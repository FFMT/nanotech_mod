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
	
	public String text = "TEST";
	
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
		nbtTagCompound.setString("TextSpotLightText", text);
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		text = nbtTagCompound.getString("TextSpotLightText");
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
		this.text = s;
	}
	
	public String getText()
	{
		return text;
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
