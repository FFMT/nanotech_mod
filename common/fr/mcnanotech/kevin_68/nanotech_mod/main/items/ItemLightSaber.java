package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechDamageSource;

public class ItemLightSaber extends Item
{
	public ItemLightSaber(int id)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(1500);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(player.isSneaking())
			{
				player.openGui(Nanotech_mod.modInstance, 5, world, (int)player.posX, (int)player.posY, (int)player.posZ);
				//this.setDamage(stack, this.getDamage(stack) == 4 ? 0 : this.getDamage(stack) + 1);
			}
			else
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
							world.playSoundAtEntity(player, "nanotech_mod:lightsaber", 1.0F, 1.0F);
							stack.getTagCompound().setBoolean("IsOn", false);
						}
						else
						{
							world.playSoundAtEntity(player, "nanotech_mod:lightsaber", 1.0F, 1.0F);
							stack.getTagCompound().setBoolean("IsOn", true);
						}
					}
					
					if(!stack.getTagCompound().hasKey("Red"))
					{
						stack.getTagCompound().setInteger("Red", 0);
					}
					
					if(!stack.getTagCompound().hasKey("Green"))
					{
						stack.getTagCompound().setInteger("Green", 0);
					}
					
					if(!stack.getTagCompound().hasKey("Blue"))
					{
						stack.getTagCompound().setInteger("Blue", 0);
					}
				}
			}
		}
		return stack;
	}

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
						player.worldObj.playSoundAtEntity(player, "nanotech_mod:lightsaber", 1.0F, 1.0F);
					}
				}
			}

		}
		return false;
	}

	public float getStrVsBlock(ItemStack stack, Block block)
	{
		if(block.blockID == Block.web.blockID && stack.getTagCompound().getBoolean("IsOn"))
		{
			return 15.0F;
		}
		else
		{
			Material material = block.blockMaterial;
			return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	public boolean canHarvestBlock(Block block)
	{
		return block.blockID == Block.web.blockID;
	}

	public int getItemEnchantability()
	{
		return 0;
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		return false;
	}

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
}
