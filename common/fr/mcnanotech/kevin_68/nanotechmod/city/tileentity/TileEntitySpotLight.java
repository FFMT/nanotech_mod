package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.items.NanotechCityItems;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class TileEntitySpotLight extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[2];
	private int[] keyList = new int[121];
	private int[] redkey = new int[121];
	private int[] greenkey = new int[121];
	private int[] bluekey = new int[121];
	private int[] darkRedkey = new int[121];
	private int[] darkGreenkey = new int[121];
	private int[] darkBluekey = new int[121];
	private int[] angle1key = new int[121];
	private int[] angle2key = new int[121];
	private int[] autoRotatekey = new int[121];
	private int[] rotateSpeedkey = new int[121];
	private int[] secondaryLazerkey = new int[121];
	private int[] reverseRotationkey = new int[121];

	private String customName;

	@SideOnly(Side.CLIENT)
	private long worldTimeClient;
	@SideOnly(Side.CLIENT)
	private float activeBooleanFloat;
	public boolean isActive;

	public int red;
	public int green;
	public int blue;
	public int darkRed;
	public int darkGreen;
	public int darkBlue;
	public int angle1;
	public int angle2;
	public boolean autoRotate;
	public int rotationSpeed;
	public boolean secondaryLazer;
	public boolean reverseRotation;

	public boolean timeLineMode;
	public int timeLine, lastTimeUse;
	public int createKeyTime;
	public int selectedbuttonid;

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{

			if(getTimeLineMode())
			{
				if(getTimeLine() > 1200)
				{
					setTimeLine(0);
				}
				else
				{
					setTimeLine(getTimeLine() + 1);
				}

				if(!this.worldObj.isRemote)
				{
					int time = getTimeLine() / 10;
					if(hasKey(time) && lastTimeUse != time)
					{
						lastTimeUse = time;
						System.out.println("time:" + time);
						setRedValue(getRedKey(time));
						setGreenValue(getGreenKey(time));
						setBlueValue(getBlueKey(time));
						setDarkRedValue(getDarkRedKey(time));
						setDarkGreenValue(getDarkGreenKey(time));
						setDarkBlueValue(getDarkBlueKey(time));
						setAngle1Value(getAngle1Key(time));
						setAngle2Value(getAngle2Key(time));
						setRotateValue(getAutoRotateKey(time) ? 1 : 0);
						setRotationSpeed(getRotationSpeedKey(time));
						setSecondaryLazer(getSecondaryLazerKey(time) ? 1 : 0);
						setReverseRotation(getReverseRotationKey(time) ? 1 : 0);
						
						this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					}
				}
			}
			this.isActive = true;
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

	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("SpotLightRed", red);
		nbtTagCompound.setInteger("SpotLightGreen", green);
		nbtTagCompound.setInteger("SpotLightBlue", blue);
		nbtTagCompound.setInteger("SpotLightDarkRed", darkRed);
		nbtTagCompound.setInteger("SpotLightDarkGreen", darkGreen);
		nbtTagCompound.setInteger("SpotLightDarkBlue", darkBlue);
		nbtTagCompound.setInteger("SpotLightAngle1", angle1);
		nbtTagCompound.setInteger("SpotLightAngle2", angle2);
		nbtTagCompound.setBoolean("SpotLightAutoRotate", autoRotate);
		nbtTagCompound.setInteger("SpotLightRotationSpeed", rotationSpeed);
		nbtTagCompound.setBoolean("SpotLightSecondaryLaser", secondaryLazer);
		nbtTagCompound.setBoolean("SpotLightReverseRotation", reverseRotation);

		nbtTagCompound.setInteger("SpotlightSelectedButtonId", selectedbuttonid);
		nbtTagCompound.setBoolean("SpotLightTimeLineMode", timeLineMode);
		nbtTagCompound.setInteger("SpotLightTimeLine", timeLine);
		nbtTagCompound.setInteger("SpotLightCreateKeyTime", createKeyTime);
		nbtTagCompound.setIntArray("SpotLightHasKey", keyList);
		nbtTagCompound.setIntArray("SpotLightTimeRed", redkey);
		nbtTagCompound.setIntArray("SpotLightTimeGreen", greenkey);
		nbtTagCompound.setIntArray("SpotLightTimeBlue", bluekey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkRed", darkRedkey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkGreen", darkGreenkey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkBlue", darkBluekey);
		nbtTagCompound.setIntArray("SpotLightTimeAngle1", angle1key);
		nbtTagCompound.setIntArray("SpotLightTimeAngle2", angle2key);
		nbtTagCompound.setIntArray("SpotLightTimeAutoRotate", autoRotatekey);
		nbtTagCompound.setIntArray("SpotLightTimeRotateSpeed", rotateSpeedkey);
		nbtTagCompound.setIntArray("SpotLightTimeSecondaryLazer", secondaryLazerkey);
		nbtTagCompound.setIntArray("SpotLightTimeReverseRotation", reverseRotationkey);

		NBTTagList itemList = new NBTTagList();
		for(int j = 0; j < inventory.length; j++)
		{
			ItemStack stack = inventory[j];
			if(stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte)j);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		nbtTagCompound.setTag("Inventory", itemList);
		if(this.customName != null)
		{
			nbtTagCompound.setString("Name", this.customName);
		}
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
		angle1 = nbtTagCompound.getInteger("SpotLightAngle1");
		angle2 = nbtTagCompound.getInteger("SpotLightAngle2");
		autoRotate = nbtTagCompound.getBoolean("SpotLightAutoRotate");
		rotationSpeed = nbtTagCompound.getInteger("SpotLightRotationSpeed");
		secondaryLazer = nbtTagCompound.getBoolean("SpotLightSecondaryLaser");
		reverseRotation = nbtTagCompound.getBoolean("SpotLightReverseRotation");

		selectedbuttonid = nbtTagCompound.getInteger("SpotlightSelectedButtonId");
		timeLineMode = nbtTagCompound.getBoolean("SpotLightTimeLineMode");
		timeLine = nbtTagCompound.getInteger("SpotLightTimeLine");
		createKeyTime = nbtTagCompound.getInteger("SpotLightCreateKeyTime");
		keyList = nbtTagCompound.getIntArray("SpotLightHasKey");
		redkey = nbtTagCompound.getIntArray("SpotLightTimeRed");
		greenkey = nbtTagCompound.getIntArray("SpotLightTimeGreen");
		bluekey = nbtTagCompound.getIntArray("SpotLightTimeBlue");
		darkRedkey = nbtTagCompound.getIntArray("SpotLightTimeDarkRed");
		darkGreenkey = nbtTagCompound.getIntArray("SpotLightTimeDarkGreen");
		darkBluekey = nbtTagCompound.getIntArray("SpotLightTimeDarkBlue");
		angle1key = nbtTagCompound.getIntArray("SpotLightTimeAngle1");
		angle2key = nbtTagCompound.getIntArray("SpotLightTimeAngle2");
		autoRotatekey = nbtTagCompound.getIntArray("SpotLightTimeAutoRotate");
		rotateSpeedkey = nbtTagCompound.getIntArray("SpotLightTimeRotateSpeed");
		secondaryLazerkey = nbtTagCompound.getIntArray("SpotLightTimeSecondaryLazer");
		reverseRotationkey = nbtTagCompound.getIntArray("SpotLightTimeReverseRotation");

		NBTTagList tagList = nbtTagCompound.getTagList("Inventory");
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound)tagList.tagAt(i);
			byte slot = tag.getByte("Slot");

			if(slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}

		if(nbtTagCompound.hasKey("Name"))
		{
			this.customName = nbtTagCompound.getString("Name");
		}
	}

	// --Setter------------------------

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

	public void setDarkRedValue(int i)
	{
		this.darkRed = i;
	}

	public void setDarkGreenValue(int i)
	{
		this.darkGreen = i;
	}

	public void setDarkBlueValue(int i)
	{
		this.darkBlue = i;
	}

	public void setAngle1Value(int i)
	{
		this.angle1 = i;
	}

	public void setAngle2Value(int i)
	{
		this.angle2 = i;
	}

	public void setRotateValue(int i)
	{
		if(i == 1)
		{
			this.autoRotate = true;
		}
		else
		{
			this.autoRotate = false;
		}
	}

	public void setRotationSpeed(int i)
	{
		this.rotationSpeed = i;
	}

	public void setSecondaryLazer(int i)
	{
		if(i == 1)
		{
			this.secondaryLazer = true;
		}
		else
		{
			this.secondaryLazer = false;
		}
	}

	public void setReverseRotation(int i)
	{
		if(i == 1)
		{
			this.reverseRotation = true;
		}
		else
		{
			this.reverseRotation = false;
		}
	}

	public void setTimeLineMode(int i)
	{
		if(i == 1)
		{
			this.timeLineMode = true;
		}
		else
		{
			this.timeLineMode = false;
		}
	}

	public void setTimeLine(int i)
	{
		this.timeLine = i;
	}

	public void setCreateKeyTime(int i)
	{
		createKeyTime = i;
	}

	public void setSelectedButtonId(int i)
	{
		this.selectedbuttonid = i;
	}

	public void setKey(int time, int i)
	{
		this.keyList[time] = i;
	}

	public void setRedKey(int time, int color)
	{
		this.redkey[time] = color;
	}

	public void setGreenKey(int time, int color)
	{
		this.greenkey[time] = color;
	}

	public void setBlueKey(int time, int color)
	{
		this.bluekey[time] = color;
	}

	public void setDarkRedKey(int time, int color)
	{
		this.darkRedkey[time] = color;
	}

	public void setDarkGreenKey(int time, int color)
	{
		this.darkGreenkey[time] = color;
	}

	public void setDarkBlueKey(int time, int color)
	{
		this.darkBluekey[time] = color;
	}

	public void setAngle1Key(int time, int i)
	{
		this.angle1key[time] = i;
	}

	public void setAngle2Key(int time, int i)
	{
		this.angle2key[time] = i;
	}

	public void setAutoRotateKey(int time, int i)
	{
		this.autoRotatekey[time] = i;
	}

	public void setRotationSpeedKey(int time, int i)
	{
		this.rotateSpeedkey[time] = i;
	}

	public void setSecondaryLazerKey(int time, int i)
	{
		this.secondaryLazerkey[time] = i;
	}

	public void setReverseRotationKey(int time, int i)
	{
		this.reverseRotationkey[time] = i;
	}

	// --Getter--------------------------

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

	public int getAngle1()
	{
		return this.angle1;
	}

	public int getAngle2()
	{
		return this.angle2;
	}

	public boolean getAutoRotate()
	{
		return this.autoRotate;
	}

	public int getRotationSpeed()
	{
		return this.rotationSpeed;
	}

	public boolean getSecondaryLazer()
	{
		return this.secondaryLazer;
	}

	public boolean getReverseRotation()
	{
		return this.reverseRotation;
	}

	public boolean getTimeLineMode()
	{
		return this.timeLineMode;
	}

	public int getTimeLine()
	{
		return this.timeLine;
	}

	public int getCreateKeyTime()
	{
		return this.createKeyTime;
	}

	public int getSelectedButtonid()
	{
		return this.selectedbuttonid;
	}

	public boolean hasKey(int time)
	{
		return this.keyList[time] == 1 ? true : false;
	}

	public int getRedKey(int time)
	{
		return this.redkey[time];
	}

	public int getGreenKey(int time)
	{
		return this.greenkey[time];
	}

	public int getBlueKey(int time)
	{
		return this.bluekey[time];
	}

	public int getDarkRedKey(int time)
	{
		return this.darkRedkey[time];
	}

	public int getDarkGreenKey(int time)
	{
		return this.darkGreenkey[time];
	}

	public int getDarkBlueKey(int time)
	{
		return this.darkBluekey[time];
	}

	public int getAngle1Key(int time)
	{
		return this.angle1key[time];
	}

	public int getAngle2Key(int time)
	{
		return this.angle2key[time];
	}

	public boolean getAutoRotateKey(int time)
	{
		return this.autoRotatekey[time] == 1 ? true : false;
	}

	public int getRotationSpeedKey(int time)
	{
		return this.rotateSpeedkey[time];
	}

	public boolean getSecondaryLazerKey(int time)
	{
		return this.secondaryLazerkey[time] == 1 ? true : false;
	}

	public boolean getReverseRotationKey(int time)
	{
		return this.reverseRotationkey[time] == 1 ? true : false;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex)
	{
		return inventory[slotIndex];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if(stack != null)
		{
			if(stack.stackSize <= amount)
			{
				setInventorySlotContents(slotIndex, null);
			}
			else
			{
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}

		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = getStackInSlot(slotIndex);
		if(stack != null)
		{
			setInventorySlotContents(slotIndex, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;

		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName()
	{
		return "container.spotLight";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public void openChest()
	{}

	@Override
	public void closeChest()
	{}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 65536.0D;
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

	public void addNbtTagToItem()
	{
		ItemStack stack = getStackInSlot(1);
		ItemStack newStack = new ItemStack(NanotechCityItems.configCopy);
		if(stack != null && stack.itemID == NanotechCityItems.configCopy.itemID)
		{
			newStack.setTagCompound(new NBTTagCompound());
			newStack.getTagCompound().setInteger("Type", 0);
			newStack.getTagCompound().setInteger("SpotLightRed", getRedValue());
			newStack.getTagCompound().setInteger("SpotLightGreen", getGreenValue());
			newStack.getTagCompound().setInteger("SpotLightBlue", getBlueValue());
			newStack.getTagCompound().setInteger("SpotLightDarkRed", getDarkRedValue());
			newStack.getTagCompound().setInteger("SpotLightDarkGreen", getDarkGreenValue());
			newStack.getTagCompound().setInteger("SpotLightDarkBlue", getDarkBlueValue());
			newStack.getTagCompound().setInteger("SpotLightAngle1", getAngle1());
			newStack.getTagCompound().setInteger("SpotLightAngle2", getAngle2());
			newStack.getTagCompound().setInteger("SpotLightAutoRotate", (getAutoRotate() ? 1 : 0));
			newStack.getTagCompound().setInteger("SpotLightRotationSpeed", (int)getRotationSpeed());
			newStack.getTagCompound().setInteger("SpotLightSecondaryLazer", (getSecondaryLazer() ? 1 : 0));
			newStack.getTagCompound().setInteger("SpotLightReverseRotation", (getReverseRotation() ? 0 : 1));

			newStack.getTagCompound().setInteger("SpotLightTimeLineMode", timeLineMode ? 1 : 0);
			newStack.getTagCompound().setIntArray("SpotLightHasKey", keyList);
			newStack.getTagCompound().setIntArray("SpotLightTimeRed", redkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeGreen", greenkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeBlue", bluekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkRed", darkRedkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkGreen", darkGreenkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkBlue", darkBluekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeAngle1", angle1key);
			newStack.getTagCompound().setIntArray("SpotLightTimeAngle2", angle2key);
			newStack.getTagCompound().setIntArray("SpotLightTimeAutoRotate", autoRotatekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeRotateSpeed", rotateSpeedkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeSecondaryLazer", secondaryLazerkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeReverseRotation", reverseRotationkey);
			setInventorySlotContents(1, newStack);
		}
	}

	public void setConfig()
	{
		ItemStack stack = getStackInSlot(1);
		if(stack != null && stack.itemID == NanotechCityItems.configCopy.itemID)
		{
			if(stack.hasTagCompound())
			{
				if(stack.getTagCompound().hasKey("Type") && stack.getTagCompound().getInteger("Type") == 0)
				{
					if(stack.getTagCompound().hasKey("SpotLightRed"))
					{
						setRedValue(stack.getTagCompound().getInteger("SpotLightRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightGreen"))
					{
						setGreenValue(stack.getTagCompound().getInteger("SpotLightGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightBlue"))
					{
						setBlueValue(stack.getTagCompound().getInteger("SpotLightBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkRed"))
					{
						setDarkRedValue(stack.getTagCompound().getInteger("SpotLightDarkRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkGreen"))
					{
						setDarkGreenValue(stack.getTagCompound().getInteger("SpotLightDarkGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkBlue"))
					{
						setDarkBlueValue(stack.getTagCompound().getInteger("SpotLightDarkBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAngle1"))
					{
						setAngle1Value(stack.getTagCompound().getInteger("SpotLightAngle1"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAngle2"))
					{
						setAngle2Value(stack.getTagCompound().getInteger("SpotLightAngle2"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAutoRotate"))
					{
						setRotateValue(stack.getTagCompound().getInteger("SpotLightAutoRotate"));
					}
					if(stack.getTagCompound().hasKey("SpotLightRotationSpeed"))
					{
						setRotationSpeed(stack.getTagCompound().getInteger("SpotLightRotationSpeed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightSecondaryLazer"))
					{
						setSecondaryLazer(stack.getTagCompound().getInteger("SpotLightSecondaryLazer"));
					}
					if(stack.getTagCompound().hasKey("SpotLightReverseRotation"))
					{
						setReverseRotation((stack.getTagCompound().getInteger("SpotLightReverseRotation") == 1 ? 0 : 1));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeLineMode"))
					{
						setTimeLineMode((stack.getTagCompound().getInteger("SpotLightTimeLineMode")));
					}
					if(stack.getTagCompound().hasKey("SpotLightHasKey"))
					{
						keyList = (stack.getTagCompound().getIntArray("SpotLightHasKey"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeRed"))
					{
						redkey = (stack.getTagCompound().getIntArray("SpotLightTimeRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeGreen"))
					{
						greenkey = (stack.getTagCompound().getIntArray("SpotLightTimeGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeBlue"))
					{
						bluekey = (stack.getTagCompound().getIntArray("SpotLightTimeBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkRed"))
					{
						darkRedkey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkGreen"))
					{
						darkGreenkey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkBlue"))
					{
						darkBluekey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAngle1"))
					{
						angle1key = (stack.getTagCompound().getIntArray("SpotLightTimeAngle1"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAngle2"))
					{
						angle2key = (stack.getTagCompound().getIntArray("SpotLightTimeAngle2"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAutoRotate"))
					{
						autoRotatekey = (stack.getTagCompound().getIntArray("SpotLightTimeAutoRotate"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeRotateSpeed"))
					{
						rotateSpeedkey = (stack.getTagCompound().getIntArray("SpotLightTimeRotateSpeed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeSecondaryLazer"))
					{
						secondaryLazerkey = (stack.getTagCompound().getIntArray("SpotLightTimeSecondaryLazer"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeReverseRotation"))
					{
						reverseRotationkey = (stack.getTagCompound().getIntArray("SpotLightTimeReverseRotation"));
					}
				}
			}
		}
	}
}