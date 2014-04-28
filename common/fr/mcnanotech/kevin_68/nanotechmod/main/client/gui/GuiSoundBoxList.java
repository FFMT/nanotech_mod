package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxList
{
	private ArrayList<ButtonEntry[]> arrList = new ArrayList();
	private int xS, yS, xE, yE, currentPageDiplayed, height, heightWithoutButton, numberOfLine, numberOfPage, width;
	private GuiButton next, prev;
	private ArrayList<BaseNTMEntry> listCateg;
	private GuiSoundBoxListBase gui;
	private GuiButtonList lastSelected;

	public GuiSoundBoxList(GuiSoundBoxListBase gui, ArrayList<BaseNTMEntry> list, int xStart, int yStart, int xEnd, int yEnd)
	{
		this.gui = gui;
		listCateg = list;
		xS = xStart;
		yS = yStart;
		xE = xEnd;
		yE = yEnd;

		height = yEnd - yStart;
		heightWithoutButton = height - 22;
		numberOfLine = (heightWithoutButton - (heightWithoutButton % 15)) / 15;
		width = xEnd - xStart;

		int l = 0;
		int currentPage = 0;
		ButtonEntry[] entry = new ButtonEntry[numberOfLine + 1];

		for(int k = 0; k < list.size(); k++)
		{
			if(l < numberOfLine)
			{
				entry[l] = new ButtonEntry(k + 4, list.get(k).getName(), xStart, yStart + (15 * l), (width / 2) - 2, 14, xStart + 2 + (width / 2));
				l++;
			}
			else
			{
				arrList.add(currentPage, entry);
				entry = new ButtonEntry[numberOfLine];
				currentPage++;
				l = 0;
				entry[l] = new ButtonEntry(k + 4, list.get(k).getName(), xStart, yStart + (15 * l), (width / 2) - 2, 14, xStart + 2 + (width / 2));
				l++;
			}

			if(k == list.size() - 1)
			{
				arrList.add(currentPage, entry);
			}
		}

		numberOfPage = arrList.size() - 1;
	}

	protected void actionPerformed(GuiButton guibutton, List buttonList)
	{
		switch(guibutton.id)
		{
		case 2:
		{
			if(this.currentPageDiplayed != this.numberOfPage)
			{
				this.currentPageDiplayed += 1;
			}
			this.updatePage();
			this.updateList(buttonList);
			break;
		}
		case 3:
		{
			if(this.currentPageDiplayed != 0)
			{
				this.currentPageDiplayed += -1;
			}
			this.updatePage();
			this.updateList(buttonList);
			break;
		}
		default:
		{
			if(lastSelected != null)
			{
				lastSelected.selected = false;
			}
			gui.setSelected(listCateg.get(guibutton.id - 4));
			if(guibutton instanceof GuiButtonList)
			{
				GuiButtonList button = (GuiButtonList)guibutton;
				this.lastSelected = button;
				button.selected = true;
			}
		}
		}
	}

	public void drawScreen(int x, int y)
	{
		FFMTGuiHelper.drawCenteredString(Minecraft.getMinecraft().fontRenderer, (currentPageDiplayed + 1) + "/" + (numberOfPage + 1), x + (width / 2) + 6, y + (height) + 5, FFMTColor.GRAY);
	}

	public void addButton(List buttonList)
	{
		buttonList.add(2, next = new GuiButton(2, xE - 20, yE - 20, 20, 20, ">"));
		buttonList.add(3, prev = new GuiButton(3, xS, yE - 20, 20, 20, "<"));
		this.updatePage();
		this.updateList(buttonList);
	}

	public void updatePage()
	{
		if(this.currentPageDiplayed == 0)
		{
			this.prev.enabled = false;
			if(this.numberOfPage < 2)
			{
				this.next.enabled = false;
			}
			else
			{
				this.next.enabled = true;
			}
		}
		else
		{
			this.prev.enabled = true;
			if(this.currentPageDiplayed == this.numberOfPage)
			{
				this.next.enabled = false;
			}
			else
			{
				this.next.enabled = true;
			}
		}
	}

	public void updateList(List buttonList)
	{
		ButtonEntry[] entryLeft = this.arrList.get(this.currentPageDiplayed);
		this.clearList(buttonList);
		for(int i = 0; i < entryLeft.length; i++)
		{
			if(entryLeft[i] != null)
			{
				buttonList.add(new GuiButtonList(entryLeft[i], false));
			}
		}

		if(this.currentPageDiplayed < this.numberOfPage)
		{
			ButtonEntry[] entryRight = this.arrList.get(this.currentPageDiplayed + 1);
			for(int j = 0; j < entryRight.length; j++)
			{
				if(entryRight[j] != null)
				{
					buttonList.add(new GuiButtonList(entryRight[j], true));
				}
			}
		}

		if(this.lastSelected != null)
		{
			for(int k = 0; k < buttonList.size(); k++)
			{
				if(buttonList.get(k) instanceof GuiButtonList)
				{
					GuiButtonList button = (GuiButtonList)buttonList.get(k);
					if(button.entry.getName() == lastSelected.entry.getName() && button.entry.x == lastSelected.entry.x && button.entry.xR == lastSelected.entry.xR && button.entry.y == lastSelected.entry.y)
					{
						button.selected = true;
						this.lastSelected = button;
					}
				}
			}
		}
	}

	public void clearList(List buttonList)
	{
		ArrayList keepList = new ArrayList();
		for(int i = 0; i < 4; i++)
		{
			keepList.add(i, buttonList.get(i));
		}
		buttonList.clear();
		for(int i = 0; i < 4; i++)
		{
			buttonList.add(i, keepList.get(i));
		}
	}

	public class ButtonEntry extends BaseNTMEntry
	{
		public int id, x, y, width, height, xR;

		public ButtonEntry(int id, String name, int x, int y, int width, int height, int xR)
		{
			super(name);
			this.id = id;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.xR = xR;
		}
	}

	public class GuiButtonList extends GuiButton
	{
	    private final ResourceLocation texture = new ResourceLocation(NanotechMod.MODID.toLowerCase(), "textures/gui/icons.png");

		public boolean selected;
		public ButtonEntry entry;

		public GuiButtonList(ButtonEntry entry, boolean isRight)
		{
			super(entry.id, isRight ? entry.xR : entry.x, entry.y, entry.width, entry.height, entry.getName());
			this.entry = entry;
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY)
		{
			if(this.visible)
			{
				FontRenderer fontrenderer = mc.fontRenderer;
				mc.getTextureManager().bindTexture(texture);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.field_146123_n = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				int k = this.getHoverState(this.field_146123_n);
				GL11.glEnable(GL11.GL_BLEND);
				OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 2 + k * 14, this.width / 2, this.height);
				this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 2 + k * 14, this.width / 2, this.height);
				this.mouseDragged(mc, mouseX, mouseY);
				int l = 14737632;

				if(packedFGColour != 0)
				{
					l = packedFGColour;
				}
				else if(this.selected)
				{
					l = FFMTColor.GREEN;
				}
				else if(this.field_146123_n)
				{
					l = 16777120;
				}

				this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
			}
		}

	}
}