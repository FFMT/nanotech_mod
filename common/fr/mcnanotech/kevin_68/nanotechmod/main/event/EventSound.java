package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

public class EventSound
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			event.manager.addSound("nanotechmod:monster1.ogg");
			event.manager.addSound("nanotechmod:monster3.ogg");
			event.manager.addSound("nanotechmod:monsterhurt.ogg");
			event.manager.addSound("nanotechmod:monsterdead.ogg");
			event.manager.addSound("nanotechmod:fly.ogg");
			event.manager.addSound("nanotechmod:CrazyGuy.ogg");
			event.manager.addSound("nanotechmod:crazyglassesgunreload.ogg");
			event.manager.addSound("nanotechmod:lightsaber.ogg");
			event.manager.addStreaming("nanotechmod:nanodisk.ogg");

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