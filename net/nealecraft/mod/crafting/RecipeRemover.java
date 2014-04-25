package net.nealecraft.mod.crafting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jcraft.jorbis.Block;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {

	
	public static void removeCraftingRecipe() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
			while(remover.hasNext()) {
				ItemStack itemstack = remover.next().getRecipeOutput();
				if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.furnace)){
					remover.remove();
				} else if (itemstack != null && itemstack.getItem() == Items.book) {
					remover.remove();
				} else if (itemstack != null && itemstack.getItem() == Items.stick) {
					remover.remove();
				}
							
		}
	}
	
	public static void removeFurnaceRecipe() {
		Map recipes = FurnaceRecipes.smelting().getSmeltingList();
		
		Iterator entries = recipes.entrySet().iterator();
		while (entries.hasNext()) {
			
			Entry thisEntry = (Entry) entries.next();
		  if (thisEntry != null && thisEntry.getKey() == Blocks.iron_ore) {
				entries.remove();
			}
		}
	}
}
