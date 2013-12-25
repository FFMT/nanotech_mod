package fr.mcnanotech.kevin_68.nanotech_mod.city.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerTextSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;

public class GuiTextSpotLight extends FFMTGuiContainerSliderBase
{	
	protected TileEntityTextSpotLight tileTextSpotLight;

	public GuiTextSpotLight(InventoryPlayer playerInventory, TileEntityTextSpotLight tileEntity, World world)
	{
		super(new ContainerTextSpotLight(tileEntity, playerInventory, world));
		tileTextSpotLight = tileEntity;
	}
	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{

	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return null;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{

	}
}