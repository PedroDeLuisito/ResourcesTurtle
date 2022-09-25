package com.pedrodeluisito.rturtle.block.custom;

import com.pedrodeluisito.rturtle.container.InfuserBlockContainer;
import com.pedrodeluisito.rturtle.tileentity.InfuserBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;

public class InfuserBlock extends Block {
    public InfuserBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        //return ModTileEntities.INFUSER_BLOCK_TILE_ENTITY.get().create();
        return new InfuserBlockTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof InfuserBlockTileEntity) {
                INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos, ((InfuserBlockTileEntity) tileEntity).fields);

                NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        worldIn.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
            worldIn.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(
                    stack -> {
                        for (int i = 0; i < stack.getSlots(); i++) {
                            spawnAsEntity(worldIn, pos, stack.getStackInSlot(i));
                        }
                    }
            );
        });
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos, IIntArray fields) {
        return new INamedContainerProvider() {
            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new InfuserBlockContainer(i, worldIn, pos, playerInventory, playerEntity, fields);
            }

            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.rturtle.infuser");
            }
        };

    }

}
