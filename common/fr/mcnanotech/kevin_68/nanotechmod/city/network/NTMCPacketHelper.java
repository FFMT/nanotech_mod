package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;

public class NTMCPacketHelper
{
	public static void sendPacket(TileEntitySpotLight tile, int value, int index)
	{
		try
		{
			NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
		}
		catch(Exception exception)
		{
			System.out.println("[NTMC]Failed to send a packet from SpotLight");
		}
	}
}
