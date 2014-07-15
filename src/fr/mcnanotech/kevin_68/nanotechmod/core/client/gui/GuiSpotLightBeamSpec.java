package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiMultipleOptionButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightBeamSpec extends GuiContainerSliderBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlighttex.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;
	public GuiBooleanButton rotateButton, revRotaButton, secLaserButton, sideLaser;
	public GuiMultipleOptionButton axeButton;

	public GuiSpotLightBeamSpec(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 20, 256, 20, "Angle 1 : " + tileSpotLight.getAngle1(), (float)(tileSpotLight.getAngle1()) / 360.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 2, 256, 20, "Angle 2 : " + tileSpotLight.getAngle2(), (float)(tileSpotLight.getAngle2()) / 180.0F));
		this.buttonList.add(rotateButton = new GuiBooleanButton(2, x - 40, y + 24, 127, 20, "Auto Rotate On", "Auto Rotate Off", tileSpotLight.isAutoRotate()));
		this.buttonList.add(revRotaButton = new GuiBooleanButton(3, x + 90, y + 24, 127, 20, "Reverse Rotation On", "Reverse Rotation Off", tileSpotLight.isReverseRotation()));
		this.buttonList.add(new GuiSliderForContainer(this, 4, x - 40, y + 48, 256, 20, "Rotation Speed : " + tileSpotLight.getRotationSpeed(), (float)(tileSpotLight.getRotationSpeed()) / 20.0F));
		this.buttonList.add(secLaserButton = new GuiBooleanButton(5, x - 40, y + 70, 127, 20, "Secondary laser On", "Secondary laser Off", tileSpotLight.isSecondaryLaser()));
		ArrayList<String> txt = new ArrayList();
		txt.add("y");
		txt.add("x");
		txt.add("z");
		this.buttonList.add(axeButton = new GuiMultipleOptionButton(7, x + 90, y + 70, 127, 20, "Axe : ", txt, 2, tileSpotLight.getDisplayAxe()));
		this.buttonList.add(sideLaser = new GuiBooleanButton(8, x - 40, y + 92, 127, 20, "Double laser", "Simple laser", tileSpotLight.isSideLaser()));
		this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, "Back"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 2:
		{
			rotateButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 10, rotateButton.getIsActive() ? 1 : 0);
			break;
		}
		case 3:
		{
			revRotaButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 11, revRotaButton.getIsActive() ? 1 : 0);
			break;
		}
		case 5:
		{
			secLaserButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 13, secLaserButton.getIsActive() ? 1 : 0);
			break;
		}
		case 6:
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
			break;
		}
		case 7:
		{
			axeButton.next();
			PacketSender.sendSpotLightPacket(tileSpotLight, 14, axeButton.getState());
			break;
		}
		case 8:
		{
			sideLaser.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 15, sideLaser.getIsActive() ? 1 : 0);
			break;
		}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		switch(sliderId)
		{
		case 0:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 8, (int)(sliderValue * 360));
			break;
		}
		case 1:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 9, (int)(sliderValue * 180));
			break;
		}
		case 4:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 12, (int)(sliderValue * 20));
			break;
		}
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
		{
		case 0:
		{
			name = "Angle 1 : " + (int)(sliderValue * 360);
			break;
		}
		case 1:
		{
			name = "Angle 2 : " + (int)(sliderValue * 180);
			break;
		}
		case 4:
		{
			name = "Rotation Speed : " + ((int)(sliderValue * 20));
			break;
		}
		}
		return name;
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