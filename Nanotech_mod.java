package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = "Nanotech_mod", name = "Nanotech mod", version = "2.0.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Nanotech_mod 
{
	/**
	 * Instance
	 */
	@Mod.Instance("Nanotech_mod")
	public static Nanotech_mod modInstance;
	 
	/**
	 * Proxy
	 */
	@SidedProxy(clientSide="fr.mcnanotech.kevin_68.nanotech_mod.ClientProxy", serverSide="fr.mcnanotech.kevin_68.nanotech_mod.CommonProxy")
	public static CommonProxy proxy;
	
	/**
	 * GUI
	 */
	private Util_GuiHandler guiHandler = new Util_GuiHandler();
	public static int Block_smokepower = 5;
	
	/**
	 * Block statement
	 */
	public static Block Block_portal, Block_portalframe, Block_grass, Block_fakediamond, Block_fakegold;
	public static Block Block_booster;
	public static Block Block_retarder;
	public static Block Block_jumper;
	public static Block Block_multiplier;
	public static Block Block_smoker;
	public static Block Block_trashcan;
	public static Block Block_barbedwire;
	public static Block Block_nanowood;
	public static Block Block_nanoleaves;
	public static Block Block_nanosaplings;
	public static Block Block_nanoplanks;
	public static Block Block_siliconore;
	public static Block Block_stonedecrease;
	public static Block Block_confusion;
	public static Block Block_fallingstone;
	public static Block Block_fallingcobblestone;
	public static Block Block_fallingmossycobblestone;
	public static Block Block_fallingstonebrick;
	public static Block Block_fallingcrackedstonebrick;
	public static Block Block_fallingmossystonebrick;
	public static Block Block_fallingchiseledstonebrick;
	public static Block Block_notfallingsand;
	public static Block Block_notfallinggravel;
	public static Block Block_sodium;
	public static Block Block_slope;
	public static Block Block_mossystone;
	
	
	/**
	 * Items statement
	 */
	public static Item Item_siliconore;
	public static Item Item_stoneofdecrease;
	public static Item Item_mysteriousmaterial;
	public static Item Item_siliconplate;
	public static Item Item_mysteriousingot;
	public static Item Item_superbottleofxp;
	public static Item Item_diamondbow;
	public static Item Item_emeraldbow;
	public static Item Item_nanomitebow;
	public static Item Item_circuit;
	public static Item Item_advencedcircuit;
	public static Item Item_processor;
	public static Item Item_microprocessor;
	public static Item Item_camera;
	public static Item Item_detector;
	public static Item Item_engine;
	public static Item Item_nanomite;
	public static Item Item_nanomiteframe;
	public static Item Item_smallnanomite;
	public static Item Item_nanomiteaxe;
	public static Item Item_nanomitepickaxe;
	public static Item Item_nanomiteshovel;
	public static Item Item_nanomitehoe;
	public static Item Item_nanomitesword;
	public static Item Item_nanomitehelmet;
	public static Item Item_nanomitechestplate;
	public static Item Item_nanomiteleggins;
	public static Item Item_nanomiteboots;
	public static Item Item_mysterioushelmet;
	public static Item Item_mysteriouschestplate;
	public static Item Item_mysteriousleggins;
	public static Item Item_mysteriousboots;
	public static Item Item_nanodisc;
	public static Item Item_yourmusicdisc;
	public static Item Item_yourmusicdisc2;
	public static Item Item_yourmusicdisc3;
	public static Item Item_yourmusicdisc4;
	public static Item Item_yourmusicdisc5;
	public static Item Item_yourmusicdisc6;
	public static Item Item_yourmusicdisc7;
	public static Item Item_yourmusicdisc8;
	public static Item Item_yourmusicdisc9;
	public static Item Item_yourmusicdisc10;
	public static Item Item_yourmusicdisc11;
	public static Item Item_yourmusicdisc12;
	public static Item Item_yourmusicdisc13;
	public static Item Item_yourmusicdisc14;
	public static Item Item_yourmusicdisc15;
	public static Item Item_yourmusicdisc16;
	public static Item Item_edibleflesh;
	public static Item Item_rottenchunk;
	public static Item Item_vide;
	
	/**
	 * Block IDs
	 */
	public static int Block_portalID;
	public static int Block_portalframeID;
	public static int Block_grassID;
	public static int Block_fakediamondID;
	public static int Block_fakegoldID;
	public static int Block_boosterID;
	public static int Block_retarderID;
	public static int Block_jumperID;
	public static int Block_multiplierID;
	public static int Block_smokerID;
	public static int Block_trashcanID;
	public static int Block_barbedwireID;
	public static int Block_nanowoodID;
	public static int Block_nanoleavesID;
	public static int Block_nanosaplingsID;
	public static int Block_nanoplanksID;
	public static int Block_siliconoreID;
	public static int Block_stonedecreaseID;
	public static int Block_confusionID;
	public static int Block_fallingstoneID;
	public static int Block_fallingcobblestoneID;
	public static int Block_fallingmossycobblestoneID;
	public static int Block_fallingstonebrickID;
	public static int Block_fallingcrackedstonebrickID;
	public static int Block_fallingmossystonebrickID;
	public static int Block_fallingchiseledstonebrickID;
	public static int Block_notfallingsandID;
	public static int Block_notfallinggravelID;
	public static int Block_sodiumID;
	public static int Block_mossystoneID;
	
	/**
	 * Item IDs
	 */
	public static int Item_siliconoreID;
	public static int Item_stoneofdecreaseID;
	public static int Item_mysteriousmaterialID;
	public static int Item_siliconplateID;
	public static int Item_mysteriousingotID;
	public static int Item_superbottleofxpID;
	public static int Item_diamondbowID;
	public static int Item_emeraldbowID;
	public static int Item_nanomitebowID;
	public static int Item_circuitID;
	public static int Item_advencedcircuitID;
	public static int Item_processorID;
	public static int Item_microprocessorID;
	public static int Item_cameraID;
	public static int Item_detectorID;
	public static int Item_engineID;
	public static int Item_nanomiteID;
	public static int Item_nanomiteframeID;
	public static int Item_smallnanomiteID;
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
	public static int Item_videID;

	
	/**
	 * Dimension ID
	 */
	public static int dimension = 19;
	
	/**
	 * Biome statement
	 */
	public static BiomeGenBase Nanotechbiome;
	
	/**
	 *Configuration
	 */
	public static boolean Config_hardrecipe;
	
	/**
	 * Mobs configuration
	 */
	public static boolean Config_creeperdrillermultiexplosion;
	public static int Config_supercreeperexplosionradius;
	public static int Config_timeuntilnextarrow_superskeleton;
	public boolean MobSpawn;
	public boolean Creeperdriller;
	public boolean Fastzombie;
	public boolean Fly;
	public boolean Supercreeper;
	public boolean Superenderman;
	public boolean Superskeleton;
	public boolean Superzombie;
	public boolean TheDeath;
	public boolean Flyingcreeper;
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
	
	/**
	 * Discs name
	 */
	public static String nanodiscname = "JedBorg - Surprise";
	public static String Yourdiscname = "Sergey Stepanov - Epic sax guy";
	public static String Yourdiscname2 = "Psy - Gangnam style";
	public static String Yourdiscname3 = "Blue heart - N64";
	public static String Yourdiscname4 = "Headhunterz - Dragonborn";
	public static String Yourdiscname5 = "Windows error remix";
	public static String Yourdiscname6 = "Narwahls";
	public static String Yourdiscname7 = "Biting Elbows - bad motherfucker";
	public static String Yourdiscname8 = "Musique 8";
	public static String Yourdiscname9 = "Musique 9";
	public static String Yourdiscname10 = "Musique 10";
	public static String Yourdiscname11 = "Musique 11";
	public static String Yourdiscname12 = "Musique 12";
	public static String Yourdiscname13 = "Musique 13";
	public static String Yourdiscname14 = "Musique 14";
	public static String Yourdiscname15 = "Musique 15";
	public static String Yourdiscname16 = "Musique 16";
	
	/**
	 * Step sounds
	 */
    public static final StepSound soundPowderFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundWoodFootstep = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundMetalFootstep = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound soundClothFootstep = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound soundSandFootstep = new StepSound("sand", 1.0F, 1.0F);
    public static final StepSound soundSnowFootstep = new StepSound("snow", 1.0F, 1.0F);
	
	/**
	 * Configuration Category
	 */
	public static final String CATEGORY_BlocksID = "Blocks ID";
	public static final String CATEGORY_ItemsID = "Items ID";
	public static final String CATEGORY_Other = "Other configs";
	public static final String CATEGORY_Mobsconfig = "Mobs configs";
	public static final String CATEGORY_Mobspawn = "Mobs spawn";
	
	/**
	 * Creative tabs
	 */
	public static Util_creativetabblock CREATIVE_TAB_B = new Util_creativetabblock("Nanotech mod Blocks");
	public static Util_creativetabitems CREATIVE_TAB_I = new Util_creativetabitems("Nanotech mod Items");
	
	/**
	 * Enum tools and armor material
	 */
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[]{6,6,6,6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[]{6,6,6,6}, 15);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	
	/**
	 * Event and Proxy
	 * @param event
	 */
	@SideOnly(Side.CLIENT)
	@PreInit
	public void PreInitnanotech_modclient(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new Event_bonemeal());
		MinecraftForge.EVENT_BUS.register(new Event_sound());
		//ClientProxy.registerRenderInformation();
	}
	
	/**
	 * Configuration
	 * @param event
	 */
	@PreInit
	public void PreInitnanotech_mod(FMLPreInitializationEvent event) 
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		Block_portalID = config.get(CATEGORY_BlocksID, "Portal", 1000).getInt();
		Block_portalframeID = config.get(CATEGORY_BlocksID, "Portal frame", 1001).getInt();
		Block_grassID = config.get(CATEGORY_BlocksID, "Grass (< 255)", 250).getInt();
		Block_fakediamondID = config.get(CATEGORY_BlocksID, "Fake diamond", 1002).getInt();
		Block_fakegoldID = config.get(CATEGORY_BlocksID, "Fake gold", 1003).getInt();
		Block_boosterID = config.get(CATEGORY_BlocksID, "Booster", 1004).getInt();
		Block_retarderID = config.get(CATEGORY_BlocksID, "Retarder", 1005).getInt();
		Block_jumperID = config.get(CATEGORY_BlocksID, "Jumper", 1006).getInt();
		Block_multiplierID = config.get(CATEGORY_BlocksID, "Multiplier", 1007).getInt();
		Block_smokerID = config.get(CATEGORY_BlocksID, "Smoker", 1008).getInt();
		Block_trashcanID = config.get(CATEGORY_BlocksID, "Trash can", 1009).getInt();
		Block_barbedwireID = config.get(CATEGORY_BlocksID, "Barbed wire", 1014).getInt();
		Block_nanowoodID = config.get(CATEGORY_BlocksID, "Nano Wood", 1015).getInt();
		Block_nanoleavesID = config.get(CATEGORY_BlocksID, "Nano Leaves", 1016).getInt();
		Block_nanosaplingsID = config.get(CATEGORY_BlocksID, "Nano Saplings", 1017).getInt();
		Block_nanoplanksID = config.get(CATEGORY_BlocksID, "Nano Planks", 1018).getInt();
		Block_siliconoreID = config.get(CATEGORY_BlocksID,"Silicon ore", 1019).getInt();
		Block_stonedecreaseID = config.get(CATEGORY_BlocksID,"Stone of decrease ore", 1020).getInt();
		Block_confusionID = config.get(CATEGORY_BlocksID,"Confusion", 1021).getInt();
		Block_fallingstoneID = config.get(CATEGORY_BlocksID,"Falling stone", 1022).getInt();
		Block_fallingcobblestoneID = config.get(CATEGORY_BlocksID,"Falling cobblestone", 1023).getInt();
		Block_fallingmossycobblestoneID = config.get(CATEGORY_BlocksID,"Falling mossy cobblestone", 1024).getInt();
		Block_fallingstonebrickID = config.get(CATEGORY_BlocksID,"Falling stonebrick", 1025).getInt();
		Block_fallingcrackedstonebrickID = config.get(CATEGORY_BlocksID,"Falling cracked stonebrick", 1026).getInt();
		Block_fallingmossystonebrickID = config.get(CATEGORY_BlocksID,"Falling mossy stonebrick", 1027).getInt();
		Block_fallingchiseledstonebrickID = config.get(CATEGORY_BlocksID,"Falling chiseled stonebrick", 1028).getInt();
		Block_notfallingsandID = config.get(CATEGORY_BlocksID,"Not falling sand", 1029).getInt();
		Block_notfallinggravelID = config.get(CATEGORY_BlocksID,"Not falling gravel", 1030).getInt();
		Block_sodiumID = config.get(CATEGORY_BlocksID, "Sodium", 1031).getInt();
		Block_mossystoneID = config.get(CATEGORY_BlocksID, "Mossy stone", 1032).getInt();
		
		Item_siliconoreID = config.get(CATEGORY_ItemsID, "Silicon Ore", 5000).getInt();
		Item_stoneofdecreaseID = config.get(CATEGORY_ItemsID, "Stone of dercrease", 5001).getInt();
		Item_mysteriousmaterialID = config.get(CATEGORY_ItemsID, "Mysterious material", 5002).getInt();
		Item_siliconplateID = config.get(CATEGORY_ItemsID, "Silicon plate", 5003).getInt();
		Item_mysteriousingotID = config.get(CATEGORY_ItemsID, "Mysterious ingot", 5004).getInt();
		Item_superbottleofxpID = config.get(CATEGORY_ItemsID, "Super Bottle of xp", 5005).getInt();
		Item_diamondbowID = config.get(CATEGORY_ItemsID, "Diamond bow", 5006).getInt();
		Item_emeraldbowID = config.get(CATEGORY_ItemsID, "Emerald bow", 5007).getInt();
		Item_nanomitebowID = config.get(CATEGORY_ItemsID, "Nanomite bow", 5008).getInt();
		Item_circuitID = config.get(CATEGORY_ItemsID, "Circuit", 5009).getInt();
		Item_advencedcircuitID = config.get(CATEGORY_ItemsID, "Advenced Circuit", 5010).getInt();
		Item_processorID = config.get(CATEGORY_ItemsID, "Processor", 5011).getInt();
		Item_microprocessorID = config.get(CATEGORY_ItemsID, "Micro-processor", 5012).getInt();
		Item_cameraID = config.get(CATEGORY_ItemsID, "Camera", 5013).getInt();
		Item_detectorID = config.get(CATEGORY_ItemsID, "Detector", 5014).getInt();
		Item_engineID = config.get(CATEGORY_ItemsID, "Engine", 5015).getInt();
		Item_nanomiteID = config.get(CATEGORY_ItemsID, "Nanomite", 5016).getInt();
		Item_nanomiteframeID = config.get(CATEGORY_ItemsID, "Nanomite Frame", 5017).getInt();
		Item_smallnanomiteID = config.get(CATEGORY_ItemsID, "Small Nanomite", 5018).getInt();
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
		Item_videID = config.get(CATEGORY_ItemsID, "Item for barrel(vide)", 5034).getInt();
		
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
	}
	
	
	/**
	 * Initialization
	 * @param event
	 */
	@Init
	public void Initnanotech_mod(FMLInitializationEvent event)
	{	
		proxy.registerRenderThings();
		this.initBlock();
		this.initItem();
		this.blockRegistry();
		this.blockName();
		this.itemName();
		this.dimensionAndBiomeAndGeneration();
		if (Config_hardrecipe == true){this.hardRecipes();}else{this.normalRecipes();}
		this.guiAndTileEntity();
		this.creativeTab();
		this.mobs();
		this.forgeDictionary();
		this.other();
	}
	
	/**
	 * Initialization of Blocks
	 */
	public void initBlock()
	{
		Block_portal = new Block_portal(Block_portalID, 2).setBlockUnbreakable().setBlockName("Block_portal");
		Block_portalframe = new Block_base(Block_portalframeID, 3, Material.rock).setResistance(5F).setHardness(2F).setBlockName("Block_portalframe").setCreativeTab(CREATIVE_TAB_B);
		Block_grass = new Block_grass(Block_grassID).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("Block_grass").setCreativeTab(CREATIVE_TAB_B);
		Block_fakediamond = new Block_fakediamond(Block_fakediamondID, 50).setHardness(3.0F).setResistance(5F).setBlockName("Block_fakediamond").setCreativeTab(CREATIVE_TAB_B);
		Block_fakegold = new Block_fakegold(Block_fakegoldID, 32).setHardness(3.0F).setResistance(5F).setBlockName("Block_fakegold").setCreativeTab(CREATIVE_TAB_B);
		Block_booster = new Block_booster(Block_boosterID, 4).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_booster").setCreativeTab(CREATIVE_TAB_B);
		Block_retarder = new Block_retarder(Block_retarderID, 6).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_retarder").setCreativeTab(CREATIVE_TAB_B);
		Block_jumper = new Block_jumper(Block_jumperID, 5).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_jumper").setCreativeTab(CREATIVE_TAB_B);
		Block_multiplier = new Block_multiplier(Block_multiplierID, 7).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_multiplier").setCreativeTab(CREATIVE_TAB_B);
		Block_smoker = new Block_smoker(Block_smokerID, 8).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_smoker").setCreativeTab(CREATIVE_TAB_B);
		Block_trashcan = new Block_trashcan(Block_trashcanID).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("Block_trashcan").setCreativeTab(CREATIVE_TAB_B); 
		Block_barbedwire = new Block_barbedwire(Block_barbedwireID, 16).setHardness(3.0F).setResistance(5F).setBlockName("Block_barbedwire").setCreativeTab(CREATIVE_TAB_B);
		Block_nanowood = new Block_nanowood(Block_nanowoodID).setHardness(1.0F).setResistance(5F).setBlockName("Block_nanowood").setCreativeTab(CREATIVE_TAB_B);
		Block_nanoleaves = new Block_nanoleaves(Block_nanoleavesID, 13).setHardness(0.5F).setResistance(5F).setBlockName("Block_nanoleaves").setCreativeTab(CREATIVE_TAB_B);
		Block_nanosaplings = new Block_nanosaplings(Block_nanosaplingsID, 12).setHardness(0.0F).setResistance(5F).setBlockName("Block_nanosaplings").setCreativeTab(CREATIVE_TAB_B);
		Block_nanoplanks = new Block_nanoplanks(Block_nanoplanksID, 31).setHardness(1.0F).setResistance(5F).setBlockName("Block_nanoplanks").setCreativeTab(CREATIVE_TAB_B);
		Block_siliconore = new Block_siliconore(Block_siliconoreID, 38).setHardness(1.0F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("Block_siliconore");
		Block_stonedecrease = new Block_stonedecrease(Block_stonedecreaseID, 39).setHardness(1.0F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("Block_stonedecrease");
		Block_confusion = new Block_confusion(Block_confusionID, 40).setHardness(5.0F).setStepSound(soundStoneFootstep).setBlockName("Block_confusion").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingstone = new Block_falling(Block_fallingstoneID, 1, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingstone").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingcobblestone = new Block_falling(Block_fallingcobblestoneID, 16, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingcobblestone").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingmossycobblestone = new Block_falling(Block_fallingmossycobblestoneID, 36, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingmossycobblestone").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingstonebrick = new Block_falling(Block_fallingstonebrickID, 54, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingstonebrick").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingcrackedstonebrick = new Block_falling(Block_fallingcrackedstonebrickID, 101, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingcrackedstonebrick").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingmossystonebrick = new Block_falling(Block_fallingmossystonebrickID, 100, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingmossystonebrick").setCreativeTab(CREATIVE_TAB_B);
		Block_fallingchiseledstonebrick = new Block_falling(Block_fallingchiseledstonebrickID, 213, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_fallingchiseledstonebrick").setCreativeTab(CREATIVE_TAB_B);
		Block_notfallingsand = new Block_basegametextures(Block_notfallingsandID, 18, Material.sand).setHardness(0.5F).setStepSound(soundSandFootstep).setBlockName("Block_notfallinsand").setCreativeTab(CREATIVE_TAB_B);
		Block_notfallinggravel = new Block_basegametextures(Block_notfallinggravelID, 19, Material.sand).setHardness(0.5F).setStepSound(soundGravelFootstep).setBlockName("Block_notfallingravel").setCreativeTab(CREATIVE_TAB_B);	
		Block_sodium = new Block_sodium(Block_sodiumID, 20, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_sodium").setCreativeTab(CREATIVE_TAB_B);
		Block_mossystone = new Block_base(Block_mossystoneID, 17, Material.rock).setHardness(1.0F).setStepSound(soundStoneFootstep).setBlockName("Block_mossystone").setCreativeTab(CREATIVE_TAB_B);
	}
	
	/**
	 * Initialization of Items
	 */
	public void initItem()
	{
		Item_siliconore = new Item_itembase(Item_siliconoreID, false).setIconIndex(0).setItemName("Item_siliconore").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_stoneofdecrease = new Item_itembase(Item_stoneofdecreaseID, false).setIconIndex(1).setItemName("Item_stoneofdecrease").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysteriousmaterial = new Item_itembase(Item_mysteriousmaterialID, false).setIconIndex(2).setItemName("Item_mysteriousmaterial").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_siliconplate = new Item_itembase(Item_siliconplateID, false).setIconIndex(3).setItemName("Item_siliconplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysteriousingot = new Item_itembase(Item_mysteriousingotID, false).setIconIndex(4).setItemName("Item_mysteriousingot").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_superbottleofxp = new Item_superbottleofxp(Item_superbottleofxpID).setIconIndex(5).setItemName("Item_superbottleofxp").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_diamondbow = new Item_diamondbow(Item_diamondbowID).setIconIndex(6).setItemName("Item_diamondbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Item_emeraldbow = new Item_emeraldbow(Item_emeraldbowID).setIconIndex(7).setItemName("Item_emeraldbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Item_nanomitebow = new Item_nanomitebow(Item_nanomitebowID).setIconIndex(8).setItemName("Item_nanomitebow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Item_circuit = new Item_itembase(Item_circuitID, false).setIconIndex(9).setItemName("Item_circuit").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_advencedcircuit = new Item_itembase(Item_advencedcircuitID, false).setIconIndex(10).setItemName("Item_advencedcircuit").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_processor = new Item_itembase(Item_processorID, false).setIconIndex(11).setItemName("Item_processor").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_microprocessor = new Item_itembase(Item_microprocessorID, false).setIconIndex(20).setItemName("Item_microprocessor").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_camera = new Item_itembase(Item_cameraID, false).setIconIndex(21).setItemName("Item_camera").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_detector = new Item_itembase(Item_detectorID, false).setIconIndex(25).setItemName("Item_detector").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_engine = new Item_itembase(Item_engineID, false).setIconIndex(26).setItemName("Item_engine").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomite = new Item_itembase(Item_nanomiteID, false).setIconIndex(12).setItemName("Item_nanomite").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomiteframe = new Item_itembase(Item_nanomiteframeID, false).setIconIndex(13).setItemName("Item_nanomiteframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_smallnanomite = new Item_itembase(Item_smallnanomiteID, false).setIconIndex(14).setItemName("Item_smallnanomite").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomitehelmet = new Item_nanomitearmor(Item_nanomitehelmetID, EnumArmorMaterialNanomite, 1, 0).setIconIndex(16).setItemName("Item_nanomitehelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomitechestplate = new Item_nanomitearmor(Item_nanomitechestplateID, EnumArmorMaterialNanomite, 1, 1).setIconIndex(32).setItemName("Item_nanomitechestplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomiteleggins = new Item_nanomitearmor(Item_nanomitelegginsID, EnumArmorMaterialNanomite, 1, 2).setIconIndex(48).setItemName("Item_nanomitelegs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomiteboots = new Item_nanomitearmor(Item_nanomitebootsID, EnumArmorMaterialNanomite, 1, 3).setIconIndex(64).setItemName("Item_nanomiteboots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomitesword = new Item_nanomitesword(Item_nanomiteswordID, EnumToolMaterialNanomite).setIconIndex(17).setItemName("Item_nanomitesword").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomiteshovel = new Item_nanomiteshovel(Item_nanomiteshovelID, EnumToolMaterialNanomite).setIconIndex(33).setItemName("Item_nanomiteshovel").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomitepickaxe = new Item_nanomitepickaxe(Item_nanomitepickaxeID, EnumToolMaterialNanomite).setIconIndex(49).setItemName("Item_nanomitepickaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomiteaxe = new Item_nanomiteaxe(Item_nanomiteaxeID, EnumToolMaterialNanomite).setIconIndex(65).setItemName("Item_nanomiteaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanomitehoe = new Item_nanomitehoe(Item_nanomitehoeID, EnumToolMaterialNanomite).setIconIndex(81).setItemName("Item_nanomitehoe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysterioushelmet = new Item_mysteriousarmor(Item_mysterioushelmetID, EnumArmorMaterialMysterious, 1, 0).setIconIndex(18).setItemName("Item_mysterioushelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysteriouschestplate = new Item_mysteriousarmor(Item_mysteriouschestplateID, EnumArmorMaterialMysterious,1 ,1).setIconIndex(34).setItemName("Item_mysteriouschestplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysteriousleggins = new Item_mysteriousarmor(Item_mysteriouslegginsID, EnumArmorMaterialMysterious,1 ,2).setIconIndex(50).setItemName("Item_mysteriousleggins").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_mysteriousboots = new Item_mysteriousarmor(Item_mysteriousbootsID, EnumArmorMaterialMysterious, 1, 3).setIconIndex(66).setItemName("Item_mysteriousboots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_nanodisc = new Item_disc(Item_nanodiscID, "nanodisk", nanodiscname).setIconIndex(239).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc = new Item_disc(Item_nanodiscID+1, "YourSound1", Yourdiscname).setIconIndex(240).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc2 = new Item_disc(Item_nanodiscID+2, "YourSound2", Yourdiscname2).setIconIndex(241).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc3 = new Item_disc(Item_nanodiscID+3, "YourSound3", Yourdiscname3).setIconIndex(242).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc4 = new Item_disc(Item_nanodiscID+4, "YourSound4", Yourdiscname4).setIconIndex(243).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc5 = new Item_disc(Item_nanodiscID+5, "YourSound5", Yourdiscname5).setIconIndex(244).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc6 = new Item_disc(Item_nanodiscID+6, "YourSound6", Yourdiscname6).setIconIndex(245).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc7 = new Item_disc(Item_nanodiscID+7, "YourSound7", Yourdiscname7).setIconIndex(246).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc8 = new Item_disc(Item_nanodiscID+8, "YourSound8", Yourdiscname8).setIconIndex(247).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc9 = new Item_disc(Item_nanodiscID+9, "YourSound9", Yourdiscname9).setIconIndex(248).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc10 = new Item_disc(Item_nanodiscID+10, "YourSound10", Yourdiscname10).setIconIndex(249).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc11 = new Item_disc(Item_nanodiscID+11, "YourSound11", Yourdiscname11).setIconIndex(250).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc12 = new Item_disc(Item_nanodiscID+12, "YourSound12", Yourdiscname12).setIconIndex(251).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc13 = new Item_disc(Item_nanodiscID+13, "YourSound13", Yourdiscname13).setIconIndex(252).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc14 = new Item_disc(Item_nanodiscID+14, "YourSound14", Yourdiscname14).setIconIndex(253).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_yourmusicdisc15 = new Item_disc(Item_nanodiscID+15, "YourSound15", Yourdiscname15).setIconIndex(254).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Item_yourmusicdisc16 = new Item_disc(Item_nanodiscID+16, "YourSound16", Yourdiscname16).setIconIndex(255).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Item_edibleflesh = new Item_edibleflesh(Item_ediblefleshID, 3, true).setIconIndex(15).setItemName("Item_edibleflesh").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_rottenchunk = new Item_edibleflesh(Item_rottenchunkID, 1, true).setIconIndex(19).setItemName("Item_rottenchunk").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Item_vide = new Item_itembase(Item_videID, true).setIconIndex(80).setItemName("Item_vide").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}
	
	/**
	 * Block registry
	 */
	public void blockRegistry()
	{
		GameRegistry.registerBlock(Block_portal, "Block_portal");
		GameRegistry.registerBlock(Block_portalframe, "Block_portalframe");
		GameRegistry.registerBlock(Block_grass, "Block_grass");
		GameRegistry.registerBlock(Block_fakediamond, "Block_fakediamond");
		GameRegistry.registerBlock(Block_fakegold, "Block_fakegold");
		GameRegistry.registerBlock(Block_booster, "Block_booster");
		GameRegistry.registerBlock(Block_retarder, "Block_retarder");
		GameRegistry.registerBlock(Block_jumper, "Block_jumper");
		GameRegistry.registerBlock(Block_multiplier, "Block_multiplier");
		GameRegistry.registerBlock(Block_smoker, "Block_smoker");
		GameRegistry.registerBlock(Block_trashcan, "Block_trashcan");
		GameRegistry.registerBlock(Block_barbedwire, "Block_barbedwire");
		GameRegistry.registerBlock(Block_nanowood, "Block_nanowood");
		GameRegistry.registerBlock(Block_nanoleaves, "Block_nanoleaves");
		GameRegistry.registerBlock(Block_nanosaplings, "Block_nanosaplings");
		GameRegistry.registerBlock(Block_nanoplanks, "Block_nanoplanks");
		GameRegistry.registerBlock(Block_siliconore, "Block_siliconore");
		GameRegistry.registerBlock(Block_stonedecrease, "Block_stonedecrease");
		GameRegistry.registerBlock(Block_confusion, "Block_confusion");
		GameRegistry.registerBlock(Block_fallingstone, "Block_fallingstone");
		GameRegistry.registerBlock(Block_fallingcobblestone, "Block_fallingcobblestone");
		GameRegistry.registerBlock(Block_fallingmossycobblestone, "Block_fallingmossycobblestone");
		GameRegistry.registerBlock(Block_fallingstonebrick, "Block_fallingstonebrick");
		GameRegistry.registerBlock(Block_fallingcrackedstonebrick, "Block_fallingcrackedstonebrick");
		GameRegistry.registerBlock(Block_fallingmossystonebrick, "Block_fallingmossystonebrick");
		GameRegistry.registerBlock(Block_fallingchiseledstonebrick, "Block_fallingchiseledstonebrick");
		GameRegistry.registerBlock(Block_notfallingsand, "Block_notfallingsand");
		GameRegistry.registerBlock(Block_notfallinggravel, "Block_notfallinggravel");
		GameRegistry.registerBlock(Block_sodium, "Block_sodium");
		GameRegistry.registerBlock(Block_mossystone, "Block_mossystone");
	}
	
	/**
	 * Block Names
	 */
	public void blockName()
	{
		LanguageRegistry.addName(Block_portal, "Portal");
		LanguageRegistry.addName(Block_portalframe, "Portal frame");
		LanguageRegistry.addName(Block_grass, "Grass");
		LanguageRegistry.addName(Block_fakediamond, "Fake diamond");
		LanguageRegistry.addName(Block_fakegold, "Fake gold");
		LanguageRegistry.addName(Block_booster, "Booster");
		LanguageRegistry.addName(Block_retarder, "Retarder");
		LanguageRegistry.addName(Block_jumper, "Jumper");
		LanguageRegistry.addName(Block_multiplier, "Multiplier");
		LanguageRegistry.addName(Block_smoker, "Smoker");
		LanguageRegistry.addName(Block_trashcan, "Trash can");
		LanguageRegistry.addName(Block_barbedwire, "Barbed wire");
		LanguageRegistry.addName(Block_nanowood, "Nano wood");
		LanguageRegistry.addName(Block_nanoleaves, "Nano leaves");
		LanguageRegistry.addName(Block_nanosaplings, "Nano saplings");
		LanguageRegistry.addName(Block_nanoplanks, "Nano plank");
		LanguageRegistry.addName(Block_siliconore, "Silicon ore");
		LanguageRegistry.addName(Block_stonedecrease, "Stone of decrease");
		LanguageRegistry.addName(Block_confusion, "Block of confusion");
		LanguageRegistry.addName(Block_fallingstone, "Falling Stone");
		LanguageRegistry.addName(Block_fallingcobblestone, "Falling Cobblestone");
		LanguageRegistry.addName(Block_fallingmossycobblestone, "Falling Mossy Cobblestone");
		LanguageRegistry.addName(Block_fallingstonebrick, "Falling Stonebrick");
		LanguageRegistry.addName(Block_fallingcrackedstonebrick, "Falling Cracked Stonebrick");
		LanguageRegistry.addName(Block_fallingmossystonebrick, "Falling Mossy Stonebrick");
		LanguageRegistry.addName(Block_fallingchiseledstonebrick, "Falling Chiseled Stonebrick");
		LanguageRegistry.addName(Block_notfallingsand, "Not Falling Sand");
		LanguageRegistry.addName(Block_notfallinggravel, "Not Falling Gravel");
		LanguageRegistry.addName(Block_sodium, "Sodium");
		LanguageRegistry.addName(Block_mossystone, "Mossy Stone");
	}
	
	/**
	 * Items Names
	 */
	public void itemName()
	{
		LanguageRegistry.addName(Item_siliconore, "Silicon Ore");
		LanguageRegistry.addName(Item_stoneofdecrease, "Stone of Decrease");
		LanguageRegistry.addName(Item_mysteriousmaterial, "Mysterious Material");
		LanguageRegistry.addName(Item_siliconplate, "Silicon Plate");
		LanguageRegistry.addName(Item_mysteriousingot, "Mysterious Ingot");
		LanguageRegistry.addName(Item_superbottleofxp, "Super bottle of xp");
		LanguageRegistry.addName(Item_diamondbow, "Diamond bow");
		LanguageRegistry.addName(Item_emeraldbow, "Emerald bow");
		LanguageRegistry.addName(Item_nanomitebow, "Nanomite bow");
		LanguageRegistry.addName(Item_circuit, "Circuit");
		LanguageRegistry.addName(Item_advencedcircuit, "Advenced Circuit");
		LanguageRegistry.addName(Item_processor, "Processor");
		LanguageRegistry.addName(Item_microprocessor, "Micro-processor");
		LanguageRegistry.addName(Item_camera, "Camera");
		LanguageRegistry.addName(Item_detector, "Detector");
		LanguageRegistry.addName(Item_engine, "Engine");
		LanguageRegistry.addName(Item_nanomite, "Nanomite");
		LanguageRegistry.addName(Item_nanomiteframe, "Nanomite Frame");
		LanguageRegistry.addName(Item_smallnanomite, "Small Nanomite");
		LanguageRegistry.addName(Item_nanomiteaxe, "Nanomite Axe");
		LanguageRegistry.addName(Item_nanomitepickaxe, "Nanomite Pickaxe");
		LanguageRegistry.addName(Item_nanomiteshovel, "Nanomite Shovel");
		LanguageRegistry.addName(Item_nanomitehoe, "Nanomite Hoe");
		LanguageRegistry.addName(Item_nanomitesword, "Nanomite Sword");
		LanguageRegistry.addName(Item_nanomitehelmet, "Nanomite Helmet");
		LanguageRegistry.addName(Item_nanomitechestplate, "Nanomite Chestplate");
		LanguageRegistry.addName(Item_nanomiteleggins, "Nanomite Leggins");
		LanguageRegistry.addName(Item_nanomiteboots, "Nanomite Boots");
		LanguageRegistry.addName(Item_mysterioushelmet, "Mysterious Helmet");
		LanguageRegistry.addName(Item_mysteriouschestplate, "Mysterious Chestplate");
		LanguageRegistry.addName(Item_mysteriousleggins, "Mysterious Leggins");
		LanguageRegistry.addName(Item_mysteriousboots, "Mysterious Boots");
		LanguageRegistry.addName(Item_edibleflesh, "Edible Flesh");
		LanguageRegistry.addName(Item_rottenchunk, "Chunk of Rotten flesh");
		LanguageRegistry.addName(Item_vide, "Vide");
	}
	
	/**
	 * Dimension and biome registry
	 */
	public void dimensionAndBiomeAndGeneration()
	{
		DimensionManager.registerProviderType(dimension, World_worldprovider.class, false);
		DimensionManager.registerDimension(dimension, dimension);
		
		Nanotechbiome = new World_nanotechbiome(50).setBiomeName("Nanotechbiome").setTemperatureRainfall(1.2F, 0.9F);
		GameRegistry.addBiome(Nanotechbiome);
		
		GameRegistry.registerWorldGenerator(new World_generation());
	}
	
	/**
	 * Normal recipes
	 */
	public void normalRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(Item_nanodisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,0));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc2, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,1));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc3, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,2));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc4, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,3));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc5, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,4));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc6, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,5));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc7, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,6));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc8, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,7));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc9, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,8));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc10, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,9));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc11, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,10));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc12, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,11));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc13, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,12));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc14, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,13));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc15, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,14));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc16, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,15));
		GameRegistry.addRecipe(new ItemStack(Block_portalframe, 4), " X ", "XZX", " X ", 'X', Block.blockSteel, 'Z', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(Block_booster, 2), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(Block_retarder, 2), " X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(Block_jumper, 2), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockSteel);
		GameRegistry.addRecipe(new ItemStack(Block_smoker, 2), " X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_trashcan), "X X", "XZX", "XXX", 'X', Item.ingotIron, 'Z', Block.cactus);
		GameRegistry.addRecipe(new ItemStack(Block_barbedwire, 4), "XXX", " X ", "XXX", 'X', Block.fenceIron);
		GameRegistry.addRecipe(new ItemStack(Item_circuit, 1), "XXX", "WYW", "XXX", 'X', Item.redstone, 'W', Item_siliconplate, 'Y', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(Item_advencedcircuit, 1), "XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.lightStoneDust, 'W', Item_siliconplate, 'V', Item_circuit);
		GameRegistry.addRecipe(new ItemStack(Item_processor, 1), "XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', Item_circuit, 'V', Item_advencedcircuit);
		GameRegistry.addRecipe(new ItemStack(Item_camera, 1), "WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', Item_microprocessor, 'V', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(Item_detector, 1), "WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', Item_microprocessor);
		GameRegistry.addRecipe(new ItemStack(Item_engine, 1), "XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', Item_processor);
		GameRegistry.addRecipe(new ItemStack(Item_nanomite, 1), "XYX", "VCV", "XNX", 'X', Item_nanomiteframe, 'Y', Item_camera, 'V', Item_detector, 'N', Item_engine);
		GameRegistry.addRecipe(new ItemStack(Item_nanomitehelmet, 1), new Object[] {"XXX", "X X", 'X', Item_nanomite});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitechestplate, 1), "X X", "XXX", "XXX", 'X', Item_nanomite);
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteleggins, 1), "XXX", "X X", "X X", 'X', Item_nanomite);
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteboots, 1), new Object[] {"X X", "X X", 'X', Item_nanomite});
		GameRegistry.addRecipe(new ItemStack(Item_mysterioushelmet, 1), new Object[] {"XXX", "X X", 'X', Item_mysteriousingot});
		GameRegistry.addRecipe(new ItemStack(Item_mysteriouschestplate, 1), "X X", "XXX", "XXX", 'X', Item_mysteriousingot);
		GameRegistry.addRecipe(new ItemStack(Item_mysteriousleggins, 1), "XXX", "X X", "X X", 'X', Item_mysteriousingot);
		GameRegistry.addRecipe(new ItemStack(Item_mysteriousboots, 1), new Object[] {"X X", "X X", 'X', Item_mysteriousingot});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteaxe, 1), new Object[] {"XX", "XW", " W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteaxe, 1), new Object[] {"XX", "WX", "W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitehoe, 1), new Object[] {"XX", " W", " W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitehoe, 1), new Object[] {"XX", "W ", "W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitepickaxe, 1), new Object[] {"XXX", " W ", " W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteshovel, 1), new Object[] {"X", "W", "W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitesword, 1), new Object[] {"X", "X", "W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteframe, 1), "X", "XWX", "X", 'X', Item.ingotIron, 'W', Block_booster);
		GameRegistry.addRecipe(new ItemStack(Item_diamondbow, 1), " XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C', Block_booster);
		GameRegistry.addRecipe(new ItemStack(Item_diamondbow, 1), "WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C', Block_booster);
		GameRegistry.addRecipe(new ItemStack(Item_emeraldbow, 1), " XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', Item_diamondbow);
		GameRegistry.addRecipe(new ItemStack(Item_emeraldbow, 1), "WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', Item_diamondbow);
		GameRegistry.addRecipe(new ItemStack(Item_nanomitebow, 1), " XW", "XCW", " XW", 'X', Item_nanomite, 'W', Item.silk, 'C', Item_emeraldbow);
		GameRegistry.addRecipe(new ItemStack(Item_nanomitebow, 1), "WX ", "WCX", "WX ", 'X', Item_nanomite, 'W', Item.silk, 'C', Item_emeraldbow);
		GameRegistry.addRecipe(new ItemStack(Block_confusion, 1), "XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstone, 8), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstone, 8), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcrackedstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcrackedstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossystonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossystonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingchiseledstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingchiseledstonebrick, 8), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcobblestone, 8), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcobblestone, 8), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossycobblestone, 8), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossycobblestone, 8), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 8), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 8), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 8), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 8), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 8), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 8), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 8), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 8), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy);

		GameRegistry.addShapelessRecipe(new ItemStack(Block_nanoplanks, 4), new Object[] {Block_nanowood});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_microprocessor, 1), new Object[] {Item_processor, Item_stoneofdecrease});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_smallnanomite, 1), new Object[] {Item_nanomite, Item_stoneofdecrease});
		GameRegistry.addShapelessRecipe(new ItemStack(Block_mossystone, 2), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_vide), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object [] {Item_vide});
		
		GameRegistry.addSmelting(Block_nanowood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		GameRegistry.addSmelting(Block_siliconore.blockID, new ItemStack(Item_siliconore, 1), 1.0F);
		GameRegistry.addSmelting(Block_stonedecrease.blockID, new ItemStack(Item_stoneofdecrease, 1), 1.0F);
		GameRegistry.addSmelting(Item_siliconore.itemID, new ItemStack(Item_siliconplate), 1.0F);
		GameRegistry.addSmelting(Item_rottenchunk.itemID, new ItemStack(Item_edibleflesh), 0.5F);
		GameRegistry.addSmelting(Item_mysteriousmaterial.itemID, new ItemStack(Item_mysteriousingot), 1.5F);
	}
	
	/**
	 * Hard recipes
	 */
	public void hardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(Item_nanodisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,0));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc2, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,1));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc3, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,2));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc4, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,3));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc5, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,4));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc6, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,5));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc7, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,6));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc8, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,7));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc9, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,8));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc10, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,9));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc11, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,10));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc12, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,11));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc13, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,12));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc14, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,13));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc15, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,14));
		GameRegistry.addRecipe(new ItemStack(Item_yourmusicdisc16, 1), "WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1,15));
		GameRegistry.addRecipe(new ItemStack(Block_portalframe), " X ", "XZX", " X ", 'X', Block.blockSteel, 'Z', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(Block_booster), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(Block_retarder), " X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand);
		GameRegistry.addRecipe(new ItemStack(Block_jumper), " X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockSteel);
		GameRegistry.addRecipe(new ItemStack(Block_smoker), " X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_trashcan), "X X", "XZX", "XXX", 'X', Item.ingotIron, 'Z', Item.bucketLava);
		GameRegistry.addRecipe(new ItemStack(Block_barbedwire), "X X", " X ", "X X", 'X', Block.fenceIron);
		GameRegistry.addRecipe(new ItemStack(Item_circuit, 1), "XXX", "WYW", "XXX", 'X', Item.redstone, 'W', Item_siliconplate, 'Y', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(Item_advencedcircuit, 1), "XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.lightStoneDust, 'W', Item_siliconplate, 'V', Item_circuit);
		GameRegistry.addRecipe(new ItemStack(Item_processor, 1), "XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', Item_circuit, 'V', Item_advencedcircuit);
		GameRegistry.addRecipe(new ItemStack(Item_camera, 1), "WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', Item_microprocessor, 'V', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(Item_detector, 1), "WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', Item_microprocessor);
		GameRegistry.addRecipe(new ItemStack(Item_engine, 1), "XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', Item_processor);
		GameRegistry.addRecipe(new ItemStack(Item_nanomite, 1), "XYX", "VCV", "XNX", 'X', Item_nanomiteframe, 'Y', Item_camera, 'V', Item_detector, 'N', Item_engine);
		GameRegistry.addRecipe(new ItemStack(Item_mysterioushelmet, 1), new Object[] {"XXX", "X X", 'X', Item_mysteriousingot});
		GameRegistry.addRecipe(new ItemStack(Item_mysteriouschestplate, 1), "X X", "XXX", "XXX", 'X', Item_mysteriousingot);
		GameRegistry.addRecipe(new ItemStack(Item_mysteriousleggins, 1), "XXX", "X X", "X X", 'X', Item_mysteriousingot);
		GameRegistry.addRecipe(new ItemStack(Item_mysteriousboots, 1), new Object[] {"X X", "X X", 'X', Item_mysteriousingot});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteaxe, 1), new Object[] {"XX", "XW", " W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteaxe, 1), new Object[] {"XX", "WX", "W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitehoe, 1), new Object[] {"XX", " W", " W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitehoe, 1), new Object[] {"XX", "W ", "W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitepickaxe, 1), new Object[] {"XXX", " W ", " W ", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomiteshovel, 1), new Object[] {"X", "W", "W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_nanomitesword, 1), new Object[] {"X", "X", "W", 'X', Item_smallnanomite, 'W', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item_diamondbow, 1), " XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C', Block_booster);
		GameRegistry.addRecipe(new ItemStack(Item_diamondbow, 1), "WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C', Block_booster);
		GameRegistry.addRecipe(new ItemStack(Item_emeraldbow, 1), " XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', Item_diamondbow);
		GameRegistry.addRecipe(new ItemStack(Item_emeraldbow, 1), "WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', Item_diamondbow);
		GameRegistry.addRecipe(new ItemStack(Item_nanomitebow, 1), " XW", "XCW", " XW", 'X', Item_nanomite, 'W', Item.silk, 'C', Item_emeraldbow);
		GameRegistry.addRecipe(new ItemStack(Item_nanomitebow, 1), "WX ", "WCX", "WX ", 'X', Item_nanomite, 'W', Item.silk, 'C', Item_emeraldbow);
		GameRegistry.addRecipe(new ItemStack(Block_confusion, 1), "XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstone, 4), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstone, 4), "XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcrackedstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcrackedstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossystonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossystonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingchiseledstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingchiseledstonebrick, 4), "XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcobblestone, 4), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingcobblestone, 4), "XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossycobblestone, 4), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand);
		GameRegistry.addRecipe(new ItemStack(Block_fallingmossycobblestone, 4), "XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 4), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 4), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 4), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallinggravel, 4), "XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 4), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 4), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 4), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Block_notfallingsand, 4), "XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy);

		
		GameRegistry.addShapelessRecipe(new ItemStack(Block_nanoplanks, 4), new Object[] {Block_nanowood});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_smallnanomite, 1), new Object[] {Item_nanomite, Item_stoneofdecrease});
		GameRegistry.addShapelessRecipe(new ItemStack(Block_mossystone, 1), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(Item_vide), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object [] {Item_vide});
		
		GameRegistry.addSmelting(Block_nanowood.blockID, new ItemStack(Item.coal, 1, 1), 0.0F);
		GameRegistry.addSmelting(Block_siliconore.blockID, new ItemStack(Item_siliconore, 1), 0.0F);
		GameRegistry.addSmelting(Block_stonedecrease.blockID, new ItemStack(Item_stoneofdecrease, 1, 1), 0.0F);
		GameRegistry.addSmelting(Item_siliconore.itemID, new ItemStack(Item_siliconplate), 0.0F);
		GameRegistry.addSmelting(Item_rottenchunk.itemID, new ItemStack(Item_edibleflesh), 0.0F);
		GameRegistry.addSmelting(Item_mysteriousmaterial.itemID, new ItemStack(Item_mysteriousingot), 0.5F);
	}
	
	/**
	 * Gui and TileEntity
	 */
	public void guiAndTileEntity()
	{
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		GameRegistry.registerTileEntity(TileEntity_block_jumper.class, "TileEntity_block_jumper");
		GameRegistry.registerTileEntity(TileEntity_block_smoker.class, "TileEntity_block_smoker");
		GameRegistry.registerTileEntity(TileEntity_block_multiplier.class, "TileEntity_block_multiplier");
	}
	
	/**
	 * CreativeTabs (Names)
	 */
	public void creativeTab()
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.Nanotech mod Blocks", "en_US", "Nanotech mod Blocks");
		LanguageRegistry.instance().addStringLocalization("itemGroup.Nanotech mod Items", "en_US", "Nanotech mod Items");
		
	}

	/**
	 * Eggs spawner color
	 */
	public static int eggColorRed = 16711680;
	public static int eggColorGreen = 652820;
	public static int eggColorBlue = 255;
	public static int eggColorLightBlue = 65535;
	public static int eggColorWhite = 16777215;
	public static int eggColorYellow = 16776960;
	public static int eggColorOrange = 16744448;
	public static int eggColorBrown = 8404992;
	public static int eggColorBlack = 0;
	public static int eggColorPink = 16711808;
	public static int eggColorGray = 8421504;
	public static int eggColorLightGreen = 8454052;
	public static int eggColorBlueGreen = 46220;
	
	
	/**
	 * Mobs
	 */
	public void mobs()
	{
		if (Superzombie == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_superzombie.class, "Superzombie", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlueGreen, eggColorRed);
			EntityRegistry.registerModEntity(Mob_superzombie.class, "Superzombie", 0, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superzombie.name", "en_US", "Superzombie");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_superzombie.class, Superzombiechance, Superzombiemin, Superzombiemax, EnumCreatureType.monster, Nanotechbiome);
			}
		}


		if (Fastzombie == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_fastzombie.class, "Fastzombie", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlue, eggColorRed);
			EntityRegistry.registerModEntity(Mob_fastzombie.class, "Fastzombie", 1, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Fastzombie.name", "en_US", "Fastzombie");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_fastzombie.class, Fastzombiechance, Fastzombiemin, Fastzombiemax, EnumCreatureType.monster, Nanotechbiome);
			}
		}

		if (Superskeleton == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_superskeleton.class, "Superskeleton", EntityRegistry.findGlobalUniqueEntityId(), eggColorWhite, eggColorYellow);
			EntityRegistry.registerModEntity(Mob_superskeleton.class, "Superskeleton", 2, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superskeleton.name", "en_US", "Superskeleton");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_superskeleton.class, Superskeletonchance, Superskeletonmin, Superskeletonmax, EnumCreatureType.monster, Nanotechbiome);
			}
		}


		if (Supercreeper == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_supercreeper.class, "Supercreeper", EntityRegistry.findGlobalUniqueEntityId(), eggColorGreen, eggColorRed);
			EntityRegistry.registerModEntity(Mob_supercreeper.class, "Supercreeper", 4, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Supercreeper.name", "en_US", "Supercreeper");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_supercreeper.class, Supercreeperchance, Supercreepermin, Supercreepermax, EnumCreatureType.monster, Nanotechbiome);
			}
		}


		if (Superenderman == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_superenderman.class, "Superenderman", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlack, eggColorGray);
			EntityRegistry.registerModEntity(Mob_superenderman.class, "Superenderman", 5, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superenderman.name", "en_US", "Superenderman");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_superenderman.class, Superendermanchance, Superendermanmin, Superendermanmax, EnumCreatureType.monster, Nanotechbiome);
			}
		}


		if (Creeperdriller == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_creeperforreur.class, "Creeperforreur", EntityRegistry.findGlobalUniqueEntityId(), eggColorOrange, eggColorRed);
			EntityRegistry.registerModEntity(Mob_creeperforreur.class, "Creeperdriller", 6, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Creeperforreur.name", "en_US", "Creeperdriller");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_creeperforreur.class, Creeperdrillerchance, Creeperdrillermin, Creeperdrillermax, EnumCreatureType.monster, Nanotechbiome);
			}	
		}


		if (TheDeath == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_thedeath.class, "TheDeath", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlack, eggColorWhite);
			EntityRegistry.registerModEntity(Mob_thedeath.class, "TheDeath", 7, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.TheDeath.name", "en_US", "TheDeath");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_thedeath.class, 0, 0, 0, EnumCreatureType.monster);
			}
		}


		if (Fly == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_fly.class, "Fly", EntityRegistry.findGlobalUniqueEntityId(), eggColorGray, eggColorBlack);
			EntityRegistry.registerModEntity(Mob_fly.class, "Fly", 8, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Fly.name", "en_US", "Fly");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_fly.class, Flychance, Flymin, Flymax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotechbiome);
			}
		}	
		
		if (Flyingcreeper == true)
		{
			EntityRegistry.registerGlobalEntityID(Mob_flyingcreeper.class, "Flying Creeper", EntityRegistry.findGlobalUniqueEntityId(), eggColorGreen, eggColorRed);
			EntityRegistry.registerModEntity(Mob_flyingcreeper.class, "Flying Creeper", 9, this, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Flying Creeper.name", "en_US", "Flying Creeper");
			if(MobSpawn == true)
			{
				EntityRegistry.addSpawn(Mob_flyingcreeper.class, Flyingcreeperchance, Flyingcreepermin, Flyingcreepermax, EnumCreatureType.monster, Nanotechbiome);
			}
		}
	}

	/**
	 * Forge dictionary
	 */
	public void forgeDictionary()
	{
		OreDictionary.registerOre("logWood", new ItemStack(Block_nanowood));
		OreDictionary.registerOre("plankWood", new ItemStack(Block_nanoplanks));
		OreDictionary.registerOre("treeSapling", new ItemStack(Block_nanosaplings));
		OreDictionary.registerOre("treeLeaves", new ItemStack(Block_nanoleaves));
	}
	
	/**
	 * Other code
	 * -Shovel on grass
	 */
	public void other()
	{
		MinecraftForge.setBlockHarvestLevel(Block_grass, "shovel", 2);
	}
}
