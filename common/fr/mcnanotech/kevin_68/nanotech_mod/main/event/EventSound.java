package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import java.io.File;

import net.minecraft.client.Minecraft;
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
			event.manager.addSound("nanotech_mod:monster1.ogg");
			event.manager.addSound("nanotech_mod:monster3.ogg");
			event.manager.addSound("nanotech_mod:monsterhurt.ogg");
			event.manager.addSound("nanotech_mod:monsterdead.ogg");
			event.manager.addSound("nanotech_mod:fly.ogg");
			event.manager.addSound("nanotech_mod:CrazyGuy.ogg");
			event.manager.addStreaming("nanotech_mod:nanodisk.ogg");
			for(int i = 1; i < 17; i++)
			{
				event.manager.addStreaming("nanotech_mod:YourSound" + i + ".ogg");
			}
			
	        File di = new File(Minecraft.getMinecraft().mcDataDir, "/assets/records/");
	        if (!di.exists())
	        {
	        	di.mkdirs();
	        }
	        File fl[] = di.listFiles();
	        
	        for (int i = 0; i != fl.length; i++)
	        {
	        	String soundName = fl[i].getName();
	        	event.manager.addStreaming(soundName);
	        }
		}
		catch(Exception e)
		{
			Nanotech_mod.NanoLog.severe("Failed to register event sounds");
		}
	}
}