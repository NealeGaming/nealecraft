package net.nealecraft.mod.handler;

import net.minecraft.item.ItemStack;
import net.nealecraft.mod.Nealecraft;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == Nealecraft.itemTreePitch) return 800;
		
		return 0;
	}

}
