package gregtechmod.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.Loader;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This File contains the functions used to get Items and add Recipes. Please do not include this File in your Moddownload as it maybe ruins compatiblity, like with the IC2-API
 * You may just copy those Functions into your Code, or better call them via invocation.
 * 
 * The whole API is the basic construct of my Mod. Everything is dependent on it.
 * I change things quite often so please don't include any File inside your Mod, unless it's an Interface. Interfaces are not going to be changed during a MC-Version
 * Since some Authors were stupid enough to break this simple Rule, I added Version checks to force it.
 * 
 * In these Folders are many useful Functions. You can use them via invocation if you want.
 * I know not everything is compilable due to API's of other Mods, or in case of the Config, direct access to GT_Mod, but these are easy to fix in your Setup.
 * 
 * You can use this to learn about Modding, but I would recommend simpler Mods.
 * You may even copypaste Code from these API-Files into your Mod, as I have nothing against that, but you should look exactly at what you are copying.
 * 
 * @author Gregorius Techneticies
 */
public class GregTech_API {
	/** For the API Version check */
	public static volatile int VERSION = 309;
	
	/** The Mod Object itself. That is the GT_Mod-Object. It's needed for me, to open GUI's and similar. */
	
	/** These Lists are getting executed at their respective timings. Useful if you have to do things right before/after I do them, without having to control the load order. Add your "Commands" in the Constructor or in a static Code Block of your Mods Main Class. These are not Threaded, I just use a native Java Interface for their execution. Implement just the Method run() and everything should work */
	public static List<Runnable> sBeforeGTPreload = new ArrayList<Runnable>(), sAfterGTPreload = new ArrayList<Runnable>(), sBeforeGTLoad = new ArrayList<Runnable>(), sAfterGTLoad = new ArrayList<Runnable>(), sBeforeGTPostload = new ArrayList<Runnable>(), sAfterGTPostload = new ArrayList<Runnable>(), sBeforeGTServerstart = new ArrayList<Runnable>(), sAfterGTServerstart = new ArrayList<Runnable>(), sBeforeGTServerstop = new ArrayList<Runnable>(), sAfterGTServerstop = new ArrayList<Runnable>(), sGTCoverload = new ArrayList<Runnable>(), sGTBlockIconload = new ArrayList<Runnable>(), sGTItemIconload = new ArrayList<Runnable>();
	
	/** The Icon Registers from Blocks and Items. They will get set right before the corresponding Icon Load Phase as executed in the Runnable List above. */
	public static Object sBlockIcons, sItemIcons;
	
	/** Configured Booleans */
	public static boolean DEBUG_MODE = false, SECONDARY_DEBUG_MODE = false, UE_ENERGY_COMPATIBILITY = true;
	
	/** The Configuration Object */
	
	/** Because Minecraft changed it from -1 to that Value */
	public static final short ITEM_WILDCARD_DAMAGE = OreDictionary.WILDCARD_VALUE;
	
	/** The MetaTileEntity-ID-List-Length */
	public static final short MAXIMUM_METATILE_IDS = Short.MAX_VALUE - 1;
	
	/** Icon which represents failed rendering */
	public static Icon FAIL_ICON = null;
	
	
	/**
	 * A List of all registered MetaTileEntities
	 * 
	 *      0 -  2047 are reserved for GregTech.
	 *   2048 -  2559 are reserved for OvermindDL.
	 *   2560 -  3071 are reserved for Immibis, if he decides to use it.
	 *   IDs >= 3072 are currently free.
	 *  
	 * Contact me if you need a free ID-Range, which doesn't conflict with other Addons.
	 * You could make an ID-Config, but we all know, what "stupid" customers think about conflicting ID's
	 */
	
	/** FilePaths and similar Strings */
    public static final String GENERIC_CHANNEL = "gregtech", TILEENTITY_PACKET_CHANNEL = "GTTile", IC2_MOD_ID = "ic2", IC2_TEXTURE_PATH = IC2_MOD_ID + ":", MOD_ID = "GregTech_Addon", TEXTURE_PATH = MOD_ID + ":", TEXTURE_FOLDER = "/mods/" + MOD_ID + "/textures/", GUI_PATH = TEXTURE_FOLDER + "gui/";
    
	/** Initialized by the Block creation. */
	public static final Block[] sBlockList = new Block[5];
	
	/** Initialized by the Item creation. */
    public static final Item[] sItemList = new Item[256];
    
	/** Getting assigned by the Config */
	public static boolean sConstantEnergy = true, sMachineFlammable = true, sMachineNonWrenchExplosions = true, sMachineRainExplosions = true, sMachineThunderExplosions = true, sMachineFireExplosions = true, sMachineWireFire = true;

	/** Getting assigned by the Config */
	public static boolean sInterDimensionalTesseractAllowed = false, sPreloadStarted = false, sPreloadFinished = false, sLoadStarted = false, sLoadFinished = false, sPostloadStarted = false, sPostloadFinished = false;
	
	/** The Icon List for Covers */
	public static final Map<Integer, Icon> sCovers = new HashMap<Integer, Icon>();
	

	/** The List of Blocks, which can conduct Machine Block Updates */
    public static final Map<Integer, Integer> sMachineIDs = new HashMap<Integer, Integer>();
    
	/** The Redstone Frequencies */
    public static final Map<Integer, Byte> sWirelessRedstone = new HashMap<Integer, Byte>();
    
	/** The IDSU Frequencies */
	public static final Map<Integer, Integer> sIDSUList = new HashMap<Integer, Integer>();
	
	/** A List of all Books, which were created using @GT_Utility.getWrittenBook the Title is the Key Value */
	public static final Map<String, ItemStack> sBookList = new HashMap<String, ItemStack>();
	
	/** The List of Tools, which can be used. Accepts regular damageable Items and Electric Items */
	public static final List<Integer> sToolList = new ArrayList<Integer>(), sCrowbarList = new ArrayList<Integer>(), sScrewdriverList = new ArrayList<Integer>(), sWrenchList = new ArrayList<Integer>(), sSoftHammerList = new ArrayList<Integer>(), sHardHammerList = new ArrayList<Integer>(), sSolderingToolList = new ArrayList<Integer>(), sSolderingMetalList = new ArrayList<Integer>();
	
	/** 
	 * The List of Dimensions, which are Whitelisted for the Teleporter. This list should not contain other Planets.
	 * Mystcraft Dimensions and other Dimensional Things should be allowed.
	 * Mystcraft and Twilight Forest are automatically considered a Dimension, without being in this List.
	 */
	public static final List<Integer> sDimensionalList = new ArrayList<Integer>();
	
	/** Lists of Biome Names, which can spawn these Materials usually */
	public static final List<String> sContinentalWaterList = new ArrayList<String>(), sTetrahedriteList = new ArrayList<String>(), sCassiteriteList = new ArrayList<String>(), sRubyList = new ArrayList<String>(), sSapphireList = new ArrayList<String>(), sBauxiteList = new ArrayList<String>();
	
	/** Lists of all the active World generation Features, these are getting Initialized in Postload! */
	
	/** Gets true in the PreInitPhase of the GregTech-Addon */
	public static boolean isGregTechLoaded() {return Loader.isModLoaded("GregTech_Addon");}
	
	/** Energy Values for Voltage Classifications */
	public static final int VOLTAGE_ULTRALOW = 8, VOLTAGE_LOW = 32, VOLTAGE_MEDIUM = 128, VOLTAGE_HIGH = 512, VOLTAGE_EXTREME = 2048, VOLTAGE_QUADEXTREME = 8192, VOLTAGE_MEGA = 32768, VOLTAGE_ULTIMATE = 1000000;
	
	/** If you have to give something a World Parameter but there is no World... */
	public static World sDummyWorld;
	
	/**
	 * Gets a Block from my Addon.
	 * @param aIndex Index of my Item:
	 * 0 Standardblock,
	 * 1 Machineblock,
	 * 2 Oreblock,
	 * 3 That glowing thing from my Lighthelmet.
	 * @param aAmount Amount of the Item in the returned Stack
	 * @param aMeta The Metavalue of the Block
	 * @return The ItemStack you ordered, if not then look at the Log.
	 */
	public static ItemStack getGregTechBlock(int aIndex, int aAmount, int aMeta) {
		if (isGregTechLoaded()) {
			try {
				return (ItemStack)Class.forName("gregtechmod.GT_Mod").getMethod("getGregTechBlock", int.class, int.class, int.class).invoke(null, aIndex, aAmount, aMeta);
			} catch (Exception e) {}
		}
		return null;
	}
	
	
	/**
	 * Gets an Item from my Addon. The Indizes are the same, as the ones at the items.png
	 * @param aIndex Index of the Item, see the "items.png".
	 * ID's of MetaItems:
	 * 0 = GT_MetaItem_Material
	 * 1 = GT_MetaItem_Dust
	 * 2 = GT_MetaItem_Cell
	 * 3 = GT_MetaItem_Component
	 * 4 = GT_MetaItem_SmallDust
	 * 5 = GT_MetaItem_Nugget
	 * 
	 * 13 = GT_MetaItem_Liquid
	 * 14 = GT_MetaItem_Gas
	 * 15 = GT_MetaItem_Plasma
	 * @param aAmount Amount of the Item in the returned Stack
	 * @return The ItemStack you ordered, if not then look at the Log.
	 */
	public static ItemStack getGregTechItem(int aIndex, int aAmount, int aMeta) {
		if (isGregTechLoaded()) {
			try {
				return (ItemStack)Class.forName("gregtechmod.GT_Mod").getMethod("getGregTechItem", int.class, int.class, int.class).invoke(null, aIndex, aAmount, aMeta);
			} catch (Exception e) {}
		}
		return null;
	}
	
	/**
	 * You want OreDict-Unification for YOUR Mod/Addon, when GregTech is installed? This Function is especially for YOU.
	 * Call this Function after the load-Phase, as I register the the most of the Unification at that Phase (Redpowers Storageblocks are registered at postload).
	 * A recommended use of this Function is inside your Recipe-System itself (if you have one), as the unification then makes 100% sure, that every added non-unificated Output gets automatically unificated.
	 * 
	 * I will personally make sure, that only common prefixes of Ores get registered at the Unificator, as of now there are:
	 * pulp, dust, dustSmall, ingot, nugget, gem, ore and block
	 * If another Mod-Author messes these up, then it's not my fault and it's especially not your fault. As these are commonly used prefixes.
	 * 
	 * This Unificator-API-Function uses the same Functions I use, for unificating Items. So if there is something messed up (very unlikely), then everything is messed up.
	 * 
	 * You shouldn't use this to unificate the Inputs of your Recipes, this is only meant for the Outputs.
	 * 
	 * @param aOreStack the Stack you want to get unificated. It is stackSize Sensitive.
	 * @return Either an unificated Stack or the stack you toss in, but it should never be null, unless you throw a Nullpointer into it.
	 */
	
	/**
	 * Adds a FusionreactorRecipe
	 * @param aInput1 = first Input (not null, and respects StackSize)
	 * @param aInput2 = second Input (not null, and respects StackSize)
	 * @param aOutput = Output of the Fusion (can be null, and respects StackSize)
	 * @param aFusionDurationInTicks = How many ticks the Fusion lasts (must be > 0)
	 * @param aFusionEnergyPerTick = The EU generated per Tick (can even be negative!)
	 * @param aEnergyNeededForStartingFusion = EU needed for heating the Reactor up (must be >= 0)
	 * @return true if the Recipe got added, otherwise false.
	 */
	public static boolean addFusionReactorRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput, int aFusionDurationInTicks, int aFusionEnergyPerTick, int aEnergyNeededForStartingFusion) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addFusionReactorRecipe", ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput, aFusionDurationInTicks, aFusionEnergyPerTick, aEnergyNeededForStartingFusion);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}

	/**
	 * Adds a Centrifuge Recipe
	 * @param aInput1 must be != null
	 * @param aCellInput this is for the needed Cells, > 0 for Tincellcount, < 0 for negative Fuelcancount, == 0 for nothing
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 * @param aOutput3 can be null
	 * @param aOutput4 can be null
	 * @param aDuration must be > 0
	 */
	public static boolean addCentrifugeRecipe(ItemStack aInput1, int aCellInput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, int aDuration) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addCentrifugeRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class).invoke(null, aInput1, aCellInput, aOutput1, aOutput2, aOutput3, aOutput4, aDuration);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}

	/**
	 * Adds a Electrolyzer Recipe
	 * @param aInput1 must be != null
	 * @param aCellInput this is for the needed Cells, > 0 for Tincellcount, < 0 for negative Fuelcancount, == 0 for nothing
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 * @param aOutput3 can be null
	 * @param aOutput4 can be null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addElectrolyzerRecipe(ItemStack aInput1, int aCellInput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addElectrolyzerRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aCellInput, aOutput1, aOutput2, aOutput3, aOutput4, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}

	/**
	 * Adds a Chemical Recipe
	 * @param aInput1 must be != null
	 * @param aInput2 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 */
	public static boolean addChemicalRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addChemicalRecipe", ItemStack.class, ItemStack.class, ItemStack.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aDuration);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Vacuum Freezer Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 */
	public static boolean addVacuumFreezerRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addVacuumFreezerRecipe", ItemStack.class, ItemStack.class, int.class).invoke(null, aInput1, aOutput1, aDuration);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Blast Furnace Recipe
	 * @param aInput1 must be != null
	 * @param aInput2 can be null
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 * @param aLevel should be > 0 is the minimum Heat Level needed for this Recipe
	 */
	public static boolean addBlastRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt, int aLevel) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addBlastRecipe", ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aOutput2, aDuration, aEUt, aLevel);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}

	/**
	 * Adds an Implosion Compressor Recipe
	 * @param aInput1 must be != null
	 * @param aInput2 amount of ITNT, should be > 0
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 */
	public static boolean addImplosionRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addImplosionRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class).invoke(null, aInput1, aInput2, aOutput1, aOutput2);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Grinder Recipe
	 * @param aInput1 must be != null
	 * @param aCellInput this is for the needed Cells, > 0 for Tincell count, < 0 for negative Water Cell count, == 0 for nothing
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 * @param aOutput3 can be null
	 * @param aOutput4 can be null
	 */
	public static boolean addGrinderRecipe(ItemStack aInput1, int aCellInput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addGrinderRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class).invoke(null, aInput1, aCellInput, aOutput1, aOutput2, aOutput3, aOutput4);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Sawmill Recipe
	 * @param aInput1 must be != null
	 * @param aCellInput this is for the needed Cells, > 0 for Tincell count, < 0 for negative Water Cell count, == 0 for nothing
	 * @param aOutput1 must be != null
	 * @param aOutput2 can be null
	 * @param aOutput3 can be null
	 */
	public static boolean addSawmillRecipe(ItemStack aInput1, int aCellInput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addSawmillRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class, ItemStack.class).invoke(null, aInput1, aCellInput, aOutput1, aOutput2, aOutput3);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}

	/**
	 * Adds a Plate Bending Machine Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addBenderRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addBenderRecipe", ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aOutput1, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Wiremill Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addWiremillRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addWiremillRecipe", ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aOutput1, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds an Alloy Smelter Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addAlloySmelterRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addAlloySmelterRecipe", ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a CNC-Machine Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addCNCRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addCNCRecipe", ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aOutput1, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Circuit Assembler Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0
	 * @param aEUt should be > 0
	 */
	public static boolean addAssemblerRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addAssemblerRecipe", ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Distillation Tower Recipe
	 */
	public static boolean addDistillationRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addDistillationRecipe", ItemStack.class, int.class, ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aOutput2, aOutput3, aOutput4, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Canning Machine Recipe
	 * @param aInput1 must be != null
	 * @param aOutput1 must be != null
	 * @param aDuration must be > 0, 100 ticks is standard.
	 * @param aEUt should be > 0, 1 EU/t is standard.
	 */
	public static boolean addCannerRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addCannerRecipe", ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aInput2, aOutput1, aOutput2, aDuration, aEUt);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Fuel for My Generators
	 * @param aInput1 must be != null
	 * @param aOutput1 can be null
	 * @param aEU EU per MilliBucket. If no Liquid Form of this Container is available, then it will give you EU*1000 per Item.
	 * @param aType 0 = Diesel; 1 = Gas Turbine; 2 = Thermal; 3 = DenseFluid; 4 = Plasma; 5 = Magic; And if something is unclear or missing, then look at the GT_Recipe-Class
	 */
	public static boolean addFuel(ItemStack aInput1, ItemStack aOutput1, int aEU, int aType) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addFuel", ItemStack.class, ItemStack.class, int.class, int.class).invoke(null, aInput1, aOutput1, aEU, aType);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a BlockID to the List of the Minable Blocks by the Jackhammer
	 * @param aBlock
	 */
	public static boolean addJackHammerMinableBlock(Block aBlock) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addJackHammerMinableBlock", Block.class).invoke(null, aBlock);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Sound to the Sonictron9001
	 * you should NOT call this in the preInit-Phase!
	 * @param aItemStack = The Item you want to display for this Sound
	 * @param aSoundName = The Name of the Sound in the resources/newsound-folder like Vanillasounds
	 * @return true if the Sound got added, otherwise false.
	 */
	public static boolean addSonictronSound(ItemStack aItemStack, String aSoundName) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addSonictronSound", ItemStack.class, String.class).invoke(null, aItemStack, aSoundName);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Description to the Computercube
	 * you should call this in the postInit-Phase!
	 * @param aItemStack = An Array of 14 ItemStacks not more, not less. The Stacks themself can be null if needed. The last 9 Stacks are showing a Craftingrecipe in the top right Corner if one of them is != null.
	 * @param aText = An Array of exactly 17 Lines of Text. 0 = First Line; 16 = Last displayable Line.
	 * @return true if the Descripion got added, otherwise false.
	 */
	public static boolean addComputercubeDescriptionSet(ItemStack[] aItemStack, String[] aText) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("addComputercubeDescriptionSet", ItemStack[].class, String[].class).invoke(null, aItemStack, aText);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Causes a Machineblock Update
	 * This update will cause surrounding Multi-Block Machines to update their Configuration.
	 * You should call this Function in @Block.breakBlock and in @Block.onBlockAdded of your Machine.
	 * @param aWorld is being the World
	 * @param aX is the X-Coord of the update causing Block
	 * @param aY is the Y-Coord of the update causing Block
	 * @param aZ is the Z-Coord of the update causing Block
	 */
	public static boolean causeMachineUpdate(World aWorld, int aX, int aY, int aZ) {
		if (isGregTechLoaded()) {
			try {
				Class.forName("gregtechmod.GT_Mod").getMethod("causeMachineUpdate", World.class, int.class, int.class, int.class).invoke(null, aWorld, aX, aY, aZ);
				return true;
			} catch (Exception e) {}
		}
		return false;
	}
	
	/**
	 * Adds a Multi-Machine Block, like my Machine Casings for example.
	 * You should call @causeMachineUpdate in @Block.breakBlock and in @Block.onBlockAdded of your registered Block.
	 * You don't need to register TileEntities which implement @IMachineBlockUpdateable
	 * @param aID the ID of your Block
	 * @param aMeta the Metadata of the Blocks as Bitmask! -1 for all Metavalues
	 */
	public static boolean registerMachineBlock(int aID, int aMeta) {
		sMachineIDs.put(aID, aMeta);
		return true;
	}
	
	/**
	 * if this Block is a Machine Update Conducting Block
	 */
	public static boolean isMachineBlock(int aID, int aMeta) {
		return (sMachineIDs.containsKey(aID) && (sMachineIDs.get(aID) & (1 << aMeta)) != 0);
	}
	
	/**
	 * Creates a new Coolant Cell Item for your Nuclear Reactor
	 */

	
	/**
	 * Adds Biomes to the Biome Lists for World Generation
	 */
	static {
		sContinentalWaterList.add(BiomeGenBase.river.biomeName);
		sContinentalWaterList.add(BiomeGenBase.frozenRiver.biomeName);
		sContinentalWaterList.add("Lake");
		sCassiteriteList.add(BiomeGenBase.taiga.biomeName);
		sCassiteriteList.add(BiomeGenBase.taigaHills.biomeName);
		sCassiteriteList.add(BiomeGenBase.icePlains.biomeName);
		sCassiteriteList.add(BiomeGenBase.iceMountains.biomeName);
		sCassiteriteList.add(BiomeGenBase.mushroomIsland.biomeName);
		sCassiteriteList.add(BiomeGenBase.mushroomIslandShore.biomeName);
		sCassiteriteList.add(BiomeGenBase.extremeHills.biomeName);
		sCassiteriteList.add(BiomeGenBase.extremeHillsEdge.biomeName);
		sCassiteriteList.add("Alps");
		sCassiteriteList.add("Glacier");
		sCassiteriteList.add("Ice Wasteland");
		sCassiteriteList.add("Flying Mountains");
		sCassiteriteList.add("Rock Mountains");
		sCassiteriteList.add("Snow Mountains");
		sCassiteriteList.add("Snow Forest");
		sCassiteriteList.add("Tall Pine Forest");
		sCassiteriteList.add("Tundra");
		sCassiteriteList.add("Rock Island");
		sCassiteriteList.add("Snow Island");
		sCassiteriteList.add("Mountain Ridge");
		sCassiteriteList.add("Volcano Island");
		sCassiteriteList.add("Promised Land");
		sTetrahedriteList.add(BiomeGenBase.jungle.biomeName);
		sTetrahedriteList.add(BiomeGenBase.jungleHills.biomeName);
		sTetrahedriteList.add(BiomeGenBase.swampland.biomeName);
		sTetrahedriteList.add(BiomeGenBase.mushroomIsland.biomeName);
		sTetrahedriteList.add(BiomeGenBase.mushroomIslandShore.biomeName);
		sTetrahedriteList.add(BiomeGenBase.extremeHills.biomeName);
		sTetrahedriteList.add(BiomeGenBase.extremeHillsEdge.biomeName);
		sTetrahedriteList.add("Bog");
		sTetrahedriteList.add("Cliffs");
		sTetrahedriteList.add("Valley");
		sTetrahedriteList.add("Canyon");
		sTetrahedriteList.add("Flying Mountains");
		sTetrahedriteList.add("Rock Mountains");
		sTetrahedriteList.add("Jungle Island");
		sTetrahedriteList.add("Rock Island");
		sTetrahedriteList.add("Mountain Ridge");
		sTetrahedriteList.add("Volcano Island");
		sTetrahedriteList.add("Promised Land");
		sRubyList.add(BiomeGenBase.desert.biomeName);
		sRubyList.add(BiomeGenBase.desertHills.biomeName);
		sRubyList.add("Sahel");
		sRubyList.add("Dunes");
		sRubyList.add("Desert Mountains");
		sRubyList.add("Mountainous Desert");
		sRubyList.add("Mountain Ridge");
		sRubyList.add("Savanna");
		sRubyList.add("Savannah");
		sRubyList.add("Shrubland");
		sRubyList.add("Wasteland");
		sRubyList.add("Fire Swamp");
		sRubyList.add("Highlands");
		sRubyList.add("Volcano");
		sRubyList.add("Steppe");
		sRubyList.add("Scrubland");
		sRubyList.add("Prairie");
		sRubyList.add("Lush Desert");
		sRubyList.add("Deadlands");
		sRubyList.add("Badlands");
		sRubyList.add("Dunes");
		sRubyList.add("Mesa");
		sRubyList.add("Outback");
		sRubyList.add("Canyon");
		sRubyList.add("Desert Island");
		sRubyList.add("Volcano Island");
		sRubyList.add("Promised Land");
		sSapphireList.add(BiomeGenBase.ocean.biomeName);
		sSapphireList.add(BiomeGenBase.beach.biomeName);
		sSapphireList.add(BiomeGenBase.frozenOcean.biomeName);
		sSapphireList.add("Twilight Lake");
		sSapphireList.add("Twilight Stream");
		sSapphireList.add("Lake Border");
		sSapphireList.add("Glacier");
		sSapphireList.add("Mangrove");
		sSapphireList.add("Oasis");
		sSapphireList.add("Origin Valley");
		sSapphireList.add("Sacred Springs");
		sSapphireList.add("Tropics");
		sSapphireList.add("Tropical Islands");
		sSapphireList.add("Estuary");
		sSapphireList.add("Promised Land");
		sBauxiteList.add(BiomeGenBase.plains.biomeName);
		sBauxiteList.add(BiomeGenBase.forest.biomeName);
		sBauxiteList.add(BiomeGenBase.forestHills.biomeName);
		sBauxiteList.add("Bald Hill");
		sBauxiteList.add("Forest Island");
		sBauxiteList.add("Pinelands");
		sBauxiteList.add("Highlands");
		sBauxiteList.add("Lowlands");
		sBauxiteList.add("Rainforest");
		sBauxiteList.add("Autumn Woods");
		sBauxiteList.add("Autumn Forest");
		sBauxiteList.add("Birch Forest");
		sBauxiteList.add("Birch Hills");
		sBauxiteList.add("Forested Hills");
		sBauxiteList.add("Forested Island");
		sBauxiteList.add("Green Hills");
		sBauxiteList.add("Meadow");
		sBauxiteList.add("Redwood Forest");
		sBauxiteList.add("Redwood Lush");
		sBauxiteList.add("Woodlands");
		sBauxiteList.add("Twilight Forest");
		sBauxiteList.add("Dense Twilight Forest");
		sBauxiteList.add("Dark Forest");
		sBauxiteList.add("Enchanted Forest");
		sBauxiteList.add("Woodland");
		sBauxiteList.add("Woodlands");
		sBauxiteList.add("Woodland Mountains");
		sBauxiteList.add("Thicket");
		sBauxiteList.add("Seasonal Forest");
		sBauxiteList.add("Redwood Forest");
		sBauxiteList.add("Quagmire");
		sBauxiteList.add("Orchard");
		sBauxiteList.add("Pasture");
		sBauxiteList.add("Mystic Grove");
		sBauxiteList.add("Meadow");
		sBauxiteList.add("Marsh");
		sBauxiteList.add("Maple Woods");
		sBauxiteList.add("Grove");
		sBauxiteList.add("Grassland");
		sBauxiteList.add("Garden");
		sBauxiteList.add("Fungi Forest");
		sBauxiteList.add("Deciduous Forest");
		sBauxiteList.add("Coniferous Forest");
		sBauxiteList.add("Cherry Blossom Grove");
		sBauxiteList.add("Promised Land");
		
		sDimensionalList.add(-1);
		sDimensionalList.add( 0);
		sDimensionalList.add( 1);
	}
}