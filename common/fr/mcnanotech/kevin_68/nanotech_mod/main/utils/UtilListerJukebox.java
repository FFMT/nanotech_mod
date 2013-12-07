package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.util.ResourceLocation;

public class UtilListerJukebox
{
	public static String mcDir;
	public static String cdDirectoryName;
	public static File oldRecordsDir;
	public static File newRecordsDir;
	public static File recordsDir;
	public static File unsortedFileList[];
	public static ArrayList<File> fileListA = new ArrayList();
	public static ArrayList<File> playlistlist1A = new ArrayList();
	public static ArrayList<File> playlistlist2A = new ArrayList();
	public static ArrayList<File> playlistlist3A = new ArrayList();
	public static ArrayList<File> playlistlist4A = new ArrayList();
	public static ArrayList<File> playlistlist5A = new ArrayList();
	public static ArrayList<File> playlistlist6A = new ArrayList();

	public static File fileList[];
	public static File playlistlist1[];
	public static File playlistlist2[];
	public static File playlistlist3[];
	public static File playlistlist4[];
	public static File playlistlist5[];
	public static File playlistlist6[];

	public static void scanFolder(Minecraft minecraft)
	{
		mcDir = String.valueOf(minecraft.getMinecraft().mcDataDir);
		oldRecordsDir = new File(minecraft.getMinecraft().mcDataDir + "/assets/records/");
		newRecordsDir = new File(minecraft.getMinecraft().mcDataDir + "/assets/virtual/legacy/records/");
		recordsDir = new File("");
		if(!oldRecordsDir.exists())
		{
			if(!newRecordsDir.exists())
			{
				newRecordsDir.mkdirs();
				recordsDir = newRecordsDir;
			}
			else
			{
				recordsDir = newRecordsDir;
			}
		}
		else
		{
			recordsDir = oldRecordsDir;
		}

		cdDirectoryName = recordsDir.getAbsolutePath();
		unsortedFileList = recordsDir.listFiles();

		for(int i = 0; i != unsortedFileList.length; i++)
		{
			if(unsortedFileList[i].getName().contains("_pl1"))
			{
				playlistlist1A.add(playlistlist1A.size(), unsortedFileList[i]);
			}
			else if(unsortedFileList[i].getName().contains("_pl2"))
			{
				playlistlist2A.add(playlistlist2A.size(), unsortedFileList[i]);
			}
			else if(unsortedFileList[i].getName().contains("_pl3"))
			{
				playlistlist3A.add(playlistlist3A.size(), unsortedFileList[i]);
			}
			else if(unsortedFileList[i].getName().contains("_pl4"))
			{
				playlistlist4A.add(playlistlist4A.size(), unsortedFileList[i]);
			}
			else if(unsortedFileList[i].getName().contains("_pl5"))
			{
				playlistlist5A.add(playlistlist5A.size(), unsortedFileList[i]);
			}
			else if(unsortedFileList[i].getName().contains("_pl6"))
			{
				playlistlist6A.add(playlistlist6A.size(), unsortedFileList[i]);
			}
			else
			{
				fileListA.add(fileListA.size(), unsortedFileList[i]);
			}
		}

		fileList = new File[fileListA.size()];
		for(int i = 0; i != fileListA.size(); i++)
		{
			fileList[i] = fileListA.get(i);
		}
		playlistlist1 = new File[playlistlist1A.size()];
		for(int i = 0; i != playlistlist1A.size(); i++)
		{
			playlistlist1[i] = playlistlist1A.get(i);
		}
		playlistlist2 = new File[playlistlist2A.size()];
		for(int i = 0; i != playlistlist2A.size(); i++)
		{
			playlistlist2[i] = playlistlist2A.get(i);
		}
		playlistlist3 = new File[playlistlist3A.size()];
		for(int i = 0; i != playlistlist3A.size(); i++)
		{
			playlistlist3[i] = playlistlist3A.get(i);
		}
		playlistlist4 = new File[playlistlist4A.size()];
		for(int i = 0; i != playlistlist4A.size(); i++)
		{
			playlistlist4[i] = playlistlist4A.get(i);
		}
		playlistlist5 = new File[playlistlist5A.size()];
		for(int i = 0; i != playlistlist5A.size(); i++)
		{
			playlistlist5[i] = playlistlist5A.get(i);
		}
		playlistlist6 = new File[playlistlist6A.size()];
		for(int i = 0; i != playlistlist6A.size(); i++)
		{
			playlistlist6[i] = playlistlist6A.get(i);
		}
	}
}
