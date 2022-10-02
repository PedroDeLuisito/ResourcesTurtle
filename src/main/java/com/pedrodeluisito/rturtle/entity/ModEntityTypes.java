//package com.pedrodeluisito.rturtle.entity;
//
//import com.pedrodeluisito.rturtle.TurtleResources;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class ModEntityTypes {
//    public static DeferredRegister<EntityType<?>>ENTITY_TYPES
//            = DeferredRegister.create(ForgeRegistries.ENTITIES, TurtleResources.Mod_ID);
//
//    //public static final RegistryObject<EntityType<GoldTurtleEntity>> GOLD_TURTLE =
////            ENTITY_TYPES.register("gold_turtle", () -> EntityType.Builder.create(GoldTurtleEntity::new,
////                    EntityClassification.CREATURE).size(1.2f, 0.36f)
////                    .build(new RessourceLocation(TurtleResources.Mod_ID, "gold_turtle").toString()));
//
//    public static void register(IEventBus eventBus){
//        ENTITY_TYPES.register(eventBus);
//
//    }
//}
