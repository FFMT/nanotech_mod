package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight2;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
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

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x + 3, y + 10, 170, 20, I18n.getString("container.spotlight.time") + ": 0.0", 0));
		this.buttonList.add(new GuiButton(1, x + 13, y + 115, 150, 20, I18n.getString("container.spotlight.back")));
		this.buttonList.add(new GuiButton(2, x + 13, y + 90, 150, 20, I18n.getString("container.spotlight.createkey")));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
		}
		if(guibutton.id == 2)
		{
			if(tileSpotLight.hasKey((tileSpotLight.getCreateKeyTime())))
			{
				this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.getString("container.spotlight.sure") + " " + I18n.getString("container.spotlight.overwrite"), I18n.getString("container.spotlight.overwrite"), I18n.getString("container.spotlight.cancel"), 1));
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
			sendSpotLightPacket((int)(sliderValue * 120), 14);
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		if(sliderId == 0)
		{
			name = I18n.getString("container.spotlight.time") + ": " + (float)(((int)((float)(sliderValue * 120))) / 2.0F);
		}
		return name;
	}

	private void sendKeyPacket(int value, int type, int time)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(type);
			dataoutputstream.writeInt(value);
			dataoutputstream.writeInt(time);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTMC|lightKey", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to send a packet from a SpotLight Key");
		}
	}
	
	private void sendSpotLightPacket(int value, int type)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(type);
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTMC|light", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to send a packet from a SpotLight");
		}
	}

	
	public void createKey(int time)
	{
		sendKeyPacket(1, 0, time);
		sendKeyPacket(tileSpotLight.getRedValue(), 1, time);
		sendKeyPacket(tileSpotLight.getGreenValue(), 2, time);
		sendKeyPacket(tileSpotLight.getBlueValue(), 3, time);
		sendKeyPacket(tileSpotLight.getDarkRedValue(), 4, time);
		sendKeyPacket(tileSpotLight.getDarkGreenValue(), 5, time);
		sendKeyPacket(tileSpotLight.getDarkBlueValue(), 6, time);
		sendKeyPacket(tileSpotLight.getAngle1(), 7, time);
		sendKeyPacket(tileSpotLight.getAngle2(), 8, time);
		sendKeyPacket(tileSpotLight.getAutoRotate() ? 1 : 0, 9, time);
		sendKeyPacket(tileSpotLight.getRotationSpeed(), 10, time);
		//this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
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