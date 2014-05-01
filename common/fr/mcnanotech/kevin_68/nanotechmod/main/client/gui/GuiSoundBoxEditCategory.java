package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;

public class GuiSoundBoxEditCategory extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	public CategoryEntry entry;

	public GuiSoundBoxEditCategory(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, CategoryEntry entry)
	{
		super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.entry = entry;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{

	}
}