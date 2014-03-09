/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

@SuppressWarnings("rawtypes")
public class TileEntityListerJukebox extends TileEntity
{
	private int modidSelected;
	private String txt;

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("ModidSelected", modidSelected);
		if(txt != null && txt.isEmpty())
		{
			nbtTagCompound.setString("NameTyped", txt);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		modidSelected = nbtTagCompound.getInteger("ModidSelected");
		txt = nbtTagCompound.getString("NameTyped");
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

	public void set(int index, int value)
	{
		if(index == 0)
		{
			modidSelected = value;
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void set(String text)
	{
		txt = text;
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public int get(int index)
	{
		if(index == 0)
		{
			return modidSelected;
		}
		else
		{
			return -1;
		}
	}

	public String getName()
	{
		return txt;
	}

}