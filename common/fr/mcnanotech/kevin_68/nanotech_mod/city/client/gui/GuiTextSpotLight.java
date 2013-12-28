package fr.mcnanotech.kevin_68.nanotech_mod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerTextSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiTextSpotLight extends FFMTGuiContainerSliderBase
{
	private static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city", "textures/gui/textspotlight.png");
	private static final ResourceLocation texture2 = new ResourceLocation("nanotech_mod_city", "textures/gui/textspotlight2.png");
	protected TileEntityTextSpotLight tileTextSpotLight;
	private GuiTextField textField;
	public FFMTGuiBooleanButton autoRotateButton;
	public FFMTGuiBooleanButton reverseRotationButton;
	public FFMTGuiSliderForContainer angleButton;
	public FFMTGuiSliderForContainer speedRotationButton;

	public GuiTextSpotLight(InventoryPlayer playerInventory, TileEntityTextSpotLight tileEntity, World world)
	{
		super(new ContainerTextSpotLight(tileEntity, playerInventory, world));
		tileTextSpotLight = tileEntity;
	}

	public void initGui()
	{
		super.initGui();
		this.xSize = 256;
		this.ySize = 256;
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		Keyboard.enableRepeatEvents(true);
		this.textField = new GuiTextField(this.fontRenderer, x + 13, y + 30, 300, 12);
		this.textField.setTextColor(-1);
		this.textField.setDisabledTextColour(-1);
		this.textField.setEnableBackgroundDrawing(false);
		this.textField.setMaxStringLength(40);
		this.textField.setEnabled(true);
		this.textField.setText(tileTextSpotLight.getText());
		this.buttonList.add(autoRotateButton = new FFMTGuiBooleanButton(1, width / 2 - 155, y + 69, 150, 20, I18n.getString("container.spotlight.rotate"), tileTextSpotLight.getRotate()));
		this.buttonList.add(angleButton = new FFMTGuiSliderForContainer(this, 2, width / 2 - 155, y + 47, I18n.getString("container.spotlight.angle") + " : " + tileTextSpotLight.getAngle(), (float)(tileTextSpotLight.getAngle()) / 180.0F));
		this.buttonList.add(speedRotationButton = new FFMTGuiSliderForContainer(this, 3, width / 2 - 155, y + 91, I18n.getString("container.spotlight.rotationspeed") + " : " + (tileTextSpotLight.getRotationSpeed() / 10.0F), (float)(tileTextSpotLight.getRotationSpeed()) / 50.0F));
		this.buttonList.add(reverseRotationButton = new FFMTGuiBooleanButton(4, width / 2 - 155, y + 113, I18n.getString("container.spotlight.rotationreverse"), !tileTextSpotLight.getReverseRotation()));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 5, width / 2 + 5, y + 47, EnumChatFormatting.RED + I18n.getString("container.spotlight.red") + " : " + tileTextSpotLight.getRedValue(), (float)(tileTextSpotLight.getRedValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 6, width / 2 + 5, y + 69, EnumChatFormatting.GREEN + I18n.getString("container.spotlight.green") + " : " + tileTextSpotLight.getGreenValue(), (float)(tileTextSpotLight.getGreenValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 7, width / 2 + 5, y + 91, EnumChatFormatting.BLUE + I18n.getString("container.spotlight.blue") + " : " + tileTextSpotLight.getBlueValue(), (float)(tileTextSpotLight.getBlueValue()) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 8, width / 2 + 5, y + 113, I18n.getString("container.textspotlight.scale") + " : " + tileTextSpotLight.getScale() / 10.0F, (float)(tileTextSpotLight.getScale()) / 50.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 9, width / 2 + 5, y + 135, I18n.getString("container.textspotlight.height") + " : " + tileTextSpotLight.getHeight() / 10.0F, (float)(tileTextSpotLight.getHeight()) / 50.0F));
		this.buttonList.add(new GuiButton(10, width / 2 - 155, y + 157, 65, 20, I18n.getString("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(11, width / 2 - 69, y + 157, 65, 20, I18n.getString("container.spotlight.paste")));

		if(!tileTextSpotLight.getRotate())
		{
			angleButton.disable();
			speedRotationButton.enable();
			reverseRotationButton.enabled = true;
		}
		else
		{
			angleButton.enable();
			speedRotationButton.disable();
			reverseRotationButton.enabled = false;
		}
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			this.sendTextSpotLightPacket(tileTextSpotLight.getRotate() ? 0 : 1, 1);
			autoRotateButton.toggle();
			if(tileTextSpotLight.getRotate())
			{
				angleButton.disable();
				speedRotationButton.enable();
				reverseRotationButton.enabled = true;
			}
			else
			{
				angleButton.enable();
				speedRotationButton.disable();
				reverseRotationButton.enabled = false;
			}
		}
		else if(guibutton.id == 4)
		{
			this.sendTextSpotLightPacket((tileTextSpotLight.getReverseRotation() ? 0 : 1), 4);
			reverseRotationButton.toggle();
		}
		else if(guibutton.id == 10)
		{
			sendTextSpotLightPacket(0, 10);
		}
		else if(guibutton.id == 11)
		{
			sendTextSpotLightPacket(1, 10);
		}
	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	protected void keyTyped(char par1, int par2)
	{
		if(this.textField.textboxKeyTyped(par1, par2))
		{
			sendTextSpotLightPacket(this.textField.getText());
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.textField.mouseClicked(par1, par2, par3);
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.textField.drawTextBox();
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

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		if(sliderId == 2)
		{
			this.sendTextSpotLightPacket((int)(sliderValue * 180), 2);
		}
		else if(sliderId == 3)
		{
			this.sendTextSpotLightPacket((int)(sliderValue * 50), 3);
		}
		else if (sliderId == 8)
		{
			this.sendTextSpotLightPacket((int)(sliderValue * 50), 8);
		}
		else if (sliderId == 9)
		{
			this.sendTextSpotLightPacket((int)(sliderValue * 50), 9);
		}
		else
		{
			this.sendTextSpotLightPacket((int)(sliderValue * 255), sliderId);
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		int multiValue = 0;
		
		switch(sliderId)
		{
		case 2:
			name = I18n.getString("container.spotlight.angle") + " : ";
			multiValue = 180;
			break;
		case 3:
			name = I18n.getString("container.spotlight.rotationspeed") + " : ";
			break;
		case 5:
			name = EnumChatFormatting.RED + I18n.getString("container.spotlight.red") + " : ";
			multiValue = 255;
			break;
		case 6:
			name = EnumChatFormatting.GREEN + I18n.getString("container.spotlight.green") + " : ";
			multiValue = 255;
			break;
		case 7:
			name = EnumChatFormatting.BLUE + I18n.getString("container.spotlight.blue") + " : ";
			multiValue = 255;
			break;
		case 8:
			name = I18n.getString("container.textspotlight.scale") + " : ";
			break;
		case 9:
			name = I18n.getString("container.textspotlight.height") + " : ";
			break;
		}
		
		if(sliderId == 3)
		{
			return name + (tileTextSpotLight.getRotationSpeed() / 10.0F);
		}
		else if(sliderId == 8)
		{
			return name + (tileTextSpotLight.getScale() / 10.0F);
		}
		else if(sliderId == 9)
		{
			return name + (tileTextSpotLight.getHeight() / 10.0F);
		}
		else
		{
			return name + (int)(sliderValue * multiValue);	
		}
	}

	private void sendTextSpotLightPacket(int value, int type)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(type);
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTMC|text", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to send a packet from a TextSpotLight");
		}
	}
	private void sendTextSpotLightPacket(String text)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeUTF(text);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTMC|text2", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to send a packet from a TextSpotLight");
		}
	}
}