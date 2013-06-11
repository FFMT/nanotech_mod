package fr.mcnanotech.kevin_68.nanotech_mod.core;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.NanotechMobs;
import fr.mcnanotech.kevin_68.nanotech_mod.event.EventBonemeal;
import fr.mcnanotech.kevin_68.nanotech_mod.event.EventSound;
import fr.mcnanotech.kevin_68.nanotech_mod.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.utils.UtilCreativetabBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.utils.UtilCreativetabItems;
import fr.mcnanotech.kevin_68.nanotech_mod.utils.UtilDiskInfo;
import fr.mcnanotech.kevin_68.nanotech_mod.utils.UtilGuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.world.NanotechBiome;
import fr.mcnanotech.kevin_68.nanotech_mod.world.NanotechWorldProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.world.World_generation;

@Mod(modid = "Nanotech_mod", name = "Nanotech mod", version = "2.0.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Nanotech_mod 
{
	// Instance
	@Instance("Nanotech_mod")
	public static Nanotech_mod modInstance;
	// Proxy
	@SidedProxy(clientSide="fr.mcnanotech.kevin_68.nanotech_mod.core.ClientProxy", serverSide="fr.mcnanotech.kevin_68.nanotech_mod.core.CommonProxy")
	public static CommonProxy proxy;
	
	// GUI
	private UtilGuiHandler guiHandler = new UtilGuiHandler();
	
	// Block IDs
	public static int BlockPortalID;
	public static int BlockPortalframeID;
	public static int BlockGrassID;
	public static int BlockFakeOreID;
	public static int BlockSpeedID;
	public static int BlockJumperID;
	public static int BlockMultiplierID;
	public static int BlockSmokerID;
	public static int BlockTrashcanID;
	public static int BlockBarbedwireID;
	public static int BlockNanowoodID;
	public static int BlockNanoleavesID;
	public static int BlockNanosaplingsID;
	public static int BlockNanoplanksID;
	public static int BlockNanoOreID;
	public static int BlockConfusionID;
	public static int BlockFallingID;
	public static int BlockNotfallingID;
	public static int BlockSodiumID;
	public static int BlockMossystoneID;
	
	/**
	 * Item IDs
	 */
	public static int Item_NanotechID;
	public static int Item_superbottleofxpID;
	public static int Item_diamondbowID;
	public static int Item_emeraldbowID;
	public static int Item_nanomitebowID;
	public static int Item_nanomiteaxeID;
	public static int Item_nanomitepickaxeID;
	public static int Item_nanomiteshovelID;
	public static int Item_nanomitehoeID;
	public static int Item_nanomiteswordID;
	public static int Item_nanomitehelmetID;
	public static int Item_nanomitechestplateID;
	public static int Item_nanomitelegginsID;
	public static int Item_nanomitebootsID;
	public static int Item_mysterioushelmetID;
	public static int Item_mysteriouschestplateID;
	public static int Item_mysteriouslegginsID;
	public static int Item_mysteriousbootsID;
	public static int Item_nanodiscID;
	public static int Item_ediblefleshID;
	public static int Item_rottenchunkID;

	// Dimension ID
	public static int dimension = 19;
	
	// Biome statement
	public static BiomeGenBase Nanotechbiome;
	
	//Configuration
	public static boolean Config_hardrecipe;
	
	// Mobs configuration
	public static boolean Config_creeperdrillermultiexplosion;
	public static int Config_supercreeperexplosionradius;
	public static int Config_timeuntilnextarrow_superskeleton;
	public static boolean MobSpawn, Creeperdriller, Fastzombie, Fly, Supercreeper, Superenderman, Superskeleton, Superzombie,
	TheDeath, Flyingcreeper;
	public static int Superzombiechance;
	public static int Superzombiemin;
	public static int Superzombiemax;
	public static int Superskeletonchance;
	public static int Superskeletonmin;
	public static int Superskeletonmax;
	public static int Supercreeperchance;
	public static int Supercreepermin;
	public static int Supercreepermax;
	public static int Superendermanchance;
	public static int Superendermanmin;
	public static int Superendermanmax;
	public static int Fastzombiechance;
	public static int Fastzombiemin;
	public static int Fastzombiemax;
	public static int Flychance;
	public static int Flymin;
	public static int Flymax;
	public static int Creeperdrillerchance;
	public static int Creeperdrillermin;
	public static int Creeperdrillermax;
	public static int Flyingcreeperchance;
	public static int Flyingcreepermin;
	public static int Flyingcreepermax;
	
	// Configuration Category
	public static final String CATEGORY_ItemsID = "Items ID";
	public static final String CATEGORY_Other = "Other configs";
	public static final String CATEGORY_Mobsconfig = "Mobs configs";
	public static final String CATEGORY_Mobspawn = "Mobs spawn";
	
	// Creative tabs
	public static UtilCreativetabBlock CREATIVE_TAB_B = new UtilCreativetabBlock("Nanotech mod Blocks");
	public static UtilCreativetabItems CREATIVE_TAB_I = new UtilCreativetabItems("Nanotech mod Items");
	
	//log
	public static Logger NanoLog;
	
	@PreInit
	public void PreInitNanotech_mod(FMLPreInitializationEvent event) 
	{
		NanoLog = event.getModLog();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if(side == Side.CLIENT)
		{
			MinecraftForge.EVENT_BUS.register(new EventSound());
			UtilDiskInfo.readInfo();
		}
		
		//Configuration
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockPortalID = config.getBlock("Portal", 1000).getInt();
		BlockPortalframeID = config.getBlock("Portal frame", 1001).getInt();
		BlockGrassID = config.getBlock("Grass", 250).getInt();
        Property BlockGrass = config.get("block", "Grass", "Grass");
        BlockGrass.comment = "Grass is used in terrain gen, ID must be less than 256";
		BlockFakeOreID = config.getBlock("Fake diamond", 1002).getInt();
		BlockSpeedID = config.getBlock("Booster and Retarder", 1003).getInt();
		BlockJumperID = config.getBlock("Jumper", 1004).getInt();
		BlockMultiplierID = config.getBlock("Multiplier", 1005).getInt();
		BlockSmokerID = config.getBlock("Smoker", 1006).getInt();
		BlockTrashcanID = config.getBlock("Trash can", 1007).getInt();
		BlockBarbedwireID = config.getBlock("Barbed wire", 1014).getInt();
		BlockNanowoodID = config.getBlock("Nano Wood", 1015).getInt();
		BlockNanoleavesID = config.getBlock("Nano Leaves", 1016).getInt();
		BlockNanosaplingsID = config.getBlock("Nano Saplings", 1017).getInt();
		BlockNanoplanksID = config.getBlock("Nano Planks", 1018).getInt();
		BlockNanoOreID = config.getBlock("Ore", 1019).getInt();
		BlockConfusionID = config.getBlock("Confusion", 1020).getInt();
		BlockFallingID = config.getBlock("Falling block", 1021).getInt();
		BlockNotfallingID = config.getBlock("Not falling sand", 1022).getInt();
		BlockSodiumID = config.getBlock("Sodium", 1023).getInt();
		BlockMossystoneID = config.getBlock("Mossy stone", 1024).getInt();

		Item_NanotechID = config.get(CATEGORY_ItemsID, "Main Nanotech ID", 5000).getInt();
		Item_superbottleofxpID = config.get(CATEGORY_ItemsID, "Super Bottle of xp", 5005).getInt();
		Item_diamondbowID = config.get(CATEGORY_ItemsID, "Diamond bow", 5006).getInt();
		Item_emeraldbowID = config.get(CATEGORY_ItemsID, "Emerald bow", 5007).getInt();
		Item_nanomitebowID = config.get(CATEGORY_ItemsID, "Nanomite bow", 5008).getInt();
		Item_nanomiteaxeID = config.get(CATEGORY_ItemsID, "Nanomite Axe", 5019).getInt();
		Item_nanomitepickaxeID = config.get(CATEGORY_ItemsID, "Nanomite Pickaxe", 5020).getInt();
		Item_nanomiteshovelID = config.get(CATEGORY_ItemsID, "Nanomite Shovel", 5021).getInt();
		Item_nanomitehoeID = config.get(CATEGORY_ItemsID, "Nanomite Hoe", 5022).getInt();
		Item_nanomiteswordID = config.get(CATEGORY_ItemsID, "Nanomite Sword", 5023).getInt();
		Item_nanomitehelmetID = config.get(CATEGORY_ItemsID, "Nanomite Helmet", 5024).getInt();
		Item_nanomitechestplateID = config.get(CATEGORY_ItemsID, "Nanomite Chestplate", 5025).getInt();
		Item_nanomitelegginsID = config.get(CATEGORY_ItemsID, "Nanomite Leggins", 5026).getInt();
		Item_nanomitebootsID = config.get(CATEGORY_ItemsID, "Nanomite Boots", 5027).getInt();
		Item_mysterioushelmetID = config.get(CATEGORY_ItemsID, "Mysterious Helmet", 5028).getInt();
		Item_mysteriouschestplateID = config.get(CATEGORY_ItemsID, "Mysterious Chestplate", 5029).getInt();
		Item_mysteriouslegginsID = config.get(CATEGORY_ItemsID, "Mysterious Leggins", 5030).getInt();
		Item_mysteriousbootsID = config.get(CATEGORY_ItemsID, "Mysterious Boots", 5031).getInt();
		Item_nanodiscID = config.get(CATEGORY_ItemsID,"Nanodisk (warning he use 18 ID)", 5100).getInt();
		Item_ediblefleshID = config.get(CATEGORY_ItemsID, "Edible Flesh", 5032).getInt();
		Item_rottenchunkID = config.get(CATEGORY_ItemsID, "Chunk of rottenflesh", 5033).getInt();
		
		Config_hardrecipe = config.get(CATEGORY_Other, "Hard recipes", false).getBoolean(false);
		
		MobSpawn = config.get(CATEGORY_Mobsconfig, "MobSpawn", true).getBoolean(true);
	    Creeperdriller = config.get(CATEGORY_Mobsconfig, "Creeperdriller", true).getBoolean(true);
	    Config_creeperdrillermultiexplosion = config.get(CATEGORY_Mobsconfig, "Creeperdriller multi-explosion", true).getBoolean(true);
	    Config_supercreeperexplosionradius = config.get(CATEGORY_Mobsconfig, "Supercreeper explosion radius", 5).getInt();
	    Config_timeuntilnextarrow_superskeleton  = config.get(CATEGORY_Mobsconfig, "Supercreeper explosion radius", 3).getInt();
	    Fastzombie = config.get(CATEGORY_Mobsconfig, "Fastzombie", true).getBoolean(true);
	    Fly = config.get(CATEGORY_Mobsconfig, "Fly", true).getBoolean(true);
	    Supercreeper = config.get(CATEGORY_Mobsconfig, "Supercreeper", true).getBoolean(true);
	    Superenderman = config.get(CATEGORY_Mobsconfig, "Superenderman", true).getBoolean(true);
	    Superskeleton = config.get(CATEGORY_Mobsconfig, "Superskeleton", true).getBoolean(true);
	    Superzombie = config.get(CATEGORY_Mobsconfig, "Superzombie", true).getBoolean(true);
	    TheDeath = config.get(CATEGORY_Mobsconfig, "TheDeath", true).getBoolean(true);
	    Flyingcreeper = config.get(CATEGORY_Mobsconfig, "Flyingcreeper", true).getBoolean(true);
	    Superzombiechance = config.get(CATEGORY_Mobspawn, "Superzombiechance", 1).getInt();
	    Superzombiemin = config.get(CATEGORY_Mobspawn, "Superzombiemin", 1).getInt();
	    Superzombiemax = config.get(CATEGORY_Mobspawn, "Superzombiemax", 2).getInt();
	    Superskeletonchance = config.get(CATEGORY_Mobspawn, "Superskeletonchance", 1).getInt();
	    Superskeletonmin = config.get(CATEGORY_Mobspawn, "Superskeletonmin", 1).getInt();
	    Superskeletonmax = config.get(CATEGORY_Mobspawn, "Superskeletonmax", 2).getInt();
	    Supercreeperchance = config.get(CATEGORY_Mobspawn, "Supercreeperchance", 1).getInt();
	    Supercreepermin = config.get(CATEGORY_Mobspawn, "Supercreepermin", 1).getInt();
	    Supercreepermax = config.get(CATEGORY_Mobspawn, "Supercreepermax", 2).getInt();
	    Superendermanchance = config.get(CATEGORY_Mobspawn, "Superendermanchance", 1).getInt();
	    Superendermanmin = config.get(CATEGORY_Mobspawn, "Superendermanmin", 1).getInt();
	    Superendermanmax = config.get(CATEGORY_Mobspawn, "Superendermanmax", 2).getInt();
	    Fastzombiechance = config.get(CATEGORY_Mobspawn, "Fastzombiechance", 1).getInt();
	    Fastzombiemin = config.get(CATEGORY_Mobspawn, "Fastzombiemin", 5).getInt();
	    Fastzombiemax = config.get(CATEGORY_Mobspawn, "Fastzombiemax", 10).getInt();
	    Flychance = config.get(CATEGORY_Mobspawn, "Flychance", 3).getInt();
	    Flymin = config.get(CATEGORY_Mobspawn, "Flymin", 1).getInt();
	    Flymax = config.get(CATEGORY_Mobspawn, "Flymax", 4).getInt();
	    Creeperdrillerchance = config.get(CATEGORY_Mobspawn, "Creeperdrillerchance", 1).getInt();
	    Creeperdrillermin = config.get(CATEGORY_Mobspawn, "Creeperdrillermin", 1).getInt();
	    Creeperdrillermax = config.get(CATEGORY_Mobspawn, "Creeperdrillermax", 2).getInt();
	    Flyingcreeperchance = config.get(CATEGORY_Mobspawn, "Flyingcreeperchance", 1).getInt();
	    Flyingcreepermin = config.get(CATEGORY_Mobspawn, "Flyingcreepermin", 1).getInt();
	    Flyingcreepermax = config.get(CATEGORY_Mobspawn, "Flyingcreepermax", 2).getInt();
	    
		config.save();
		
		NanotechBlock.initBlock();
		NanotechBlock.blockRegistry();
		NanotechItem.initItem();
	}
	
	// Initialization
	@Init
	public void InitNanotech_mod(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		Nanotechbiome = new NanotechBiome(100).setBiomeName("Nanotechbiome").setTemperatureRainfall(1.2F, 0.9F);
		
		DimensionManager.registerProviderType(dimension, NanotechWorldProvider.class, false);
		DimensionManager.registerDimension(dimension, dimension);
		
		GameRegistry.registerWorldGenerator(new World_generation());
		
		this.guiAndTileEntity();
		this.creativeTab();
		NanotechMobs.mobs();
		proxy.registerModRenders();
		this.forgeDictionary();
		this.other();
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
	}
	
	@PostInit
	public void PostInitNanotech_mod(FMLPostInitializationEvent event)
	{
		if(Config_hardrecipe)
		{
			this.hardRecipes();
		}
		else
		{
			this.normalRecipes();
		}
		
		//Localization
		LanguageRegistry.instance().loadLocalization("/fr/mcnanotech/kevin_68/nanotech_mod/lang/en_US.lang", "en_US", false);
		LanguageRegistry.instance().loadLocalization("/fr/mcnanotech/kevin_68/nanotech_mod/lang/fr_FR.lang", "fr_FR", false);
	}
	
	/**
	 * Normal recipes
	 */
	public void normalRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanodisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc2, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,1));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc3, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,2));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc4, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,3));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc5, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc6, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,5));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc7, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,6));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc8, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,7));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc9, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc10, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,9));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc11, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,10));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc12, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,11));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc13, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,12));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc14, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,13));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc15, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,14));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc16, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,15));
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockPortalframe, 4), " X ", "XZX", " X ", 'X', Block.blockSteel, 'Z', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 2, 0), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 2, 1), " X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockJumper, 2), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockSteel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSmoker, 2), " X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockTrashcan), "X X", "XZX", "XXX", 'X', Item.ingotIron, 'Z', Block.cactus);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockBarbedwire, 4), "XXX", " X ", "XXX", 'X', Block.fenceIron);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 5), "XXX", "WYW", "XXX", 'X', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'Y', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 6), "XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.lightStoneDust, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'V', new ItemStack(NanotechItem.ItemBase, 1, 5));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 7), "XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 5), 'V', new ItemStack(NanotechItem.ItemBase, 1, 6));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 9), "WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8), 'V', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 10), "WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 11), "XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 12), "XYX", "VCV", "XNX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'Y', new ItemStack(NanotechItem.ItemBase, 1, 9), 'V', new ItemStack(NanotechItem.ItemBase, 1, 10), 'N', new ItemStack(NanotechItem.ItemBase, 1, 11));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitechestplate, 1), "X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteleggings, 1), "XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteboots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysterioushelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriouschestplate, 1), "X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriousleggings, 1), "XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriousboots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteaxe, 1), new Object[] {"XX", "XW", " W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteaxe, 1), new Object[] {"XX", "WX", "W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehoe, 1), new Object[] {"XX", " W", " W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehoe, 1), new Object[] {"XX", "W ", "W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitepickaxe, 1), new Object[] {"XXX", " W ", " W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteshovel, 1), new Object[] {"X", "W", "W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitesword, 1), new Object[] {"X", "X", "W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 13), "X", "XWX", "X", 'X', Item.ingotIron, 'W', new ItemStack(NanotechBlock.BlockSpeed, 1, 0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), " XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.BlockSpeed, 1, 0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), "WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.BlockSpeed, 1, 0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), " XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), "WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), " XW", "XCW", " XW", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'W', Item.silk, 'C', NanotechItem.Emeraldbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), "WX ", "WCX", "WX ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'W', Item.silk, 'C', NanotechItem.Emeraldbow);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockConfusion, 1), "XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 2), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 2), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 3), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 3), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 5), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 5), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 6), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 8, 6), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 8, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy);

		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockNanoplanks, 4), new Object[] {NanotechBlock.BlockNanowood});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.Rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 8), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 7), new ItemStack(NanotechItem.ItemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 14), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 12), new ItemStack(NanotechItem.ItemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockMossystone, 2), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 15), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object [] {new ItemStack(NanotechItem.ItemBase, 1, 15)});
		
		GameRegistry.addSmelting(NanotechBlock.BlockNanowood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		FurnaceRecipes.smelting().addSmelting(NanotechBlock.BlockNanoOre.blockID, 0, new ItemStack(NanotechItem.ItemBase, 1, 0), 1.0F);
		FurnaceRecipes.smelting().addSmelting(NanotechBlock.BlockNanoOre.blockID, 1, new ItemStack(NanotechItem.ItemBase, 1, 1), 1.0F);
		FurnaceRecipes.smelting().addSmelting(NanotechItem.ItemBase.itemID, 0, new ItemStack(NanotechItem.ItemBase, 1, 3), 1.0F);
		GameRegistry.addSmelting(NanotechItem.Rottenchunk.itemID, new ItemStack(NanotechItem.Edibleflesh), 0.5F);
		FurnaceRecipes.smelting().addSmelting(NanotechItem.ItemBase.itemID, 2, new ItemStack(NanotechItem.ItemBase, 1, 4), 1.5F);
	}
	
	/**
	 * Hard recipes
	 */
	public void hardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanodisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc2, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,1));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc3, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,2));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc4, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,3));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc5, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc6, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,5));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc7, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,6));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc8, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,7));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc9, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc10, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,9));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc11, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,10));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc12, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,11));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc13, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,12));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc14, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,13));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc15, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,14));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc16, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,15));
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockPortalframe), " X ", "XZX", " X ", 'X', Block.blockSteel, 'Z', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 1, 0), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 1 ,1), " X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockJumper), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockSteel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSmoker), " X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockTrashcan), "X X", "XZX", "XXX", 'X', Item.ingotIron, 'Z', Item.bucketLava);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockBarbedwire), "X X", " X ", "X X", 'X', Block.fenceIron);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 5), "XXX", "WYW", "XXX", 'X', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'Y', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 6), "XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.lightStoneDust, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'V', new ItemStack(NanotechItem.ItemBase, 1, 5));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 7), "XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 5), 'V', new ItemStack(NanotechItem.ItemBase, 1, 6));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 9), "WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8), 'V', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 10), "WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 11), "XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 12), "XYX", "VCV", "XNX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'Y', new ItemStack(NanotechItem.ItemBase, 1, 9), 'V', new ItemStack(NanotechItem.ItemBase, 1, 10), 'N', new ItemStack(NanotechItem.ItemBase, 1, 11));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysterioushelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriouschestplate, 1), "X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriousleggings, 1), "XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Mysteriousboots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteaxe, 1), new Object[] {"XX", "XW", " W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteaxe, 1), new Object[] {"XX", "WX", "W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehoe, 1), new Object[] {"XX", " W", " W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehoe, 1), new Object[] {"XX", "W ", "W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitepickaxe, 1), new Object[] {"XXX", " W ", " W ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteshovel, 1), new Object[] {"X", "W", "W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitesword, 1), new Object[] {"X", "X", "W", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), " XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C',  new ItemStack(NanotechBlock.BlockSpeed, 1, 0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), "WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C',  new ItemStack(NanotechBlock.BlockSpeed, 1, 0));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), " XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), "WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), " XW", "XCW", " XW", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.silk, 'C', NanotechItem.Emeraldbow);
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), "WX ", "WCX", "WX ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 14), 'W', Item.silk, 'C', NanotechItem.Emeraldbow);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockConfusion, 1), "XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 2), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 2), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 3), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 3), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 5), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 5), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 6), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, 4, 6), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 0), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, 4, 1), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy);

		
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockNanoplanks, 4), new Object[] {NanotechBlock.BlockNanowood});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.Rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 14), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 12), new ItemStack(NanotechItem.ItemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockMossystone, 1), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 15), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object [] {new ItemStack(NanotechItem.ItemBase, 1, 15)});
		
		GameRegistry.addSmelting(NanotechBlock.BlockNanowood.blockID, new ItemStack(Item.coal, 1, 1), 0.0F);
		FurnaceRecipes.smelting().addSmelting(NanotechBlock.BlockNanoOre.blockID, 0, new ItemStack(NanotechItem.ItemBase, 1, 0), 0.1F);
		FurnaceRecipes.smelting().addSmelting(NanotechBlock.BlockNanoOre.blockID, 1, new ItemStack(NanotechItem.ItemBase, 1, 1), 0.1F);
		FurnaceRecipes.smelting().addSmelting(NanotechItem.ItemBase.itemID, 0, new ItemStack(NanotechItem.ItemBase, 1, 3), 0.0F);
		GameRegistry.addSmelting(NanotechItem.Rottenchunk.itemID, new ItemStack(NanotechItem.Edibleflesh), 0.0F);
		FurnaceRecipes.smelting().addSmelting(NanotechItem.ItemBase.itemID, 2, new ItemStack(NanotechItem.ItemBase, 1, 4), 0.5F);
	}
	
	/**
	 * Gui and TileEntity
	 */
	public void guiAndTileEntity()
	{
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		GameRegistry.registerTileEntity(TileEntityJumper.class, "TileEntityJumper");
		GameRegistry.registerTileEntity(TileEntitySmoker.class, "TileEntitySmoker");
		GameRegistry.registerTileEntity(TileEntityMultiplier.class, "TileEntityMultiplier");
	}
	
	/**
	 * CreativeTabs (Names)
	 */
	public void creativeTab()
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.Nanotech mod Blocks", "en_US", "Nanotech mod Blocks");
		LanguageRegistry.instance().addStringLocalization("itemGroup.Nanotech mod Items", "en_US", "Nanotech mod Items");
		
	}

	// Forge dictionary
	public void forgeDictionary()
	{
		OreDictionary.registerOre("logWood", new ItemStack(NanotechBlock.BlockNanowood));
		OreDictionary.registerOre("plankWood", new ItemStack(NanotechBlock.BlockNanoplanks));
		OreDictionary.registerOre("treeSapling", new ItemStack(NanotechBlock.BlockNanosaplings));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NanotechBlock.BlockNanoleaves));
	}
	
	/*
	 * Other code
	 * -Shovel on grass
	 */
	public void other()
	{
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.BlockGrass, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.Blocknotfalling, "shovel", 2);
	}
}
