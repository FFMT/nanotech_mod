package fr.mcnanotech.kevin_68.nanotechmod.core.network;

import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightBoolean;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightByte;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightKey;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.packets.PacketSpotLightString;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;

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

	public static void sendSpotLightPacketByte(TileEntitySpotLight tile, byte index, byte value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLightByte(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
		}
		catch(Exception e)
		{
			NanotechMod.log.error("Failed to send spotight packet");
			e.printStackTrace();
		}
	}
	
	public static void sendSpotLightPacketBoolean(TileEntitySpotLight tile, byte index, boolean value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLightBoolean(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
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

	public static void sendSpotLightPacket(TileEntitySpotLight tile, int index, SpotLightEntry entry)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSpotLightKey(tile.xCoord, tile.yCoord, tile.zCoord, index, entry));
		}
		catch(Exception e)
		{
			NanotechMod.log.error("Failed to send spotight packet");
			e.printStackTrace();
		}
	}
}
