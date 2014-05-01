package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxConfirm extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	private GuiContainer gui;
	private String txt;

	public GuiSoundBoxConfirm(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, GuiContainer gui, String txt)
	{
		super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.gui = gui;
		this.txt = txt;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(0, x + 6, y + 92, 78, 20, "No"));
		this.buttonList.add(new GuiButton(1, x + 91, y + 92, 78, 20, "Yes"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(gui);
			break;
		}
		case 1:
		{
			if(gui instanceof YesAction)
			{
				YesAction action = (YesAction)gui;
				action.handleYesAction();
			}
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString("Sound box" + " - " + "Edit sound", 6, 6, 4210752);
		FFMTGuiHelper.drawCenteredLocalizedString(this.mc.fontRenderer, txt, 83, 50, FFMTColor.RED);
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

	public static interface YesAction
	{
		void handleYesAction();
	}
}