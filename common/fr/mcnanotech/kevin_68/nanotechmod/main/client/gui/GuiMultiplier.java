/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;

public class GuiMultiplier extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/gui/multiplier.png");
	private TileEntityMultiplier tileMultiplier;

	public GuiMultiplier(InventoryPlayer inventoryPlayer, TileEntityMultiplier tileEntity, World world)
	{
		super(new ContainerMultiplier(tileEntity, inventoryPlayer, world));
		this.tileMultiplier = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString(tileMultiplier.hasCustomInventoryName() ? tileMultiplier.getCustomName() : I18n.format(tileMultiplier.getInventoryName()), 8, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.input"), 50, 20, 4210752);
		fontRendererObj.drawString(I18n.format("container.output"), 100, 20, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}