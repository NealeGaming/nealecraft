package net.nealecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMineralBlocks extends ItemBlock {
	
	final static String[] subBlocks = new String[] {"limestone", "shale", "granite", "andesite"};

	public ItemMineralBlocks(Block dogshit) {
		super(dogshit);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= subBlocks.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + subBlocks[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}
