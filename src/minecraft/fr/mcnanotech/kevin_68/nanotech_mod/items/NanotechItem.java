package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class NanotechItem
{
	// Items statement
	public static Item ItemBase, Superbottleofxp, Diamondbow, Emeraldbow, Nanomitebow, Nanomiteaxe,
	Nanomitepickaxe, Nanomiteshovel, Nanomitehoe, Nanomitesword, Nanomitehelmet, Nanomitechestplate,
	Nanomiteleggings, Nanomiteboots, Mysterioushelmet, Mysteriouschestplate, Mysteriousleggings, Mysteriousboots,
    Nanodisc, Yourmusicdisc, Yourmusicdisc2, Yourmusicdisc3, Yourmusicdisc4, Yourmusicdisc5, Yourmusicdisc6,
    Yourmusicdisc7, Yourmusicdisc8, Yourmusicdisc9, Yourmusicdisc10, Yourmusicdisc11, Yourmusicdisc12,
    Yourmusicdisc13, Yourmusicdisc14, Yourmusicdisc15, Yourmusicdisc16, Edibleflesh, Rottenchunk;
	
	// Enum tools and armor material
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[]{6,6,6,6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[]{6,6,6,6}, 15);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	
	// Items Initialization
	public static void initItem()
	{
		ItemBase = new ItemBaseMetadata(Nanotech_mod.Item_NanotechID).setIconIndex(0).setItemName("Nanotechbase").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Superbottleofxp = new ItemSuperbottleofxp(Nanotech_mod.Item_superbottleofxpID).setIconIndex(5).setItemName("Superbottleofxp").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Diamondbow = new ItemDiamondBow(Nanotech_mod.Item_diamondbowID).setIconIndex(6).setItemName("Diamondbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Emeraldbow = new ItemEmeraldBow(Nanotech_mod.Item_emeraldbowID).setIconIndex(7).setItemName("Emeraldbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Nanomitebow = new ItemNanomiteBow(Nanotech_mod.Item_nanomitebowID).setIconIndex(8).setItemName("Nanomitebow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Nanomitehelmet = new ItemNanomiteArmor(Nanotech_mod.Item_nanomitehelmetID, EnumArmorMaterialNanomite, 1, 0).setIconIndex(16).setItemName("NanomiteHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitechestplate = new ItemNanomiteArmor(Nanotech_mod.Item_nanomitechestplateID, EnumArmorMaterialNanomite, 1, 1).setIconIndex(32).setItemName("NanomiteChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteleggings = new ItemNanomiteArmor(Nanotech_mod.Item_nanomitelegginsID, EnumArmorMaterialNanomite, 1, 2).setIconIndex(48).setItemName("NanomiteLegs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteboots = new ItemNanomiteArmor(Nanotech_mod.Item_nanomitebootsID, EnumArmorMaterialNanomite, 1, 3).setIconIndex(64).setItemName("NanomiteBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitesword = new ItemNanomiteSword(Nanotech_mod.Item_nanomiteswordID, EnumToolMaterialNanomite).setIconIndex(17).setItemName("NanomiteSword").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteshovel = new ItemNanomiteShovel(Nanotech_mod.Item_nanomiteshovelID, EnumToolMaterialNanomite).setIconIndex(33).setItemName("NanomiteShovel").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitepickaxe = new ItemNanomitePickaxe(Nanotech_mod.Item_nanomitepickaxeID, EnumToolMaterialNanomite).setIconIndex(49).setItemName("NanomitePickaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteaxe = new ItemNanomiteAxe(Nanotech_mod.Item_nanomiteaxeID, EnumToolMaterialNanomite).setIconIndex(65).setItemName("NanomiteAxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitehoe = new ItemNanomiteHoe(Nanotech_mod.Item_nanomitehoeID, EnumToolMaterialNanomite).setIconIndex(81).setItemName("NanomiteHoe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysterioushelmet = new ItemMysteriousArmor(Nanotech_mod.Item_mysterioushelmetID, EnumArmorMaterialMysterious, 1, 0).setIconIndex(18).setItemName("MysteriousHelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriouschestplate = new ItemMysteriousArmor(Nanotech_mod.Item_mysteriouschestplateID, EnumArmorMaterialMysterious,1 ,1).setIconIndex(34).setItemName("MysteriousChestPlate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousleggings = new ItemMysteriousArmor(Nanotech_mod.Item_mysteriouslegginsID, EnumArmorMaterialMysterious,1 ,2).setIconIndex(50).setItemName("MysteriousLeggings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousboots = new ItemMysteriousArmor(Nanotech_mod.Item_mysteriousbootsID, EnumArmorMaterialMysterious, 1, 3).setIconIndex(66).setItemName("MysteriousBoots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanodisc = new ItemDisc(Nanotech_mod.Item_nanodiscID, "Nanodisk").setIconIndex(239).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc = new ItemDisc(Nanotech_mod.Item_nanodiscID +1, "YourSound1").setIconIndex(240).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc2 = new ItemDisc(Nanotech_mod.Item_nanodiscID +2, "YourSound2").setIconIndex(241).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc3 = new ItemDisc(Nanotech_mod.Item_nanodiscID +3, "YourSound3").setIconIndex(242).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc4 = new ItemDisc(Nanotech_mod.Item_nanodiscID +4, "YourSound4").setIconIndex(243).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc5 = new ItemDisc(Nanotech_mod.Item_nanodiscID +5, "YourSound5").setIconIndex(244).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc6 = new ItemDisc(Nanotech_mod.Item_nanodiscID +6, "YourSound6").setIconIndex(245).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc7 = new ItemDisc(Nanotech_mod.Item_nanodiscID +7, "YourSound7").setIconIndex(246).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc8 = new ItemDisc(Nanotech_mod.Item_nanodiscID +8, "YourSound8").setIconIndex(247).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc9 = new ItemDisc(Nanotech_mod.Item_nanodiscID +9, "YourSound9").setIconIndex(248).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc10 = new ItemDisc(Nanotech_mod.Item_nanodiscID +10, "YourSound10").setIconIndex(249).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc11 = new ItemDisc(Nanotech_mod.Item_nanodiscID +11, "YourSound11").setIconIndex(250).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc12 = new ItemDisc(Nanotech_mod.Item_nanodiscID +12, "YourSound12").setIconIndex(251).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc13 = new ItemDisc(Nanotech_mod.Item_nanodiscID +13, "YourSound13").setIconIndex(252).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc14 = new ItemDisc(Nanotech_mod.Item_nanodiscID +14, "YourSound14").setIconIndex(253).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc15 = new ItemDisc(Nanotech_mod.Item_nanodiscID +15, "YourSound15").setIconIndex(254).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Yourmusicdisc16 = new ItemDisc(Nanotech_mod.Item_nanodiscID +16, "YourSound16").setIconIndex(255).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Edibleflesh = new ItemEdibleflesh(Nanotech_mod.Item_ediblefleshID, 3, 0.6F, true).setIconIndex(15).setItemName("EdibleFlesh").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Rottenchunk = new ItemEdibleflesh(Nanotech_mod.Item_rottenchunkID, 1, 0.6F, true).setIconIndex(19).setItemName("RottenChunk").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}

}
