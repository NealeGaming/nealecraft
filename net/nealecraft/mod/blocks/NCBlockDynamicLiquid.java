package net.nealecraft.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.nealecraft.mod.Nealecraft;

public class NCBlockDynamicLiquid extends BlockDynamicLiquid {

	public NCBlockDynamicLiquid(Material material) {
		super(material);
		
		this.setCreativeTab(Nealecraft.nealecraftTab);
	}

}
