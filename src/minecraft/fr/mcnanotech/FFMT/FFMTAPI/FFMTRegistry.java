package fr.mcnanotech.FFMT.FFMTAPI;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
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
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static Minecraft getMinecraftInstance()
	{
		return mc;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
//Separator
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Correct name (ex:Mobs(entity.entityName.name -> entityName), CreativeTabs(itemGroup.creativeTabName -> creativeTabName))
	 * @param name
	 * @param removeBack
	 * @param removeForward
	 */
	@IsWorking
	public static void correctName(String name, String removeback, String removeForward)
	{
		LanguageRegistry.instance().addStringLocalization(removeback + name + removeForward, "en_US", name);
	}
	
	/**
	 * Correct name (ex:Mobs(entity.entityName.name -> entityName), CreativeTabs(itemGroup.creativeTabName -> creativeTabName))
	 * @param name
	 * @param removeBack
	 * @param removeForward
	 * @param language (If not specified, by default is en_US)
	 */
	@IsWorking
	public static void correctName(String entityName, String removeback, String removeForward, String language)
	{
		LanguageRegistry.instance().addStringLocalization(removeback + entityName + removeForward, language, entityName);
	}

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
	 * Adding version checker (IS NOT COMPATIBLE IN SERVER VERSION)
	 * @param modName (the mod name)
	 * @param version (the version of your mod)
	 * @param versiondoc (the .htm version file (Args in the htm file (eg) : Version : 0.1))
	 * @param download (the download link)
	 */
	@UnknownTestStatus
	@SideOnly(Side.CLIENT)
	public static void registerVersionCheck(String modName, double version, String versiondoc, String download)
	{
		FFMTVersionChecker.checkerSimpleSSP(modName, version, versiondoc, download, mc);
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
