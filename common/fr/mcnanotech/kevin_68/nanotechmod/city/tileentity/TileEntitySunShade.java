/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;

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
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.sunShade, 3, 3);
						}
						else
						{
							this.worldObj.setBlock(xCoord + j, yCoord + 2, zCoord + k, NanotechCityBlock.sunShade, 2, 3);
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
						this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.sunShade, 1, 3);
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
		return AxisAlignedBB.getAABBPool().getAABB(xCoord - 2, yCoord, zCoord - 2, xCoord + 2, yCoord + 3, zCoord + 2);
	}
}