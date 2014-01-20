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
	private boolean[] hasKey = new boolean[120];
	private int[][] color = new int[120][6];
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
	public float rotationSpeed;
	public boolean secondaryLazer;
	public boolean reverseRotation;

	public boolean timeLineMode;
	public int timeLine;

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
		nbtTagCompound.setFloat("SpotLightRotationSpeed", rotationSpeed);
		nbtTagCompound.setBoolean("SpotLightSecondaryLaser", secondaryLazer);
		nbtTagCompound.setBoolean("SpotLightReverseRotation", reverseRotation);

		nbtTagCompound.setBoolean("SpotLightTimeLineMode", timeLineMode);
		nbtTagCompound.setInteger("SpotLightTimeLine", timeLine);

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

		NBTTagList booleanList = new NBTTagList();
		for(int i = 0; i < hasKey.length; i++)
		{
			boolean boo = this.hasKey[i];
			NBTTagCompound tag = new NBTTagCompound();
			tag.setBoolean("Key" + i, boo);
			booleanList.appendTag(tag);
		}
		nbtTagCompound.setTag("HasKey", booleanList);

		if(this.customName != null)
		{
			nbtTagCompound.setString("Name", this.customName);
		}

		NBTTagList keyList = new NBTTagList();
		for(int i = 0; i < 120; i++)
		{
			NBTTagList typeList = new NBTTagList();
			typeList.setName("TypeList:Key:" + i);
			for(int j = 0; j < 6; j++)
			{
				int colo = this.color[i][j];
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("KeyColor:" + j, colo);
				typeList.appendTag(tag);
			}
			keyList.appendTag(typeList);
		}
		nbtTagCompound.setTag("KeyList", keyList);

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
		rotationSpeed = nbtTagCompound.getFloat("SpotLightRotationSpeed");
		secondaryLazer = nbtTagCompound.getBoolean("SpotLightSecondaryLaser");
		reverseRotation = nbtTagCompound.getBoolean("SpotLightReverseRotation");

		timeLineMode = nbtTagCompound.getBoolean("SpotLightTimeLineMode");
		timeLine = nbtTagCompound.getInteger("SpotLightTimeLine");

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

		NBTTagList tagList2 = nbtTagCompound.getTagList("HasKey");
		for(int i = 0; i < hasKey.length; i++)
		{
			NBTTagCompound tag = (NBTTagCompound)tagList2.tagAt(i);
			if(tag != null)
			{
				boolean boo = tag.getBoolean("Key" + i);
				hasKey[i] = boo;
			}
		}

		NBTTagList tagList3 = nbtTagCompound.getTagList("KeyList");
		for(int i = 0; i < 120; i++)
		{
			NBTTagList tagList4 = nbtTagCompound.getTagList("TypeList:Key:" + i);
			for(int j = 0; j < 6; j++)
			{
				NBTTagCompound tag = (NBTTagCompound)tagList4.tagAt(j);
				if(tag != null)
				{
					int colo = tag.getInteger("KeyColor:" + j);
					color[i][j] = colo;
				}
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

	public float getRotationSpeed()
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
				}
			}
		}
	}
}