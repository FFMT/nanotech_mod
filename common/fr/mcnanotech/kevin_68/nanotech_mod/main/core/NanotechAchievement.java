package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class NanotechAchievement
{
	// Achievement
	public static Achievement installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockSpotLight, blockTheDeath, blockTrail, blockTrashCan, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat;
	public static AchievementPage pageNanotech;

	public static void initAchievement()
	{
		installMod = new Achievement(12569, "installMod", 0, 0, new ItemStack(NanotechItem.ItemBase, 1, 12), null).registerAchievement();
		blockBarbedWire = new Achievement(12570, "blockBarbedWire", 5, 5, NanotechBlock.BlockBarbedwire, installMod).registerAchievement();
		blockConfusion = new Achievement(12571, "blockConfusion", 4, 5, NanotechBlock.BlockConfusion, installMod).registerAchievement();
		blockFalling = new Achievement(12572, "blockFalling", 3, 5, NanotechBlock.BlockFalling, installMod).registerAchievement();
		blockJumper = new Achievement(12573, "blockJumper", 0, 5, new ItemStack(NanotechBlock.BlockJumper, 1, 0), installMod).registerAchievement();
		blockJumperAdv = new Achievement(12574, "blockJumperAdv", 0, 7, new ItemStack(NanotechBlock.BlockJumper, 1, 1), blockJumper).registerAchievement();
		blockMossyStone = new Achievement(12575, "blockMossyStone", 1, 5, NanotechBlock.BlockMossystone, installMod).registerAchievement();
		blockNotFalling = new Achievement(12576, "blockNotFalling", 2, 5, NanotechBlock.Blocknotfalling, installMod).registerAchievement();
		blockPortalFrame = new Achievement(12577, "blockPortalFrame", -1, 5, NanotechBlock.BlockPortalFrame, installMod).registerAchievement();
		blockSmoker = new Achievement(12578, "blockSmoker", -2, 5, NanotechBlock.BlockSmoker, installMod).registerAchievement();
		blockSpeed = new Achievement(12579, "blockSpeed", -3, 5, NanotechBlock.BlockSpeed, installMod).registerAchievement();
		blockSlow = new Achievement(12580, "blockSlow", -4, 5, new ItemStack(NanotechBlock.BlockSpeed, 1, 1), installMod).registerAchievement();
		if (Nanotech_mod.nanotech_mod_city())
		{
			blockSpotLight = new Achievement(12581, "blockSpotLight", -5, 5, NanotechCityBlock.BlockSpotLight, installMod).registerAchievement();
			blockTrail = new Achievement(12582, "blockTrail", -6, 5, NanotechCityBlock.BlockTrail, installMod).registerAchievement();
			blockTrashCan = new Achievement(12583, "blockTrashCan", 6, 5, NanotechCityBlock.BlockTrashcan, installMod).registerAchievement();
		}
		blockTheDeath = new Achievement(12584, "blockTheDeath", 3, 0, NanotechBlock.BlockTheDeathHead, installMod).registerAchievement();
		killTheDeath = new Achievement(12586, "killTheDeath", 5, 0, NanotechBlock.BlockTheDeathHead, blockTheDeath).registerAchievement();
		killTheDeathWithCG = new Achievement(12587, "killTheDeathWithCG", 7, 0, NanotechBlock.BlockTheDeathHead, killTheDeath).registerAchievement();
		getScythe = new Achievement(12588, "getScythe", 5, 2, NanotechItem.scythe, killTheDeath).registerAchievement();
		getMysteriousMat = new Achievement(12589, "getMysteriousMat", 5, -2, new ItemStack(NanotechItem.ItemBase, 1, 2), killTheDeath).registerAchievement();

		pageNanotech = new AchievementPage("Nanotech_mod", installMod, blockBarbedWire, blockConfusion, blockFalling, blockJumper, blockJumperAdv, blockMossyStone, blockNotFalling, blockPortalFrame, blockSmoker, blockSpeed, blockSlow, blockSpotLight, blockTrail, blockTrashCan, blockTheDeath, killTheDeath, killTheDeathWithCG, getScythe, getMysteriousMat);
		AchievementPage.registerAchievementPage(pageNanotech);
	}
}
