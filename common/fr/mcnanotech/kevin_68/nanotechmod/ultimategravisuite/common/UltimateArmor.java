package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateArmor extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	public UltimateArmor(ArmorMaterial armorMaterial, int slot)
	{
		super(armorMaterial, 0, slot);
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
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

	private int getEnergyPerDamage()
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