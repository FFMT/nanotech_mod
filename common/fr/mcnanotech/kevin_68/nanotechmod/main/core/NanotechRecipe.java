/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.minecraftforgefrance.ffmtlibs.FFMTRegistry;

public class NanotechRecipe
{
	public static void InitCommonRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanoDisc, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Blocks.obsidian, 'Z', Items.paper, 'W', new ItemStack(Items.diamond)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.nanoPlank, 4), new Object[] {NanotechBlock.nanoWood});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 5), new Object[] {"XXX", "WYW", "XXX", 'X', Items.redstone, 'W', new ItemStack(NanotechItem.itemBase, 1, 3), 'Y', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 6), new Object[] {"XYX", "WVW", "XYX", 'X', Items.redstone, 'Y', Items.glowstone_dust, 'W', new ItemStack(NanotechItem.itemBase, 1, 3), 'V', new ItemStack(NanotechItem.itemBase, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 7), new Object[] {"XYX", "WVW", "XYX", 'X', Items.gold_ingot, 'Y', Items.redstone, 'W', new ItemStack(NanotechItem.itemBase, 1, 5), 'V', new ItemStack(NanotechItem.itemBase, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 9), new Object[] {"WXW", "WCW", "WVW", 'W', Items.iron_ingot, 'X', Blocks.glass_pane, 'C', new ItemStack(NanotechItem.itemBase, 1, 8), 'V', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 10), new Object[] {"WXW", "XCX", "WXW", 'W', Items.gold_ingot, 'X', Blocks.stone_pressure_plate, 'C', new ItemStack(NanotechItem.itemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 11), new Object[] {"XWX", "WCW", "XWX", 'X', Blocks.stone, 'W', Items.redstone, 'C', new ItemStack(NanotechItem.itemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 12), new Object[] {"XYX", "VCV", "XNX", 'X', new ItemStack(NanotechItem.itemBase, 1, 13), 'Y', new ItemStack(NanotechItem.itemBase, 1, 9), 'V', new ItemStack(NanotechItem.itemBase, 1, 10), 'N', new ItemStack(NanotechItem.itemBase, 1, 11)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 16), new Object[] {"XDX", "DFD", "XDX", 'X', Items.flint_and_steel, 'D', Items.diamond, 'F', NanotechBlock.portalFrame});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteHelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteChestPlate, 1), new Object[] {"X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteBoots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		FFMTRegistry.addAllArmorCrafting(new ItemStack(NanotechItem.itemBase, 1, 4), new ItemStack(NanotechItem.mysteriousHelmet, 1), new ItemStack(NanotechItem.mysteriousChestPlate, 1), new ItemStack(NanotechItem.mysteriousLeggings, 1), new ItemStack(NanotechItem.mysteriousBoots, 1));
		FFMTRegistry.addAllToolsCrafting(new ItemStack(NanotechItem.itemBase, 1, 14), new ItemStack(NanotechItem.nanomiteAxe, 1), new ItemStack(NanotechItem.nanomiteShovel, 1), new ItemStack(NanotechItem.nanomiteHoe, 1), new ItemStack(NanotechItem.nanomitePickaxe, 1), new ItemStack(NanotechItem.nanomiteSword, 1), new ItemStack(Items.stick, 1));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 13), new Object[] {" X ", "XWX", " X ", 'X', Items.iron_ingot, 'W', new ItemStack(NanotechBlock.speed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.diamondBow, 1), new Object[] {" XW", "XCW", " XW", 'X', Items.diamond, 'W', Items.string, 'C', new ItemStack(NanotechBlock.speed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.diamondBow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Items.diamond, 'W', Items.string, 'C', new ItemStack(NanotechBlock.speed, 1, 0)});
		// GameRegistry.addRecipe(new ItemStack(NanotechItem.emeraldBow, 1), new Object[] {" XW", "XCW", " XW", 'X', Items.emerald, 'W', Items.string, 'C', NanotechItem.diamondBow});
		// GameRegistry.addRecipe(new ItemStack(NanotechItem.emeraldBow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Items.emerald, 'W', Items.string, 'C', NanotechItem.diamondBow});
		// GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteBow, 1), new Object[] {"ENE", "INI", " S ", 'N', new ItemStack(NanotechItem.itemBase, 1, 14), 'I', Items.iron_ingot, 'E',
		// NanotechItem.emeraldBow, 'S', Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 8), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 7), new ItemStack(NanotechItem.itemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 14), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 12), new ItemStack(NanotechItem.itemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 15), new Object[] {Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jump, 1, 1), new Object[] {"FBF", 'B', new ItemStack(NanotechBlock.jump, 1, 0), 'F', Items.feather});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.alters, 1), new Object[] {"ASA", 'A', Blocks.anvil, 'S', Items.stick});
		// GameRegistry.addRecipe(new ItemStack(NanotechItem.listerJukeBox, 1), new Object[] {"CCC", "JJJ", "CCC", 'C', NanotechItem.nanoDisc, 'J', Blocks.jukebox});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.reinforcedFishingRod, 1), new Object[] {Items.fishing_rod, Items.iron_ingot, Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.nanoFence, 4), new Object[] {"PSP", "PSP", 'P', NanotechBlock.nanoPlank, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.nanoStepSingle, 6), new Object[] {"PPP", 'P', NanotechBlock.nanoPlank});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.nanoStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', NanotechBlock.nanoPlank});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.nanoStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', NanotechBlock.nanoPlank});
		// GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 20), new Object[] {NanotechItem.crazyGlasses, Items.iron_ingot, Items.iron_ingot});
		// GameRegistry.addRecipe(new ItemStack(NanotechItem.crazyGlassesGun, 1, 0), new Object[] {"DID", "DID", " S ", 'D', NanotechItem.diamondBow, 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.lightSaber, 1, 0), new Object[] {"G", "G", "S", 'G', Blocks.glass, 'S', (Loader.isModLoaded("nanotechmodcity") ? NanotechCityBlock.spotlight : Blocks.gold_block)});

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[] {"XXX", "XXX", "XXX", 'X', "itemSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[] {"XXX", "XXX", "XXX", 'X', "dustSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[] {"XXX", "XXX", "XXX", 'X', "ingotSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[] {"XXX", "XXX", "XXX", 'X', "cellSodium"}));

		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 17), new ItemStack(NanotechItem.itemBase, 1, 18), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 18), new ItemStack(NanotechItem.itemBase, 1, 19), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 19), new ItemStack(Items.fish, 1), 0.1F);
	}

	public static void InitNormalRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.portalFrame, 4), new Object[] {" X ", "XZX", " X ", 'X', Blocks.iron_block, 'Z', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 2, 0), new Object[] {" X ", "XZX", " X ", 'X', Items.redstone, 'Z', Blocks.soul_sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 2, 1), new Object[] {" X ", "XZX", " X ", 'X', Items.snowball, 'Z', Blocks.soul_sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jump, 2, 0), new Object[] {" X ", "XZX", " X ", 'X', Items.redstone, 'Z', Blocks.iron_block});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.smoker, 2), new Object[] {" X ", "XZX", " X ", 'X', Items.flint_and_steel, 'Z', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.barbedWire, 4), new Object[] {"XXX", " X ", "XXX", 'X', Blocks.iron_bars});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.confusion, 1), new Object[] {"XXX", "WCV", "XXX", 'X', Blocks.stone, 'W', Items.spider_eye, 'C', Items.rotten_flesh, 'V', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.theDeathHead, 1), new Object[] {"SHS", "DND", "SHS", 'S', Blocks.soul_sand, 'H', new ItemStack(Items.skull, 1, 1), 'D', Items.diamond, 'N', Items.nether_star});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.mossyStone, 2), new Object[] {Blocks.mossy_cobblestone, Blocks.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.rottenChunk), new Object[] {Items.rotten_flesh, Items.rotten_flesh});
		GameRegistry.addSmelting(NanotechBlock.nanoWood, new ItemStack(Items.coal, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechBlock.ore, 1, 0), new ItemStack(NanotechItem.itemBase, 1, 0), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechBlock.ore, 1, 1), new ItemStack(NanotechItem.itemBase, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 0), new ItemStack(NanotechItem.itemBase, 1, 3), 1.0F);
		GameRegistry.addSmelting(NanotechItem.rottenChunk, new ItemStack(NanotechItem.edibleFlesh), 0.5F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 2), new ItemStack(NanotechItem.itemBase, 1, 4), 1.5F);
	}

	public static void InitHardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.portalFrame, 1), new Object[] {" X ", "XZX", " X ", 'X', Blocks.iron_block, 'Z', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 1, 0), new Object[] {" X ", "XZX", " X ", 'X', Items.redstone, 'Z', Blocks.soul_sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 1, 1), new Object[] {" X ", "XZX", " X ", 'X', Items.snowball, 'Z', Blocks.soul_sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jump, 1, 0), new Object[] {" X ", "XZX", " X ", 'X', Items.redstone, 'Z', Blocks.iron_block});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.smoker, 1), new Object[] {" X ", "XZX", " X ", 'X', Items.flint_and_steel, 'Z', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.barbedWire, 1), new Object[] {"X X", " X ", "X X", 'X', Blocks.iron_bars});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.confusion, 1), new Object[] {"WRV", "XYX", "WCV", 'X', Blocks.stone, 'W', Items.fermented_spider_eye, 'R', Items.rotten_flesh, 'V', Items.bone, 'Y', Blocks.soul_sand, 'C', Blocks.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.theDeathHead, 1), new Object[] {"HDH", "SNS", "HDH", 'S', Blocks.soul_sand, 'H', new ItemStack(Items.skull, 1, 1), 'D', Blocks.diamond_block, 'N', Items.nether_star});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.mossyStone, 1), new Object[] {Blocks.mossy_cobblestone, Blocks.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.rottenChunk), new Object[] {Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh});
		GameRegistry.addSmelting(NanotechBlock.nanoWood, new ItemStack(Items.coal, 1, 1), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechBlock.ore, 1, 0), new ItemStack(NanotechItem.itemBase, 1, 0), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechBlock.ore, 1, 1), new ItemStack(NanotechItem.itemBase, 1, 1), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 0), new ItemStack(NanotechItem.itemBase, 1, 3), 0.0F);
		GameRegistry.addSmelting(NanotechItem.rottenChunk, new ItemStack(NanotechItem.edibleFlesh), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(new ItemStack(NanotechItem.itemBase, 1, 2), new ItemStack(NanotechItem.itemBase, 1, 4), 0.5F);
	}

	public static void InitFallingBlockRecipes(int output)
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.stone, 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.stone, 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 0), 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 0), 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 1), 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 1), 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 2), 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 2), 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 3), 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Blocks.stonebrick, 1, 3), 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.cobblestone, 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.cobblestone, 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.mossy_cobblestone, 'Z', Blocks.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.mossy_cobblestone, 'Z', Blocks.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.gravel, 'Z', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.gravel, 'Z', Blocks.stonebrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.gravel, 'Z', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.gravel, 'Z', Blocks.mossy_cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.sand, 'Z', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.sand, 'Z', Blocks.stonebrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.sand, 'Z', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Blocks.sand, 'Z', Blocks.mossy_cobblestone});
	}
}