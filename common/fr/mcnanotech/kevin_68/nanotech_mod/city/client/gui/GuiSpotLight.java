package fr.mcnanotech.kevin_68.nanotech_mod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.minecraftforgefrance.ffmtlibs.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.GuiSliderForContainer;

public class GuiSpotLight extends GuiContainerSliderBase
{
	protected TileEntitySpotLight tileSpotLight;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city:textures/gui/SpotLight.png");

	public GuiSpotLight(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World world)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, world));
		tileSpotLight = tileEntity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.RED + "red" + " : "+ tileSpotLight.getRedValue(), (float)(tileSpotLight.getRedValue()) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.GREEN + "green" + " : "+ tileSpotLight.getGreenValue(), (float)(tileSpotLight.getGreenValue()) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.BLUE + "blue" + " : "+ tileSpotLight.getBlueValue(), (float)(tileSpotLight.getBlueValue()) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.DARK_RED + "dark red" + " : "+ tileSpotLight.getDarkRedValue(), (float)(tileSpotLight.getDarkRedValue()) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.DARK_GREEN + "dark green" + " : "+ tileSpotLight.getDarkGreenValue(), (float)(tileSpotLight.getDarkGreenValue()) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.DARK_BLUE + "dark blue" + " : "+ tileSpotLight.getDarkBlueValue(), (float)(tileSpotLight.getDarkBlueValue()) / 255.0F));
	}
	
	@Override
	public void handlerSliderAction(int sladerId, float sladerValue)
	{
		this.sendSpotLightPacket((int)(sladerValue * 255), sladerId);
	}

	@Override
	public String getSladerName(int sladerId, float sladerValue)
	{
		String name = "";
		switch(sladerId)
		{
		case 0:
			name = EnumChatFormatting.RED + "red" + " : ";
			break;
		case 1:
			name = EnumChatFormatting.GREEN + "green" + " : ";
			break;
		case 2:
			name = EnumChatFormatting.BLUE + "blue" + " : ";
			break;
		case 3:
			name = EnumChatFormatting.DARK_RED + "dark red" + " : ";
			break;
		case 4:
			name = EnumChatFormatting.DARK_GREEN + "dark green" + " : ";
			break;
		case 5:
			name = EnumChatFormatting.DARK_BLUE + "dark blue" + " : ";
			break;
		}
		return name + (int)(sladerValue * 255);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
	}

	private void sendSpotLightPacket(int value, int type)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(type);
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTMC|light", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to send a packet from a SpotLight");
		}
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