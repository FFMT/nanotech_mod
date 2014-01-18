package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class NanotechItem
{
	// Items statement
	public static Item itemBase, superBottleOfXp, diamondBow, emeraldBow, nanomiteBow, nanomiteAxe, nanomitePickaxe, nanomiteShovel, nanomiteHoe, nanomiteSword, nanomiteHelmet, nanomiteChestPlate, nanomiteLeggings, nanomiteBoots, mysteriousHelmet, mysteriousChestPlate, mysteriousLeggings, mysteriousBoots, nanoDisc, edibleFlesh, rottenChunk, scythe, crazyGlasses, debug, alters, nitrogenBucket,
			reinforcedFishingRod, crazyGlassesGun, lightSaber;

	// Enum tools and armor material
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[] {6, 6, 6, 6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialCrazyGlasses = EnumHelper.addArmorMaterial("CrazyGlasses", 0, new int[] {0, 0, 0, 0}, 0);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	public static EnumToolMaterial EnumToolMaterialScythe = EnumHelper.addToolMaterial("Scythe", 4, 2500, 13F, 16, 2);

	// Items Initialization
	public static void initItem()
	{
		itemBase = new ItemBaseMetadata(NanotechMod.nanotechItemID).setUnlocalizedName("nanotechbase").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		superBottleOfXp = new ItemSuperbottleofxp(NanotechMod.superBottleOfXpID).setUnlocalizedName("superbottleofxp").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		diamondBow = new ItemDiamondBow(NanotechMod.diamondBowID).setUnlocalizedName("diamondbow").setCreativeTab(NanotechMod.CREATIVE_TAB_I).setFull3D();
		emeraldBow = new ItemEmeraldBow(NanotechMod.emeraldBowID).setUnlocalizedName("emeraldbow").setCreativeTab(NanotechMod.CREATIVE_TAB_I).setFull3D();
		nanomiteBow = new ItemNanomiteArrowGun(NanotechMod.nanomiteBowID).setUnlocalizedName("nanomitebow").setCreativeTab(NanotechMod.CREATIVE_TAB_I).setFull3D();
		nanomiteHelmet = new ItemNanomiteArmor(NanotechMod.nanomiteHelmetID, EnumArmorMaterialNanomite, 1, 0).setUnlocalizedName("nanomiteHelmet").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteChestPlate = new ItemNanomiteArmor(NanotechMod.nanomiteChestPlateID, EnumArmorMaterialNanomite, 1, 1).setUnlocalizedName("nanomiteChestPlate").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteLeggings = new ItemNanomiteArmor(NanotechMod.nanomiteLegginsID, EnumArmorMaterialNanomite, 1, 2).setUnlocalizedName("nanomiteLegs").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteBoots = new ItemNanomiteArmor(NanotechMod.nanomiteBootsID, EnumArmorMaterialNanomite, 1, 3).setUnlocalizedName("nanomiteBoots").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteSword = new ItemNanomiteSword(NanotechMod.nanomiteSwordID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteSword").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteShovel = new ItemNanomiteShovel(NanotechMod.nanomiteShovelID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteShovel").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomitePickaxe = new ItemNanomitePickaxe(NanotechMod.nanomitePickaxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomitePickaxe").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteAxe = new ItemNanomiteAxe(NanotechMod.nanomiteAxeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteAxe").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanomiteHoe = new ItemNanomiteHoe(NanotechMod.nanomiteHoeID, EnumToolMaterialNanomite).setUnlocalizedName("nanomiteHoe").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		mysteriousHelmet = new ItemMysteriousArmor(NanotechMod.mysteriousHelmetID, EnumArmorMaterialMysterious, 1, 0).setUnlocalizedName("mysteriousHelmet").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		mysteriousChestPlate = new ItemMysteriousArmor(NanotechMod.mysteriousChestPlateID, EnumArmorMaterialMysterious, 1, 1).setUnlocalizedName("mysteriousChestPlate").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		mysteriousLeggings = new ItemMysteriousArmor(NanotechMod.mysteriousLegginsID, EnumArmorMaterialMysterious, 1, 2).setUnlocalizedName("mysteriousLeggings").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		mysteriousBoots = new ItemMysteriousArmor(NanotechMod.mysteriousBootsID, EnumArmorMaterialMysterious, 1, 3).setUnlocalizedName("mysteriousBoots").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nanoDisc = new ItemDisk(NanotechMod.nanoDiscID, "nanotechmod:nanodisk", "JedBorg - Surprise", "nanodisk").setUnlocalizedName("record").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		edibleFlesh = new ItemNanoFood(NanotechMod.edibleFleshID, 3, 0.6F, true).setUnlocalizedName("edibleFlesh").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		rottenChunk = new ItemNanoFood(NanotechMod.rottenChunkID, 1, 0.6F, true, Potion.hunger.id, 120, 0, 1.0F).setUnlocalizedName("rottenChunk").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		scythe = new ItemScythe(NanotechMod.scytheID, EnumToolMaterialScythe).setUnlocalizedName("scythe").setFull3D().setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		crazyGlasses = new ItemCrazyGlasses(NanotechMod.crazyGlassesID, EnumArmorMaterialCrazyGlasses, 1, 0).setUnlocalizedName("crazyGlasses").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		debug = new ItemDebug(NanotechMod.debugID).setUnlocalizedName("debug").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		alters = new ItemAlters(NanotechMod.altersID).setUnlocalizedName("alters").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		nitrogenBucket = new ItemNitrogenBucket(NanotechMod.nitrogenBucketID, NanotechBlock.liquidNitrogen.blockID).setContainerItem(Item.bucketEmpty).setUnlocalizedName("nitrogenBucket").setTextureName("nanotechmod:nitrogenbucket").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		reinforcedFishingRod = new ItemReinforcedFishingRod(NanotechMod.reinforcedFishingRodID).setUnlocalizedName("reinforcedFishingRod").setTextureName("nanotechmod:reinforced_fishing_rod").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		crazyGlassesGun = new ItemCrazyGlassesGun(NanotechMod.crazyGlassesGunID).setUnlocalizedName("crazyGlassesGun").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
		lightSaber = new ItemLightSaber(NanotechMod.lightSaberID).setUnlocalizedName("lightSaber").setCreativeTab(NanotechMod.CREATIVE_TAB_I);
	}

	public static void registerItem()
	{
		GameRegistry.registerItem(itemBase, "nanotechbase", "NanotechMod");
		GameRegistry.registerItem(superBottleOfXp, "superbottleofxp", "NanotechMod");
		GameRegistry.registerItem(diamondBow, "diamondbow", "NanotechMod");
		GameRegistry.registerItem(emeraldBow, "emeraldbow", "NanotechMod");
		GameRegistry.registerItem(nanomiteBow, "nanomitebow", "NanotechMod");
		GameRegistry.registerItem(nanomiteHelmet, "nanomiteHelmet", "NanotechMod");
		GameRegistry.registerItem(nanomiteChestPlate, "nanomiteChestPlate", "NanotechMod");
		GameRegistry.registerItem(nanomiteLeggings, "nanomiteLegs", "NanotechMod");
		GameRegistry.registerItem(nanomiteBoots, "nanomiteBoots", "NanotechMod");
		GameRegistry.registerItem(nanomiteSword, "nanomiteSword", "NanotechMod");
		GameRegistry.registerItem(nanomiteShovel, "nanomiteShovel", "NanotechMod");
		GameRegistry.registerItem(nanomitePickaxe, "nanomitePickaxe", "NanotechMod");
		GameRegistry.registerItem(nanomiteAxe, "nanomiteAxe", "NanotechMod");
		GameRegistry.registerItem(nanomiteHoe, "nanomiteHoe", "NanotechMod");
		GameRegistry.registerItem(mysteriousHelmet, "mysteriousHelmet", "NanotechMod");
		GameRegistry.registerItem(mysteriousChestPlate, "mysteriousChestPlate", "NanotechMod");
		GameRegistry.registerItem(mysteriousLeggings, "mysteriousLeggings", "NanotechMod");
		GameRegistry.registerItem(mysteriousBoots, "mysteriousBoots", "NanotechMod");
		GameRegistry.registerItem(nanoDisc, "nanoDisc", "NanotechMod");
		GameRegistry.registerItem(edibleFlesh, "edibleFlesh", "NanotechMod");
		GameRegistry.registerItem(rottenChunk, "rottenChunk", "NanotechMod");
		GameRegistry.registerItem(scythe, "scythe", "NanotechMod");
		GameRegistry.registerItem(crazyGlasses, "crazyGlasses", "NanotechMod");
		GameRegistry.registerItem(debug, "debug", "NanotechMod");
		GameRegistry.registerItem(alters, "alters", "NanotechMod");
		GameRegistry.registerItem(nitrogenBucket, "nitrogenBucket", "NanotechMod");
		GameRegistry.registerItem(reinforcedFishingRod, "reinforcedFishingRod", "NanotechMod");
		GameRegistry.registerItem(crazyGlassesGun, "crazyGlassesGun", "NanotechMod");
		GameRegistry.registerItem(lightSaber, "lightSaber", "NanotechMod");
	}
}