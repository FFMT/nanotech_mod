package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.IPlayerTracker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

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

	@ForgeSubscribe
	public void onItemPickup(EntityItemPickupEvent event)
	{
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechItem.scythe)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.getScythe);
		}
	}
}