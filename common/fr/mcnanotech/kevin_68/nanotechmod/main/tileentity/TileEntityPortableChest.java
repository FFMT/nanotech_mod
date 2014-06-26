/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerPortableChest;

@SuppressWarnings("rawtypes")
public class TileEntityPortableChest extends TileEntity implements IInventory
{
	public ItemStack[] inventory = new ItemStack[72];
	private String customName;
	private byte direction;
	public float lidAngle;
	public float prevLidAngle;
	public int numUsingPlayers;
	private int ticksSinceSync;

	public void readFromNBT(NBTTagCompound nbttag)
	{
		super.readFromNBT(nbttag);
		direction = nbttag.getByte("Direction");

		NBTTagList nbttaglist = nbttag.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		if(nbttag.hasKey("CustomName"))
		{
			this.customName = nbttag.getString("CustomName");
		}

		for(int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot");

			if(j >= 0 && j < this.inventory.length)
			{
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	public void writeToNBT(NBTTagCompound nbttag)
	{
		super.writeToNBT(nbttag);
		nbttag.setByte("Direction", direction);

		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < this.inventory.length; i++)
		{
			if(this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbttag.setTag("Items", nbttaglist);

		if(this.hasCustomInventoryName())
		{
			nbttag.setString("CustomName", this.customName);
		}
	}

	public byte getDirection()
	{
		return this.direction;
	}

	public void setDirection(byte b)
	{
		this.direction = b;
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

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotId)
	{
		return inventory[slotId];
	}

	@Override
	public ItemStack decrStackSize(int slotId, int quantity)
	{
		if(this.inventory[slotId] != null)
		{
			ItemStack itemstack;

			if(this.inventory[slotId].stackSize <= quantity)
			{
				itemstack = this.inventory[slotId];
				this.inventory[slotId] = null;

				this.markDirty();
				return itemstack;
			}
			else
			{
				itemstack = this.inventory[slotId].splitStack(quantity);

				if(this.inventory[slotId].stackSize == 0)
				{
					this.inventory[slotId] = null;
				}

				this.markDirty();
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotId)
	{
		if(this.inventory[slotId] != null)
		{
			ItemStack itemstack = this.inventory[slotId];
			this.inventory[slotId] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slotId, ItemStack stack)
	{
		this.inventory[slotId] = stack;

		if(stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();
	}

	@Override
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.customName : "container.portablechest.name";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomGuiName(String name)
	{
		this.customName = name;
	}

	public String getCustomGuiName()
	{
		return this.customName;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory()
	{
		if(this.numUsingPlayers < 0)
		{
			this.numUsingPlayers = 0;
		}

		++this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
	}

	@Override
	public void closeInventory()
	{
		--this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);

	}

	@Override
	public boolean isItemValidForSlot(int slotId, ItemStack stack)
	{
		return true;
	}

	public boolean receiveClientEvent(int eventId, int eventValue)
	{
		if(eventId == 1)
		{
			this.numUsingPlayers = eventValue;
			return true;
		}
		else
		{
			return super.receiveClientEvent(eventId, eventValue);
		}
	}

	public void updateEntity()
	{
		super.updateEntity();
		++this.ticksSinceSync;

		if(!this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
		{
			this.numUsingPlayers = 0;
			List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.xCoord - 5, this.yCoord - 5, this.zCoord - 5, this.xCoord + 6, this.yCoord + 6, this.zCoord + 6));
			Iterator iterator = list.iterator();

			while(iterator.hasNext())
			{
				EntityPlayer entityplayer = (EntityPlayer)iterator.next();

				if(entityplayer.openContainer instanceof ContainerPortableChest)
				{
					++this.numUsingPlayers;
				}
			}
		}

		this.prevLidAngle = this.lidAngle;

		if(this.numUsingPlayers > 0 && this.lidAngle == 0.0F)
		{
			this.worldObj.playSoundEffect(((double)this.xCoord + 0.5), (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if(this.numUsingPlayers == 0 && this.lidAngle > 0.0F || this.numUsingPlayers > 0 && this.lidAngle < 1.0F)
		{
			float f1 = this.lidAngle;

			if(this.numUsingPlayers > 0)
			{
				this.lidAngle += 0.1F;
			}
			else
			{
				this.lidAngle -= 0.1F;
			}

			if(this.lidAngle > 1.0F)
			{
				this.lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if(this.lidAngle < f2 && f1 >= f2)
			{
				this.worldObj.playSoundEffect((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if(this.lidAngle < 0.0F)
			{
				this.lidAngle = 0.0F;
			}
		}
	}
}