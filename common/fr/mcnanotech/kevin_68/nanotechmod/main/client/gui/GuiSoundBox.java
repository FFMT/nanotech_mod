package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBox extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;

	public GuiSoundBox(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world)
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
		if(UtilSoundBox.getCategoryList().isEmpty())
		{
			UtilSoundBox.setCategory(this.mc.thePlayer.getCommandSenderName(), "NanotechMod_0", "Default", FFMTColor.WHITE);
		}
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(0, x + 10, y + 20, 156, 20, UtilSoundBox.getSoundsList(this.mc.thePlayer.getCommandSenderName()).isEmpty() ? "NoSounds" : "Sounds"));
		this.buttonList.add(new GuiButton(1, x + 10, y + 44, 156, 20, "Categories"));
		this.buttonList.add(new GuiButton(2, x + 10, y + 68, 156, 20, "Add sound"));
		this.buttonList.add(new GuiButton(3, x + 10, y + 92, 156, 20, "Add category"));
		this.buttonList.add(new GuiButton(4, x + 6, y + 117, 78, 20, "Stop sounds"));
		this.buttonList.add(new GuiButton(5, x + 91, y + 117, 78, 20, "Syncronization"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			if(!UtilSoundBox.getSoundsList(this.mc.thePlayer.getCommandSenderName()).isEmpty())
			{
				this.mc.displayGuiScreen(new GuiSoundBoxAllSound(inv, tile, wrld));
			}
			break;
		}
		case 1:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxCategories(inv, tile, wrld));
			break;
		}
		case 2:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAddSound1(inv, tile, wrld, false, null));
			break;
		}
		case 3:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxAddCategory(inv, null, wrld, false, null));
			break;
		}
		case 4:
		{
			if(tile != null)
			{
				tile.stopSounds();
			}
			break;
		}
		case 5:
		{
			this.mc.displayGuiScreen(new GuiSoundBoxSync(inv, tile, wrld));
			break;
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