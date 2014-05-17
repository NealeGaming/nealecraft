package net.nealecraft.mod.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.tileentity.TileEntityAlabasterOven;
import net.nealecraft.mod.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ObsidianBlock extends BlockContainer {

	public ObsidianBlock(Material material) {
		super(material);
		
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
		this.setCreativeTab(Nealecraft.nealecraftTab);
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityObsidianTable();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
		
		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(itemstack.hasDisplayName()) {
			((TileEntityAlabasterOven)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x,  y,  z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4  = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if(b1.func_149730_j() && !b2.func_149730_j()) {
				b0 = 3;	
			}
			
			if(b2.func_149730_j() && !b1.func_149730_j()) {
				b0 = 2;	
			}
			
			if(b3.func_149730_j() && !b4.func_149730_j()) {
				b0 = 5;	
			}
			
			if(b4.func_149730_j() && !b3.func_149730_j()) {
				b0 = 4;	
			}
			
			world.setBlockMetadataWithNotify(x, y, x, b0, 2);
		}
		
	}

}
