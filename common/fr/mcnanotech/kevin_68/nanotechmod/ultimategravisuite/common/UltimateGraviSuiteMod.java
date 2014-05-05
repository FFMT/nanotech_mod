/**
This work is made available under the terms of the Creative Commons Attribution License:
http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en

Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */

package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.IC2Items;
import ic2.core.IC2;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacketHandler;

@Mod(modid = "UltimateGraviSuite", name = "Ultimate Gravitation Suite", version = "@VERSION@")
public class UltimateGraviSuiteMod
{
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.CommonProxy")
	public static CommonProxy proxy;

	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client.UGSKeyboardClient", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UGSKeyboard")
	public static UGSKeyboard keyboard;

	// Items
	public static Item ultimateGraviChestPlate, ultimateHelmet, ultimateCircuit, ultimateLeggings, ultimateBoots;

	// Config
	public static int uhGenDay, uhGenNight, ultimateMinCharge, ultimateUseByTick, boostUseByTick;
	public static boolean displayHud;
	public static String hudPos;

	public static final FFMTPacketHandler packetHandler = new FFMTPacketHandler("fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.packet", "UltimateGraviSuite");

	public static Logger ugslogger;

	@Instance("UltimateGraviSuite")
	public static UltimateGraviSuiteMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ugslogger = event.getModLog();
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			hudPos = cfg.get(cfg.CATEGORY_GENERAL, "hudPosition", "left", "hud position. Valid value : right and left").getString();
			displayHud = cfg.get(cfg.CATEGORY_GENERAL, "Display hud", true).getBoolean(true);
			uhGenDay = cfg.get(cfg.CATEGORY_GENERAL, "the output of the ultimate helmet during day time", 1024).getInt();
			uhGenNight = cfg.get(cfg.CATEGORY_GENERAL, "the output of the ultimate helmet during night time", 0).getInt();
			ultimateMinCharge = cfg.get(cfg.CATEGORY_GENERAL, "ultimate min charge", 1000000, "the minimum charge to use invisibility and fly").getInt();
			ultimateUseByTick = cfg.get(cfg.CATEGORY_GENERAL, "ultimate use by tick", 1200, "the use of the ultimate by tick when fly or invisibility is enable").getInt();
			boostUseByTick = cfg.get(cfg.CATEGORY_GENERAL, "boost use by tick", 6000, "the use of the ultimate by tick when you use boost mode").getInt();
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

		ultimateHelmet = new UltimateArmor(ArmorMaterial.DIAMOND, 0).setUnlocalizedName("ultimateSolarHelmet").setTextureName("ultimategravisuite:ultimate_helmet");
		ultimateGraviChestPlate = new UltimateArmor(ArmorMaterial.DIAMOND, 1).setUnlocalizedName("ultimategraviChestPlate").setTextureName("ultimategravisuite:ultimate_gravi_chestplate");
		ultimateLeggings = new UltimateArmor(ArmorMaterial.DIAMOND, 2).setUnlocalizedName("ultimateLeggings").setTextureName("ultimategravisuite:ultimate_leggings");
		ultimateBoots = new UltimateArmor(ArmorMaterial.DIAMOND, 3).setUnlocalizedName("ultimateBoots").setTextureName("ultimategravisuite:ultimate_boots");
		ultimateCircuit = new Item().setUnlocalizedName("ultimateCircuit").setTextureName("ultimategravisuite:ultimate_circuit").setCreativeTab(IC2.tabIC2);

		GameRegistry.registerItem(ultimateHelmet, "ultimateHelmet");
		GameRegistry.registerItem(ultimateGraviChestPlate, "ultimateGraviChestPlate");
		GameRegistry.registerItem(ultimateLeggings, "ultimateLeggings");
		GameRegistry.registerItem(ultimateBoots, "ultimateBoots");
		GameRegistry.registerItem(ultimateCircuit, "ultimateCircuit");
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.init();
		FMLCommonHandler.instance().bus().register(new UGSCommonEventHandler());
		MinecraftForge.EVENT_BUS.register(new UGSCommonEventHandler());

		packetHandler.initialise("UGS|Packets");

		ugslogger.info("Start Mods Check");
		Item gravisuit = GameRegistry.findItem("GraviSuite", "graviChestPlate"); // TODO
																					// check
																					// when
																					// GraviSuite
																					// is
																					// release
																					// for
																					// 1.7.2
		if(Loader.isModLoaded("CompactSolars"))
		{
			Block compactsolar = GameRegistry.findBlock("CompactSolars", "CompactSolarBlock");
			if(compactsolar != null)
			{
				if(Loader.isModLoaded("gregtech_addon"))
				{
					/*
					 * ugslogger.info("GregTech loaded");
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateCircuit, 1), new Object[] {"ABC",
					 * "BDB", "CBA", 'A', GregTech_API.getGregTechItem(43, 1,
					 * 0), 'B', IC2Items.getItem("advancedCircuit"), 'C',
					 * GregTech_API.getGregTechItem(3, 1, 0), 'D',
					 * GregTech_API.getGregTechBlock(1, 1, 4)}));
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateGraviChestPlate, 1), new Object[]
					 * {"SIS", "XGX", "SYS", 'I',
					 * GregTech_API.getGregTechItem(38, 1, 1), 'G', gravisuit,
					 * 'S', "itemSuperconductor", 'Y',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'X',
					 * ultimateCircuit})); GameRegistry.addRecipe(new
					 * ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new
					 * Object[] {"PSP", "XUX", "SYS", 'P', new
					 * ItemStack(compactsolar, 1, 2), 'X', ultimateCircuit, 'S',
					 * "itemSuperconductor", 'U',
					 * IC2Items.getItem("quantumHelmet"), 'Y',
					 * GregTech_API.getGregTechBlock(1, 1, 4)}));
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateLeggings, 1), new Object[] {"SDS",
					 * "UQU", "ICI", 'S', "itemSuperconductor", 'D',
					 * GregTech_API.getGregTechItem(37, 1, 1), 'I',
					 * IC2Items.getItem("iridiumPlate"), 'Q',
					 * IC2Items.getItem("quantumLeggings"), 'C',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'U',
					 * ultimateCircuit})); GameRegistry.addRecipe(new
					 * ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new
					 * Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor",
					 * 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I',
					 * IC2Items.getItem("iridiumPlate"), 'Q',
					 * IC2Items.getItem("quantumBoots"), 'C',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'U',
					 * ultimateCircuit}));
					 */
				}
				else
				{
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateCircuit, 1), new Object[] {"IAL", "AMA", "LAI", 'I', IC2Items.getItem("iridiumPlate"), 'A', IC2Items.getItem("advancedCircuit"), 'L', IC2Items.getItem("lapotronCrystal"), 'M', IC2Items.getItem("advancedMachine")}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateGraviChestPlate, 1), new Object[] {"SNS", "UGU", "SMS", 'N', Items.nether_star, 'G', gravisuit, 'S', "itemSuperconductor", 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"PSP", "XUX", "SYS", 'P', new ItemStack(compactsolar, 1, 2), 'X', ultimateCircuit, 'S', "itemSuperconductor", 'U', IC2Items.getItem("quantumHelmet"), 'Y', IC2Items.getItem("advancedMachine")}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', IC2Items.getItem("lapotronCrystal"), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumLeggings"), 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', IC2Items.getItem("lapotronCrystal"), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumBoots"), 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
				}
				ugslogger.info("CompactSolars loaded");
			}
			else
			{
				ugslogger.error("Couldn't get compact solar block, fatal error, recipe no added");
			}
		}

		if(Loader.isModLoaded("AdvancedSolarPanel"))
		{
			Block advsolar = GameRegistry.findBlock("AdvancedSolarPanel", "BlockAdvSolarPanel");
			Item ultiSolarHelmet = GameRegistry.findItem("AdvancedSolarPanel", "ultimateSolarHelmet"); // TODO
																										// check
																										// when
																										// ASP
																										// is
																										// release
																										// for
																										// 1.7.2

			if(advsolar != null && ultiSolarHelmet != null)
			{
				if(Loader.isModLoaded("gregtech_addon"))
				{
					/*
					 * ugslogger.info("GregTech loaded");
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateCircuit, 1), new Object[] {"ABC",
					 * "BDB", "CBA", 'A', GregTech_API.getGregTechItem(43, 1,
					 * 0), 'B', IC2Items.getItem("advancedCircuit"), 'C',
					 * GregTech_API.getGregTechItem(3, 1, 0), 'D',
					 * GregTech_API.getGregTechBlock(1, 1, 4)}));
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateGraviChestPlate, 1), new Object[]
					 * {"SIS", "XGX", "SYS", 'I',
					 * GregTech_API.getGregTechItem(38, 1, 1), 'G', gravisuit,
					 * 'S', "itemSuperconductor", 'Y',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'X',
					 * ultimateCircuit})); GameRegistry.addRecipe(new
					 * ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new
					 * Object[] {"SAS", "XUX", "SYS", 'A', new
					 * ItemStack(advsolar, 1, 2), 'X', ultimateCircuit, 'P',
					 * "itemSuperconductor", 'U', ultiSolarHelmet, 'Y',
					 * GregTech_API.getGregTechBlock(1, 1, 4)}));
					 * GameRegistry.addRecipe(new ShapedOreRecipe(new
					 * ItemStack(ultimateLeggings, 1), new Object[] {"SDS",
					 * "UQU", "ICI", 'S', "itemSuperconductor", 'D',
					 * GregTech_API.getGregTechItem(37, 1, 1), 'I',
					 * IC2Items.getItem("iridiumPlate"), 'Q',
					 * IC2Items.getItem("quantumLeggings"), 'C',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'U',
					 * ultimateCircuit})); GameRegistry.addRecipe(new
					 * ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new
					 * Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor",
					 * 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I',
					 * IC2Items.getItem("iridiumPlate"), 'Q',
					 * IC2Items.getItem("quantumBoots"), 'C',
					 * GregTech_API.getGregTechBlock(1, 1, 4), 'U',
					 * ultimateCircuit}));
					 */
				}
				else
				{
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateCircuit, 1), new Object[] {"IAL", "AMA", "LAI", 'I', IC2Items.getItem("iridiumPlate"), 'A', IC2Items.getItem("advancedCircuit"), 'L', IC2Items.getItem("lapotronCrystal"), 'M', IC2Items.getItem("advancedMachine")}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateGraviChestPlate, 1), new Object[] {"SNS", "UGU", "SMS", 'N', Items.nether_star, 'G', gravisuit, 'S', "itemSuperconductor", 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateHelmet, 1), new Object[] {"SAS", "XUX", "SYS", 'A', new ItemStack(advsolar, 1, 2), 'X', ultimateCircuit, 'S', "itemSuperconductor", 'U', ultiSolarHelmet, 'Y', IC2Items.getItem("advancedMachine")}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', IC2Items.getItem("lapotronCrystal"), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumLeggings"), 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "IMI", 'S', "itemSuperconductor", 'D', IC2Items.getItem("lapotronCrystal"), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumBoots"), 'M', IC2Items.getItem("advancedMachine"), 'U', ultimateCircuit}));
				}
				ugslogger.info("AdvancedSolarPanel loaded");
			}
			else
			{
				ugslogger.error("Couldn't get advanced solar block, fatal error, recipe no added");
			}
		}
		if(!Loader.isModLoaded("CompactSolars") && !Loader.isModLoaded("AdvancedSolarPanel"))
		{
			ugslogger.error("Fatal error, couldn't init any recipe, please install compact solars panel or advanced solar panel");
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		packetHandler.postInitialise();
	}
}