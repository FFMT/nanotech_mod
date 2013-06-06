package fr.mcnanotech.kevin_68.nanotech_mod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;

import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntitySmoker;

public class ContainerSmoker extends Container
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
       
	protected TileEntitySmoker tileentity;
	private World worldObj;
           
	public ContainerSmoker(TileEntitySmoker tileentity, InventoryPlayer playerinventory, World world)
	{
		this.worldObj = world;
		this.tileentity = tileentity;
		
		bindPlayerInventory(playerinventory);
	}
           
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileentity.isUseableByPlayer(player);
	}
	
	protected void bindPlayerInventory(InventoryPlayer player_inventory)
	{              
		int var6;
		int var7;
		for (var6 = 0; var6 < 3; ++var6)
		{
			for (var7 = 0; var7 < 9; ++var7)
			{
				this.addSlotToContainer(new Slot(player_inventory, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 9; ++var6)
		{
			this.addSlotToContainer(new Slot(player_inventory, var6, 8 + var6 * 18, 142));
		}
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}
}
     