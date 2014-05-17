package net.nealecraft.mod.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.entity.EntityCyclops;
import net.nealecraft.mod.model.ModelCyclops;
import net.nealecraft.mod.renderer.ItemRenderObsidianTable;
import net.nealecraft.mod.renderer.RenderCyclops;
import net.nealecraft.mod.renderer.RenderObsidianTable;
import net.nealecraft.mod.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		//ObsidianTable
		TileEntitySpecialRenderer render = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Nealecraft.blockObsidianTable), new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelCyclops(), 0.3F));
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
