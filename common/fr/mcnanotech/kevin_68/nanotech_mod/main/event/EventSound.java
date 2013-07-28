package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

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
			event.manager.soundPoolSounds.addSound("nanotech/monster1.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/monster1.ogg"));
			event.manager.soundPoolSounds.addSound("nanotech/monster3.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/monster3.ogg"));
			event.manager.soundPoolSounds.addSound("nanotech/monsterhurt.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/monsterhurt.ogg"));
			event.manager.soundPoolSounds.addSound("nanotech/monsterdead.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/monsterdead.ogg"));
			event.manager.soundPoolSounds.addSound("nanotech/fly.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/fly.ogg"));
			event.manager.soundPoolSounds.addSound("nanotech/crazyguy.ogg", Nanotech_mod.class.getResource("/mods/Nanotech_mod/sounds/CrazyGuy.ogg"));

			File fich = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/nanodisk.ogg");
			File fich2 = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/YourSound.ogg");
			File txt2 = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/YourSound.txt");

			if(!fich.exists())
			{
				getFile("http://dl.mcnanotech.fr/kevin_68/Nanotech_mod/Disk/nanodisk.ogg", "nanodisk.ogg");
			}
			if(!fich2.exists() && !txt2.exists())
			{
				getFile("http://dl.mcnanotech.fr/kevin_68/Nanotech_mod/Disk/YourSound.txt", "YourSound.txt");
			}

		}
		catch(Exception e)
		{
			Nanotech_mod.NanoLog.severe("Failed to register event sounds");
		}
	}

	private void getFile(String path, String fileName) throws Exception
	{
		String fAddress = path;
		String localFileName = fileName;
		String destinationDir = Minecraft.getMinecraftDir() + "/resources/mod/streaming";
		OutputStream outStream = null;
		URLConnection uCon = null;
		InputStream is = null;
		File tmp = new File(destinationDir);

		if(!tmp.exists())
		{
			tmp.mkdir();
		}

		try
		{
			URL Url;
			byte[] buf;
			int ByteRead, ByteWritten = 0;
			Url = new URL(fAddress);
			outStream = new BufferedOutputStream(new FileOutputStream(destinationDir + "/" + localFileName));

			uCon = Url.openConnection();
			is = uCon.getInputStream();
			buf = new byte[1024];
			while((ByteRead = is.read(buf)) != -1)
			{
				outStream.write(buf, 0, ByteRead);
				ByteWritten += ByteRead;
			}

			System.out.println("File name: \"" + localFileName + "\"\nNo ofbytes: " + ByteWritten);
			System.out.println(destinationDir);
			is.close();
			outStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}