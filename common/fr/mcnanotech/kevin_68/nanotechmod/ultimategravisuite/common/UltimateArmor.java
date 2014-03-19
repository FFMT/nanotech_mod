package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.IC2Potion;
import ic2.core.Ic2Items;
import ic2.core.item.ItemTinCan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateArmor extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	private final Map<Integer, Integer> potionRemovalCost = new HashMap();
	private final Map<EntityPlayer, Integer> speedTickerMap = new HashMap();
	private final Map<EntityPlayer, Float> jumpChargeMap = new HashMap();

	public UltimateArmor(ArmorMaterial armorMaterial, int slot)
	{
		super(armorMaterial, 0, slot);
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		potionRemovalCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(10000));
		potionRemovalCost.put(Integer.valueOf(IC2Potion.radiation.id), Integer.valueOf(10000));
		potionRemovalCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(25000));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if(UGSUtils.isInvisibilityActive(player))
			{
				return "ultimategravisuite:textures/models/armor/ultimate_layer_3.png";
			}
		}
		if(slot == 2)
		{
			return "ultimategravisuite:textures/models/armor/ultimate_layer_2.png";
		}
		return "ultimategravisuite:textures/models/armor/ultimate_layer_1.png";
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		NBTTagCompound tag = UGSUtils.getTag(stack);
		byte timer = tag.getByte("timer");
		if(!world.isRemote && timer > 0)
		{
			timer = (byte)(timer - 1);
			tag.setByte("timer", timer);
		}
		switch(this.armorType)
		{
		case 0:
			int air = player.getAir();
			if((ElectricItem.manager.canUse(stack, 1000)) && (air < 100))
			{
				player.setAir(air + 200);

				ElectricItem.manager.use(stack, 1000, null);
			}

			if((ElectricItem.manager.canUse(stack, 1000)) && (player.getFoodStats().needFood()))
			{
				int slot = -1;
				for(int i = 0; i < player.inventory.mainInventory.length; i++)
				{
					if((player.inventory.mainInventory[i] != null) && (player.inventory.mainInventory[i].getItem() == Ic2Items.filledTinCan.getItem()))
					{
						slot = i;
						break;
					}
				}
				if(slot > -1)
				{
					ItemStack stack2 = player.inventory.mainInventory[slot];
					ItemTinCan can = (ItemTinCan)stack2.getItem();
					player.getFoodStats().addStats(can.func_150905_g(stack2), can.func_150906_h(stack2));
					can.func_77849_c(stack2, player.worldObj, player);
					can.onEaten(player);
					if(--stack2.stackSize <= 0)
					{
						player.inventory.mainInventory[slot] = null;
					}
					ElectricItem.manager.use(stack, 1000, null);
				}
			}

			Iterator effectIt = player.getActivePotionEffects().iterator();
			while(effectIt.hasNext())
			{
				PotionEffect effect = (PotionEffect)effectIt.next();
				int id = effect.getPotionID();

				Integer cost = potionRemovalCost.get(Integer.valueOf(id));
				if(cost != null)
				{
					cost = Integer.valueOf(cost.intValue() * (effect.getAmplifier() + 1));
					if(ElectricItem.manager.canUse(stack, cost))
					{
						ElectricItem.manager.use(stack, cost, null);
						IC2.platform.removePotion(player, id);
					}
				}
			}

			boolean nightVision = tag.getBoolean("nightVision");
			if(IC2.keyboard.isAltKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && timer == 0)
			{
				timer = (byte)10;
				nightVision = !nightVision;
				if(!world.isRemote)
				{
					tag.setBoolean("nightVision", nightVision);
					if(nightVision)
					{
						player.addChatComponentMessage(new ChatComponentTranslation("ultimate.night.on"));
					}
					else
					{
						player.addChatComponentMessage(new ChatComponentTranslation("ultimate.night.off"));
					}
				}
			}
			if(nightVision)
			{
				if(ElectricItem.manager.use(stack, 1, player))
				{
					int x = MathHelper.floor_double(player.posX);
					int z = MathHelper.floor_double(player.posZ);
					int y = MathHelper.floor_double(player.posY);

					int skylight = player.worldObj.getBlockLightValue(x, y, z);
					if(skylight < 8)
					{
						player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 0, true));
					}
					else
					{
						IC2.platform.removePotion(player, Potion.nightVision.id);
					}
				}
			}
			else
			{
				IC2.platform.removePotion(player, Potion.nightVision.id);
			}
			break;
		case 1:
			// TODO
			break;
		case 2:
			int speedTicker;
			if(ElectricItem.manager.canUse(stack, 1000) && (player.onGround && Math.abs(player.motionX) + Math.abs(player.motionZ) > 0.10000000149011612D || player.isInWater()) && player.isSprinting())
			{
				speedTicker = speedTickerMap.containsKey(player) ? speedTickerMap.get(player).intValue() : 0;
				++speedTicker;

				if(speedTicker >= 10)
				{
					speedTicker = 0;
					ElectricItem.manager.use(stack, 1000, (EntityPlayer)null);
				}

				speedTickerMap.put(player, speedTicker);
				float moveSpeed = 0.52F;

				if(player.isInWater())
				{
					moveSpeed = 0.15F;

					if(IC2.keyboard.isJumpKeyDown(player))
					{
						player.motionY += 0.10005D;
					}
				}

				if(moveSpeed > 0.0F)
				{
					player.moveFlying(0.0F, 1.0F, moveSpeed);
				}
			}
			break;
		case 3:
			float jumpCharge = jumpChargeMap.containsKey(player) ? jumpChargeMap.get(player).floatValue() : 1.0F;

			if(ElectricItem.manager.canUse(stack, 1000) && player.onGround && jumpCharge < 1.0F)
			{
				jumpCharge = 1.0F;
				ElectricItem.manager.use(stack, 1000, player);
			}

			if(player.motionY >= 0.0D && jumpCharge > 0.0F && !player.isInWater())
			{
				if(IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isBoostKeyDown(player))
				{
					if(jumpCharge == 1.0F)
					{
						player.motionX *= 5.0D;
						player.motionZ *= 5.0D;
					}

					player.motionY += (double)(jumpCharge * 0.45F);
					jumpCharge = (float)((double)jumpCharge * 0.90D);
				}
				else if(jumpCharge < 1.0F)
				{
					jumpCharge = 0.0F;
				}
			}

			jumpChargeMap.put(player, jumpCharge);
			break;
		}
	}

	@Override
	public boolean canProvideEnergy(ItemStack stack)
	{
		return true;
	}

	@Override
	public Item getChargedItem(ItemStack stack)
	{
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack stack)
	{
		return this;
	}

	@Override
	public int getMaxCharge(ItemStack stack)
	{
		return 1000000000;
	}

	@Override
	public int getTier(ItemStack stack)
	{
		return 4;
	}

	@Override
	public int getTransferLimit(ItemStack stack)
	{
		return 120000;
	}

	@Override
	public boolean isMetalArmor(ItemStack stack, EntityPlayer player)
	{
		return true;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource source, double damage, int slot)
	{
		double absorptionRatio = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int energyPerDamage = this.getEnergyPerDamage();
		long l = 25 * ElectricItem.manager.discharge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true);
		long damageLimit = Math.abs(l / energyPerDamage);
		return new ArmorProperties(0, absorptionRatio, (int)damageLimit);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		if(ElectricItem.manager.getCharge(armor) >= getEnergyPerDamage())
		{
			return (int)Math.round(20.0D * getBaseAbsorptionRatio() * getDamageAbsorptionRatio());
		}
		return 0;
	}

	public double getDamageAbsorptionRatio()
	{
		if(this.armorType == 1)
		{
			return 2.0D;
		}
		return 1.1D;
	}

	private double getBaseAbsorptionRatio()
	{
		switch(this.armorType)
		{
		case 0:
			return 0.4D;
		case 1:
			return 1.1D;
		case 2:
			return 0.4D;
		case 3:
			return 0.4D;
		}
		return 0.0D;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		ElectricItem.manager.discharge(stack, damage * getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}

	public int getEnergyPerDamage()
	{
		return 10000;
	}

	public int getItemEnchantability()
	{
		return 0;
	}

	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
	{
		return false;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list)
	{
		ItemStack charged = new ItemStack(this, 1);
		ElectricItem.manager.charge(charged, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		list.add(charged);
		list.add(new ItemStack(this, 1, getMaxDamage()));
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}
}