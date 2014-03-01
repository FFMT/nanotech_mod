/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.network;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client.ClientProxy;

public class ClientPacketHandler extends ServerPacketHandler
{
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

		try
		{
			String packetType = data.readUTF();
			ItemStack chestPlate = ClientProxy.mc.thePlayer.inventory.armorItemInSlot(2);

			if(packetType.equalsIgnoreCase("setFlyStatus"))
			{

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					ClientPacketHelper.firstLoadClient(ClientProxy.mc.thePlayer, chestPlate);
				}
			}

			if(packetType.equalsIgnoreCase("setInvisibilityStatus"))
			{
				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					ClientPacketHelper.firstLoadClient(ClientProxy.mc.thePlayer, chestPlate);
				}
			}

			if(packetType.equalsIgnoreCase("setNightVisionStatus"))
			{
				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateHelmet))
				{
					ClientPacketHelper.firstLoadClient(ClientProxy.mc.thePlayer, chestPlate);
				}
			}
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}
}