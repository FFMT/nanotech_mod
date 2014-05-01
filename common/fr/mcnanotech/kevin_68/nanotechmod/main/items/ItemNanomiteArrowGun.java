/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNanomiteArrowGun extends ItemBow
{
	private int timer = 0;

	public ItemNanomiteArrowGun()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(300000);
		this.setFull3D();
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}

			if(player.isSneaking())
			{
				if(stack.getTagCompound().hasKey("Mode"))
				{
					if(stack.getTagCompound().getByte("Mode") < 3)
					{
						stack.getTagCompound().setByte("Mode", (byte)(stack.getTagCompound().getByte("Mode") + 1));
					}
					else
					{
						stack.getTagCompound().setByte("Mode", (byte)0);
					}
					player.addChatMessage(new ChatComponentText(this.getInfo(stack.getTagCompound().getByte("Mode"))));
				}
				else
				{
					stack.getTagCompound().setByte("Mode", (byte)1);
					player.addChatMessage(new ChatComponentText(this.getInfo((byte)1)));
				}
				return stack;
			}
			else
			{
				if(!stack.getTagCompound().hasKey("Mode"))
				{
					this.shoot(stack, world, player);
					return stack;
				}
				else
				{
					if(stack.getTagCompound().getByte("Mode") == 0)
					{
						this.shoot(stack, world, player);
						return stack;
					}
				}
			}
		}
		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isCurrentItem)
	{
		if(isCurrentItem && entity instanceof EntityPlayer && !world.isRemote)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if(stack.hasTagCompound())
			{
				if(stack.getTagCompound().hasKey("Mode"))
				{
					byte mode = stack.getTagCompound().getByte("Mode");
					if(mode == 1 || mode == 2)
					{
						if(this.timer <= 0)
						{
							this.shoot(stack, world, player);
							this.timer = (mode == 1 ? 16 : 4);
						}
						else
						{
							this.timer--;
						}
					}
					else if(mode == 3)
					{
						if(this.timer <= 0)
						{
							final IEntitySelector livingFilter = new NanoArrowGunEntityFilter();
							List entityTagetList = world.selectEntitiesWithinAABB(Entity.class, player.boundingBox.expand(64.0D, 64.0D, 64.0D), livingFilter);
							for(int i = 0; i < entityTagetList.size(); i++)
							{
								Entity entityTarget = (Entity)entityTagetList.get(i);
								if(entityTarget != player && entityTarget instanceof EntityLivingBase)
								{
									EntityLivingBase entityLivingTarget = (EntityLivingBase)entityTarget;
									Vec3 vec3 = player.getLook(1.0F).normalize();
									Vec3 vec31 = entityLivingTarget.worldObj.getWorldVec3Pool().getVecFromPool(entityLivingTarget.posX - player.posX, entityLivingTarget.boundingBox.minY + (double)(entityLivingTarget.height / 2.0F) - (player.posY + (double)player.getEyeHeight()), entityLivingTarget.posZ - player.posZ);
									double d0 = vec31.lengthVector();
									vec31 = vec31.normalize();
									double d1 = vec3.dotProduct(vec31);
									if(d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(entityLivingTarget))
									{
										this.shoot(stack, world, player);
									}
								}
							}
							this.timer = 6;
						}

						else
						{
							this.timer--;
						}
					}
				}
			}
		}
	}

	public void shoot(ItemStack stack, World world, EntityPlayer player)
	{
		boolean creativeOrInfinity = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

		if(creativeOrInfinity || player.inventory.hasItem(Items.arrow))
		{
			float power = 1.0F;
			EntityArrow arrow = new EntityArrow(world, player, power * 6.0F);
			arrow.setIsCritical(true);

			int powerLvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

			if(powerLvl > 0)
			{
				arrow.setDamage(arrow.getDamage() + (double)powerLvl * 0.5D + 0.5D);
			}

			int punchLvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

			if(punchLvl > 0)
			{
				arrow.setKnockbackStrength(punchLvl);
			}

			if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
			{
				arrow.setFire(100);
			}

			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + power * 0.5F);

			if(creativeOrInfinity)
			{
				arrow.canBePickedUp = 2;
			}
			else
			{
				player.inventory.consumeInventoryItem(Items.arrow);
			}
			world.spawnEntityInWorld(arrow);
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey("Mode"))
			{
				byte mode = stack.getTagCompound().getByte("Mode");
				list.add(this.getInfo(mode));
				return;
			}
			list.add(getInfo((byte)0));
		}
	}

	public int getItemEnchantability()
	{
		return 1;
	}

	private String getInfo(byte mode)
	{
		String info = "";
		switch(mode)
		{
		case 0:
			info = "nanomiteGun.manual";
			break;
		case 1:
			info = "nanomiteGun.auto.slow";
			break;
		case 2:
			info = "nanomiteGun.auto.fast";
			break;
		case 3:
			info = "nanomiteGun.auto.detect";
			break;
		}
		return StatCollector.translateToLocal(info);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
	}
}