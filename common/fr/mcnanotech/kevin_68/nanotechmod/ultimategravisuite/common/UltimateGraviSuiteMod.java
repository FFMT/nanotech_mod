/**
This work is made available under the terms of the Creative Commons Attribution License:
http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en

Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */

package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.IC2Items;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

//@Mod(modid = "UltimateGraviSuite", name = "Ultimate Gravitation Suite", version = "@VERSION@")

public class UltimateGraviSuiteMod
{
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.CommonProxy")
	public static CommonProxy proxy;

	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client.UGSKeyboardClient", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UGSKeyboard")
	public static UGSKeyboard keyboard;

	// Items
	public static Item ultimateGraviChestPlate;
	public static Item ultimateHelmet;
	public static Item ultimateCircuit;
	public static Item ultimateLeggings;
	public static Item ultimateBoots;

	// Config
	public static int hudPos;
	public static int uhGenDay = 1024;
	public static int uhGenNight = 0;
	public static boolean displayHud;

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
		ultimateGraviChestPlate = new UltimateGraviChestPlate(ArmorMaterial.DIAMOND, 0, 1).setUnlocalizedName("ultimategraviChestPlate");
		ultimateHelmet = new UltimateQuantumHelmet(ArmorMaterial.DIAMOND, 0, 0).setUnlocalizedName("ultimateSolarHelmet");
		ultimateLeggings = new UltimateLeggings(ArmorMaterial.DIAMOND, 0, 2).setUnlocalizedName("ultimateLeggings");
		ultimateBoots = new UltimateBoots(ArmorMaterial.DIAMOND, 0, 3).setUnlocalizedName("ultimateBoots");

		ultimateCircuit = new UltimateCircuit().setUnlocalizedName("ultimateCircuit").setTextureName("ultimategravisuite:ultimateCircuit");

		GameRegistry.registerItem(ultimateGraviChestPlate, "ultimateGraviChestPlate");
		GameRegistry.registerItem(ultimateHelmet, "ultimateHelmet");
		GameRegistry.registerItem(ultimateLeggings, "ultimateLeggings");
		GameRegistry.registerItem(ultimateBoots, "ultimateBoots");
		GameRegistry.registerItem(ultimateCircuit, "ultimateCircuit");

		proxy.init();
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
			ugslogger.info("Start Mods Check");
			Item gravisuit = GameRegistry.findItem("GraviSuite", "graviChestPlate"); // TODO check when GraviSuite is release for 1.7.2
			if(Loader.isModLoaded("CompactSolars"))
			{
				ugslogger.info("CompactSolars loaded");
				try
				{
					Block compactsolar = GameRegistry.findBlock("CompactSolars", "CompactSolarBlock");
					if(Loader.isModLoaded("gregtech_addon"))
					{
						/*
						 * ugslogger.info("GregTech loaded"); GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateCircuit, 1), new Object[] {"ABC", "BDB", "CBA", 'A',
						 * GregTech_API.getGregTechItem(43, 1, 0), 'B', IC2Items.getItem("advancedCircuit"), 'C', GregTech_API.getGregTechItem(3, 1, 0), 'D', GregTech_API.getGregTechBlock(1, 1, 4)}));
						 * GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateGraviChestPlate, 1), new Object[] {"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G',
						 * gravisuit, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimateCircuit})); GameRegistry.addRecipe(new ShapedOreRecipe(new
						 * ItemStack(ultimateHelmet, 1), new Object[] {"PSP", "XUX", "SYS", 'P', new ItemStack(compactsolar, 1, 2), 'X', ultimateCircuit, 'S', "itemSuperconductor", 'U',
						 * IC2Items.getItem("quantumHelmet"), 'Y', GregTech_API.getGregTechBlock(1, 1, 4)})); GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new
						 * Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', IC2Items.getItem("iridiumPlate"), 'Q',
						 * IC2Items.getItem("quantumLeggings"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimateCircuit})); GameRegistry.addRecipe(new ShapedOreRecipe(new
						 * ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU", "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I',
						 * IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumBoots"), 'C', GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimateCircuit}));
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
				}
				catch(Exception ex)
				{
					ugslogger.error("Couldn't get compact solar block, fatal error, recipe no added");
				}
			}

			if(Loader.isModLoaded("AdvancedSolarPanel"))
			{
				ugslogger.info("AdvancedSolarPanel loaded");
				try
				{
					Block advsolar = GameRegistry.findBlock("AdvancedSolarPanel", "BlockAdvSolarPanel");
					Item ultiSolarHelmet = GameRegistry.findItem("AdvancedSolarPanel", "ultimateSolarHelmet"); // TODO check when ASP is release for 1.7.2
					if(Loader.isModLoaded("gregtech_addon"))
					{
						/*
						 * ugslogger.info("GregTech loaded"); GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateCircuit, 1), new Object[] {"ABC", "BDB", "CBA", 'A',
						 * GregTech_API.getGregTechItem(43, 1, 0), 'B', IC2Items.getItem("advancedCircuit"), 'C', GregTech_API.getGregTechItem(3, 1, 0), 'D', GregTech_API.getGregTechBlock(1, 1, 4)}));
						 * GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateGraviChestPlate, 1), new Object[] {"SIS", "XGX", "SYS", 'I', GregTech_API.getGregTechItem(38, 1, 1), 'G',
						 * gravisuit, 'S', "itemSuperconductor", 'Y', GregTech_API.getGregTechBlock(1, 1, 4), 'X', ultimateCircuit})); GameRegistry.addRecipe(new ShapedOreRecipe(new
						 * ItemStack(ultimateHelmet, 1), new Object[] {"SAS", "XUX", "SYS", 'A', new ItemStack(advsolar, 1, 2), 'X', ultimateCircuit, 'P', "itemSuperconductor", 'U', ultiSolarHelmet,
						 * 'Y', GregTech_API.getGregTechBlock(1, 1, 4)})); GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateLeggings, 1), new Object[] {"SDS", "UQU", "ICI", 'S',
						 * "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumLeggings"), 'C',
						 * GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimateCircuit})); GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ultimateBoots, 1), new Object[] {"SDS", "UQU",
						 * "ICI", 'S', "itemSuperconductor", 'D', GregTech_API.getGregTechItem(37, 1, 1), 'I', IC2Items.getItem("iridiumPlate"), 'Q', IC2Items.getItem("quantumBoots"), 'C',
						 * GregTech_API.getGregTechBlock(1, 1, 4), 'U', ultimateCircuit}));
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
				}
				catch(Exception ex)
				{
					ugslogger.error("Couldn't get advanced solar block, fatal error, recipe no added");
				}
			}
		}
		catch(Exception ex)
		{
			ugslogger.error("Fatal error, couldn't init any recipe");
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
