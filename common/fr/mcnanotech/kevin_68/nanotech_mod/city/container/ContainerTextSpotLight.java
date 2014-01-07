package fr.mcnanotech.kevin_68.nanotech_mod.city.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;

public class ContainerTextSpotLight extends Container
{
	protected TileEntityTextSpotLight tileTextSpotLight;
	private World worldObj;

	public ContainerTextSpotLight(TileEntityTextSpotLight tileEntity, InventoryPlayer inventoryPlayer, World world)
	{
		this.worldObj = world;
		this.tileTextSpotLight = tileEntity;
		addSlotToContainer(new Slot(tileEntity, 1, 0, 115));
		bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileTextSpotLight.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
	{
		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 11 + i * 18, 142));
		}
	}

	public TileEntityTextSpotLight getSpotLight()
	{
		return tileTextSpotLight;
	}
}