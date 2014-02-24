/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemEmeraldBow extends ItemBow
{
	private IIcon[] iconbuffer;
	private static String[] bowpullname = new String[] {"_pull1", "_pull2", "_pull3"};

	public ItemEmeraldBow()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(5000);
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		iconbuffer = new IIcon[bowpullname.length];
		itemIcon = iconregister.registerIcon(this.getIconString());
		for(int i = 0; i < bowpullname.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon(this.getIconString() + bowpullname[i]);
		}
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(usingItem != null && usingItem.getItem().equals(NanotechItem.emeraldBow))
		{
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if(k >= 18)
				return iconbuffer[2];
			if(k > 13)
				return iconbuffer[1];
			if(k > 0)
				return iconbuffer[0];
		}
		return getIconIndex(stack);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount)
	{
		int var6 = this.getMaxItemUseDuration(stack) - itemInUseCount - 3000;

		ArrowLooseEvent event = new ArrowLooseEvent(player, stack, var6);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return;
		}
		var6 = event.charge;

		boolean creativeorinfinity = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

		if(creativeorinfinity || player.inventory.hasItem(Items.arrow))
		{
			float var7 = (float)var6 / 20.0F;
			var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

			if((double)var7 < 0.1D)
			{
				return;
			}

			if(var7 > 1.0F)
			{
				var7 = 1.0F;
			}

			EntityArrow var8 = new EntityArrow(world, player, var7 * 6.0F);

			if(var7 == 1.0F)
			{
				var8.setIsCritical(true);
			}

			int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

			if(var9 > 0)
			{
				var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
			}

			int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

			if(var10 > 0)
			{
				var8.setKnockbackStrength(var10);
			}

			if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
			{
				var8.setFire(100);
			}

			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

			if(creativeorinfinity)
			{
				var8.canBePickedUp = 2;
			}
			else
			{
				player.inventory.consumeInventoryItem(Items.arrow);
			}

			if(!world.isRemote)
			{
				world.spawnEntityInWorld(var8);
			}
		}
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 200000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, stack);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return event.result;
		}

		if(player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}

		return stack;
	}

	@Override
	public int getItemEnchantability()
	{
		return 1;
	}
}