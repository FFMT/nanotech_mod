package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightColor extends GuiContainerSliderBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlighttex.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;

	public GuiSpotLightColor(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}

	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 20, 256, 20, I18n.format("container.spotlight.red") + " : " + (tileSpotLight.getRed() & 0xFF), (float)(tileSpotLight.getRed() & 0xFF) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 2, 256, 20, I18n.format("container.spotlight.green") + " : " + (tileSpotLight.getGreen() & 0xFF), (float)(tileSpotLight.getGreen() & 0xFF) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 2, x - 40, y + 25, 256, 20, I18n.format("container.spotlight.blue") + " : " + (tileSpotLight.getBlue() & 0xFF), (float)(tileSpotLight.getBlue() & 0xFF) / 255.0F));

		this.buttonList.add(new GuiSliderForContainer(this, 3, x - 40, y + 47, 256, 20, I18n.format("container.spotlight.red") + " : " + (tileSpotLight.getSecRed() & 0xFF), (float)(tileSpotLight.getSecRed() & 0xFF) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 4, x - 40, y + 69, 256, 20, I18n.format("container.spotlight.green") + " : " + (tileSpotLight.getSecGreen() & 0xFF), (float)(tileSpotLight.getSecGreen() & 0xFF) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 5, x - 40, y + 91, 256, 20, I18n.format("container.spotlight.blue") + " : " + (tileSpotLight.getSecBlue() & 0xFF), (float)(tileSpotLight.getSecBlue() & 0xFF) / 255.0F));

		this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, I18n.format("container.spotlight.back")));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 6:
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
			break;
		}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)sliderId, (byte)(sliderValue * 255.0F));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
		{
		case 0:
		{
			name = I18n.format("container.spotlight.red") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		case 1:
		{
			name = I18n.format("container.spotlight.green") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		case 2:
		{
			name = I18n.format("container.spotlight.blue") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		case 3:
		{
			name = I18n.format("container.spotlight.red") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		case 4:
		{
			name = I18n.format("container.spotlight.green") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		case 5:
		{
			name = I18n.format("container.spotlight.blue") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
			break;
		}
		}
		return name;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}