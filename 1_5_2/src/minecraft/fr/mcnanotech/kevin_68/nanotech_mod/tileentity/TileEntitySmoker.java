package fr.mcnanotech.kevin_68.nanotech_mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmoker extends TileEntity
{
	public static int Smokepower;

	public TileEntitySmoker()
	{
		if (Smokepower > 15)
		{
			Smokepower = 15;
		}
		if (Smokepower < 0)
		{
			Smokepower = 0;
		}
	}

	public int getSmokePower()
	{
		return Smokepower;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
	    if (tagCompound.hasKey("Power"))
	    {
			Smokepower = tagCompound.getInteger("Power");
	    }
	    else
	    {
	    	Smokepower = 0;
	    }
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("Smokepower", 0);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		NBTTagCompound tag = pkt.customParam1;
		this.readFromNBT(tag);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, tag);
	}
}
