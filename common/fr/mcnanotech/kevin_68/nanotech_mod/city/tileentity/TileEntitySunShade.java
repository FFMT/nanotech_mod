package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;

public class TileEntitySunShade extends TileEntity
{
	private boolean isOpen;

	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setBoolean("open", isOpen);
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		isOpen = nbtTagCompound.getBoolean("open");
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

	public boolean getIsOpen()
	{
		return isOpen;
	}

	public void openSunShade()
	{
		if(this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 1)
		{
			boolean canOpen = true;
			for(int j = -1; j < 2; ++j)
			{
				for(int k = -1; k < 2; ++k)
				{
					if(j != 0 || k != 0)
					{
						if(!this.worldObj.isAirBlock(xCoord + j, yCoord + 2, zCoord + k))
						{
							canOpen = false;
							return;
						}
					}
				}
			}
			if(canOpen)
			{
				for(int j = -1; j < 2; ++j)
				{
					for(int k = -1; k < 2; ++k)
					{
						if(j == 0 && k == 0)
						{
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.sunShade.blockID, 3, 3);
						}
						else
						{
							this.worldObj.setBlock(xCoord + j, yCoord + 2, zCoord + k, NanotechCityBlock.sunShade.blockID, 2, 3);
						}
					}
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
				this.isOpen = true;
			}
		}
	}

	public void closeSunShade()
	{
		if(this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 3)
		{
			for(int j = -1; j < 2; ++j)
			{
				for(int k = -1; k < 2; ++k)
				{
					if(j == 0 && k == 0)
					{
						this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.sunShade.blockID, 1, 3);
					}
					else
					{
						this.worldObj.setBlockToAir(xCoord + j, yCoord + 2, zCoord + k);
					}
				}
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
		this.isOpen = false;
	}

	public void switchSunShade()
	{
		if(getIsOpen())
		{
			this.closeSunShade();
		}
		else
		{
			this.openSunShade();
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}
}