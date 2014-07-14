package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class TileEntitySpotLight extends TileEntity
{

	@SideOnly(Side.CLIENT)
	private long worldTimeClient;
	@SideOnly(Side.CLIENT)
	private float activeBooleanFloat;
	public boolean isActive;

	public int red, green, blue;
	public int secRed, secGreen, secBlue;
	public String textureName, secTextureName;
	public int angle1, angle2, autoRotate, reverseRotation, rotationSpeed, secondaryLaser;
	public int lastKeySelected, timeLineEnabled, time, smoothMode, createKeyTime;
	public int[] keyList = new int[121];
	public int[] keyRed = new int[121];
	public int[] keyGreen = new int[121];
	public int[] keyBlue = new int[121];
	public int[] keySecRed = new int[121];
	public int[] keySecGreen = new int[121];
	public int[] keySecBlue = new int[121];
	public int[] keyAngle1 = new int[121];
	public int[] keyAngle2 = new int[121];
	public int[] keyAutRot = new int[121];
	public int[] keyRevRot = new int[121];
	public int[] keyRotSpe = new int[121];
	public int[] keySecLas = new int[121];
	

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			this.isActive = true;
			
			if(get(timeLineEnabled) == 1)
			{
				if(get(time) > 1200)
				{
					set(time, 0);
				}
				else
				{
					set(time, get(time) + 1);
				}
			}
		}
		else
		{
			this.isActive = false;
		}
	}

	@SideOnly(Side.CLIENT)
	public float isActive()
	{
		if(!this.isActive)
		{
			return 0.0F;
		}
		else
		{
			int i = (int)(this.worldObj.getTotalWorldTime() - this.worldTimeClient);
			this.worldTimeClient = this.worldObj.getTotalWorldTime();

			if(i > 1)
			{
				this.activeBooleanFloat -= (float)i / 40.0F;

				if(this.activeBooleanFloat < 0.0F)
				{
					this.activeBooleanFloat = 0.0F;
				}
			}

			this.activeBooleanFloat += 0.025F;

			if(this.activeBooleanFloat > 1.0F)
			{
				this.activeBooleanFloat = 1.0F;
			}

			return this.activeBooleanFloat;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 65536.0D;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("Red", red);
		nbtTagCompound.setInteger("Green", green);
		nbtTagCompound.setInteger("Blue", blue);
		nbtTagCompound.setInteger("SecRed", secRed);
		nbtTagCompound.setInteger("SecGreen", secGreen);
		nbtTagCompound.setInteger("SecBlue", secBlue);
		nbtTagCompound.setString("TextureName", textureName);
		nbtTagCompound.setString("SecTextureName", secTextureName);
		nbtTagCompound.setInteger("Angle1", angle1);
		nbtTagCompound.setInteger("Angle2", angle2);
		nbtTagCompound.setInteger("AutoRotate", autoRotate);
		nbtTagCompound.setInteger("ReverseRotation", reverseRotation);
		nbtTagCompound.setInteger("RotationSpeed", rotationSpeed);
		nbtTagCompound.setInteger("SecondaryLaser", secondaryLaser);
		nbtTagCompound.setInteger("LastKeySelected", lastKeySelected);
		nbtTagCompound.setIntArray("KeyList", keyList);
		nbtTagCompound.setInteger("TimeLineEnabled", timeLineEnabled);
		nbtTagCompound.setInteger("Time", time);
		nbtTagCompound.setInteger("SmoothMode", smoothMode);
		nbtTagCompound.setIntArray("KeyRed", keyRed);
		nbtTagCompound.setIntArray("KeySecGreen", keySecGreen);
        nbtTagCompound.setIntArray("KeySecBlue", keySecBlue);
        nbtTagCompound.setIntArray("KeyAngle1", keyAngle1);
        nbtTagCompound.setIntArray("KeyAngle2", keyAngle2);
        nbtTagCompound.setIntArray("KeyAutRot", keyAutRot);
        nbtTagCompound.setIntArray("KeyRevRot", keyRevRot);
        nbtTagCompound.setIntArray("KeyRotSpe", keyRotSpe);
        nbtTagCompound.setIntArray("KeySecLas", keySecLas);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		red = nbtTagCompound.getInteger("Red");
		green = nbtTagCompound.getInteger("Green");
		blue = nbtTagCompound.getInteger("Blue");
		secRed = nbtTagCompound.getInteger("SecRed");
		secGreen = nbtTagCompound.getInteger("SecGreen");
		secBlue = nbtTagCompound.getInteger("SecBlue");
		textureName = nbtTagCompound.getString("TextureName");
		secTextureName = nbtTagCompound.getString("SecTextureName");
		angle1 = nbtTagCompound.getInteger("Angle1");
		angle2 = nbtTagCompound.getInteger("Angle2");
		autoRotate = nbtTagCompound.getInteger("AutoRotate");
		reverseRotation = nbtTagCompound.getInteger("ReverseRotation");
		rotationSpeed = nbtTagCompound.getInteger("RotationSpeed");
		secondaryLaser = nbtTagCompound.getInteger("SecondaryLaser");
		lastKeySelected = nbtTagCompound.getInteger("LastKeySelected");
		keyList = nbtTagCompound.getIntArray("KeyList");
		timeLineEnabled = nbtTagCompound.getInteger("TimeLineEnabled");
		time = nbtTagCompound.getInteger("Time");
		smoothMode = nbtTagCompound.getInteger("SmoothMode");
		keyRed = nbtTagCompound.getIntArray("KeyRed");
		keyGreen = nbtTagCompound.getIntArray("KeyGreen");
		keyBlue = nbtTagCompound.getIntArray("KeyBlue");
		keySecRed = nbtTagCompound.getIntArray("KeySecRed");
		keySecGreen = nbtTagCompound.getIntArray("keySecGreen");
		keySecBlue = nbtTagCompound.getIntArray("keySecBlue");
		keyAngle1 = nbtTagCompound.getIntArray("KeyAngle1");
		keyAngle2 = nbtTagCompound.getIntArray("KeyAngle2");
		keyAutRot = nbtTagCompound.getIntArray("KeyAutRot");
		keyRevRot = nbtTagCompound.getIntArray("KeyRevRot");
		keyRotSpe = nbtTagCompound.getIntArray("KeyRotSpe");
		keySecLas = nbtTagCompound.getIntArray("KeySecLas");
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
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
		switch(index)
		{
		case 0:
		{
			this.red = value;
			break;
		}
		case 1:
		{
			this.green = value;
			break;
		}
		case 2:
		{
			this.blue = value;
			break;
		}
		case 3:
		{
			this.secRed = value;
			break;
		}
		case 4:
		{
			this.secGreen = value;
			break;
		}
		case 5:
		{
			this.secBlue = value;
			break;
		}
		case 8:
		{
			this.angle1 = value;
			break;
		}
		case 9:
		{
			this.angle2 = value;
			break;
		}
		case 10:
		{
			this.autoRotate = value;
			break;
		}
		case 11:
		{
			this.reverseRotation = value;
			break;
		}
		case 12:
		{
			this.rotationSpeed = value;
			break;
		}
		case 13:
		{
			this.secondaryLaser = value;
			break;
		}
		case 20:
		{
			this.lastKeySelected = value;
			break;
		}
		case 22:
		{
			this.timeLineEnabled = value;
			break;
		}
		case 23:
		{
			this.time = value;
			break;
		}
		case 24:
		{
			this.smoothMode = value;
			break;
		}
		case 37:
		{
			this.createKeyTime = value;
			break;
		}
		default:
		{
			NanotechMod.log.error("Wrong set index : " + index);
		}
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void set(int index, String value)
	{
		switch(index)
		{
		case 6:
		{
			textureName = value;
			break;
		}
		case 7:
		{
			secTextureName = value;
			break;
		}
		default:
		{
			NanotechMod.log.error("Wrong set index : " + index);
		}
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void set(int index, int value, int time)
	{
		switch(index)
		{
		case 21:
		{
			this.keyList[time] = value;
			break;
		}
		case 25:
		{
			this.keyRed[time] = value;
			break;
		}
		case 26:
		{
			this.keyGreen[time] = value;
			break;
		}
		case 27:
		{
			this.keyBlue[time] = value;
			break;
		}
		case 28:
		{
			this.keySecRed[time] = value;
			break;
		}
		case 29:
		{
			this.keySecGreen[time] = value;
			break;
		}
		case 30:
		{
			this.keySecBlue[time] = value;
			break;
		}
		case 31:
		{
			this.keyAngle1[time] = value;
			break;
		}
		case 32:
		{
			this.keyAngle2[time] = value;
			break;
		}
		case 33:
		{
			this.keyAutRot[time] = value;
			break;
		}
		case 34:
		{
			this.keyRevRot[time] = value;
			break;
		}
		case 35:
		{
			this.keyRotSpe[time] = value;
			break;
		}
		case 36:
		{
			this.keySecLas[time] = value;
			break;
		}
		}
	}

	public int get(int index)
	{
		switch(index)
		{
		case 0:
		{
			return this.red;
		}
		case 1:
		{
			return this.green;
		}
		case 2:
		{
			return this.blue;
		}
		case 3:
		{
			return this.secRed;
		}
		case 4:
		{
			return this.secGreen;
		}
		case 5:
		{
			return this.secBlue;
		}
		case 8:
		{
			return this.angle1;
		}
		case 9:
		{
			return this.angle2;
		}
		case 10:
		{
			return this.autoRotate;
		}
		case 11:
		{
			return this.reverseRotation;
		}
		case 12:
		{
			return this.rotationSpeed;
		}
		case 13:
		{
			return this.secondaryLaser;
		}
		case 20:
		{
			return this.lastKeySelected;
		}
		case 22:
		{
			return this.timeLineEnabled;
		}
		case 23:
		{
			return this.time;
		}
		case 24:
		{
			return smoothMode;
		}
		case 37:
		{
			return createKeyTime;
		}
		default:
		{
			NanotechMod.log.error("Wrong get index :" + index);
			return -1;
		}
		}
	}

	public String getS(int index)
	{
		switch(index)
		{
		case 6:
		{
			return textureName;
		}
		case 7:
		{
			return secTextureName;
		}
		default:
		{
			NanotechMod.log.error("Wrong get index :" + index);
			return "null";
		}
		}
	}

	public int get(int index, int time)
	{
		switch(index)
		{
		case 21:
		{
			return keyList[time];
		}
		case 25:
		{
			return keyRed[time];
		}
		case 26:
		{
			return keyGreen[time];
		}
		case 27:
		{
			return keyBlue[time];
		}
		case 28:
		{
			return keySecRed[time];
		}
		case 29:
		{
			return keySecGreen[time];
		}
		case 30:
		{
			return keySecBlue[time];
		}
		case 31:
		{
			return keyAngle1[time];
		}
		case 32:
		{
			return keyAngle2[time];
		}
		case 33:
		{
			return keyAutRot[time];
		}
		case 34:
		{
			return keyRevRot[time];
		}
		case 35:
		{
			return keyRotSpe[time];
		}
		case 36:
		{
			return keySecLas[time];
		}
		default:
		{
			NanotechMod.log.error("Wrong get index :" + index);
			return -1;
		}
		}
	}
}
