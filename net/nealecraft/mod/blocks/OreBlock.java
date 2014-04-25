package net.nealecraft.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.nealecraft.mod.Nealecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreBlock extends Block {

	public OreBlock(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(200.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(Nealecraft.nealecraftTab);
		
	}
	
	public Item getItemDropped(int i, Random random, int j) {
		return this == Nealecraft.oreTopazOre ? Nealecraft.itemTopaz : Item.getItemFromBlock(this);
	}
	
	public int quantityDropped(Random random) {
		return this == Nealecraft.oreTopazOre ? 4 + random.nextInt(5) : 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	

}
