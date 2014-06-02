package net.nealecraft.mod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.container.ContainerIngotMasher;
import net.nealecraft.mod.tileentity.TileEntityIngotMasher;

public class GuiIngotMasher extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation(Nealecraft.modid + ":" + "/textures/gui/IngotMasherGui.png");
	private TileEntityIngotMasher ingotMasher;

	public GuiIngotMasher(InventoryPlayer invPlayer, TileEntityIngotMasher teIngotMasher) {
		super(new ContainerIngotMasher(invPlayer, teIngotMasher));
		ingotMasher = teIngotMasher;
		
		this.xSize = 176;
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.ingotMasher.hasCustomInventoryName() ? this.ingotMasher.getInventoryName() : I18n.format(this.ingotMasher.getInventoryName());
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		// TODO Auto-generated method stub
		
	}

}
