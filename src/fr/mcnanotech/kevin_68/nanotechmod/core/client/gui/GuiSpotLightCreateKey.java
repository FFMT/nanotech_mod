/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightCreateKey extends GuiContainerSliderBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlightkey.png");

	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;

	public GuiSpotLightCreateKey(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, world));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		this.world = world;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiSliderForContainer(this, 0, x + 3, y + 10, 170, 20, I18n.format("container.spotlight.time") + ": 0.0", 0));
		this.buttonList.add(new GuiButton(1, x + 13, y + 115, 150, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(2, x + 13, y + 90, 150, 20, I18n.format("container.spotlight.createkey")));
		PacketSender.sendSpotLightPacket(this.tileSpotLight, 37, 0);
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
		}
		if(guibutton.id == 2)
		{
			if(tileSpotLight.getKey(tileSpotLight.getCreateKeyTime()) != null)
			{
				this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.format("container.spotlight.sure") + " " + I18n.format("container.spotlight.overwrite"), I18n.format("container.spotlight.overwrite"), I18n.format("container.spotlight.cancel"), 1));
			}
			else
			{
				this.createKey(tileSpotLight.getCreateKeyTime());
			}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		if(sliderId == 0)
		{
			System.out.println("clic !");
			PacketSender.sendSpotLightPacket(this.tileSpotLight, 37, (int)(sliderValue * 120));
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		if(sliderId == 0)
		{
			name = I18n.format("container.spotlight.time") + ": " + (float)(((int)((float)(sliderValue * 120))) / 2.0F);
		}
		return name;
	}

	public void createKey(int time)
	{
		SpotLightEntry entry = new SpotLightEntry(tileSpotLight.getRed(), tileSpotLight.getGreen(), tileSpotLight.getBlue(), tileSpotLight.getSecRed(), tileSpotLight.getGreen(), tileSpotLight.getBlue(), tileSpotLight.getAngle1(), tileSpotLight.getAngle2(), tileSpotLight.isAutoRotate(), tileSpotLight.isReverseRotation(), tileSpotLight.getRotationSpeed(), tileSpotLight.isSecondaryLaser());
		PacketSender.sendSpotLightPacket(tileSpotLight, time, entry);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}