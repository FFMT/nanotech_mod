package fr.mcnanotech.kevin_68.nanotech_mod.city.container;

import net.minecraft.client.Minecraft;
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
		addSlotToContainer(new Slot(tileEntity, 1, 0, 114));
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
			addSlotToContainer(new Slot(inventoryPlayer, i, 11 + i * 18, 141));
		}
	}

	public TileEntitySpotLight getSpotLight()
	{
		return tileSpotLight;
	}
}