package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

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
		if(player.dimension == Nanotech_mod.dimensionID)
		{
			player.triggerAchievement(NanotechAchievement.nanotechDim);
		}
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{

	}
}