package net.nealecraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;
import net.nealecraft.mod.Nealecraft;

public class TopazSword extends ItemSword {

	public TopazSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setCreativeTab(Nealecraft.nealecraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
