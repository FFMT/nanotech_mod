package fr.mcnanotech.kevin_68.nanotech_mod.city.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityOnlineJukebox;

public class ContainerOnlineJukebox extends Container
{
	protected TileEntityOnlineJukebox tileOnlineJukebox;
	private World worldObj;

	public ContainerOnlineJukebox(TileEntityOnlineJukebox tileEntity, InventoryPlayer inventoryPlayer, World world)
	{
		this.worldObj = world;
		this.tileOnlineJukebox = tileEntity;
		bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileOnlineJukebox.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
	{

		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	public TileEntityOnlineJukebox getFountain()
	{
		return tileOnlineJukebox;
	}
}