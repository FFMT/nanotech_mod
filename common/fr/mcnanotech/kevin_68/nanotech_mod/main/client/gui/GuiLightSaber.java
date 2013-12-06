package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerLightSaber;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.ItemLightSaber;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

@SideOnly(Side.CLIENT)
public class GuiLightSaber extends FFMTGuiContainerSliderBase
{
	private final ItemStack saberStack;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod:textures/gui/lightsaber.png");

	public GuiLightSaber(EntityPlayer player)
	{
		super(new ContainerLightSaber(player.inventory, player.worldObj));
		saberStack = player.getCurrentEquippedItem();
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		if(!saberStack.hasTagCompound())
		{
			saberStack.setTagCompound(new NBTTagCompound());
		}
		int red = saberStack.getTagCompound().hasKey("red") ? saberStack.getTagCompound().getInteger("red") : 0;
		int green = saberStack.getTagCompound().hasKey("green") ? saberStack.getTagCompound().getInteger("green") : 0;
		int blue = saberStack.getTagCompound().hasKey("blue") ? saberStack.getTagCompound().getInteger("blue") : 0;
		System.out.println("red " + red + " | green : " + green + " | blue : " + blue);
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.RED + "red" + " : " + red, (float)(red) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 1, width / 2 - 75, y + 29, EnumChatFormatting.GREEN + "green" + " : " + green, (float)(green) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 2, width / 2 - 75, y + 51, EnumChatFormatting.BLUE + "blue" + " : " + blue, (float)(blue) / 255.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		this.sendSaberPacket((int)(sliderValue * 255), sliderId);
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
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
		}
		return name + (int)(sliderValue * 255);
	}

	private void sendSaberPacket(int value, int type)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(type);
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTM|saber", bytearrayoutputstream.toByteArray()));
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

	public void updateScreen()
	{
		super.updateScreen();
		if(this.mc.thePlayer.getCurrentEquippedItem() == null || !(this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemLightSaber))
		{
			this.mc.thePlayer.closeScreen();
		}
	}
}