package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;

public class GuiSpotLightTimeLine extends FFMTGuiContainerSliderBase
{
	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;
	public FFMTGuiBooleanButton timeLineModeButton;
	public GuiButton removebutton;
	public FFMTGuiBooleanButton smoothButton;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmodcity:textures/gui/spotlight1.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("nanotechmodcity:textures/gui/spotlight2.png");
	protected static final ResourceLocation timeline = new ResourceLocation("nanotechmodcity:textures/gui/timeline.png");
	protected static final ResourceLocation widget = new ResourceLocation("nanotechmodcity:textures/gui/widget.png");

	public GuiSpotLightTimeLine(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
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
		this.xSize = 256;
		this.ySize = 256;
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		sendSpotLightPacket(-1, 15);
		this.buttonList.add(new GuiButton(0, width / 2 - 155, y + 157, 65, 20, I18n.format("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(1, width / 2 - 69, y + 157, 65, 20, I18n.format("container.spotlight.paste")));
		this.buttonList.add(new GuiButton(2, width / 2 + 90, y + 185, 65, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(3, width / 2 - 155, y + 69, 120, 20, I18n.format("container.spotlight.addKey")));
		this.buttonList.add(timeLineModeButton = new FFMTGuiBooleanButton(4, width / 2 - 155, y + 185, 65, 20, I18n.format("container.spotlight.timeline"), tileSpotLight.getTimeLineMode()));
		this.buttonList.add(removebutton = new GuiButton(5, width / 2 - 155, y + 91, 120, 20, I18n.format("container.spotlight.deleteKey")));
		this.buttonList.add(new GuiButton(6, width / 2 - 155, y + 113, 120, 20, I18n.format("container.spotlight.settimelineto") + " 0"));
		this.buttonList.add(smoothButton = new FFMTGuiBooleanButton(7, width / 2 - 155, y + 135, 120, 20, I18n.format("container.spotlight.smooth"), tileSpotLight.getSmoothMode()));
		removebutton.enabled = false;

		for(int i = 0; i < 121; i++)
		{
			if(tileSpotLight.hasKey(i))
			{
				this.buttonList.add(new GuiTimeKey(10 + i, width / 2 - 149 + (int)(i * 2.5), y + 50 + ((i % 2)) * 4));
			}
		}
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		if(guibutton.id == 0)
		{
			sendSpotLightPacket(0, 12);
		}
		else if(guibutton.id == 1)
		{
			sendSpotLightPacket(1, 12);
		}
		else if(guibutton.id == 2)
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
		}
		else if(guibutton.id == 3)
		{
			this.mc.displayGuiScreen(new GuiSpotLightCreateKey(invPlayer, tileSpotLight, world));
		}
		else if(guibutton.id == 4)
		{
			this.sendSpotLightPacket((int)(tileSpotLight.getTimeLineMode() ? 0 : 1), 13);
			timeLineModeButton.toggle();
		}
		else if(guibutton.id == 5)
		{
			if(tileSpotLight.getSelectedButtonid() != -1)
			{
				if(tileSpotLight.hasKey(tileSpotLight.getSelectedButtonid()))
				{
					this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.format("container.spotlight.sure") + " " + I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.cancel"), 0));
				}
			}
		}
		else if(guibutton.id == 6)
		{
			sendSpotLightPacket(0, 16);
		}
		else if(guibutton.id == 7)
		{
			sendSpotLightPacket((int)(tileSpotLight.getSmoothMode() ? 0 : 1), 17);
			smoothButton.toggle();
		}
		else if(guibutton.id >= 10)
		{
			int keyid = guibutton.id - 10;
			if(tileSpotLight.hasKey(keyid))
			{
				sendSpotLightPacket(keyid, 15);
				removebutton.enabled = true;
			}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{

	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return "";
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
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
			// TODO this.mc.getNetHandler().addToSendQueue(new
			// Packet250CustomPayload("NTMC|lightKey",
			// bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			// TODO
			// NanotechMod.nanoLog.severe("Failed to send a packet from a SpotLight Key");
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
			// TODO this.mc.getNetHandler().addToSendQueue(new
			// Packet250CustomPayload("NTMC|light",
			// bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			// TODO
			// NanotechMod.nanoLog.severe("Failed to send a packet from a SpotLight");
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x - 35, y + 19, 0, 0, xSize, ySize);
		this.mc.renderEngine.bindTexture(texture2);
		this.drawTexturedModalRect(x + 135, y + 19, 0, 0, xSize, ySize);
		this.mc.renderEngine.bindTexture(timeline);
		this.drawTexturedModalRect(x - 20, y + 40, 0, 0, 256, 21);
		this.drawTexturedModalRect(x + 225, y + 40, 0, 22, 256, 43);
		this.mc.renderEngine.bindTexture(widget);
		this.drawTexturedModalRect(x - 20 + (int)(tileSpotLight.getTimeLine() / 4), y + 40, 0, 3, 1, 12);

		if(tileSpotLight.getSelectedButtonid() != -1)
		{
			if(tileSpotLight.hasKey(tileSpotLight.getSelectedButtonid()))
			{
				this.drawTexturedModalRect(x - 22 + (int)(tileSpotLight.getSelectedButtonid() * 2.5), y + 62, 0, 13, 5, 19);
				this.drawString(this.fontRendererObj, EnumChatFormatting.RED + I18n.format("container.spotlight.red") + " : " + tileSpotLight.getRedKey(tileSpotLight.getSelectedButtonid()), x + 100, y + 70, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.GREEN + I18n.format("container.spotlight.green") + " : " + tileSpotLight.getGreenKey(tileSpotLight.getSelectedButtonid()), x + 100, y + 80, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.BLUE + I18n.format("container.spotlight.blue") + " : " + tileSpotLight.getBlueKey(tileSpotLight.getSelectedButtonid()), x + 100, y + 90, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_RED + I18n.format("container.spotlight.darkred") + " : " + tileSpotLight.getDarkRedKey(tileSpotLight.getSelectedButtonid()), x + 185, y + 70, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_GREEN + I18n.format("container.spotlight.darkgreen") + " : " + tileSpotLight.getDarkGreenKey(tileSpotLight.getSelectedButtonid()), x + 185, y + 80, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_BLUE + I18n.format("container.spotlight.darkblue") + " : " + tileSpotLight.getDarkBlueKey(tileSpotLight.getSelectedButtonid()), x + 185, y + 90, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 1 : " + tileSpotLight.getAngle1Key(tileSpotLight.getSelectedButtonid()), x + 100, y + 100, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 2 : " + tileSpotLight.getAngle2Key(tileSpotLight.getSelectedButtonid()), x + 185, y + 100, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotate") + " : " + (tileSpotLight.getAutoRotateKey(tileSpotLight.getSelectedButtonid()) == false ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 110, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationspeed") + " : " + tileSpotLight.getRotationSpeedKey(tileSpotLight.getSelectedButtonid()), x + 100, y + 120, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationreverse") + " : " + (tileSpotLight.getReverseRotationKey(tileSpotLight.getSelectedButtonid()) == true ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 130, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.secondlazer") + " : " + (tileSpotLight.getSecondaryLazerKey(tileSpotLight.getSelectedButtonid()) == false ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 140, 0xffffff);
			}
		}
	}

}