/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

@SuppressWarnings({"unchecked", "unused"})
public class GuiSmoker extends FFMTGuiContainerSliderBase
{
	private TileEntitySmoker tileSmoker;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/gui/smoker.png");

	public GuiSmoker(InventoryPlayer playerinventory, TileEntitySmoker tileentity, World world)
	{
		super(new ContainerSmoker(tileentity, playerinventory, world));
		tileSmoker = tileentity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x - 75, y + 20, I18n.format("container.smoker.power", tileSmoker.getSmokeValue()), (float)(tileSmoker.getSmokeValue()) / 15.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		NTMPacketHelper.sendPacket(tileSmoker, (int)(sliderValue * 15));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return I18n.format("container.smoker.power", +(int)(sliderValue * 15));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString(I18n.format("container.smoker"), 6, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory"), 6, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}