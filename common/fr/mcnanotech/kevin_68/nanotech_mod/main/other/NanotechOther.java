package fr.mcnanotech.kevin_68.nanotech_mod.main.other;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.BucketEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.EventBonemeal;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.LivingEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.PlayerEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.PlayerTracker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.event.TextureEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityButton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityPresent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.CraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.NanotechServerTickHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechBiome;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechWorldProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NitrogenOcean;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.WorldGeneration;

public class NanotechOther
{
	public static Fluid liquidNitrogen;

	public static BiomeGenBase nanotechBiome;
	public static BiomeGenBase nitrogenOcean;

	public static Potion freeze;

	public static void registerLiquid(int state)
	{
		if(state == 0)
		{
			liquidNitrogen = new Fluid("liquidnitrogen").setDensity(4000).setViscosity(500).setTemperature(77).setLuminosity(0).setUnlocalizedName("liquidNitrogen");
			FluidRegistry.registerFluid(liquidNitrogen);
			liquidNitrogen = FluidRegistry.getFluid("liquidnitrogen");
		}
		else if(state == 1)
		{
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidnitrogen", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(NanotechItem.nitrogenBucket), FluidContainerRegistry.EMPTY_BUCKET);
		}
		else
		{
			Nanotech_mod.nanoLog.severe("Error on call liquid register");
		}
	}

	public static void registerWorld()
	{
		nanotechBiome = new NanotechBiome(Nanotech_mod.nanotechBiomeID).setBiomeName("Nanotechbiome").setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.0F, 0.1F);
		nitrogenOcean = new NitrogenOcean(Nanotech_mod.nitrogenOceanID).setBiomeName("NitrogenOcean").setTemperatureRainfall(-15.0F, -10.0F).setMinMaxHeight(-0.5F, 0.0F);

		DimensionManager.registerProviderType(Nanotech_mod.dimensionID, NanotechWorldProvider.class, false);
		DimensionManager.registerDimension(Nanotech_mod.dimensionID, Nanotech_mod.dimensionID);

		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(NanotechBlock.sodium), 1, 5, 6));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(NanotechItem.nanoDisc), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(NanotechItem.alters), 1, 1, 10));

		GameRegistry.registerWorldGenerator(new WorldGeneration());

	}

	public static void registerPotion()
	{
		freeze = new NanotechPotion(30, true, 3035801).setPotionName("potion.freeze").setIconIndex(0, 0).func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.50000000596046448D, 2);
	}

	public static void registerGuiAndTileEntity()
	{
		NetworkRegistry.instance().registerGuiHandler(Nanotech_mod.modInstance, new GuiHandler());
		NetworkRegistry.instance().registerChannel(new PacketHandler(), "nanotechmod");

		GameRegistry.registerTileEntity(TileEntityJumper.class, "TileEntityJumper");
		GameRegistry.registerTileEntity(TileEntitySmoker.class, "TileEntitySmoker");
		GameRegistry.registerTileEntity(TileEntityMultiplier.class, "TileEntityMultiplier");
		GameRegistry.registerTileEntity(TileEntityListerJukebox.class, "TileEntityListerJukebox");
		GameRegistry.registerTileEntity(TileEntityButton.class, "TileEntityButton");
		GameRegistry.registerTileEntity(TileEntityPresent.class, "TileEntityPresent");
	}

	public static void registerForgeDictionary()
	{
		OreDictionary.registerOre("logWood", new ItemStack(NanotechBlock.nanoWood));
		OreDictionary.registerOre("plankWood", new ItemStack(NanotechBlock.nanoPlanks));
		OreDictionary.registerOre("treeSapling", new ItemStack(NanotechBlock.nanoSaplings));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NanotechBlock.nanoLeaves));
	}

	public static void registerBlockHarvestlevel()
	{
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.nanoGrass, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(NanotechBlock.notfalling, "shovel", 2);
	}

	public static void registerEvent()
	{
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		MinecraftForge.EVENT_BUS.register(new PlayerEvent());
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		MinecraftForge.EVENT_BUS.register(new TextureEvent());
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		GameRegistry.registerPlayerTracker(new PlayerTracker());
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		TickRegistry.registerTickHandler(new NanotechServerTickHandler(), Side.SERVER);
	}
}