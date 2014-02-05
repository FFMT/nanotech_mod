package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.items.NanotechCityItems;
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
	public static final String MODID = "NanotechModCity";

	@Instance("NanotechModCity")
	public static NanotechModCity modInstance;

	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotechmod.city.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotechmod.city.core.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs cityTab = new CreativeTabs("NanotechModCity")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(NanotechCityList.lamp);
		}
	};

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		/*
		 * Configuration cfg = new
		 * Configuration(event.getSuggestedConfigurationFile()); try {
		 * cfg.load(); trashcanID = cfg.getBlock("Trash can", 1100).getInt();
		 * spotLightID = cfg.getBlock("SpotLight", 1101).getInt(); trailID =
		 * cfg.getBlock("Trail", 1121).getInt(); fountainID =
		 * cfg.getBlock("Fountain", 1122).getInt(); lampID =
		 * cfg.getBlock("Lamp", 1123).getInt(); sunShadeID =
		 * cfg.getBlock("SunShade", 1124).getInt(); modernFenceID =
		 * cfg.getBlock("ModernFence", 1125).getInt(); textSpotLightID =
		 * cfg.getBlock("Text Spotlight", 1126).getInt();
		 * 
		 * configCopyID = cfg.getItem("Condif Copy", 5100).getInt(); }
		 * catch(Exception ex) {
		 * NanotechMod.nanoLog.severe("Failed to load configuration"); } finally
		 * { if(cfg.hasChanged()) { cfg.save(); } }
		 */

		NanotechCityBlock.initBlock();
		NanotechCityItems.initItems();
		NanotechCityAchievement.initAchievement();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		System.out.println(String.valueOf(NanotechCityList.fountain != null));
		System.out.println(String.valueOf(NanotechCityList.lamp != null));
		System.out.println(String.valueOf(NanotechCityList.modernFence != null));
		System.out.println(String.valueOf(NanotechCityList.spotLight != null));
		System.out.println(String.valueOf(NanotechCityList.sunShade != null));
		System.out.println(String.valueOf(NanotechCityList.textSpotLight != null));
		System.out.println(String.valueOf(NanotechCityList.trail != null));
		System.out.println(String.valueOf(NanotechCityList.trashcan != null));
		// TODO GameRegistry.registerCraftingHandler(new CityCraftingHandler());

		//NetworkRegistry.instance().registerGuiHandler(this.modInstance, new GuiHandler());
		// TODO NetworkRegistry.instance().registerChannel(new PacketHandler(),
		// "nanotechmodcity");

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

		GameRegistry.addRecipe(new ItemStack(NanotechCityList.lamp, 1), new Object[] {"IDI", "GSG", "III", 'I', Items.iron_ingot, 'D', Blocks.daylight_detector, 'G', Blocks.glass_pane, 'S', Blocks.glowstone});
		GameRegistry.addRecipe(new ItemStack(NanotechCityList.sunShade, 1), new Object[] {"WWW", " S ", " S ", 'W', Blocks.wool, 'S', Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechCityList.trail, 1), new Object[] {Blocks.grass, Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechCityList.fountain, 1), new Object[] {"S S", "SWS", "SPS", 'S', new ItemStack(Blocks.stone_slab, 0), 'W', Items.water_bucket, 'P', Blocks.piston});
		GameRegistry.addRecipe(new ItemStack(NanotechCityList.modernFence, 4), new Object[] {"I I", "III", "I I", 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(NanotechCityList.trashcan, 1), new Object[] {"I I", "ICI", "III", 'I', Items.iron_ingot, 'C', Blocks.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechCityList.spotLight), new Object[] {"OAO", "RGB", "OAO", 'O', Blocks.obsidian, 'A', Blocks.glass, 'R', new ItemStack(Items.dye, 1, 1), 'G', new ItemStack(Items.dye, 1, 2), 'B', new ItemStack(Items.dye, 1, 4)});
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		NanotechCityAchievement.addAchievementInPage();
		
	}
}