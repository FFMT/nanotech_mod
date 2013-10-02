package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class NanotechAchievement
{
	// Achievement
	public static Achievement installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim;
	public static AchievementPage pageNanotech;

	public static void initAchievement()
	{
		installMod = new Achievement(12569, "installMod", 0, 0, new ItemStack(NanotechItem.ItemBase, 1, 12), null).registerAchievement();
		blockBarbedWire = new Achievement(12570, "blockBarbedWire", 1, 8, NanotechBlock.BlockBarbedwire, installMod).registerAchievement();
		blockConfusion = new Achievement(12571, "blockConfusion", 1, 6, NanotechBlock.BlockConfusion, installMod).registerAchievement();
		blockFalling = new Achievement(12572, "blockFalling", 1, 7, NanotechBlock.BlockFalling, installMod).registerAchievement();
		blockJumper = new Achievement(12573, "blockJumper", -1, 5, new ItemStack(NanotechBlock.BlockJumper, 1, 0), installMod).registerAchievement();
		blockJumperAdv = new Achievement(12574, "blockJumperAdv", -3, 5, new ItemStack(NanotechBlock.BlockJumper, 1, 1), blockJumper).registerAchievement();
		blockMossyStone = new Achievement(12575, "blockMossyStone", -1, 6, NanotechBlock.BlockMossystone, installMod).registerAchievement();
		blockNotFalling = new Achievement(12576, "blockNotFalling", -1, 7, NanotechBlock.Blocknotfalling, installMod).registerAchievement();
		blockPortalFrame = new Achievement(12577, "blockPortalFrame", -1, 8, NanotechBlock.BlockPortalFrame, installMod).registerAchievement();
		blockSmoker = new Achievement(12578, "blockSmoker", 1, 5, NanotechBlock.BlockSmoker, installMod).registerAchievement();
		blockSpeed = new Achievement(12579, "blockSpeed", -2, 3, NanotechBlock.BlockSpeed, installMod).registerAchievement();
		blockSlow = new Achievement(12580, "blockSlow", -2, 2, new ItemStack(NanotechBlock.BlockSpeed, 1, 1), installMod).registerAchievement();
		blockTheDeath = new Achievement(12584, "blockTheDeath", 3, 0, NanotechBlock.BlockTheDeathHead, installMod).registerAchievement();
		killTheDeath = new Achievement(12586, "killTheDeath", 5, 0, NanotechBlock.BlockTheDeathHead, blockTheDeath).registerAchievement();
		killTheDeathWithCG = new Achievement(12587, "killTheDeathWithCG", 7, 0, NanotechBlock.BlockTheDeathHead, killTheDeath).registerAchievement();
		getScythe = new Achievement(12588, "getScythe", 5, 2, NanotechItem.scythe, killTheDeath).registerAchievement();
		getMysteriousMat = new Achievement(12589, "getMysteriousMat", 5, -2, new ItemStack(NanotechItem.ItemBase, 1, 2), killTheDeath).registerAchievement();
		nanotechDim = new Achievement(12590, "nanotechDim", -3, 8, new ItemStack(NanotechBlock.BlockGrass, 0, 0), blockPortalFrame).registerAchievement();

		pageNanotech = new AchievementPage("Nanotech_mod", installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockTheDeath, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat, nanotechDim);
		AchievementPage.registerAchievementPage(pageNanotech);
	}
}