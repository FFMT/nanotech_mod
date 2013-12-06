package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerLightSaber;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

@SideOnly(Side.CLIENT)
public class GuiLightSaber extends FFMTGuiContainerSliderBase
{

	public GuiLightSaber(EntityPlayer player)
	{
		super(new ContainerLightSaber(player.inventory, player.worldObj));
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
	}
	
	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return "Test";
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
	}
}