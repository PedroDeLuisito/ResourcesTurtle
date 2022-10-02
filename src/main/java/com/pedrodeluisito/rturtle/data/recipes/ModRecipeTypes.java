package com.pedrodeluisito.rturtle.data.recipes;

import com.pedrodeluisito.rturtle.TurtleResources;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TurtleResources.Mod_ID);

    public static final RegistryObject<InfuserRecipe.Serializer> INFUSER_SERIALIZER
            = RECIPE_SERIALIZER.register("infuser", InfuserRecipe.Serializer::new);

    public static IRecipeType<InfuserRecipe> INFUSER_RECIPE
            = new InfuserRecipe.InfuserRecipeType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, InfuserRecipe.TYPE_ID, INFUSER_RECIPE);
    }
}
