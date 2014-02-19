/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;

public class CityCraftingHandler
{
	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event)
	{
		if(event.crafting.getItem().equals(Item.getItemFromBlock(NanotechCityBlock.spotlight)))
		{
			event.player.triggerAchievement(NanotechCityAchievement.blockSpotLight);
		}
		if(event.crafting.getItem().equals(Item.getItemFromBlock(NanotechCityBlock.trail)))
		{
			event.player.triggerAchievement(NanotechCityAchievement.blockTrail);
		}
		if(event.crafting.getItem().equals(Item.getItemFromBlock(NanotechCityBlock.trashcan)))
		{
			event.player.triggerAchievement(NanotechCityAchievement.blockTrashCan);
		}
	}
}