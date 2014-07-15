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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight2;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;

public class GuiSpotLightTimeLine extends GuiContainerSliderBase
{
	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;
	public GuiBooleanButton timeLineModeButton;
	public GuiButton removebutton;
	public GuiBooleanButton smoothButton;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlight1.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("nanotechmod:textures/gui/spotlight2.png");
	protected static final ResourceLocation timeline = new ResourceLocation("nanotechmod:textures/gui/timeline.png");
	protected static final ResourceLocation widget = new ResourceLocation("nanotechmod:textures/gui/widget.png");

	public GuiSpotLightTimeLine(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
	{
		super(new ContainerSpotLight2(tileEntity, playerInventory, world));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		this.world = world;
	}

	public void initGui()
	{
		super.initGui();
		this.xSize = 256;
		this.ySize = 256;
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		PacketSender.sendSpotLightPacket(this.tileSpotLight, 20, -1);
		this.buttonList.add(new GuiButton(2, width / 2 + 90, y + 185, 65, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(3, width / 2 - 155, y + 69, 120, 20, I18n.format("container.spotlight.addKey")));
		this.buttonList.add(timeLineModeButton = new GuiBooleanButton(4, width / 2 - 155, y + 185, 65, 20, I18n.format("container.spotlight.timeline"), tileSpotLight.isTimeLineEnabled()));
		this.buttonList.add(removebutton = new GuiButton(5, width / 2 - 155, y + 91, 120, 20, I18n.format("container.spotlight.deleteKey")));
		this.buttonList.add(new GuiButton(6, width / 2 - 155, y + 113, 120, 20, I18n.format("container.spotlight.settimelineto") + " 0"));
		this.buttonList.add(smoothButton = new GuiBooleanButton(7, width / 2 - 155, y + 135, 120, 20, I18n.format("container.spotlight.smooth"), tileSpotLight.isSmoothMode()));
		removebutton.enabled = false;

		for(int i = 0; i < 121; i++)
		{
			if(tileSpotLight.getKey(i) != null && tileSpotLight.getKey(i).isActive())
			{
				System.out.println("button " + i + " draw");
				this.buttonList.add(new GuiTimeKey(10 + i, width / 2 - 149 + (int)(i * 2.5), y + 50 + ((i % 2)) * 4));
			}
		}
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		if(guibutton.id == 2)
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
		}
		else if(guibutton.id == 3)
		{
			this.mc.displayGuiScreen(new GuiSpotLightCreateKey(invPlayer, tileSpotLight, world));
		}
		else if(guibutton.id == 4)
		{
			timeLineModeButton.toggle();
			PacketSender.sendSpotLightPacket(this.tileSpotLight, 22, timeLineModeButton.getIsActive() ? 1 : 0);
		}
		else if(guibutton.id == 5)
		{
			if(tileSpotLight.getKey(tileSpotLight.getLastKeySelected()) != null && tileSpotLight.getKey(tileSpotLight.getCreateKeyTime()).isActive())
			{
				this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.format("container.spotlight.sure") + " " + I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.cancel"), 0));
			}
		}
		else if(guibutton.id == 6)
		{
			PacketSender.sendSpotLightPacket(this.tileSpotLight, 23, 0);
		}
		else if(guibutton.id == 7)
		{
			smoothButton.toggle();
			PacketSender.sendSpotLightPacket(this.tileSpotLight, 24, smoothButton.getIsActive() ? 1 : 0);
		}
		else if(guibutton.id >= 10)
		{
			int keyid = guibutton.id - 10;
			if(tileSpotLight.getKey(keyid) != null)
			{
				PacketSender.sendSpotLightPacket(this.tileSpotLight, 20, keyid);
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
		this.drawTexturedModalRect(x - 20 + (int)(tileSpotLight.getTime() / 4), y + 40, 0, 3, 1, 12);

		if(tileSpotLight.getKey(tileSpotLight.getLastKeySelected()) != null)
		{
			SpotLightEntry entry = tileSpotLight.getKey(tileSpotLight.getLastKeySelected());
			this.drawTexturedModalRect(x - 22 + (int)(tileSpotLight.getLastKeySelected() * 2.5), y + 62, 0, 13, 5, 19);
			this.drawString(this.fontRendererObj, EnumChatFormatting.RED + I18n.format("container.spotlight.red") + " : " + entry.getKeyRed(), x + 100, y + 70, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.GREEN + I18n.format("container.spotlight.green") + " : " + entry.getKeyGreen(), x + 100, y + 80, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.BLUE + I18n.format("container.spotlight.blue") + " : " + entry.getKeyBlue(), x + 100, y + 90, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_RED + I18n.format("container.spotlight.darkred") + " : " + entry.getKeySecRed(), x + 185, y + 70, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_GREEN + I18n.format("container.spotlight.darkgreen") + " : " + entry.getKeySecGreen(), x + 185, y + 80, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_BLUE + I18n.format("container.spotlight.darkblue") + " : " + entry.getKeySecBlue(), x + 185, y + 90, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 1 : " + entry.getKeyAngle1(), x + 100, y + 100, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 2 : " + entry.getKeyAngle2(), x + 185, y + 100, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotate") + " : " + (entry.isKeyAutRot() ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 110, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationspeed") + " : " + entry.getKeyRotSpe(), x + 100, y + 120, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationreverse") + " : " + (entry.isKeyRevRot() ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 130, 0xffffff);
			this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.secondlazer") + " : " + (entry.isKeySecLas() ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 140, 0xffffff);
		}
	}
}