package net.nealecraft.mod.items;

import net.minecraft.item.ItemFood;
import net.nealecraft.mod.Nealecraft;

public class FoodBBQRibs extends ItemFood {

	public FoodBBQRibs(int heal, float saturation, boolean wolfmeat) {
		super(heal, saturation, wolfmeat);

		this.setPotionEffect(8, 60, 1, 1F);
		this.setPotionEffect(10, 60, 1, 1F);
		this.setTextureName(Nealecraft.modid + ":BBQRibs");
		this.setCreativeTab(Nealecraft.nealecraftTab);
	}
	
}
