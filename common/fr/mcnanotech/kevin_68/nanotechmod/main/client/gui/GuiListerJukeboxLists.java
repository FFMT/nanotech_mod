package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

@SideOnly(Side.CLIENT)
public class GuiListerJukeboxLists extends GuiSlot
{
	public final List listList;
	public final Map mapMap;
	public static int lastSlotSelected = -1;
	final GuiListerJukeboxModidList listerGuiModList;
	final GuiListerJukeboxCategoryList listerGuiCategoryList;
	final GuiListerJukeboxAllSounds listerGuiAllSounds;

	public GuiListerJukeboxLists(GuiListerJukeboxModidList guiLister, ArrayList<String> arrList)
	{
		super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
		this.listerGuiModList = guiLister;
		this.listerGuiCategoryList = null;
		this.listerGuiAllSounds = null;
		this.listList = Lists.newArrayList();
		this.mapMap = Maps.newHashMap();

		for(int i = 0; i != arrList.size() - 1; i++)
		{
			this.mapMap.put(i, arrList.get(i));
			this.listList.add(i);
		}
	}

	public GuiListerJukeboxLists(GuiListerJukeboxCategoryList guiLister, ArrayList<String> arrList)
	{
		super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
		this.listerGuiModList = null;
		this.listerGuiCategoryList = guiLister;
		this.listerGuiAllSounds = null;
		this.listList = Lists.newArrayList();
		this.mapMap = Maps.newHashMap();

		for(int i = 0; i != arrList.size(); i++)
		{
			this.mapMap.put(i, arrList.get(i));
			this.listList.add(i);
		}
	}
	
	public GuiListerJukeboxLists(GuiListerJukeboxAllSounds guiLister, ArrayList<String> arrList)
	{
		super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
		this.listerGuiModList = null;
		this.listerGuiCategoryList = null;
		this.listerGuiAllSounds = guiLister;
		this.listList = Lists.newArrayList();
		this.mapMap = Maps.newHashMap();

		for(int i = 0; i != arrList.size(); i++)
		{
			this.mapMap.put(i, arrList.get(i));
			this.listList.add(i);
		}
	}

	@Override
	protected int getSize()
	{
		return this.listList.size();
	}

	@Override
	protected boolean isSelected(int slot)
	{
		if(lastSlotSelected == -1)
		{
			return false;
		}
		else
		{
			return slot == lastSlotSelected;
		}
	}

	@Override
	protected void elementClicked(int slot, boolean doubleclick, int var3, int var4)
	{
		lastSlotSelected = slot;
	}

	@Override
	protected int getContentHeight()
	{
		return this.getSize() * 18;
	}

	@Override
	protected void drawBackground()
	{
		if(listerGuiModList != null)
		{
			this.listerGuiModList.drawDefaultBackground();
		}
		else if(listerGuiCategoryList != null)
		{
			this.listerGuiCategoryList.drawDefaultBackground();
		}
		else if(listerGuiAllSounds != null)
		{
			this.listerGuiAllSounds.drawDefaultBackground();
		}
	}

	@Override
	protected void drawSlot(int slotId, int par2, int par3, int par4, Tessellator tesselator, int var6, int var7)
	{
		if(listerGuiModList != null)
		{
			this.listerGuiModList.getFont().setBidiFlag(true);
			this.listerGuiModList.drawCenteredString(this.listerGuiModList.getFont(), (this.mapMap.get(this.listList.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.getMainDir().getName() + File.separator, ""), this.listerGuiModList.width / 2, par3 + 1, 16777215);
		}
		else if(listerGuiCategoryList != null)
		{
			int color = UtilListerJukebox.getCategoryColor().get(slotId);
			this.listerGuiCategoryList.getFont().setBidiFlag(true);
			this.listerGuiCategoryList.drawCenteredString(this.listerGuiCategoryList.getFont(), (this.mapMap.get(this.listList.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.getMainDir().getName() + File.separator, ""), this.listerGuiCategoryList.width / 2, par3 + 1, color);
		}
		else if(listerGuiAllSounds != null)
		{
			int color = UtilListerJukebox.getSoundColor().get(slotId);
			this.listerGuiAllSounds.getFont().setBidiFlag(true);
			this.listerGuiAllSounds.drawCenteredString(this.listerGuiAllSounds.getFont(), (this.mapMap.get(this.listList.get(slotId))).toString().replace(".ogg", "").replace(UtilListerJukebox.getMainDir().getName() + File.separator, ""), this.listerGuiAllSounds.width / 2, par3 + 1, color);
		}
	}

	public static int getSelectedSlot()
	{
		return lastSlotSelected;
	}
}