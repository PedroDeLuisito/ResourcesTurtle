package com.pedrodeluisito.rturtle.tileentity;

import com.pedrodeluisito.rturtle.block.custom.InfuserBlock;
import com.pedrodeluisito.rturtle.data.recipes.InfuserRecipe;
import com.pedrodeluisito.rturtle.data.recipes.ModRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Optional;

public class InfuserBlockTileEntity extends TileEntity implements ITickableTileEntity {

    public static final int WATER   = 0;
    public static final int FUEL    = 1;
    public static final int ITEM_INFUSER = 2;

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);


    protected int timer;
    private int infuserSmeltTime;
    private boolean wasSmelting = false;
    private ItemStack output = null;
    public final IIntArray fields;
    public InfuserBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        this.fields = new IIntArray() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return InfuserBlockTileEntity.this.infuserSmeltTime;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        InfuserBlockTileEntity.this.infuserSmeltTime = value;
                        break;
                }
            }

            public int size() {
                return 1;
            }
        };
    }

    public InfuserBlockTileEntity () {
        this(ModTileEntities.INFUSER_BLOCK_TILE_ENTITY.get());
    }

    protected int getSmeltTime () {
        return 1;
    }

    public boolean isSmelting() {
        return this.infuserSmeltTime > 0;
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


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 1 : return stack.getItem() == Items.BLAZE_POWDER;
                    default: return true;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                switch (slot) {
                    case 1: return 64;
                    default: return 1;
                }
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)) {
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

        return super.getCapability(cap);
    }

    @Override
    public CompoundNBT getTileData() {
        return super.getTileData();
    }

    @Override
    public void tick() {
        if(world.isRemote) {
            return;
        }


        if (!this.isSmelting()) {
            // On check si on a bien un element à infuser + une blaze rod + un sceau d'eau
            if (!this.getItem(FUEL).isEmpty()
                    && this.getItem(WATER).getItem() == Items.WATER_BUCKET
                    && this.canBeSmelt()){
                // On recupere l'item d'output
                this.output = this.resultSmelt();
                // On commence de smelt
                this.infuserSmeltTime = 100;
                // On enleve l'item a smelt et le blaze powder
                this.getItem(FUEL).shrink(1);
                this.getItem(ITEM_INFUSER).shrink(1);
//                this.getItem(WATER).shrink(1);
//                itemHandler.insertItem(WATER,Items.BUCKET.getDefaultInstance(),false);
                // Block state changement to LIT
                this.world.setBlockState(pos, world.getBlockState(pos).with(InfuserBlock.LIT,this.isSmelting()),3);
            }

            // Si le temps de smelting est fini
            if (this.wasSmelting && this.output != null) {
                this.wasSmelting = false;
                itemHandler.extractItem(WATER,1,false);
                itemHandler.insertItem(WATER,this.output,false);
                world.playSound(null, pos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS,1,1);
                this.output = null;
                // Block state changement to Non LIT
                this.world.setBlockState(pos, world.getBlockState(pos).with(InfuserBlock.LIT,false),3);
            }

        } else {
            // Le infuser est en train d'infuser
            this.infuserSmeltTime--;
            this.wasSmelting = true;
        }
    }

    private ItemStack resultSmelt() {
        Inventory inv = new Inventory(itemHandler.getSlots()) ;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }
        Optional<InfuserRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.INFUSER_RECIPE, inv, world);
        if (recipe.isPresent()) {
            return recipe.get().getRecipeOutput();
        }
        return null;
    }

    private boolean canBeSmelt() {
        Inventory inv = new Inventory(itemHandler.getSlots()) ;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }
        Optional<InfuserRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.INFUSER_RECIPE, inv, world);
        return recipe.isPresent();
    }

    private ItemStack getItem(int index) {
        return this.itemHandler.getStackInSlot(index);
    }

}
