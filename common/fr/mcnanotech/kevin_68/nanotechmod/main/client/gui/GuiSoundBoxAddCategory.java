package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiSliderForContainer;

public class GuiSoundBoxAddCategory extends FFMTGuiContainerSliderBase
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	public GuiTextField nameField;
	private String name;
	private int[] color = new int[] {255, 255, 255};
	private boolean editMode;
	private GuiSoundBoxEditCategory gui;
	private GuiButton nextButton;

	public GuiSoundBoxAddCategory(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, boolean editMode, GuiSoundBoxEditCategory gui)
	{
		super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.editMode = editMode;
		this.gui = gui;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		name = editMode ? gui.entry.getName() : "";
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		Keyboard.enableRepeatEvents(true);
		this.nameField = new GuiTextField(this.fontRendererObj, x + 6, y + 20, 160, 12);
		this.nameField.setTextColor((color[0] * 65536) + (color[1] * 256) + color[2]);
		this.nameField.setDisabledTextColour(-1);
		this.nameField.setEnableBackgroundDrawing(true);
		this.nameField.setMaxStringLength(40);
		this.nameField.setEnabled(true);
		this.nameField.setText(name);

		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x + 6, y + 40, 160, 20, EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + ": " + color[0], color[0] / 255));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 1, x + 6, y + 64, 160, 20, EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + ": " + color[1], color[1] / 255));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 2, x + 6, y + 88, 160, 20, EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + ": " + color[2], color[2] / 255));
		this.buttonList.add(new GuiButton(3, x + 6, y + 117, 78, 20, "Cancel"));
		this.buttonList.add(nextButton = new GuiButton(4, x + 91, y + 117, 78, 20, editMode ? "Apply" : "Next"));
		nextButton.enabled = false;
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 3:
		{
			if(editMode)
			{
				this.mc.displayGuiScreen(new GuiSoundBoxEditCategory(inv, tile, wrld, this.gui.entry));
			}
			else
			{
				this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			}
			break;
		}
		case 4:
		{
			if(editMode)
			{
				CategoryEntry entry = new CategoryEntry(this.gui.entry.getName(), this.gui.entry.getOwner(), (color[0] * 65536) + (color[1] * 256) + color[2], this.gui.entry.getId());
				this.mc.displayGuiScreen(new GuiSoundBoxEditCategory(inv, tile, wrld, entry));
			}
			else
			{
				UtilSoundBox.setCategory(UtilSoundBox.getPlyN(this.mc), UtilSoundBox.getNextId(UtilSoundBox.getPlyN(this.mc), true), name, (color[0] * 65536) + (color[1] * 256) + color[2]);
				this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			}
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		if(editMode)
		{
			fontRendererObj.drawString("Sound box" + " - " + "Edit sound name", 6, 6, 4210752);
		}
		else
		{
			fontRendererObj.drawString("Sound box" + " - " + "Add category", 6, 6, 4210752);
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.nameField.drawTextBox();
		if(name == "" && !this.nameField.isFocused())
		{
			this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.fieldName"), x + 83, y + 22, 16777215);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		FFMTGuiHelper.bindTexture("nanotechmod", "textures/gui/soundbox.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		color[sliderId] = (int)(sliderValue * 255);
		this.nameField.setTextColor((color[0] * 65536) + (color[1] * 256) + color[2]);
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		switch(sliderId)
		{
		case 0:
		{
			return EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + ": " + color[0];
		}
		case 1:
		{
			return EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + ": " + color[1];
		}
		case 2:
		{
			return EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + ": " + color[2];
		}
		default:
		{
			return null;
		}
		}
	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen()
	{
		if(name.length() > 1)
		{
			nextButton.enabled = true;
		}
		else
		{
			nextButton.enabled = false;
		}
	}

	protected void keyTyped(char par1, int par2)
	{
		if(this.nameField.textboxKeyTyped(par1, par2))
		{
			name = this.nameField.getText();
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.nameField.mouseClicked(par1, par2, par3);
	}
}