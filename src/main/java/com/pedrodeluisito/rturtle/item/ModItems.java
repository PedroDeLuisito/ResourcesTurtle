package com.pedrodeluisito.rturtle.item;

import com.pedrodeluisito.rturtle.TurtleResources;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TurtleResources.Mod_ID);


    //Gold Turtle Egg
    public static final RegistryObject<Item> GOLD_TURTLE_EGG = ITEMS.register("gold_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));

    //Redstone Turtle Egg
    public static final RegistryObject<Item> REDSTONE_TURTLE_EGG = ITEMS.register("redstone_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));

    // ARMOR
    public static final RegistryObject<Item> TURTLE_BOOTS = ITEMS.register("turtle_boots",
            ()-> new ArmorItem(ModArmorMaterial.TURTLE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> TURTLE_CHESTPLATE = ITEMS.register("turtle_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.TURTLE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> TURTLE_LEGGINGS = ITEMS.register("turtle_leggings",
            ()-> new ArmorItem(ModArmorMaterial.TURTLE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));

    // Custom Fluid
    public static final RegistryObject<Item> STONE_INFUSED_WATER = ITEMS.register("stone_infused_water",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> WOOD_INFUSED_WATER = ITEMS.register("wood_infused_water",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> DYE_INFUSED_WATER = ITEMS.register("dye_infused_water",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
