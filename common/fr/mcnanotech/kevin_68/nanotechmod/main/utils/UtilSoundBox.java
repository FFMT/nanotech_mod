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

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;

public class UtilSoundBox
{
	private static final File mcDir = Minecraft.getMinecraft().mcDataDir;
	private static final File mainDir = new File(new File(mcDir, "nanotechmod"), "jukebox");
	private static File dataFile = new File(mainDir, "sounds.dat");

	public static void init()
	{
		if(!mainDir.exists())
		{
			mainDir.mkdirs();
		}
	}

	@SideOnly(Side.CLIENT)
	public static String getPlyN(Minecraft mc)
	{
		return mc.thePlayer.getCommandSenderName();
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

	public static void setSound(String player, int id, String dir, String name, CategoryEntry category, int color)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagCompound compound = compoundBase.hasKey("sounds") ? compoundBase.getCompoundTag("sounds") : new NBTTagCompound();
		NBTTagList playerList = compound.hasKey(player) ? compound.getTagList(player, Constants.NBT.TAG_COMPOUND) : new NBTTagList();
		NBTTagCompound playerTag = playerList.tagCount() > id ? playerList.getCompoundTagAt(id) : new NBTTagCompound();
		playerTag.setString("dir", dir);
		playerTag.setString("name", name);
		playerTag.setInteger("categoryId", category.getId());
		playerTag.setInteger("color", color);
		playerList.appendTag(playerTag);
		compound.setTag(player, playerList);
		compoundBase.setTag("sounds", compound);
		saveData(compoundBase);
	}

	public static SoundEntry getSound(String player, int id)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
		NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
		NBTTagCompound playerTag = playerList.getCompoundTagAt(id);
		return new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getInteger("categorie"), playerTag.getInteger("color"));
	}
	
	public static ArrayList<BaseNTMEntry> getSoundsList(String player)
	{
		ArrayList<BaseNTMEntry> list = new ArrayList();
		NBTTagCompound compoundBase = getData();
		NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
		NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < playerList.tagCount(); i++)
		{
			NBTTagCompound playerTag = playerList.getCompoundTagAt(i);
			list.add(i, new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getInteger("categorie"), playerTag.getInteger("color")));
		}
		return list;
	}

	public static void setCategory(String player, int id, String name, int color)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagList compound = compoundBase.hasKey("categories") ? compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND) : new NBTTagList();
		NBTTagCompound category = compound.tagCount() > id ? compound.getCompoundTagAt(id) : new NBTTagCompound();
		category.setString("owner", player);
		category.setString("name", name);
		category.setInteger("color", color);
		compound.appendTag(category);
		compoundBase.setTag("categories", compound);
		saveData(compoundBase);
	}

	public static CategoryEntry getCategory(int id)
	{
		NBTTagCompound compoundBase = getData();
		NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
		NBTTagCompound category = compound.getCompoundTagAt(id);

		return new CategoryEntry(category.getString("name"), category.getString("owner"), category.getInteger("color"), id);
	}
	
	public static ArrayList<BaseNTMEntry> getCategoryList()
	{
		ArrayList<BaseNTMEntry> list = new ArrayList();
		NBTTagCompound compoundBase = getData();
		NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < compound.tagCount(); i++)
		{
			NBTTagCompound category = compound.getCompoundTagAt(i);
			list.add(i, new CategoryEntry(category.getString("name"), category.getString("owner"), category.getInteger("color"), i));
		}
		return list;
	}

	public static int getNextId(String player, boolean isCategory)
	{
		NBTTagCompound compoundBase = getData();
		if(!isCategory)
		{
			if(compoundBase.hasKey("sounds"))
			{
				NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
				NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
				return playerList.tagCount();
			}
			else
			{
				return 0;
			}
		}
		else
		{
			if(compoundBase.hasKey("categories"))
			{
				NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
				return compound.tagCount();
			}
			else
			{
				return 0;
			}
		}
	}

	public static class SoundEntry extends BaseNTMEntry
	{
		private final String dir;
		private final int color, categoryId;

		public SoundEntry(String dir, String name, int categoryId, int color)
		{
			super(name);
			this.dir = dir;
			this.categoryId = categoryId;
			this.color = color;
		}

		public String getDir()
		{
			return dir;
		}

		public CategoryEntry getCategory()
		{
			return UtilSoundBox.getCategory(categoryId);
		}

		public int getColor()
		{
			return color;
		}
	}

	public static class CategoryEntry extends BaseNTMEntry
	{
		private final String owner;
		private final int color, id;

		public CategoryEntry(String name, String owner, int color, int id)
		{
			super(name);
			this.owner = owner;
			this.color = color;
			this.id = id;
		}

		public String getOwner()
		{
			return owner;
		}

		public int getColor()
		{
			return color;
		}

		public int getId()
		{
			return id;
		}
	}
}