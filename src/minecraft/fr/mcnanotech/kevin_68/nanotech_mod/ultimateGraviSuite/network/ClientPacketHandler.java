package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class ClientPacketHandler extends ServerPacketHandler
{
    public void onPacketData(INetworkManager var1, Packet250CustomPayload var2, Player var3)
    {
        DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var2.data));

        try
        {
            String var5 = var4.readUTF();

            if (var5.equalsIgnoreCase("setFlyStatus"))
            {
                ItemStack var6 = ClientProxy.mc.thePlayer.inventory.armorItemInSlot(2);

                if (var6 != null && var6.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
                {
                    UltimateGraviChestPlateClientProxy.firstLoadClient(ClientProxy.mc.thePlayer, var6);
                }
            }
            
            if (var5.equalsIgnoreCase("setInvisibilityStatus"))
            {
            	ItemStack var6 = ClientProxy.mc.thePlayer.inventory.armorItemInSlot(2);

                if (var6 != null && var6.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
                {
                    UltimateGraviChestPlateClientProxy.firstLoadClient(ClientProxy.mc.thePlayer, var6);
                }
            }
            
            if (var5.equalsIgnoreCase("setNightVisionStatus"))
            {
            	ItemStack var6 = ClientProxy.mc.thePlayer.inventory.armorItemInSlot(2);
            	
            	if (var6 != null && var6.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
            	{
            		UltimateGraviChestPlateClientProxy.firstLoadClient(ClientProxy.mc.thePlayer, var6);
            	}
            }
        }
        catch (IOException var7)
        {
            var7.printStackTrace();
        }
    }
}
