package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilListerJukebox;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;

@SideOnly(Side.CLIENT)
class GuiSlotMusic extends GuiSlot
{
	private final List listList;
	private final Map mapMap;
	final GuiListerJukebox listerGui;

	public GuiSlotMusic(GuiListerJukebox guiLister)
	{
		super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
		this.listerGui = guiLister;
		this.listList = Lists.newArrayList();
		this.mapMap = Maps.newHashMap();

		for(int i = 0; i != UtilListerJukebox.fileList.length; i++)
		{
			this.mapMap.put(i, UtilListerJukebox.fileList[i]);
			this.listList.add(i);
		}

		this.mapMap.put(mapMap.size() + 1, "nanodisk");
		this.listList.add(listList.size() + 1);

	}

	protected int getSize()
	{
		return this.listList.size();
	}

	protected void elementClicked(int slot, boolean doubleclick)
	{

		if(slot < listList.size() - 1)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.fileList[slot].getName());
		}
		else
		{
			this.listerGui.getTile().playMusic("nanodisk");
		}
	}

	protected int getContentHeight()
	{
		return this.getSize() * 18;
	}

	protected void drawBackground()
	{
		this.listerGui.drawDefaultBackground();
	}

	protected void drawSlot(int slotId, int par2, int par3, int par4, Tessellator tesselator)
	{
		this.listerGui.getFont().setBidiFlag(true);
		int color = 16777215;

		if(this.mapMap.get(this.listList.get(slotId)).toString().equals("nanodisk"))
		{
			color = FFMTColor.aquaInt;
		}
		this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap.get(this.listList.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
	}

	@Override
	protected boolean isSelected(int i)
	{
		return false;
	}
}

@SideOnly(Side.CLIENT)
class GuiSlotMusicPlaylist extends GuiSlot
{
	private final List listList1;
	private final Map mapMap1;
	private final List listList2;
	private final Map mapMap2;
	private final List listList3;
	private final Map mapMap3;
	private final List listList4;
	private final Map mapMap4;
	private final List listList5;
	private final Map mapMap5;
	private final List listList6;
	private final Map mapMap6;
	private int playList;
	final GuiListerJukeboxPlaylists listerGui;

	public GuiSlotMusicPlaylist(GuiListerJukeboxPlaylists guiLister, int playlist)
	{
		super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
		this.listerGui = guiLister;
		playList = playlist;
		this.listList1 = Lists.newArrayList();
		this.mapMap1 = Maps.newHashMap();
		this.listList2 = Lists.newArrayList();
		this.mapMap2 = Maps.newHashMap();
		this.listList3 = Lists.newArrayList();
		this.mapMap3 = Maps.newHashMap();
		this.listList4 = Lists.newArrayList();
		this.mapMap4 = Maps.newHashMap();
		this.listList5 = Lists.newArrayList();
		this.mapMap5 = Maps.newHashMap();
		this.listList6 = Lists.newArrayList();
		this.mapMap6 = Maps.newHashMap();

		for(int i = 0; i != UtilListerJukebox.playlistlist1.length; i++)
		{
			this.mapMap1.put(i, UtilListerJukebox.playlistlist1[i]);
			this.listList1.add(i);
		}
		for(int i = 0; i != UtilListerJukebox.playlistlist2.length; i++)
		{
			this.mapMap2.put(i, UtilListerJukebox.playlistlist2[i]);
			this.listList2.add(i);
		}
		for(int i = 0; i != UtilListerJukebox.playlistlist3.length; i++)
		{
			this.mapMap3.put(i, UtilListerJukebox.playlistlist3[i]);
			this.listList3.add(i);
		}
		for(int i = 0; i != UtilListerJukebox.playlistlist4.length; i++)
		{
			this.mapMap4.put(i, UtilListerJukebox.playlistlist4[i]);
			this.listList4.add(i);
		}
		for(int i = 0; i != UtilListerJukebox.playlistlist5.length; i++)
		{
			this.mapMap5.put(i, UtilListerJukebox.playlistlist5[i]);
			this.listList5.add(i);
		}
		for(int i = 0; i != UtilListerJukebox.playlistlist6.length; i++)
		{
			this.mapMap6.put(i, UtilListerJukebox.playlistlist6[i]);
			this.listList6.add(i);
		}
	}

	protected int getSize()
	{
		if(playList == 1)
		{
			return this.listList1.size();
		}
		else if(playList == 2)
		{
			return this.listList2.size();
		}
		else if(playList == 3)
		{
			return this.listList3.size();
		}
		else if(playList == 4)
		{
			return this.listList4.size();
		}
		else if(playList == 5)
		{
			return this.listList5.size();
		}
		else
		{
			return this.listList6.size();
		}
	}

	protected void elementClicked(int slot, boolean doubleclick)
	{
		if(playList == 1)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist1[slot].getName());
		}
		else if(playList == 2)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist2[slot].getName());
		}
		else if(playList == 3)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist3[slot].getName());
		}
		else if(playList == 4)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist4[slot].getName());
		}
		else if(playList == 5)
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist5[slot].getName());
		}
		else
		{
			this.listerGui.getTile().playMusic(UtilListerJukebox.playlistlist6[slot].getName());
		}
	}

	protected int getContentHeight()
	{
		return this.getSize() * 18;
	}

	protected void drawBackground()
	{
		this.listerGui.drawDefaultBackground();
	}

	protected void drawSlot(int slotId, int par2, int par3, int par4, Tessellator tesselator)
	{
		this.listerGui.getFont().setBidiFlag(true);
		int color = 16777215;

		if(this.playList == 1)
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap1.get(this.listList1.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
		else if(this.playList == 2)
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap2.get(this.listList2.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
		else if(this.playList == 3)
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap3.get(this.listList3.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
		else if(this.playList == 4)
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap4.get(this.listList4.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
		else if(this.playList == 5)
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap5.get(this.listList5.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
		else
		{
			this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap6.get(this.listList6.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.cdDirectoryName + File.separator, ""), this.listerGui.width / 2, par3 + 1, color);
		}
	}

	@Override
	protected boolean isSelected(int i)
	{
		return false;
	}
}