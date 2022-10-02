package com.pedrodeluisito.rturtle.item;

import com.pedrodeluisito.rturtle.TurtleResources;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BucketItem;
import net.minecraft.potion.EffectInstance;
import com.pedrodeluisito.rturtle.fluid.ModFluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TurtleResources.Mod_ID);



    //TIER 1 EGG
    //Coal Turtle Egg
    public static final RegistryObject<Item> COAL_TURTLE_EGG = ITEMS.register("coal_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Gravel Turtle Egg
    public static final RegistryObject<Item> GRAVEL_TURTLE_EGG = ITEMS.register("gravel_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Rainbow Turtle Egg
    public static final RegistryObject<Item> RAINBOW_TURTLE_EGG = ITEMS.register("rainbow_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Rocky Turtle Egg
    public static final RegistryObject<Item> ROCKY_TURTLE_EGG = ITEMS.register("rocky_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                    .hunger(2)
                    .saturation(0.2f).setAlwaysEdible().build())));
    //Woody Turtle Egg
    public static final RegistryObject<Item> WOODY_TURTLE_EGG = ITEMS.register("woody_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                        .hunger(2)
                        .saturation(0.2f).setAlwaysEdible().build())));
    //Zombie Turtle Egg
    public static final RegistryObject<Item> ZOMBIE_TURTLE_EGG = ITEMS.register("zombie_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .effect(() -> new EffectInstance(Effects.HUNGER, 250),0.5f)
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));

    //TIER 2 EGG
    //Icy Turtle Egg
    public static final RegistryObject<Item> ICY_TURTLE_EGG = ITEMS.register("icy_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Skeleton Turtle Egg
    public static final RegistryObject<Item> SKELETON_TURTLE_EGG = ITEMS.register("skeleton_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Iron Turtle Egg
    public static final RegistryObject<Item> IRON_TURTLE_EGG = ITEMS.register("iron_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //lapis Turtle Egg
    public static final RegistryObject<Item> LAPIS_TURTLE_EGG = ITEMS.register("lapis_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Gold Turtle Egg
    public static final RegistryObject<Item> GOLD_TURTLE_EGG = ITEMS.register("gold_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //slime Turtle Egg
    public static final RegistryObject<Item> SLIME_TURTLE_EGG = ITEMS.register("slime_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Pigman Turtle Egg
    public static final RegistryObject<Item> PIGMAN_TURTLE_EGG = ITEMS.register("pigman_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .effect(() -> new EffectInstance(Effects.GLOWING, 250),0.5f)
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));

    //TIER 3 EGG
    //Creeper Turtle Egg
    public static final RegistryObject<Item> CREEPER_TURTLE_EGG = ITEMS.register("creeper_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Quartz Turtle Egg
    public static final RegistryObject<Item> QUARTZ_TURTLE_EGG = ITEMS.register("quartz_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Redstone Turtle Egg
    public static final RegistryObject<Item> REDSTONE_TURTLE_EGG = ITEMS.register("redstone_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Diamond Turtle Egg
    public static final RegistryObject<Item> DIAMOND_TURTLE_EGG = ITEMS.register("diamond_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Emerald Turtle Egg
    public static final RegistryObject<Item> EMERALD_TURTLE_EGG = ITEMS.register("emerald_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Netherite Turtle Egg
    public static final RegistryObject<Item> NETHERITE_TURTLE_EGG = ITEMS.register("netherite_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Enderman Turtle Egg
    public static final RegistryObject<Item> ENDERMAN_TURTLE_EGG = ITEMS.register("enderman_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));

    //TIER 4 EGG
    //Dragon Turtle Egg
    public static final RegistryObject<Item> DRAGON_TURTLE_EGG = ITEMS.register("dragon_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Netherstar Turtle Egg
    public static final RegistryObject<Item> NETHERSTAR_TURTLE_EGG = ITEMS.register("netherstar_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));
    //Wither Turtle Egg
    public static final RegistryObject<Item> WITHER_TURTLE_EGG = ITEMS.register("wither_turtle_egg",
            ()-> new Item (new Item.Properties().group(ModItemGroup.TURTLE_GROUP)
                    .food(new Food.Builder()
                            .effect(() -> new EffectInstance(Effects.WITHER, 100),1.0f)
                            .hunger(2)
                            .saturation(0.2f).setAlwaysEdible().build())));




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
    public static final RegistryObject<Item> STONE_INFUSED_WATER_BUCKET = ITEMS.register("stone_infused_water_bucket",
            ()-> new BucketItem( () -> ModFluids.STONE_INFUSED_WATER_FLUID.get(), new Item.Properties().maxStackSize(1).group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> WOOD_INFUSED_WATER_BUCKET = ITEMS.register("wood_infused_water_bucket",
            ()-> new BucketItem( () -> ModFluids.WOOD_INFUSED_WATER_FLUID.get(), new Item.Properties().maxStackSize(1).group(ModItemGroup.TURTLE_GROUP)));
    public static final RegistryObject<Item> DYE_INFUSED_WATER_BUCKET = ITEMS.register("dye_infused_water_bucket",
            ()-> new BucketItem( () -> ModFluids.DYE_INFUSED_WATER_FLUID.get(), new Item.Properties().maxStackSize(1).group(ModItemGroup.TURTLE_GROUP)));

    public static final RegistryObject<Item> GOLD_INFUSED_WATER_BUCKET = ITEMS.register("gold_infused_water_bucket",
            ()-> new BucketItem( () -> ModFluids.GOLD_INFUSED_WATER_FLUID.get(), new Item.Properties().maxStackSize(1).group(ModItemGroup.TURTLE_GROUP)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
