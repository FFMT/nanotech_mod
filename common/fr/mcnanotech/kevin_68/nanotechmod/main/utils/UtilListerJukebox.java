/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UtilListerJukebox
{
	private static final File mcDir = Minecraft.getMinecraft().mcDataDir;
	private static final File mainDir = new File(new File(mcDir, "nanotechmod"), "jukebox");
	private static final File dataFile = new File(mainDir, "sounds.dat");

	public static void init()
	{
		if(!mainDir.exists())
		{
			mainDir.mkdirs();
		}
		if(!dataFile.exists())
		{
			try
			{
				dataFile.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private static NBTTagCompound getData()
	{
		try
		{
			FileInputStream fileinputstream = new FileInputStream(dataFile);
			NBTTagCompound compound = CompressedStreamTools.readCompressed(fileinputstream);
			fileinputstream.close();
			return compound;
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
			NBTTagCompound compound = new NBTTagCompound();
			saveData(compound);
			return compound;
		}
	}

	private static void saveData(NBTTagCompound compound)
	{
		try
		{
			FileOutputStream fileoutputstream = new FileOutputStream(dataFile);
			CompressedStreamTools.writeCompressed(compound, fileoutputstream);
			fileoutputstream.close();
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}

	public static void addSound(String player, int id, String dir, String name, String categorie, int color)
	{
		NBTTagCompound compound = getData();
		NBTTagList playerList = compound.hasKey(player) ? compound.getTagList(player, Constants.NBT.TAG_COMPOUND) : new NBTTagList();
		NBTTagCompound playerTag = playerList.tagCount() > id ? playerList.getCompoundTagAt(id) : new NBTTagCompound();
		playerTag.setString("dir", dir);
		playerTag.setString("name", name);
		playerTag.setString("categorie", categorie);
		playerTag.setInteger("color", color);
		playerList.appendTag(playerTag);
		compound.setTag(player, playerList);
		saveData(compound);
	}

	public static int getNextId(String player)
	{
		NBTTagCompound compound = getData();
		if(compound.hasKey(player)) 
		{
			NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
			return playerList.tagCount();
		}
		else
		{
			return 0;
		}
		
	}

	public static SoundEntry getSound(String player, int id)
	{
		NBTTagCompound compound = getData();
		NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
		NBTTagCompound playerTag = playerList.getCompoundTagAt(id);
		return new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getString("categorie"), playerTag.getInteger("color"));
	}

	public static class SoundEntry
	{
		private final String dir, name, categorie;
		private final int color;

		public SoundEntry(String dir, String name, String categorie, int color)
		{
			this.dir = dir;
			this.name = name;
			this.categorie = categorie;
			this.color = color;
		}

		public String getDir()
		{
			return dir;
		}

		public String getName()
		{
			return name;
		}

		public String getCategorie()
		{
			return categorie;
		}

		public int getColor()
		{
			return color;
		}
	}
}