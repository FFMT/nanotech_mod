package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.Language;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxList
{
	private ArrayList<BaseNTMEntry> list;
	private int lastSlot;
	private GuiListBase gui;
	private int xPos, yPos, width, height;

	public GuiSoundBoxList(ArrayList<BaseNTMEntry> arrList, GuiListBase gui, int xPos, int yPos, int width, int height)
	{
		this.gui = gui;
		this.list = arrList;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void elementClicked(int slotId, boolean doubleClick, int mouseX, int mouseY)
	{
		gui.handlerListAction(list, slotId, doubleClick, mouseX, mouseY);
		lastSlot = slotId;
	}

	private boolean isSelected(int slotId)
	{
		return lastSlot == slotId;
	}
	
	public void drawScreen(int par1, int par2, float par3)
	{
		if(!list.isEmpty())
		{
			
		}
	}
	
	protected void drawSlot(int slotId, int x, int y, int var4, Tessellator tessellator, int var6, int var7)
	{
		FFMTGuiHelper.drawCenteredString(gui.mc.fontRenderer, this.list.get(slotId).getName(), this.width / 2, y + 1, 16777215);
	}

}