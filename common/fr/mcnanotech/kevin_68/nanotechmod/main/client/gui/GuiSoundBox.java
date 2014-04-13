package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBox extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;

	public GuiSoundBox(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
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
		this.buttonList.add(new GuiButton(0, x + 10, y + 20, 156, 20, "All sounds"));
		this.buttonList.add(new GuiButton(1, x + 10, y + 44, 156, 20, "Categories"));
		this.buttonList.add(new GuiButton(2, x + 10, y + 68, 156, 20, "Add sound"));
		this.buttonList.add(new GuiButton(3, x + 10, y + 92, 156, 20, "Add category"));
		this.buttonList.add(new GuiButton(4, x + 30, y + 116, 116, 20, "Stop sound"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 2:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAddSound1(inv, tile, wrld));
			break;
		}
		case 3:
		{
			UtilSoundBox.setCategory(UtilSoundBox.getPlyN(mc), UtilSoundBox.getNextId(UtilSoundBox.getPlyN(mc), true), "test", 0);
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString("Sound box", 6, 6, 4210752);
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