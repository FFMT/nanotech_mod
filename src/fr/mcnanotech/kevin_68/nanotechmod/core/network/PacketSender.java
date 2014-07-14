package fr.mcnanotech.kevin_68.nanotechmod.core.network;

import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightKey;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightString;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;

public class PacketSender
{
	public static void sendSpotLightPacket(TileEntitySpotLight tile, int index, int value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
		}
		catch(Exception e)
		{
			NanotechMod.log.error("Failed to send spotight packet");
			e.printStackTrace();
		}
	}
	
	public static void sendSpotLightPacket(TileEntitySpotLight tile, int index, String value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLightString(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
		}
		catch(Exception e)
		{
			NanotechMod.log.error("Failed to send spotight packet");
			e.printStackTrace();
		}
	}
	
	public static void sendSpotLightPacket(TileEntitySpotLight tile, int index, int value, int time)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLightKey(tile.xCoord, tile.yCoord, tile.zCoord, index, value, time));
		}
		catch(Exception e)
		{
			NanotechMod.log.error("Failed to send spotight packet");
			e.printStackTrace();
		}
	}
}
