/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateBoots extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	public static Map jumpChargeMap = new HashMap();
	public static int minCharge;
	public static float boostSpeed;
	public static int boostMultiplier;

	public UltimateBoots(ArmorMaterial armorMaterial, int slot, int layer)
	{
		super(armorMaterial, slot, layer);
		minCharge = 80000;
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("ultimategravisuite:ultimateBoots");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(!readInvisibilityStatus(stack))
		{
			return "ultimategravisuite:textures/armor/ultimategraviChestPlate.png";
		}
		else
		{
			return "ultimategravisuite:textures/armor/ultimategraviChestPlateInvisible.png";
		}
	}

	@SubscribeEvent
	public void onEntityLivingFallEvent(LivingFallEvent fallevent)
	{
		if(IC2.platform.isSimulating() && fallevent.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)fallevent.entity;
			ItemStack stack = player.inventory.armorInventory[0];

			if(stack != null && stack.getItem() == this)
			{
				int var4 = (int)fallevent.distance - 3;
				int var5 = this.getEnergyPerDamage() * var4;

				if(var5 <= ElectricItem.manager.discharge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true))
				{
					ElectricItem.manager.discharge(stack, var5, Integer.MAX_VALUE, true, false);
					fallevent.setCanceled(true);
				}
			}
		}
	}

	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource damagesource, double var4, int var6)
	{
		double var7 = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int var9 = this.getEnergyPerDamage();
		int var10 = var9 > 0 ? 25 * ElectricItem.manager.discharge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true) / var9 : 0;
		return new ArmorProperties(0, var7, var10);
	}

	public double getDamageAbsorptionRatio()
	{
		return 1.1D;
	}

	public int getEnergyPerDamage()
	{
		return 900;
	}

	private double getBaseAbsorptionRatio()
	{
		return 0.4D;
	}

	public boolean isMetalArmor(ItemStack stack, EntityPlayer player)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		this.getArmorTexture(stack, player, 1, null);
		boolean var4 = false;
		int var11;
		boolean var6 = true;

		float jumpCharge = jumpChargeMap.containsKey(player) ? ((Float)jumpChargeMap.get(player)).floatValue() : 1.0F;

		if(ElectricItem.manager.canUse(stack, 1000) && player.onGround && jumpCharge < 1.0F)
		{
			jumpCharge = 1.0F;
			ElectricItem.manager.use(stack, 1000, (EntityPlayer)null);
			var4 = true;
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

		jumpChargeMap.put(player, Float.valueOf(jumpCharge));
		IC2.platform.profilerEndSection();

	}

	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int slot)
	{
		return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
	}

	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource var3, int var4, int var5)
	{
		ElectricItem.manager.discharge(stack, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}

	public static boolean readInvisibilityStatus(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuiteMod.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isInvisibleBoo");
	}

	public static boolean saveInvisibilityStatus(ItemStack stack, boolean invisible)
	{
		NBTTagCompound nbttag = UltimateGraviSuiteMod.getOrCreateNbtData(stack);
		nbttag.setBoolean("isInvisibleBoo", invisible);
		return true;
	}

	public void getSubItems(int id, CreativeTabs creativetab, List list)
	{
		ItemStack stack = new ItemStack(this, 1);
		ElectricItem.manager.charge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		list.add(stack);
		list.add(new ItemStack(this, 1, this.getMaxDamage()));
	}

	public boolean isRepairable()
	{
		return false;
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
		return 60000000;
	}

	@Override
	public int getTier(ItemStack stack)
	{
		return 2;
	}

	@Override
	public int getTransferLimit(ItemStack stack)
	{
		return 20000;
	}
}