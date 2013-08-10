package fr.mcnanotech.FFMT.FFMTAPI;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.IsWorking;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.UnTested;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.UnknownTestStatus;

/**
 * @authors kevin_68, elias54
 */
public class FFMTRegistry 
{

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Spawn particles (Blocks only)
	 * @param speed
	 * @param particles (ex: "smoke", "largesmoke", "enchantmenttable", ...)
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 * @param random
	 */
	@UnTested
	@SideOnly(Side.CLIENT)
	public static void spawnParticles(int speed, String particles, World world, int posX, int posY, int posZ, Random random)
	{
		float var7 = (float)posX + random.nextFloat() ;
		float var8 = (float)posY + random.nextFloat() * 0.1F;
		float var9 = (float)posZ + random.nextFloat() ;

		for(int i = 0; i < speed; i++)
		{
			world.spawnParticle(particles, (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
		}
	}

	/**
	 * Spawn particles (Blocks only)
	 * @param speed
	 * @param particles (ex: "smoke", "largesmoke", "enchantmenttable", ...)
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 * @param random
	 * @param velX (If not specified, by default is 0.0D)
	 * @param velY (If not specified, by default is 0.0D)
	 * @param velZ (If not specified, by default is 0.0D)
	 */
	@UnTested
	@SideOnly(Side.CLIENT)
	public static void spawnParticles(int speed, String particles, World world, int posX, int posY, int posZ, Random random, double velX, double velY, double velZ)
	{
		float var7 = (float)posX + random.nextFloat() ;
		float var8 = (float)posY + random.nextFloat() * 0.1F;
		float var9 = (float)posZ + random.nextFloat() ;

		for(int i = 0; i < speed; i++)
		{
			world.spawnParticle(particles, (double)var7, (double)var8, (double)var9, velX, velY, velZ);
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Adding version checker rewritten by robin4002 original by elias
	 * @param event (FMLPreInitializationEvent put it in preinit)
	 * @param versionUrl (your txt url with the last version number)
	 * @param downloadurl
	 * @param modname
	 * @param actuallyversion
	 */
	@IsWorking
	public static void registerVersionCheck(FMLPreInitializationEvent event, String versionUrl, String downloadurl, String modname, String actuallyversion)
	{
		FFMTVersionChecker.Check(event, versionUrl, downloadurl, modname, actuallyversion);
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Add smelting for blocks/items with metadata
	 * @param input
	 * @param metadata
	 * @param output
	 * @param xp
	 */
	@IsWorking
	public static void addSmeltingWithMetadata(int input, int metadata, ItemStack output, float xp)
	{
		try
		{
			FurnaceRecipes.smelting().addSmelting(input, metadata, output, xp);
		}
		catch (Exception e)
		{
			FFMTAPI.FFMTlog.severe("Failed to register smelting whith metadata");
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Helper for crafting armors
	 * @param material
	 * @param type
	 * Helmet:0  
	 * Chestplate:1  
	 * Leggings:2  
	 * Boots:3 
	 * @param output
	 */
	@IsWorking
	public static void addArmorCrafting(ItemStack material, int type, ItemStack output)
	{
		try
		{
			if (type == 0)
			{
				GameRegistry.addRecipe(output, new Object[] {"XXX", "X X", 'X', material});
			}
			if (type == 1)
			{
				GameRegistry.addRecipe(output, new Object[] {"X X", "XXX", "XXX", 'X', material});
			}
			if (type == 2)
			{
				GameRegistry.addRecipe(output, new Object[] {"XXX", "X X", "X X", 'X', material});
			}
			if (type == 3)
			{
				GameRegistry.addRecipe(output, new Object[] {"X X", "X X", 'X', material});
			}
			if (type < 0 || type > 3)
			{
				FFMTAPI.FFMTlog.severe("Failed to register armor crafting, wrong 'type'");
			}
		}
		catch (Exception e)
		{
			FFMTAPI.FFMTlog.severe("Failed to register armor crafting");
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Helper for crafting all armors
	 * @param material
	 * @param outputHelmet
	 * @param outputChestPlate
	 * @param outputLeggings
	 * @param outputBoots
	 */
	@IsWorking
	public static void addAllArmorCrafting(ItemStack material, ItemStack outputHelmet, ItemStack outputChestPlate, ItemStack outputLeggings, ItemStack outputBoots)
	{
		try
		{
			GameRegistry.addRecipe(outputHelmet, new Object[] {"XXX", "X X", 'X', material});
			GameRegistry.addRecipe(outputChestPlate, new Object[] {"X X", "XXX", "XXX", 'X', material});
			GameRegistry.addRecipe(outputLeggings, new Object[] {"XXX", "X X", "X X", 'X', material});
			GameRegistry.addRecipe(outputBoots, new Object[] {"X X", "X X", 'X', material});
		}
		catch (Exception e)
		{
			FFMTAPI.FFMTlog.severe("Failed to register armor crafting");
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Helper for crafting tools
	 * @param material
	 * @param type
	 * Axe:0
	 * Shovel:1
	 * Hoe:2
	 * Pickaxe:3
	 * Sword:4
	 * @param output
	 */
	@IsWorking
	public static void addToolsCrafting(ItemStack material, int type, ItemStack output, ItemStack stick)
	{
		try
		{
			if (type == 0)
			{
				GameRegistry.addRecipe(output, new Object[] {"XX", "XS", " S", 'X', material, 'S', stick});
				GameRegistry.addRecipe(output, new Object[] {"XX", "SX", "S ", 'X', material, 'S', stick});
			}
			if (type == 1)
			{
				GameRegistry.addRecipe(output, new Object[] {"X", "S", "S", 'X', material, 'S', stick});
			}
			if (type == 2)
			{
				GameRegistry.addRecipe(output, new Object[] {"XX", " S", " S", 'X', material, 'S', stick});
				GameRegistry.addRecipe(output, new Object[] {"XX", "S ", "S ", 'X', material, 'S', stick});
			}
			if (type == 3)
			{
				GameRegistry.addRecipe(output, new Object[] {"XXX", " S ", " S ", 'X', material, 'S', stick});
			}
			if (type == 4)
			{
				GameRegistry.addRecipe(output, new Object[] {"X", "X", "S", 'X', material, 'S', stick});
			}
			if (type < 0 || type > 4)
			{
				FFMTAPI.FFMTlog.severe("Failed to register tools crafting, wrong 'type'");
			}
		}
		catch (Exception e)
		{
			FFMTAPI.FFMTlog.severe("Failed to register tools crafting");
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Separator
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Add all tools crafting
	 * @param material
	 * @param outputAxe
	 * @param outputShovel
	 * @param outputHoe
	 * @param outputPickaxe
	 * @param outputSword
	 * @param stick
	 */
	@IsWorking
	public static void addAllToolsCrafting(ItemStack material, ItemStack outputAxe, ItemStack outputShovel, ItemStack outputHoe, ItemStack outputPickaxe, ItemStack outputSword, ItemStack stick)
	{
		try
		{
			GameRegistry.addRecipe(outputAxe, new Object[] {"XX", "XS", " S", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputAxe, new Object[] {"XX", "SX", "S ", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputShovel, new Object[] {"X", "S", "S", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputHoe, new Object[] {"XX", " S", " S", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputHoe, new Object[] {"XX", "S ", "S ", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputPickaxe, new Object[] {"XXX", " S ", " S ", 'X', material, 'S', stick});
			GameRegistry.addRecipe(outputSword, new Object[] {"X", "X", "S", 'X', material, 'S', stick});
		}
		catch (Exception e)
		{
			FFMTAPI.FFMTlog.severe("Failed to register tools crafting");
		}
	}
}
