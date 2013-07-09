package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import java.util.logging.Logger;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabItems;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.NanotechMobs;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventBonemeal;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventSound;
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
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"NanotechMod"}, packetHandler = PacketHandler.class)
public class Nanotech_mod
{
	// Instance
	@Instance("Nanotech_mod")
	public static Nanotech_mod modInstance;
	// Proxy
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.CommonProxy")
	public static CommonProxy proxy;

	// GUI
	private GuiHandler guiHandler = new GuiHandler();

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

	// Item IDs
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
	public static int dimensionID = 19;

	// Biome statement
	public static BiomeGenBase Nanotechbiome;

	// Configuration
	public static boolean Config_hardrecipe;

	// Mobs configuration
	public static boolean Config_creeperdrillermultiexplosion;
	public static int Config_supercreeperexplosionradius;
	public static int Config_timeuntilnextarrow_superskeleton;
	public static boolean MobSpawn, Creeperdriller, Fastzombie, Fly,
			Supercreeper, Superenderman, Superskeleton, Superzombie, TheDeath,
			Flyingcreeper;
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
	public static final String CATEGORY_Other = "Other configs";
	public static final String CATEGORY_Mobsconfig = "Mobs configs";
	public static final String CATEGORY_Mobspawn = "Mobs spawn";

	// Creative tabs
	public static CreativetabBlock CREATIVE_TAB_B = new CreativetabBlock("NanotechModBlocks");
	public static CreativetabItems CREATIVE_TAB_I = new CreativetabItems("NanotechModItems");

	// log
	public static Logger NanoLog;

	@PreInit
	public void PreInitNanotech_mod(FMLPreInitializationEvent event)
	{
		NanoLog = event.getModLog();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.CLIENT)
		{
			MinecraftForge.EVENT_BUS.register(new EventSound());
			UtilDiskInfo.readInfo();
		}

		// Configuration
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockPortalID = config.getBlock("Portal", 1000).getInt();
		BlockPortalframeID = config.getBlock("Portal frame", 1001).getInt();
		BlockGrassID = config.getTerrainBlock("block", "Grass", 250, "Grass is used in terrain gen, ID must be less than 256").getInt();
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

		Item_NanotechID = config.getItem("Main Nanotech ID", 5000).getInt();
		Item_superbottleofxpID = config.getItem("Super Bottle of xp", 5005).getInt();
		Item_diamondbowID = config.getItem("Diamond bow", 5006).getInt();
		Item_emeraldbowID = config.getItem("Emerald bow", 5007).getInt();
		Item_nanomitebowID = config.getItem("Nanomite bow", 5008).getInt();
		Item_nanomiteaxeID = config.getItem("Nanomite Axe", 5019).getInt();
		Item_nanomitepickaxeID = config.getItem("Nanomite Pickaxe", 5020).getInt();
		Item_nanomiteshovelID = config.getItem("Nanomite Shovel", 5021).getInt();
		Item_nanomitehoeID = config.getItem("Nanomite Hoe", 5022).getInt();
		Item_nanomiteswordID = config.getItem("Nanomite Sword", 5023).getInt();
		Item_nanomitehelmetID = config.getItem("Nanomite Helmet", 5024).getInt();
		Item_nanomitechestplateID = config.getItem("Nanomite Chestplate", 5025).getInt();
		Item_nanomitelegginsID = config.getItem("Nanomite Leggins", 5026).getInt();
		Item_nanomitebootsID = config.getItem("Nanomite Boots", 5027).getInt();
		Item_mysterioushelmetID = config.getItem("Mysterious Helmet", 5028).getInt();
		Item_mysteriouschestplateID = config.getItem("Mysterious Chestplate", 5029).getInt();
		Item_mysteriouslegginsID = config.getItem("Mysterious Leggins", 5030).getInt();
		Item_mysteriousbootsID = config.getItem("Mysterious Boots", 5031).getInt();
		Item_nanodiscID = config.getItem("Nanodisk (warning he use 18 ID)", 5100).getInt();
		Item_ediblefleshID = config.getItem("Edible Flesh", 5032).getInt();
		Item_rottenchunkID = config.getItem("Chunk of rottenflesh", 5033).getInt();

		Config_hardrecipe = config.get(CATEGORY_Other, "Hard recipes", false).getBoolean(false);

		MobSpawn = config.get(CATEGORY_Mobsconfig, "MobSpawn", true).getBoolean(true);
		Creeperdriller = config.get(CATEGORY_Mobsconfig, "Creeperdriller", true).getBoolean(true);
		Config_creeperdrillermultiexplosion = config.get(CATEGORY_Mobsconfig, "Creeperdriller multi-explosion", true).getBoolean(true);
		Config_supercreeperexplosionradius = config.get(CATEGORY_Mobsconfig, "Supercreeper explosion radius", 5).getInt();
		Config_timeuntilnextarrow_superskeleton = config.get(CATEGORY_Mobsconfig, "Supercreeper explosion radius", 3).getInt();
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
	}

	@PostInit
	public void PostInitNanotech_mod(FMLPostInitializationEvent event)
	{
		NanotechRecipe.InitCommonRecipes();
		if (Config_hardrecipe)
		{
			NanotechRecipe.InitHardRecipes();
			NanotechRecipe.InitFallingBlockRecipes(4);
		}
		else
		{
			NanotechRecipe.InitNormalRecipes();
			NanotechRecipe.InitFallingBlockRecipes(8);
		}

		// Localization
		LanguageRegistry.instance().loadLocalization("/mods/Nanotech_mod/lang/en_US.lang", "en_US", false);
		LanguageRegistry.instance().loadLocalization("/mods/Nanotech_mod/lang/fr_FR.lang", "fr_FR", false);
	}

	// Gui and TileEntity
	public void guiAndTileEntity()
	{
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
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
