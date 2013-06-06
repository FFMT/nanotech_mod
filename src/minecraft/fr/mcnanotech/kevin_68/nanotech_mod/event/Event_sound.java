package fr.mcnanotech.kevin_68.nanotech_mod.event;

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
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class Event_sound
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            event.manager.soundPoolSounds.addSound("monster1.ogg", Nanotech_mod.class.getResource("/Nanotech_mod/client/Sounds/monster1.ogg"));
            event.manager.soundPoolSounds.addSound("monster3.ogg", Nanotech_mod.class.getResource("/Nanotech_mod/client/Sounds/monster3.ogg"));
            event.manager.soundPoolSounds.addSound("monsterhurt.ogg", Nanotech_mod.class.getResource("/Nanotech_mod/client/Sounds/monsterhurt.ogg"));
            event.manager.soundPoolSounds.addSound("monsterdead.ogg", Nanotech_mod.class.getResource("/Nanotech_mod/client/Sounds/monsterdead.ogg"));
            event.manager.soundPoolSounds.addSound("fly.ogg", Nanotech_mod.class.getResource("/Nanotech_mod/client/Sounds/fly.ogg"));
            
            File fich = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/nanodisk.ogg");
            File fich2 = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/YourSound.ogg");
            File txt2 = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/YourSound.txt");
            
            if (!fich.exists())
            {
            getsounds("https://dl.dropbox.com/u/76684272/Nanotech_mod/streaming/nanodisk.ogg");
            }
            if (!fich2.exists() && !txt2.exists())
            {
            gettxt("https://dl.dropbox.com/u/76684272/Nanotech_mod/streaming/YourSound.txt");
            }
            
        }
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
    
    private void getsounds(String path) throws Exception
    {
    String fAddress = path;
    String localFileName = "nanodisk.ogg";
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
    int ByteRead,ByteWritten=0;
    Url = new URL(fAddress);
    outStream = new BufferedOutputStream(new FileOutputStream(destinationDir+"/"+localFileName));

    uCon = Url.openConnection();
    is = uCon.getInputStream();
    buf = new byte[1024]; while ((ByteRead = is.read(buf)) != -1)
    {
    outStream.write(buf, 0, ByteRead);
    ByteWritten += ByteRead;
    }

    System.out.println("File name: \""+localFileName+ "\"\nNo ofbytes: " + ByteWritten);
    System.out.println(destinationDir); is.close();
    outStream.close();
    }
    catch (Exception e) { e.printStackTrace(); }
    }
    
    private void gettxt(String path) throws Exception
    {
    String fAddress = path;
    String localFileName = "YourSound.txt";
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
    int ByteRead,ByteWritten=0;
    Url = new URL(fAddress);
    outStream = new BufferedOutputStream(new FileOutputStream(destinationDir+"/"+localFileName));

    uCon = Url.openConnection();
    is = uCon.getInputStream();
    buf = new byte[1024]; while ((ByteRead = is.read(buf)) != -1)
    {
    outStream.write(buf, 0, ByteRead);
    ByteWritten += ByteRead;
    }

    System.out.println("File name: \""+localFileName+ "\"\nNo ofbytes: " + ByteWritten);
    System.out.println(destinationDir); is.close();
    outStream.close();
    }
    catch (Exception e) { e.printStackTrace(); }
    }
}