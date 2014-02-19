/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;

@SuppressWarnings("unused")
public class ContainerSmoker extends Container
{
	protected TileEntitySmoker smoker;
	private World worldObj;

	public ContainerSmoker(TileEntitySmoker tileentity, InventoryPlayer playerinventory, World world)
	{
		this.worldObj = world;
		this.smoker = tileentity;
		bindPlayerInventory(playerinventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return smoker.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer player_inventory)
	{
		int var6;
		int var7;
		for(var6 = 0; var6 < 3; ++var6)
		{
			for(var7 = 0; var7 < 9; ++var7)
			{
				this.addSlotToContainer(new Slot(player_inventory, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
			}
		}

		for(var6 = 0; var6 < 9; ++var6)
		{
			this.addSlotToContainer(new Slot(player_inventory, var6, 8 + var6 * 18, 142));
		}
	}

	public TileEntitySmoker getSmoker()
	{
		return smoker;
	}
}
