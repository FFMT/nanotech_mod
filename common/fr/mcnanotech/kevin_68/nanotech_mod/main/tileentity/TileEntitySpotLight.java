package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntitySpotLight extends TileEntity
{
	@SideOnly(Side.CLIENT)
	private long field_82137_b;
	@SideOnly(Side.CLIENT)
	private float field_82138_c;
	public boolean isActive;
	public boolean isReverse;
	private String field_94048_i;

	public int red;
	public int green;
	public int blue;
	public int darkRed;
	public int darkGreen;
	public int darkBlue;

	public void updateEntity()
	{
		this.updateState();
	}

	private void updateState()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			if(!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord))
			{
				this.isActive = true;
				this.isReverse = true;
			}
			else
			{
				this.isActive = true;
				this.isReverse = false;
			}
		}
		else
		{
			this.isActive = false;
		}
	}

	@SideOnly(Side.CLIENT)
	public float func_82125_v_()
	{
		if(!this.isActive)
		{
			return 0.0F;
		}
		else
		{
			int i = (int)(this.worldObj.getTotalWorldTime() - this.field_82137_b);
			this.field_82137_b = this.worldObj.getTotalWorldTime();

			if(i > 1)
			{
				this.field_82138_c -= (float)i / 40.0F;

				if(this.field_82138_c < 0.0F)
				{
					this.field_82138_c = 0.0F;
				}
			}

			this.field_82138_c += 0.025F;

			if(this.field_82138_c > 1.0F)
			{
				this.field_82138_c = 1.0F;
			}

			return this.field_82138_c;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 65536.0D;
	}

	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("SpotLightRed", red);
		nbtTagCompound.setInteger("SpotLightGreen", green);
		nbtTagCompound.setInteger("SpotLightBlue", blue);
		nbtTagCompound.setInteger("SpotLightDarkRed", darkRed);
		nbtTagCompound.setInteger("SpotLightDarkGreen", darkGreen);
		nbtTagCompound.setInteger("SpotLightDarkBlue", darkBlue);
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		red = nbtTagCompound.getInteger("SpotLightRed");
		green = nbtTagCompound.getInteger("SpotLightGreen");
		blue = nbtTagCompound.getInteger("SpotLightBlue");
		darkRed = nbtTagCompound.getInteger("SpotLightDarkRed");
		darkGreen = nbtTagCompound.getInteger("SpotLightDarkGreen");
		darkBlue = nbtTagCompound.getInteger("SpotLightDarkBlue");
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 4, nbttagcompound);
	}

	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		this.readFromNBT(pkt.customParam1);
	}

	public int setRedValue(int i)
	{
		return this.red = i;
	}

	public int setGreenValue(int i)
	{
		return this.green = i;
	}

	public int setBlueValue(int i)
	{
		return this.blue = i;
	}

	public int setDarkRedValue(int i)
	{
		return this.darkRed = i;
	}

	public int setDarkGreenValue(int i)
	{
		return this.darkGreen = i;
	}

	public int setDarkBlueValue(int i)
	{
		return this.darkBlue = i;
	}

	public int getRedValue()
	{
		return this.red;
	}

	public int getGreenValue()
	{
		return this.green;
	}

	public int getBlueValue()
	{
		return this.blue;
	}

	public int getDarkRedValue()
	{
		return this.darkRed;
	}

	public int getDarkGreenValue()
	{
		return this.darkGreen;
	}

	public int getDarkBlueValue()
	{
		return this.darkBlue;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

}
