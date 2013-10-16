package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import net.minecraft.stats.Achievement;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;

public class NanotechCityAchievement
{
	public static Achievement blockSpotLight, blockTrail, blockTrashCan;

	public static void initAchievement()
	{
		blockSpotLight = new Achievement(12581, "blockSpotLight", 1, -1, NanotechCityBlock.BlockSpotLight, NanotechAchievement.getInstallModAchievement()).registerAchievement();
		blockTrail = new Achievement(12582, "blockTrail", 1, -2, NanotechCityBlock.BlockTrail, NanotechAchievement.getInstallModAchievement()).registerAchievement();
		blockTrashCan = new Achievement(12583, "blockTrashCan", 1, -3, NanotechCityBlock.BlockTrashcan, NanotechAchievement.getInstallModAchievement()).registerAchievement();
	}

	public static void addAchievementInPage()
	{
		NanotechAchievement.pageNanotech.getAchievements().add(blockSpotLight);
		NanotechAchievement.pageNanotech.getAchievements().add(blockTrail);
		NanotechAchievement.pageNanotech.getAchievements().add(blockTrashCan);
	}
}