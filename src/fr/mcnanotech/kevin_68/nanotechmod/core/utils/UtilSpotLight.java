package fr.mcnanotech.kevin_68.nanotechmod.core.utils;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class UtilSpotLight
{
	public static ArrayList<BaseListEntry> list()
	{
		ArrayList<BaseListEntry> list = new ArrayList();
		list.add(new TextureEntry("beacon_beam", 0, "textures/entity/beacon_beam.png"));
		File dir = new File(new File(new File(Minecraft.getMinecraft().mcDataDir, "assets"),"nanotechmod"), "spotlight");
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		File[] fileList = dir.listFiles();
		if(fileList != null && fileList.length != 0)
		{
			for(int i = 0; i < fileList.length; i++)
			{
				// TODO fix
				String path = fileList[i].getAbsolutePath().replace(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "").replace(File.separator + "assets" + File.separator, "").replace("nanotechmod" + File.separator, "nanotechmod:");
				list.add(i + 1, new TextureEntry(fileList[i].getName(), /*getColor*/0, path));
			}
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

		return new TextureEntry("beacon_beam", 0, "textures/entity/beacon_beam.png");
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

		public TextureEntry(String name, int txtColor, String path)
		{
			super(name, txtColor);
			this.path = path;
		}

		public String getPath()
		{
			return path;
		}
	}
}
