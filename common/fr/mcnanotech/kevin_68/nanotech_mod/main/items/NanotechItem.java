package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechItem
{
	// Items statement
	public static Item ItemBase, Superbottleofxp, Diamondbow, Emeraldbow, Nanomitebow, Nanomiteaxe, Nanomitepickaxe, Nanomiteshovel, Nanomitehoe, Nanomitesword, Nanomitehelmet, Nanomitechestplate, Nanomiteleggings, Nanomiteboots, Mysterioushelmet, Mysteriouschestplate, Mysteriousleggings, Mysteriousboots, Nanodisc, Edibleflesh, Rottenchunk, scythe, crazyGlasses, teaSeed, tea, debug, alters;

	// Enum tools and armor material
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialCrazyGlasses = EnumHelper.addArmorMaterial("CrazyGlasses", 0, new int[] {0, 0, 0, 0}, 0);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	public static EnumToolMaterial EnumToolMaterialScythe = EnumHelper.addToolMaterial("Scythe", 4, 2500, 13F, 16, 2);

	// Items Initialization
	public static void initItem()
	{
		ItemBase = new ItemBaseMetadata(Nanotech_mod.ItemNanotechID).setUnlocalizedName("nanotechbase").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Superbottleofxp = new ItemSuperbottleofxp(Nanotech_mod.ItemSuperBottleOfXpID).setUnlocalizedName("superbottleofxp").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Diamondbow = new ItemDiamondBow(Nanotech_mod.ItemDiamondBowID).setUnlocalizedName("diamondbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Emeraldbow = new ItemEmeraldBow(Nanotech_mod.ItemEmeraldBowID).setUnlocalizedName("emeraldbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Nanomitebow = new ItemNanomiteBow(Nanotech_mod.ItemNanomiteBowID).setUnlocalizedName("nanomitebow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Nanomitehelmet = new ItemNanomiteArmor(Nanotech_mod.ItemNanomiteHelmetID, EnumArmorMaterialNanomite, 1, 0).setUnlocalizedName("nanomiteHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitechestplate = new ItemNanomiteArmor(Nanotech_mod.ItemNanomiteChestPlateID, EnumArmorMaterialNanomite, 1, 1).setUnlocalizedName("nanomiteChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteleggings = new ItemNanomiteArmor(Nanotech_mod.ItemNanomiteLegginsID, EnumArmorMaterialNanomite, 1, 2).setUnlocalizedName("nanomiteLegs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteboots = new ItemNanomiteArmor(Nanotech_mod.ItemNanomiteBootsID, EnumArmorMaterialNanomite, 1, 3).setUnlocalizedName("nanomiteBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitesword = new ItemNanomiteSword(Nanotech_mod.ItemNanomiteSwordID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteSword").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteshovel = new ItemNanomiteShovel(Nanotech_mod.ItemNanomiteShovelID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteShovel").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitepickaxe = new ItemNanomitePickaxe(Nanotech_mod.ItemNanomitePickaxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomitePickaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteaxe = new ItemNanomiteAxe(Nanotech_mod.ItemNanomiteAxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteAxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitehoe = new ItemNanomiteHoe(Nanotech_mod.ItemNanomiteHoeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteHoe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysterioushelmet = new ItemMysteriousArmor(Nanotech_mod.ItemMysteriousHelmetID, EnumArmorMaterialMysterious, 1, 0).setUnlocalizedName("mysteriousHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriouschestplate = new ItemMysteriousArmor(Nanotech_mod.ItemMysteriousChestPlateID, EnumArmorMaterialMysterious, 1, 1).setUnlocalizedName("mysteriousChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousleggings = new ItemMysteriousArmor(Nanotech_mod.ItemMysteriousLegginsID, EnumArmorMaterialMysterious, 1, 2).setUnlocalizedName("mysteriousLeggings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousboots = new ItemMysteriousArmor(Nanotech_mod.ItemMysteriousBootsID, EnumArmorMaterialMysterious, 1, 3).setUnlocalizedName("mysteriousBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanodisc = new ItemDisk(Nanotech_mod.ItemNanoDiscID, "nanotech_mod:nanodisk", "JedBorg - Surprise", "nanodisk").setUnlocalizedName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Edibleflesh = new ItemNanoFood(Nanotech_mod.ItemEdibleFleshID, 3, 0.6F, true).setUnlocalizedName("edibleFlesh").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Rottenchunk = new ItemNanoFood(Nanotech_mod.ItemRottenChunkID, 1, 0.6F, true, Potion.hunger.id, 120, 0, 1.0F).setUnlocalizedName("rottenChunk").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		scythe = new ItemScythe(Nanotech_mod.ItemScytheID, EnumToolMaterialScythe).setUnlocalizedName("scythe").setFull3D().setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		crazyGlasses = new ItemCrazyGlasses(Nanotech_mod.ItemCrazyGlassesID, EnumArmorMaterialCrazyGlasses, 1, 0).setUnlocalizedName("crazyGlasses").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		teaSeed = new ItemTeaSeed(Nanotech_mod.TeaSeedID, NanotechBlock.BlockTea.blockID, Block.tilledField.blockID).setUnlocalizedName("teaSeed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		tea = new ItemTea(Nanotech_mod.TeaID).setUnlocalizedName("tea").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		debug = new ItemDebug(Nanotech_mod.DebugID).setUnlocalizedName("debug").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		alters = new ItemAlters(Nanotech_mod.AltersID).setUnlocalizedName("alters").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}
}