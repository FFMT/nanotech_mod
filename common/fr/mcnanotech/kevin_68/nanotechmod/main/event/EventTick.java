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
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechFluid;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;

public class EventTick
{
	// TODO fix tick
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event)
	{
		if(event.phase == Phase.END)
		{
			if(event.side == Side.CLIENT)
			{
				this.tickClientPlayer(event.player);
			}
			else
			{
				this.tickServerPlayer(event.player);
			}
		}
	}

	private void tickClientPlayer(EntityPlayer player)
	{
		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).getItem().equals(NanotechItem.alters))
				{
					if(player.isInsideOfMaterial(Material.water) || player.isInsideOfMaterial(Material.lava))
					{
						if(!player.capabilities.isCreativeMode)
						{
							Minecraft mc = FMLClientHandler.instance().getClient();
							if(mc.gameSettings.isKeyDown(mc.gameSettings.keyBindJump))
							{
								mc.gameSettings.keyBindJump.unPressAllKeys();
							}
						}
					}
				}
			}
		}
	}

	private void tickServerPlayer(EntityPlayer player)
	{
		if(player.inventory.armorItemInSlot(3) == null && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).getItem() == NanotechItem.crazyGlasses)
					{
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses);
					}
				}
			}
		}
		else if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() != NanotechItem.crazyGlasses && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).getItem() == NanotechItem.crazyGlasses)
					{
						player.inventory.setInventorySlotContents(i, player.inventory.armorItemInSlot(3).copy());
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses);
					}
				}
			}
		}
		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).getItem() == NanotechFluid.bucketNitrogen)
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
				if(player.inventory.getStackInSlot(i).getItem() == Item.getItemFromBlock(NanotechBlock.machine) && player.inventory.getStackInSlot(i).getItemDamage() == 0)
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

						player.worldObj.setBlock(x, y, z, NanotechBlock.machine, 0, 2);
						TileEntity te = player.worldObj.getTileEntity(x, y, z);
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

								NBTTagList nbttaglist = player.inventory.getStackInSlot(i).getTagCompound().getTagList("Items", 1);
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
						player.inventory.decrStackSize(i, 1);
						player.worldObj.markBlockForUpdate(x, y, z);
					}
				}
			}
		}
	}

	private boolean doEffect(EntityPlayer player)
	{
		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chestPlate = player.getCurrentArmor(2);
		ItemStack leggings = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);
		if(helmet != null && chestPlate != null && leggings != null && boots != null)
		{
			if(helmet.getItem() == NanotechItem.mysteriousHelmet && chestPlate.getItem() == NanotechItem.mysteriousChestPlate && leggings.getItem() == NanotechItem.mysteriousLeggings && boots.getItem() == NanotechItem.mysteriousBoots)
			{
				return false;
			}
			if(Loader.isModLoaded("UltimateGraviSuite"))
			{
				Item ultiHelmet = GameRegistry.findItem("UltimateGraviSuite", "ultimateHelmet");
				Item ultiChestPlate = GameRegistry.findItem("UltimateGraviSuite", "ultimateGraviChestPlate");
				Item ultiLeggings = GameRegistry.findItem("UltimateGraviSuite", "ultimateLeggings");
				Item ultiBoots = GameRegistry.findItem("UltimateGraviSuite", "ultimateBoots");
				if(helmet.getItem() == ultiHelmet && chestPlate.getItem() == ultiChestPlate && leggings.getItem() == ultiLeggings && boots.getItem() == ultiBoots)
				{
					return false;
				}
			}
		}
		return true;
	}
}
