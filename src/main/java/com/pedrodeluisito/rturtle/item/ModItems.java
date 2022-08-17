package com.pedrodeluisito.rturtle.item;

import com.pedrodeluisito.rturtle.TurtleResources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TurtleResources.Mod_ID);

<<<<<<< HEAD
    public static final RegistryObject<Item> GOLD_TURTLE_EGG = ITEMS.register("gold_turtle_egg",
=======
    public static final RegistryObject<Item> GOLDTURTLEEGG = ITEMS.register("gold_turtleegg",
>>>>>>> a5caeca8473b14e1c2d4316053842a72b746cb4d
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
