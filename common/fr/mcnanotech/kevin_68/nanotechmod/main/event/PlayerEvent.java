/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

public class PlayerEvent
{
	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event)
	{
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechModList.scythe)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.getScythe);
		}
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechModList.crazyGlasses)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.itemCrazyGlasses);
		}
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechModList.itemBase, 1, 2)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.getMysteriousMat);
		}
		if(event.item.getEntityItem().isItemEqual(new ItemStack(NanotechModList.ore, 1, 1)))
		{
			event.entityPlayer.triggerAchievement(NanotechAchievement.blockSiliconOre);
		}
	}
}