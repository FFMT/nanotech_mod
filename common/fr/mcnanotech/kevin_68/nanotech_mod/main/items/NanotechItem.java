package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import cpw.mods.fml.common.registry.GameRegistry;
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
	public static Item itemBase, superBottleOfXp, diamondBow, emeraldBow, nanomiteBow, nanomiteAxe, nanomitePickaxe, nanomiteShovel, nanomiteHoe, nanomiteSword, nanomiteHelmet, nanomiteChestPlate, nanomiteLeggings, nanomiteBoots, mysteriousHelmet, mysteriousChestPlate, mysteriousLeggings, mysteriousBoots, nanoDisc, edibleFlesh, rottenChunk, scythe, crazyGlasses, debug, alters, nitrogenBucket,
			reinforcedFishingRod, crazyGlassesGun;

	// Enum tools and armor material
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialCrazyGlasses = EnumHelper.addArmorMaterial("CrazyGlasses", 0, new int[] {0, 0, 0, 0}, 0);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	public static EnumToolMaterial EnumToolMaterialScythe = EnumHelper.addToolMaterial("Scythe", 4, 2500, 13F, 16, 2);

	// Items Initialization
	public static void initItem()
	{
		itemBase = new ItemBaseMetadata(Nanotech_mod.nanotechItemID).setUnlocalizedName("nanotechbase").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		superBottleOfXp = new ItemSuperbottleofxp(Nanotech_mod.superBottleOfXpID).setUnlocalizedName("superbottleofxp").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		diamondBow = new ItemDiamondBow(Nanotech_mod.diamondBowID).setUnlocalizedName("diamondbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		emeraldBow = new ItemEmeraldBow(Nanotech_mod.emeraldBowID).setUnlocalizedName("emeraldbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		nanomiteBow = new ItemNanomiteArrowGun(Nanotech_mod.nanomiteBowID).setUnlocalizedName("nanomitebow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		nanomiteHelmet = new ItemNanomiteArmor(Nanotech_mod.nanomiteHelmetID, EnumArmorMaterialNanomite, 1, 0).setUnlocalizedName("nanomiteHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteChestPlate = new ItemNanomiteArmor(Nanotech_mod.nanomiteChestPlateID, EnumArmorMaterialNanomite, 1, 1).setUnlocalizedName("nanomiteChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteLeggings = new ItemNanomiteArmor(Nanotech_mod.nanomiteLegginsID, EnumArmorMaterialNanomite, 1, 2).setUnlocalizedName("nanomiteLegs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteBoots = new ItemNanomiteArmor(Nanotech_mod.nanomiteBootsID, EnumArmorMaterialNanomite, 1, 3).setUnlocalizedName("nanomiteBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteSword = new ItemNanomiteSword(Nanotech_mod.nanomiteSwordID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteSword").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteShovel = new ItemNanomiteShovel(Nanotech_mod.nanomiteShovelID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteShovel").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomitePickaxe = new ItemNanomitePickaxe(Nanotech_mod.nanomitePickaxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomitePickaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteAxe = new ItemNanomiteAxe(Nanotech_mod.nanomiteAxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteAxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanomiteHoe = new ItemNanomiteHoe(Nanotech_mod.nanomiteHoeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteHoe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		mysteriousHelmet = new ItemMysteriousArmor(Nanotech_mod.mysteriousHelmetID, EnumArmorMaterialMysterious, 1, 0).setUnlocalizedName("mysteriousHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		mysteriousChestPlate = new ItemMysteriousArmor(Nanotech_mod.mysteriousChestPlateID, EnumArmorMaterialMysterious, 1, 1).setUnlocalizedName("mysteriousChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		mysteriousLeggings = new ItemMysteriousArmor(Nanotech_mod.mysteriousLegginsID, EnumArmorMaterialMysterious, 1, 2).setUnlocalizedName("mysteriousLeggings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		mysteriousBoots = new ItemMysteriousArmor(Nanotech_mod.mysteriousBootsID, EnumArmorMaterialMysterious, 1, 3).setUnlocalizedName("mysteriousBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nanoDisc = new ItemDisk(Nanotech_mod.nanoDiscID, "nanotech_mod:nanodisk", "JedBorg - Surprise", "nanodisk").setUnlocalizedName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		edibleFlesh = new ItemNanoFood(Nanotech_mod.edibleFleshID, 3, 0.6F, true).setUnlocalizedName("edibleFlesh").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		rottenChunk = new ItemNanoFood(Nanotech_mod.rottenChunkID, 1, 0.6F, true, Potion.hunger.id, 120, 0, 1.0F).setUnlocalizedName("rottenChunk").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		scythe = new ItemScythe(Nanotech_mod.scytheID, EnumToolMaterialScythe).setUnlocalizedName("scythe").setFull3D().setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		crazyGlasses = new ItemCrazyGlasses(Nanotech_mod.crazyGlassesID, EnumArmorMaterialCrazyGlasses, 1, 0).setUnlocalizedName("crazyGlasses").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		debug = new ItemDebug(Nanotech_mod.debugID).setUnlocalizedName("debug").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		alters = new ItemAlters(Nanotech_mod.altersID).setUnlocalizedName("alters").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		nitrogenBucket = new ItemNitrogenBucket(Nanotech_mod.nitrogenBucketID, NanotechBlock.liquidNitrogen.blockID).setContainerItem(Item.bucketEmpty).setUnlocalizedName("nitrogenBucket").setTextureName("nanotech_mod:nitrogenbucket").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		reinforcedFishingRod = new ItemReinforcedFishingRod(Nanotech_mod.reinforcedFishingRodID).setUnlocalizedName("reinforcedFishingRod").setTextureName("nanotech_mod:reinforced_fishing_rod").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		crazyGlassesGun = new ItemCrazyGlassesGun(Nanotech_mod.crazyGlassesGunID).setUnlocalizedName("crazyGlassesGun").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(itemBase, "nanotechbase", "nanotech_mod");
		GameRegistry.registerItem(superBottleOfXp, "superbottleofxp", "nanotech_mod");
		GameRegistry.registerItem(diamondBow, "diamondbow", "nanotech_mod");
		GameRegistry.registerItem(emeraldBow, "emeraldbow", "nanotech_mod");
		GameRegistry.registerItem(nanomiteBow, "nanomitebow", "nanotech_mod");
		GameRegistry.registerItem(nanomiteHelmet, "nanomiteHelmet", "nanotech_mod");
		GameRegistry.registerItem(nanomiteChestPlate, "nanomiteChestPlate", "nanotech_mod");
		GameRegistry.registerItem(nanomiteLeggings, "nanomiteLegs", "nanotech_mod");
		GameRegistry.registerItem(nanomiteBoots, "nanomiteBoots", "nanotech_mod");
		GameRegistry.registerItem(nanomiteSword, "nanomiteSword", "nanotech_mod");
		GameRegistry.registerItem(nanomiteShovel, "nanomiteShovel", "nanotech_mod");
		GameRegistry.registerItem(nanomitePickaxe, "nanomitePickaxe", "nanotech_mod");
		GameRegistry.registerItem(nanomiteAxe, "nanomiteAxe", "nanotech_mod");
		GameRegistry.registerItem(nanomiteHoe, "nanomiteHoe", "nanotech_mod");
		GameRegistry.registerItem(mysteriousHelmet, "mysteriousHelmet", "nanotech_mod");
		GameRegistry.registerItem(mysteriousChestPlate, "mysteriousChestPlate", "nanotech_mod");
		GameRegistry.registerItem(mysteriousLeggings, "mysteriousLeggings", "nanotech_mod");
		GameRegistry.registerItem(mysteriousBoots, "mysteriousBoots", "nanotech_mod");
		GameRegistry.registerItem(nanoDisc, "nanoDisc", "nanotech_mod");
		GameRegistry.registerItem(edibleFlesh, "edibleFlesh", "nanotech_mod");
		GameRegistry.registerItem(rottenChunk, "rottenChunk", "nanotech_mod");
		GameRegistry.registerItem(scythe, "scythe", "nanotech_mod");
		GameRegistry.registerItem(crazyGlasses, "crazyGlasses", "nanotech_mod");
		GameRegistry.registerItem(debug, "debug", "nanotech_mod");
		GameRegistry.registerItem(alters, "alters", "nanotech_mod");
		GameRegistry.registerItem(nitrogenBucket, "nitrogenBucket", "nanotech_mod");
		GameRegistry.registerItem(reinforcedFishingRod, "reinforcedFishingRod", "nanotech_mod");
		GameRegistry.registerItem(crazyGlassesGun, "crazyGlassesGun", "nanotech_mod");

	}
}