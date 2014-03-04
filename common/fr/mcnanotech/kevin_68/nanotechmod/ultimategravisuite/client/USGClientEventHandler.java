package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;

public class USGClientEventHandler
{
	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == TickEvent.Phase.START)
		{
			UltimateGraviSuiteMod.keyboard.sendKeyUpdate();
		}
	}
}