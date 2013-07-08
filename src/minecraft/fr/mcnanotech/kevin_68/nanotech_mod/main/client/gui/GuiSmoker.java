package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class GuiSmoker extends GuiContainer
{
	protected TileEntitySmoker tilesmoker;

	public GuiSmoker(InventoryPlayer playerinventory, TileEntitySmoker tileentity, World world)
	{
		super(new ContainerSmoker(tileentity, playerinventory, world));
		tilesmoker = tileentity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		buttonList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "+"));
		buttonList.add(new GuiButton(2, x + 75, y + 45, 20, 20, "-"));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 1)
		{
			//tilesmoker.Smokepower ++;
		}
		if (guibutton.id == 2)
		{
			//tilesmoker.Smokepower --;
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString("Smoke Block", 6, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 4210752);
		fontRenderer.drawString(String.valueOf(tilesmoker.Smokepower), x, y, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture("/mods/Nanotech_mod/textures/gui/Blocksmoker.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}