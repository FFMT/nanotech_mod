package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.minecraftforgefrance.ffmtapi.FFMTRegistry;

public class NanotechRecipe
{
	public static void InitCommonRecipes()
	{
		// disk
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanodisc, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.diamond)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc2, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc3, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc4, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc5, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc6, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc7, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc8, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc9, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc10, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 9)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc11, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 10)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc12, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 11)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc13, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 12)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc14, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc15, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Yourmusicdisc16, 1), new Object[] {"WZW", "ZXZ", "WZW", 'X', Block.obsidian, 'Z', Item.paper, 'W', new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockNanoplanks, 4), new Object[] {NanotechBlock.BlockNanowood});

		// items
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 5), new Object[] {"XXX", "WYW", "XXX", 'X', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'Y', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 6), new Object[] {"XYX", "WVW", "XYX", 'X', Item.redstone, 'Y', Item.glowstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 3), 'V', new ItemStack(NanotechItem.ItemBase, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 7), new Object[] {"XYX", "WVW", "XYX", 'X', Item.ingotGold, 'Y', Item.redstone, 'W', new ItemStack(NanotechItem.ItemBase, 1, 5), 'V', new ItemStack(NanotechItem.ItemBase, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 9), new Object[] {"WXW", "WCW", "WVW", 'W', Item.ingotIron, 'X', Block.thinGlass, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8), 'V', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 10), new Object[] {"WXW", "XCX", "WXW", 'W', Item.ingotGold, 'X', Block.pressurePlateStone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 11), new Object[] {"XWX", "WCW", "XWX", 'X', Block.stone, 'W', Item.redstone, 'C', new ItemStack(NanotechItem.ItemBase, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 12), new Object[] {"XYX", "VCV", "XNX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'Y', new ItemStack(NanotechItem.ItemBase, 1, 9), 'V', new ItemStack(NanotechItem.ItemBase, 1, 10), 'N', new ItemStack(NanotechItem.ItemBase, 1, 11)});
		/* TODO need change */
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitehelmet, 1), new Object[] {"XXX", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitechestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteleggings, 1), new Object[] {"XXX", "X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomiteboots, 1), new Object[] {"X X", "X X", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13)});
		/* end need change */
		FFMTRegistry.addAllArmorCrafting(new ItemStack(NanotechItem.ItemBase, 1, 4), new ItemStack(NanotechItem.Mysterioushelmet, 1), new ItemStack(NanotechItem.Mysteriouschestplate, 1), new ItemStack(NanotechItem.Mysteriousleggings, 1), new ItemStack(NanotechItem.Mysteriousboots, 1));
		FFMTRegistry.addAllToolsCrafting(new ItemStack(NanotechItem.ItemBase, 1, 14), new ItemStack(NanotechItem.Nanomiteaxe, 1), new ItemStack(NanotechItem.Nanomiteshovel, 1), new ItemStack(NanotechItem.Nanomitehoe, 1), new ItemStack(NanotechItem.Nanomitepickaxe, 1), new ItemStack(NanotechItem.Nanomitesword, 1), new ItemStack(Item.stick, 1));
		GameRegistry.addRecipe(new ItemStack(NanotechItem.ItemBase, 1, 13), new Object[] {"X", "XWX", "X", 'X', Item.ingotIron, 'W', new ItemStack(NanotechBlock.BlockSpeed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), new Object[] {" XW", "XCW", " XW", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.BlockSpeed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Diamondbow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Item.diamond, 'W', Item.silk, 'C', new ItemStack(NanotechBlock.BlockSpeed, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), new Object[] {" XW", "XCW", " XW", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Emeraldbow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', Item.emerald, 'W', Item.silk, 'C', NanotechItem.Diamondbow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), new Object[] {" XW", "XCW", " XW", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'W', Item.silk, 'C', NanotechItem.Emeraldbow});
		GameRegistry.addRecipe(new ItemStack(NanotechItem.Nanomitebow, 1), new Object[] {"WX ", "WCX", "WX ", 'X', new ItemStack(NanotechItem.ItemBase, 1, 13), 'W', Item.silk, 'C', NanotechItem.Emeraldbow});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 8), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 7), new ItemStack(NanotechItem.ItemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 14), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 12), new ItemStack(NanotechItem.ItemBase, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.ItemBase, 1, 15), new Object[] {Block.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new Object[] {new ItemStack(NanotechItem.ItemBase, 1, 15)});

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.BlockSodium), new Object[]{"XXX", "XXX", "XXX", 'X', "itemSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.BlockSodium), new Object[]{"XXX", "XXX", "XXX", 'X', "dustSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.BlockSodium), new Object[]{"XXX", "XXX", "XXX", 'X', "ingotSodium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NanotechBlock.BlockSodium), new Object[]{"XXX", "XXX", "XXX", 'X', "cellSodium"}));
	}

	public static void InitNormalRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockPortalFrame, 4), new Object[] {" X ", "XZX", " X ", 'X', Block.blockIron, 'Z', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 2, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 2, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockJumper, 2), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSmoker, 2), new Object[] {" X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockBarbedwire, 4), new Object[] {"XXX", " X ", "XXX", 'X', Block.fenceIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockConfusion, 1), new Object[] {"XXX", "WCV", "XXX", 'X', Block.stone, 'W', Item.spiderEye, 'C', Item.rottenFlesh, 'V', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockTheDeathHead, 1), new Object[] {"SHS", "DND", "SHS", 'S', Block.slowSand, 'H', new ItemStack(Item.skull.itemID, 1, 1), 'D', Item.diamond, 'N', Item.netherStar});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockMossystone, 2), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.Rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addSmelting(NanotechBlock.BlockNanowood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.BlockNanoOre.blockID, 0, new ItemStack(NanotechItem.ItemBase, 1, 0), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.BlockNanoOre.blockID, 1, new ItemStack(NanotechItem.ItemBase, 1, 1), 1.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.ItemBase.itemID, 0, new ItemStack(NanotechItem.ItemBase, 1, 3), 1.0F);
		GameRegistry.addSmelting(NanotechItem.Rottenchunk.itemID, new ItemStack(NanotechItem.Edibleflesh), 0.5F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.ItemBase.itemID, 2, new ItemStack(NanotechItem.ItemBase, 1, 4), 1.5F);
	}

	public static void InitHardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockPortalFrame, 1), new Object[] {" X ", "XZX", " X ", 'X', Block.blockIron, 'Z', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 1, 0), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSpeed, 1, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.snowball, 'Z', Block.slowSand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockJumper, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.redstone, 'Z', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockSmoker, 1), new Object[] {" X ", "XZX", " X ", 'X', Item.flintAndSteel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockBarbedwire, 1), new Object[] {"X X", " X ", "X X", 'X', Block.fenceIron});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockConfusion, 1), new Object[] {"WRV", "XYX", "WCV", 'X', Block.stone, 'W', Item.fermentedSpiderEye, 'R', Item.rottenFlesh, 'V', Item.bone, 'Y', Block.slowSand, 'C', Block.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockTheDeathHead, 1), new Object[] {"HDH", "SNS", "HDH", 'S', Block.slowSand, 'H', new ItemStack(Item.skull.itemID, 1, 1), 'D', Block.blockDiamond, 'N', Item.netherStar});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechBlock.BlockMossystone, 1), new Object[] {Block.cobblestoneMossy, Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechItem.Rottenchunk), new Object[] {Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh});
		GameRegistry.addSmelting(NanotechBlock.BlockNanowood.blockID, new ItemStack(Item.coal, 1, 1), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.BlockNanoOre.blockID, 0, new ItemStack(NanotechItem.ItemBase, 1, 0), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechBlock.BlockNanoOre.blockID, 1, new ItemStack(NanotechItem.ItemBase, 1, 1), 0.1F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.ItemBase.itemID, 0, new ItemStack(NanotechItem.ItemBase, 1, 3), 0.0F);
		GameRegistry.addSmelting(NanotechItem.Rottenchunk.itemID, new ItemStack(NanotechItem.Edibleflesh), 0.0F);
		FFMTRegistry.addSmeltingWithMetadata(NanotechItem.ItemBase.itemID, 2, new ItemStack(NanotechItem.ItemBase, 1, 4), 0.5F);
	}

	public static void InitFallingBlockRecipes(int output)
	{
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.stone, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 0), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 2), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 1), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 3), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 2), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 4), new Object[] {"XZX", "ZXZ", "XZX", 'X', new ItemStack(Block.stoneBrick, 3), 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 5), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestone, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.sand});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.BlockFalling, output, 6), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.cobblestoneMossy, 'Z', Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 0), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.gravel, 'Z', Block.cobblestoneMossy});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.stoneBrick});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(NanotechBlock.Blocknotfalling, output, 1), new Object[] {"XZX", "ZXZ", "XZX", 'X', Block.sand, 'Z', Block.cobblestoneMossy});
	}
}