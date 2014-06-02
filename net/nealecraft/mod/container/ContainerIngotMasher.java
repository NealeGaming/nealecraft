package net.nealecraft.mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.nealecraft.mod.slot.SlotIngotMasher;
import net.nealecraft.mod.tileentity.TileEntityIngotMasher;

public class ContainerIngotMasher extends Container {

	private TileEntityIngotMasher masher;
	private int dualCookTime;
	private int dualPower;
	private int lastItemBurnTime;
	
	public ContainerIngotMasher(InventoryPlayer invPlayer, TileEntityIngotMasher teIngotMasher) {
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		
		masher = teIngotMasher;
		
		this.addSlotToContainer(new Slot(teIngotMasher, 0, 41, 13));
		this.addSlotToContainer(new Slot(teIngotMasher, 1, 41, 52));
		this.addSlotToContainer(new Slot(teIngotMasher, 2, 8, 56));
		this.addSlotToContainer(new SlotIngotMasher(invPlayer.player, teIngotMasher, 3, 113, 33));
		
		
		//Inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		
		//ActionBar
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}

}
