package com.pedrodeluisito.rturtle.fluid;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.block.ModBlocks;
import com.pedrodeluisito.rturtle.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, TurtleResources.Mod_ID);

    // STONE INFUSED WATER
    public static final RegistryObject<FlowingFluid> STONE_INFUSED_WATER_FLUID
            = FLUIDS.register("stone_infused_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.STONE_INFUSER_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> STONE_INFUSED_WATER_FLOWING
            = FLUIDS.register("stone_infused_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.STONE_INFUSER_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties STONE_INFUSER_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> STONE_INFUSED_WATER_FLUID.get(), () -> STONE_INFUSED_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5)
            .overlay(WATER_OVERLAY_RL)
            .color(0xbf727272)).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.STONE_INFUSED_WATER_BLOCK.get())
            .bucket(() -> ModItems.STONE_INFUSED_WATER_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> STONE_INFUSED_WATER_BLOCK = ModBlocks.BLOCKS.register("stone_infused_water_block",
            () -> new FlowingFluidBlock(() -> ModFluids.STONE_INFUSED_WATER_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));




    // WOOD INFUSED WATER
    public static final RegistryObject<FlowingFluid> WOOD_INFUSED_WATER_FLUID
            = FLUIDS.register("wood_infused_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.WOOD_INFUSER_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> WOOD_INFUSED_WATER_FLOWING
            = FLUIDS.register("wood_infused_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.WOOD_INFUSER_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties WOOD_INFUSER_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> WOOD_INFUSED_WATER_FLUID.get(), () -> WOOD_INFUSED_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5)
            .overlay(WATER_OVERLAY_RL)
            .color(0xbf3d341a)).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.WOOD_INFUSED_WATER_BLOCK.get())
            .bucket(() -> ModItems.WOOD_INFUSED_WATER_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> WOOD_INFUSED_WATER_BLOCK = ModBlocks.BLOCKS.register("wood_infused_water_block",
            () -> new FlowingFluidBlock(() -> ModFluids.WOOD_INFUSED_WATER_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));




    // DYE INFUSED WATER

    public static final RegistryObject<FlowingFluid> DYE_INFUSED_WATER_FLUID
            = FLUIDS.register("dye_infused_water_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.DYE_INFUSER_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DYE_INFUSED_WATER_FLOWING
            = FLUIDS.register("dye_infused_water_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DYE_INFUSER_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties DYE_INFUSER_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> DYE_INFUSED_WATER_FLUID.get(), () -> DYE_INFUSED_WATER_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5)
            .overlay(WATER_OVERLAY_RL)
            .color(0xbfb200ff)).slopeFindDistance(4).levelDecreasePerBlock(2)
            .block(() -> ModFluids.DYE_INFUSED_WATER_BLOCK.get())
            .bucket(() -> ModItems.DYE_INFUSED_WATER_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> DYE_INFUSED_WATER_BLOCK = ModBlocks.BLOCKS.register("dye_infused_water_block",
            () -> new FlowingFluidBlock(() -> ModFluids.DYE_INFUSED_WATER_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
