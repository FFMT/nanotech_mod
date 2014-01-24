package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.items.NanotechCityItems;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiSpotLightTimeLine extends FFMTGuiContainerSliderBase
{
	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;
	public FFMTGuiBooleanButton timeLineModeButton;
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
		this.buttonList.add(new GuiButton(0, width / 2 - 155, y + 157, 65, 20, I18n.getString("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(1, width / 2 - 69, y + 157, 65, 20, I18n.getString("container.spotlight.paste")));
		this.buttonList.add(new GuiButton(2, width / 2 + 90, y + 185, 65, 20, I18n.getString("container.spotlight.back")));
		this.buttonList.add(new GuiButton(3, width / 2 - 155, y + 70, 120, 20, I18n.getString("container.spotlight.addKey")));
		this.buttonList.add(timeLineModeButton = new FFMTGuiBooleanButton(4, width / 2 - 155, y + 185, 65, 20, I18n.getString("container.spotlight.timeline"), tileSpotLight.getTimeLineMode()));

		for(int i = 0; i < 121; i++)
		{
			boolean hasKey = tileSpotLight.hasKey(i);
			if(hasKey)
			{
				this.buttonList.add(new GuiTimeKey(10 + i, width / 2 - 149 + (int)(i * 2.5), y + 50 + ((i % 2)) * 4));
			}
		}

		sendSpotLightPacket(-1, 15);
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
					//guiconfirm 
				}
			}
		}
		else if(guibutton.id >= 10)
		{
			int keyid = guibutton.id - 10;
			if(tileSpotLight.hasKey(keyid))
			{
				sendSpotLightPacket(keyid, 15);
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
		this.drawTexturedModalRect(x - 20 + (int)(tileSpotLight.getTimeLine() / 4), y + 40, 0, 3, 1, 24);

		if(tileSpotLight.getSelectedButtonid() != -1)
		{
			if(tileSpotLight.hasKey(tileSpotLight.getSelectedButtonid()))
			{
				this.drawString(this.fontRenderer, EnumChatFormatting.RED + I18n.getString("container.spotlight.red") + " : " + tileSpotLight.getRedKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 70, 0xffffff);
				this.drawString(this.fontRenderer, EnumChatFormatting.GREEN + I18n.getString("container.spotlight.green") + " : " + tileSpotLight.getGreenKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 80, 0xffffff);
				this.drawString(this.fontRenderer, EnumChatFormatting.BLUE + I18n.getString("container.spotlight.blue") + " : " + tileSpotLight.getBlueKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 90, 0xffffff);
				this.drawString(this.fontRenderer, EnumChatFormatting.DARK_RED + I18n.getString("container.spotlight.darkred") + " : " + tileSpotLight.getDarkRedKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 100, 0xffffff);
				this.drawString(this.fontRenderer, EnumChatFormatting.DARK_GREEN + I18n.getString("container.spotlight.darkgreen") + " : " + tileSpotLight.getDarkGreenKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 110, 0xffffff);
				this.drawString(this.fontRenderer, EnumChatFormatting.DARK_BLUE + I18n.getString("container.spotlight.darkblue") + " : " + tileSpotLight.getDarkBlueKey(tileSpotLight.getSelectedButtonid()), x + 110, y + 120, 0xffffff);
				this.buttonList.add(new GuiButton(5, 80, 120, 80, 20, "test"));
			}
		}
	}
}