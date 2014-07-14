/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;

public class GuiSpotLightConfirm extends GuiContainer
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlightconfirm.png");

	private String action;
	private String yes;
	private String no;
	private int guiopen;
	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;

	public GuiSpotLightConfirm(TileEntitySpotLight tile, InventoryPlayer invplay, World world, String actionname, String yesbutton, String nobutton, int guiid)
	{
		super(new ContainerSpotLight(tile, invplay, world));
		action = actionname;
		yes = yesbutton;
		no = nobutton;
		guiopen = guiid;
		invPlayer = invplay;
		tileSpotLight = tile;
		this.world = world;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(1, x + 13, y + 90, 150, 20, yes));
		this.buttonList.add(new GuiButton(2, x + 13, y + 115, 150, 20, no));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			if(guiopen == 0)
			{
				PacketSender.sendSpotLightPacket(tileSpotLight, 0, tileSpotLight.get(20), 0);
				this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
			}
			else
			{
				PacketSender.sendSpotLightPacket(tileSpotLight, 0, tileSpotLight.get(20), 0);
				createKey(tileSpotLight.get(37));
				this.mc.displayGuiScreen(new GuiSpotLightCreateKey(invPlayer, tileSpotLight, world));
			}
		}
		else
		{
			if(guiopen == 0)
			{
				this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
			}
			else
			{
				this.mc.displayGuiScreen(new GuiSpotLightCreateKey(invPlayer, tileSpotLight, world));
			}
		}
	}

	public void createKey(int time)
	{
		PacketSender.sendSpotLightPacket(tileSpotLight, 21, 1, time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 25, tileSpotLight.get(0), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 26, tileSpotLight.get(1), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 27, tileSpotLight.get(2), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 28, tileSpotLight.get(3), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 29, tileSpotLight.get(4), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 30, tileSpotLight.get(5), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 31, tileSpotLight.get(6), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 32, tileSpotLight.get(7), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 33, tileSpotLight.get(8), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 34, tileSpotLight.get(9), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 35, tileSpotLight.get(10), time);
		PacketSender.sendSpotLightPacket(tileSpotLight, 36, tileSpotLight.get(11), time);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		this.drawCenteredString(this.fontRendererObj, action, width / 2, y + 10, 0xff0000);
	}
}