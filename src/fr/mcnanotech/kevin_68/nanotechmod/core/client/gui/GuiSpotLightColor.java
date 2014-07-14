package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
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

		this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 15, 256, 20, "Red : " + tileSpotLight.get(0), (float)(tileSpotLight.get(0)) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 7, 256, 20, "Green : " + tileSpotLight.get(1), (float)(tileSpotLight.get(1)) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 2, x - 40, y + 29, 256, 20, "Blue : " + tileSpotLight.get(2), (float)(tileSpotLight.get(2)) / 255.0F));

		this.buttonList.add(new GuiSliderForContainer(this, 3, x - 40, y + 51, 256, 20, "Red : " + tileSpotLight.get(3), (float)(tileSpotLight.get(3)) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 4, x - 40, y + 73, 256, 20, "Green : " + tileSpotLight.get(4), (float)(tileSpotLight.get(4)) / 255.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 5, x - 40, y + 95, 256, 20, "Blue : " + tileSpotLight.get(5), (float)(tileSpotLight.get(5)) / 255.0F));

		this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, "Back"));
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
		PacketSender.sendSpotLightPacket(tileSpotLight, sliderId, (int)(sliderValue * 255.0F));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
		{
		case 0:
		{
			name = "Red : " + (int)(sliderValue * 255.0F);
			break;
		}
		case 1:
		{
			name = "Green : " + (int)(sliderValue * 255.0F);
			break;
		}
		case 2:
		{
			name = "Blue : " + (int)(sliderValue * 255.0F);
			break;
		}
		case 3:
		{
			name = "Red : " + (int)(sliderValue * 255.0F);
			break;
		}
		case 4:
		{
			name = "Green : " + (int)(sliderValue * 255.0F);
			break;
		}
		case 5:
		{
			name = "Blue : " + (int)(sliderValue * 255.0F);
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