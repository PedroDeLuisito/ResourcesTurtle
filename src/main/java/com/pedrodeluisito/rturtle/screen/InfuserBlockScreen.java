package com.pedrodeluisito.rturtle.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.pedrodeluisito.rturtle.TurtleResources;
import com.pedrodeluisito.rturtle.container.InfuserBlockContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfuserBlockScreen extends ContainerScreen<InfuserBlockContainer> {
    private final ResourceLocation GUI = new ResourceLocation(TurtleResources.Mod_ID,
            "textures/gui/infuser_gui.png");

    public InfuserBlockScreen(InfuserBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
        if(this.container.isSmelting()) {
            int progress = (int)((100-this.container.smeltingTime()) *0.28);
            this.blit(matrixStack,i+83,j+48-progress,177,28-progress,11,progress);
        }

    }
}
