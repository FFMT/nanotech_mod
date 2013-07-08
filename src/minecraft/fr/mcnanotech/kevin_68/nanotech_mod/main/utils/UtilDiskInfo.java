package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class UtilDiskInfo
{
	public static String[] cdInfo = new String[16];

	public static void readInfo()
	{
		File cdlocalization = new File(Minecraft.getMinecraftDir() + "/resources/mod/streaming/diskinfo.txt");
		if (!cdlocalization.exists())
		{
			try
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter(cdlocalization));
				for (int i = 1; i < 17; i++)
				{
					bw.write("cd information" + i);
					bw.newLine();
				}
				bw.close();
			}
			catch (IOException e)
			{}
		}

		else
		{
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(cdlocalization));
				for (int i = 0; i < 16; i++)
				{
					cdInfo[i] = br.readLine();
				}
				br.close();
			}
			catch (IOException e)
			{
				System.out.println("Failed to read cd name");
			}
		}
	}
}
