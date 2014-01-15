package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiSmoker extends FFMTGuiContainerSliderBase
{
	private TileEntitySmoker tileSmoker;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/smoker.png");

	public GuiSmoker(InventoryPlayer playerinventory, TileEntitySmoker tileentity, World world)
	{
		super(new ContainerSmoker(tileentity, playerinventory, world));
		tileSmoker = tileentity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x - 75, y + 20, I18n.getStringParams("container.smoker.power", tileSmoker.getSmokeValue()), (float)(tileSmoker.getSmokeValue()) / 15.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		this.sendSmokerPacket((int)(sliderValue * 15));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return I18n.getStringParams("container.smoker.power", +(int)(sliderValue * 15));
	}

	private void sendSmokerPacket(int value)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTM|smoker", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to send a packet from a Smoker");
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString(I18n.getString("container.smoker"), 6, 6, 4210752);
		fontRenderer.drawString(I18n.getString("container.inventory"), 6, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}