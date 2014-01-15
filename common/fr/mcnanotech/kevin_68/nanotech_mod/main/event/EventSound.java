package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilListerJukebox;

public class EventSound
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			event.manager.addSound("nanotech_mod:monster1.ogg");
			event.manager.addSound("nanotech_mod:monster3.ogg");
			event.manager.addSound("nanotech_mod:monsterhurt.ogg");
			event.manager.addSound("nanotech_mod:monsterdead.ogg");
			event.manager.addSound("nanotech_mod:fly.ogg");
			event.manager.addSound("nanotech_mod:CrazyGuy.ogg");
			event.manager.addSound("nanotech_mod:crazyglassesgunreload.ogg");
			event.manager.addSound("nanotech_mod:lightsaber.ogg");
			event.manager.addStreaming("nanotech_mod:nanodisk.ogg");

			for(int i = 0; i != UtilListerJukebox.unsortedFileList.length; i++)
			{
				String soundName = UtilListerJukebox.unsortedFileList[i].getName();
				boolean isVanillaSound = soundName.equals("11.ogg") || soundName.equals("13.ogg") || soundName.equals("blocks.ogg") || soundName.equals("cat.ogg") || soundName.equals("chirp.ogg") || soundName.equals("far.ogg") || soundName.equals("mall.ogg") || soundName.equals("mellohi.ogg") || soundName.equals("stal.ogg") || soundName.equals("strad.ogg") || soundName.equals("wait.ogg") || soundName.equals("ward.ogg");
				if(!isVanillaSound && soundName.contains(".ogg"))
				{
					event.manager.addStreaming(soundName);
				}
			}
		}
		catch(Exception e)
		{
			NanotechMod.nanoLog.severe("Failed to register event sounds");
		}
	}
}