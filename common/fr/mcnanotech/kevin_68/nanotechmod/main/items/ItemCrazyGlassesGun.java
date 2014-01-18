package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.minecraftforgefrance.ffmtlibs.FFMTContainerHelper;

public class ItemCrazyGlassesGun extends ItemBow
{
	public int timer = 0;

	public ItemCrazyGlassesGun(int id)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(300000);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:crazyglassesgunitem");
	}

	public ItemStack onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}

			if(!stack.getTagCompound().hasKey("IsPlayingSound"))
			{
				stack.getTagCompound().setBoolean("IsPlayingSound", false);
			}

			if(stack.getTagCompound().hasKey("Charge"))
			{
				if(stack.getTagCompound().getByte("Charge") > 0)
				{
					if(!stack.getTagCompound().getBoolean("Reload"))
					{
						this.shoot(stack, world, player);
						if((stack.getTagCompound().getByte("Charge") - 1) == 0)
						{
							stack.getTagCompound().setBoolean("Reload", true);
							stack.getTagCompound().setBoolean("IsPlayingSound", false);
						}
						stack.getTagCompound().setByte("Charge", (byte)(stack.getTagCompound().getByte("Charge") - 1));

					}
				}
				else
				{
					stack.getTagCompound().setBoolean("Reload", true);
				}
			}
			else
			{
				stack.getTagCompound().setByte("Charge", (byte)0);
			}
		}
		return stack;
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isCurrentItem)
	{
		if(!world.isRemote)
		{
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				if(player.inventory.hasItemStack(new ItemStack(NanotechItem.itemBase, 1, 20)))
				{
					if(!stack.hasTagCompound())
					{
						stack.setTagCompound(new NBTTagCompound());
					}

					if(stack.getTagCompound().hasKey("Reload"))
					{
						if(stack.getTagCompound().getBoolean("Reload"))
						{
							if(timer == 40)
							{
								stack.getTagCompound().setBoolean("Reload", false);
								timer = 0;
							}
							else if(timer == 6 || timer == 16 || timer == 26 || timer == 36)
							{
								if(FFMTContainerHelper.consumeItemWithMetadataInInventory((EntityPlayer)entity, NanotechItem.itemBase.itemID, 20))
								{
									stack.getTagCompound().setByte("Charge", (byte)(stack.getTagCompound().getByte("Charge") + 1));
								}
								timer++;
							}
							else if(timer == 1)
							{
								if(!stack.getTagCompound().getBoolean("IsPlayingSound"))
								{
									world.playSoundAtEntity(entity, "nanotech_mod:crazyglassesgunreload", 1.0F, 1.0F);
									stack.getTagCompound().setBoolean("IsPlayingSound", true);
								}
								timer++;
							}
							else
							{
								timer++;
							}
						}
					}
					else
					{
						stack.getTagCompound().setBoolean("Reload", true);
					}
				}
			}
		}
	}

	public void shoot(ItemStack stack, World world, EntityPlayer player)
	{
		if(player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(NanotechItem.itemBase, 1, 20)))
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			EntityItem glasses = new EntityItem(world);
			glasses.delayBeforeCanPickup = 5;
			glasses.setEntityItemStack(new ItemStack(NanotechItem.crazyGlasses, 1, 0));
			glasses.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
			glasses.posX -= (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			glasses.posY -= 0.10000000149011612D;
			glasses.posZ -= (double)(MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			glasses.setPosition(glasses.posX, glasses.posY, glasses.posZ);
			glasses.yOffset = 0.0F;
			glasses.motionX = (double)(-MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
			glasses.motionZ = (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
			glasses.motionY = (double)(-MathHelper.sin(glasses.rotationPitch / 180.0F * (float)Math.PI));
			world.spawnEntityInWorld(glasses);

			EntityItem iron = new EntityItem(world);
			iron.delayBeforeCanPickup = 5;
			iron.setEntityItemStack(new ItemStack(Item.ingotIron, 2, 0));
			iron.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
			iron.posX -= (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			iron.posY -= 0.10000000149011612D;
			iron.posZ -= (double)(MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			iron.setPosition(glasses.posX, glasses.posY, glasses.posZ);
			iron.yOffset = 0.0F;
			iron.motionX = (double)(-MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
			iron.motionZ = (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
			iron.motionY = (double)(-MathHelper.sin(glasses.rotationPitch / 180.0F * (float)Math.PI));
			world.spawnEntityInWorld(iron);
		}
	}

	public int getItemEnchantability()
	{
		return 1;
	}
}