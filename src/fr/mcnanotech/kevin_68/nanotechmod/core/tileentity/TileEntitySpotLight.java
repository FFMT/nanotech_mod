package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;

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
	public int angle1, angle2, autoRotate, reverseRotation, rotationSpeed, secondaryLaser, displayAxe, sideLaser;
	public int lastKeySelected, timeLineEnabled, time, smoothMode, createKeyTime;
	public int lastTimeUse;

	public byte[] redKey = new byte[1200];
	public byte[] greenKey = new byte[1200];
	public byte[] blueKey = new byte[1200];
	public byte[] secRedKey = new byte[1200];
	public byte[] secGreenKey = new byte[1200];
	public byte[] secBlueKey = new byte[1200];
	public int[] angle1Key = new int[1200];
	public byte[] angle2Key = new byte[1200];

	private SpotLightEntry[] keyList = new SpotLightEntry[120];

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			this.isActive = true;

			if(isTimeLineEnabled())
			{
				if(getTime() == 1199)
				{
					set(23, 0);
				}
				else
				{
					set(23, getTime() + 1);
				}

				if(!this.worldObj.isRemote)
				{
					if(this.isSmoothMode())
					{
						this.set(0, (redKey[getTime()] & 0xFF));
						this.set(1, (greenKey[getTime()] & 0xFF));
						this.set(2, (blueKey[getTime()] & 0xFF));
						this.set(3, (secRedKey[getTime()] & 0xFF));
						this.set(4, (secGreenKey[getTime()] & 0xFF));
						this.set(5, (secBlueKey[getTime()] & 0xFF));
						this.set(8, (angle1Key[getTime()] & 0xFF));
						this.set(9, (angle2Key[getTime()] & 0xFF));
						
						int curTime = this.getTime() / 10;
						if(this.getKey(curTime) != null && lastTimeUse != time)
						{
							lastTimeUse = time;
							this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
							this.set(10, this.getKey(curTime).isKeyAutRot() ? 1 : 0);
							this.set(11, this.getKey(curTime).isKeyRevRot() ? 1 : 0);
							this.set(12, this.getKey(curTime).getKeyRotSpe());
							this.set(13, this.getKey(curTime).isKeySecLas() ? 1 : 0);
							this.set(14, this.getKey(curTime).getKeyDisplayAxe());
							this.set(15, this.getKey(curTime).isSideLaser() ? 1 : 0);
						}
					}
					else
					{
						int curTime = this.getTime() / 10;
						if(this.getKey(curTime) != null && lastTimeUse != time)
						{
							lastTimeUse = time;
							this.set(0, this.getKey(curTime).getKeyRed());
							this.set(1, this.getKey(curTime).getKeyGreen());
							this.set(2, this.getKey(curTime).getKeyBlue());
							this.set(3, this.getKey(curTime).getKeySecRed());
							this.set(4, this.getKey(curTime).getKeySecGreen());
							this.set(5, this.getKey(curTime).getKeySecBlue());
							this.set(8, this.getKey(curTime).getKeyAngle1());
							this.set(9, this.getKey(curTime).getKeyAngle2());
							this.set(10, this.getKey(curTime).isKeyAutRot() ? 1 : 0);
							this.set(11, this.getKey(curTime).isKeyRevRot() ? 1 : 0);
							this.set(12, this.getKey(curTime).getKeyRotSpe());
							this.set(13, this.getKey(curTime).isKeySecLas() ? 1 : 0);
							this.set(14, this.getKey(curTime).getKeyDisplayAxe());
							this.set(15, this.getKey(curTime).isSideLaser() ? 1 : 0);
							this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
						}
					}
				}
			}
		}
		else
		{
			this.isActive = false;
		}
	}

	public void keysProcess()
	{
		ArrayList<Integer> keys = new ArrayList();
		ArrayList<Integer> timeBetwinKeys = new ArrayList();

		for(int i = 0; i < keyList.length; i++)
		{
			SpotLightEntry entry = keyList[i];
			if(entry != null && entry.isActive())
			{
				keys.add(i * 10);
			}
		}

		if(!keys.isEmpty() && keys.size() > 1)
		{
			for(int j = 0; j < keys.size() - 1; j++)
			{
				timeBetwinKeys.add(keys.get(j + 1) - keys.get(j));
			}
			timeBetwinKeys.add((1200 - keys.get(keys.size() - 1) + keys.get(0)));

			for(int k = 0; k < (keys.size() - 1); k++)
			{
				int startRed = keyList[keys.get(k) / 10].getKeyRed();
				int endRed = keyList[keys.get(k + 1) / 10].getKeyRed();
				int deltaRed = endRed - startRed;
				float tickRed = (float)deltaRed / (float)timeBetwinKeys.get(k);
				
				int startGreen = keyList[keys.get(k) / 10].getKeyGreen();
				int endGreen = keyList[keys.get(k + 1) / 10].getKeyGreen();
				int deltaGreen = endGreen - startGreen;
				float tickGreen = (float)deltaGreen / (float)timeBetwinKeys.get(k);
				
				int startBlue = keyList[keys.get(k) / 10].getKeyBlue();
				int endBlue = keyList[keys.get(k + 1) / 10].getKeyBlue();
				int deltaBlue = endBlue - startBlue;
				float tickBlue = (float)deltaBlue / (float)timeBetwinKeys.get(k);
				
				int startSecRed = keyList[keys.get(k) / 10].getKeySecRed();
				int endSecRed = keyList[keys.get(k + 1) / 10].getKeySecRed();
				int deltaSecRed = endSecRed - startSecRed;
				float tickSecRed = (float)deltaSecRed / (float)timeBetwinKeys.get(k);
				
				int startSecGreen = keyList[keys.get(k) / 10].getKeySecGreen();
				int endSecGreen = keyList[keys.get(k + 1) / 10].getKeySecGreen();
				int deltaSecGreen = endSecGreen - startSecGreen;
				float tickSecGreen = (float)deltaSecGreen / (float)timeBetwinKeys.get(k);
				
				int startSecBlue = keyList[keys.get(k) / 10].getKeySecBlue();
				int endSecBlue = keyList[keys.get(k + 1) / 10].getKeySecBlue();
				int deltaSecBlue = endSecBlue - startSecBlue;
				float tickSecBlue = (float)deltaSecBlue / (float)timeBetwinKeys.get(k);
				
				int startAngle1 = keyList[keys.get(k) / 10].getKeyAngle1();
				int endAngle1 = keyList[keys.get(k + 1) / 10].getKeyAngle1();
				int deltaAngle1 = endAngle1 - startAngle1;
				float tickAngle1 = (float)deltaAngle1 / (float)timeBetwinKeys.get(k);
				
				int startAngle2 = keyList[keys.get(k) / 10].getKeyAngle2();
				int endAngle2 = keyList[keys.get(k + 1) / 10].getKeyAngle2();
				int deltaAngle2 = endAngle2 - startAngle2;
				float tickAngle2 = (float)deltaAngle2 / (float)timeBetwinKeys.get(k);
				
				for(int l = keys.get(k); l < keys.get(k + 1); l++)
				{
					redKey[l] = (byte)(startRed + (tickRed * (l - keys.get(k))));
					greenKey[l] = (byte)(startGreen + (tickGreen * (l - keys.get(k))));
					blueKey[l] = (byte)(startBlue + (tickBlue * (l - keys.get(k))));
					secRedKey[l] = (byte)(startSecRed + (tickSecRed * (l - keys.get(k))));
					secGreenKey[l] = (byte)(startSecGreen + (tickSecGreen * (l - keys.get(k))));
					secBlueKey[l] = (byte)(startSecBlue + (tickSecBlue * (l - keys.get(k))));
					angle1Key[l] = (int)(startAngle1 + (tickAngle1 * (l - keys.get(k))));
					angle2Key[l] = (byte)(startAngle2 + (tickAngle2 * (l - keys.get(k))));
				}
			}

			int startRed = keyList[keys.get(keys.size() - 1) / 10].getKeyRed();
			int endRed = keyList[keys.get(0) / 10].getKeyRed();
			int deltaRed = endRed - startRed;
			float tickRed = (float)deltaRed / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startGreen = keyList[keys.get(keys.size() - 1) / 10].getKeyGreen();
			int endGreen = keyList[keys.get(0) / 10].getKeyGreen();
			int deltaGreen = endGreen - startGreen;
			float tickGreen = (float)deltaGreen / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startBlue = keyList[keys.get(keys.size() - 1) / 10].getKeyBlue();
			int endBlue = keyList[keys.get(0) / 10].getKeyBlue();
			int deltaBlue = endBlue - startBlue;
			float tickBlue = (float)deltaBlue / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startSecRed = keyList[keys.get(keys.size() - 1) / 10].getKeySecRed();
			int endSecRed = keyList[keys.get(0) / 10].getKeySecRed();
			int deltaSecRed = endSecRed - startSecRed;
			float tickSecRed = (float)deltaSecRed / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startSecGreen = keyList[keys.get(keys.size() - 1) / 10].getKeySecGreen();
			int endSecGreen = keyList[keys.get(0) / 10].getKeySecGreen();
			int deltaSecGreen = endSecGreen - startSecGreen;
			float tickSecGreen = (float)deltaSecGreen / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startSecBlue = keyList[keys.get(keys.size() - 1) / 10].getKeySecBlue();
			int endSecBlue = keyList[keys.get(0) / 10].getKeySecBlue();
			int deltaSecBlue = endSecBlue - startSecBlue;
			float tickSecBlue = (float)deltaSecBlue / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startAngle1 = keyList[keys.get(keys.size() - 1) / 10].getKeyAngle1();
			int endAngle1 = keyList[keys.get(0) / 10].getKeyAngle1();
			int deltaAngle1 = endAngle1 - startAngle1;
			float tickAngle1 = (float)deltaAngle1 / (float)timeBetwinKeys.get(keys.size() - 1);
			
			int startAngle2 = keyList[keys.get(keys.size() - 1) / 10].getKeyAngle2();
			int endAngle2 = keyList[keys.get(0) / 10].getKeyAngle2();
			int deltaAngle2 = endAngle2 - startAngle2;
			float tickAngle2 = (float)deltaAngle2 / (float)timeBetwinKeys.get(keys.size() - 1);

			for(int m = keys.get(keys.size() - 1); m < 1200; m++)
			{
				redKey[m] = (byte)(startRed + (tickRed * (m - keys.get(keys.size() - 1))));
				greenKey[m] = (byte)(startGreen + (tickGreen * (m - keys.get(keys.size() - 1))));
				blueKey[m] = (byte)(startBlue + (tickBlue * (m - keys.get(keys.size() - 1))));
				secRedKey[m] = (byte)(startSecRed + (tickSecRed * (m - keys.get(keys.size() - 1))));
				secGreenKey[m] = (byte)(startSecGreen + (tickSecGreen * (m - keys.get(keys.size() - 1))));
				secBlueKey[m] = (byte)(startSecBlue + (tickSecBlue * (m - keys.get(keys.size() - 1))));
				angle1Key[m] = (int)(startAngle1 + (tickAngle1 * (m - keys.get(keys.size() - 1))));
				angle2Key[m] = (byte)(startAngle2 + (tickAngle2 * (m - keys.get(keys.size() - 1))));

			}
			for(int n = 0; n < keys.get(0); n++)
			{
				redKey[n] = (byte)(redKey[1199] + (tickRed * n));
				greenKey[n] = (byte)(greenKey[1199] + (tickGreen * n));
				blueKey[n] = (byte)(blueKey[1199] + (tickBlue * n));
				secRedKey[n] = (byte)(secRedKey[1199] + (tickSecRed * n));
				secGreenKey[n] = (byte)(secGreenKey[1199] + (tickSecGreen * n));
				secBlueKey[n] = (byte)(secBlueKey[1199] + (tickSecBlue * n));
				angle1Key[n] = (int)(angle1Key[1199] + (tickAngle1 * n));
				angle2Key[n] = (byte)(angle2Key[1199] + (tickAngle2 * n));

			}
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
		if(textureName != null && !textureName.isEmpty())
		{
			nbtTagCompound.setString("TextureName", textureName);
		}
		if(secTextureName != null && !secTextureName.isEmpty())
		{
			nbtTagCompound.setString("SecTextureName", secTextureName);
		}
		nbtTagCompound.setInteger("Angle1", angle1);
		nbtTagCompound.setInteger("Angle2", angle2);
		nbtTagCompound.setInteger("AutoRotate", autoRotate);
		nbtTagCompound.setInteger("ReverseRotation", reverseRotation);
		nbtTagCompound.setInteger("RotationSpeed", rotationSpeed);
		nbtTagCompound.setInteger("SecondaryLaser", secondaryLaser);
		nbtTagCompound.setInteger("LastKeySelected", lastKeySelected);
		nbtTagCompound.setInteger("TimeLineEnabled", timeLineEnabled);
		nbtTagCompound.setInteger("Time", time);
		nbtTagCompound.setInteger("SmoothMode", smoothMode);
		nbtTagCompound.setInteger("CreateKeyTime", createKeyTime);
		nbtTagCompound.setInteger("DisplayAxe", displayAxe);
		nbtTagCompound.setInteger("SideLaser", sideLaser);
		nbtTagCompound.setByteArray("RedKey", redKey);
		nbtTagCompound.setByteArray("GreenKey", greenKey);
		nbtTagCompound.setByteArray("BlueKey", blueKey);
		nbtTagCompound.setByteArray("SecRedKey", secRedKey);
		nbtTagCompound.setByteArray("SecGreenKey", secGreenKey);
		nbtTagCompound.setByteArray("SecBlueKey", secBlueKey);
		nbtTagCompound.setIntArray("Angle1Key", angle1Key);
		nbtTagCompound.setByteArray("Angle2Key", angle2Key);

		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < this.keyList.length; ++i)
		{
			if(this.keyList[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Key", (byte)i);
				this.keyList[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbtTagCompound.setTag("SpotLightKeys", nbttaglist);

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
		timeLineEnabled = nbtTagCompound.getInteger("TimeLineEnabled");
		time = nbtTagCompound.getInteger("Time");
		smoothMode = nbtTagCompound.getInteger("SmoothMode");
		createKeyTime = nbtTagCompound.getInteger("CreateKeyTime");
		displayAxe = nbtTagCompound.getInteger("DisplayAxe");
		sideLaser = nbtTagCompound.getInteger("SideLaser");
		redKey = nbtTagCompound.getByteArray("RedKey");		
		greenKey = nbtTagCompound.getByteArray("GreenKey");
		blueKey = nbtTagCompound.getByteArray("BlueKey");
		secRedKey = nbtTagCompound.getByteArray("SecRedKey");		
		secGreenKey = nbtTagCompound.getByteArray("SecGreenKey");
		secBlueKey = nbtTagCompound.getByteArray("SecBlueKey");
		angle1Key = nbtTagCompound.getIntArray("Angle1Key");
		angle2Key = nbtTagCompound.getByteArray("Angle2Key");
		
		NBTTagList nbttaglist = nbtTagCompound.getTagList("SpotLightKeys", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Key") & 255;

			if(j >= 0 && j < this.keyList.length)
			{
				this.keyList[j] = SpotLightEntry.loadSpotLightEntryFromNBT(nbttagcompound1);
			}
		}

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
		case 14:
		{
			this.displayAxe = value;
			break;
		}
		case 15:
		{
			this.sideLaser = value;
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

	public int getRed()
	{
		return red;
	}

	public int getGreen()
	{
		return green;
	}

	public int getBlue()
	{
		return blue;
	}

	public int getSecRed()
	{
		return secRed;
	}

	public int getSecGreen()
	{
		return secGreen;
	}

	public int getSecBlue()
	{
		return secBlue;
	}

	public String getTextureName()
	{
		return textureName;
	}

	public String getSecTextureName()
	{
		return secTextureName;
	}

	public int getAngle1()
	{
		return angle1;
	}

	public int getAngle2()
	{
		return angle2;
	}

	public boolean isAutoRotate()
	{
		return autoRotate == 1;
	}

	public boolean isReverseRotation()
	{
		return reverseRotation == 1;
	}

	public int getRotationSpeed()
	{
		return rotationSpeed;
	}

	public boolean isSecondaryLaser()
	{
		return secondaryLaser == 1;
	}

	public int getDisplayAxe()
	{
		return displayAxe;
	}
	
	public boolean isSideLaser()
	{
		return sideLaser == 1;
	}

	public int getLastKeySelected()
	{
		return lastKeySelected;
	}

	public boolean isTimeLineEnabled()
	{
		return timeLineEnabled == 1;
	}

	public int getTime()
	{
		return time;
	}

	public boolean isSmoothMode()
	{
		return smoothMode == 1;
	}

	public int getCreateKeyTime()
	{
		return createKeyTime;
	}

	public void setKey(int index, SpotLightEntry value)
	{
		if(index >= 0 && index < this.keyList.length)
		{
			this.keyList[index] = value;
		}
		else
		{
			System.out.println("fatal error, index invalid !");
		}
		keysProcess();
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public SpotLightEntry getKey(int index)
	{
		if(index >= 0 && index < this.keyList.length)
		{
			return this.keyList[index];
		}
		return null;
	}
}