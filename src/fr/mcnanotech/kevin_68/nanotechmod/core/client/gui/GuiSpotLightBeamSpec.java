package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
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

		this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 20, 256, 20, I18n.format("container.spotlight.angle") + " 1 : " + tileSpotLight.getAngle1(), (float)(tileSpotLight.getAngle1()) / 360.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 2, 256, 20, I18n.format("container.spotlight.angle") + " 2 : " + (tileSpotLight.getAngle2() & 0xFF), (float)(tileSpotLight.getAngle2() & 0xFF) / 180.0F));
		this.buttonList.add(rotateButton = new GuiBooleanButton(2, x - 40, y + 24, 127, 20, I18n.format("container.spotlight.rotate") + " " + I18n.format("container.spotlight.on"), I18n.format("container.spotlight.rotate") + " " + I18n.format("container.spotlight.off"), tileSpotLight.isAutoRotate()));
		this.buttonList.add(revRotaButton = new GuiBooleanButton(3, x + 90, y + 24, 127, 20, I18n.format("container.spotlight.rotationreverse") + " " + I18n.format("container.spotlight.on"), I18n.format("container.spotlight.rotationreverse") + " " + I18n.format("container.spotlight.off"), tileSpotLight.isReverseRotation()));
		this.buttonList.add(new GuiSliderForContainer(this, 4, x - 40, y + 48, 127, 20, I18n.format("container.spotlight.rotationspeed") + " : " + (tileSpotLight.getRotationSpeed() & 0xFF), (float)(tileSpotLight.getRotationSpeed()) / 20.0F));
		this.buttonList.add(secLaserButton = new GuiBooleanButton(5, x + 90, y + 48, 127, 20, I18n.format("container.spotlight.secondlazer") + " " + I18n.format("container.spotlight.on"), I18n.format("container.spotlight.secondlazer") + " " + I18n.format("container.spotlight.off"), tileSpotLight.isSecondaryLaser()));
		this.buttonList.add(axeButton = new GuiMultipleOptionButton(7, x + 90, y + 70, 127, 20, I18n.format("container.spotlight.axis") + " : ", new String[] {"x", "y", "z"}, (tileSpotLight.getDisplayAxe() & 0xFF)));
		this.buttonList.add(sideLaser = new GuiBooleanButton(8, x - 40, y + 70, 127, 20, I18n.format("container.spotlight.double"), I18n.format("container.spotlight.simple"), tileSpotLight.isSideLaser()));
		this.buttonList.add(new GuiSliderForContainer(this, 9, x - 40, y + 92, 127, 20, I18n.format("container.spotlight.size") + " : " + (tileSpotLight.getMainLaserSize()& 0xFF), (float)((tileSpotLight.getMainLaserSize()& 0xFF) / 100.0F)));
		this.buttonList.add(new GuiSliderForContainer(this, 10, x + 90, y + 92, 127, 20, I18n.format("container.spotlight.size") + " : " + (tileSpotLight.getSecLaserSize()& 0xFF), (float)((tileSpotLight.getSecLaserSize()& 0xFF) / 100.0F)));
		this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, I18n.format("container.spotlight.back")));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 2:
		{
			rotateButton.toggle();
			PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)10, rotateButton.getIsActive());
			break;
		}
		case 3:
		{
			revRotaButton.toggle();
			PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)11, revRotaButton.getIsActive());
			break;
		}
		case 5:
		{
			secLaserButton.toggle();
			PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)13, secLaserButton.getIsActive());
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
			PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)14, (byte)axeButton.getState());
			break;
		}
		case 8:
		{
			sideLaser.toggle();
			PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)15, sideLaser.getIsActive());
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
			PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)9, (byte)(sliderValue * 180));
			break;
		}
		case 4:
		{
			PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)12, (byte)(sliderValue * 20));
			break;
		}
		case 9:
		{
			PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)16, (byte)(sliderValue * 100));
			break;
		}
		case 10:
		{
			PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)17, (byte)(sliderValue * 100));
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
			name = "Angle 2 : " + ((byte)(sliderValue * 180) & 0xFF);
			break;
		}
		case 4:
		{
			name = "Rotation Speed : " + ((byte)(sliderValue * 20) & 0xFF);
			break;
		}
		case 9:
		{
			name = "Main laser Size : " + ((byte)(sliderValue * 100) & 0xFF);
			break;
		}
		case 10:
		{
			name = "Sec laser Size : " + ((byte)(sliderValue * 100) & 0xFF);
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