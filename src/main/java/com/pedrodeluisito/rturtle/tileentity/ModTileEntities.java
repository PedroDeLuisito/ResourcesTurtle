package com.pedrodeluisito.rturtle.tileentity;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TurtleResources.Mod_ID);

    public static RegistryObject<TileEntityType<InfuserBlockTileEntity>> INFUSER_BLOCK_TILE_ENTITY =
            TILE_ENTITIES.register("infuser_block_tile_entity", () -> TileEntityType.Builder.create(
                    InfuserBlockTileEntity::new, ModBlocks.INFUSER.get()).build(null));

    public static void register(IEventBus eventbus) {
        TILE_ENTITIES.register(eventbus);
    }

}
