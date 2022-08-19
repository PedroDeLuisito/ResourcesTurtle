package com.pedrodeluisito.rturtle.tileentity;

import com.pedrodeluisito.rturtle.container.InfuserContainer;
import com.pedrodeluisito.rturtle.data.recipes.InfuserRecipe;
import com.pedrodeluisito.rturtle.data.recipes.ModRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Optional;

public class InfuserTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private InfuserContainer container;
    private int currentSmeltTime = 0;

    public InfuserTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public InfuserTile() {
        this(ModTileEntities.INFUSER_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    public void setContainer(InfuserContainer iContainer) {
        this.container = iContainer;
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 1: return stack.getItem() == Items.BLAZE_POWDER;
                    default:
                        return true;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                if (slot == 1) return 64;
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        // Here hoppers behaviour
        return super.getCapability(cap);
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<InfuserRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.INFUSER_RECIPE, inv, world);


        recipe.ifPresent(iRecipe ->  {
            ItemStack output = iRecipe.getRecipeOutput();
            craftTheItem(output);
            markDirty();
        });
    }

    private void craftTheItem(ItemStack output) {
        this.timeBeforeCraft();
        if (this.container != null) {
            this.container.setInfusing(true);
            System.out.println(currentSmeltTime);
            if (currentSmeltTime != 100) {
                currentSmeltTime++;
                return;
            }
            currentSmeltTime = 0;
            this.container.setInfusing(false);
        } else {
            System.out.println("NULLLLLLLLLLLLLL");
        }
        itemHandler.extractItem(0,1,false);
        itemHandler.extractItem(1,1,false);
        itemHandler.extractItem(2,1,false);
        itemHandler.insertItem(0, output, false);
    }

    public void timeBeforeCraft() {

    }


    @Override
    public void tick() {
        if (world.isRemote) {
            return;
        }
        this.craft();
    }
}
