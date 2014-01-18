package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import cpw.mods.fml.common.Loader;
import net.minecraft.stats.Achievement;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

public class NanotechCityAchievement
{
	public static Achievement blockSpotLight, blockTrail, blockTrashCan;

	public static void initAchievement()
	{
		blockSpotLight = new Achievement(12581, "blockSpotLight", 1, -1, NanotechCityBlock.spotLight, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null).registerAchievement();
		blockTrail = new Achievement(12582, "blockTrail", 1, -2, NanotechCityBlock.trail, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null).registerAchievement();
		blockTrashCan = new Achievement(12583, "blockTrashCan", 1, -3, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null).registerAchievement();
	}

	public static void addAchievementInPage()
	{
		if(Loader.isModLoaded("NanotechMod"))
		{
			NanotechAchievement.pageNanotech.getAchievements().add(blockSpotLight);
			NanotechAchievement.pageNanotech.getAchievements().add(blockTrail);
			NanotechAchievement.pageNanotech.getAchievements().add(blockTrashCan);
		}
	}
}