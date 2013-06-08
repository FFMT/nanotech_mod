package fr.mcnanotech.kevin_68.nanotech_mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityJumper;

public class ContainerJumper extends Container
{
	protected TileEntityJumper tile_entity;
	private World worldObj;
           
	public ContainerJumper(TileEntityJumper tile_entity, InventoryPlayer playerinventory, World world)
	{
		this.worldObj = world;
		this.tile_entity = tile_entity;
		bindPlayerInventory(playerinventory);
	}
           
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile_entity.isUseableByPlayer(player);
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) 
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++) 
			{
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) 
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
}
     