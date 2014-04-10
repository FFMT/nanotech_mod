package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import org.lwjgl.opengl.GL11;

import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiDropDown extends Gui
{
	private Map<String, ListElement> data = new TreeMap<String, ListElement>();

	private final Minecraft mc;
	private int xPos, yPos, width, height, maxHeight;

	private String dropDownName = null;
	private String selectedOption = null;
	private String hoverOption = null;

	private final int stringLenght;

	private boolean isOpen = false;
	public boolean drawList = true;
	public boolean enabled = true;

	public GuiDropDown(Minecraft minecraft, int x, int y, int maxHeight, int width)
	{
		this.mc = minecraft;
		this.xPos = x;
		this.yPos = y;
		this.width = width >= 20 ? width : 20;
		this.height = 12;
		this.stringLenght = this.width - 14;
		this.maxHeight = maxHeight;
	}

	public GuiDropDown setDropDownMenuName(String name)
	{
		this.dropDownName = name;
		return this;
	}

	public void addDefaultOption(Object value)
	{
		this.addDefaultOption(String.valueOf(value), value);
	}

	public void addDefaultOption(String name, Object value)
	{
		this.addOption(name, value);

		try
		{
			this.setOptionDefault(String.valueOf(name));
		}
		catch(OptionNotFoundExeption e)
		{}
	}

	public void addOption(Object value)
	{
		this.addOption(String.valueOf(value), value);
	}

	public void addOption(String name, Object value)
	{
		this.data.put(name, new ListElement(this.data.size(), value, name));
	}

	private void setOptionDefault(String name) throws OptionNotFoundExeption
	{
		if(!this.data.containsKey(name))
		{
			throw new OptionNotFoundExeption(name);
		}

		this.selectedOption = name;
	}

	public void clearList()
	{
		this.data.clear();
		this.isOpen = false;
		this.selectedOption = null;
	}

	public ListElement getSelectedOption()
	{
		return this.data.containsKey(this.selectedOption) ? this.data.get(this.selectedOption) : new ListElement(-1, -1, "");
	}

	public void drawScreen(int mouseX, int mouseY, float partialTick)
	{
		if(this.data.isEmpty())
		{
			this.enabled = false;
		}

		if(this.drawList)
		{
			boolean isHover = mouseX >= this.xPos && mouseX < this.xPos + this.width && mouseY >= this.yPos && mouseY < this.yPos + this.height;

			this.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
			this.drawRect(this.xPos, this.yPos, this.xPos + this.width - 13, this.yPos + this.height, -16777216);

			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			FFMTGuiHelper.bindTexture("textures/gui/widgets.png");
			this.drawTexturedModalRect(this.xPos + this.width - 12, this.yPos, 0, this.enabled ? isHover ? 86 : 66 : 46, 6, 6);
			this.drawTexturedModalRect(this.xPos + this.width - 6, this.yPos, 194, this.enabled ? isHover ? 86 : 66 : 46, 6, 6);
			this.drawTexturedModalRect(this.xPos + this.width - 12, this.yPos + 6, 0, this.enabled ? isHover ? 100 : 80 : 60, 6, 6);
			this.drawTexturedModalRect(this.xPos + this.width - 6, this.yPos + 6, 194, this.enabled ? isHover ? 100 : 80 : 60, 6, 6);

			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			this.drawCenteredString(this.mc.fontRenderer, this.isOpen ? "<" : ">", this.xPos + this.width - 6, this.yPos + this.height / 8, 0xffffffff);
			GL11.glPopMatrix();

			if(this.isOpen)
			{
				ArrayList<String> entrySet = this.getDataKey();

				int unrollLenght = entrySet.size() * this.height;

				this.drawRect(this.xPos - 1, this.yPos + this.height, this.xPos + this.width + 1, this.yPos + this.height + unrollLenght + 1, -6250336);
				this.drawRect(this.xPos, this.yPos + this.height + 1, this.xPos + this.width, this.yPos + this.height + unrollLenght, -16777216);

				boolean isHoverList = mouseX >= this.xPos && mouseX < this.xPos + this.width && mouseY >= this.yPos + this.height && mouseY < this.yPos + this.height + unrollLenght + 1;

				for(int index = 0; index < entrySet.size(); index++)
				{
					String optionDisplayString = entrySet.get(index);
					int xPosition = this.xPos;
					int yPosition = this.yPos + this.height + (this.height / 8) + (index * 12);

					boolean isHoverOption = mouseX >= xPosition && mouseX < xPosition + width && mouseY >= yPosition && mouseY < yPosition + 12;
					this.hoverOption = isHoverOption ? String.valueOf(optionDisplayString) : null;

					if(this.hoverOption != null && this.hoverOption.equals(optionDisplayString))
					{
						this.drawRect(xPosition, yPosition, xPosition + this.width, yPosition + 11, 0xffffffff);
						this.mc.fontRenderer.drawString(this.mc.fontRenderer.trimStringToWidth(optionDisplayString, this.width - 2), xPosition + 2, yPosition + (11 / 8), 0);
					}
					else
					{
						this.mc.fontRenderer.drawString(this.mc.fontRenderer.trimStringToWidth(optionDisplayString, this.width - 2), xPosition + 2, yPosition + (11 / 8), 0xffffffff);

						if(!isHoverList)
						{
							if(this.selectedOption != null && this.selectedOption.equals(optionDisplayString))
							{
								this.drawRect(xPosition, yPosition, xPosition + this.width, yPosition + 11, 0xffffffff);
								this.mc.fontRenderer.drawString(this.mc.fontRenderer.trimStringToWidth(optionDisplayString, this.width - 2), xPosition + 2, yPosition + (11 / 8), 0);
							}
						}
					}
				}
			}

			if(this.isAnyOptionSelected())
			{
				String selectedOptionName = this.mc.fontRenderer.trimStringToWidth(this.selectedOption, stringLenght);
				this.drawString(this.mc.fontRenderer, selectedOptionName, this.xPos + 2, this.yPos + this.height / 8, 0xffffffff);
			}

			if(this.dropDownName != null)
			{
				this.drawString(this.mc.fontRenderer, this.dropDownName + " :", this.xPos, this.yPos - 11, 0xffffffff);
			}
		}
	}

	public void mouseClicked(int mouseX, int mouseY, int button)
	{
		if(this.enabled)
		{
			boolean isHoverComponent = this.isOpen ? mouseX >= this.xPos - 1 && mouseX < this.xPos + this.width + 1 && mouseY >= this.yPos - 1 && mouseY < this.yPos + this.height + (this.getDataKey().size() * 12) - 1 : mouseX >= this.xPos - 1 && mouseX < this.xPos + this.width + 1 && mouseY >= this.yPos - 1 && mouseY < this.yPos + this.height + 1;

			if(!isHoverComponent)
			{
				this.isOpen = false;
			}
			else
			{
				boolean isHover = mouseX >= this.xPos && mouseX < this.xPos + this.width && mouseY >= this.yPos && mouseY < this.yPos + this.height;

				if(isHover && !this.data.isEmpty())
				{
					this.isOpen = !this.isOpen;
				}

				if(this.isOpen)
				{
					ArrayList<String> entrySet = this.getDataKey();

					for(int index = 0; index < entrySet.size(); index++)
					{
						int xPosition = this.xPos;
						int yPosition = this.yPos + this.height + (this.height / 8) + (index * 12);

						boolean isHoverOption = mouseX >= xPosition && mouseX < xPosition + width && mouseY >= yPosition && mouseY < yPosition + 12;

						if(isHoverOption)
						{
							this.selectedOption = entrySet.get(index);
							this.isOpen = false;
						}
					}
				}
			}
		}
	}

	public boolean isAnyOptionSelected()
	{
		return this.selectedOption != null;
	}

	private ArrayList<String> getDataKey()
	{
		return new ArrayList(this.data.keySet());
	}

	public class OptionNotFoundExeption extends Throwable
	{
		public OptionNotFoundExeption(String optionName)
		{
			super("No option found for name: '" + optionName + "' !");
		}
	}

	public class ListElement
	{
		private final int optionIndex;
		private final Object optionValue;
		private final String optionName;

		public ListElement(int optionI, Object optionV, String optionN)
		{
			this.optionIndex = optionI;
			this.optionValue = optionV;
			this.optionName = optionN;
		}

		public Object getOptionValue()
		{
			return this.optionValue;
		}

		public int getOptionIndex()
		{
			return this.optionIndex;
		}

		public String getOptionName()
		{
			return this.optionName;
		}
	}
}
