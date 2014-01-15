package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.items.NanotechCityItems;

public class TileEntityTextSpotLight extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[2];
	private String customName;

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
	public float scale;
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
		nbtTagCompound.setFloat("Scale", scale);
		nbtTagCompound.setInteger("Height", height);

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
		this.signText = nbtTagCompound.getString("Text");
		this.rotate = nbtTagCompound.getBoolean("Rotate");
		this.angle = nbtTagCompound.getInteger("Angle");
		this.rotationSpeed = nbtTagCompound.getFloat("RotationSpeed");
		this.reverseRotation = nbtTagCompound.getBoolean("ReverseRotation");
		this.red = nbtTagCompound.getInteger("Red");
		this.green = nbtTagCompound.getInteger("Green");
		this.blue = nbtTagCompound.getInteger("Blue");
		this.scale = nbtTagCompound.getFloat("Scale");
		this.height = nbtTagCompound.getInteger("Height");

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

	public void setScale(float i)
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

	public float getScale()
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
		return "container.textspotLight";
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
	public void addNbtTagToItem()
	{
		ItemStack stack = getStackInSlot(1);
		ItemStack newStack = new ItemStack(NanotechCityItems.configCopy);
		if(stack != null && stack.itemID == NanotechCityItems.configCopy.itemID)
		{
			newStack.setTagCompound(new NBTTagCompound());
			newStack.getTagCompound().setInteger("Type", 1);
			newStack.getTagCompound().setString("TextSpotLightText", getText());
			newStack.getTagCompound().setInteger("TextSpotLightRed", getRedValue());
			newStack.getTagCompound().setInteger("TextSpotLightGreen", getGreenValue());
			newStack.getTagCompound().setInteger("TextSpotLightBlue", getBlueValue());
			newStack.getTagCompound().setInteger("TextSpotLightAngle", getAngle());
			newStack.getTagCompound().setInteger("TextSpotLightAutoRotate", (getRotate() ? 1 : 0));
			newStack.getTagCompound().setInteger("TextSpotLightRotationSpeed", (int)getRotationSpeed());
			newStack.getTagCompound().setInteger("TextSpotLightReverseRotation", (getReverseRotation() ? 0 : 1));
			newStack.getTagCompound().setFloat("TextSpotLightScale", getScale());
			newStack.getTagCompound().setInteger("TextSpotLightHeight", getHeight());
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
				if(stack.getTagCompound().hasKey("Type") && stack.getTagCompound().getInteger("Type") == 1)
				{
					if(stack.getTagCompound().hasKey("TextSpotLightText"))
					{
						setText(stack.getTagCompound().getString("TextSpotLightText"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightRed"))
					{
						setRedValue(stack.getTagCompound().getInteger("TextSpotLightRed"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightGreen"))
					{
						setGreenValue(stack.getTagCompound().getInteger("TextSpotLightGreen"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightBlue"))
					{
						setBlueValue(stack.getTagCompound().getInteger("TextSpotLightBlue"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightAngle"))
					{
						setAngle(stack.getTagCompound().getInteger("TextSpotLightAngle"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightAutoRotate"))
					{
						setRotate((stack.getTagCompound().getInteger("TextSpotLightAutoRotate") == 1 ? true : false));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightRotationSpeed"))
					{
						setRotationSpeed(stack.getTagCompound().getInteger("TextSpotLightRotationSpeed"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightReverseRotation"))
					{
						setReverseRotation((stack.getTagCompound().getInteger("TextSpotLightReverseRotation") == 1 ? false : true));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightScale"))
					{
						setScale(stack.getTagCompound().getFloat("TextSpotLightScale"));
					}
					if(stack.getTagCompound().hasKey("TextSpotLightHeight"))
					{
						setHeight(stack.getTagCompound().getInteger("TextSpotLightHeight"));
					}
				}
			}
		}
	}
}
