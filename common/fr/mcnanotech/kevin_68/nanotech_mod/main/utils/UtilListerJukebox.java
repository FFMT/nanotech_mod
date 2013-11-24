package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class UtilListerJukebox
{
	public static String cdDirectoryName;
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
		recordsDir = new File(minecraft.getMinecraft().mcDataDir + "/assets/nanotech_mod/records/");
		if(!recordsDir.exists())
		{
			recordsDir.mkdirs();
		}
		cdDirectoryName = recordsDir.getAbsolutePath();
		unsortedFileList = recordsDir.listFiles();		
		
		for(int i = 0; i != unsortedFileList.length; i++)
		{
			System.out.println(unsortedFileList[i].getName());
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
