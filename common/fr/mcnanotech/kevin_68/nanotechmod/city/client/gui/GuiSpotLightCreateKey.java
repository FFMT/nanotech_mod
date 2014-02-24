/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight2;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.NTMCPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiSpotLightCreateKey extends FFMTGuiContainerSliderBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmodcity:textures/gui/spotlightkey.png");

	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;

	public GuiSpotLightCreateKey(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
	{
		super(new ContainerSpotLight2(tileEntity, playerInventory, world));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		this.world = world;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x + 3, y + 10, 170, 20, I18n.format("container.spotlight.time") + ": 0.0", 0));
		this.buttonList.add(new GuiButton(1, x + 13, y + 115, 150, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(2, x + 13, y + 90, 150, 20, I18n.format("container.spotlight.createkey")));
		NTMCPacketHelper.sendPacket(this.tileSpotLight, 0, TileEntitySpotLight.CREATEKEYTIME);
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
		}
		if(guibutton.id == 2)
		{
			if(tileSpotLight.get(TileEntitySpotLight.KEYLIST, (tileSpotLight.get(TileEntitySpotLight.CREATEKEYTIME))) == 1)
			{
				this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.format("container.spotlight.sure") + " " + I18n.format("container.spotlight.overwrite"), I18n.format("container.spotlight.overwrite"), I18n.format("container.spotlight.cancel"), 1));
			}
			else
			{
				this.createKey(tileSpotLight.get(TileEntitySpotLight.CREATEKEYTIME));
			}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		if(sliderId == 0)
		{
			NTMCPacketHelper.sendPacket(this.tileSpotLight, (int)(sliderValue * 120), TileEntitySpotLight.CREATEKEYTIME);
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
		NTMCPacketHelper.sendPacket(this.tileSpotLight, 1, TileEntitySpotLight.KEYLIST, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.RED), TileEntitySpotLight.REDKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.GREEN), TileEntitySpotLight.GREENKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.BLUE), TileEntitySpotLight.BLUEKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.DARKRED), TileEntitySpotLight.DARKREDKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.DARKGREEN), TileEntitySpotLight.DARKGREENKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.DARKBLUE), TileEntitySpotLight.DARKBLUEKEY, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.ANGLE1), TileEntitySpotLight.ANGLE1, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.ANGLE2), TileEntitySpotLight.ANGLE2, time);
		NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.AUTOROTATE), TileEntitySpotLight.AUTOROTATE, time);
		// sendKeyPacket(tileSpotLight.getRotationSpeed(), 10, time);
		// sendKeyPacket(tileSpotLight.getSecondaryLazer() ? 1 : 0, 11, time);
		// sendKeyPacket(tileSpotLight.getReverseRotation() ? 1 : 0, 12, time);
		// this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer,
		// tileSpotLight, world)); TODO finish
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