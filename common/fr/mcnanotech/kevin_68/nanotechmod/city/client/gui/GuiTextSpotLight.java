/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.NTMCPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiTextSpotLight extends FFMTGuiContainerSliderBase
{
	private static final ResourceLocation texture = new ResourceLocation("nanotechmodcity", "textures/gui/textspotlight.png");
	private static final ResourceLocation texture2 = new ResourceLocation("nanotechmodcity", "textures/gui/textspotlight2.png");
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

	@SuppressWarnings("unchecked")
	public void initGui()
	{
		super.initGui();
		this.xSize = 256;
		this.ySize = 256;
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		Keyboard.enableRepeatEvents(true);
		this.textField = new GuiTextField(this.fontRendererObj, x + 13, y + 30, 300, 12);
		this.textField.setTextColor(-1);
		this.textField.setDisabledTextColour(-1);
		this.textField.setEnableBackgroundDrawing(false);
		this.textField.setMaxStringLength(40);
		this.textField.setEnabled(true);
		this.textField.setText(tileTextSpotLight.getText());
		this.buttonList.add(autoRotateButton = new FFMTGuiBooleanButton(1, width / 2 - 155, y + 69, 150, 20, I18n.format("container.spotlight.rotate"), tileTextSpotLight.get(TileEntityTextSpotLight.ROTATE) == 1 ? true : false));
		this.buttonList.add(angleButton = new FFMTGuiSliderForContainer(this, 2, width / 2 - 155, y + 47, 310, 20, I18n.format("container.spotlight.angle") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.ANGLE), (float)(tileTextSpotLight.get(TileEntityTextSpotLight.ANGLE)) / 360.0F));
		this.buttonList.add(speedRotationButton = new FFMTGuiSliderForContainer(this, 3, width / 2 - 155, y + 91, I18n.format("container.spotlight.rotationspeed") + " : " + (tileTextSpotLight.get(TileEntityTextSpotLight.ROTATIONSPEED) / 10.0F), (float)(tileTextSpotLight.get(TileEntityTextSpotLight.ROTATIONSPEED)) / 50.0F));
		this.buttonList.add(reverseRotationButton = new FFMTGuiBooleanButton(4, width / 2 - 155, y + 113, I18n.format("container.spotlight.rotationreverse"), tileTextSpotLight.get(TileEntityTextSpotLight.REVERSEROTATION) == 1 ? false : true));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 5, width / 2 + 5, y + 69, EnumChatFormatting.RED + I18n.format("container.spotlight.red") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.RED), (float)(tileTextSpotLight.get(TileEntityTextSpotLight.RED)) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 6, width / 2 + 5, y + 91, EnumChatFormatting.GREEN + I18n.format("container.spotlight.green") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.GREEN), (float)(tileTextSpotLight.get(TileEntityTextSpotLight.GREEN)) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 7, width / 2 + 5, y + 113, EnumChatFormatting.BLUE + I18n.format("container.spotlight.blue") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.BLUE), (float)(tileTextSpotLight.get(TileEntityTextSpotLight.BLUE)) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 8, width / 2 + 5, y + 135, I18n.format("container.textspotlight.scale") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.SCALE) / 10.0F, (float)(tileTextSpotLight.get(TileEntityTextSpotLight.SCALE)) / 50.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 9, width / 2 - 155, y + 135, I18n.format("container.textspotlight.height") + " : " + tileTextSpotLight.get(TileEntityTextSpotLight.HEIGHT) / 10.0F, (float)(tileTextSpotLight.get(TileEntityTextSpotLight.HEIGHT)) / 50.0F));
		this.buttonList.add(new GuiButton(10, width / 2 - 155, y + 157, 65, 20, I18n.format("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(11, width / 2 - 69, y + 157, 65, 20, I18n.format("container.spotlight.paste")));

		if(tileTextSpotLight.get(TileEntityTextSpotLight.ROTATE) == 0)
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
			NTMCPacketHelper.sendPacket(tileTextSpotLight, tileTextSpotLight.get(TileEntityTextSpotLight.REVROTATE), TileEntityTextSpotLight.ROTATE);

			autoRotateButton.toggle();
			if(tileTextSpotLight.get(TileEntityTextSpotLight.ROTATE) == 1)
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
			NTMCPacketHelper.sendPacket(tileTextSpotLight, tileTextSpotLight.get(TileEntityTextSpotLight.REVREVERSEROTATION), TileEntityTextSpotLight.REVERSEROTATION);
			reverseRotationButton.toggle();
		}
		else if(guibutton.id == 10)
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, 0, TileEntityTextSpotLight.CONFIGCOPIER);
		}
		else if(guibutton.id == 11)
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, 1, TileEntityTextSpotLight.CONFIGCOPIER);
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
			NTMCPacketHelper.sendPacket(tileTextSpotLight, this.textField.getText());
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
			NTMCPacketHelper.sendPacket(tileTextSpotLight, (int)(sliderValue * 360), TileEntityTextSpotLight.ANGLE);
		}
		else if(sliderId == 3)
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, (int)(sliderValue * 50), TileEntityTextSpotLight.ROTATIONSPEED);
		}
		else if(sliderId == 8)
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, (int)(sliderValue * 50), TileEntityTextSpotLight.SCALE);
		}
		else if(sliderId == 9)
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, (int)(sliderValue * 50), TileEntityTextSpotLight.HEIGHT);
		}
		else
		{
			NTMCPacketHelper.sendPacket(tileTextSpotLight, (int)(sliderValue * 255), sliderId - 1);
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
			name = I18n.format("container.spotlight.angle") + " : ";
			multiValue = 360;
			break;
		case 3:
			name = I18n.format("container.spotlight.rotationspeed") + " : ";
			break;
		case 5:
			name = EnumChatFormatting.RED + I18n.format("container.spotlight.red") + " : ";
			multiValue = 255;
			break;
		case 6:
			name = EnumChatFormatting.GREEN + I18n.format("container.spotlight.green") + " : ";
			multiValue = 255;
			break;
		case 7:
			name = EnumChatFormatting.BLUE + I18n.format("container.spotlight.blue") + " : ";
			multiValue = 255;
			break;
		case 8:
			name = I18n.format("container.textspotlight.scale") + " : ";
			break;
		case 9:
			name = I18n.format("container.textspotlight.height") + " : ";
			break;
		}

		if(sliderId == 3)
		{
			return name + (tileTextSpotLight.get(TileEntityTextSpotLight.ROTATIONSPEED) / 10.0F);
		}
		else if(sliderId == 8)
		{
			return name + (tileTextSpotLight.get(TileEntityTextSpotLight.SCALE) / 10.0F);
		}
		else if(sliderId == 9)
		{
			return name + (tileTextSpotLight.get(TileEntityTextSpotLight.HEIGHT) / 10.0F);
		}
		else
		{
			return name + (int)(sliderValue * multiValue);
		}
	}
}