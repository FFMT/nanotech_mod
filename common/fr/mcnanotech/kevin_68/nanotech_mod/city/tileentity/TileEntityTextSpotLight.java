package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTextSpotLight extends TileEntity
{
	@SideOnly(Side.CLIENT)
	private long worldTime;
	@SideOnly(Side.CLIENT)
	private float booleanFloat;
	public boolean isActive;

	public String signText = "";
	private EntityPlayer field_142011_d;
	public boolean rotate;
	public int angle;
	public float rotationSpeed;
	public boolean reverseRotation;
	public int red;
	public int green;
	public int blue;
	public int scale;
	public int height;

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			this.isActive = true;
		}
		else
		{
			this.isActive = false;
		}
	}

	@SideOnly(Side.CLIENT)
	public float isActiveFloat()
	{
		if(!this.isActive)
		{
			return 0.0F;
		}
		else
		{
			int i = (int)(this.worldObj.getTotalWorldTime() - this.worldTime);
			this.worldTime = this.worldObj.getTotalWorldTime();

			if(i > 1)
			{
				this.booleanFloat -= (float)i / 40.0F;

				if(this.booleanFloat < 0.0F)
				{
					this.booleanFloat = 0.0F;
				}
			}

			this.booleanFloat += 0.025F;

			if(this.booleanFloat > 1.0F)
			{
				this.booleanFloat = 1.0F;
			}

			return this.booleanFloat;
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
		nbtTagCompound.setString("Text", this.signText);
		nbtTagCompound.setBoolean("Rotate", rotate);
		nbtTagCompound.setInteger("Angle", angle);
		nbtTagCompound.setFloat("RotationSpeed", rotationSpeed);
		nbtTagCompound.setBoolean("ReverseRotation", reverseRotation);
		nbtTagCompound.setInteger("Red", red);
		nbtTagCompound.setInteger("Green", green);
		nbtTagCompound.setInteger("Blue", blue);
		nbtTagCompound.setInteger("Scale", scale);
		nbtTagCompound.setInteger("Height", height);
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		this.signText = nbtTagCompound.getString("Text");
		this.rotate = nbtTagCompound.getBoolean("Rotate");
		this.angle = nbtTagCompound.getInteger("Angle");
		this.rotationSpeed = nbtTagCompound.getFloat("RotationSpeed");
		this.reverseRotation = nbtTagCompound.getBoolean("ReverseRotation");
		this.red = nbtTagCompound.getInteger("Red");
		this.green = nbtTagCompound.getInteger("Green");
		this.blue = nbtTagCompound.getInteger("Blue");
		this.scale = nbtTagCompound.getInteger("Scale");
		this.height = nbtTagCompound.getInteger("Height");
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

	public void setText(String s)
	{
		this.signText = s;
	}

	public void setRotate(boolean b)
	{
		this.rotate = b;
	}
	
	public void setAngle(int i)
	{
		this.angle = i;
	}
	
	public void setRotationSpeed(int i)
	{
		this.rotationSpeed = i;
	}
	
	public void setReverseRotation(boolean b)
	{
		this.reverseRotation = b;
	}
	
	public void setRedValue(int i)
	{
		this.red = i;
	}

	public void setGreenValue(int i)
	{
		this.green = i;
	}

	public void setBlueValue(int i)
	{
		this.blue = i;
	}
	
	public void setScale(int i)
	{
		this.scale = i;
	}
	
	public void setHeight(int i)
	{
		this.height = i;
	}

	public String getText()
	{
		return this.signText;
	}
	
	public boolean getRotate()
	{
		return this.rotate;
	}
	
	public int getAngle()
	{
		return this.angle;
	}
	
	public float getRotationSpeed()
	{
		return this.rotationSpeed;
	}
	
	public boolean getReverseRotation()
	{
		return this.reverseRotation;
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
	
	public int getScale()
	{
		return this.scale;
	}
	
	public int getHeight()
	{
		return this.height;
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
