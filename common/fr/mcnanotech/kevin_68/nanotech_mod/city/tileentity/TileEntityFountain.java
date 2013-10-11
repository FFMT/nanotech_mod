package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityFountain extends TileEntity
{
	@SideOnly(Side.CLIENT)
	private long field_82137_b;
	@SideOnly(Side.CLIENT)
	private float field_82138_c;
	public boolean isActive;
	public float f = 0.0F;
	public boolean isGoingDown = false;
	private String field_94048_i;

	public float height = 6.0F;
	public float width = 0.2F;
	public boolean rotate = false;
	public boolean animated = false;

	public void updateEntity()
	{
		this.updateState();
		float randAnimated = this.worldObj.rand.nextInt(20);

		if(isActive)
		{
			if(f < height && !animated)
			{
				f += 0.1;
			}
			else if(animated)
			{
				if(randAnimated != 0)
				{
					if(f < height && !isGoingDown)
					{
						f += 0.1;
					}
					else if(f == height || f > height / randAnimated)
					{
						f -= 0.1;
						isGoingDown = true;
					}
					else if(f == height / randAnimated || f < height / randAnimated)
					{
						isGoingDown = false;
					}
				}
			}
		}

		if(!isActive && f != 0.0F)
		{
			f = 0.0F;
		}
	}

	private void updateState()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			if(!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord))
			{
				this.isActive = true;
			}
			else
			{
				this.isActive = true;
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
		nbtTagCompound.setFloat("FountainHeight", height);
		nbtTagCompound.setFloat("FountainWidth", width);
		nbtTagCompound.setBoolean("FountainRotate", rotate);
		nbtTagCompound.setBoolean("FountainAnimated", animated);
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		height = nbtTagCompound.getFloat("FountainHeight");
		width = nbtTagCompound.getFloat("FountainWidth");
		rotate = nbtTagCompound.getBoolean("FountainRotate");
		animated = nbtTagCompound.getBoolean("FountainAnimated");
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

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

	public float getHeight()
	{
		return height;
	}

	public float getWidth()
	{
		return width;
	}

	public boolean getRotate()
	{
		return rotate;
	}

	public boolean getAnimated()
	{
		return animated;
	}

	public void setHeight(float f)
	{
		height = f;
	}

	public void setWidth(float f)
	{
		width = f;
	}

	public void setRotate(boolean b)
	{
		rotate = b;
	}

	public void setAnimated(boolean b)
	{
		animated = b;
	}

}
