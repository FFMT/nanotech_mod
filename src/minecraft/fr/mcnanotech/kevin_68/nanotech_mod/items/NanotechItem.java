package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class NanotechItem
{
	// Items statement
	public static Item Siliconore, Stoneofdecrease, Mysteriousmaterial, Siliconplate, Mysteriousingot,
	Superbottleofxp, Diamondbow, Emeraldbow, Nanomitebow, Circuit, Advencedcircuit, Processor,
	Microprocessor, Camera, Detector, Engine, Nanomite, Nanomiteframe, Smallnanomite, Nanomiteaxe,
	Nanomitepickaxe, Nanomiteshovel, Nanomitehoe, Nanomitesword, Nanomitehelmet, Nanomitechestplate,
	Nanomiteleggins, Nanomiteboots, Mysterioushelmet, Mysteriouschestplate, Mysteriousleggins, Mysteriousboots,
    Nanodisc, Yourmusicdisc, Yourmusicdisc2, Yourmusicdisc3, Yourmusicdisc4, Yourmusicdisc5, Yourmusicdisc6,
    Yourmusicdisc7, Yourmusicdisc8, Yourmusicdisc9, Yourmusicdisc10, Yourmusicdisc11, Yourmusicdisc12,
    Yourmusicdisc13, Yourmusicdisc14, Yourmusicdisc15, Yourmusicdisc16, Edibleflesh, Rottenchunk, Vide;
	
	// Enum tools and armor material
	public static EnumArmorMaterial EnumArmorMaterialMysterious = EnumHelper.addArmorMaterial("Mysterious", 50, new int[]{6,6,6,6}, 15);
	public static EnumArmorMaterial EnumArmorMaterialNanomite = EnumHelper.addArmorMaterial("Nanomite", 50, new int[]{6,6,6,6}, 15);
	public static EnumToolMaterial EnumToolMaterialNanomite = EnumHelper.addToolMaterial("Nanomite", 4, 2000, 13F, 4, 14);
	
	// Items Initialization
	public static void initItem()
	{
		Siliconore = new Itembase(Nanotech_mod.Item_siliconoreID).setIconIndex(0).setItemName("Item_siliconore").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Stoneofdecrease = new Itembase(Nanotech_mod.Item_stoneofdecreaseID).setIconIndex(1).setItemName("Item_stoneofdecrease").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousmaterial = new Itembase(Nanotech_mod.Item_mysteriousmaterialID).setIconIndex(2).setItemName("Item_mysteriousmaterial").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Siliconplate = new Itembase(Nanotech_mod.Item_siliconplateID).setIconIndex(3).setItemName("Item_siliconplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousingot = new Itembase(Nanotech_mod.Item_mysteriousingotID).setIconIndex(4).setItemName("Item_mysteriousingot").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Superbottleofxp = new Item_superbottleofxp(Nanotech_mod.Item_superbottleofxpID).setIconIndex(5).setItemName("Item_superbottleofxp").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Diamondbow = new Item_diamondbow(Nanotech_mod.Item_diamondbowID).setIconIndex(6).setItemName("Item_diamondbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Emeraldbow = new Item_emeraldbow(Nanotech_mod.Item_emeraldbowID).setIconIndex(7).setItemName("Item_emeraldbow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Nanomitebow = new Item_nanomitebow(Nanotech_mod.Item_nanomitebowID).setIconIndex(8).setItemName("Item_nanomitebow").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I).setFull3D();
		Circuit = new Itembase(Nanotech_mod.Item_circuitID).setIconIndex(9).setItemName("Item_circuit").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Advencedcircuit = new Itembase(Nanotech_mod.Item_advencedcircuitID).setIconIndex(10).setItemName("Item_advencedcircuit").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Processor = new Itembase(Nanotech_mod.Item_processorID).setIconIndex(11).setItemName("Item_processor").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Microprocessor = new Itembase(Nanotech_mod.Item_microprocessorID).setIconIndex(20).setItemName("Item_microprocessor").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Camera = new Itembase(Nanotech_mod.Item_cameraID).setIconIndex(21).setItemName("Item_camera").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Detector = new Itembase(Nanotech_mod.Item_detectorID).setIconIndex(25).setItemName("Item_detector").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Engine = new Itembase(Nanotech_mod.Item_engineID).setIconIndex(26).setItemName("Item_engine").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomite = new Itembase(Nanotech_mod.Item_nanomiteID).setIconIndex(12).setItemName("Item_nanomite").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteframe = new Itembase(Nanotech_mod.Item_nanomiteframeID).setIconIndex(13).setItemName("Item_nanomiteframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Smallnanomite = new Itembase(Nanotech_mod.Item_smallnanomiteID).setIconIndex(14).setItemName("Item_smallnanomite").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitehelmet = new Item_nanomitearmor(Nanotech_mod.Item_nanomitehelmetID, EnumArmorMaterialNanomite, 1, 0).setIconIndex(16).setItemName("Item_nanomitehelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitechestplate = new Item_nanomitearmor(Nanotech_mod.Item_nanomitechestplateID, EnumArmorMaterialNanomite, 1, 1).setIconIndex(32).setItemName("Item_nanomitechestplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteleggins = new Item_nanomitearmor(Nanotech_mod.Item_nanomitelegginsID, EnumArmorMaterialNanomite, 1, 2).setIconIndex(48).setItemName("Item_nanomitelegs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteboots = new Item_nanomitearmor(Nanotech_mod.Item_nanomitebootsID, EnumArmorMaterialNanomite, 1, 3).setIconIndex(64).setItemName("Item_nanomiteboots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitesword = new Item_nanomitesword(Nanotech_mod.Item_nanomiteswordID, EnumToolMaterialNanomite).setIconIndex(17).setItemName("Item_nanomitesword").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteshovel = new Item_nanomiteshovel(Nanotech_mod.Item_nanomiteshovelID, EnumToolMaterialNanomite).setIconIndex(33).setItemName("Item_nanomiteshovel").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitepickaxe = new Item_nanomitepickaxe(Nanotech_mod.Item_nanomitepickaxeID, EnumToolMaterialNanomite).setIconIndex(49).setItemName("Item_nanomitepickaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomiteaxe = new Item_nanomiteaxe(Nanotech_mod.Item_nanomiteaxeID, EnumToolMaterialNanomite).setIconIndex(65).setItemName("Item_nanomiteaxe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanomitehoe = new Item_nanomitehoe(Nanotech_mod.Item_nanomitehoeID, EnumToolMaterialNanomite).setIconIndex(81).setItemName("Item_nanomitehoe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysterioushelmet = new Item_mysteriousarmor(Nanotech_mod.Item_mysterioushelmetID, EnumArmorMaterialMysterious, 1, 0).setIconIndex(18).setItemName("Item_mysterioushelmet").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriouschestplate = new Item_mysteriousarmor(Nanotech_mod.Item_mysteriouschestplateID, EnumArmorMaterialMysterious,1 ,1).setIconIndex(34).setItemName("Item_mysteriouschestplate").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousleggins = new Item_mysteriousarmor(Nanotech_mod.Item_mysteriouslegginsID, EnumArmorMaterialMysterious,1 ,2).setIconIndex(50).setItemName("Item_mysteriousleggins").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Mysteriousboots = new Item_mysteriousarmor(Nanotech_mod.Item_mysteriousbootsID, EnumArmorMaterialMysterious, 1, 3).setIconIndex(66).setItemName("Item_mysteriousboots").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Nanodisc = new Item_disc(Nanotech_mod.Item_nanodiscID, "nanodisk", Nanotech_mod.nanodiscname).setIconIndex(239).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc = new Item_disc(Nanotech_mod.Item_nanodiscID+1, "YourSound1", Nanotech_mod.Yourdiscname).setIconIndex(240).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc2 = new Item_disc(Nanotech_mod.Item_nanodiscID+2, "YourSound2", Nanotech_mod.Yourdiscname2).setIconIndex(241).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc3 = new Item_disc(Nanotech_mod.Item_nanodiscID+3, "YourSound3", Nanotech_mod.Yourdiscname3).setIconIndex(242).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc4 = new Item_disc(Nanotech_mod.Item_nanodiscID+4, "YourSound4", Nanotech_mod.Yourdiscname4).setIconIndex(243).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc5 = new Item_disc(Nanotech_mod.Item_nanodiscID+5, "YourSound5", Nanotech_mod.Yourdiscname5).setIconIndex(244).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc6 = new Item_disc(Nanotech_mod.Item_nanodiscID+6, "YourSound6", Nanotech_mod.Yourdiscname6).setIconIndex(245).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc7 = new Item_disc(Nanotech_mod.Item_nanodiscID+7, "YourSound7", Nanotech_mod.Yourdiscname7).setIconIndex(246).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc8 = new Item_disc(Nanotech_mod.Item_nanodiscID+8, "YourSound8", Nanotech_mod.Yourdiscname8).setIconIndex(247).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc9 = new Item_disc(Nanotech_mod.Item_nanodiscID+9, "YourSound9", Nanotech_mod.Yourdiscname9).setIconIndex(248).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc10 = new Item_disc(Nanotech_mod.Item_nanodiscID+10, "YourSound10", Nanotech_mod.Yourdiscname10).setIconIndex(249).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc11 = new Item_disc(Nanotech_mod.Item_nanodiscID+11, "YourSound11", Nanotech_mod.Yourdiscname11).setIconIndex(250).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc12 = new Item_disc(Nanotech_mod.Item_nanodiscID+12, "YourSound12", Nanotech_mod.Yourdiscname12).setIconIndex(251).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc13 = new Item_disc(Nanotech_mod.Item_nanodiscID+13, "YourSound13", Nanotech_mod.Yourdiscname13).setIconIndex(252).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc14 = new Item_disc(Nanotech_mod.Item_nanodiscID+14, "YourSound14", Nanotech_mod.Yourdiscname14).setIconIndex(253).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Yourmusicdisc15 = new Item_disc(Nanotech_mod.Item_nanodiscID+15, "YourSound15", Nanotech_mod.Yourdiscname15).setIconIndex(254).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Yourmusicdisc16 = new Item_disc(Nanotech_mod.Item_nanodiscID+16, "YourSound16", Nanotech_mod.Yourdiscname16).setIconIndex(255).setItemName("record").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I); 
		Edibleflesh = new Item_edibleflesh(Nanotech_mod.Item_ediblefleshID, 3, true).setIconIndex(15).setItemName("Item_edibleflesh").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Rottenchunk = new Item_edibleflesh(Nanotech_mod.Item_rottenchunkID, 1, true).setIconIndex(19).setItemName("Item_rottenchunk").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
		Vide = new Itembase(Nanotech_mod.Item_videID).setIconIndex(80).setItemName("Item_vide").setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}
	
	/**
	 * Items Names
	 */
	public static void itemName()
	{
		/*
		LanguageRegistry.addName(Item_siliconore, "Silicon Ore");
		LanguageRegistry.addName(Item_stoneofdecrease, "Stone of Decrease");
		LanguageRegistry.addName(Item_mysteriousmaterial, "Mysterious Material");
		LanguageRegistry.addName(Item_siliconplate, "Silicon Plate");
		LanguageRegistry.addName(Item_mysteriousingot, "Mysterious Ingot");
		LanguageRegistry.addName(Item_superbottleofxp, "Super bottle of xp");
		LanguageRegistry.addName(Item_diamondbow, "Diamond bow");
		LanguageRegistry.addName(Item_emeraldbow, "Emerald bow");
		LanguageRegistry.addName(Item_nanomitebow, "Nanomite bow");
		LanguageRegistry.addName(Item_circuit, "Circuit");
		LanguageRegistry.addName(Item_advencedcircuit, "Advenced Circuit");
		LanguageRegistry.addName(Item_processor, "Processor");
		LanguageRegistry.addName(Item_microprocessor, "Micro-processor");
		LanguageRegistry.addName(Item_camera, "Camera");
		LanguageRegistry.addName(Item_detector, "Detector");
		LanguageRegistry.addName(Item_engine, "Engine");
		LanguageRegistry.addName(Item_nanomite, "Nanomite");
		LanguageRegistry.addName(Item_nanomiteframe, "Nanomite Frame");
		LanguageRegistry.addName(Item_smallnanomite, "Small Nanomite");
		LanguageRegistry.addName(Item_nanomiteaxe, "Nanomite Axe");
		LanguageRegistry.addName(Item_nanomitepickaxe, "Nanomite Pickaxe");
		LanguageRegistry.addName(Item_nanomiteshovel, "Nanomite Shovel");
		LanguageRegistry.addName(Item_nanomitehoe, "Nanomite Hoe");
		LanguageRegistry.addName(Item_nanomitesword, "Nanomite Sword");
		LanguageRegistry.addName(Item_nanomitehelmet, "Nanomite Helmet");
		LanguageRegistry.addName(Item_nanomitechestplate, "Nanomite Chestplate");
		LanguageRegistry.addName(Item_nanomiteleggins, "Nanomite Leggins");
		LanguageRegistry.addName(Item_nanomiteboots, "Nanomite Boots");
		LanguageRegistry.addName(Item_mysterioushelmet, "Mysterious Helmet");
		LanguageRegistry.addName(Item_mysteriouschestplate, "Mysterious Chestplate");
		LanguageRegistry.addName(Item_mysteriousleggins, "Mysterious Leggins");
		LanguageRegistry.addName(Item_mysteriousboots, "Mysterious Boots");
		LanguageRegistry.addName(Item_edibleflesh, "Edible Flesh");
		LanguageRegistry.addName(Item_rottenchunk, "Chunk of Rotten flesh");
		LanguageRegistry.addName(Item_vide, "Vide");
		*/
	}

}
