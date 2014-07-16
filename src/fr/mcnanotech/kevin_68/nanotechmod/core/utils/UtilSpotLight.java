package fr.mcnanotech.kevin_68.nanotechmod.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class UtilSpotLight
{
	private static File mcDir;
	private static File mainDir;
	private static File dataFile;

	public static void init()
	{
		mcDir = Minecraft.getMinecraft().mcDataDir;
		mainDir = new File(new File(mcDir, "nanotechmod"), "spotlight");
		if(!mainDir.exists())
		{
			mainDir.mkdirs();
		}
		dataFile = new File(mainDir, "textures.dat");
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
			setSound("beacon_beam", "textures/entity/beacon_beam.png");
			setSound("dirt", "textures/blocks/dirt.png");
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

	public static void setSound(String name, String path)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagList list = compoundBase.hasKey("textures") ? compoundBase.getTagList("textures", Constants.NBT.TAG_COMPOUND) : new NBTTagList();
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("name", name);
		tag.setString("path", path);
		list.appendTag(tag);
		compoundBase.setTag("textures", list);
		saveData(compoundBase);
	}

	public static void deleteTexure(String name)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagList list = compoundBase.getTagList("textures", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < list.tagCount(); i++)
		{
			if(list.getCompoundTagAt(i).getString("name").equals(name))
			{
				list.removeTag(i);
			}
		}
		saveData(compoundBase);
	}

	public static ArrayList<BaseListEntry> list()
	{
		ArrayList<BaseListEntry> list = new ArrayList();
		
		NBTTagCompound compoundBase = getData();
		NBTTagList tagList = compoundBase.getTagList("textures", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			list.add(new TextureEntry(tag.getString("name"), tag.getString("path")));
		}

		return list;
	}

	public static TextureEntry getEntryByName(String name)
	{
		for(int i = 0; i < list().size(); i++)
		{
			if(list().get(i).name.equals(name))
			{
				return (TextureEntry)list().get(i);
			}
		}

		return new TextureEntry("beacon_beam", "textures/entity/beacon_beam.png");
	}

	public static class BaseListEntry
	{
		private String name;
		private int txtColor;

		public BaseListEntry(String name, int txtColor)
		{
			this.name = name;
			this.txtColor = txtColor;
		}

		public String getName()
		{
			return name;
		}

		public int getTxtColor()
		{
			return txtColor;
		}
	}

	public static class TextureEntry extends BaseListEntry
	{
		private String path;

		public TextureEntry(String name, String path)
		{
			super(name, 0xffffff);
			this.path = path;
		}

		public String getPath()
		{
			return path;
		}
	}
}
