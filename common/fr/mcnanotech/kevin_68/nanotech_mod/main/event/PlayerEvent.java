package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class PlayerEvent
{
	@ForgeSubscribe
	public void onItemPickup(EntityItemPickupEvent event)
	{
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechItem.scythe)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.getScythe);
		}
	}
}