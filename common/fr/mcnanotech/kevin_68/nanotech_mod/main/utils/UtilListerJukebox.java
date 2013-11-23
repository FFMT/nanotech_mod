package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.io.File;
import java.io.FileFilter;

import net.minecraft.client.Minecraft;

public class UtilListerJukebox
{
	public static String cdDirectoryName;
	public static File recordsDir;
	public static File fileList[];
	public static File playlist;
	public static File playlistFolders[];
	public static File playlistlist1[];
	public static File playlistlist2[];
	public static File playlistlist3[];
	public static File playlistlist4[];
	public static File playlistlist5[];
	public static File playlistlist6[];

	public static void scanFolder(Minecraft minecraft)
	{
		recordsDir = new File(minecraft.getMinecraft().mcDataDir + "/assets/records/");
		cdDirectoryName = recordsDir.getAbsolutePath();
		fileList = recordsDir.listFiles();
		playlist = new File(recordsDir + "/playlists/");
		if(!playlist.exists())
		{
			playlist.mkdirs();
		}
		playlistFolders = new File[] {new File(playlist + "/playlist1/"), new File(playlist + "/playlist2/"), new File(playlist + "/playlist3/"), new File(playlist + "/playlist4/"), new File(playlist + "/playlist5/"), new File(playlist + "/playlist6/")};

		for(int i = 0; i != 6; i++)
		{
			if(!playlistFolders[i].exists())
			{
				playlistFolders[i].mkdirs();
			}
		}
		
		playlistlist1 = playlistFolders[0].listFiles();
		playlistlist2 = playlistFolders[1].listFiles();
		playlistlist3 = playlistFolders[2].listFiles();
		playlistlist4 = playlistFolders[3].listFiles();
		playlistlist5 = playlistFolders[4].listFiles();
		playlistlist6 = playlistFolders[5].listFiles();
	}
}
