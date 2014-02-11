package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;

public class NTMCPacketHelper
{
	public static void sendPacket(TileEntitySpotLight tile, int value, int index)
	{
		try
		{
			if(index == 0)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, value, tile.getGreenValue(), tile.getBlueValue(), tile.getDarkRedValue(), tile.getDarkGreenValue(), tile.getDarkBlueValue()));
			}
			else if(index == 1)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, tile.getRedValue(), value, tile.getBlueValue(), tile.getDarkRedValue(), tile.getDarkGreenValue(), tile.getDarkBlueValue()));
			}
			else if(index == 2)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, tile.getRedValue(), tile.getGreenValue(), value, tile.getDarkRedValue(), tile.getDarkGreenValue(), tile.getDarkBlueValue()));
			}
			else if(index == 3)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, tile.getRedValue(), tile.getGreenValue(), tile.getBlueValue(), value, tile.getDarkGreenValue(), tile.getDarkBlueValue()));
			}
			else if(index == 4)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, tile.getRedValue(), tile.getGreenValue(), tile.getBlueValue(), tile.getDarkRedValue(), value, tile.getDarkBlueValue()));
			}
			else if(index == 5)
			{
				NanotechModCity.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, tile.getRedValue(), tile.getGreenValue(), tile.getBlueValue(), tile.getDarkRedValue(), tile.getDarkGreenValue(), value));
			}
		}
		catch(Exception exception)
		{
			System.out.println("[NTMC]Failed to send a packet from SpotLight");
		}
	}
}
