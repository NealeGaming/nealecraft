package net.nealecraft.mod.armor;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.nealecraft.mod.Nealecraft;

public class TopazArmor extends ItemArmor {

	public TopazArmor(ArmorMaterial material, int id,
			int slot) {
		super(material, id, slot);
		this.setCreativeTab(Nealecraft.nealecraftTab);

		if(slot == 0) {
			this.setTextureName(Nealecraft.modid + ":TopazHelm");
		}else if (slot == 1) {
			this.setTextureName(Nealecraft.modid + ":TopazChest");
		}else if (slot == 2) {
			this.setTextureName(Nealecraft.modid + ":TopazLegs");
		}else if (slot == 3) {
			this.setTextureName(Nealecraft.modid + ":TopazBoots");
		}	
	}
		
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (itemstack.getItem() == Nealecraft.armorTopazHelm || itemstack.getItem() == Nealecraft.armorTopazChest || itemstack.getItem() == Nealecraft.armorTopazBoots) {  
				return Nealecraft.modid + ":textures/model/armor/topaz_layer_1.png";
		}else if (itemstack.getItem() == Nealecraft.armorTopazLegs) {  
			return Nealecraft.modid + ":textures/model/armor/topaz_layer_2.png";
		}else{
			return null;
		}
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		
		if (itemstack.getItem() == Nealecraft.armorTopazHelm) {
			itemstack.addEnchantment(Enchantment.aquaAffinity, 2);
		}else if (itemstack.getItem() == Nealecraft.armorTopazChest) {
			itemstack.addEnchantment(Enchantment.fireProtection, 4);
		}else if (itemstack.getItem() == Nealecraft.armorTopazLegs) {
			itemstack.addEnchantment(Enchantment.thorns, 5);
		}else if (itemstack.getItem() == Nealecraft.armorTopazBoots) {
			itemstack.addEnchantment(Enchantment.unbreaking, 4);
		}
	}
}
