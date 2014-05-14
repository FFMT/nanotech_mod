package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;

public class GuiSoundBoxSync extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;

	public GuiSoundBoxSync(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world)
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
		this.buttonList.add(new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
		this.buttonList.add(new GuiButton(1, x + 91, y + 117, 78, 20, "test"));
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
			ArrayList<BaseNTMEntry> list = UtilSoundBox.getCategoryList();
			for(int i = 0; i < list.size(); i++)
			{
				NTMPacketHelper.sendSoundBoxPacket(true, (CategoryEntry)(list.get(i)));
			}
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString("Sound box" + " - " + "Syncronization", 6, 6, 4210752);
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
}