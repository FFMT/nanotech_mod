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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.NTMCPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiContainerSliderBase;

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

	@SuppressWarnings({"unchecked"})
	@Override
	public void initGui()
	{
		super.initGui();
		this.xSize = 256;
		this.ySize = 256;
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		NTMCPacketHelper.sendPacket(this.tileSpotLight, -1, TileEntitySpotLight.SELECTEDBUTTON);
		this.buttonList.add(new GuiButton(0, width / 2 - 155, y + 157, 65, 20, I18n.format("container.spotlight.copy")));
		this.buttonList.add(new GuiButton(1, width / 2 - 69, y + 157, 65, 20, I18n.format("container.spotlight.paste")));
		this.buttonList.add(new GuiButton(2, width / 2 + 90, y + 185, 65, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(3, width / 2 - 155, y + 69, 120, 20, I18n.format("container.spotlight.addKey")));
		this.buttonList.add(timeLineModeButton = new FFMTGuiBooleanButton(4, width / 2 - 155, y + 185, 65, 20, I18n.format("container.spotlight.timeline"), tileSpotLight.get(TileEntitySpotLight.TIMELINEMODE) == 1 ? true : false));
		this.buttonList.add(removebutton = new GuiButton(5, width / 2 - 155, y + 91, 120, 20, I18n.format("container.spotlight.deleteKey")));
		this.buttonList.add(new GuiButton(6, width / 2 - 155, y + 113, 120, 20, I18n.format("container.spotlight.settimelineto") + " 0"));
		this.buttonList.add(smoothButton = new FFMTGuiBooleanButton(7, width / 2 - 155, y + 135, 120, 20, I18n.format("container.spotlight.smooth"), tileSpotLight.get(TileEntitySpotLight.SMOOTHMODE) == 1 ? true : false));
		removebutton.enabled = false;

		for(int i = 0; i < 121; i++)
		{
			if(tileSpotLight.get(TileEntitySpotLight.KEYLIST, i) == 1)
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
			NTMCPacketHelper.sendPacket(this.tileSpotLight, 0, TileEntitySpotLight.CONFIGCOPIER);
		}
		else if(guibutton.id == 1)
		{
			NTMCPacketHelper.sendPacket(this.tileSpotLight, 1, TileEntitySpotLight.CONFIGCOPIER);
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
			NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.REVTIMELINEMODE), TileEntitySpotLight.TIMELINEMODE);
			timeLineModeButton.toggle();
		}
		else if(guibutton.id == 5)
		{
			if(tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON) != -1)
			{
				if(tileSpotLight.get(TileEntitySpotLight.KEYLIST, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)) == 1)
				{
					this.mc.displayGuiScreen(new GuiSpotLightConfirm(tileSpotLight, invPlayer, world, I18n.format("container.spotlight.sure") + " " + I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.deleteKey"), I18n.format("container.spotlight.cancel"), 0));
				}
			}
		}
		else if(guibutton.id == 6)
		{
			NTMCPacketHelper.sendPacket(this.tileSpotLight, 0, TileEntitySpotLight.TIMELINE);
		}
		else if(guibutton.id == 7)
		{
			NTMCPacketHelper.sendPacket(this.tileSpotLight, tileSpotLight.get(TileEntitySpotLight.REVSMOOTHMODE), TileEntitySpotLight.SMOOTHMODE);
			smoothButton.toggle();
		}
		else if(guibutton.id >= 10)
		{
			int keyid = guibutton.id - 10;
			if(tileSpotLight.get(TileEntitySpotLight.KEYLIST, keyid) == 1)
			{
				NTMCPacketHelper.sendPacket(this.tileSpotLight, keyid, TileEntitySpotLight.SELECTEDBUTTON);
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
		this.drawTexturedModalRect(x - 20 + (int)(tileSpotLight.get(TileEntitySpotLight.TIMELINE) / 4), y + 40, 0, 3, 1, 12);

		if(tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON) != -1)
		{
			if(tileSpotLight.get(TileEntitySpotLight.KEYLIST, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)) == 1)
			{
				this.drawTexturedModalRect(x - 22 + (int)(tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON) * 2.5), y + 62, 0, 13, 5, 19);
				this.drawString(this.fontRendererObj, EnumChatFormatting.RED + I18n.format("container.spotlight.red") + " : " + tileSpotLight.get(TileEntitySpotLight.REDKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 100, y + 70, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.GREEN + I18n.format("container.spotlight.green") + " : " + tileSpotLight.get(TileEntitySpotLight.GREENKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 100, y + 80, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.BLUE + I18n.format("container.spotlight.blue") + " : " + tileSpotLight.get(TileEntitySpotLight.BLUEKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 100, y + 90, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_RED + I18n.format("container.spotlight.darkred") + " : " + tileSpotLight.get(TileEntitySpotLight.DARKREDKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 185, y + 70, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_GREEN + I18n.format("container.spotlight.darkgreen") + " : " + tileSpotLight.get(TileEntitySpotLight.DARKGREENKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 185, y + 80, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.DARK_BLUE + I18n.format("container.spotlight.darkblue") + " : " + tileSpotLight.get(TileEntitySpotLight.DARKBLUEKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 185, y + 90, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 1 : " + tileSpotLight.get(TileEntitySpotLight.ANGLE1KEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 100, y + 100, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.angle") + " 2 : " + tileSpotLight.get(TileEntitySpotLight.ANGLE2KEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 185, y + 100, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotate") + " : " + (tileSpotLight.get(TileEntitySpotLight.AUTOROTATEKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)) == 0 ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 110, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationspeed") + " : " + tileSpotLight.get(TileEntitySpotLight.ROTATIONSPEED, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)), x + 100, y + 120, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.rotationreverse") + " : " + (tileSpotLight.get(TileEntitySpotLight.SECONDARYLAZERKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)) == 1 ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 130, 0xffffff);
				this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + I18n.format("container.spotlight.secondlazer") + " : " + (tileSpotLight.get(TileEntitySpotLight.REVERSEROTATIONKEY, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON)) == 0 ? I18n.format("container.spotlight.true") : I18n.format("container.spotlight.false")), x + 100, y + 140, 0xffffff);
			}
		}
	}

}