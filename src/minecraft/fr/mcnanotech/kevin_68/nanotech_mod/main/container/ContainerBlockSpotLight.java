package fr.mcnanotech.kevin_68.nanotech_mod.main.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockSpotLight;

public class ContainerBlockSpotLight extends Container
{
	protected TileEntityBlockSpotLight tile_entity;
	private World worldObj;

	public ContainerBlockSpotLight(TileEntityBlockSpotLight tile_entity, InventoryPlayer playerinventory, World world)
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

		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
}
