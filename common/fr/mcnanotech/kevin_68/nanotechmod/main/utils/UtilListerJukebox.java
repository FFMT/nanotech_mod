/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class UtilListerJukebox
{
	private static final File mcDir = Minecraft.getMinecraft().mcDataDir;
	private static final File mainDir = new File(mcDir + "/nanotechmod/jukebox/");
	private static final File txtDir = new File(mainDir + "/sounds_" + Minecraft.getMinecraft().getSession().getUsername() + ".txt");

	public static void debug()
	{
		NanotechMod.nanoLogger.info("~~~~~~~~~~~Starting Lister JukeBox debug~~~~~~~~~~~");
		NanotechMod.nanoLogger.info(mcDir);
		NanotechMod.nanoLogger.info(mainDir);
		NanotechMod.nanoLogger.info(txtDir);
		NanotechMod.nanoLogger.info("~~~~~~~~~~~Ending Lister JukeBox debug~~~~~~~~~~~");
	}

	public static void init()
	{
		if(!mainDir.exists())
		{
			mainDir.mkdirs();
			NanotechMod.nanoLogger.info("Folders created");
		}

		if(!txtDir.exists())
		{
			try
			{
				txtDir.createNewFile();
				NanotechMod.nanoLogger.info("File created");
				try
				{
					FileWriter writer = new FileWriter(txtDir);
					try
					{
						writer.write("#This file contain all the sounds of " + Minecraft.getMinecraft().getSession().getUsername());
						NanotechMod.nanoLogger.info("Informations added");
					}
					catch(IOException e)
					{
						e.printStackTrace();
						NanotechMod.nanoLogger.error("Failed to write informations");
					}
					finally
					{
						writer.close();
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
					NanotechMod.nanoLogger.error("Error on FileWriter");
				}
			}
			catch(IOException e)
			{
				NanotechMod.nanoLogger.error("Failed to create file");
				e.printStackTrace();
			}
		}
	}
}