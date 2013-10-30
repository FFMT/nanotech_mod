package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class NanotechAchievement
{
	// Achievement
	public static Achievement installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim, blockListerJukebox, blockSiliconOre, itemAlters, itemSiliconore, itemSiliconplate, itemCircuit,
			itemAdvancedcircuit, itemProcessor, itemMicroProcessor, itemCamera, itemDetector, itemEngine, itemNanomiteFrame, itemNanomite, itemSmallNanomite, itemStoneofdecrease, itemMysteriousingot, itemVoid, itemPortalActivator, itemCrazyGlasses, itemDiamondBow, itemEmeraldBow, itemNanomiteBow, itemMysteriousArmor, itemNanomiteTool, itemNanomiteArmor;
	public static AchievementPage pageNanotech;

	public static void initAchievement()
	{
		installMod = new Achievement(12569, "installMod", 0, 0, new ItemStack(NanotechItem.itemBase, 1, 12), null).registerAchievement().setSpecial();
		blockBarbedWire = new Achievement(12570, "blockBarbedWire", 1, 8, NanotechBlock.barbedwire, installMod).registerAchievement();
		blockConfusion = new Achievement(12571, "blockConfusion", 1, 6, NanotechBlock.confusion, installMod).registerAchievement();
		blockFalling = new Achievement(12572, "blockFalling", 1, 7, NanotechBlock.falling, installMod).registerAchievement();
		blockJumper = new Achievement(12573, "blockJumper", -1, 5, new ItemStack(NanotechBlock.jumper, 1, 0), installMod).registerAchievement();
		blockJumperAdv = new Achievement(12574, "blockJumperAdv", -3, 5, new ItemStack(NanotechBlock.jumper, 1, 1), blockJumper).registerAchievement();
		blockMossyStone = new Achievement(12575, "blockMossyStone", -1, 6, NanotechBlock.mossystone, installMod).registerAchievement();
		blockNotFalling = new Achievement(12576, "blockNotFalling", -1, 7, NanotechBlock.notfalling, installMod).registerAchievement();
		blockPortalFrame = new Achievement(12577, "blockPortalFrame", -1, 8, NanotechBlock.portalFrame, installMod).registerAchievement();
		blockSmoker = new Achievement(12578, "blockSmoker", 1, 5, NanotechBlock.smoker, installMod).registerAchievement();
		blockSpeed = new Achievement(12579, "blockSpeed", -2, 3, NanotechBlock.speed, installMod).registerAchievement();
		blockSlow = new Achievement(12580, "blockSlow", -2, 2, new ItemStack(NanotechBlock.speed, 1, 1), installMod).registerAchievement();
		blockSiliconOre = new Achievement(12596, "blockSiliconOre", -6, 1, new ItemStack(NanotechBlock.nanoOre, 1, 0), installMod).registerAchievement();
		blockTheDeath = new Achievement(12584, "blockTheDeath", 3, 0, NanotechBlock.theDeathHead, installMod).registerAchievement();
		blockListerJukebox = new Achievement(12585, "blockListerJukebox", -2, 4, NanotechBlock.listerJukebox, installMod).registerAchievement();
		killTheDeath = new Achievement(12586, "killTheDeath", 5, 0, NanotechBlock.theDeathHead, blockTheDeath).registerAchievement();
		killTheDeathWithCG = new Achievement(12587, "killTheDeathWithCG", 7, 0, NanotechBlock.theDeathHead, killTheDeath).registerAchievement();
		getScythe = new Achievement(12588, "getScythe", 5, 2, NanotechItem.scythe, killTheDeath).registerAchievement();
		getMysteriousMat = new Achievement(12589, "getMysteriousMat", 5, -2, new ItemStack(NanotechItem.itemBase, 1, 2), killTheDeath).registerAchievement();
		nanotechDim = new Achievement(12590, "nanotechDim", -3, 8, new ItemStack(NanotechBlock.nanoGrass, 0, 0), itemPortalActivator).registerAchievement();
		itemAlters = new Achievement(12591, "itemAlters", -4, -2, new ItemStack(NanotechItem.alters, 1), installMod).registerAchievement();
		itemSiliconore = new Achievement(12592, "itemSiliconore", -6, 2, new ItemStack(NanotechItem.itemBase, 1, 0), blockSiliconOre).registerAchievement();
		itemSiliconplate = new Achievement(12593, "itemSiliconplate", -6, 3, new ItemStack(NanotechItem.itemBase, 1, 3), itemSiliconore).registerAchievement();
		itemCircuit = new Achievement(12594, "itemCircuit", -6, 4, new ItemStack(NanotechItem.itemBase, 1, 5), itemSiliconplate).registerAchievement();
		itemAdvancedcircuit = new Achievement(12595, "itemAdvancedcircuit", -6, 5, new ItemStack(NanotechItem.itemBase, 1, 6), itemCircuit).registerAchievement();
		itemProcessor = new Achievement(12597, "itemProcessor", -6, 6, new ItemStack(NanotechItem.itemBase, 1, 7), itemAdvancedcircuit).registerAchievement();
		itemMicroProcessor = new Achievement(12598, "itemMicroProcessor", -6, 7, new ItemStack(NanotechItem.itemBase, 1, 8), itemProcessor).registerAchievement();
		itemCamera = new Achievement(12599, "itemCamera", -7, 7, new ItemStack(NanotechItem.itemBase, 1, 9), itemMicroProcessor).registerAchievement();
		itemDetector = new Achievement(12600, "itemDetector", -6, 8, new ItemStack(NanotechItem.itemBase, 1, 10), itemMicroProcessor).registerAchievement();
		itemEngine = new Achievement(12601, "itemEngine", -5, 7, new ItemStack(NanotechItem.itemBase, 1, 11), itemMicroProcessor).registerAchievement();
		itemNanomiteFrame = new Achievement(12602, "itemNanomiteFrame", -4, 7, new ItemStack(NanotechItem.itemBase, 1, 13), itemEngine).registerAchievement();
		itemNanomite = new Achievement(12603, "itemNanomite", -4, 6, new ItemStack(NanotechItem.itemBase, 1, 12), itemNanomiteFrame).registerAchievement();
		itemSmallNanomite = new Achievement(12604, "itemSmallNanomite", -4, 5, new ItemStack(NanotechItem.itemBase, 1, 14), itemNanomite).registerAchievement();
		itemStoneofdecrease = new Achievement(12605, "itemStoneofdecrease", -4, -1, new ItemStack(NanotechItem.itemBase, 1, 1), installMod).registerAchievement();
		itemMysteriousingot = new Achievement(12607, "itemMysteriousingot", 5, -3, new ItemStack(NanotechItem.itemBase, 1, 4), getMysteriousMat).registerAchievement();
		itemVoid = new Achievement(12608, "itemVoid", -4, -3, new ItemStack(NanotechItem.itemBase, 1, 15), installMod).registerAchievement();
		itemPortalActivator = new Achievement(12609, "itemPortalActivator", -2, 8, new ItemStack(NanotechItem.itemBase, 1, 16), blockPortalFrame).registerAchievement();
		itemCrazyGlasses = new Achievement(12610, "itemCrazyGlasses", -4, -4, new ItemStack(NanotechItem.crazyGlasses, 1), installMod).registerAchievement();
		itemDiamondBow = new Achievement(12611, "itemDiamondBow", -4, -5, new ItemStack(NanotechItem.diamondBow, 1), installMod).registerAchievement();
		itemEmeraldBow = new Achievement(12612, "itemEmeraldBow", -5, -5, new ItemStack(NanotechItem.emeraldBow, 1), itemDiamondBow).registerAchievement();
		itemNanomiteBow = new Achievement(12613, "itemNanomiteBow", -6, -5, new ItemStack(NanotechItem.nanomiteBow, 1), itemEmeraldBow).registerAchievement().setSpecial();
		itemMysteriousArmor = new Achievement(12614, "itemMysteriousArmor", 5, -4, new ItemStack(NanotechItem.mysteriousChestPlate, 1), itemMysteriousingot).registerAchievement().setSpecial();
		itemNanomiteTool = new Achievement(12615, "itemNanomiteTool", -4, 3, new ItemStack(NanotechItem.nanomitePickaxe, 1), itemSmallNanomite).registerAchievement().setSpecial();
		itemNanomiteArmor = new Achievement(12616, "itemNanomiteArmor", -5, 4, new ItemStack(NanotechItem.nanomiteChestPlate, 1), itemSmallNanomite).registerAchievement().setSpecial();

		pageNanotech = new AchievementPage("Nanotech_mod", installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, blockSiliconOre, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim, blockListerJukebox, itemAlters, itemSiliconore, itemSiliconplate, itemCircuit, itemAdvancedcircuit, itemProcessor, itemMicroProcessor, itemCamera, itemDetector, itemEngine, itemNanomiteFrame, itemNanomite, itemSmallNanomite, itemStoneofdecrease, itemMysteriousingot, itemVoid, itemPortalActivator, itemCrazyGlasses, itemDiamondBow, itemEmeraldBow, itemNanomiteBow, itemMysteriousArmor, itemNanomiteTool, itemNanomiteArmor);
		AchievementPage.registerAchievementPage(pageNanotech);
	}

	public static Achievement getInstallModAchievement()
	{
		return installMod;
	}
}