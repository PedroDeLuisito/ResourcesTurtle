package com.pedrodeluisito.rturtle.block.custom;

import com.pedrodeluisito.rturtle.container.InfuserBlockContainer;
import com.pedrodeluisito.rturtle.tileentity.InfuserBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class InfuserBlock extends HorizontalBlock {

    public static final BooleanProperty LIT;

    public InfuserBlock(Properties properties) {
        super(properties);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState())).with(LIT, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new InfuserBlockTileEntity();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
        builder.add(LIT);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        // Spawn Bubbles particules
        if (0.3f < rand.nextFloat() && worldIn.getBlockState(pos).get(LIT)) {
            worldIn.addParticle(ParticleTypes.BUBBLE,
                    pos.getX()+rand.nextDouble()*0.7+0.15,
                    pos.getY()+1,
                    pos.getZ()+rand.nextDouble()*0.7+0.15,
                    0d,0.05d,0d);
            worldIn.addParticle(ParticleTypes.BUBBLE_POP,
                    pos.getX()+rand.nextDouble()*0.7+0.15,
                    pos.getY()+1.1,
                    pos.getZ()+rand.nextDouble()*0.7+0.15,
                    0d,0.05d,0d);
        }

        // Spawn Flame
        if (0.3f < rand.nextFloat() && worldIn.getBlockState(pos).get(LIT)) {
            if (worldIn.getBlockState(pos).get(HORIZONTAL_FACING) == Direction.NORTH)
                worldIn.addParticle(ParticleTypes.FLAME,
                    pos.getX()+rand.nextDouble()*0.6+0.2,
                    pos.getY()+rand.nextDouble()*0.25+0.1,
                    pos.getZ()-0.05,
                    0d,0.001d,0d);
            if (worldIn.getBlockState(pos).get(HORIZONTAL_FACING) == Direction.EAST)
                worldIn.addParticle(ParticleTypes.FLAME,
                        pos.getX()+1.05,
                        pos.getY()+rand.nextDouble()*0.25+0.1,
                        pos.getZ()+rand.nextDouble()*0.6+0.2,
                        0d,0.001d,0d);
            if (worldIn.getBlockState(pos).get(HORIZONTAL_FACING) == Direction.WEST)
                worldIn.addParticle(ParticleTypes.FLAME,
                        pos.getX()-0.05,
                        pos.getY()+rand.nextDouble()*0.25+0.1,
                        pos.getZ()+rand.nextDouble()*0.6+0.2,
                        0d,0.001d,0d);
            if (worldIn.getBlockState(pos).get(HORIZONTAL_FACING) == Direction.SOUTH)
                worldIn.addParticle(ParticleTypes.FLAME,
                        pos.getX()+rand.nextDouble()*0.6+0.2,
                        pos.getY()+rand.nextDouble()*0.25+0.1,
                        pos.getZ()+1.05,
                        0d,0.001d,0d);
        }

        super.animateTick(stateIn, worldIn, pos, rand);
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
        if (!state.matchesBlock(newState.getBlock())) {
            TileEntity t = worldIn.getTileEntity(pos);
            if (t instanceof InfuserBlockTileEntity) {
                worldIn.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(
                    stack -> {
                        for (int i = 0; i < stack.getSlots(); i++) {
                            spawnAsEntity(worldIn, pos, stack.getStackInSlot(i));
                        }
                    }
                );
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
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

    static {
        LIT = BlockStateProperties.LIT;
    }

}
