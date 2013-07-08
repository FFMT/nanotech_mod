package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

class KeyboardHandler extends KeyBindingRegistry.KeyHandler
{
    final KeyboardClient key;

    KeyboardHandler(KeyboardClient var1, KeyBinding[] var2, boolean[] var3)
    {
        super(var2, var3);
        this.key = var1;
    }

    public String getLabel()
    {
        return "UltimateGraviSuiteKeyboard";
    }

    public void keyDown(EnumSet var1, KeyBinding var2, boolean var3, boolean var4)
    {
        if (var3 && var2 == KeyboardClient.flyKey && KeyboardClient.mc.inGameHasFocus)
        {
            ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(2);

            if (var5 != null && var5.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
            {
                ClientProxy.sendMyPacket("keyFLY", 1);
                UltimateGraviChestPlateClientProxy.switchFlyModeClient(KeyboardClient.mc.thePlayer, var5);
            }
        }
        
        if (var3 && var2 == KeyboardClient.invKey && KeyboardClient.mc.inGameHasFocus)
        {
            ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(2);
            ItemStack var6 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(1);
            ItemStack var7 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(0);
            ItemStack var8 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(3);


            if (var5 != null && var5.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
            {
            	ClientProxy.sendMyPacket("keyInv", 1);
            	UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var5);
            	
                if (var6 != null && var6.getItem() == UltimateGraviSuite.ultimateLeggings)
                {
                	ClientProxy.sendMyPacket("keyInvLeg", 1);
                	UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var6);
                }
                
                if (var7 != null && var7.getItem() == UltimateGraviSuite.ultimateBoots)
                {
                	ClientProxy.sendMyPacket("keyInvBoo", 1);
                	UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var7);
                }
                
                if (var8 != null && var8.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
                {
                	ClientProxy.sendMyPacket("keyInvHel", 1);
                	UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var8);
                }
            }
        }
        
        if (var3 && var2 == KeyboardClient.nightKey && KeyboardClient.mc.inGameHasFocus)
        {
            ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(3);

            if (var5 != null && var5.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
            {
            	ClientProxy.sendMyPacket("keyNight", 1);
            	UltimateGraviChestPlateClientProxy.switchNightVisionModeClient(KeyboardClient.mc.thePlayer, var5);
            }
        }
    }

    public EnumSet ticks()
    {
        return EnumSet.of(TickType.CLIENT);
    }

    public void keyUp(EnumSet var1, KeyBinding var2, boolean var3) {}
}
