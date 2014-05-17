package net.nealecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WorkSurfaceRecipeSorter implements Comparator {

	final WorkSurfaceCraftingManager workSurface;
	
	public WorkSurfaceRecipeSorter(WorkSurfaceCraftingManager workSurfaceCraftingManager) {
		this.workSurface = workSurfaceCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof WorkSurfaceShapelessRecipes && irecipe2 instanceof WorkSurfaceShapedRecipes ? 1: (irecipe2 instanceof WorkSurfaceShapelessRecipes && irecipe1 instanceof WorkSurfaceShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
