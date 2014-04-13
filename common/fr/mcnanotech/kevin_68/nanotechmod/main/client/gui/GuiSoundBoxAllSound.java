package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;

public class GuiSoundBoxAllSound extends GuiListBase
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	private GuiSoundBoxList guiSBList;

	public GuiSoundBoxAllSound(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
	}
	
    public void initGui()
    {
    //	guiSBList = new GuiSoundBoxList(eee, this, this.mc, 100, 100, 20, 30);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		
	}
	
	@Override
	public void handlerListAction(ArrayList<BaseNTMEntry> list, int slotId, boolean doubleClick, int mouseX, int mouseY)
	{

	}
}