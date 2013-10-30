package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.minecraftforgefrance.ffmtlibs.FFMTRegistry;

public class NanotechRecipe
{
	public static void InitCommonRecipes()
	{
		// disk
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanoDisc, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.nanoPlanks, 4), new Object[] {NanotechBlock.nanoWood});

		// items
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 5), new Object[] {"XXX", "WYW", "XXX", 'X', Item.redstone, 'W', new ItemStack(NanotechItem.itemBase, 1, 3), 'Y', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 6), new Object[] {"XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.glowstone, 'W', new ItemStack(NanotechItem.itemBase, 1, 3), 'V', new ItemStack(NanotechItem.itemBase, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 7), new Object[] {"XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', new ItemStack(NanotechItem.itemBase, 1, 5), 'V', new ItemStack(NanotechItem.itemBase, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 9), new Object[] {"WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', new ItemStack(NanotechItem.itemBase, 1, 8), 'V', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 10), new Object[] {"WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', new ItemStack(NanotechItem.itemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 11), new Object[] {"XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', new ItemStack(NanotechItem.itemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 12), new Object[] {"XYX", "VCV", "XNX", 'X', new ItemStack(NanotechItem.itemBase, 1, 13), 'Y', new ItemStack(NanotechItem.itemBase, 1, 9), 'V', new ItemStack(NanotechItem.itemBase, 1, 10), 'N', new ItemStack(NanotechItem.itemBase, 1, 11)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 16), new Object[] {"XDX", "DFD", "XDX", 'X', Item.flintAndSteel, 'D', Item.diamond, 'F', NanotechBlock.portalFrame});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteHelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteChestPlate, 1), new Object[] {"X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteBoots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.itemBase, 1, 14)});
		FFMTRegistry.addAllArmorCrafting(new ItemStack(NanotechItem.itemBase, 1, 4), new ItemStack(NanotechItem.mysteriousHelmet, 1), new ItemStack(NanotechItem.mysteriousChestPlate, 1), new ItemStack(NanotechItem.mysteriousLeggings, 1), new ItemStack(NanotechItem.mysteriousBoots, 1));
		FFMTRegistry.addAllToolsCrafting(new ItemStack(NanotechItem.itemBase, 1, 14), new ItemStack(NanotechItem.nanomiteAxe, 1), new ItemStack(NanotechItem.nanomiteShovel, 1), new ItemStack(NanotechItem.nanomiteHoe, 1), new ItemStack(NanotechItem.nanomitePickaxe, 1), new ItemStack(NanotechItem.nanomiteSword, 1), new ItemStack(Item.stick, 1));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.itemBase, 1, 13), new Object[] {" X ", "XWX", " X ", 'X', Item.ingotIron, 'W', new ItemStack(NanotechBlock.speed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.diamondBow, 1), new Object[] {" XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.speed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.diamondBow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.speed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.emeraldBow, 1), new Object[] {" XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.diamondBow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.emeraldBow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.diamondBow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteBow, 1), new Object[] {" XW", "XCW", " XW", 'X', new ItemStack(NanotechItem.itemBase, 1, 14), 'W', Item.silk, 'C', NanotechItem.emeraldBow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.nanomiteBow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', new ItemStack(NanotechItem.itemBase, 1, 14), 'W', Item.silk, 'C', NanotechItem.emeraldBow});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 8), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 7), new ItemStack(NanotechItem.itemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 14), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 12), new ItemStack(NanotechItem.itemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.itemBase, 1, 15), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object[] {new ItemStack(NanotechItem.itemBase, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jumper, 1, 1), new Object[] {"FBF", 'B', new ItemStack(NanotechBlock.jumper, 1, 0), 'F', Item.feather});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.alters, 1), new Object[] {"ASA", 'A', Block.anvil, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.listerJukebox, 1), new Object[] {"CCC", "JJJ", "CCC", 'C', NanotechItem.nanoDisc, 'J', Block.jukebox});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.reinforcedFishingRod, 1), new Object[] {Item.fishingRod, Item.ingotIron, Item.ingotIron});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[]{"XXX", "XXX", "XXX", 'X', "itemSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[]{"XXX", "XXX", "XXX", 'X', "dustSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.sodium), new Object[]{"XXX", "XXX", "XXX", 'X', "cellSodium"}));
	
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 17, new ItemStack(NanotechItem.itemBase, 1, 18), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 18, new ItemStack(NanotechItem.itemBase, 1, 19), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 19, new ItemStack(Item.fishRaw, 1), 0.1F);
	
	}

	public static void InitNormalRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.portalFrame, 4), new Object[] {" X ", "XZX", " X ", 'X', Block.blockIron, 'Z', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 2, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 2, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jumper, 2, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.smoker, 2), new Object[] {" X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.barbedwire, 4), new Object[] {"XXX", " X ", "XXX", 'X', Block.fenceIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.confusion, 1), new Object[] {"XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.theDeathHead, 1), new Object[] {"SHS", "DND", "SHS", 'S', Block.slowSand, 'H', new ItemStack(Item.skull.itemID, 1, 1), 'D', Item.diamond, 'N', Item.netherStar});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.mossystone, 2), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.rottenChunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addSmelting(NanotechBlock.nanoWood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.nanoOre.blockID, 0, new ItemStack(NanotechItem.itemBase, 1, 0), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.nanoOre.blockID, 1, new ItemStack(NanotechItem.itemBase, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 0, new ItemStack(NanotechItem.itemBase, 1, 3), 1.0F);
		GameRegistry.addSmelting(NanotechItem.rottenChunk.itemID, new ItemStack(NanotechItem.edibleFlesh), 0.5F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 2, new ItemStack(NanotechItem.itemBase, 1, 4), 1.5F);
	}

	public static void InitHardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.portalFrame, 1), new Object[] {" X ", "XZX", " X ", 'X', Block.blockIron, 'Z', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 1, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.speed, 1, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.jumper, 1, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.smoker, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.barbedwire, 1), new Object[] {"X X", " X ", "X X", 'X', Block.fenceIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.confusion, 1), new Object[] {"WRV", "XYX", "WCV", 'X', Block.stone, 'W', Item.fermentedSpiderEye, 'R', Item.rottenFlesh, 'V', Item.bone, 'Y', Block.slowSand, 'C', Block.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.theDeathHead, 1), new Object[] {"HDH", "SNS", "HDH", 'S', Block.slowSand, 'H', new ItemStack(Item.skull.itemID, 1, 1), 'D', Block.blockDiamond, 'N', Item.netherStar});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.mossystone, 1), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.rottenChunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addSmelting(NanotechBlock.nanoWood.blockID, new ItemStack(Item.coal, 1, 1), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.nanoOre.blockID, 0, new ItemStack(NanotechItem.itemBase, 1, 0), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.nanoOre.blockID, 1, new ItemStack(NanotechItem.itemBase, 1, 1), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 0, new ItemStack(NanotechItem.itemBase, 1, 3), 0.0F);
		GameRegistry.addSmelting(NanotechItem.rottenChunk.itemID, new ItemStack(NanotechItem.edibleFlesh), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.itemBase.itemID, 2, new ItemStack(NanotechItem.itemBase, 1, 4), 0.5F);
	}

	public static void InitFallingBlockRecipes(int output)
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.falling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.notfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy});
	}
}