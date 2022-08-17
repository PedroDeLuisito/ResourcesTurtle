package com.pedrodeluisito.rturtle.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup TURTLE_GROUP = new ItemGroup("TurtleResourcesTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GOLD_TURTLE_EGG.get());
        }
    };

}
