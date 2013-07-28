package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class EventRenderOverlay
{
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event)
	{}
}