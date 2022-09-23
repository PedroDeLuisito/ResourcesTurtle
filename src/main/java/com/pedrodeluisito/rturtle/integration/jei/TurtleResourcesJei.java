package com.pedrodeluisito.rturtle.integration.jei;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.data.recipes.InfuserRecipe;
import com.pedrodeluisito.rturtle.data.recipes.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class TurtleResourcesJei implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TurtleResources.Mod_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new InfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().world).getRecipeManager();
        registration.addRecipes(rm.getRecipesForType(ModRecipeTypes.INFUSER_RECIPE).stream()
                        .filter(r -> r instanceof InfuserRecipe).collect(Collectors.toList()),
                InfuserRecipeCategory.UID);
    }


}
