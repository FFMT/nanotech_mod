/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechFluid;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;

public class EventTick
{
	@SuppressWarnings("static-access")
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event)
	{
		for(int i = 0; i < event.player.inventory.getSizeInventory(); i++)
		{
			if(event.player.inventory.getStackInSlot(i) != null)
			{
				if(event.player.inventory.getStackInSlot(i).getItem().equals(NanotechItem.alters))
				{
					if(event.player.isInsideOfMaterial(Material.water) || event.player.isInsideOfMaterial(Material.lava))
					{
						if(!event.player.capabilities.isCreativeMode)
						{
							Minecraft mc = Minecraft.getMinecraft();
							if(mc.gameSettings.isKeyDown(mc.gameSettings.keyBindJump))
							{
								// TODO if key down pressed, cancel
							}
						}
					}
				}
			}
		}

		if(event.player.inventory.armorItemInSlot(3) == null && !event.player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < event.player.inventory.getSizeInventory(); i++)
			{
				if(event.player.inventory.getStackInSlot(i) != null)
				{
					if(event.player.inventory.getStackInSlot(i).getItem() == NanotechItem.crazyGlasses)
					{
						event.player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						event.player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses);
					}
				}
			}
		}
		else if(event.player.inventory.armorItemInSlot(3) != null && event.player.inventory.armorItemInSlot(3).getItem() != NanotechItem.crazyGlasses && !event.player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < event.player.inventory.getSizeInventory(); i++)
			{
				if(event.player.inventory.getStackInSlot(i) != null)
				{
					if(event.player.inventory.getStackInSlot(i).getItem() == NanotechItem.crazyGlasses)
					{
						event.player.inventory.setInventorySlotContents(i, event.player.inventory.armorItemInSlot(3).copy());
						event.player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						event.player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses);
					}
				}
			}
		}
		for(int i = 0; i < event.player.inventory.getSizeInventory(); i++)
		{
			if(event.player.inventory.getStackInSlot(i) != null)
			{
				if(event.player.inventory.getStackInSlot(i).getItem() == NanotechFluid.bucketNitrogen)
				{
					Random rand = new Random();
					if(rand.nextInt(100) < 2 && this.doEffect(event.player))
					{
						event.player.attackEntityFrom(NanotechDamageSource.nitrogenDamage, 1);
					}
				}
			}
		}

		for(int i = 0; i < event.player.inventory.getSizeInventory(); i++)
		{
			if(event.player.inventory.getStackInSlot(i) != null)
			{
				if(event.player.inventory.getStackInSlot(i).getItem() == Item.getItemFromBlock(NanotechBlock.machine) && event.player.inventory.getStackInSlot(i).getItemDamage() == 0)
				{
					if(event.player.inventory.getCurrentItem() != event.player.inventory.getStackInSlot(i))
					{
						int direction = MathHelper.floor_double((double)(event.player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

						int x = (int)event.player.posX;
						int y = (int)event.player.posY;
						int z = (int)event.player.posZ;

						for(int g = -3; g != 3; g++)
						{
							for(int h = -3; h != 3; h++)
							{
								for(int f = -3; f != 3; f++)
								{
									if(event.player.worldObj.isAirBlock((int)event.player.posX + h, (int)event.player.posY + f, (int)event.player.posZ + g))
									{
										x = (int)event.player.posX + h;
										y = (int)event.player.posY + f;
										z = (int)event.player.posZ + g;
									}
								}
							}
						}

						while(event.player.worldObj.isAirBlock(x, y - 1, z) && y > 0)
						{
							y--;
						}

						event.player.worldObj.setBlock(x, y, z, NanotechBlock.machine, 0, 2);
						TileEntity te = event.player.worldObj.getTileEntity(x, y, z);
						if(te != null && te instanceof TileEntityPortableChest)
						{
							TileEntityPortableChest teChest = (TileEntityPortableChest)te;
							teChest.setDirection((byte)direction);

							if(event.player.inventory.getStackInSlot(i).hasTagCompound())
							{
								if(event.player.inventory.getStackInSlot(i).hasDisplayName())
								{
									teChest.setCustomGuiName(event.player.inventory.getStackInSlot(i).getDisplayName());
								}

								NBTTagList nbttaglist = event.player.inventory.getStackInSlot(i).getTagCompound().getTagList("Items", 1);
								for(int j = 0; j < nbttaglist.tagCount(); j++)
								{
									NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(j);
									int k = nbttagcompound1.getByte("Slot");

									if(k >= 0 && k < teChest.inventory.length)
									{
										teChest.inventory[k] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
									}
								}
							}
						}
						event.player.inventory.decrStackSize(i, 1);
						event.player.worldObj.markBlockForUpdate(x, y, z);
					}
				}
			}
		}
	}

	private boolean doEffect(EntityPlayer player)
	{
		ItemStack helmet = player.getCurrentArmor(4);
		ItemStack chestPlate = player.getCurrentArmor(3);
		ItemStack leggings = player.getCurrentArmor(2);
		ItemStack boots = player.getCurrentArmor(1);
		if(helmet != null && chestPlate != null && leggings != null && boots != null)
		{
			if(helmet.getItem().equals(NanotechItem.mysteriousHelmet) && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && boots.getItem().equals(NanotechItem.mysteriousBoots))
			{
				return false;
			}
			if(Loader.isModLoaded("UltimateGraviSuite"))
			{
				/*
				 * if(helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet)
				 * && chestPlate.getItem().equals(UltimateGraviSuite.
				 * ultimateGraviChestPlate) &&
				 * leggings.getItem().equals(UltimateGraviSuite
				 * .ultimateLeggings) &&
				 * boots.getItem().equals(UltimateGraviSuite.ultimateBoots)) {
				 * return false; }
				 */
			}
		}
		return true;
	}
}
