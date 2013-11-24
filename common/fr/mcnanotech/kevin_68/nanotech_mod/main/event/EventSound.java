package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
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

			/*
			 * File di = new File(Minecraft.getMinecraft().mcDataDir,
			 * "/assets/records/"); if(!di.exists()) { di.mkdirs(); }
			 */

			for(int i = 0; i != UtilListerJukebox.fileList.length; i++)
			{
				String soundName = UtilListerJukebox.fileList[i].getName();
				event.manager.addStreaming("nanotech_mod:" + soundName);
			}
		}
		catch(Exception e)
		{
			Nanotech_mod.nanoLog.severe("Failed to register event sounds");
		}
	}
}