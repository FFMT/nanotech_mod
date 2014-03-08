/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerLightSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.ItemLightSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

@SideOnly(Side.CLIENT)
@SuppressWarnings({"unchecked"})
public class GuiLightSaber extends FFMTGuiContainerSliderBase
{
	private final ItemStack saberStack;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/lightsaber.png");

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
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, width / 2 - 75, y + 7, EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + " : " + red, (float)(red) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 1, width / 2 - 75, y + 29, EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + " : " + green, (float)(green) / 255.0F));
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 2, width / 2 - 75, y + 51, EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + " : " + blue, (float)(blue) / 255.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		NTMPacketHelper.sendPacket(sliderId, (int)(sliderValue * 255));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
		{
		case 0:
			name = EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + " : ";
			break;
		case 1:
			name = EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + " : ";
			break;
		case 2:
			name = EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + " : ";
			break;
		}
		return name + (int)(sliderValue * 255);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
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