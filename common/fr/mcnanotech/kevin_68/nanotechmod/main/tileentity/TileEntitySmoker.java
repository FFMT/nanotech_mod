package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntitySmoker extends TileEntity
{
	public int Smokepower;
	public static final Random random = new Random();

	public void updateEntity()
	{
		for(int i = 0; i < getSmokeValue(); i++)
		{
			float f = (float)xCoord + random.nextFloat();
			float f1 = (float)((float)yCoord + random.nextFloat() * 0.5F + 0.5F);
			float f2 = (float)zCoord + random.nextFloat();
			this.worldObj.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.002D * i, 0.0D);
		}
	}
	
	
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("Smoke", Smokepower);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		Smokepower = nbtTagCompound.getInteger("Smoke");
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

	public void setSmokeInt(int newValue)
	{
		Smokepower = newValue;
	}

	public int getSmokeValue()
	{
		return this.Smokepower;
	}
}