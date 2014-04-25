package net.nealecraft.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.nealecraft.mod.blocks.*;
import net.nealecraft.mod.handler.*;
import net.nealecraft.mod.items.*;
import net.nealecraft.mod.proxy.CommonProxy;
import net.nealecraft.mod.tileentity.TileEntityAlabasterOven;
import net.nealecraft.mod.worldgen.NealecraftWorldGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Nealecraft.modid, version = Nealecraft.version)
public class Nealecraft {
	
	public static final String modid = "Nealecraft";
	public static final String version = "Alpha v0.1";
	
	NealecraftWorldGen eventWorldGen = new NealecraftWorldGen();
		
	public static CreativeTabs nealecraftTab;
	
	public static ToolMaterial TopazMaterial = EnumHelper.addToolMaterial("TopazMaterial", 2, 750, 6.0F, 2.0F, 10);
	
	@Instance(modid)
	public static Nealecraft instance;
	
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemZincIngot;
	public static Item itemNickelIngot;
	public static Item itemManganeseIngot;
	public static Item itemVanadiumIngot;
	
	public static Item itemTinCog;
	public static Item itemIronWasher;
	public static Item itemIronDisc;
	public static Item itemIronHammer;
	public static Item itemIronPunch;
	
	public static Item itemTreePitch;
	
	public static Item itemStaff;
	
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreZincOre;
	public static Block oreNickelOre;
	public static Block oreManganeseOre;
	public static Block oreVanadiumOre;
	public static Block oreTopazOre;
	
	public static Block blockCopperBlock;
	
	public static Block blockObsidianTable;
	
	public static Item itemTopaz;

	public static Item itemTopazSword;
	public static Item itemTopazAxe;
	public static Item itemTopazShovel;
	public static Item itemTopazHoe;
	public static Item itemTopazPickaxe;
	
	//Machines
	public static Block blockAlabasterOvenIdle;
	public static Block blockAlabasterOvenActive;
	public static final int guiIDAlabasterOven = 0;
	
	@SidedProxy(clientSide = "net.nealecraft.mod.proxy.ClientProxy", serverSide = "net.nealecraft.mod.proxy.CommonProxy")
	public static CommonProxy nealeProxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		
		nealecraftTab = new CreativeTabs("Nealecraft") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Nealecraft.oreCopperOre);
			}
		};
		
		//Initializations
		
		//Items
		itemCopperIngot = new NCItems().setUnlocalizedName("CopperIngot");
		itemTinIngot = new NCItems().setUnlocalizedName("TinIngot");
		itemZincIngot = new NCItems().setUnlocalizedName("ZincIngot");
		itemNickelIngot = new NCItems().setUnlocalizedName("NickelIngot");
		itemManganeseIngot = new NCItems().setUnlocalizedName("ManganeseIngot");
		itemVanadiumIngot = new NCItems().setUnlocalizedName("VanadiumIngot");
		
		itemTinCog = new NCItems().setUnlocalizedName("TinCog");
		itemIronWasher = new NCItems().setUnlocalizedName("IronWasher");
		itemIronDisc = new NCItems().setUnlocalizedName("IronDisc");
		itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
		itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");
		
		itemTreePitch = new NCItems().setUnlocalizedName("TreePitch");
		
		itemStaff = new NCItems().setUnlocalizedName("Staff");
		
		itemTopaz = new NCItems().setUnlocalizedName("Topaz");
		
		itemTopazSword = new TopazSword(TopazMaterial).setUnlocalizedName("TopazSword");
		itemTopazAxe = new TopazAxe(TopazMaterial).setUnlocalizedName("TopazAxe");
		itemTopazShovel = new TopazShovel(TopazMaterial).setUnlocalizedName("TopazShovel");
		itemTopazHoe = new TopazHoe(TopazMaterial).setUnlocalizedName("TopazHoe");
		itemTopazPickaxe = new TopazPickaxe(TopazMaterial).setUnlocalizedName("TopazPickaxe");
		
		//Ores
		oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
		oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
		oreZincOre = new OreBlock(Material.rock).setBlockName("ZincOre");
		oreNickelOre = new OreBlock(Material.rock).setBlockName("NickelOre");
		oreManganeseOre = new OreBlock(Material.rock).setBlockName("ManganeseOre");
		oreVanadiumOre = new OreBlock(Material.rock).setBlockName("VanadiumOre");
		oreTopazOre = new OreBlock(Material.rock).setBlockName("TopazOre");
		
		//Blocks
		blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
		
		blockObsidianTable = new ObsidianBlock(Material.rock).setBlockName("ObsidianTable");
		
		//Machines
		blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(nealecraftTab).setHardness(3.5F);
		blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F).setHardness(3.5F);
		
		

		//Registers
		//Items		
		GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
		GameRegistry.registerItem(itemTinIngot, "TinIngot");
		GameRegistry.registerItem(itemZincIngot, "ZincIngot");
		GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
		GameRegistry.registerItem(itemManganeseIngot, "ManganeseIngot");
		GameRegistry.registerItem(itemVanadiumIngot, "VanadiumIngot");
		
		GameRegistry.registerItem(itemTinCog, "TinCog");
		GameRegistry.registerItem(itemIronWasher, "IronWasher");
		GameRegistry.registerItem(itemIronDisc, "IronDisc");
		GameRegistry.registerItem(itemIronHammer, "IronHammer");
		GameRegistry.registerItem(itemIronPunch, "IronPunch");		
		
		GameRegistry.registerItem(itemTreePitch, "TreePitch");
		
		GameRegistry.registerItem(itemStaff, "Staff");
		
		GameRegistry.registerItem(itemTopaz, "Topaz");
		
		GameRegistry.registerItem(itemTopazAxe, "TopazAxe");
		GameRegistry.registerItem(itemTopazSword, "TopazSword");
		GameRegistry.registerItem(itemTopazShovel, "TopazShovel");
		GameRegistry.registerItem(itemTopazHoe, "TopazHoe");
		GameRegistry.registerItem(itemTopazPickaxe, "TopazPickaxe");
		
		//Ores
		GameRegistry.registerBlock(oreCopperOre, "CopperOre");
		GameRegistry.registerBlock(oreTinOre, "TinOre");
		GameRegistry.registerBlock(oreZincOre, "ZincOre");
		GameRegistry.registerBlock(oreNickelOre, "NickelOre");
		GameRegistry.registerBlock(oreManganeseOre, "ManganeseOre");
		GameRegistry.registerBlock(oreVanadiumOre, "VanadiumOre");
		GameRegistry.registerBlock(oreTopazOre, "TopazOre");
		
		//Blocks
		GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
		
		GameRegistry.registerBlock(blockObsidianTable, "ObsidianTable");
		
		//Machines
		GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
		GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
		
		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		//Renderers
		nealeProxy.registerRenderThings();
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(itemTinCog, 4), new Object[]{" X ", "XFX", " X ", 'X', itemTinIngot, 'F', Items.flint});
		
		GameRegistry.addShapelessRecipe(new ItemStack(oreCopperOre), new Object[]{itemCopperIngot, Blocks.cobblestone});
		
		GameRegistry.addRecipe(new ItemStack(itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(itemIronWasher), new Object[]{"DP", 'D', itemIronDisc, 'P', new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
		
		//Smelting
		GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
		GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
		GameRegistry.addSmelting(oreZincOre, new ItemStack(itemZincIngot), 0);
		GameRegistry.addSmelting(oreNickelOre, new ItemStack(itemNickelIngot), 0);
		GameRegistry.addSmelting(oreManganeseOre, new ItemStack(itemManganeseIngot), 0);
		GameRegistry.addSmelting(oreVanadiumOre, new ItemStack(itemVanadiumIngot), 0);
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		

	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
	
}
