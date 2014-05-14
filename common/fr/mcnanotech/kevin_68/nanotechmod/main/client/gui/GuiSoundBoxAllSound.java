package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.SoundEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;

public class GuiSoundBoxAllSound extends GuiSoundBoxListBase
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;

	private GuiButton playButton;
	private ArrayList<BaseNTMEntry> sndList = UtilSoundBox.getSoundsList(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
	private GuiSoundBoxList sBList;
	private SoundEntry snd;
	private boolean editMode;

	public GuiSoundBoxAllSound(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world)
	{
		super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(0, new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
		this.buttonList.add(1, playButton = new GuiButton(1, x + 91, y + 117, 78, 20, "Play"));
		playButton.enabled = false;
		sBList = new GuiSoundBoxList(this, sndList, x + 6, y + 17, x + 169, y + 115);
		sBList.addButton(buttonList);
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			break;
		}
		case 1:
		{
			if(editMode)
			{
				this.mc.displayGuiScreen(new GuiSoundBoxEditSound(inv, tile, wrld, snd, 0));
			}
			else
			{
				this.tile.playSound(snd.getDir());
			}
			break;
		}
		default:
		{
			sBList.actionPerformed(guibutton, this.buttonList);
		}
		}
	}

	@Override
	public void setSelected(BaseNTMEntry entry)
	{
		if(entry instanceof SoundEntry)
		{
			SoundEntry ent = (SoundEntry)entry;
			if(snd != null && snd == ent)
			{
				editMode = true;
			}
			else
			{
				editMode = false;
			}

			this.snd = ent;
			this.updateButton(editMode);
			this.playButton.enabled = true;
		}
	}

	public void updateButton(boolean edit)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.set(1, playButton = new GuiButton(1, x + 91, y + 117, 78, 20, edit ? "Edit" : "Play"));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		GuiHelper.bindTexture("nanotechmod", "textures/gui/soundbox.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
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
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString("Sound box" + " - " + "All sounds", 6, 6, 4210752);
	}
}