package com.pedrodeluisito.rturtle.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup TURTLE_GROUP = new ItemGroup("TurtleResourcesTab") {
        @Override
        public ItemStack createIcon() {
<<<<<<< HEAD
            return new ItemStack(ModItems.GOLD_TURTLE_EGG.get());
=======
            return new ItemStack(ModItems.GOLDTURTLEEGG.get());
>>>>>>> a5caeca8473b14e1c2d4316053842a72b746cb4d
        }
    };

}
