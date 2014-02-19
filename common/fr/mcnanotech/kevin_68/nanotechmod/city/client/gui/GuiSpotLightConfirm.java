/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight2;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;

public class GuiSpotLightConfirm extends GuiContainer
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmodcity:textures/gui/spotlightconfirm.png");

	private String action;
	private String yes;
	private String no;
	private int guiopen;
	protected InventoryPlayer invPlayer;
	protected TileEntitySpotLight tileSpotLight;
	protected World world;

	public GuiSpotLightConfirm(TileEntitySpotLight tile, InventoryPlayer invplay, World world, String actionname, String yesbutton, String nobutton, int guiid)
	{
		super(new ContainerSpotLight2(tile, invplay, world));
		action = actionname;
		yes = yesbutton;
		no = nobutton;
		guiopen = guiid;
		invPlayer = invplay;
		tileSpotLight = tile;
		this.world = world;
	}

	@SuppressWarnings("unchecked")
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
				sendKeyPacket(0, 0, tileSpotLight.get(TileEntitySpotLight.SELECTEDBUTTON));
				this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
			}
			else
			{
				sendKeyPacket(0, 0, tileSpotLight.get(TileEntitySpotLight.CREATEKEYTIME));
				createKey(tileSpotLight.get(TileEntitySpotLight.CREATEKEYTIME));
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
			// NanotechModCity.nanoLog.severe("Failed to send a packet from a SpotLight Key");
		}
	}

	public void createKey(int time)
	{
		sendKeyPacket(1, 0, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.RED), 1, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.GREEN), 2, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.BLUE), 3, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.DARKRED), 4, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.DARKGREEN), 5, time);
		sendKeyPacket(tileSpotLight.get(TileEntitySpotLight.DARKBLUE), 6, time);
		// TODO END THIS
		// this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer,
		// tileSpotLight, world));
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