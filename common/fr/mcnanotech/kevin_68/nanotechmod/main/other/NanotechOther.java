/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.BucketEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.EventBonemeal;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.EventTick;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.LivingEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.PlayerEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.event.RenderEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.PacketJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.PacketSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.PacketSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityButton;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPresent;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.world.NanotechBiome;
import fr.mcnanotech.kevin_68.nanotechmod.main.world.NanotechWorldProvider;
import fr.mcnanotech.kevin_68.nanotechmod.main.world.NitrogenOcean;
import fr.mcnanotech.kevin_68.nanotechmod.main.world.WorldGeneration;

public class NanotechOther
{
	protected static final BiomeGenBase.Height height_nanotechBiome = new BiomeGenBase.Height(0.0F, 0.1F);
	protected static final BiomeGenBase.Height height_nitrogenOcean = new BiomeGenBase.Height(-0.5F, 0.0F);

	public static BiomeGenBase nanotechBiome;
	public static BiomeGenBase nitrogenOcean;

	public static Potion freeze;

	public static void initPackets(PacketHandler packetHandler)
	{
		packetHandler.initialise();
		packetHandler.registerPacket(PacketJumper.class);
		packetHandler.registerPacket(PacketSmoker.class);
		packetHandler.registerPacket(PacketSaber.class);
		NanotechMod.nanoLogger.info("Packets initialized");
	}

	public static void initPotion()
	{
		freeze = new NanotechPotion(30, true, 3035801).setPotionName("potion.freeze").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.50000000596046448D, 2);
		NanotechMod.nanoLogger.info("Potion initialized");
	}

	public static void initBiomes()
	{
		nanotechBiome = new NanotechBiome(NanotechConfiguration.nanotechBiomeID).setBiomeName("Nanotechbiome").setTemperatureRainfall(1.2F, 0.9F).setHeight(height_nanotechBiome);
		nitrogenOcean = new NitrogenOcean(NanotechConfiguration.nitrogenOceanID).setBiomeName("NitrogenOcean").setTemperatureRainfall(-15.0F, -10.0F).setHeight(height_nitrogenOcean);
	}

	public static void initGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(NanotechMod.modInstance, new GuiHandler());
	}

	public static void initTileEntity()
	{
		GameRegistry.registerTileEntity(TileEntityJumper.class, "TileEntityJumper");
		GameRegistry.registerTileEntity(TileEntitySmoker.class, "TileEntitySmoker");
		GameRegistry.registerTileEntity(TileEntityMultiplier.class, "TileEntityMultiplier");
		GameRegistry.registerTileEntity(TileEntityListerJukebox.class, "TileEntityListerJukebox");
		GameRegistry.registerTileEntity(TileEntityButton.class, "TileEntityButton");
		GameRegistry.registerTileEntity(TileEntityPresent.class, "TileEntityPresent");
		GameRegistry.registerTileEntity(TileEntityPortableChest.class, "TileEntityPortableChest");
	}

	public static void initEvent()
	{
		FMLCommonHandler.instance().bus().register(new PlayerEvent());
		FMLCommonHandler.instance().bus().register(new EventTick());
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		MinecraftForge.EVENT_BUS.register(new RenderEvent());
	}

	public static void initForgeDictionary()
	{
		OreDictionary.registerOre("logWood", new ItemStack(NanotechBlock.nanoWood));
		OreDictionary.registerOre("plankWood", new ItemStack(NanotechBlock.nanoPlank));
		OreDictionary.registerOre("treeSapling", new ItemStack(NanotechBlock.nanoSaplings));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NanotechBlock.nanoLeaves));
	}

	public static void initWorld()
	{
		DimensionManager.registerProviderType(NanotechConfiguration.dimensionID, NanotechWorldProvider.class, false);
		DimensionManager.registerDimension(NanotechConfiguration.dimensionID, NanotechConfiguration.dimensionID);
		
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 0);

		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(NanotechBlock.sodium), 1, 5, 6));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(NanotechItem.nanoDisc), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(NanotechItem.alters), 1, 1, 10));
	}
}