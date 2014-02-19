/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import net.minecraft.stats.Achievement;
import cpw.mods.fml.common.Loader;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

public class NanotechCityAchievement
{
	public static Achievement blockSpotLight, blockTrail, blockTrashCan;

	public static void initAchievement()
	{
		blockSpotLight = new Achievement("nanotechmodcityachievement1", "blockSpotLight", 1, -1, NanotechCityList.spotLight, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null);
		blockTrail = new Achievement("nanotechmodcityachievement2", "blockTrail", 1, -2, NanotechCityList.trail, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null);
		blockTrashCan = new Achievement("nanotechmodcityachievement3", "blockTrashCan", 1, -3, NanotechCityList.trashcan, Loader.isModLoaded("NanotechMod") ? NanotechAchievement.getInstallModAchievement() : null);
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