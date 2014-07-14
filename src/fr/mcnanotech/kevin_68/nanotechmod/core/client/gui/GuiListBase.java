package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight.BaseListEntry;

public class GuiListBase extends GuiContainer
{

	public GuiListBase(Container container)
	{
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{}

	public void setSelected(BaseListEntry entry)
	{}
}