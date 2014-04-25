package net.nealecraft.mod.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.renderer.ItemRenderObsidianTable;
import net.nealecraft.mod.renderer.RenderObsidianTable;
import net.nealecraft.mod.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		//ObsidianTable
		TileEntitySpecialRenderer render = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Nealecraft.blockObsidianTable), new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));
		
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
