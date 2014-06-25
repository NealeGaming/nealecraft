package net.nealecraft.mod.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.container.ContainerIngotMasher;
import net.nealecraft.mod.tileentity.TileEntityIngotMasher;

public class GuiIngotMasher extends GuiContainer {
	
	public ResourceLocation texture = new ResourceLocation(Nealecraft.modid + ":" + "/textures/gui/IngotMasherGui.png");
	public TileEntityIngotMasher ingotMasher;

	public GuiIngotMasher(InventoryPlayer invPlayer, TileEntityIngotMasher teIngotMasher) {
		super(new ContainerIngotMasher(invPlayer, teIngotMasher));
		ingotMasher = teIngotMasher;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.ingotMasher.hasCustomInventoryName() ? this.ingotMasher.getInventoryName() : I18n.format(this.ingotMasher.getInventoryName());
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
	}

	@Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (ingotMasher.hasPower())
        {
            int i1 = ingotMasher.getPowerRemainingScaled(45);
            drawTexturedModalRect(guiLeft + 8, guiTop + 53 - i1, 176, 62 - i1, 16, i1);
        }

        int i1 = ingotMasher.getMasherProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, i1 + 1, 16);
    }

}
