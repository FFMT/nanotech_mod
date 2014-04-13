package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;

public class GuiListBase extends GuiContainer
{
	public GuiListBase(Container par1Container)
	{
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{}

	public void handlerListAction(ArrayList<BaseNTMEntry> list, int slotId, boolean doubleClick, int mouseX, int mouseY)
	{}
}