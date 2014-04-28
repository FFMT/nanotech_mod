package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiSoundBoxConfirm.YesAction;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.SoundEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxEditSound extends GuiContainer implements YesAction
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	public SoundEntry entry;

	public GuiSoundBoxEditSound(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, SoundEntry entry)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.entry = entry;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
		this.buttonList.add(new GuiButton(1, x + 91, y + 117, 78, 20, "Apply"));
		this.buttonList.add(new GuiButton(2, x + 10, y + 20, 156, 20, "Name: " + entry.getName()));
		this.buttonList.add(new GuiButton(3, x + 10, y + 44, 156, 20, "Directory: " + entry.getDir()));
		this.buttonList.add(new GuiButton(4, x + 10, y + 68, 156, 20, "Categories: " + entry.getCategory().getName()));
		this.buttonList.add(new GuiButton(5, x + 10, y + 92, 156, 20, EnumChatFormatting.RED + "Delete"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAllSound(inv, tile, wrld));
			break;
		}
		case 1:
		{
			UtilSoundBox.deleteSound(UtilSoundBox.getPlyN(this.mc), entry.getId());
			UtilSoundBox.setSound(this.mc.thePlayer.getCommandSenderName(), entry.getId(), entry.getDir(), entry.getName(), entry.getCategory(), entry.getColor());
			this.mc.displayGuiScreen(new GuiSoundBoxAllSound(inv, tile, wrld));
			break;
		}
		case 2:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAddSound1(inv, tile, wrld, true, this));
			break;
		}
		case 3:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAddSound2(inv, tile, wrld, "", new int[] {0, 0, 0}, true, this));
			break;
		}
		case 5:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxConfirm(inv, tile, wrld, this, "Are you sure?"));
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString("Sound box" + " - " + "Edit sound", 6, 6, 4210752);
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
	public void handleYesAction()
	{
		UtilSoundBox.deleteSound(UtilSoundBox.getPlyN(this.mc), entry.getId());
		if(UtilSoundBox.getSoundsList(UtilSoundBox.getPlyN(this.mc)).isEmpty())
		{
			this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
		}
		else
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAllSound(inv, tile, wrld));
		}
	}
}