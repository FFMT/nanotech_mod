package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateLeggings extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	public static Map enableQuantumSpeedOnSprintMap = new HashMap();
	public static Map speedTickerMap = new HashMap();
	public static int maxCharge;
	public static int minCharge;
	public static int transferLimit;
	public static int tier;
	public static float boostSpeed;
	public static int boostMultiplier;

	public UltimateLeggings(int id, EnumArmorMaterial armorMaterial, int slot, int layer)
	{
		super(id, armorMaterial, slot, layer);
		maxCharge = 10000000;
		transferLimit = 200000;
		tier = 2;
		minCharge = 80000;
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("ultimategravisuite:ultimateLeggings");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(!readInvisibilityStatus(stack))
		{
			return "ultimategravisuite:textures/armor/ultimategraviChestPlate2.png";
		}
		else
		{
			return "ultimategravisuite:textures/armor/ultimategraviChestPlateInvisible.png";
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
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		this.getArmorTexture(stack, player, 1, 1);
		boolean var4 = false;
		int var11;
		boolean var6 = true;

		if(IC2.platform.isRendering())
		{
			var6 = IC2.enableQuantumSpeedOnSprint;
		}
		else if(enableQuantumSpeedOnSprintMap.containsKey(player))
		{
			var6 = ((Boolean)enableQuantumSpeedOnSprintMap.get(player)).booleanValue();
		}

		if(ElectricItem.manager.canUse(stack, 1000) && (player.onGround && Math.abs(player.motionX) + Math.abs(player.motionZ) > 0.10000000149011612D || player.isInWater()) && (var6 && player.isSprinting() || !var6 && IC2.keyboard.isBoostKeyDown(player)))
		{
			var11 = speedTickerMap.containsKey(player) ? ((Integer)speedTickerMap.get(player)).intValue() : 0;
			++var11;

			if(var11 >= 10)
			{
				var11 = 0;
				ElectricItem.manager.use(stack, 1000, (EntityPlayer)null);
				var4 = true;
			}

			speedTickerMap.put(player, Integer.valueOf(var11));
			float var8 = 0.52F;

			if(player.isInWater())
			{
				var8 = 0.1F;

				if (IC2.keyboard.isJumpKeyDown(player))
				{
					player.motionY += 0.10000055149011612D;
				}
			}

			if(var8 > 0.0F)
			{
				player.moveFlying(0.0F, 1.0F, var8);
			}
		}

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
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isInvisibleLeg");
	}

	public static boolean saveInvisibilityStatus(ItemStack stack, boolean invisible)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setBoolean("isInvisibleLeg", invisible);
		return true;
	}

	public void getSubItems(int id, CreativeTabs creativetab, List list)
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

	@Override
	public boolean canProvideEnergy(ItemStack stack)
	{
		return true;
	}

	@Override
	public int getChargedItemId(ItemStack stack)
	{
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack stack)
	{
		return this.itemID;
	}

	@Override
	public int getMaxCharge(ItemStack stack)
	{
		return 10000000;
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