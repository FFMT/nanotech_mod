package fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.core.UltimateGraviSuite;

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