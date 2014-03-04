package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class USGCommonEventHandler
{
	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == TickEvent.Phase.END)
		{
			if(UltimateGraviSuiteMod.keyboard.isFlyKeyDown(event.player))
			{
				System.out.println(event.player.getCommandSenderName() + " pressed fly key");
			}
			if(UltimateGraviSuiteMod.keyboard.isInvisibleKeyDown(event.player))
			{
				System.out.println(event.player.getCommandSenderName() + " pressed invisible key");
			}
		}
	}
}