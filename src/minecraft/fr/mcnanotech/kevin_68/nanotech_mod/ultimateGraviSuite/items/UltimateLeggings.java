package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

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


	public UltimateLeggings(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
        maxCharge = 10000000;
        transferLimit = 200000;
        tier = 2;
        minCharge = 80000;
        this.setCreativeTab(UltimateGraviSuite.ic2Tab);
        this.setMaxDamage(27);
	}
	
    public void registerIcons(IconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateLeggings");
    }
    
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if (!readInvisibilityStatus(stack))
		{
			return "/mods/UltimateGraviSuite/textures/armor/ultimategraviChestPlate2.png";
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

    public boolean isMetalArmor(ItemStack var1, EntityPlayer var2)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack var1)
    {
        return EnumRarity.epic;
    }

    @Override
    public void onArmorTickUpdate(World var1, EntityPlayer var2, ItemStack var3)
    {
    	this.getArmorTexture(var3, var2, 1, 1);
        boolean var4 = false;
        int var11;
                boolean var6 = true;

                if (IC2.platform.isRendering())
                {
                    var6 = IC2.enableQuantumSpeedOnSprint;
                }
                else if (enableQuantumSpeedOnSprintMap.containsKey(var2))
                {
                    var6 = ((Boolean)enableQuantumSpeedOnSprintMap.get(var2)).booleanValue();
                }

                if (ElectricItem.manager.canUse(var3, 1000) && (var2.onGround && Math.abs(var2.motionX) + Math.abs(var2.motionZ) > 0.10000000149011612D || var2.isInWater()) && (var6 && var2.isSprinting() || !var6 && IC2.keyboard.isBoostKeyDown(var2)))
                {
                    var11 = speedTickerMap.containsKey(var2) ? ((Integer)speedTickerMap.get(var2)).intValue() : 0;
                    ++var11;

                    if (var11 >= 10)
                    {
                        var11 = 0;
                        ElectricItem.manager.use(var3, 1000, (EntityPlayer)null);
                        var4 = true;
                    }

                    speedTickerMap.put(var2, Integer.valueOf(var11));
                    float var8 = 0.52F;

                    if (var2.isInWater())
                    {
                        var8 = 0.1F;

                        if (var2.isJumping)
                        {
                            var2.motionY += 0.10000055149011612D;
                        }
                    }

                    if (var8 > 0.0F)
                    {
                        var2.moveFlying(0.0F, 1.0F, var8);
                    }
                }

                IC2.platform.profilerEndSection();
        
    }


	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
        return (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio());
	}


	public void damageArmor(EntityLiving var1, ItemStack var2, DamageSource var3, int var4, int var5)
	{
        ElectricItem.manager.discharge(var2, var4 * this.getEnergyPerDamage(), Integer.MAX_VALUE, true, false);
	}
	
    public static boolean readInvisibilityStatus(ItemStack var0)
    {
        NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
        return var1.getBoolean("isInvisibleLeg");
    }

    public static boolean saveInvisibilityStatus(ItemStack var0, boolean var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setBoolean("isInvisibleLeg", var1);
        return true;
    }

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
