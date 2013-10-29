package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
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
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechItem.crazyGlasses)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.itemCrazyGlasses);
		}
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechItem.itemBase, 1, 2)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.getMysteriousMat);
		}
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechBlock.nanoOre, 1, 1)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.blockSiliconOre);
		}
	}
}