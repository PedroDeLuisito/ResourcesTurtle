package com.pedrodeluisito.rturtle.block;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.item.ModItemGroup;
import com.pedrodeluisito.rturtle.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TurtleResources.Mod_ID);

    public static final RegistryObject<Block> INFUSER = registerBlock("infuser",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool()));

    public static final RegistryObject<Block> NEST= registerBlock("nest",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE).setRequiresTool().hardnessAndResistance(3f)));




    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TURTLE_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
