package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.item.ItemTinCan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
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

	public UltimateQuantumHelmet(int id, EnumArmorMaterial armorMaterial, int slot, int layer)
	{
		super(id, armorMaterial, slot, layer);
		genDay = UltimateGraviSuite.uhGenDay;
		genNight = UltimateGraviSuite.uhGenNight;
		minCharge = 10000;
		dischargeOnTick = 128;
		this.setCreativeTab(IC2.tabIC2);
		this.setMaxDamage(27);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("ultimategravisuite:ultimateHelmet");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
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

	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource var3, double var4, int var6)
	{
		double var7 = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
		int var9 = this.getEnergyPerDamage();
		int var10 = var9 <= 0 ? 0 : ElectricItem.manager.discharge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true) / var9;
		return new ISpecialArmor.ArmorProperties(0, var7, var10);
	}

	public static int getCharge(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		int charge = nbttag.getInteger("charge");
		return charge;
	}

	public static void setCharge(ItemStack stack, int charge)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setInteger("charge", charge);
	}

	public static boolean onTick(EntityPlayer player, ItemStack stack)
	{
		gainFuel(player);

		if(generating > 0)
		{
			int var3 = generating;
			int var2;
			int var4;

			for(var4 = 0; var4 < player.inventory.armorInventory.length; ++var4)
			{
				if(var3 <= 0)
				{
					return true;
				}

				if(player.inventory.armorInventory[var4] != null && Item.itemsList[player.inventory.armorInventory[var4].itemID] instanceof IElectricItem)
				{
					var2 = ElectricItem.manager.charge(player.inventory.armorInventory[var4], var3, 3, false, false);
					var3 -= var2;
				}
			}

			for(var4 = 0; var4 < player.inventory.mainInventory.length; ++var4)
			{
				if(var3 <= 0)
				{
					return true;
				}

				if(player.inventory.mainInventory[var4] != null && Item.itemsList[player.inventory.mainInventory[var4].itemID] instanceof IElectricItem)
				{
					var2 = ElectricItem.manager.charge(player.inventory.mainInventory[var4], var3, 3, false, false);
					var3 -= var2;
				}
			}
		}

		return true;
	}

	public static boolean readNightVisionStatus(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isInvisible");
	}

	public static boolean saveNightVisionStatus(ItemStack stack, boolean nightvisionstatus)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setBoolean("isInvisible", nightvisionstatus);
		return true;
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		this.getArmorTexture(stack, player, 1, 1);
		boolean var4 = false;
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
			int SlotWithTinCanId = -1;

			for(int slotId = 0; slotId < player.inventory.mainInventory.length; slotId++)
			{
				if(player.inventory.mainInventory[slotId] != null && player.inventory.mainInventory[slotId].itemID == Ic2Items.filledTinCan.itemID)
				{
					SlotWithTinCanId = slotId;
					break;
				}
			}

			if(SlotWithTinCanId > -1)
			{
				ItemFood can = (ItemFood)player.inventory.mainInventory[SlotWithTinCanId].getItem();
				player.getFoodStats().addStats(can.getHealAmount(), can.getSaturationModifier());
				ItemTinCan can1 = (ItemTinCan)can;
				can1.func_77849_c(player.inventory.mainInventory[SlotWithTinCanId], player.worldObj, player);
				can1.onEaten(player);

				if(--player.inventory.mainInventory[SlotWithTinCanId].stackSize <= 0)
				{
					player.inventory.mainInventory[SlotWithTinCanId] = null;
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

	public static int gainFuel(EntityPlayer player)
	{
		if(ticker++ % tickRate() == 0)
		{
			updateVisibility(player);
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

	public static void updateVisibility(EntityPlayer player)
	{
		wetBiome = player.worldObj.getWorldChunkManager().getBiomeGenAt((int)player.posX, (int)player.posZ).getIntRainfall() > 0;
		noSunWorld = player.worldObj.provider.hasNoSky;
		Boolean var1 = Boolean.valueOf(wetBiome && (player.worldObj.isRaining() || player.worldObj.isThundering()));

		if(player.worldObj.isDaytime() && !var1.booleanValue())
		{
			sunIsUp = true;
		}
		else
		{
			sunIsUp = false;
		}

		if(player.worldObj.canBlockSeeTheSky((int)player.posX, (int)player.posY + 1, (int)player.posZ) && !noSunWorld)
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

	public static boolean readInvisibilityStatus(ItemStack stack)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		return nbttag.getBoolean("isInvisibleHel");
	}

	public static boolean saveInvisibilityStatus(ItemStack stack, boolean isInvisible)
	{
		NBTTagCompound nbttag = UltimateGraviSuite.getOrCreateNbtData(stack);
		nbttag.setBoolean("isInvisibleHel", isInvisible);
		return true;
	}

	public static int tickRate()
	{
		return 128;
	}

	public boolean isMetalArmor(ItemStack stack, EntityPlayer player)
	{
		return true;
	}

	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int var3)
	{
		return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
	}

	public void damageArmor(EntityLivingBase living, ItemStack stack, DamageSource var3, int var4, int var5)
	{
		ElectricItem.manager.discharge(stack, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}

	public void getSubItems(int id, CreativeTabs creativetab, List list)
	{
		ItemStack stack = new ItemStack(this, 1);
		ElectricItem.manager.charge(stack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		list.add(stack);
		list.add(new ItemStack(this, 1, this.getMaxDamage()));
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}

	static
	{
		Potion IC2radiation = null;
		try
		{
			IC2radiation = (Potion)Class.forName("ic2.core.IC2Potion").getField("radiation").get(null);
		}
		catch(Exception ex)
		{}
		potionRemovalCost[Potion.poison.id] = 10000;
		potionRemovalCost[IC2radiation.id] = 10000;
		potionRemovalCost[Potion.wither.id] = 25000;
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