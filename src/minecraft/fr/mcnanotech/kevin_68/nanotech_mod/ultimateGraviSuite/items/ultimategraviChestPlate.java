package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

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
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class ultimategraviChestPlate extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
	
    public static int minCharge;
    public static int maxCharge = 10000000;
    public static int dischargeOnTick;
    public static float boostSpeed;
    public static int boostMultiplier;
    
    public ultimategraviChestPlate(int var1, EnumArmorMaterial var2, int var3, int var4)
    {
        super(var1, var2, var3, var4);
        minCharge = 80000;
        dischargeOnTick = 416;
        boostSpeed = 0.15F;
        boostMultiplier = 6;
        this.setCreativeTab(UltimateGraviSuite.ic2Tab);
        this.setMaxDamage(27);
    }
    
    public void registerIcons(IconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateGraviChestPlate");
    }
    
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if (!readInvisibilityStatus(stack))
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
        int var10 = var9 > 0 ? 25 * ElectricItem.manager.discharge(var2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true) / var9 : 0;
        return new ISpecialArmor.ArmorProperties(0, var7, var10);
    }
    
    public static int getCharge(ItemStack var0)
    {
        NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
        int var2 = var1.getInteger("charge");
        return var2;
    }
    
    @Override
    public void onArmorTickUpdate(World var1, EntityPlayer var2, ItemStack var3)
    {
    	if (!var3.isItemEnchanted())
    	{
    		var3.addEnchantment(Enchantment.thorns, 10);
    	}
    	
    	if (readInvisibilityStatus(var3))
		{
    		var2.addPotionEffect(new PotionEffect(14, 20, 100));
		}  	
    	
    	this.getArmorTexture(var3, var2, 1, 1);
    	IC2.platform.profilerEndSection();
    }

    public static void setCharge(ItemStack var0, int var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setInteger("charge", var1);
        System.out.println(var1);
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

    public int getArmorDisplay(EntityPlayer var1, ItemStack var2, int var3)
    {
        return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
    }

    public void damageArmor(EntityLiving var1, ItemStack var2, DamageSource var3, int var4, int var5)
    {
        ElectricItem.manager.discharge(var2, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
    }

    public static boolean readFlyStatus(ItemStack var0)
    {
        NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
        return var1.getBoolean("isFlyActive");
    }

    public static boolean saveFlyStatus(ItemStack var0, boolean var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setBoolean("isFlyActive", var1);
        return true;
    }
    
    public static boolean readInvisibilityStatus(ItemStack var0)
    {
        NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
        return var1.getBoolean("isInvisible");
    }

    public static boolean saveInvisibilityStatus(ItemStack var0, boolean var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setBoolean("isInvisible", var1);
        return true;
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int var1, CreativeTabs var2, List var3)
    {
        ItemStack var4 = new ItemStack(this, 1);
        ElectricItem.manager.charge(var4, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        var3.add(var4);
        var3.add(new ItemStack(this, 1, this.getMaxDamage()));
    }

    public boolean isRepairable()
    {
        return false;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
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
