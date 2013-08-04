package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.Items;

import java.util.Random;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import advsolar.AdvancedSolarPanel;
import cpw.mods.compactsolars.CompactSolars;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateCircuit;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientPacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientTickHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerPacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerTickHandler;
import gravisuite.GraviSuite;
import gregtechmod.api.GregTech_API;

@Mod(modid = "UltimateGraviSuite", name = "Ultimate Gravitation Suite", dependencies = "required-after:IC2;required-after:GraviSuite", version = "1.6")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @NetworkMod.SidedPacketHandler(channels ={"gravisuite"}, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec = @NetworkMod.SidedPacketHandler(channels = {"gravisuite"}, packetHandler = ServerPacketHandler.class))

public class UltimateGraviSuite
{
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ServerProxy")
	public static ServerProxy proxy;
	// Keyboard
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard")
	public static Keyboard keyboard;

	// Items
	public static Item ultimategraviChestPlate;
	public static Item theultimateSolarHelmet;
	public static Item ultimatecircuit;
	public static Item ultimateLeggings;
	public static Item ultimateBoots;

	// Items ID
	public static int ultimategraviChestPlateID;
	public static int theultimateSolarHelmetID;
	public static int ultimatecircuitID;
	public static int ultimateLeggingsID;
	public static int ultimateBootsID;

	// Config
	private boolean keyDown;
	public static int hudPos;
	public static int uhGenDay = 1024;
	public static int uhGenNight = 0;
	public static boolean displayHud;

	// TickHandler
	public static ClientTickHandler clientTickHandler;
	public static ServerTickHandler serverTickHandler;

	// Other
	public static Random random = new Random();

	// Instance
	@Instance("UltimateGraviSuite")
	public static UltimateGraviSuite instance;

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			ultimategraviChestPlateID = cfg.get("Items", "ultimategraviChestPlateID", 5500).getInt();
			theultimateSolarHelmetID = cfg.get("Items", "ultimateSolarHelmetID", 5501).getInt();
			ultimatecircuitID = cfg.get("Items", "ultimatecircuitID", 5502).getInt();
			ultimateLeggingsID = cfg.get("Items", "ultimateLeggingsID", 5503).getInt();
			ultimateBootsID = cfg.get("Items", "ultimateBootsID", 5504).getInt();

			hudPos = cfg.get("Hud settings", "hudPosition", 1).getInt();
			displayHud = cfg.get("Hud settings", "Display hud", true).getBoolean(true);
		}
		catch(Exception e)
		{

		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}

	@Init
	public void load(FMLInitializationEvent event)
	{	
		this.Item();
		this.ItemName();
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		proxy.initCore();
		proxy.registerRenderers();
	}

	// Items statement
	public void Item()
	{
		ultimategraviChestPlate = new UltimateGraviChestPlate(ultimategraviChestPlateID, EnumArmorMaterial.DIAMOND, proxy.addArmor("UltimateGraviSuite"), 1).setUnlocalizedName("ultimategraviChestPlate");
		theultimateSolarHelmet = new UltimateQuantumHelmet(theultimateSolarHelmetID, EnumArmorMaterial.DIAMOND, proxy.addArmor("ultimateQuantumHelmet"), 0).setUnlocalizedName("TheUltimateSolarHelmet");
		ultimateLeggings = new UltimateLeggings(ultimateLeggingsID, EnumArmorMaterial.DIAMOND, proxy.addArmor("UltimateLeggins"), 2).setUnlocalizedName("UltimateLeggings");
		ultimatecircuit = new UltimateCircuit(ultimatecircuitID).setUnlocalizedName("UltimateCircuit");
		ultimateBoots = new UltimateBoots(ultimateBootsID, EnumArmorMaterial.DIAMOND, proxy.addArmor("UltimateBoots"), 3).setUnlocalizedName("ultimateBoots");
	}

	// Items Name
	public void ItemName()
	{
		LanguageRegistry.addName(ultimategraviChestPlate, "Ultimate GraviChestPlate");
		LanguageRegistry.addName(theultimateSolarHelmet, "Ultimate Quantum Helmet");
		LanguageRegistry.addName(ultimatecircuit, "Ultimate circuit");
		LanguageRegistry.addName(ultimateLeggings, "Ultimate Quantum Leggings");
		LanguageRegistry.addName(ultimateBoots, "Ultimate Quantum Boots");
	}

	// Mod PostInit
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		if(hudPos < 1 || hudPos > 4)
		{
			hudPos = 1;
		}
		
		if(Loader.isModLoaded("CompactSolars"))
		{
			if(Loader.isModLoaded("GregTech_Addon"))
			{
				GameRegistry.addRecipe(new ItemStack(ultimatecircuit, 1), new Object[]
				{"ABC", "BDB", "CBA", 'A', "craftingCircuitTier08", 'B', Items.getItem("advancedCircuit"), 'C', "craftingCircuitTier07", 'D', GregTech_API.getGregTechBlock(1, 1, 4)});
				GameRegistry.addRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[]
				{"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G', GraviSuite.graviChestPlate, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimatecircuit});
				GameRegistry.addRecipe(new ItemStack(theultimateSolarHelmet, 1), new Object[]
				{"SPS", "XUX", "SYS", 'S', new ItemStack(CompactSolars.compactSolarBlock, 1, 2), 'X', ultimatecircuit, 'P', "itemSuperconductor", 'U', Items.getItem("quantumHelmet"), 'Y', GregTech_API.getGregTechBlock(1, 1, 4)});
				GameRegistry.addRecipe(new ItemStack(ultimateLeggings, 1), new Object[]
				{"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit});
				GameRegistry.addRecipe(new ItemStack(ultimateBoots, 1), new Object[]
				{"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit});
				
			}
			else
			{
				// add compactSolars non-gregtech recipes
			}
		}

		else if(Loader.isModLoaded("AdvancedSolarPanel"))
		{
			if(Loader.isModLoaded("GregTech_Addon"))
			{
				GameRegistry.addRecipe(new ItemStack(ultimatecircuit, 1), new Object[]
				{"ABC", "BDB", "CBA", 'A', "craftingCircuitTier08", 'B', Items.getItem("advancedCircuit"), 'C', "craftingCircuitTier07", 'D', GregTech_API.getGregTechBlock(1, 1, 4)});
				GameRegistry.addRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[]
				{"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G', GraviSuite.graviChestPlate, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimatecircuit});
				GameRegistry.addRecipe(new ItemStack(theultimateSolarHelmet, 1), new Object[]
				{"SPS", "XUX", "SYS", 'P', new ItemStack(AdvancedSolarPanel.blockAdvSolarPanel, 1, 2), 'X', ultimatecircuit, 'S', "itemSuperconductor", 'U', AdvancedSolarPanel.ultimateSolarHelmet, 'Y', GregTech_API.getGregTechBlock(1, 1, 4)});
				GameRegistry.addRecipe(new ItemStack(ultimateLeggings, 1), new Object[]
				{"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit});
				GameRegistry.addRecipe(new ItemStack(ultimateBoots, 1), new Object[]
				{"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit});
			}
			else
			{
				// add AdvancedSolarPanel non-gregtech recipes
			}
		}
	}

	// IS Simulating
	public static boolean isSimulating()
	{
		return !FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	// NBTTag
	public static NBTTagCompound getOrCreateNbtData(ItemStack stack)
	{
		NBTTagCompound nbt = stack.getTagCompound();

		if(nbt == null)
		{
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setInteger("charge", 0);
		}

		return nbt;
	}
}