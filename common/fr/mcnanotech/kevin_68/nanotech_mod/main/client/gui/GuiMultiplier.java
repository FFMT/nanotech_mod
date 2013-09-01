package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;

public class GuiMultiplier extends GuiContainer
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/Multiplier.png");

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
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.func_110577_a(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}