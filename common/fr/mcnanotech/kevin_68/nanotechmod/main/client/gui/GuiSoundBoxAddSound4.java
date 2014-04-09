package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxAddSound4 extends GuiContainer
{

	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	private String name, dir, categ;
	private int[] color;

	public GuiSoundBoxAddSound4(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, String name, int[] color, String dir, String categ)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.name = name;
		this.color = color;
		this.dir = dir;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		categ = "default";
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(3, x + 6, y + 112, 78, 20, "Cancel"));
		this.buttonList.add(new GuiButton(4, x + 88, y + 112, 78, 20, "Create"));
	}
	
	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 3:
		{
			this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			break;
		}
		case 4:
		{
			UtilListerJukebox.addSound(this.mc.thePlayer.getCommandSenderName(), UtilListerJukebox.getNextId(this.mc.thePlayer.getCommandSenderName()), dir, name, categ, (color[0] * 65536) + (color[1] * 256) + color[2]);
			this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
			break;
		}
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString("Sound box" + " - " + "Add sound resume", 6, 6, 4210752);
		
		this.drawCenteredString(fontRendererObj, name, 85, 30,  (color[0] * 65536) + (color[1] * 256) + color[2]);
		this.drawCenteredString(fontRendererObj, dir, 85, 45, FFMTColor.WHITE);
		this.drawCenteredString(fontRendererObj, categ, 85, 60, FFMTColor.WHITE);
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
