package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.ElectricItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.ultimategraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerTickHandler;


public class UltimateGraviChestPlateServerProxy
{
    private MinecraftServer mc = FMLCommonHandler.instance().getMinecraftServerInstance();

    public static boolean switchFlyModeServer(EntityPlayer var0, ItemStack var1)
    {
        if (ultimategraviChestPlate.readFlyStatus(var1))
        {
            if (!var0.capabilities.isCreativeMode)
            {
                var0.capabilities.allowFlying = false;
                var0.capabilities.isFlying = false;
            }

            ServerProxy.sendPlayerMessage(var0, "\u00a7cGravitation engine OFF");
            ServerTickHandler.isFlyActiveByMod.put(var0, Boolean.valueOf(false));
            ultimategraviChestPlate.saveFlyStatus(var1, false);
        }
        else
        {
            int var2 = ultimategraviChestPlate.getCharge(var1);

            if (var2 < ultimategraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
            {
                ServerProxy.sendPlayerMessage(var0, "Not enough energy to run Gravitation engine !");
            }
            else
            {
                ServerProxy.sendPlayerMessage(var0, "\u00a7aGravitation engine ON");
                var0.capabilities.allowFlying = true;
                var0.capabilities.isFlying = true;
                ServerTickHandler.isFlyActiveByMod.put(var0, Boolean.valueOf(true));
                ultimategraviChestPlate.saveFlyStatus(var1, true);
            }
        }

        return true;
    }
    
    public static boolean switchInvisibleModeServer(EntityPlayer var0, ItemStack var1)
    {
    	if (var1.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
    	{
        if (ultimategraviChestPlate.readInvisibilityStatus(var1))
        {

            ServerProxy.sendPlayerMessage(var0, "\u00a7cInvisibility OFF");
            ServerTickHandler.isInvisibilityActiveByMod.put(var0, Boolean.valueOf(false));
            ultimategraviChestPlate.saveInvisibilityStatus(var1, false);
        }
        else
        {
            int var2 = ultimategraviChestPlate.getCharge(var1);

            if (var2 < ultimategraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
            {
                ServerProxy.sendPlayerMessage(var0, "Not enough energy to be Invisible !");
            }
            else
            {
                ServerProxy.sendPlayerMessage(var0, "\u00a7aInvisibility ON");
                ServerTickHandler.isInvisibilityActiveByMod.put(var0, Boolean.valueOf(true));
                ultimategraviChestPlate.saveInvisibilityStatus(var1, true);
            }
        }
    	}
    	
    	if (var1.getItem() == UltimateGraviSuite.ultimateLeggings)
    	{
    		 if (UltimateLeggings.readInvisibilityStatus(var1))
             {
    			 UltimateLeggings.saveInvisibilityStatus(var1, false);

             }
             else
             {
            	 UltimateLeggings.saveInvisibilityStatus(var1, true);
                 
             }	
    	}
    	if (var1.getItem() == UltimateGraviSuite.ultimateBoots)
    	{
    		 if (UltimateBoots.readInvisibilityStatus(var1))
             {
    			 UltimateBoots.saveInvisibilityStatus(var1, false);

             }
             else
             {
            	 UltimateBoots.saveInvisibilityStatus(var1, true);
                 
             }	
    	}
    	
    	if (var1.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
    	{
    		 if (UltimateQuantumHelmet.readInvisibilityStatus(var1))
             {
    			 UltimateQuantumHelmet.saveInvisibilityStatus(var1, false);

             }
             else
             {
            	 UltimateQuantumHelmet.saveInvisibilityStatus(var1, true);
                 
             }	
    	}

        return true;
    }
    
    public static boolean switchNightVisionModeServer(EntityPlayer var0, ItemStack var1)
    {
        if (UltimateQuantumHelmet.readNightVisionStatus(var1))
        {

            ServerProxy.sendPlayerMessage(var0, "\u00a7cNight vision OFF");
            ServerTickHandler.isINightVisionActiveByMod.put(var0, Boolean.valueOf(false));
            UltimateQuantumHelmet.saveNightVisionStatus(var1, false);
        }
        else
        {
            int var2 = UltimateQuantumHelmet.getCharge(var1);

            if (var2 < UltimateQuantumHelmet.minCharge && !var0.capabilities.isCreativeMode)
            {
                ServerProxy.sendPlayerMessage(var0, "Not enough energy to be Invisible !");
            }
            else
            {
                ServerProxy.sendPlayerMessage(var0, "\u00a7aNight vision ON");
                ServerTickHandler.isINightVisionActiveByMod.put(var0, Boolean.valueOf(true));
                UltimateQuantumHelmet.saveNightVisionStatus(var1, true);
            }
        }

        return true;
    }

    public static boolean boostModeServer(EntityPlayer var0, ItemStack var1, float var2, float var3)
    {
        if (ultimategraviChestPlate.readFlyStatus(var1) && !var0.onGround && var0.capabilities.isFlying && !var0.isInWater())
        {
            int var4 = ultimategraviChestPlate.getCharge(var1);

            if (var4 > ultimategraviChestPlate.dischargeOnTick * ultimategraviChestPlate.boostMultiplier || var0.capabilities.isCreativeMode)
            {
                var0.moveFlying(var2, var3, ultimategraviChestPlate.boostSpeed);

                if (!var0.capabilities.isCreativeMode)
                {
                    ElectricItem.discharge(var1, ultimategraviChestPlate.dischargeOnTick * ultimategraviChestPlate.boostMultiplier, 3, true, false);
                }
            }
        }

        return true;
    }

    public static boolean firstLoadServer(EntityPlayer var0, ItemStack var1)
    {
        if (ultimategraviChestPlate.readFlyStatus(var1))
        {
            ultimategraviChestPlate.saveFlyStatus(var1, false);
            switchFlyModeServer(var0, var1);
            ServerProxy.sendPacket(var0, "setFlyStatus", 0);
        }
        if (ultimategraviChestPlate.readInvisibilityStatus(var1))
        {
            ultimategraviChestPlate.saveInvisibilityStatus(var1, false);
        	UltimateLeggings.saveInvisibilityStatus(var1, false);
        	UltimateBoots.saveInvisibilityStatus(var1, false);
        	UltimateQuantumHelmet.saveInvisibilityStatus(var1, false);
        	switchInvisibleModeServer(var0, var1);
            ServerProxy.sendPacket(var0, "setInvisibilityStatus", 0);
        } 
        if (UltimateQuantumHelmet.readNightVisionStatus(var1))
        {
        	UltimateQuantumHelmet.saveNightVisionStatus(var1, false);
            switchNightVisionModeServer(var0, var1);
            ServerProxy.sendPacket(var0, "setNightVisionStatus", 0);
        }

        return true;
    }

    public static boolean onTickServer(EntityPlayer var0, ItemStack var1, float var2, float var3)
    {
        if (ServerTickHandler.checkLastUndressed(var0))
        {
            ultimategraviChestPlate.saveFlyStatus(var1, false);
            ServerTickHandler.lastUndressed.put(var0, Boolean.valueOf(false));
        }

        if (ultimategraviChestPlate.readFlyStatus(var1) || ultimategraviChestPlate.readInvisibilityStatus(var1))
        {
            NBTTagCompound var4 = UltimateGraviSuite.getOrCreateNbtData(var1);
            int var5 = ultimategraviChestPlate.getCharge(var1);

            if (!var0.capabilities.isCreativeMode)
            {
                if (var5 < ultimategraviChestPlate.dischargeOnTick)
                {
                    ServerProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
                    switchFlyModeServer(var0, var1);
                    switchInvisibleModeServer(var0, var1);
                }
                else
                {
                    ElectricItem.discharge(var1, ultimategraviChestPlate.dischargeOnTick, 3, true, false);
                }
            }

            var0.fallDistance = 0.0F;

            if (!var0.onGround && var0.capabilities.isFlying && Keyboard.isBoostKeyDown(var0))
            {
                boostModeServer(var0, var1, var2, var3);

                if (var5 <= ultimategraviChestPlate.dischargeOnTick * ultimategraviChestPlate.boostMultiplier && !var0.capabilities.isCreativeMode)
                {
                    ServerProxy.sendPlayerMessage(var0, "Not enough energy to boost !");
                }
                else
                {
                    if (Keyboard.isJumpKeyDown(var0))
                    {
                        var0.motionY += (double)(ultimategraviChestPlate.boostSpeed + 0.03F);
                    }

                    if (Keyboard.isSneakKeyDown(var0))
                    {
                        var0.motionY -= (double)(ultimategraviChestPlate.boostSpeed + 0.03F);
                    }

                    if (!var0.capabilities.isCreativeMode)
                    {
                        ElectricItem.discharge(var1, ultimategraviChestPlate.dischargeOnTick * ultimategraviChestPlate.boostMultiplier, 3, true, false);
                    }
                }
            }
        }
        
        if (UltimateQuantumHelmet.readNightVisionStatus(var1))
        {
            int var4 = UltimateQuantumHelmet.getCharge(var1);

            if (!var0.capabilities.isCreativeMode)
            {
                if (var4 < UltimateQuantumHelmet.dischargeOnTick)
                {
                	ServerProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
                    switchNightVisionModeServer(var0, var1);
                }
                else
                {
                    ElectricItem.discharge(var1, UltimateQuantumHelmet.dischargeOnTick, 3, true, false);
                }
            }
        }

        var0.extinguish();
        return true;
    }
}
