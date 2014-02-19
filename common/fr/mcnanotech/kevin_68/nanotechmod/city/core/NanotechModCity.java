/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.items.NanotechCityItems;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.PacketSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.PacketSpotLightKey;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.PacketTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.PacketTextSpotLightString;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityModernFence;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrashCan;

@Mod(modid = NanotechModCity.MODID, name = "Nanotech mod City", version = "@VERSION@")
public class NanotechModCity
{
	/**
	 * NanotechModCity mod IDentifier
	 */
	public static final String MODID = "nanotechmodcity";

	/**
	 * NanotechModCity mod instance
	 */
	@Instance(MODID)
	public static NanotechModCity modInstance;

	/**
	 * NanotechModCity CommonProxy
	 */
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.city.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.city.core.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * NanotechModCity packethandler
	 */
	public static final PacketHandler packetHandler = new PacketHandler();

	/**
	 * NanotechModCity logger
	 */
	public static Logger nanoCityLogger;

	/**
	 * CreativeTab of NanotechModCity
	 */
	public static CreativeTabs cityTab = new CreativeTabs("NanotechModCity")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(NanotechCityBlock.lamp);
		}
	};

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		NanotechCityBlock.initBlock();
		NanotechCityItems.initItems();
		NanotechCityAchievement.initAchievement();
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new CityCraftingHandler());

		NetworkRegistry.INSTANCE.registerGuiHandler(this.modInstance, new GuiHandler());
		packetHandler.initialise();
		packetHandler.registerPacket(PacketSpotLight.class);
		packetHandler.registerPacket(PacketSpotLightKey.class);
		packetHandler.registerPacket(PacketTextSpotLight.class);
		packetHandler.registerPacket(PacketTextSpotLightString.class);

		GameRegistry.registerTileEntity(TileEntitySpotLight.class, "SpotLight");
		GameRegistry.registerTileEntity(TileEntityTrail.class, "Trail");
		GameRegistry.registerTileEntity(TileEntityFountain.class, "Fountain");
		GameRegistry.registerTileEntity(TileEntityLamp.class, "Lamp");
		GameRegistry.registerTileEntity(TileEntityLampLight.class, "LampLight");
		GameRegistry.registerTileEntity(TileEntitySunShade.class, "SunShade");
		GameRegistry.registerTileEntity(TileEntityModernFence.class, "ModernFence");
		GameRegistry.registerTileEntity(TileEntityTrashCan.class, "Trashcan");
		GameRegistry.registerTileEntity(TileEntityTextSpotLight.class, "TextSpotLight");

		proxy.registerTileRenders();

		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.lamp, 1), new Object[] {"IDI", "GSG", "III", 'I', Items.iron_ingot, 'D', Blocks.daylight_detector, 'G', Blocks.glass_pane, 'S', Blocks.glowstone});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.sunShade, 1), new Object[] {"WWW", " S ", " S ", 'W', Blocks.wool, 'S', Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechCityBlock.trail, 1), new Object[] {Blocks.grass, Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.fountain, 1), new Object[] {"S S", "SWS", "SPS", 'S', new ItemStack(Blocks.stone_slab, 0), 'W', Items.water_bucket, 'P', Blocks.piston});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.modernFence, 4), new Object[] {"I I", "III", "I I", 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.trashcan, 1), new Object[] {"I I", "ICI", "III", 'I', Items.iron_ingot, 'C', Blocks.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.spotlight), new Object[] {"OAO", "RGB", "OAO", 'O', Blocks.obsidian, 'A', Blocks.glass, 'R', new ItemStack(Items.dye, 1, 1), 'G', new ItemStack(Items.dye, 1, 2), 'B', new ItemStack(Items.dye, 1, 4)});
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		NanotechCityAchievement.addAchievementInPage();
		packetHandler.postInitialise();
	}
}