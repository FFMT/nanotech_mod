/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;

public class PlayerTracker
{

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		event.player.triggerAchievement(NanotechAchievement.installMod);
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerChangedDimensionEvent event)
	{
		if(event.player.dimension == NanotechConfiguration.dimensionID)
		{
			event.player.triggerAchievement(NanotechAchievement.nanotechDim);
		}
	}
}