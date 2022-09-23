package com.pedrodeluisito.rturtle.integration.jei;

import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.block.ModBlocks;
import com.pedrodeluisito.rturtle.data.recipes.InfuserRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class InfuserRecipeCategory implements IRecipeCategory<InfuserRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TurtleResources.Mod_ID);
    public final static ResourceLocation TEXTURE = new ResourceLocation(TurtleResources.Mod_ID, "textures/gui/infuser_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
//    private final IDrawableStatic bubles;

    public InfuserRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.INFUSER.get()));
//        this.bubles = helper.createDrawable(TEXTURE,176,0,13,17);
    }


    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends InfuserRecipe> getRecipeClass() {
        return InfuserRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.INFUSER.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(InfuserRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, InfuserRecipe recipe, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0,true,60,30);
        recipeLayout.getItemStacks().init(1,true,79,52);
        recipeLayout.getItemStacks().init(2,true,98,30);
        recipeLayout.getItemStacks().init(3,false,42,30);
        recipeLayout.getItemStacks().set(ingredients);
    }
}
