package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySatelite;

public class TileEntityButton extends TileEntity
{
	public boolean sateliteIsFalling = false;;
	
	public void updateEntity()
	{
		
	}
	
	public void crashSatelite()
	{
		if(!sateliteIsFalling)
		{
			if(monitorNextToPad(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
			{
				this.worldObj.spawnEntityInWorld(new EntitySatelite(this.worldObj, this.xCoord, this.yCoord, this.zCoord));
				sateliteIsFalling = true;
			}
		}
		else
		{
			sateliteIsFalling = true;
		}
	}

	public boolean monitorNextToPad(World world, int x, int y, int z)
	{
		if(!(world.getBlockMetadata(x, y, z) == 0))
		{
			if(world.getBlockId(x - 1, y, z) == NanotechBlock.satelite.blockID)
			{
				return world.getBlockMetadata(x - 1, y, z) == 0;
			}
			else if(world.getBlockId(x + 1, y, z) == NanotechBlock.satelite.blockID)
			{
				return world.getBlockMetadata(x + 1, y, z) == 0;
			}
			else if(world.getBlockId(x, y, z - 1) == NanotechBlock.satelite.blockID)
			{
				return world.getBlockMetadata(x, y, z - 1) == 0;
			}
			else if(world.getBlockId(x, y, z + 1) == NanotechBlock.satelite.blockID)
			{
				return world.getBlockMetadata(x, y, z + 1) == 0;
			}
		}
		return false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setBoolean("SateliteIsFalling", sateliteIsFalling);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		sateliteIsFalling = nbtTagCompound.getBoolean("SateliteIsFalling");
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

	public void setSateliteIsFalling(boolean newValue)
	{
		sateliteIsFalling = newValue;
	}

	public boolean getSateliteIsFalling()
	{
		return this.sateliteIsFalling;
	}
}
