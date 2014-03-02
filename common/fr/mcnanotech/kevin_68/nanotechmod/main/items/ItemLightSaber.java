/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;

public class ItemLightSaber extends Item
{
	public ItemLightSaber()
	{
		this.maxStackSize = 1;
		this.setMaxDamage(1500);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(player.isSneaking())
			{
				if(!stack.hasTagCompound())
				{
					stack.setTagCompound(new NBTTagCompound());
				}
				player.openGui(NanotechMod.modInstance, 10, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			}
			else
			{
				if(!stack.hasTagCompound())
				{
					stack.setTagCompound(new NBTTagCompound());
				}
				if(!stack.getTagCompound().hasKey("IsOn"))
				{
					world.playSoundAtEntity(player, "nanotechmod:lightsaber", 1.0F, 1.0F);
					stack.getTagCompound().setBoolean("IsOn", true);
				}
				else
				{
					world.playSoundAtEntity(player, "nanotechmod:lightsaber", 1.0F, 1.0F);
					stack.getTagCompound().setBoolean("IsOn", !stack.getTagCompound().getBoolean("IsOn"));
				}
			}
		}
		return stack;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if(!player.worldObj.isRemote)
		{
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			else
			{
				if(!stack.getTagCompound().hasKey("IsOn"))
				{
					stack.getTagCompound().setBoolean("IsOn", false);
				}
				else
				{
					if(stack.getTagCompound().getBoolean("IsOn"))
					{
						player.worldObj.playSoundAtEntity(player, "nanotechmod:lightsaber", 1.0F, 1.0F);
					}
				}
			}

		}
		return false;
	}

	@Override
	public float func_150893_a(ItemStack stack, Block block)
	{
		if(block.equals(Blocks.web) && stack.getTagCompound().getBoolean("IsOn"))
		{
			return 15.0F;
		}
		else
		{
			Material material = block.getMaterial();
			return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean func_150897_b(Block block)
	{
		return block.equals(Blocks.web);
	}

	@Override
	public int getItemEnchantability()
	{
		return 0;
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		return false;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entityTarget, EntityLivingBase entitySource)
	{
		if(stack.getTagCompound().getBoolean("IsOn"))
		{
			entityTarget.attackEntityFrom(NanotechDamageSource.lightSaberDamage, 16F);
			this.setDamage(stack, this.getDamage(stack) + 1);
			return true;
		}
		else
		{
			entityTarget.attackEntityFrom(NanotechDamageSource.lightSaberDamage, 1F);
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		// Empty
	}
}