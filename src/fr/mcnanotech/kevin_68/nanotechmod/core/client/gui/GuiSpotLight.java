package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;

public class GuiSpotLight extends GuiContainer
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlight.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;
	public GuiBooleanButton timeButton;

	public GuiSpotLight(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}
	
	public void initGui()
	{
		super.initGui();
//		this.xSize = 256;
//		this.ySize = 256;
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;	
		
		this.buttonList.add(new GuiButton(0, x + 5, y + 20, 80, 20, "Color"));
		this.buttonList.add(new GuiButton(1, x + 90, y + 20, 80, 20, "Texture"));
		this.buttonList.add(new GuiButton(2, x + 5, y + 45, 80, 20, "Beam Specs"));
		this.buttonList.add(new GuiButton(3, x + 5, y + 70, 80, 20, "TimeLine config"));
		this.buttonList.add(timeButton = new GuiBooleanButton(4, x + 90, y + 70, 80, 20, "TimeLine On", "TimeLine Off", tileSpotLight.isTimeLineEnabled()));
	}
	
	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(new GuiSpotLightColor(invPlayer, tileSpotLight, world));
			break;
		}
		case 1:
		{
			this.mc.displayGuiScreen(new GuiSpotLightTexture(invPlayer, tileSpotLight, world));
			break;
		}
		case 2:
		{
			this.mc.displayGuiScreen(new GuiSpotLightBeamSpec(invPlayer, tileSpotLight, world));
			break;
		}
		case 3:
		{
			this.mc.displayGuiScreen(new GuiSpotLightTimeLine(invPlayer, tileSpotLight, world));
			break;
		}
		case 4:
		{
			timeButton.toggle();
			PacketSender.sendSpotLightPacket(this.tileSpotLight, 22, timeButton.getIsActive() ? 1 : 0);
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}