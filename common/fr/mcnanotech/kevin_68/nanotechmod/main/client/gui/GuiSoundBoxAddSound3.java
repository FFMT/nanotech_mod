package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiSoundBoxList.GuiButtonList;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.SoundEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxAddSound3 extends GuiSoundBoxListBase
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	private String name, dir;
	private CategoryEntry categ;
	private int[] color;
	private boolean editMode;
	private GuiSoundBoxEditSound gui;
	private GuiButton nextButton;
	private ArrayList<BaseNTMEntry> categList = UtilSoundBox.getCategoryList();
	private GuiSoundBoxList sBList;

	public GuiSoundBoxAddSound3(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, String name, int[] color, String dir, boolean editMode, GuiSoundBoxEditSound gui)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.name = name;
		this.color = color;
		this.dir = dir;
		this.editMode = editMode;
		this.gui = gui;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(0, new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
		this.buttonList.add(1, nextButton = new GuiButton(1, x + 91, y + 117, 78, 20, editMode ? "Apply" : "Next"));
		nextButton.enabled = false;
		sBList = new GuiSoundBoxList(this, categList, x + 6, y + 17, x + 169, y + 115);
		sBList.addButton(buttonList);
		if(editMode)
		{
			this.categ = gui.entry.getCategory();
		}
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			if(editMode)
			{
				this.mc.displayGuiScreen(new GuiSoundBoxEditSound(inv, tile, wrld, this.gui.entry));
			}
			else
			{
				this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			}
			break;
		}
		case 1:
		{
			if(editMode)
			{
				SoundEntry entry = new SoundEntry(this.gui.entry.getDir(), this.gui.entry.getName(), this.categ.getId(), this.gui.entry.getColor(), this.gui.entry.getId());
				this.mc.displayGuiScreen(new GuiSoundBoxEditSound(inv, tile, wrld, entry));
			}
			else
			{
				this.mc.displayGuiScreen(new GuiSoundBoxAddSound4(inv, tile, wrld, name, color, dir, categ));
			}
			break;
		}
		default:
		{
			sBList.actionPerformed(guibutton, this.buttonList);
			break;
		}
		}
	}

	@Override
	public void setSelected(BaseNTMEntry entry)
	{
		if(entry instanceof CategoryEntry)
		{
			this.categ = (CategoryEntry)entry;
			this.nextButton.enabled = true;
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString("Sound box" + " - " + "Add sound step 3", 6, 6, 4210752);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		super.drawScreen(par1, par2, par3);
		this.sBList.drawScreen(x, y);
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
}