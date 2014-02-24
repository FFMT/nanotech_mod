/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.client.Minecraft;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.NanotechEntity;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechFluid;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

@Mod(modid = NanotechMod.MODID, name = "Nanotech mod", version = "@VERSION@", dependencies = "required-after:FFMTLIBS")
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
	public static final PacketHandler packetHandler = new PacketHandler();

	/**
	 * NanotechMod logger
	 */
	public static Logger nanoLogger;

	/**
	 * Creative tab for blocks
	 */
	public static CreativeTabs CreaB = new CreativeTabs("nanotechtabblock")
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
	public static CreativeTabs CreaI = new CreativeTabs("nanotechtabitem")
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
	public void PreInitnanotechmod(FMLPreInitializationEvent event)
	{
		nanoLogger = event.getModLog();

		if(event.getSide().isClient())
		{
			UtilListerJukebox.scanFolder(Minecraft.getMinecraft());
		}

		NanotechConfiguration.configure(event);
		NanotechOther.initPotion();
		NanotechBlock.initBlock();
		NanotechItem.initItem();
		NanotechFluid.initFluid();
		NanotechFluid.initFluidContainer();
		NanotechOther.initBiomes();
		NanotechDamageSource.loadDamageSource();
		NanotechEntity.initEntities();
		NanotechOther.initGuiHandler();
		NanotechOther.initTileEntity();
		NanotechOther.initEvent();
	}

	@EventHandler
	public void Initnanotechmod(FMLInitializationEvent event)
	{
		NanotechOther.initPackets(packetHandler);
		
		NanotechOther.initForgeDictionary();
		NanotechOther.initBlockHarvestlevel();
		NanotechOther.initWorld();
		NanotechAchievement.initAchievement();
	}

	@EventHandler
	public void PostInitnanotechmod(FMLPostInitializationEvent event)
	{
		proxy.register();
		packetHandler.postInitialise();

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
}
