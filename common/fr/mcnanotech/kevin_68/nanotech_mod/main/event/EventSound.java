package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class EventSound
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			event.manager.addSound("Nanotech_mod:monster1.ogg");
			event.manager.addSound("Nanotech_mod:monster3.ogg");
			event.manager.addSound("Nanotech_mod:monsterhurt.ogg");
			event.manager.addSound("Nanotech_mod:monsterdead.ogg");
			event.manager.addSound("Nanotech_mod:fly.ogg");
			event.manager.addSound("Nanotech_mod:CrazyGuy.ogg");
			event.manager.addStreaming("Nanotech_mod:nanodisk.ogg");
			for (int i = 1; i < 17; i++)
			{
				event.manager.addStreaming("Nanotech_mod:YourSound" + i +".ogg");
			}

		}
		catch(Exception e)
		{
			Nanotech_mod.NanoLog.severe("Failed to register event sounds");
		}
	}
}