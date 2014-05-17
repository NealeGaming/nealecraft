package net.nealecraft.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AlabasterOven extends BlockContainer {
	
	private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	private static boolean keepInventory;
	private Random rand = new Random();

	public AlabasterOven(boolean isActive) {
		super(Material.iron);
		
		this.isActive = isActive;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Nealecraft.modid + ":" + "AlabasterOvenSide");
		this.iconFront = iconRegister.registerIcon(Nealecraft.modid + ":" + (this.isActive ? "AlabasterOvenFrontOn" : "AlabasterOvenFrontOff"));
		this.iconTop = iconRegister.registerIcon(Nealecraft.modid + ":" + "AlabasterOvenTop");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
		//return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}
	
	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(Nealecraft.blockAlabasterOvenIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
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
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, Nealecraft.instance, Nealecraft.guiIDAlabasterOven, world, x, y, z);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityAlabasterOven();
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if(this.isActive) {
			int direction = world.getBlockMetadata(x, y, z);
			
			float x1 = (float)x + 0.5F;
			float y1 = (float)y + random.nextFloat();
			float z1 = (float)z + 0.5F;
			
			float f = 0.52F;
			float f1 = random.nextFloat() * 0.6F - 0.3F;
			
			if(direction == 4){
				world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}
			
			if(direction == 5){
				world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}
			
			if(direction == 2){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
			}
			
			if(direction == 3){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
			}
		}
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

	public static void updateAlabasterOvenBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if(active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, Nealecraft.blockAlabasterOvenActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, Nealecraft.blockAlabasterOvenIdle);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if(tileentity != null) {
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		if(!keepInventory) {
			TileEntityAlabasterOven tileentity = (TileEntityAlabasterOven) world.getTileEntity(x, y, z);
			
			if(tileentity != null) {
				for(int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);
					
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							
							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				
				world.func_147453_f(x, y, z, oldblock);
			}
		}
		
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}
	
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(Nealecraft.blockAlabasterOvenIdle);
	}

}
