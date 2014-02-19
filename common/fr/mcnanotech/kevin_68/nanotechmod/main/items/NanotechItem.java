/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class NanotechItem
{
	public static ArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[] {6, 6, 6, 6}, 15);
	public static ArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[] {6, 6, 6, 6}, 15);
	public static ArmorMaterial EnumArmorMaterialCrazyGlasses = EnumHelper.addArmorMaterial("CrazyGlasses", 0, new int[] {0, 0, 0, 0}, 0);
	public static ToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	public static ToolMaterial EnumToolMaterialScythe = EnumHelper.addToolMaterial("Scythe", 4, 2500, 13F, 16, 2);

	/**
	 * Only use for NPE on loading
	 */
	public static Item itemBase, superBottleOfXp, diamondBow, emeraldBow, nanomiteBow, nanomiteHelmet, nanomiteChestPlate, nanomiteLeggings, nanomiteBoots, nanomiteSword, nanomiteShovel, nanomitePickaxe, nanomiteAxe, nanomiteHoe, mysteriousHelmet, mysteriousChestPlate, mysteriousLeggings, mysteriousBoots, nanoDisc, edibleFlesh, rottenChunk, scythe, crazyGlasses, debug, alters,
			reinforcedFishingRod, crazyGlassesGun, lightSaber;

	public static void initItem()
	{
		itemBase = new ItemBaseMetadata().setUnlocalizedName("nanotechbase").setTextureName(NanotechMod.MODID + ":").setCreativeTab(NanotechMod.CreaI);
		superBottleOfXp = new ItemSuperBottleOfXp().setUnlocalizedName("superbottleofxp").setTextureName("experience_bottle").setCreativeTab(NanotechMod.CreaI);
		diamondBow = new ItemDiamondBow().setUnlocalizedName("diamondbow").setTextureName(NanotechMod.MODID + ":diamondbow").setCreativeTab(NanotechMod.CreaI);
		emeraldBow = new ItemEmeraldBow().setUnlocalizedName("emeraldbow").setTextureName(NanotechMod.MODID + ":emeraldbow").setCreativeTab(NanotechMod.CreaI);
		nanomiteBow = new ItemNanomiteArrowGun().setUnlocalizedName("nanomitebow").setTextureName(NanotechMod.MODID + ":nanomitebow").setCreativeTab(NanotechMod.CreaI);
		nanomiteHelmet = new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 0).setUnlocalizedName("nanomiteHelmet").setTextureName(NanotechMod.MODID + ":nanomiteHelmet").setCreativeTab(NanotechMod.CreaI);
		nanomiteChestPlate = new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 1).setUnlocalizedName("nanomiteChestPlate").setTextureName(NanotechMod.MODID + ":nanomiteChestPlate").setCreativeTab(NanotechMod.CreaI);
		nanomiteLeggings = new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 2).setUnlocalizedName("nanomiteLegs").setTextureName(NanotechMod.MODID + ":nanomiteLegs").setCreativeTab(NanotechMod.CreaI);
		nanomiteBoots = new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 3).setUnlocalizedName("nanomiteBoots").setTextureName(NanotechMod.MODID + ":nanomiteBoots").setCreativeTab(NanotechMod.CreaI);
		nanomiteSword = new ItemNanomiteSword(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteSword").setTextureName(NanotechMod.MODID + ":nanomiteSword").setCreativeTab(NanotechMod.CreaI);
		nanomiteShovel = new ItemNanomiteShovel(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteShovel").setTextureName(NanotechMod.MODID + ":nanomiteShovel").setCreativeTab(NanotechMod.CreaI);
		nanomitePickaxe = new ItemNanomitePickaxe(EnumToolMaterialNanomite).setUnlocalizedName("nanomitePickaxe").setTextureName(NanotechMod.MODID + ":nanomitePickaxe").setCreativeTab(NanotechMod.CreaI);
		nanomiteAxe = new ItemNanomiteAxe(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteAxe").setTextureName(NanotechMod.MODID + ":nanomiteAxe").setCreativeTab(NanotechMod.CreaI);
		nanomiteHoe = new ItemNanomiteHoe(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteHoe").setTextureName(NanotechMod.MODID + ":nanomiteHoe").setCreativeTab(NanotechMod.CreaI);
		mysteriousHelmet = new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 0).setUnlocalizedName("mysteriousHelmet").setTextureName(NanotechMod.MODID + ":mysteriousHelmet").setCreativeTab(NanotechMod.CreaI);
		mysteriousChestPlate = new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 1).setUnlocalizedName("mysteriousChestPlate").setTextureName(NanotechMod.MODID + ":mysteriousChestPlate").setCreativeTab(NanotechMod.CreaI);
		mysteriousLeggings = new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 2).setUnlocalizedName("mysteriousLeggings").setTextureName(NanotechMod.MODID + ":mysteriousLeggins").setCreativeTab(NanotechMod.CreaI);
		mysteriousBoots = new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 3).setUnlocalizedName("mysteriousBoots").setTextureName(NanotechMod.MODID + ":mysteriousboots").setCreativeTab(NanotechMod.CreaI);
		nanoDisc = new ItemDisk(NanotechMod.MODID + ":nanodisk", "JedBorg - Suprise").setUnlocalizedName("record").setTextureName(NanotechMod.MODID + ":nanodisk").setCreativeTab(NanotechMod.CreaI);
		edibleFlesh = new ItemNanoFood(3, 0.6F, true).setUnlocalizedName("edibleFlesh").setTextureName(NanotechMod.MODID + ":edibleFlesh").setCreativeTab(NanotechMod.CreaI);
		rottenChunk = new ItemNanoFood(1, 0.6F, true, Potion.hunger.id, 120, 0, 1.0F).setUnlocalizedName("rottenChunk").setTextureName(NanotechMod.MODID + ":rottenChunk").setCreativeTab(NanotechMod.CreaI);
		scythe = new ItemScythe(EnumToolMaterialScythe).setUnlocalizedName("scythe").setTextureName(NanotechMod.MODID + ":itemScythe").setCreativeTab(NanotechMod.CreaI).setFull3D();
		crazyGlasses = new ItemCrazyGlasses(EnumArmorMaterialCrazyGlasses, 1, 0).setUnlocalizedName("crazyGlasses").setTextureName(NanotechMod.MODID + ":crazyGlassesItem").setCreativeTab(NanotechMod.CreaI);
		debug = new ItemDebug().setUnlocalizedName("debug").setTextureName(NanotechMod.MODID + ":debug").setCreativeTab(NanotechMod.CreaI);
		alters = new ItemAlters().setUnlocalizedName("alters").setTextureName(NanotechMod.MODID + ":altersItem").setCreativeTab(NanotechMod.CreaI);
		reinforcedFishingRod = new ItemReinforcedFishingRod().setUnlocalizedName("reinforcedFishingRod").setTextureName(NanotechMod.MODID + ":reinforced_fishing_rod").setCreativeTab(NanotechMod.CreaI);
		crazyGlassesGun = new ItemCrazyGlassesGun().setUnlocalizedName("crazyGlassesGun").setTextureName(NanotechMod.MODID + "crazyglassesgunitem").setCreativeTab(NanotechMod.CreaI);
		lightSaber = new ItemLightSaber().setUnlocalizedName("lightSaber").setCreativeTab(NanotechMod.CreaI);

		GameRegistry.registerItem(itemBase, "nanotechbase", NanotechMod.MODID);
		GameRegistry.registerItem(superBottleOfXp, "superbottleofxp", NanotechMod.MODID);
		GameRegistry.registerItem(diamondBow, "diamondbow", NanotechMod.MODID);
		GameRegistry.registerItem(emeraldBow, "emeraldbow", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteBow, "nanomitebow", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteHelmet, "nanomiteHelmet", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteChestPlate, "nanomiteChestPlate", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteLeggings, "nanomiteLegs", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteBoots, "nanomiteBoots", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteSword, "nanomiteSword", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteShovel, "nanomiteShovel", NanotechMod.MODID);
		GameRegistry.registerItem(nanomitePickaxe, "nanomitePickaxe", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteAxe, "nanomiteAxe", NanotechMod.MODID);
		GameRegistry.registerItem(nanomiteHoe, "nanomiteHoe", NanotechMod.MODID);
		GameRegistry.registerItem(mysteriousHelmet, "mysteriousHelmet", NanotechMod.MODID);
		GameRegistry.registerItem(mysteriousChestPlate, "mysteriousChestPlate", NanotechMod.MODID);
		GameRegistry.registerItem(mysteriousLeggings, "mysteriousLeggings", NanotechMod.MODID);
		GameRegistry.registerItem(mysteriousBoots, "mysteriousBoots", NanotechMod.MODID);
		GameRegistry.registerItem(nanoDisc, "nanoDisc", NanotechMod.MODID);
		GameRegistry.registerItem(edibleFlesh, "edibleFlesh", NanotechMod.MODID);
		GameRegistry.registerItem(rottenChunk, "rottenChunk", NanotechMod.MODID);
		GameRegistry.registerItem(scythe, "scythe", NanotechMod.MODID);
		GameRegistry.registerItem(crazyGlasses, "crazyGlasses", NanotechMod.MODID);
		GameRegistry.registerItem(debug, "debug", NanotechMod.MODID);
		GameRegistry.registerItem(alters, "alters", NanotechMod.MODID);
		GameRegistry.registerItem(reinforcedFishingRod, "reinforcedFishingRod", NanotechMod.MODID);
		GameRegistry.registerItem(crazyGlassesGun, "crazyGlassesGun", NanotechMod.MODID);
		GameRegistry.registerItem(lightSaber, "lightSaber", NanotechMod.MODID);

		NanotechMod.nanoLogger.info("Items initialized");
	}
}