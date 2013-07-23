package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;

public class PlayerTracker implements IPlayerTracker
{

	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		player.triggerAchievement(NanotechAchievement.installMod);
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{

	}

}