/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.Loader;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;

public class NanotechServerTickHandler
{
	// TODO fml event
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{}

	// TODO fml event
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer player = (EntityPlayer)tickData[0];
		if(player.inventory.armorItemInSlot(3) == null && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).itemID == NanotechItem.crazyGlasses.itemID)
					{
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses.itemID);
					}
				}
			}
		}
		else if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).itemID != NanotechItem.crazyGlasses.itemID && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).itemID == NanotechItem.crazyGlasses.itemID)
					{
						player.inventory.setInventorySlotContents(i, player.inventory.armorItemInSlot(3).copy());
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses.itemID);
					}
				}
			}
		}
		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).itemID == NanotechItem.nitrogenBucket.itemID)
				{
					Random rand = new Random();
					if(rand.nextInt(100) < 2 && this.doEffect(player))
					{
						player.attackEntityFrom(NanotechDamageSource.nitrogenDamage, 1);
					}
				}
			}
		}

		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).itemID == NanotechBlock.machine.blockID && player.inventory.getStackInSlot(i).getItemDamage() == 0)
				{
					if(player.inventory.getCurrentItem() != player.inventory.getStackInSlot(i))
					{
						int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

						int x = (int)player.posX;
						int y = (int)player.posY;
						int z = (int)player.posZ;

						for(int g = -3; g != 3; g++)
						{
							for(int h = -3; h != 3; h++)
							{
								for(int f = -3; f != 3; f++)
								{
									if(player.worldObj.isAirBlock((int)player.posX + h, (int)player.posY + f, (int)player.posZ + g))
									{
										x = (int)player.posX + h;
										y = (int)player.posY + f;
										z = (int)player.posZ + g;
									}
								}
							}
						}

						while(player.worldObj.isAirBlock(x, y - 1, z) && y > 0)
						{
							y--;
						}

						player.worldObj.setBlock(x, y, z, NanotechBlock.machine.blockID, 0, 2);
						TileEntity te = player.worldObj.getBlockTileEntity(x, y, z);
						if(te != null && te instanceof TileEntityPortableChest)
						{
							TileEntityPortableChest teChest = (TileEntityPortableChest)te;
							teChest.setDirection((byte)direction);

							if(player.inventory.getStackInSlot(i).hasTagCompound())
							{
								if(player.inventory.getStackInSlot(i).hasDisplayName())
								{
									teChest.setCustomGuiName(player.inventory.getStackInSlot(i).getDisplayName());
								}

								NBTTagList nbttaglist = player.inventory.getStackInSlot(i).getTagCompound().getTagList("Items");
								for(int j = 0; j < nbttaglist.tagCount(); j++)
								{
									NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(j);
									int k = nbttagcompound1.getByte("Slot");

									if(k >= 0 && k < teChest.inventory.length)
									{
										teChest.inventory[k] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
									}
								}
							}
						}
						player.inventory.decrStackSize(i, 1);
						player.worldObj.markBlockForUpdate(x, y, z);
					}
				}
			}
		}
	}

	private boolean doEffect(EntityPlayer player)
	{
		ItemStack helmet = player.getCurrentItemOrArmor(4);
		ItemStack chestPlate = player.getCurrentItemOrArmor(3);
		ItemStack leggings = player.getCurrentItemOrArmor(2);
		ItemStack boots = player.getCurrentItemOrArmor(1);
		if(helmet != null && chestPlate != null && leggings != null && boots != null)
		{
			if(helmet.getItem().equals(NanotechItem.mysteriousHelmet) && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && boots.getItem().equals(NanotechItem.mysteriousBoots))
			{
				return false;
			}
			if(Loader.isModLoaded("UltimateGraviSuite"))
			{
				if(helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet) && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate) && leggings.getItem().equals(UltimateGraviSuite.ultimateLeggings) && boots.getItem().equals(UltimateGraviSuite.ultimateBoots))
				{
					return false;
				}
			}
		}
		return true;
	}

	// TODO fml event
	public String getLabel()
	{
		return "Nanotech Mod - auto set crazy glasses";
	}
}