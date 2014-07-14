package fr.mcnanotech.kevin_68.nanotechmod.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.blocks.NTMBlocks;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.NTMTileEntity;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight;
import fr.minecraftforgefrance.ffmtlibs.network.PacketManager;

@Mod(modid = NanotechMod.MODID, name = "Nanotech mod", version = "@VERSION@", dependencies = "required-after:ffmtlibs")
public class NanotechMod
{
	public static final String MODID = "nanotechmod";

	@Instance(MODID)
	public static NanotechMod modInstance;

	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.core.CommonProxy")
	public static CommonProxy proxy;

	public static final PacketManager packetHandler = new PacketManager("fr.mcnanotech.kevin_68.nanotechmod.core.network.packets", MODID, "NanotechMod");

	public static Logger log;

	public static CreativeTabs blockTab = new CreativeTabs("nanotech.blocks")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.anvil);
		}
	};

	public static CreativeTabs itemTab = new CreativeTabs("nanotech.items")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Items.apple;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int func_151243_f()// Items's metadata
		{
			return 0;
		}
	};

	@EventHandler
	public void preInitNanotechMod(FMLPreInitializationEvent event)
	{
		log = event.getModLog();
		NTMBlocks.initBlock();

		NTMTileEntity.registerTiles();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this.modInstance, new GuiHandler());
	}

	@EventHandler
	public void initNanotechMod(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public void postInitNanotechMod(FMLPostInitializationEvent event)
	{
		proxy.register();
		if(event.getSide() == Side.CLIENT)
		{
			UtilSpotLight.list();
		}
	}
}