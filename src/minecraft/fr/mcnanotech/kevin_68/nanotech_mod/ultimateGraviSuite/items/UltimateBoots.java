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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class UltimateBoots extends ItemArmor implements IElectricItem, IMetalArmor, ISpecialArmor
{
    public static Map jumpChargeMap = new HashMap();
    public static int minCharge;
    public static float boostSpeed;
    public static int boostMultiplier;


	public UltimateBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
        minCharge = 80000;
        this.setCreativeTab(UltimateGraviSuite.ic2Tab);
        this.setMaxDamage(27);
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateBoots");
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
	
    @ForgeSubscribe
    public void onEntityLivingFallEvent(LivingFallEvent var1)
    {
        if (IC2.platform.isSimulating() && var1.entity instanceof EntityPlayer)
        {
            EntityPlayer var2 = (EntityPlayer)var1.entity;
            ItemStack var3 = var2.inventory.armorInventory[0];

            if (var3 != null && var3.itemID == this.itemID)
            {
                int var4 = (int)var1.distance - 3;
                int var5 = this.getEnergyPerDamage() * var4;

                if (var5 <= ElectricItem.manager.discharge(var3, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true))
                {
                    ElectricItem.manager.discharge(var3, var5, Integer.MAX_VALUE, true, false);
                    var1.setCanceled(true);
                }
            }
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

                float var7 = jumpChargeMap.containsKey(var2) ? ((Float)jumpChargeMap.get(var2)).floatValue() : 1.0F;

                if (ElectricItem.manager.canUse(var3, 1000) && var2.onGround && var7 < 1.0F)
                {
                    var7 = 1.0F;
                    ElectricItem.manager.use(var3, 1000, (EntityPlayer)null);
                    var4 = true;
                }

                if (var2.motionY >= 0.0D && var7 > 0.0F && !var2.isInWater())
                {
                    if (IC2.keyboard.isJumpKeyDown(var2) && IC2.keyboard.isBoostKeyDown(var2))
                    {
                        if (var7 == 1.0F)
                        {
                            var2.motionX *= 5.0D;
                            var2.motionZ *= 5.0D;
                        }

                        var2.motionY += (double)(var7 * 0.45F);
                        var7 = (float)((double)var7 * 0.90D);
                    }
                    else if (var7 < 1.0F)
                    {
                        var7 = 0.0F;
                    }
                }

                jumpChargeMap.put(var2, Float.valueOf(var7));
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
        return var1.getBoolean("isInvisibleBoo");
    }

    public static boolean saveInvisibilityStatus(ItemStack var0, boolean var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setBoolean("isInvisibleBoo", var1);
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
