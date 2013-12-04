package fr.mcnanotech.kevin_68.nanotech_mod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
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
        
		/*
		buttonList.add(new GuiButton(0, width / 2 - 30, y + 7, 20, 20, EnumChatFormatting.RED + "-1"));
		buttonList.add(new GuiButton(1, width / 2 - 58, y + 7, 20, 20, EnumChatFormatting.RED + "-10"));
		buttonList.add(new GuiButton(2, width / 2 - 86, y + 7, 25, 20, EnumChatFormatting.RED + "-100"));
		buttonList.add(new GuiButton(3, width / 2 + 10, y + 7, 20, 20, EnumChatFormatting.RED + "+1"));
		buttonList.add(new GuiButton(4, width / 2 + 38, y + 7, 20, 20, EnumChatFormatting.RED + "+10"));
		buttonList.add(new GuiButton(5, width / 2 + 61, y + 7, 25, 20, EnumChatFormatting.RED + "+100"));

		buttonList.add(new GuiButton(6, width / 2 - 30, y + 29, 20, 20, EnumChatFormatting.GREEN + "-1"));
		buttonList.add(new GuiButton(7, width / 2 - 58, y + 29, 20, 20, EnumChatFormatting.GREEN + "-10"));
		buttonList.add(new GuiButton(8, width / 2 - 86, y + 29, 25, 20, EnumChatFormatting.GREEN + "-100"));
		buttonList.add(new GuiButton(9, width / 2 + 10, y + 29, 20, 20, EnumChatFormatting.GREEN + "+1"));
		buttonList.add(new GuiButton(10, width / 2 + 38, y + 29, 20, 20, EnumChatFormatting.GREEN + "+10"));
		buttonList.add(new GuiButton(11, width / 2 + 61, y + 29, 25, 20, EnumChatFormatting.GREEN + "+100"));

		buttonList.add(new GuiButton(12, width / 2 - 30, y + 51, 20, 20, EnumChatFormatting.BLUE + "-1"));
		buttonList.add(new GuiButton(13, width / 2 - 58, y + 51, 20, 20, EnumChatFormatting.BLUE + "-10"));
		buttonList.add(new GuiButton(14, width / 2 - 86, y + 51, 25, 20, EnumChatFormatting.BLUE + "-100"));
		buttonList.add(new GuiButton(15, width / 2 + 10, y + 51, 20, 20, EnumChatFormatting.BLUE + "+1"));
		buttonList.add(new GuiButton(16, width / 2 + 38, y + 51, 20, 20, EnumChatFormatting.BLUE + "+10"));
		buttonList.add(new GuiButton(17, width / 2 + 61, y + 51, 25, 20, EnumChatFormatting.BLUE + "+100"));

		buttonList.add(new GuiButton(18, width / 2 - 30, y + 73, 20, 20, EnumChatFormatting.DARK_RED + "-1"));
		buttonList.add(new GuiButton(19, width / 2 - 58, y + 73, 20, 20, EnumChatFormatting.DARK_RED + "-10"));
		buttonList.add(new GuiButton(20, width / 2 - 86, y + 73, 25, 20, EnumChatFormatting.DARK_RED + "-100"));
		buttonList.add(new GuiButton(21, width / 2 + 10, y + 73, 20, 20, EnumChatFormatting.DARK_RED + "+1"));
		buttonList.add(new GuiButton(22, width / 2 + 38, y + 73, 20, 20, EnumChatFormatting.DARK_RED + "+10"));
		buttonList.add(new GuiButton(23, width / 2 + 61, y + 73, 25, 20, EnumChatFormatting.DARK_RED + "+100"));

		buttonList.add(new GuiButton(24, width / 2 - 30, y + 95, 20, 20, EnumChatFormatting.DARK_GREEN + "-1"));
		buttonList.add(new GuiButton(25, width / 2 - 58, y + 95, 20, 20, EnumChatFormatting.DARK_GREEN + "-10"));
		buttonList.add(new GuiButton(26, width / 2 - 86, y + 95, 25, 20, EnumChatFormatting.DARK_GREEN + "-100"));
		buttonList.add(new GuiButton(27, width / 2 + 10, y + 95, 20, 20, EnumChatFormatting.DARK_GREEN + "+1"));
		buttonList.add(new GuiButton(28, width / 2 + 38, y + 95, 20, 20, EnumChatFormatting.DARK_GREEN + "+10"));
		buttonList.add(new GuiButton(29, width / 2 + 61, y + 95, 25, 20, EnumChatFormatting.DARK_GREEN + "+100"));

		buttonList.add(new GuiButton(30, width / 2 - 30, y + 117, 20, 20, EnumChatFormatting.DARK_BLUE + "-1"));
		buttonList.add(new GuiButton(31, width / 2 - 58, y + 117, 20, 20, EnumChatFormatting.DARK_BLUE + "-10"));
		buttonList.add(new GuiButton(32, width / 2 - 86, y + 117, 25, 20, EnumChatFormatting.DARK_BLUE + "-100"));
		buttonList.add(new GuiButton(33, width / 2 + 10, y + 117, 20, 20, EnumChatFormatting.DARK_BLUE + "+1"));
		buttonList.add(new GuiButton(34, width / 2 + 38, y + 117, 20, 20, EnumChatFormatting.DARK_BLUE + "+10"));
		buttonList.add(new GuiButton(35, width / 2 + 61, y + 117, 25, 20, EnumChatFormatting.DARK_BLUE + "+100"));
		*/
	}
	
	@Override
	public void handlerSliderAction(int sladerId, float sladerValue)
	{
		this.sendSpotLightPacket((int)(sladerValue * 255), sladerId);
	}

	@Override
	public String getSladerName(int sladerId, float sladerValue)
	{
		if(sladerId == 0)
		{
			return EnumChatFormatting.RED + "red" + " : " + (int)(sladerValue * 255);
		}
		return null;
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		// Type : 0 = red, 1 = green, 2 = blue, 3 = dark red, 4 = dark green, 5
		// = dark blue
		if(guibutton.id == 0)
		{
			if(tileSpotLight.getRedValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() - 1, 0);
			}
		}
		if(guibutton.id == 1)
		{

			if(tileSpotLight.getRedValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() - 10, 0);
			}
			else
			{
				this.setToMin(0);
			}
		}
		if(guibutton.id == 2)
		{

			if(tileSpotLight.getRedValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() - 100, 0);
			}
			else
			{
				this.setToMin(0);
			}
		}
		if(guibutton.id == 3)
		{
			if(tileSpotLight.getRedValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() + 1, 0);
			}
		}
		if(guibutton.id == 4)
		{
			if(tileSpotLight.getRedValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() + 10, 0);
			}
			else
			{
				this.setToMax(0);
			}
		}
		if(guibutton.id == 5)
		{
			if(tileSpotLight.getRedValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getRedValue() + 100, 0);
			}
			else
			{
				this.setToMax(0);
			}
		}

		if(guibutton.id == 6)
		{
			if(tileSpotLight.getGreenValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() - 1, 1);
			}
		}
		if(guibutton.id == 7)
		{
			if(tileSpotLight.getGreenValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() - 10, 1);
			}
			else
			{
				this.setToMin(1);
			}
		}
		if(guibutton.id == 8)
		{
			if(tileSpotLight.getGreenValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() - 100, 1);
			}
			else
			{
				this.setToMin(1);
			}
		}
		if(guibutton.id == 9)
		{
			if(tileSpotLight.getGreenValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() + 1, 1);
			}
		}
		if(guibutton.id == 10)
		{
			if(tileSpotLight.getGreenValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() + 10, 1);
			}
			else
			{
				this.setToMax(1);
			}
		}
		if(guibutton.id == 11)
		{
			if(tileSpotLight.getGreenValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getGreenValue() + 100, 1);
			}
			else
			{
				this.setToMax(1);
			}
		}

		if(guibutton.id == 12)
		{
			if(tileSpotLight.getBlueValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() - 1, 2);
			}
		}
		if(guibutton.id == 13)
		{
			if(tileSpotLight.getBlueValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() - 10, 2);
			}
			else
			{
				this.setToMin(2);
			}
		}
		if(guibutton.id == 14)
		{
			if(tileSpotLight.getBlueValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() - 100, 2);
			}
			else
			{
				this.setToMin(2);
			}
		}
		if(guibutton.id == 15)
		{
			if(tileSpotLight.getBlueValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() + 1, 2);
			}
		}
		if(guibutton.id == 16)
		{
			if(tileSpotLight.getBlueValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() + 10, 2);
			}
			else
			{
				this.setToMax(2);
			}
		}
		if(guibutton.id == 17)
		{
			if(tileSpotLight.getBlueValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getBlueValue() + 100, 2);
			}
			else
			{
				this.setToMax(2);
			}
		}

		if(guibutton.id == 18)
		{
			if(tileSpotLight.getDarkRedValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() - 1, 3);
			}
		}
		if(guibutton.id == 19)
		{

			if(tileSpotLight.getDarkRedValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() - 10, 3);
			}
			else
			{
				this.setToMin(3);
			}
		}
		if(guibutton.id == 20)
		{

			if(tileSpotLight.getDarkRedValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() - 100, 3);
			}
			else
			{
				this.setToMin(3);
			}
		}
		if(guibutton.id == 21)
		{
			if(tileSpotLight.getDarkRedValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() + 1, 3);
			}
		}
		if(guibutton.id == 22)
		{
			if(tileSpotLight.getDarkRedValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() + 10, 3);
			}
			else
			{
				this.setToMax(3);
			}
		}
		if(guibutton.id == 23)
		{
			if(tileSpotLight.getDarkRedValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkRedValue() + 100, 3);
			}
			else
			{
				this.setToMax(3);
			}
		}

		if(guibutton.id == 24)
		{
			if(tileSpotLight.getDarkGreenValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() - 1, 4);
			}
		}
		if(guibutton.id == 25)
		{
			if(tileSpotLight.getDarkGreenValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() - 10, 4);
			}
			else
			{
				this.setToMin(4);
			}
		}
		if(guibutton.id == 26)
		{
			if(tileSpotLight.getDarkGreenValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() - 100, 4);
			}
			else
			{
				this.setToMin(4);
			}
		}
		if(guibutton.id == 27)
		{
			if(tileSpotLight.getDarkGreenValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() + 1, 4);
			}
		}
		if(guibutton.id == 28)
		{
			if(tileSpotLight.getDarkGreenValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() + 10, 4);
			}
			else
			{
				this.setToMax(4);
			}
		}
		if(guibutton.id == 29)
		{
			if(tileSpotLight.getDarkGreenValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkGreenValue() + 100, 4);
			}
			else
			{
				this.setToMax(4);
			}
		}

		if(guibutton.id == 30)
		{
			if(tileSpotLight.getDarkBlueValue() > 0)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() - 1, 5);
			}
		}
		if(guibutton.id == 31)
		{
			if(tileSpotLight.getDarkBlueValue() > 10)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() - 10, 5);
			}
			else
			{
				this.setToMin(5);
			}
		}
		if(guibutton.id == 32)
		{
			if(tileSpotLight.getDarkBlueValue() > 100)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() - 100, 5);
			}
			else
			{
				this.setToMin(5);
			}
		}
		if(guibutton.id == 33)
		{
			if(tileSpotLight.getDarkBlueValue() < 255)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() + 1, 5);
			}
		}
		if(guibutton.id == 34)
		{
			if(tileSpotLight.getDarkBlueValue() < 245)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() + 10, 5);
			}
			else
			{
				this.setToMax(5);
			}
		}
		if(guibutton.id == 35)
		{
			if(tileSpotLight.getDarkBlueValue() < 155)
			{
				this.sendSpotLightPacket(tileSpotLight.getDarkBlueValue() + 100, 5);
			}
			else
			{
				this.setToMax(5);
			}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
	}

	private void setToMax(int type)
	{
		this.sendSpotLightPacket(255, type);
	}

	private void setToMin(int type)
	{
		this.sendSpotLightPacket(0, type);
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