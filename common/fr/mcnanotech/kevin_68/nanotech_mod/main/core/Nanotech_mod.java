package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.creativetab.CreativetabItems;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.NanotechEntity;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventSound;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechOther;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilListerJukebox;

@Mod(modid = "Nanotech_mod", name = "Nanotech mod", version = "@VERSION@", dependencies = "required-after:FFMTLIBS")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"NTM|smoker", "NTM|jumper", "NTM|saber"}, packetHandler = PacketHandler.class)
public class Nanotech_mod
{
	// Instance
	@Instance("Nanotech_mod")
	public static Nanotech_mod modInstance;
	// Proxy
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.main.core.CommonProxy")
	public static CommonProxy proxy;

	// Block IDs
	public static int portalID, portalFrameID, grassID, fakeOreID, speedID, jumperID, multiplierID, smokerID, barbedWireID, nanoWoodID, nanoLeavesID, nanoSaplingsID, nanoPlanksID, nanoOreID, confusionID, fallingID, notFallingID, sodiumID, mossyStoneID, theDeathHeadID, listerJukeboxID, liquidNitrogenID, nanoFenceID, nanoStairsID, nanoSlabSingleID, nanoSlabDoubleID, satID, nukeStairsID, nukeID,
			presentID, portableChestID;

	// Item IDs
	public static int nanotechItemID, superBottleOfXpID, diamondBowID, emeraldBowID, nanomiteBowID, nanomiteAxeID, nanomitePickaxeID, nanomiteShovelID, nanomiteHoeID, nanomiteSwordID, nanomiteHelmetID, nanomiteChestPlateID, nanomiteLegginsID, nanomiteBootsID, mysteriousHelmetID, mysteriousChestPlateID, mysteriousLegginsID, mysteriousBootsID, nanoDiscID, edibleFleshID, rottenChunkID, scytheID,
			crazyGlassesID, debugID, altersID, nitrogenBucketID, reinforcedFishingRodID, crazyGlassesGunID, lightSaberID;

	// Dimension and biome
	public static int dimensionID;
	public static int nanotechBiomeID, nitrogenOceanID;
	public static int structure1Prob, structure2Prob, structure3Prob, structure4Prob, structure5Prob, structure6Prob;

	// Recipe configuration
	public static boolean hardRecipe;

	// Mobs configuration
	public static boolean theDeathSpawn, multipleExplosion;
	public static int explosionRadius, timeUntilNextArrow;
	public static int superZombieProb, superZombieMin, superZombieMax, superSkeletonProb, superSkeletonMin, superSkeletonMax, superCreeperProb, superCreeperMin, superCreeperMax, superEndermanProb, superEndermanMin, superEndermanMax, fastZombieProb, fastZombieMin, fastZombieMax, flyProb, flyMin, flyMax, creeperDrillerProb, creeperDrillerMin, creeperDrillerMax, flyingCreeperProb, flyingCreeperMin,
			flyingCreeperMax, crazyGuyProb, crazyGuyMin, crazyGuyMax;

	// Configuration Category
	public static final String CATEGORY_OTHER = "Other configs";
	public static final String CATEGORY_MOB_CFG = "Mobs configs";
	public static final String CATEGORY_MOB_SPAWN = "Mobs spawn";
	public static final String CATEGORY_WORLD = "World";

	// Creative tabs
	public static CreativetabBlock CREATIVE_TAB_B = new CreativetabBlock("NanotechModBlocks");
	public static CreativetabItems CREATIVE_TAB_I = new CreativetabItems("NanotechModItems");

	// log
	public static Logger nanoLog;

	@EventHandler
	public void PreInitNanotech_mod(FMLPreInitializationEvent event)
	{
		nanoLog = event.getModLog();
		if(event.getSide().isClient())
		{
			UtilListerJukebox.scanFolder(Minecraft.getMinecraft());
			MinecraftForge.EVENT_BUS.register(new EventSound());
		}

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			portalID = cfg.getBlock("Portal", 1000).getInt();
			portalFrameID = cfg.getBlock("Portal Frame", 1001).getInt();
			grassID = cfg.getTerrainBlock("block", "Grass", 250, "Grass is used in terrain gen, ID must be less than 256").getInt();
			fakeOreID = cfg.getBlock("Fake diamond", 1002).getInt();
			speedID = cfg.getBlock("Booster and Retarder", 1003).getInt();
			jumperID = cfg.getBlock("Jumper", 1004).getInt();
			multiplierID = cfg.getBlock("Multiplier", 1005).getInt();
			smokerID = cfg.getBlock("Smoker", 1006).getInt();
			barbedWireID = cfg.getBlock("Barbed Wire", 1007).getInt();
			nanoWoodID = cfg.getBlock("Nano Wood", 1008).getInt();
			nanoLeavesID = cfg.getBlock("Nano Leaves", 1009).getInt();
			nanoSaplingsID = cfg.getBlock("Nano Saplings", 1010).getInt();
			nanoPlanksID = cfg.getBlock("Nano Planks", 1011).getInt();
			nanoOreID = cfg.getBlock("Ore", 1012).getInt();
			confusionID = cfg.getBlock("Confusion", 1013).getInt();
			fallingID = cfg.getBlock("Falling Blocks", 1014).getInt();
			notFallingID = cfg.getBlock("Not Falling Blocks", 1015).getInt();
			sodiumID = cfg.getBlock("Sodium", 1016).getInt();
			mossyStoneID = cfg.getBlock("Mossy Stone", 1017).getInt();
			theDeathHeadID = cfg.getBlock("TheDeathHead", 1018).getInt();
			listerJukeboxID = cfg.getBlock("ListerJukebox", 1020).getInt();
			liquidNitrogenID = cfg.getTerrainBlock("block", "Block Liquid Nitrogen", 251, "used in terrain gen, ID must be less than 256").getInt();
			nanoFenceID = cfg.getBlock("Nano Fence", 1021).getInt();
			nanoStairsID = cfg.getBlock("Nano Stairs", 1022).getInt();
			nanoSlabSingleID = cfg.getBlock("Nano Slab Single", 1023).getInt();
			nanoSlabDoubleID = cfg.getBlock("Nano Slab Double", 1024).getInt();
			satID = cfg.getBlock("Satelite", 1025).getInt();
			nukeStairsID = cfg.getBlock("Nuke stairs", 1026).getInt();
			nukeID = cfg.getBlock("Nuke", 1027).getInt();
			presentID = cfg.getBlock("Present", 1028).getInt();
			portableChestID = cfg.getBlock("Portable Chest", 1029).getInt();

			nanotechItemID = cfg.getItem("Main Nanotech ID", 5000).getInt();
			superBottleOfXpID = cfg.getItem("Super Bottle of xp", 5001).getInt();
			diamondBowID = cfg.getItem("Diamond bow", 5002).getInt();
			emeraldBowID = cfg.getItem("Emerald bow", 5003).getInt();
			nanomiteBowID = cfg.getItem("Nanomite bow", 5004).getInt();
			nanomiteAxeID = cfg.getItem("Nanomite Axe", 5005).getInt();
			nanomitePickaxeID = cfg.getItem("Nanomite Pickaxe", 5006).getInt();
			nanomiteShovelID = cfg.getItem("Nanomite Shovel", 5007).getInt();
			nanomiteHoeID = cfg.getItem("Nanomite Hoe", 5008).getInt();
			nanomiteSwordID = cfg.getItem("Nanomite Sword", 5009).getInt();
			nanomiteHelmetID = cfg.getItem("Nanomite Helmet", 5010).getInt();
			nanomiteChestPlateID = cfg.getItem("Nanomite Chestplate", 5011).getInt();
			nanomiteLegginsID = cfg.getItem("Nanomite Leggins", 5012).getInt();
			nanomiteBootsID = cfg.getItem("Nanomite Boots", 5013).getInt();
			mysteriousHelmetID = cfg.getItem("Mysterious Helmet", 5014).getInt();
			mysteriousChestPlateID = cfg.getItem("Mysterious Chestplate", 5015).getInt();
			mysteriousLegginsID = cfg.getItem("Mysterious Leggins", 5016).getInt();
			mysteriousBootsID = cfg.getItem("Mysterious Boots", 5017).getInt();
			edibleFleshID = cfg.getItem("Edible Flesh", 5018).getInt();
			rottenChunkID = cfg.getItem("Chunk of rottenflesh", 5019).getInt();
			scytheID = cfg.getItem("Scythe", 5020).getInt();
			crazyGlassesID = cfg.getItem("CrazyGlasses", 5021).getInt();
			debugID = cfg.getItem("Debug Item", 5024).getInt();
			altersID = cfg.getItem("Alters", 5025).getInt();
			nanoDiscID = cfg.getItem("Nanodisc", 5026).getInt();
			nitrogenBucketID = cfg.getItem("Liquid Nitrogen Bucket", 5027).getInt();
			reinforcedFishingRodID = cfg.getItem("Reinforced Fishing Rod", 5028).getInt();
			crazyGlassesGunID = cfg.getItem("Crazy Glasses Gun", 5029).getInt();
			lightSaberID = cfg.getItem("Light Saber", 5030).getInt();

			dimensionID = cfg.get("World", "Dimension ID", 19).getInt();
			nanotechBiomeID = cfg.get("World", "Biome ID", 100).getInt();
			nitrogenOceanID = cfg.get("World", "Nitrogen Ocean", 101).getInt();

			hardRecipe = cfg.get(CATEGORY_OTHER, "Hard recipes", false).getBoolean(false);

			multipleExplosion = cfg.get(CATEGORY_MOB_CFG, "Multiple Explosion (CreeperDriller)", true).getBoolean(true);
			explosionRadius = cfg.get(CATEGORY_MOB_CFG, "Explosion Radius (SuperCreeper)", 5).getInt();
			timeUntilNextArrow = cfg.get(CATEGORY_MOB_CFG, "Time Until New Arrow (SuperSkeleton)", 3).getInt();

			superZombieProb = cfg.get(CATEGORY_MOB_SPAWN, "SuperZombie Prob", 1).getInt();
			superZombieMin = cfg.get(CATEGORY_MOB_SPAWN, "SuperZombie Min", 1).getInt();
			superZombieMax = cfg.get(CATEGORY_MOB_SPAWN, "SuperZombie Max", 2).getInt();
			superSkeletonProb = cfg.get(CATEGORY_MOB_SPAWN, "SuperSkeleton Prob", 1).getInt();
			superSkeletonMin = cfg.get(CATEGORY_MOB_SPAWN, "SuperSkeleton Min", 1).getInt();
			superSkeletonMax = cfg.get(CATEGORY_MOB_SPAWN, "SuperSkeleton Max", 2).getInt();
			superCreeperProb = cfg.get(CATEGORY_MOB_SPAWN, "SuperCreeper Prob", 1).getInt();
			superCreeperMin = cfg.get(CATEGORY_MOB_SPAWN, "SuperCreeper Min", 1).getInt();
			superCreeperMax = cfg.get(CATEGORY_MOB_SPAWN, "SuperCreeper Max", 2).getInt();
			superEndermanProb = cfg.get(CATEGORY_MOB_SPAWN, "SuperEnderman Prob", 1).getInt();
			superEndermanMin = cfg.get(CATEGORY_MOB_SPAWN, "SuperEnderman Min", 1).getInt();
			superEndermanMax = cfg.get(CATEGORY_MOB_SPAWN, "SuperEnderman Max", 2).getInt();
			fastZombieProb = cfg.get(CATEGORY_MOB_SPAWN, "FastZombie Prob", 1).getInt();
			fastZombieMin = cfg.get(CATEGORY_MOB_SPAWN, "FastZombie Min", 5).getInt();
			fastZombieMax = cfg.get(CATEGORY_MOB_SPAWN, "FastZombie Max", 10).getInt();
			flyProb = cfg.get(CATEGORY_MOB_SPAWN, "Fly Prob", 3).getInt();
			flyMin = cfg.get(CATEGORY_MOB_SPAWN, "Fly Min", 1).getInt();
			flyMax = cfg.get(CATEGORY_MOB_SPAWN, "Fly Max", 4).getInt();
			creeperDrillerProb = cfg.get(CATEGORY_MOB_SPAWN, "CreeperDriller Prob", 1).getInt();
			creeperDrillerMin = cfg.get(CATEGORY_MOB_SPAWN, "CreeperDriller Min", 1).getInt();
			creeperDrillerMax = cfg.get(CATEGORY_MOB_SPAWN, "CreeperDriller Max", 2).getInt();
			flyingCreeperProb = cfg.get(CATEGORY_MOB_SPAWN, "FlyingCreeper Prob", 1).getInt();
			flyingCreeperMin = cfg.get(CATEGORY_MOB_SPAWN, "FlyingCreeper Min", 1).getInt();
			flyingCreeperMax = cfg.get(CATEGORY_MOB_SPAWN, "FlyingCreeper Max", 2).getInt();
			crazyGuyProb = cfg.get(CATEGORY_MOB_SPAWN, "CrazyGuy Prob", 1).getInt();
			crazyGuyMin = cfg.get(CATEGORY_MOB_SPAWN, "CrazyGuy Min", 1).getInt();
			crazyGuyMax = cfg.get(CATEGORY_MOB_SPAWN, "CrazyGuy Max", 2, "Set the probability to 0 to disable the mob, max = maximum spawn group and min = minimum spawn group").getInt();
			theDeathSpawn = cfg.get(CATEGORY_MOB_SPAWN, "Enable TheDeath", true).getBoolean(true);

			structure1Prob = cfg.get(CATEGORY_WORLD, "Structure 1 probability", 2).getInt();
			structure2Prob = cfg.get(CATEGORY_WORLD, "Structure 2 probability", 2).getInt();
			structure3Prob = cfg.get(CATEGORY_WORLD, "Structure 3 probability", 2).getInt();
			structure4Prob = cfg.get(CATEGORY_WORLD, "Structure 4 probability", 2).getInt();
			structure5Prob = cfg.get(CATEGORY_WORLD, "Structure 5 probability", 2).getInt();
			structure6Prob = cfg.get(CATEGORY_WORLD, "Structure 6 probability", 2).getInt();
		}
		catch(Exception ex)
		{
			nanoLog.severe("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}

		NanotechDamageSource.loadDamageSource();
		NanotechOther.registerLiquid(0);
		NanotechBlock.initBlock();
		NanotechBlock.blockRegistry();
		NanotechItem.initItem();
		NanotechItem.registerItem();
		NanotechAchievement.initAchievement();
		NanotechOther.registerLiquid(1);

	}

	// Initialization
	@EventHandler
	public void InitNanotech_mod(FMLInitializationEvent event)
	{
		NanotechOther.registerWorld();
		NanotechOther.registerPotion();
		proxy.registerItemRenders();
		proxy.registerTileEntityRenders();
		NanotechOther.registerGuiAndTileEntity();
		NanotechEntity.mobs();
		proxy.registerModRenders();
		NanotechEntity.otherEntity();
		proxy.registerEntityRenders();
		NanotechOther.registerForgeDictionary();
		NanotechOther.registerBlockHarvestlevel();
		NanotechOther.registerEvent();
		proxy.registerTickHandler();

		GameRegistry.addRecipe(new INanotechRecipe());
	}

	@EventHandler
	public void PostInitNanotech_mod(FMLPostInitializationEvent event)
	{
		proxy.registerOverlay();

		NanotechRecipe.InitCommonRecipes();
		if(hardRecipe)
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
}