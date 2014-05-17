package net.nealecraft.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.nealecraft.mod.Nealecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorkSurface extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon workSurfaceTop;
	
	public WorkSurface() {
		super(Material.wood);
		
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(Nealecraft.nealecraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.workSurfaceTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + "WorkSurfaceSide");
		this.workSurfaceTop = iconRegister.registerIcon(Nealecraft.modid + ":" + "WorkSurfaceTop");
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		if (!player.isSneaking()) {
			player.openGui(Nealecraft.instance, Nealecraft.guiIDWorkSurface, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}
	

}
