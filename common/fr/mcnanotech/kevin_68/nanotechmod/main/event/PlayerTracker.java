package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

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
		if(player.dimension == NanotechMod.dimensionID)
		{
			player.triggerAchievement(NanotechAchievement.nanotechDim);
		}
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{

	}
}