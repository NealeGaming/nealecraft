package net.nealecraft.mod.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nealecraft.mod.Nealecraft;

public class IngotMasherRecipes {

	public IngotMasherRecipes() {
		
	}
	
	public static ItemStack getMashingResult(Item item, Item item2) {
		return getOutput(item, item2);
	}
	
	public static ItemStack getOutput(Item item, Item item2) {
		//Recipe One
		if (item == Nealecraft.itemManganeseIngot && item2 == Items.iron_ingot || item == Items.iron_ingot && item2 == Nealecraft.itemManganeseIngot) {
			return new ItemStack(Nealecraft.itemVanadiumIngot, 2);
		}
		
		return null;
	}
	
}
