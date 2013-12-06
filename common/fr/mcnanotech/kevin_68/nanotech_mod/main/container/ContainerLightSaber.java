package fr.mcnanotech.kevin_68.nanotech_mod.main.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;

public class ContainerLightSaber extends Container
{
	private World worldObj;

	public ContainerLightSaber(InventoryPlayer playerinventory, World world)
	{
		this.worldObj = world;
		bindPlayerInventory(playerinventory);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
	{
		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}
}