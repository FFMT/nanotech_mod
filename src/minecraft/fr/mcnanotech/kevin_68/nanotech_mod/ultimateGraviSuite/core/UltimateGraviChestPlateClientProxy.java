package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.ElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.ultimategraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientTickHandler;

public class UltimateGraviChestPlateClientProxy
{
    public static boolean firstLoad = false;
    private Minecraft mc = FMLClientHandler.instance().getClient();
    private static int ticker = 0;

    public static boolean switchFlyModeClient(EntityPlayer var0, ItemStack var1)
    {
        if (ultimategraviChestPlate.readFlyStatus(var1))
        {
            if (!var0.capabilities.isCreativeMode)
            {
                var0.capabilities.allowFlying = false;
                var0.capabilities.isFlying = false;
            }

            ClientProxy.sendPlayerMessage(var0, "\u00a7cGravitation engine OFF");
            ClientTickHandler.isFlyActiveByMod = false;
            ultimategraviChestPlate.saveFlyStatus(var1, false);
        }
        else
        {
            int var2 = ultimategraviChestPlate.getCharge(var1);

            if (var2 < ultimategraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
            {
                ClientProxy.sendPlayerMessage(var0, "Not enough energy to run Gravitation engine !");
            }
            else
            {
                ClientProxy.sendPlayerMessage(var0, "\u00a7aGravitation engine ON");
                var0.capabilities.allowFlying = true;
                var0.capabilities.isFlying = true;
                ClientTickHandler.isFlyActiveByMod = true;
                ultimategraviChestPlate.saveFlyStatus(var1, true);
            }
        }

        return true;
    }
    
    public static boolean switchInvisibleModeClient(EntityPlayer var0, ItemStack var1)
    {
    	if (var1.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
    	{
    	 if (ultimategraviChestPlate.readInvisibilityStatus(var1))
         {
             ClientProxy.sendPlayerMessage(var0, "\u00a7cInvisibility OFF");
             ClientTickHandler.isInvisibilityActiveByMod = false;
             ultimategraviChestPlate.saveInvisibilityStatus(var1, false);

         }
         else
         {
             int var2 = ultimategraviChestPlate.getCharge(var1);

             if (var2 < ultimategraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
             {
                 ClientProxy.sendPlayerMessage(var0, "Not enough energy to be invisible !");
             }
             else
             {
                 ClientProxy.sendPlayerMessage(var0, "\u00a7aInvisibility ON");
                 ClientTickHandler.isInvisibilityActiveByMod = true;
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
    
    public static boolean switchNightVisionModeClient(EntityPlayer var0, ItemStack var1)
    {
    	if (UltimateQuantumHelmet.readNightVisionStatus(var1))
    	{
            ClientProxy.sendPlayerMessage(var0, "\u00a7cNight vision OFF");
    		ClientTickHandler.isINightVisionActiveByMod = false;
    		UltimateQuantumHelmet.saveNightVisionStatus(var1, false);

    	}
    	else
    	{
    		int var2 = UltimateQuantumHelmet.getCharge(var1);
         
    		if (var2 < UltimateQuantumHelmet.minCharge && !var0.capabilities.isCreativeMode)
    		{
    			ClientProxy.sendPlayerMessage(var0, "Not enough energy to be invisible !");
    		}
    		else
    		{
                ClientProxy.sendPlayerMessage(var0, "\u00a7aNight vision ON");
    			ClientTickHandler.isINightVisionActiveByMod = true;
    			UltimateQuantumHelmet.saveNightVisionStatus(var1, true);
    		}
    	}
    	return true;
    }

    public static boolean boostMode(EntityPlayer var0, ItemStack var1, float var2, float var3)
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

    public static boolean firstLoadClient(EntityPlayer var0, ItemStack var1)
    {
        if (ultimategraviChestPlate.readFlyStatus(var1))
        {
        	ultimategraviChestPlate.saveFlyStatus(var1, false);
            switchFlyModeClient(var0, var1);
        }
        if (ultimategraviChestPlate.readInvisibilityStatus(var1))
        {
        	ultimategraviChestPlate.saveInvisibilityStatus(var1, false);
        	UltimateLeggings.saveInvisibilityStatus(var1, false);
        	UltimateBoots.saveInvisibilityStatus(var1, false);
        	UltimateQuantumHelmet.saveInvisibilityStatus(var1, false);
            switchInvisibleModeClient(var0, var1);
        }
        if (UltimateQuantumHelmet.readNightVisionStatus(var1))
        {
        	UltimateQuantumHelmet.saveNightVisionStatus(var1, false);
            switchNightVisionModeClient(var0, var1);
        }

        return true;
    }

    public static boolean onTickClient(EntityPlayer var0, ItemStack var1, float var2, float var3)
    {
        if (firstLoad)
        {
            ClientProxy.sendMyPacket("worldLoad", 1);
            firstLoad = false;
            return true;
        }
        else
        {
            if (ClientTickHandler.isLastUndressed)
            {
            	ultimategraviChestPlate.saveFlyStatus(var1, false);
                ClientTickHandler.isLastUndressed = false;
            }

            if (ultimategraviChestPlate.readFlyStatus(var1) || ultimategraviChestPlate.readInvisibilityStatus(var1))
            {
                int var4 = ultimategraviChestPlate.getCharge(var1);

                if (!var0.capabilities.isCreativeMode)
                {
                    if (var4 < ultimategraviChestPlate.dischargeOnTick)
                    {
                        ClientProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
                        switchFlyModeClient(var0, var1);
                        switchInvisibleModeClient(var0, var1);
                    }
                    else
                    {
                        ElectricItem.discharge(var1, ultimategraviChestPlate.dischargeOnTick, 3, true, false);
                    }
                }

                var0.fallDistance = 0.0F;

                if (!var0.onGround && var0.capabilities.isFlying && KeyboardClient.isBoostKeyDown(var0))
                {
                    KeyboardClient.updatePlayerMove();

                    if (var4 <= ultimategraviChestPlate.dischargeOnTick * ultimategraviChestPlate.boostMultiplier && !var0.capabilities.isCreativeMode)
                    {
                        ClientProxy.sendPlayerMessage(var0, "Not enough energy to boost !");
                    }
                    else
                    {
                        boostMode(var0, var1, var2, var3);

                        if (KeyboardClient.isJumpKeyDown(var0))
                        {
                            var0.motionY += (double)(ultimategraviChestPlate.boostSpeed + 0.03F);
                        }

                        if (KeyboardClient.isSneakKeyDown(var0))
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
                        ClientProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
                        switchNightVisionModeClient(var0, var1);
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
}
