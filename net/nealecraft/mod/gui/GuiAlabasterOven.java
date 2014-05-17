package net.nealecraft.mod.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.tileentity.TileEntityAlabasterOven;
import net.nealecraft.mod.container.ContainerAlabasterOven;

public class GuiAlabasterOven extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation(Nealecraft.modid + ":" + "textures/gui/GuiAlabasterOven.png");
	
	public TileEntityAlabasterOven alabasterOven;

	public GuiAlabasterOven(InventoryPlayer inventoryPlayer, TileEntityAlabasterOven entity) {
		super(new ContainerAlabasterOven(inventoryPlayer, entity));
		
		this.alabasterOven = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name = this.alabasterOven.hasCustomInventoryName() ? this.alabasterOven.getInventoryName() : I18n.format(this.alabasterOven.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	
		if(this.alabasterOven.isBurning()) {
			int k = this.alabasterOven.getBurnTimeRemainingScaled(40);
			int j = 40 - k;
			drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
		}
		
		int k = this.alabasterOven.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
	}

}
