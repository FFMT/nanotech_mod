package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemDiamondBow extends ItemBow
{
	private Icon[] iconbuffer;
	private static String[] bowpullname = new String[] {"diamondbow_pull1", "diamondbow_pull2", "diamondbow_pull3"};

	public ItemDiamondBow(int id)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(1000);
	}

	public void registerIcons(IconRegister iconregister)
	{
		iconbuffer = new Icon[bowpullname.length];
		for(int i = 0; i < bowpullname.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon("nanotechmod:" + bowpullname[i]);
		}
		itemIcon = iconregister.registerIcon("nanotechmod:diamondbow");
	}

	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(usingItem != null && usingItem.getItem().itemID == NanotechItem.diamondBow.itemID)
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

	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount)
	{
		int charge = this.getMaxItemUseDuration(stack) - itemInUseCount;

		ArrowLooseEvent event = new ArrowLooseEvent(player, stack, charge);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return;
		}
		charge = event.charge;

		boolean creativeOrInfinity = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

		if(creativeOrInfinity || player.inventory.hasItem(Item.arrow.itemID))
		{
			float power = 1000000000000000000F;

			if((double)power < 0.1D)
			{
				return;
			}

			if(power > 1.0F)
			{
				power = 1.0F;
			}

			EntityArrow arrow = new EntityArrow(world, player, power * 4.0F);

			if(power == 1.0F)
			{
				arrow.setIsCritical(true);
			}

			int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

			if(var9 > 0)
			{
				arrow.setDamage(arrow.getDamage() + (double)var9 * 0.5D + 0.5D);
			}

			int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

			if(var10 > 0)
			{
				arrow.setKnockbackStrength(var10);
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
				player.inventory.consumeInventoryItem(Item.arrow.itemID);
			}

			if(!world.isRemote)
			{
				world.spawnEntityInWorld(arrow);
			}
		}
	}

	public ItemStack onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 1000;
	}

	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.bow;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, stack);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return event.result;
		}

		if(player.capabilities.isCreativeMode || player.inventory.hasItem(Item.arrow.itemID))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		return stack;
	}

	public int getItemEnchantability()
	{
		return 1;
	}
}