package fr.mcnanotech.kevin_68.nanotech_mod.city.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;

public class ContainerSpotLight extends Container
{
	protected TileEntitySpotLight tileSpotLight;
	private World worldObj;

	public ContainerSpotLight(TileEntitySpotLight tileEntity, InventoryPlayer inventoryPlayer, World world)
	{
		this.worldObj = world;
		this.tileSpotLight = tileEntity;
		bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileSpotLight.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
	{

		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	public TileEntitySpotLight getSpotLight()
	{
		return tileSpotLight;
	}
}
