package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateServerProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class ServerPacketHandler implements IPacketHandler
{
    public void onPacketData(INetworkManager var1, Packet250CustomPayload var2, Player var3)
    {
        DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var2.data));
        EntityPlayerMP var5 = (EntityPlayerMP)var3;

        try
        {
            String var6 = var4.readUTF();
            int var7;

            if (var6.equalsIgnoreCase("keyFLY"))
            {
                var7 = var4.readInt();
                ItemStack var8 = var5.inventory.armorInventory[2];

                if (var8 != null && var8.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
                {
                    UltimateGraviChestPlateServerProxy.switchFlyModeServer(var5, var8);
                }
            }
            
            if (var6.equalsIgnoreCase("keyInv"))
            {
            	var7 = var4.readInt();
            	ItemStack var8 = var5.inventory.armorInventory[2];
            	ItemStack var9 = var5.inventory.armorInventory[1];
            	ItemStack var10 = var5.inventory.armorInventory[0];
            	ItemStack var11 = var5.inventory.armorInventory[3];

            	
            	if (var8 != null && var8.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
            	{
            		UltimateGraviChestPlateServerProxy.switchInvisibleModeServer(var5, var8);
            	}
            	
            	if (var9 != null && var9.getItem() == UltimateGraviSuite.ultimateLeggings)
            	{
            		UltimateGraviChestPlateServerProxy.switchInvisibleModeServer(var5, var9);
            	}
            	
            	if (var10 != null && var10.getItem() == UltimateGraviSuite.ultimateBoots)
            	{
            		UltimateGraviChestPlateServerProxy.switchInvisibleModeServer(var5, var10);
            	}
            	
            	if (var11 != null && var11.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
            	{
            		UltimateGraviChestPlateServerProxy.switchInvisibleModeServer(var5, var11);
            	}
            }
            
            if (var6.equalsIgnoreCase("keyNight"))
            {
            	var7 = var4.readInt();
            	ItemStack var8 = var5.inventory.armorInventory[3];
            	
            	if (var8 != null && var8.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
            	{
            		UltimateGraviChestPlateServerProxy.switchNightVisionModeServer(var5, var8);
            	}
            }

            ItemStack var10;

            if (var6.equalsIgnoreCase("worldLoad"))
            {
                var10 = var5.inventory.armorInventory[2];

                if (var10 != null && var10.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
                {
                    UltimateGraviChestPlateServerProxy.firstLoadServer(var5, var10);
                }
            }

            if (var6.equalsIgnoreCase("keyState"))
            {
                var7 = var4.readInt();
                UltimateGraviSuite.keyboard.processKeyUpdate(var5, var7);
            }

            if (var6.equalsIgnoreCase("keyModePressed"))
            {
                var10 = var5.inventory.armorInventory[2];
            }
        }
        catch (IOException var9)
        {
            var9.printStackTrace();
        }
    }
}
