package com.pedrodeluisito.rturtle.tileentity;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntity {
    public static DeferredRegister<TileEntityType<?>>TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TurtleResources.Mod_ID);

    //public static RegistryObject<TileEntityType<NestTile>> NestTile =
           // TILE_ENTITIES.register("nest_tile", () -> TileEntityType.Builder.create(
                  //  NestTile::new, ModBlocks.NEST_TILE.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }

}
