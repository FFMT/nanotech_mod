package fr.mcnanotech.kevin_68.nanotech_mod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityMultiplier;

public class GuiMultiplier extends GuiContainer
{
	public GuiMultiplier(InventoryPlayer inventoryPlayer, TileEntityMultiplier tileEntity, World world)
	{
		super(new ContainerMultiplier(tileEntity, inventoryPlayer, world));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString("Multiplier", 8, 6, 4210752);
		fontRenderer.drawString("1.Place Items", 70, 10, 4210752);
		fontRenderer.drawString("2.Shift", 130, 55, 4210752);
		fontRenderer.drawString("click", 130, 70, 4210752);
		fontRenderer.drawString("3.Take", 70, 70, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/Nanotech_mod/textures/gui/Multiplier.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}