package net.nealecraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.nealecraft.mod.Nealecraft;

public class NCItems extends Item {
	
	public NCItems() {
		this.setCreativeTab(Nealecraft.nealecraftTab);
		//this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
