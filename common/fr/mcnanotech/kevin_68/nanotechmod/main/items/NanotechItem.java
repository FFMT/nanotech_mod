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
	public static Item emeraldBow;

	public static void initItem()
	{
		GameRegistry.registerItem(new ItemBaseMetadata().setUnlocalizedName("nanotechbase").setTextureName(NanotechMod.MODID + ":").setCreativeTab(NanotechMod.CreaI), "nanotechbase", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemSuperBottleOfXp().setUnlocalizedName("superbottleofxp").setTextureName("experience_bottle").setCreativeTab(NanotechMod.CreaI), "superbottleofxp", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemDiamondBow().setUnlocalizedName("diamondbow").setTextureName(NanotechMod.MODID + ":diamondbow").setCreativeTab(NanotechMod.CreaI), "diamondbow", NanotechMod.MODID);
		GameRegistry.registerItem(emeraldBow = new ItemEmeraldBow().setUnlocalizedName("emeraldbow").setTextureName(NanotechMod.MODID + ":emeraldbow").setCreativeTab(NanotechMod.CreaI), "emeraldbow", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteArrowGun().setUnlocalizedName("nanomitebow").setTextureName(NanotechMod.MODID + ":nanomitebow").setCreativeTab(NanotechMod.CreaI), "nanomitebow", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 0).setUnlocalizedName("nanomiteHelmet").setTextureName(NanotechMod.MODID + ":nanomiteHelmet").setCreativeTab(NanotechMod.CreaI), "nanomiteHelmet", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 1).setUnlocalizedName("nanomiteChestPlate").setTextureName(NanotechMod.MODID + ":nanomiteChestPlate").setCreativeTab(NanotechMod.CreaI), "nanomiteChestPlate", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 2).setUnlocalizedName("nanomiteLegs").setTextureName(NanotechMod.MODID + ":nanomiteLegs").setCreativeTab(NanotechMod.CreaI), "nanomiteLegs", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteArmor(EnumArmorMaterialNanomite, 1, 3).setUnlocalizedName("nanomiteBoots").setTextureName(NanotechMod.MODID + ":nanomiteBoots").setCreativeTab(NanotechMod.CreaI), "nanomiteBoots", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteSword(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteSword").setTextureName(NanotechMod.MODID + ":nanomiteSword").setCreativeTab(NanotechMod.CreaI), "nanomiteSword", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteShovel(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteShovel").setTextureName(NanotechMod.MODID + ":nanomiteShovel").setCreativeTab(NanotechMod.CreaI), "nanomiteShovel", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomitePickaxe(EnumToolMaterialNanomite).setUnlocalizedName("nanomitePickaxe").setTextureName(NanotechMod.MODID + ":nanomitePickaxe").setCreativeTab(NanotechMod.CreaI), "nanomitePickaxe", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteAxe(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteAxe").setTextureName(NanotechMod.MODID + ":nanomiteAxe").setCreativeTab(NanotechMod.CreaI), "nanomiteAxe", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanomiteHoe(EnumToolMaterialNanomite).setUnlocalizedName("nanomiteHoe").setTextureName(NanotechMod.MODID + ":nanomiteHoe").setCreativeTab(NanotechMod.CreaI), "nanomiteHoe", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 0).setUnlocalizedName("mysteriousHelmet").setTextureName(NanotechMod.MODID + ":mysteriousHelmet").setCreativeTab(NanotechMod.CreaI), "mysteriousHelmet", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 1).setUnlocalizedName("mysteriousChestPlate").setTextureName(NanotechMod.MODID + ":mysteriousChestPlate").setCreativeTab(NanotechMod.CreaI), "mysteriousChestPlate", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 2).setUnlocalizedName("mysteriousLeggings").setTextureName(NanotechMod.MODID + ":mysteriousLeggins").setCreativeTab(NanotechMod.CreaI), "mysteriousLeggings", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemMysteriousArmor(EnumArmorMaterialMysterious, 1, 3).setUnlocalizedName("mysteriousBoots").setTextureName(NanotechMod.MODID + ":mysteriousboots").setCreativeTab(NanotechMod.CreaI), "mysteriousBoots", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemDisk(NanotechMod.MODID + ":nanodisk", "JedBorg - Suprise").setUnlocalizedName("record").setTextureName(NanotechMod.MODID + ":nanodisk").setCreativeTab(NanotechMod.CreaI), "nanoDisc", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanoFood(3, 0.6F, true).setUnlocalizedName("edibleFlesh").setTextureName(NanotechMod.MODID + ":edibleFlesh").setCreativeTab(NanotechMod.CreaI), "edibleFlesh", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemNanoFood(1, 0.6F, true, Potion.hunger.id, 120, 0, 1.0F).setUnlocalizedName("rottenChunk").setTextureName(NanotechMod.MODID + ":rottenChunk").setCreativeTab(NanotechMod.CreaI), "rottenChunk", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemScythe(EnumToolMaterialScythe).setUnlocalizedName("scythe").setTextureName(NanotechMod.MODID + ":itemScythe").setCreativeTab(NanotechMod.CreaI).setFull3D(), "scythe", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemCrazyGlasses(EnumArmorMaterialCrazyGlasses, 1, 0).setUnlocalizedName("crazyGlasses").setTextureName(NanotechMod.MODID + ":crazyGlassesItem").setCreativeTab(NanotechMod.CreaI), "crazyGlasses", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemDebug().setUnlocalizedName("debug").setTextureName(NanotechMod.MODID + ":debug").setCreativeTab(NanotechMod.CreaI), "debug", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemAlters().setUnlocalizedName("alters").setTextureName(NanotechMod.MODID + ":altersItem").setCreativeTab(NanotechMod.CreaI), "alters", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemReinforcedFishingRod().setUnlocalizedName("reinforcedFishingRod").setTextureName(NanotechMod.MODID + ":reinforced_fishing_rod").setCreativeTab(NanotechMod.CreaI), "reinforcedFishingRod", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemCrazyGlassesGun().setUnlocalizedName("crazyGlassesGun").setTextureName(NanotechMod.MODID + "crazyglassesgunitem").setCreativeTab(NanotechMod.CreaI), "crazyGlassesGun", NanotechMod.MODID);
		GameRegistry.registerItem(new ItemLightSaber().setUnlocalizedName("lightSaber").setCreativeTab(NanotechMod.CreaI), "lightSaber", NanotechMod.MODID);

		NanotechMod.nanoLogger.info("Items initialized");
	}
}