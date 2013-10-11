package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.Items;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateCircuit;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientPacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerPacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerTickHandler;
import gregtechmod.api.GregTech_API;

@Mod(modid = "UltimateGraviSuite", name = "Ultimate Gravitation Suite", version = "@GRAVI_VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @NetworkMod.SidedPacketHandler(channels = {"gravisuite"}, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec = @NetworkMod.SidedPacketHandler(channels = {"gravisuite"}, packetHandler = ServerPacketHandler.class))
public class UltimateGraviSuite
{
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ServerProxy")
	public static ServerProxy proxy;
	// Keyboard
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard")
	public static Keyboard keyboard;

	// Items
	public static Item ultimategraviChestPlate;
	public static Item ultimateHelmet;
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

	public static Logger ugslogger;

	// Instance
	@Instance("UltimateGraviSuite")
	public static UltimateGraviSuite instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ugslogger = event.getModLog();
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

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		ultimategraviChestPlate = new UltimateGraviChestPlate(ultimategraviChestPlateID, EnumArmorMaterial.DIAMOND, 0, 1).setUnlocalizedName("ultimategraviChestPlate");
		ultimateHelmet = new UltimateQuantumHelmet(theultimateSolarHelmetID, EnumArmorMaterial.DIAMOND, 0, 0).setUnlocalizedName("theUltimateSolarHelmet");
		ultimateLeggings = new UltimateLeggings(ultimateLeggingsID, EnumArmorMaterial.DIAMOND, 0, 2).setUnlocalizedName("ultimateLeggings");
		ultimateBoots = new UltimateBoots(ultimateBootsID, EnumArmorMaterial.DIAMOND, 0, 3).setUnlocalizedName("ultimateBoots");

		ultimatecircuit = new UltimateCircuit(ultimatecircuitID).setUnlocalizedName("ultimateCircuit").setTextureName("ultimategravisuite:ultimateCircuit");

		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		proxy.initCore();
		proxy.registerRenderers();
	}

	// Mod PostInit
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if(hudPos < 1 || hudPos > 4)
		{
			hudPos = 1;
		}

		try
		{
			ugslogger.fine("Start Mods Check");
			Item gravisuit = (Item)Class.forName("gravisuite.GraviSuite").getField("graviChestPlate").get(null);
			if(Loader.isModLoaded("CompactSolars"))
			{
				ugslogger.fine("CompactSolars loaded");
				try
				{
					Block compactsolar = (Block)Class.forName("cpw.mods.compactsolars.CompactSolars").getField("compactSolarBlock").get(null);
					if(Loader.isModLoaded("gregtech_addon"))
					{
						ugslogger.fine("GregTech loaded");
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimatecircuit, 1), new Object[] {"ABC", "BDB", "CBA", 'A', GregTech_API.getGregTechItem(43, 1, 0), 'B', Items.getItem("advancedCircuit"), 'C', GregTech_API.getGregTechItem(3, 1, 0), 'D', GregTech_API.getGregTechBlock(1, 1, 4)}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[] {"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G', gravisuit, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"PSP", "XUX", "SYS", 'P', new ItemStack(compactsolar, 1, 2), 'X', ultimatecircuit, 'S', "itemSuperconductor", 'U', Items.getItem("quantumHelmet"), 'Y', GregTech_API.getGregTechBlock(1, 1, 4)}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit}));
					}
					else
					{
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimatecircuit, 1), new Object[] {"IAL", "AMA", "LAI", 'I', Items.getItem("iridiumPlate"), 'A', Items.getItem("advancedCircuit"), 'L', Items.getItem("lapotronCrystal"), 'M', Items.getItem("advancedMachine")}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[] {"SNS", "UGU", "SMS", 'N', Item.netherStar, 'G', gravisuit, 'S', "itemSuperconductor", 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"PSP", "XUX", "SYS", 'P', new ItemStack(compactsolar, 1, 2), 'X', ultimatecircuit, 'S', "itemSuperconductor", 'U', Items.getItem("quantumHelmet"), 'Y', Items.getItem("advancedMachine")}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', Items.getItem("lapotronCrystal"), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', Items.getItem("lapotronCrystal"), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
					}
				}
				catch(Exception ex)
				{
					ugslogger.severe("Couldn't get compact solar block, fatal error, recipe no added");
				}
			}

			if(Loader.isModLoaded("AdvancedSolarPanel"))
			{
				ugslogger.fine("AdvancedSolarPanel loaded");
				try
				{
					Block advsolar = (Block)Class.forName("advsolar.AdvancedSolarPanel").getField("blockAdvSolarPanel").get(null);
					Item ultiSolarHelmet = (Item)Class.forName("advsolar.AdvancedSolarPanel").getField("ultimateSolarHelmet").get(null);
					if(Loader.isModLoaded("gregtech_addon"))
					{
						ugslogger.fine("GregTech loaded");
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimatecircuit, 1), new Object[] {"ABC", "BDB", "CBA", 'A', GregTech_API.getGregTechItem(43, 1, 0), 'B', Items.getItem("advancedCircuit"), 'C', GregTech_API.getGregTechItem(3, 1, 0), 'D', GregTech_API.getGregTechBlock(1, 1, 4)}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[] {"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G', gravisuit, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"SAS", "XUX", "SYS", 'A', new ItemStack(advsolar, 1, 2), 'X', ultimatecircuit, 'P', "itemSuperconductor", 'U', ultiSolarHelmet, 'Y', GregTech_API.getGregTechBlock(1, 1, 4)}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimatecircuit}));
					}
					else
					{
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimatecircuit, 1), new Object[] {"IAL", "AMA", "LAI", 'I', Items.getItem("iridiumPlate"), 'A', Items.getItem("advancedCircuit"), 'L', Items.getItem("lapotronCrystal"), 'M', Items.getItem("advancedMachine")}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimategraviChestPlate, 1), new Object[] {"SNS", "UGU", "SMS", 'N', Item.netherStar, 'G', gravisuit, 'S', "itemSuperconductor", 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"SAS", "XUX", "SYS", 'A', new ItemStack(advsolar, 1, 2), 'X', ultimatecircuit, 'S', "itemSuperconductor", 'U', ultiSolarHelmet, 'Y', Items.getItem("advancedMachine")}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', Items.getItem("lapotronCrystal"), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumLeggings"), 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
						GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', Items.getItem("lapotronCrystal"), 'I', Items.getItem("iridiumPlate"), 'Q', Items.getItem("quantumBoots"), 'M', Items.getItem("advancedMachine"), 'U', ultimatecircuit}));
					}
				}
				catch(Exception ex)
				{
					ugslogger.severe("Couldn't get advanced solar block, fatal error, recipe no added");
				}
			}
		}
		catch(Exception ex)
		{
			ugslogger.severe("Fatal error, couldn't init any recipe");
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