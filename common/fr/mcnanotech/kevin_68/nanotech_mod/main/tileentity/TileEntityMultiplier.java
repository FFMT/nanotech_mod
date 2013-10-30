package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMultiplier extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[2];
	private String customName;

	public void updateEntity()
	{
		if(this.inventory[0] == null && this.inventory[1] != null)
		{
			this.inventory[0] = this.inventory[1].copy();
			this.inventory[0].stackSize = 64;
		}
		else if(this.inventory[0] != null && this.inventory[1] != null)
		{
			if(!this.isItemStackEqualWithoutQuantity(inventory[0], inventory[1]))
			{
				this.inventory[0] = this.inventory[1].copy();
				this.inventory[0].stackSize = 64;
			}
		}
		if(this.inventory[0] != null && this.inventory[0].stackSize < 64)
		{
			this.inventory[0].stackSize = 64;
		}
	}

	@Override
	public String getInvName()
	{
		return "container.multiplier";
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
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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
	public void readFromNBT(NBTTagCompound nbttagCompound)
	{
		super.readFromNBT(nbttagCompound);

		NBTTagList tagList = nbttagCompound.getTagList("Inventory");

		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound)tagList.tagAt(i);
			byte slot = tag.getByte("Slot");

			if(slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		if(nbttagCompound.hasKey("Name"))
		{
			this.customName = nbttagCompound.getString("Name");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagCompound)
	{
		super.writeToNBT(nbttagCompound);

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
		nbttagCompound.setTag("Inventory", itemList);

		if(this.customName != null)
		{
			nbttagCompound.setString("Name", this.customName);
		}
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
	public void openChest()
	{}

	@Override
	public void closeChest()
	{}

	@Override
	public boolean isInvNameLocalized()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomName(String name)
	{
		this.customName = name;
	}

	public String getCustomName()
	{
		return this.customName;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		return false;
	}

	private boolean isItemStackEqualWithoutQuantity(ItemStack stack, ItemStack stack2)
	{
		return stack.itemID != stack2.itemID ? false : (stack.getItemDamage() != stack2.getItemDamage() ? false : (stack.stackTagCompound == null && stack2.stackTagCompound != null ? false : stack.stackTagCompound == null || stack.stackTagCompound.equals(stack2.stackTagCompound)));
	}
}