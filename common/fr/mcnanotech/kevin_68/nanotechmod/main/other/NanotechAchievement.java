/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;

public class NanotechAchievement
{
	// Achievement
	public static Achievement installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim, blockListerJukebox, blockSiliconOre, itemAlters, itemSiliconore, itemSiliconplate, itemCircuit,
			itemAdvancedcircuit, itemProcessor, itemMicroProcessor, itemCamera, itemDetector, itemEngine, itemNanomiteFrame, itemNanomite, itemSmallNanomite, itemStoneofdecrease, itemMysteriousingot, itemVoid, itemPortalActivator, itemCrazyGlasses, itemDiamondBow, itemEmeraldBow, itemNanomiteBow, itemMysteriousArmor, itemNanomiteTool, itemNanomiteArmor, itemReinforcedFishinRod,
			itemCrazyGlassesLauncher, itemFrozenFish, deathSatelit, deathLightLaser, deathAlters, deathSodium, deathNitrogen, deathBarbedWire;
	public static AchievementPage pageNanotech;

	public static void initAchievement()
	{
		installMod = new Achievement("achievement.installMod", "installMod", 0, 0, new ItemStack(NanotechItem.itemBase, 1, 12), (Achievement)null).registerStat().setSpecial();
		blockBarbedWire = new Achievement("achievement.blockBarbedWire", "blockBarbedWire", 1, 8, NanotechBlock.barbedWire, installMod).registerStat();
		blockConfusion = new Achievement("achievement.blockConfusion", "blockConfusion", 1, 6, NanotechBlock.confusion, installMod).registerStat();
		blockFalling = new Achievement("achievement.blockFalling", "blockFalling", 1, 7, NanotechBlock.falling, installMod).registerStat();
		blockJumper = new Achievement("achievement.blockJumper", "blockJumper", -1, 5, new ItemStack(NanotechBlock.jump, 1, 0), installMod).registerStat();
		blockJumperAdv = new Achievement("achievement.blockJumperAdv", "blockJumperAdv", -3, 5, new ItemStack(NanotechBlock.jump, 1, 1), blockJumper).registerStat();
		blockMossyStone = new Achievement("achievement.blockMossyStone", "blockMossyStone", -1, 6, NanotechBlock.mossyStone, installMod).registerStat();
		blockNotFalling = new Achievement("achievement.blockNotFalling", "blockNotFalling", -1, 7, NanotechBlock.notFalling, installMod).registerStat();
		blockPortalFrame = new Achievement("achievement.blockPortalFrame", "blockPortalFrame", -1, 8, NanotechBlock.portalFrame, installMod).registerStat();
		blockSmoker = new Achievement("achievement.blockSmoker", "blockSmoker", 1, 5, NanotechBlock.smoker, installMod).registerStat();
		blockSpeed = new Achievement("achievement.blockSpeed", "blockSpeed", -2, 3, NanotechBlock.speed, installMod).registerStat();
		blockSlow = new Achievement("achievement.blockSlow", "blockSlow", -2, 2, new ItemStack(NanotechBlock.speed, 1, 1), installMod).registerStat();
		blockSiliconOre = new Achievement("achievement.blockSiliconOre", "blockSiliconOre", -6, 1, new ItemStack(NanotechBlock.ore, 1, 0), installMod).registerStat();
		blockTheDeath = new Achievement("achievement.blockTheDeath", "blockTheDeath", 3, 0, NanotechBlock.theDeathHead, installMod).registerStat();
		blockListerJukebox = new Achievement("achievement.blockListerJukebox", "blockListerJukebox", -2, 4, NanotechBlock.listerJukeBox, installMod).registerStat();
		killTheDeath = new Achievement("achievement.killTheDeath", "killTheDeath", 5, 0, NanotechBlock.theDeathHead, blockTheDeath).registerStat();
		killTheDeathWithCG = new Achievement("achievement.killTheDeathWithCG", "killTheDeathWithCG", 7, 0, NanotechBlock.theDeathHead, killTheDeath).registerStat();
		getScythe = new Achievement("achievement.getScythe", "getScythe", 5, 2, NanotechItem.scythe, killTheDeath).registerStat();
		getMysteriousMat = new Achievement("achievement.getMysteriousMat", "getMysteriousMat", 5, -2, new ItemStack(NanotechItem.itemBase, 1, 2), killTheDeath).registerStat();
		nanotechDim = new Achievement("achievement.nanotechDim", "nanotechDim", -3, 8, new ItemStack(NanotechBlock.nanoGrass, 0, 0), itemPortalActivator).registerStat();
		itemAlters = new Achievement("achievement.itemAlters", "itemAlters", -4, -2, new ItemStack(NanotechItem.alters, 1), installMod).registerStat();
		itemSiliconore = new Achievement("achievement.itemSiliconore", "itemSiliconore", -6, 2, new ItemStack(NanotechItem.itemBase, 1, 0), blockSiliconOre).registerStat();
		itemSiliconplate = new Achievement("achievement.itemSiliconplate", "itemSiliconplate", -6, 3, new ItemStack(NanotechItem.itemBase, 1, 3), itemSiliconore).registerStat();
		itemCircuit = new Achievement("achievement.itemCircuit", "itemCircuit", -6, 4, new ItemStack(NanotechItem.itemBase, 1, 5), itemSiliconplate).registerStat();
		itemAdvancedcircuit = new Achievement("achievement.itemAdvancedcircuit", "itemAdvancedcircuit", -6, 5, new ItemStack(NanotechItem.itemBase, 1, 6), itemCircuit).registerStat();
		itemProcessor = new Achievement("achievement.itemProcessor", "itemProcessor", -6, 6, new ItemStack(NanotechItem.itemBase, 1, 7), itemAdvancedcircuit).registerStat();
		itemMicroProcessor = new Achievement("achievement.itemMicroProcessor", "itemMicroProcessor", -6, 7, new ItemStack(NanotechItem.itemBase, 1, 8), itemProcessor).registerStat();
		itemCamera = new Achievement("achievement.itemCamera", "itemCamera", -7, 7, new ItemStack(NanotechItem.itemBase, 1, 9), itemMicroProcessor).registerStat();
		itemDetector = new Achievement("achievement.itemDetector", "itemDetector", -6, 8, new ItemStack(NanotechItem.itemBase, 1, 10), itemMicroProcessor).registerStat();
		itemEngine = new Achievement("achievement.itemEngine", "itemEngine", -5, 7, new ItemStack(NanotechItem.itemBase, 1, 11), itemMicroProcessor).registerStat();
		itemNanomiteFrame = new Achievement("achievement.itemNanomiteFrame", "itemNanomiteFrame", -4, 7, new ItemStack(NanotechItem.itemBase, 1, 13), itemEngine).registerStat();
		itemNanomite = new Achievement("achievement.itemNanomite", "itemNanomite", -4, 6, new ItemStack(NanotechItem.itemBase, 1, 12), itemNanomiteFrame).registerStat();
		itemSmallNanomite = new Achievement("achievement.itemSmallNanomite", "itemSmallNanomite", -4, 5, new ItemStack(NanotechItem.itemBase, 1, 14), itemNanomite).registerStat();
		itemStoneofdecrease = new Achievement("achievement.itemStoneofdecrease", "itemStoneofdecrease", -4, -1, new ItemStack(NanotechItem.itemBase, 1, 1), installMod).registerStat();
		itemMysteriousingot = new Achievement("achievement.itemMysteriousingot", "itemMysteriousingot", 5, -3, new ItemStack(NanotechItem.itemBase, 1, 4), getMysteriousMat).registerStat();
		itemVoid = new Achievement("achievement.itemVoid", "itemVoid", -4, -3, new ItemStack(NanotechItem.itemBase, 1, 15), installMod).registerStat();
		itemPortalActivator = new Achievement("achievement.itemPortalActivator", "itemPortalActivator", -2, 8, new ItemStack(NanotechItem.itemBase, 1, 16), blockPortalFrame).registerStat();
		itemCrazyGlasses = new Achievement("achievement.itemCrazyGlasses", "itemCrazyGlasses", -4, -4, new ItemStack(NanotechItem.crazyGlasses, 1), installMod).registerStat();
		itemDiamondBow = new Achievement("achievement.itemDiamondBow", "itemDiamondBow", -4, -5, new ItemStack(NanotechItem.diamondBow, 1), installMod).registerStat();
		itemEmeraldBow = new Achievement("achievement.itemEmeraldBow", "itemEmeraldBow", -5, -5, new ItemStack(NanotechItem.emeraldBow, 1), itemDiamondBow).registerStat();
		itemNanomiteBow = new Achievement("achievement.itemNanomiteBow", "itemNanomiteBow", -6, -5, new ItemStack(NanotechItem.nanomiteArrowGun, 1), itemEmeraldBow).registerStat().setSpecial();
		itemMysteriousArmor = new Achievement("achievement.itemMysteriousArmor", "itemMysteriousArmor", 5, -4, new ItemStack(NanotechItem.mysteriousChestPlate, 1), itemMysteriousingot).registerStat().setSpecial();
		itemNanomiteTool = new Achievement("achievement.itemNanomiteTool", "itemNanomiteTool", -4, 3, new ItemStack(NanotechItem.nanomitePickaxe, 1), itemSmallNanomite).registerStat().setSpecial();
		itemNanomiteArmor = new Achievement("achievement.itemNanomiteArmor", "itemNanomiteArmor", -5, 4, new ItemStack(NanotechItem.nanomiteChestPlate, 1), itemSmallNanomite).registerStat().setSpecial();
		itemReinforcedFishinRod = new Achievement("achievement.itemReinforcedFishinRod", "itemReinforcedFishinRod", -4, -6, new ItemStack(NanotechItem.reinforcedFishingRod, 1), installMod).registerStat();
		itemCrazyGlassesLauncher = new Achievement("achievement.itemCrazyGlassesLauncher", "itemCrazyGlassesLauncher", -5, -4, new ItemStack(NanotechItem.crazyGlassesGun, 1), itemCrazyGlasses).registerStat();
		itemFrozenFish = new Achievement("achievement.itemFrozenFish", "itemFrozenFish", -5, -6, new ItemStack(NanotechItem.itemBase, 1, 17), itemReinforcedFishinRod).registerStat().setSpecial();
		deathSatelit = new Achievement("achievement.deathSatelit", "deathSatelit", 2, -5, new ItemStack(Items.bone, 1), null).registerStat();
		deathLightLaser = new Achievement("achievement.deathLightLaser", "deathLightLaser", 2, -6, new ItemStack(Items.bone, 1), null).registerStat();
		deathAlters = new Achievement("achievement.deathAlters", "deathAlters", 2, -7, new ItemStack(Items.bone, 1), null).registerStat();
		deathSodium = new Achievement("achievement.deathSodium", "deathSodium", 3, -7, new ItemStack(Items.bone, 1), null).registerStat();
		deathNitrogen = new Achievement("achievement.deathNitrogen", "deathNitrogen", 3, -6, new ItemStack(Items.bone, 1), null).registerStat();
		deathBarbedWire = new Achievement("achievement.deathBarbedWire", "deathBarbedWire", 3, -5, new ItemStack(Items.bone, 1), null).registerStat();

		pageNanotech = new AchievementPage("nanotechmod", installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, blockSiliconOre, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim, blockListerJukebox, itemAlters, itemSiliconore, itemSiliconplate, itemCircuit, itemAdvancedcircuit, itemProcessor, itemMicroProcessor, itemCamera, itemDetector, itemEngine, itemNanomiteFrame, itemNanomite, itemSmallNanomite, itemStoneofdecrease, itemMysteriousingot, itemVoid, itemPortalActivator, itemCrazyGlasses, itemDiamondBow, itemEmeraldBow, itemNanomiteBow, itemMysteriousArmor, itemNanomiteTool, itemNanomiteArmor, itemReinforcedFishinRod, itemCrazyGlassesLauncher, itemFrozenFish, deathSatelit, deathLightLaser, deathAlters, deathSodium, deathNitrogen, deathBarbedWire);
		AchievementPage.registerAchievementPage(pageNanotech);
	}

	public static Achievement getInstallModAchievement()
	{
		return installMod;
	}
}