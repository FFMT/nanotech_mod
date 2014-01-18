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

public class GuiSpotLight extends FFMTGuiContainerSliderBase
{
	protected TileEntitySpotLight tileSpotLight;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city:textures/gui/spotlight1.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("nanotech_mod_city:textures/gui/spotlight2.png");
	public FFMTGuiBooleanButton autoRotateButton;
	public FFMTGuiBooleanButton secondaryLazerButton;
	public FFMTGuiBooleanButton reverseRotationButton;
	public FFMTGuiSliderForContainer angle2Button;
	public FFMTGuiSliderForContainer speedRotationButton;

	public GuiSpotLight(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, world));
		tileSpotLight = tileEntity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.xSize = 256;
		this.ySize = 256;
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, width / 2 + 5, y + 47, EnumChatFormatting.RED + I18n.getString("container.spotlight.red") + " : " + tileSpotLight.getRedValue(), (float)(tileSpotLight.getRedValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 1, width / 2 + 5, y + 69, EnumChatFormatting.GREEN + I18n.getString("container.spotlight.green") + " : " + tileSpotLight.getGreenValue(), (float)(tileSpotLight.getGreenValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 2, width / 2 + 5, y + 91, EnumChatFormatting.BLUE + I18n.getString("container.spotlight.blue") + " : " + tileSpotLight.getBlueValue(), (float)(tileSpotLight.getBlueValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 3, width / 2 + 5, y + 113, EnumChatFormatting.DARK_RED + I18n.getString("container.spotlight.darkred") + " : " + tileSpotLight.getDarkRedValue(), (float)(tileSpotLight.getDarkRedValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 4, width / 2 + 5, y + 135, EnumChatFormatting.DARK_GREEN + I18n.getString("container.spotlight.darkgreen") + " : " + tileSpotLight.getDarkGreenValue(), (float)(tileSpotLight.getDarkGreenValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 5, width / 2 + 5, y + 157, EnumChatFormatting.DARK_BLUE + I18n.getString("container.spotlight.darkblue") + " : " + tileSpotLight.getDarkBlueValue(), (float)(tileSpotLight.getDarkBlueValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 6, width / 2 - 155, y + 25, 310, 20, EnumChatFormatting.WHITE + I18n.getString("container.spotlight.angle") + " 1 : " + tileSpotLight.getAngle1(), (float)(tileSpotLight.getAngle1()) / 360.0F));
		this.buttonList.add(angle2Button = new FFMTGuiSliderForContainer(this, 7, width / 2 - 155, y + 47, I18n.getString("container.spotlight.angle") + " 2 : " + tileSpotLight.getAngle2(), (float)(tileSpotLight.getAngle2()) / 180.0F));
		this.buttonList.add(autoRotateButton = new FFMTGuiBooleanButton(8, width / 2 - 155, y + 69, 150, 20, I18n.getString("container.spotlight.rotate"), tileSpotLight.getAutoRotate()));
		this.buttonList.add(speedRotationButton = new FFMTGuiSliderForContainer(this, 9, width / 2 - 155, y + 91, I18n.getString("container.spotlight.rotationspeed") + " : " + (tileSpotLight.getRotationSpeed() / 10.0F), (float)(tileSpotLight.getRotationSpeed()) / 50.0F));
		this.buttonList.add(reverseRotationButton = new FFMTGuiBooleanButton(11, width / 2 - 155, y + 113, I18n.getString("container.spotlight.rotationreverse"), !tileSpotLight.getReverseRotation()));
		this.buttonList.add(secondaryLazerButton = new FFMTGuiBooleanButton(10, width / 2 - 155, y + 135, I18n.getString("container.spotlight.secondlazer"), tileSpotLight.getSecondaryLazer()));
		this.buttonList.add(new GuiButton(12, width / 2 - 155, y + 157, 65, 20, I18n.getString("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(13, width / 2 - 69, y + 157, 65, 20, I18n.getString("container.spotlight.paste")));

		if(!tileSpotLight.getAutoRotate())
		{
			angle2Button.disable();
			speedRotationButton.enable();
			reverseRotationButton.enabled = true;
		}
		else
		{
			angle2Button.enable();
			speedRotationButton.disable();
			reverseRotationButton.enabled = false;
		}
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 8)
		{
			this.sendSpotLightPacket((int)(tileSpotLight.getAutoRotate() ? 0 : 1), 8);
			autoRotateButton.toggle();
			if(tileSpotLight.getAutoRotate())
			{
				angle2Button.disable();
				speedRotationButton.enable();
				reverseRotationButton.enabled = true;
			}
			else
			{
				angle2Button.enable();
				speedRotationButton.disable();
				reverseRotationButton.enabled = false;
			}
		}
		else if(guibutton.id == 10)
		{
			this.sendSpotLightPacket((int)(tileSpotLight.getSecondaryLazer() ? 0 : 1), 10);
			secondaryLazerButton.toggle();
		}
		else if(guibutton.id == 11)
		{
			this.sendSpotLightPacket((int)(tileSpotLight.getReverseRotation() ? 0 : 1), 11);
			reverseRotationButton.toggle();
		}
		else if(guibutton.id == 12)
		{
			sendSpotLightPacket(0, 12);
		}
		else if(guibutton.id == 13)
		{
			sendSpotLightPacket(1, 12);
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		if(sliderId == 6)
		{
			this.sendSpotLightPacket((int)(sliderValue * 360), sliderId);
		}
		else if(sliderId == 7)
		{
			this.sendSpotLightPacket((int)(sliderValue * 180), sliderId);
		}
		else if(sliderId == 9)
		{
			this.sendSpotLightPacket((int)(sliderValue * 50), sliderId);
		}
		else
		{
			this.sendSpotLightPacket((int)(sliderValue * 255), sliderId);
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		int multiValue = 255;
		switch(sliderId)
		{
		case 0:
			name = EnumChatFormatting.RED + I18n.getString("container.spotlight.red") + " : ";
			multiValue = 255;
			break;
		case 1:
			name = EnumChatFormatting.GREEN + I18n.getString("container.spotlight.green") + " : ";
			multiValue = 255;
			break;
		case 2:
			name = EnumChatFormatting.BLUE + I18n.getString("container.spotlight.blue") + " : ";
			multiValue = 255;
			break;
		case 3:
			name = EnumChatFormatting.DARK_RED + I18n.getString("container.spotlight.darkred") + " : ";
			multiValue = 255;
			break;
		case 4:
			name = EnumChatFormatting.DARK_GREEN + I18n.getString("container.spotlight.darkgreen") + " : ";
			multiValue = 255;
			break;
		case 5:
			name = EnumChatFormatting.DARK_BLUE + I18n.getString("container.spotlight.darkblue") + " : ";
			multiValue = 255;
			break;
		case 6:
			name = I18n.getString("container.spotlight.angle") + " 1 : ";
			multiValue = 360;
			break;
		case 7:
			name = I18n.getString("container.spotlight.angle") + " 2 : ";
			multiValue = 180;
			break;
		case 9:
			name = I18n.getString("container.spotlight.rotationspeed") + " : ";
			break;
		}
		if(sliderId == 9)
		{
			return name + (tileSpotLight.getRotationSpeed() / 10.0F);
		}
		else
		{
			return name + (int)(sliderValue * multiValue);
		}
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
	}
}