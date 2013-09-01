package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import java.util.logging.Logger;

import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabItems;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.NanotechMobs;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.CraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventBonemeal;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventSound;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.PlayerTracker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilDiskInfo;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechBiome;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechWorldProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.WorldGeneration;

@Mod(modid = "Nanotech_mod", name = "Nanotech mod", version = "2.0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"NTM|smoker", "NTM|jumper"}, packetHandler = PacketHandler.class)
public class Nanotech_mod
{
	// Instance
	@Instance("Nanotech_mod")
	public static Nanotech_mod modInstance;
	// Proxy
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.CommonProxy")
	public static CommonProxy proxy;

	// Block IDs
	public static int BlockPortalID, BlockPortalFrameID, BlockGrassID, BlockFakeOreID, BlockSpeedID, BlockJumperID, BlockMultiplierID, BlockSmokerID, BlockBarbedWireID, BlockNanoWoodID, BlockNanoLeavesID, BlockNanoSaplingsID, BlockNanoPlanksID, BlockNanoOreID, BlockConfusionID, BlockFallingID, BlockNotFallingID, BlockSodiumID, BlockMossyStoneID,
	BlockTheDeathHeadID, BlockTeaID;

	// Item IDs
	public static int ItemNanotechID, ItemSuperBottleOfXpID, ItemDiamondBowID, ItemEmeraldBowID, ItemNanomiteBowID, ItemNanomiteAxeID, ItemNanomitePickaxeID, ItemNanomiteShovelID, ItemNanomiteHoeID, ItemNanomiteSwordID, ItemNanomiteHelmetID, ItemNanomiteChestPlateID, ItemNanomiteLegginsID, ItemNanomiteBootsID, ItemMysteriousHelmetID, ItemMysteriousChestPlateID, ItemMysteriousLegginsID,
	ItemMysteriousBootsID, ItemNanoDiscID, ItemEdibleFleshID, ItemRottenChunkID, ItemScytheID, ItemCrazyGlassesID, TeaSeedID, TeaID, DebugID;

	// Dimension ID
	public static int dimensionID = 19;

	// Biome statement
	public static BiomeGenBase Nanotechbiome;

	// Recipe configuration
	public static boolean HardRecipe;

	// Mobs configuration
	public static boolean MultipleExplosion;
	public static int ExplosionRadius;
	public static int TimeUntilNextArrow;
	public static boolean CreeperDriller, FastZombie, Fly, SuperCreeper, SuperEnderman, SuperSkeleton, SuperZombie, TheDeath, FlyingCreeper, CrazyGuy;
	public static int SuperZombieProb;
	public static int SuperZombieMin;
	public static int SuperZombieMax;
	public static int SuperSkeletonProb;
	public static int SuperSkeletonMin;
	public static int SuperSkeletonMax;
	public static int SuperCreeperProb;
	public static int SuperCreeperMin;
	public static int SuperCreeperMax;
	public static int SuperEndermanProb;
	public static int SuperEndermanMin;
	public static int SuperEndermanMax;
	public static int FastZombieProb;
	public static int FastZombieMin;
	public static int FastZombieMax;
	public static int FlyProb;
	public static int FlyMin;
	public static int FlyMax;
	public static int CreeperDrillerProb;
	public static int CreeperDrillerMin;
	public static int CreeperDrillerMax;
	public static int FlyingCreeperProb;
	public static int FlyingCreeperMin;
	public static int FlyingCreeperMax;
	public static int CrazyGuyProb;
	public static int CrazyGuyMin;
	public static int CrazyGuyMax;

	// Configuration Category
	public static final String CATEGORY_Other = "Other configs";
	public static final String CATEGORY_Mobscfg = "Mobs configs";
	public static final String CATEGORY_Mobspawn = "Mobs spawn";

	// Creative tabs
	public static CreativetabBlock CREATIVE_TAB_B = new CreativetabBlock("NanotechModBlocks");
	public static CreativetabItems CREATIVE_TAB_I = new CreativetabItems("NanotechModItems");

	// log
	public static Logger NanoLog;

	public static boolean nanotech_mod_city()
	{
		try
		{
			if (Loader.isModLoaded("Nanotech_mod_City"))
			{
				NanoLog.info("Nanotech_mod City Detected");
				return true;
			}
			else
			{
				NanoLog.info("Nanotech_mod City not detected");
				return false;
			}
		}
		catch (Exception e)
		{
			NanoLog.severe("Failed to check if Nanotech_mod City is here, or not");
			return false;
		}
	}

	@EventHandler
	public void PreInitNanotech_mod(FMLPreInitializationEvent event)
	{
		NanoLog = event.getModLog();
		if(event.getSide().isClient())
		{
			MinecraftForge.EVENT_BUS.register(new EventSound());
			UtilDiskInfo.readInfo();
		}

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			BlockPortalID = cfg.getBlock("Portal", 1000).getInt();
			BlockPortalFrameID = cfg.getBlock("Portal Frame", 1001).getInt();
			BlockGrassID = cfg.getTerrainBlock("block", "Grass", 250, "Grass is used in terrain gen, ID must be less than 256").getInt();
			BlockFakeOreID = cfg.getBlock("Fake diamond", 1002).getInt();
			BlockSpeedID = cfg.getBlock("Booster and Retarder", 1003).getInt();
			BlockJumperID = cfg.getBlock("Jumper", 1004).getInt();
			BlockMultiplierID = cfg.getBlock("Multiplier", 1005).getInt();
			BlockSmokerID = cfg.getBlock("Smoker", 1006).getInt();
			BlockBarbedWireID = cfg.getBlock("Barbed Wire", 1007).getInt();
			BlockNanoWoodID = cfg.getBlock("Nano Wood", 1008).getInt();
			BlockNanoLeavesID = cfg.getBlock("Nano Leaves", 1009).getInt();
			BlockNanoSaplingsID = cfg.getBlock("Nano Saplings", 1010).getInt();
			BlockNanoPlanksID = cfg.getBlock("Nano Planks", 1011).getInt();
			BlockNanoOreID = cfg.getBlock("Ore", 1012).getInt();
			BlockConfusionID = cfg.getBlock("Confusion", 1013).getInt();
			BlockFallingID = cfg.getBlock("Falling Blocks", 1014).getInt();
			BlockNotFallingID = cfg.getBlock("Not Falling Blocks", 1015).getInt();
			BlockSodiumID = cfg.getBlock("Sodium", 1016).getInt();
			BlockMossyStoneID = cfg.getBlock("Mossy Stone", 1017).getInt();
			BlockTheDeathHeadID = cfg.getBlock("TheDeathHead", 1018).getInt();
			BlockTeaID = cfg.getBlock("Tea", 1019).getInt();

			ItemNanotechID = cfg.getItem("Main Nanotech ID", 5000).getInt();
			ItemSuperBottleOfXpID = cfg.getItem("Super Bottle of xp", 5001).getInt();
			ItemDiamondBowID = cfg.getItem("Diamond bow", 5002).getInt();
			ItemEmeraldBowID = cfg.getItem("Emerald bow", 5003).getInt();
			ItemNanomiteBowID = cfg.getItem("Nanomite bow", 5004).getInt();
			ItemNanomiteAxeID = cfg.getItem("Nanomite Axe", 5005).getInt();
			ItemNanomitePickaxeID = cfg.getItem("Nanomite Pickaxe", 5006).getInt();
			ItemNanomiteShovelID = cfg.getItem("Nanomite Shovel", 5007).getInt();
			ItemNanomiteHoeID = cfg.getItem("Nanomite Hoe", 5008).getInt();
			ItemNanomiteSwordID = cfg.getItem("Nanomite Sword", 5009).getInt();
			ItemNanomiteHelmetID = cfg.getItem("Nanomite Helmet", 5010).getInt();
			ItemNanomiteChestPlateID = cfg.getItem("Nanomite Chestplate", 5011).getInt();
			ItemNanomiteLegginsID = cfg.getItem("Nanomite Leggins", 5012).getInt();
			ItemNanomiteBootsID = cfg.getItem("Nanomite Boots", 5013).getInt();
			ItemMysteriousHelmetID = cfg.getItem("Mysterious Helmet", 5014).getInt();
			ItemMysteriousChestPlateID = cfg.getItem("Mysterious Chestplate", 5015).getInt();
			ItemMysteriousLegginsID = cfg.getItem("Mysterious Leggins", 5016).getInt();
			ItemMysteriousBootsID = cfg.getItem("Mysterious Boots", 5017).getInt();
			ItemNanoDiscID = cfg.getItem("Nanodisk (warning he use 18 ID)", 5100).getInt();
			ItemEdibleFleshID = cfg.getItem("Edible Flesh", 5018).getInt();
			ItemRottenChunkID = cfg.getItem("Chunk of rottenflesh", 5019).getInt();
			ItemScytheID = cfg.getItem("Scythe", 5020).getInt();
			ItemCrazyGlassesID = cfg.getItem("CrazyGlasses", 5021).getInt();
			TeaSeedID = cfg.getItem("TeaSeed", 5022).getInt();
			TeaID = cfg.getItem("Tea", 5023).getInt();
			DebugID = cfg.getItem("Debug Item", 5024).getInt();
			
			HardRecipe = cfg.get(CATEGORY_Other, "Hard recipes", false).getBoolean(false);

			CreeperDriller = cfg.get(CATEGORY_Mobscfg, "CreeperDriller", true).getBoolean(true);
			MultipleExplosion = cfg.get(CATEGORY_Mobscfg, "Multiple Explosion (CreeperDriller)", true).getBoolean(true);
			ExplosionRadius = cfg.get(CATEGORY_Mobscfg, "Explosion Radius (SuperCreeper)", 5).getInt();
			TimeUntilNextArrow = cfg.get(CATEGORY_Mobscfg, "Time Until New Arrow (SuperSkeleton)", 3).getInt();
			FastZombie = cfg.get(CATEGORY_Mobscfg, "Fastzombie", true).getBoolean(true);
			Fly = cfg.get(CATEGORY_Mobscfg, "Fly", true).getBoolean(true);
			SuperCreeper = cfg.get(CATEGORY_Mobscfg, "Supercreeper", true).getBoolean(true);
			SuperEnderman = cfg.get(CATEGORY_Mobscfg, "Superenderman", true).getBoolean(true);
			SuperSkeleton = cfg.get(CATEGORY_Mobscfg, "Superskeleton", true).getBoolean(true);
			SuperZombie = cfg.get(CATEGORY_Mobscfg, "Superzombie", true).getBoolean(true);
			TheDeath = cfg.get(CATEGORY_Mobscfg, "TheDeath", true).getBoolean(true);
			FlyingCreeper = cfg.get(CATEGORY_Mobscfg, "FlyingCreeper", true).getBoolean(true);
			CrazyGuy = cfg.get(CATEGORY_Mobscfg, "CrazyGuy", true).getBoolean(true);
			SuperZombieProb = cfg.get(CATEGORY_Mobspawn, "SuperZombie Prob", 1).getInt();
			SuperZombieMin = cfg.get(CATEGORY_Mobspawn, "SuperZombie Min", 1).getInt();
			SuperZombieMax = cfg.get(CATEGORY_Mobspawn, "SuperZombie Max", 2).getInt();
			SuperSkeletonProb = cfg.get(CATEGORY_Mobspawn, "SuperSkeleton Prob", 1).getInt();
			SuperSkeletonMin = cfg.get(CATEGORY_Mobspawn, "SuperSkeleton Min", 1).getInt();
			SuperSkeletonMax = cfg.get(CATEGORY_Mobspawn, "SuperSkeleton Max", 2).getInt();
			SuperCreeperProb = cfg.get(CATEGORY_Mobspawn, "SuperCreeper Prob", 1).getInt();
			SuperCreeperMin = cfg.get(CATEGORY_Mobspawn, "SuperCreeper Min", 1).getInt();
			SuperCreeperMax = cfg.get(CATEGORY_Mobspawn, "SuperCreeper Max", 2).getInt();
			SuperEndermanProb = cfg.get(CATEGORY_Mobspawn, "SuperEnderman Prob", 1).getInt();
			SuperEndermanMin = cfg.get(CATEGORY_Mobspawn, "SuperEnderman Min", 1).getInt();
			SuperEndermanMax = cfg.get(CATEGORY_Mobspawn, "SuperEnderman Max", 2).getInt();
			FastZombieProb = cfg.get(CATEGORY_Mobspawn, "FastZombie Prob", 1).getInt();
			FastZombieMin = cfg.get(CATEGORY_Mobspawn, "FastZombie Min", 5).getInt();
			FastZombieMax = cfg.get(CATEGORY_Mobspawn, "FastZombie Max", 10).getInt();
			FlyProb = cfg.get(CATEGORY_Mobspawn, "Fly Prob", 3).getInt();
			FlyMin = cfg.get(CATEGORY_Mobspawn, "Fly Min", 1).getInt();
			FlyMax = cfg.get(CATEGORY_Mobspawn, "Fly Max", 4).getInt();
			CreeperDrillerProb = cfg.get(CATEGORY_Mobspawn, "CreeperDriller Prob", 1).getInt();
			CreeperDrillerMin = cfg.get(CATEGORY_Mobspawn, "CreeperDriller Min", 1).getInt();
			CreeperDrillerMax = cfg.get(CATEGORY_Mobspawn, "CreeperDriller Max", 2).getInt();
			FlyingCreeperProb = cfg.get(CATEGORY_Mobspawn, "FlyingCreeper Prob", 1).getInt();
			FlyingCreeperMin = cfg.get(CATEGORY_Mobspawn, "FlyingCreeper Min", 1).getInt();
			FlyingCreeperMax = cfg.get(CATEGORY_Mobspawn, "FlyingCreeper Max", 2).getInt();
			CrazyGuyProb = cfg.get(CATEGORY_Mobspawn, "CrazyGuy Prob", 1).getInt();
			CrazyGuyMin = cfg.get(CATEGORY_Mobspawn, "CrazyGuy Min", 1).getInt();
			CrazyGuyMax = cfg.get(CATEGORY_Mobspawn, "CrazyGuy Max", 2).getInt();
			Property info = cfg.get(CATEGORY_Mobspawn, "CrazyGuy Max", "");
			info.comment = "Set to 0 prob for disable mob spawning. Min = minimum spawn group, max = maximum spawn group";
		}
		catch(Exception ex)
		{
			NanoLog.severe("Failed to load cfguration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}

		NanotechBlock.initBlock();
		NanotechBlock.blockRegistry();
		NanotechItem.initItem();
		NanotechAchievement.initAchievement();
	}

	// Initialization
	@EventHandler
	public void InitNanotech_mod(FMLInitializationEvent event)
	{
		Nanotechbiome = new NanotechBiome(100).setBiomeName("Nanotechbiome").setTemperatureRainfall(1.2F, 0.9F);

		DimensionManager.registerProviderType(dimensionID, NanotechWorldProvider.class, false);
		DimensionManager.registerDimension(dimensionID, dimensionID);

		GameRegistry.registerWorldGenerator(new WorldGeneration());

		this.guiAndTileEntity();
		NanotechMobs.mobs();
		proxy.registerModRenders();
		this.forgeDictionary();
		this.other();
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());

		GameRegistry.registerPlayerTracker(new PlayerTracker());
		GameRegistry.registerCraftingHandler(new CraftingHandler());
	}

	@EventHandler
	public void PostInitNanotech_mod(FMLPostInitializationEvent event)
	{
		proxy.registerOverlay();

		NanotechRecipe.InitCommonRecipes();
		if(HardRecipe)
		{
			NanotechRecipe.InitHardRecipes();
			NanotechRecipe.InitFallingBlockRecipes(4);
		}
		else
		{
			NanotechRecipe.InitNormalRecipes();
			NanotechRecipe.InitFallingBlockRecipes(8);
		}

	}

	// Gui and TileEntity
	public void guiAndTileEntity()
	{
		NetworkRegistry.instance().registerGuiHandler(this.modInstance, new GuiHandler());
		NetworkRegistry.instance().registerChannel(new PacketHandler(), "nanotechmod");

		GameRegistry.registerTileEntity(TileEntityJumper.class, "TileEntityJumper");
		GameRegistry.registerTileEntity(TileEntitySmoker.class, "TileEntitySmoker");
		GameRegistry.registerTileEntity(TileEntityMultiplier.class, "TileEntityMultiplier");
	}

	// Forge dictionary
	public void forgeDictionary()
	{
		OreDictionary.registerOre("logWood", new ItemStack(NanotechBlock.BlockNanowood));
		OreDictionary.registerOre("plankWood", new ItemStack(NanotechBlock.BlockNanoplanks));
		OreDictionary.registerOre("treeSapling", new ItemStack(NanotechBlock.BlockNanosaplings));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NanotechBlock.BlockNanoleaves));
	}

	// Other code -Shovel on grass
	public void other()
	{
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.BlockGrass, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.Blocknotfalling, "shovel", 2);
	}
}
