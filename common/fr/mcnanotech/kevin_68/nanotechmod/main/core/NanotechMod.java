/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.NanotechEntity;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechFluid;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacketHandler;
import fr.minecraftforgefrance.ffmtlibs.network.PacketManager;

@Mod(modid = NanotechMod.MODID, name = "Nanotech mod", version = "@VERSION@", dependencies = "required-after:ffmtlibs")
public class NanotechMod
{
	/**
	 * NanotechMod's mod Identifier
	 */
	public static final String MODID = "NanotechMod";

	/**
	 * Instance of NanotechMod
	 */
	@Instance(MODID)
	public static NanotechMod modInstance;

	/**
	 * Instance of NanotechMod's CommonProxy
	 */
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.main.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.main.core.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * NanotechMod packethandler
	 */
	public static final PacketManager packetHandler = new PacketManager("fr.mcnanotech.kevin_68.nanotechmod.main.network.packet", MODID, "NanotechMod");

	/**
	 * NanotechMod logger
	 */
	public static Logger nanoLogger;

	/**
	 * Creative tab for blocks
	 */
	public static CreativeTabs CreaB = new CreativeTabs("nanotech.blocks")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(NanotechBlock.speed);
		}
	};

	/**
	 * Creative tab for items
	 */
	public static CreativeTabs CreaI = new CreativeTabs("nanotech.items")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return NanotechItem.itemBase;
		}

		@SideOnly(Side.CLIENT)
		public int func_151243_f()
		{
			return 12;
		}
	};

	@EventHandler
	public void preInitNanotechMod(FMLPreInitializationEvent event)
	{
		nanoLogger = event.getModLog();

		if(event.getSide().isClient())
		{
			UtilSoundBox.init();
		}

		NanotechConfiguration.configure(event);
		NanotechOther.initPotion();
		NanotechBlock.initBlock();
		NanotechItem.initItem();
		NanotechFluid.initFluid(event.getSide());
		NanotechFluid.initFluidContainer();
		NanotechOther.initBiomes();
		NanotechDamageSource.loadDamageSource();
		NanotechEntity.initEntities();
		NanotechOther.initGuiHandler();
		NanotechOther.initTileEntity();
		NanotechOther.initEvent(event.getSide());
	}

	@EventHandler
	public void initNanotechMod(FMLInitializationEvent event)
	{
		NanotechMod.nanoLogger.info("Packets initialized");

		NanotechOther.initForgeDictionary();
		NanotechOther.initWorld();
		NanotechAchievement.initAchievement();
	}

	@EventHandler
	public void postInitNanotechMod(FMLPostInitializationEvent event)
	{
		proxy.register();

		GameRegistry.addRecipe(new INanotechRecipe());
		NanotechRecipe.InitCommonRecipes();
		if(NanotechConfiguration.hardRecipe)
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
	
	@EventHandler
	public void onServerStarted(FMLServerStartedEvent event)
	{
		UtilSoundBox.serverInit();
	}

	public static class BaseNTMEntry
	{
		private final String name;

		public BaseNTMEntry(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return name;
		}
	}
}
