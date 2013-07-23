package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class NanotechAchievement 
{

	//Achievement
	public static Achievement installMod;
	public static AchievementPage pageNanotech;
	
	public static void initAchievement()
	{
		installMod = new Achievement(12569, "installMod", 0, 0, new ItemStack(NanotechItem.ItemBase, 1, 12), null).registerAchievement();
		
		pageNanotech = new AchievementPage("Nanotech_mod", installMod);
		AchievementPage.registerAchievementPage(pageNanotech);
	}
}
