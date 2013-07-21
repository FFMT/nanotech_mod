package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import java.util.logging.Logger;

import net.minecraft.item.ItemStack;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockTrail;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilDiskInfo;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechBiome;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechWorldProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.WorldGeneration;

@Mod(modid = "Nanotech_mod", name = "Nanotech mod", version = "2.0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"nanotechmod"}, packetHandler = PacketHandler.class)
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
	public static int BlockPortalFrameID;
	public static int BlockGrassID;
	public static int BlockFakeOreID;
	public static int BlockSpeedID;
	public static int BlockJumperID;
	public static int BlockMultiplierID;
	public static int BlockSmokerID;
	public static int BlockTrashcanID;
	public static int BlockBarbedWireID;
	public static int BlockNanoWoodID;
	public static int BlockNanoLeavesID;
	public static int BlockNanoSaplingsID;
	public static int BlockNanoPlanksID;
	public static int BlockNanoOreID;
	public static int BlockConfusionID;
	public static int BlockFallingID;
	public static int BlockNotFallingID;
	public static int BlockSodiumID;
	public static int BlockMossyStoneID;
	public static int BlockSpotLightID;
	public static int BlockTheDeathHeadID;
	public static int BlockTrailID;

	// Item IDs
	public static int ItemNanotechID;
	public static int ItemSuperBottleOfXpID;
	public static int ItemDiamondBowID;
	public static int ItemEmeraldBowID;
	public static int ItemNanomiteBowID;
	public static int ItemNanomiteAxeID;
	public static int ItemNanomitePickaxeID;
	public static int ItemNanomiteShovelID;
	public static int ItemNanomiteHoeID;
	public static int ItemNanomiteSwordID;
	public static int ItemNanomiteHelmetID;
	public static int ItemNanomiteChestPlateID;
	public static int ItemNanomiteLegginsID;
	public static int ItemNanomiteBootsID;
	public static int ItemMysteriousHelmetID;
	public static int ItemMysteriousChestPlateID;
	public static int ItemMysteriousLegginsID;
	public static int ItemMysteriousBootsID;
	public static int ItemNanoDiscID;
	public static int ItemEdibleFleshID;
	public static int ItemRottenChunkID;

	// Dimension ID
	public static int dimensionID = 19;

	// Biome statement
	public static BiomeGenBase Nanotechbiome;

	// Configuration
	public static boolean HardRecipe;

	// Mobs configuration
	public static boolean MultipleExplosion;
	public static int ExplosionRadius;
	public static int TimeUntilNextArrow;
	public static boolean CreeperDriller, FastZombie, Fly, SuperCreeper,
			SuperEnderman, SuperSkeleton, SuperZombie, TheDeath, FlyingCreeper,
			CrazyGuy;
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
	public static final String CATEGORY_Mobsconfig = "Mobs configs";
	public static final String CATEGORY_Mobspawn = "Mobs spawn";

	// Creative tabs
	public static CreativetabBlock CREATIVE_TAB_B = new CreativetabBlock("NanotechModBlocks");
	public static CreativetabItems CREATIVE_TAB_I = new CreativetabItems("NanotechModItems");

	// log
	public static Logger NanoLog;

	protected TileEntityBlockSpotLight tileSpotLight;

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

		// Configuration
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockPortalID = config.getBlock("Portal", 1000).getInt();
		BlockPortalFrameID = config.getBlock("Portal Frame", 1001).getInt();
		BlockGrassID = config.getTerrainBlock("block", "Grass", 250, "Grass is used in terrain gen, ID must be less than 256").getInt();
		BlockFakeOreID = config.getBlock("Fake diamond", 1002).getInt();
		BlockSpeedID = config.getBlock("Booster and Retarder", 1003).getInt();
		BlockJumperID = config.getBlock("Jumper", 1004).getInt();
		BlockMultiplierID = config.getBlock("Multiplier", 1005).getInt();
		BlockSmokerID = config.getBlock("Smoker", 1006).getInt();
		BlockTrashcanID = config.getBlock("Trash can", 1007).getInt();
		BlockBarbedWireID = config.getBlock("Barbed Wire", 1008).getInt();
		BlockNanoWoodID = config.getBlock("Nano Wood", 1009).getInt();
		BlockNanoLeavesID = config.getBlock("Nano Leaves", 1010).getInt();
		BlockNanoSaplingsID = config.getBlock("Nano Saplings", 1011).getInt();
		BlockNanoPlanksID = config.getBlock("Nano Planks", 1012).getInt();
		BlockNanoOreID = config.getBlock("Ore", 1013).getInt();
		BlockConfusionID = config.getBlock("Confusion", 1014).getInt();
		BlockFallingID = config.getBlock("Falling Blocks", 1015).getInt();
		BlockNotFallingID = config.getBlock("Not Falling Blocks", 1016).getInt();
		BlockSodiumID = config.getBlock("Sodium", 1017).getInt();
		BlockMossyStoneID = config.getBlock("Mossy Stone", 1018).getInt();
		BlockSpotLightID = config.getBlock("SpotLight", 1019).getInt();
		BlockTheDeathHeadID = config.getBlock("TheDeathHead", 1020).getInt();
		BlockTrailID = config.getBlock("Trail", 1021).getInt();

		ItemNanotechID = config.getItem("Main Nanotech ID", 5000).getInt();
		ItemSuperBottleOfXpID = config.getItem("Super Bottle of xp", 5001).getInt();
		ItemDiamondBowID = config.getItem("Diamond bow", 5002).getInt();
		ItemEmeraldBowID = config.getItem("Emerald bow", 5003).getInt();
		ItemNanomiteBowID = config.getItem("Nanomite bow", 5004).getInt();
		ItemNanomiteAxeID = config.getItem("Nanomite Axe", 5005).getInt();
		ItemNanomitePickaxeID = config.getItem("Nanomite Pickaxe", 5006).getInt();
		ItemNanomiteShovelID = config.getItem("Nanomite Shovel", 5007).getInt();
		ItemNanomiteHoeID = config.getItem("Nanomite Hoe", 5008).getInt();
		ItemNanomiteSwordID = config.getItem("Nanomite Sword", 5009).getInt();
		ItemNanomiteHelmetID = config.getItem("Nanomite Helmet", 5010).getInt();
		ItemNanomiteChestPlateID = config.getItem("Nanomite Chestplate", 5011).getInt();
		ItemNanomiteLegginsID = config.getItem("Nanomite Leggins", 5012).getInt();
		ItemNanomiteBootsID = config.getItem("Nanomite Boots", 5013).getInt();
		ItemMysteriousHelmetID = config.getItem("Mysterious Helmet", 5014).getInt();
		ItemMysteriousChestPlateID = config.getItem("Mysterious Chestplate", 5015).getInt();
		ItemMysteriousLegginsID = config.getItem("Mysterious Leggins", 5016).getInt();
		ItemMysteriousBootsID = config.getItem("Mysterious Boots", 5017).getInt();
		ItemNanoDiscID = config.getItem("Nanodisk (warning he use 18 ID)", 5100).getInt();
		ItemEdibleFleshID = config.getItem("Edible Flesh", 5018).getInt();
		ItemRottenChunkID = config.getItem("Chunk of rottenflesh", 5019).getInt();

		HardRecipe = config.get(CATEGORY_Other, "Hard recipes", false).getBoolean(false);

		// Property info = config.get(CATEGORY_Mobspawn, "", "");
		// info.comment = "Set to 0 for disable mob spawning";
		CreeperDriller = config.get(CATEGORY_Mobsconfig, "CreeperDriller", true).getBoolean(true);
		MultipleExplosion = config.get(CATEGORY_Mobsconfig, "Multiple Explosion (CreeperDriller)", true).getBoolean(true);
		ExplosionRadius = config.get(CATEGORY_Mobsconfig, "Explosion Radius (SuperCreeper)", 5).getInt();
		TimeUntilNextArrow = config.get(CATEGORY_Mobsconfig, "Time Until New Arrow (SuperSkeleton)", 3).getInt();
		FastZombie = config.get(CATEGORY_Mobsconfig, "Fastzombie", true).getBoolean(true);
		Fly = config.get(CATEGORY_Mobsconfig, "Fly", true).getBoolean(true);
		SuperCreeper = config.get(CATEGORY_Mobsconfig, "Supercreeper", true).getBoolean(true);
		SuperEnderman = config.get(CATEGORY_Mobsconfig, "Superenderman", true).getBoolean(true);
		SuperSkeleton = config.get(CATEGORY_Mobsconfig, "Superskeleton", true).getBoolean(true);
		SuperZombie = config.get(CATEGORY_Mobsconfig, "Superzombie", true).getBoolean(true);
		TheDeath = config.get(CATEGORY_Mobsconfig, "TheDeath", true).getBoolean(true);
		FlyingCreeper = config.get(CATEGORY_Mobsconfig, "FlyingCreeper", true).getBoolean(true);
		CrazyGuy = config.get(CATEGORY_Mobsconfig, "CrazyGuy", true).getBoolean(true);
		SuperZombieProb = config.get(CATEGORY_Mobspawn, "SuperZombie Prob", 1).getInt();
		SuperZombieMin = config.get(CATEGORY_Mobspawn, "SuperZombie Min", 1).getInt();
		SuperZombieMax = config.get(CATEGORY_Mobspawn, "SuperZombie Max", 2).getInt();
		SuperSkeletonProb = config.get(CATEGORY_Mobspawn, "SuperSkeleton Prob", 1).getInt();
		SuperSkeletonMin = config.get(CATEGORY_Mobspawn, "SuperSkeleton Min", 1).getInt();
		SuperSkeletonMax = config.get(CATEGORY_Mobspawn, "SuperSkeleton Max", 2).getInt();
		SuperCreeperProb = config.get(CATEGORY_Mobspawn, "SuperCreeper Prob", 1).getInt();
		SuperCreeperMin = config.get(CATEGORY_Mobspawn, "SuperCreeper Min", 1).getInt();
		SuperCreeperMax = config.get(CATEGORY_Mobspawn, "SuperCreeper Max", 2).getInt();
		SuperEndermanProb = config.get(CATEGORY_Mobspawn, "SuperEnderman Prob", 1).getInt();
		SuperEndermanMin = config.get(CATEGORY_Mobspawn, "SuperEnderman Min", 1).getInt();
		SuperEndermanMax = config.get(CATEGORY_Mobspawn, "SuperEnderman Max", 2).getInt();
		FastZombieProb = config.get(CATEGORY_Mobspawn, "FastZombie Prob", 1).getInt();
		FastZombieMin = config.get(CATEGORY_Mobspawn, "FastZombie Min", 5).getInt();
		FastZombieMax = config.get(CATEGORY_Mobspawn, "FastZombie Max", 10).getInt();
		FlyProb = config.get(CATEGORY_Mobspawn, "Fly Prob", 3).getInt();
		FlyMin = config.get(CATEGORY_Mobspawn, "Fly Min", 1).getInt();
		FlyMax = config.get(CATEGORY_Mobspawn, "Fly Max", 4).getInt();
		CreeperDrillerProb = config.get(CATEGORY_Mobspawn, "CreeperDriller Prob", 1).getInt();
		CreeperDrillerMin = config.get(CATEGORY_Mobspawn, "CreeperDriller Min", 1).getInt();
		CreeperDrillerMax = config.get(CATEGORY_Mobspawn, "CreeperDriller Max", 2).getInt();
		FlyingCreeperProb = config.get(CATEGORY_Mobspawn, "FlyingCreeper Prob", 1).getInt();
		FlyingCreeperMin = config.get(CATEGORY_Mobspawn, "FlyingCreeper Min", 1).getInt();
		FlyingCreeperMax = config.get(CATEGORY_Mobspawn, "FlyingCreeper Max", 2).getInt();
		CrazyGuyProb = config.get(CATEGORY_Mobspawn, "CrazyGuy Prob", 1).getInt();
		CrazyGuyMin = config.get(CATEGORY_Mobspawn, "CrazyGuy Min", 1).getInt();
		CrazyGuyMax = config.get(CATEGORY_Mobspawn, "CrazyGuy Max", 2).getInt();

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
		GameRegistry.registerTileEntity(TileEntityBlockSpotLight.class, "TileEntityBlockSpotLight");
		GameRegistry.registerTileEntity(TileEntityBlockTrail.class, "TileEntityBlockTrail");
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
