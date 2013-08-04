package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.IC2Potion;
import ic2.core.Ic2Items;
import ic2.core.item.ItemTinCan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateQuantumHelmet extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	private static final int[] potionRemovalCost = new int[Potion.potionTypes.length];
	public static int ticker;
	public static int generating;
	public static int genDay;
	public static int genNight;
	public static int dischargeOnTick;
	public static boolean initialized;
	public static boolean sunIsUp;
	public static boolean skyIsVisible;
	private static boolean noSunWorld;
	private static boolean wetBiome;
	public static int minCharge;

	public UltimateQuantumHelmet(int var1, EnumArmorMaterial var2, int var3, int var4)
	{
		super(var1, var2, var3, var4);
		genDay = UltimateGraviSuite.uhGenDay;
		genNight = UltimateGraviSuite.uhGenNight;
		minCharge = 10000;
		dischargeOnTick = 128;
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateHelmet");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(!readInvisibilityStatus(stack))
		{
			return "/mods/UltimateGraviSuite/textures/armor/ultimategraviChestPlate.png";
		}
		else
		{
			return "/mods/UltimateGraviSuite/textures/armor/ultimategraviChestPlateInvisible.png";
		}
	}

	public ISpecialArmor.ArmorProperties getProperties(EntityLiving var1, ItemStack var2, DamageSource var3, double var4, int var6)
	{
		double var7 = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int var9 = this.getEnergyPerDamage();
		int var10 = var9 <= 0 ? 0 : ElectricItem.manager.discharge(var2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true) / var9;
		return new ISpecialArmor.ArmorProperties(0, var7, var10);
	}

	public static int getCharge(ItemStack var0)
	{
		NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
		int var2 = var1.getInteger("charge");
		return var2;
	}

	public static void setCharge(ItemStack var0, int var1)
	{
		NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
		var2.setInteger("charge", var1);
	}

	public static boolean onTick(EntityPlayer var0, ItemStack var1)
	{
		gainFuel(var0);

		if(generating > 0)
		{
			int var3 = generating;
			int var2;
			int var4;

			for(var4 = 0; var4 < var0.inventory.armorInventory.length; ++var4)
			{
				if(var3 <= 0)
				{
					return true;
				}

				if(var0.inventory.armorInventory[var4] != null && Item.itemsList[var0.inventory.armorInventory[var4].itemID] instanceof IElectricItem)
				{
					var2 = ElectricItem.manager.charge(var0.inventory.armorInventory[var4], var3, 3, false, false);
					var3 -= var2;
				}
			}

			for(var4 = 0; var4 < var0.inventory.mainInventory.length; ++var4)
			{
				if(var3 <= 0)
				{
					return true;
				}

				if(var0.inventory.mainInventory[var4] != null && Item.itemsList[var0.inventory.mainInventory[var4].itemID] instanceof IElectricItem)
				{
					var2 = ElectricItem.manager.charge(var0.inventory.mainInventory[var4], var3, 3, false, false);
					var3 -= var2;
				}
			}
		}

		return true;
	}

	public static boolean readNightVisionStatus(ItemStack var0)
	{
		NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
		return var1.getBoolean("isInvisible");
	}

	public static boolean saveNightVisionStatus(ItemStack var0, boolean var1)
	{
		NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
		var2.setBoolean("isInvisible", var1);
		return true;
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		this.getArmorTexture(stack, player, 1, 1);
		boolean var4 = false;
		int var11;
		int var5 = player.getAir();

		if(readNightVisionStatus(stack))
		{
			if(!player.worldObj.isDaytime() || !skyIsVisible)
			{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500, 2, true));
				ElectricItem.manager.discharge(stack, 200, Integer.MAX_VALUE, true, false);
			}

			var4 = true;
		}

		if(ElectricItem.manager.canUse(stack, 1000) && var5 < 100)
		{
			player.setAir(var5 + 200);
			ElectricItem.manager.use(stack, 1000, (EntityPlayer)null);
			var4 = true;
		}

		if(ElectricItem.manager.canUse(stack, 1000) && player.getFoodStats().needFood())
		{
			int var9 = -1;

			for(var11 = 0; var11 < player.inventory.mainInventory.length; ++var11)
			{
				if(player.inventory.mainInventory[var11] != null && player.inventory.mainInventory[var11].itemID == Ic2Items.filledTinCan.itemID)
				{
					var9 = var11;
					break;
				}
			}

			if(var9 > -1)
			{
				ItemTinCan var13 = (ItemTinCan)player.inventory.mainInventory[var9].getItem();
				player.getFoodStats().addStats(var13.getHealAmount(), var13.getSaturationModifier());
				var13.func_77849_c(player.inventory.mainInventory[var9], player.worldObj, player);
				var13.onEaten(player);

				if(--player.inventory.mainInventory[var9].stackSize <= 0)
				{
					player.inventory.mainInventory[var9] = null;
				}

				ElectricItem.manager.use(stack, 1000, (EntityPlayer)null);
				var4 = true;
			}
		}
		Iterator var10 = (new LinkedList(player.getActivePotionEffects())).iterator();

		while(var10.hasNext())
		{
			PotionEffect var14 = (PotionEffect)var10.next();
			int var12 = potionRemovalCost[var14.getPotionID()];

			if(var12 > 0)
			{
				var12 *= var14.getAmplifier() + 1;

				if(ElectricItem.manager.canUse(stack, var12))
				{
					ElectricItem.manager.use(stack, var12, (EntityPlayer)null);
					IC2.platform.removePotion(player, var14.getPotionID());
				}
			}
		}
		IC2.platform.profilerEndSection();
	}

	public static int gainFuel(EntityPlayer var0)
	{
		if(ticker++ % tickRate() == 0)
		{
			updateVisibility(var0);
		}

		if(sunIsUp && skyIsVisible)
		{
			generating = 0 + genDay;
			return generating;
		}
		else if(skyIsVisible)
		{
			generating = 0 + genNight;
			return generating;
		}
		else
		{
			generating = 0;
			return generating;
		}
	}

	public static void updateVisibility(EntityPlayer var0)
	{
		wetBiome = var0.worldObj.getWorldChunkManager().getBiomeGenAt((int)var0.posX, (int)var0.posZ).getIntRainfall() > 0;
		noSunWorld = var0.worldObj.provider.hasNoSky;
		Boolean var1 = Boolean.valueOf(wetBiome && (var0.worldObj.isRaining() || var0.worldObj.isThundering()));

		if(var0.worldObj.isDaytime() && !var1.booleanValue())
		{
			sunIsUp = true;
		}
		else
		{
			sunIsUp = false;
		}

		if(var0.worldObj.canBlockSeeTheSky((int)var0.posX, (int)var0.posY + 1, (int)var0.posZ) && !noSunWorld)
		{
			skyIsVisible = true;
		}
		else
		{
			skyIsVisible = false;
		}
	}

	public int getEnergyPerDamage()
	{
		return 900;
	}

	public double getDamageAbsorptionRatio()
	{
		return 1.1D;
	}

	private double getBaseAbsorptionRatio()
	{
		return 0.4D;
	}

	public static boolean readInvisibilityStatus(ItemStack var0)
	{
		NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
		return var1.getBoolean("isInvisibleHel");
	}

	public static boolean saveInvisibilityStatus(ItemStack var0, boolean var1)
	{
		NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
		var2.setBoolean("isInvisibleHel", var1);
		return true;
	}

	public static int tickRate()
	{
		return 128;
	}

	public boolean isMetalArmor(ItemStack var1, EntityPlayer var2)
	{
		return true;
	}

	public int getArmorDisplay(EntityPlayer var1, ItemStack var2, int var3)
	{
		return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
	}

	public void damageArmor(EntityLiving var1, ItemStack var2, DamageSource var3, int var4, int var5)
	{
		ElectricItem.manager.discharge(var2, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}

	public void getSubItems(int var1, CreativeTabs var2, List var3)
	{
		ItemStack var4 = new ItemStack(this, 1);
		ElectricItem.manager.charge(var4, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		var3.add(var4);
		var3.add(new ItemStack(this, 1, this.getMaxDamage()));
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack var1)
	{
		return EnumRarity.epic;
	}

	static
	{
		potionRemovalCost[Potion.poison.id] = 10000;
		potionRemovalCost[IC2Potion.radiation.id] = 10000;
		potionRemovalCost[Potion.wither.id] = 25000;
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
		return 10000000;
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