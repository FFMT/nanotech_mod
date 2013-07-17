package fr.mcnanotech.FFMT.FFMTAPITestMod.Core;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTColor;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTEntityHelper;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTRegistry;
import fr.mcnanotech.FFMT.FFMTAPITestMod.Entity.FFMTAPIMobTest;

@Mod(modid = "FFMTAPITestMod", name = "FFMT API Test Mod", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

/**
 * @author kevin_68
 */
public class FFMTAPITestMod 
{
	public static Logger FFMTTMlog;
	
	@Instance("FFMTAPITestMod")
	public static FFMTAPITestMod FFMTAPITestMod;
	
	@PreInit
	public void preload(FMLPreInitializationEvent event)
	{
		FFMTTMlog = FMLLog.getLogger();
		FFMTTMlog.log(Level.INFO, "PreInitialization");

	}
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{

		FFMTTMlog.log(Level.INFO, "Initialization");
	}
	
	
	@PostInit
	public void postload(FMLPostInitializationEvent event)
	{
		
		FFMTRegistry.addToolsCrafting(new ItemStack(Item.seeds), 0, new ItemStack(Item.axeDiamond), new ItemStack(Item.stick));
		FFMTRegistry.addToolsCrafting(new ItemStack(Item.seeds), 1, new ItemStack(Item.shovelDiamond), new ItemStack(Item.stick));
		FFMTRegistry.addToolsCrafting(new ItemStack(Item.seeds), 2, new ItemStack(Item.hoeDiamond), new ItemStack(Item.stick));
		FFMTRegistry.addToolsCrafting(new ItemStack(Item.seeds), 3, new ItemStack(Item.pickaxeDiamond), new ItemStack(Item.stick));
		FFMTRegistry.addToolsCrafting(new ItemStack(Item.seeds), 4, new ItemStack(Item.swordDiamond), new ItemStack(Item.stick));
		FFMTRegistry.addAllArmorCrafting(new ItemStack(Item.seeds), new ItemStack(Item.helmetChain), new ItemStack(Item.plateChain), new ItemStack(Item.legsChain), new ItemStack(Item.bootsChain));
		FFMTRegistry.addArmorCrafting(new ItemStack(Block.dirt), 0, new ItemStack(Item.helmetGold));
		FFMTRegistry.addArmorCrafting(new ItemStack(Block.dirt), 1, new ItemStack(Item.plateGold));
		FFMTRegistry.addArmorCrafting(new ItemStack(Block.dirt), 2, new ItemStack(Item.legsGold));
		FFMTRegistry.addArmorCrafting(new ItemStack(Block.dirt), 3, new ItemStack(Item.bootsGold));
		FFMTRegistry.addSmeltingWithMetadata(Item.dyePowder.itemID, 1, new ItemStack(Item.diamond), 0.0F);
		FFMTEntityHelper.addMob(FFMTAPIMobTest.class, "FFMT API Mob Test", 0, this, 100, 1, true, FFMTColor.blackInt, FFMTColor.greenInt, 10, 1, 5, EnumCreatureType.monster, BiomeGenBase.desert);
		FFMTRegistry.correctName("FFMT API Mob Test", "entity.", ".name", "en_US");
	}
}
