package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPresent extends TileEntity
{
	private int presentId = 1, presentMeta;

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("id", presentId);
		nbtTagCompound.setInteger("meta", presentMeta);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		presentId = nbtTagCompound.getInteger("id");
		presentMeta = nbtTagCompound.getInteger("meta");
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 4, nbttagcompound);
	}

	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		this.readFromNBT(pkt.data);
	}

	public void setPresent(int id, int meta)
	{
		presentId = id;
		presentMeta = meta;
	}

	public int getPresentId()
	{
		return presentId;
	}

	public int getPresentMeta()
	{
		return presentMeta;
	}
}