/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class UtilListerJukebox
{
	private static final File mcDir = Minecraft.getMinecraft().mcDataDir;
	private static final File mainDir = new File(new File(mcDir, "nanotechmod"), "jukebox");
	private static final File txtDir = new File(mainDir, "sounds_" + Minecraft.getMinecraft().getSession().getUsername() + ".txt");
	private static final File categDir = new File(mainDir, "category.txt");

	public static void debug()
	{
		NanotechMod.nanoLogger.info("~~~~~~~~~~~Starting Lister JukeBox debug~~~~~~~~~~~");
		NanotechMod.nanoLogger.info(mcDir);
		NanotechMod.nanoLogger.info(mainDir);
		NanotechMod.nanoLogger.info(txtDir);
		NanotechMod.nanoLogger.info(categDir);
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
						writer.write("#This file contain all the sounds of " + Minecraft.getMinecraft().getSession().getUsername() + "\n");
						writer.write("#directory~&~name~&~category~&~color~&~UID\n");
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

		if(!categDir.exists())
		{
			try
			{
				categDir.createNewFile();
				NanotechMod.nanoLogger.info("File created");
				try
				{
					FileWriter writer = new FileWriter(categDir);
					try
					{
						writer.write("#This file contain all category\n");
						writer.write("#category~color~owner\n");
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

	public static File getMainDir()
	{
		return mainDir;
	}

	public static void addSound(String modid, String directory, String name, String category, int color)
	{
		String categ = category.length() > 1 ? category : "default";

		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(txtDir, true));
			writer.write(modid + "~&~" + directory + "~&~" + name + "~&~" + categ + "~&~" + color + "~&~" + FileUtils.readLines(txtDir).size() + "\n");
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getAllLines()
	{
		ArrayList<String> arrList = new ArrayList();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(txtDir));
			String line;
			while((line = reader.readLine()) != null)
			{
				if(!line.contains("#"))
				{
					arrList.add(arrList.size(), line);
				}
			}
			arrList.add(arrList.size(), reader.readLine());
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return arrList;
	}
	
	public static String[] getInfoStringbyUID(int UID)
	{
		ArrayList<String> rawList = getAllLines();
		String[] list = new String[6];
		
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~&~");
			if(str[5] == String.valueOf(UID))
			{
				list = str;
			}
		}
		return list;
	}

	public static ArrayList<String> getModidList()
	{
		ArrayList<String> arrList = new ArrayList();
		List<ModContainer> modList = Loader.instance().getModList();

		arrList.add(0, "minecraft");

		for(int i = 1; i < modList.size() - 1; i++)
		{
			arrList.add(i, modList.get(i).getModId());
		}

		return arrList;
	}

	public static String getModid(int i)
	{
		if(i > -1)
		{
			return getModidList().get(i);
		}
		else
		{
			return "minecraft";
		}
	}

	public static String getModidByUID(int UID)
	{
		return getInfoStringbyUID(UID)[0];
	}
	
	public static String getDirectoryByUID(int UID)
	{
		return getInfoStringbyUID(UID)[1];
	}
	
	public static String getNameByUID(int UID)
	{
		return getInfoStringbyUID(UID)[2];
	}
	
	public static String getCategoryByUID(int UID)
	{
		return getInfoStringbyUID(UID)[3];
	}
	
	public static int getColorByUID(int UID)
	{
		return Integer.valueOf(getInfoStringbyUID(UID)[4]);
	}
	
	public static String getStringForPlayingbyUID(int UID)
	{
		return getInfoStringbyUID(UID)[0] + ":" + getInfoStringbyUID(UID)[1];
	}
	
	public static ArrayList<Integer> UIDS()
	{
		ArrayList<String> rawList = getAllLines();
		ArrayList<Integer> list = new ArrayList();
		
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~&~");
			list.add(list.size(), Integer.valueOf(str[5]));
		}
		return list;
	}
	
	
	
	
	
	

	@Deprecated
	public static void setSound(String directory, String name, String category, int color)
	{
		String categ = category.length() > 1 ? category : "default";

		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(txtDir, true));
			writer.write(directory + "~" + name + "~" + categ + "~" + color + "\n");
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Deprecated
	public static void setCategory(String name, int color)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(categDir, true));
			writer.write(name + "~" + color + "~" + Minecraft.getMinecraft().getSession().getUsername() + "\n");
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Deprecated
	public static void editSound(int index, String directory, String name, String category, int color)
	{
		String categ = category.length() > 1 ? category : "default";

		try
		{
			int li = index + 2;
			List<String> line = FileUtils.readLines(txtDir);
			line.set(li, directory + "~" + name + "~" + categ + "~" + color + "\n");
			FileUtils.writeLines(txtDir, line);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Deprecated
	private static ArrayList<String> getCategory()
	{
		ArrayList<String> arrList = new ArrayList();
		arrList.add(0, "default~16777215~kevin_68");
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(categDir));
			String line;
			while((line = reader.readLine()) != null)
			{
				if(!line.contains("#"))
				{
					arrList.add(arrList.size(), line);
				}
			}
			arrList.add(arrList.size(), reader.readLine());
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getCategoryName()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getCategory();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(i, str[0]);
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<Integer> getCategoryColor()
	{
		ArrayList<Integer> arrList = new ArrayList();
		ArrayList<String> rawList = getCategory();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(i, Integer.valueOf(str[1]));
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getCategoryOwner()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getCategory();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(i, str[2]);
		}
		return arrList;
	}

	@Deprecated
	private static ArrayList<String> getSounds()
	{
		ArrayList<String> arrList = new ArrayList();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(txtDir));
			String line;
			while((line = reader.readLine()) != null)
			{
				if(!line.contains("#"))
				{
					arrList.add(arrList.size(), line);
				}
			}
			arrList.add(arrList.size(), reader.readLine());
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getAllSoundsDirectory()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getSounds();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(arrList.size(), str[0]);
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getAllSoundsName()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getSounds();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(arrList.size(), str[1]);
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getSoundsByCategory(String category)
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getSounds();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String categ = rawList.get(i).split("~")[2];
			if(categ == category)
			{
				arrList.add(arrList.size(), rawList.get(i).split("~")[1]);
			}
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<String> getSoundCategory()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> rawList = getSounds();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(arrList.size(), str[2]);
		}
		return arrList;
	}

	@Deprecated
	public static ArrayList<Integer> getSoundColor()
	{
		ArrayList<Integer> arrList = new ArrayList();
		ArrayList<String> rawList = getSounds();
		for(int i = 0; i != rawList.size() - 1; i++)
		{
			String[] str = rawList.get(i).split("~");
			arrList.add(arrList.size(), Integer.valueOf(str[3]));
		}
		return arrList;
	}
}