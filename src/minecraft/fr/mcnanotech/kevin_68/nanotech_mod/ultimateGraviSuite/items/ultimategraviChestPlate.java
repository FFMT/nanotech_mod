package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateGraviChestPlate extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	public static int minCharge;
	public static int maxCharge = 10000000;
	public static int dischargeOnTick;
	public static float boostSpeed;
	public static int boostMultiplier;

	public UltimateGraviChestPlate(int id, EnumArmorMaterial armorMaterial, int slot, int layer)
	{
		super(id, armorMaterial, slot, layer);
		minCharge = 80000;
		dischargeOnTick = 416;
		boostSpeed = 0.15F;
		boostMultiplier = 6;
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateGraviChestPlate");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(!readInvisibilityStatus(stack))
		{
			return "/mods/UltimateGraviSuite/textures/armor/ultimategraviChestPlate.png";
		} else
		{
			return "/mods/UltimateGraviSuite/textures/armor/ultimategraviChestPlateInvisible.png";
		}
	}

	public ArmorProperties getProperties(EntityLiving entity, ItemStack stack, DamageSource var3, double var4, int var6)
	{

		double var7 = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int var9 = this.getEnergyPerDamage();
		int var10 = var9 > 0 ? 25 * ElectricItem.manager.discharge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true) / var9 : 0;
		return new ArmorProperties(0, var7, var10);
	}

	public static int getCharge(ItemStack stack)
	{
		NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(stack);
		int var2 = var1.getInteger("charge");
		return var2;
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		if(!stack.isItemEnchanted())
		{
			stack.addEnchantment(Enchantment.thorns, 10);
		}

		if(readInvisibilityStatus(stack))
		{
			player.addPotionEffect(new PotionEffect(14, 20, 100));
		}

		this.getArmorTexture(stack, player, 1, 1);
		IC2.platform.profilerEndSection();
	}

	public static void setCharge(ItemStack stack, int charge)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setInteger("charge", charge);
	}

	public int getEnergyPerDamage()
	{
		return 900;
	}

	public double getDamageAbsorptionRatio()
	{
		return 2.0D;
	}

	private double getBaseAbsorptionRatio()
	{
		return 1.1D;
	}

	public boolean isMetalArmor(ItemStack var1, EntityPlayer var2)
	{
		return true;
	}

	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int var3)
	{
		return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
	}

	public void damageArmor(EntityLiving player, ItemStack stack, DamageSource var3, int var4, int var5)
	{
		ElectricItem.manager.discharge(stack, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}

	public static boolean readFlyStatus(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isFlyActive");
	}

	public static boolean saveFlyStatus(ItemStack stack, boolean fly)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setBoolean("isFlyActive", fly);
		return true;
	}

	public static boolean readInvisibilityStatus(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isInvisible");
	}

	public static boolean saveInvisibilityStatus(ItemStack stack, boolean invisible)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setBoolean("isInvisible", invisible);
		return true;
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	public void getSubItems(int id, CreativeTabs crativetab, List list)
	{
		ItemStack var4 = new ItemStack(this, 1);
		ElectricItem.manager.charge(var4, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		list.add(var4);
		list.add(new ItemStack(this, 1, this.getMaxDamage()));
	}

	public boolean isRepairable()
	{
		return false;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	public int getItemEnchantability()
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack var1)
	{
		return EnumRarity.epic;
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack)
	{
		return true;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack)
	{
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack)
	{
		return this.itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack)
	{
		return this.maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack)
	{
		return 2;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack)
	{
		return 20000;
	}
}
