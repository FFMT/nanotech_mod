package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiSoundBoxListBase extends GuiContainer
{

	public GuiSoundBoxListBase(Container container)
	{
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
	}
	
	public void setSelected(BaseNTMEntry entry)
	{
	}
}