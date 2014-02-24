/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

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
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbt);
	}

	public void setSmokeInt(int newValue)
	{
		Smokepower = newValue;
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public int getSmokeValue()
	{
		return this.Smokepower;
	}
}