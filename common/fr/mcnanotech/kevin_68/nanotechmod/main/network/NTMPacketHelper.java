/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.network;

import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.packet.PacketJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.packet.PacketListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.packet.PacketListerJukeboxString;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.packet.PacketSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.packet.PacketSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;

public class NTMPacketHelper
{
	public static void sendPacket(TileEntityJumper tile, int value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketJumper(tile.xCoord, tile.yCoord, tile.zCoord, value));
		}
		catch(Exception exception)
		{
			NanotechMod.nanoLogger.error("Failed to send a packet from a jumper");
		}
	}

	public static void sendPacket(TileEntitySmoker tile, int value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSmoker(tile.xCoord, tile.yCoord, tile.zCoord, value));
		}
		catch(Exception exception)
		{
			NanotechMod.nanoLogger.error("Failed to send a packet from a smoker");
		}
	}

	public static void sendPacket(int id, int value)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketSaber(id, value));
		}
		catch(Exception exception)
		{
			NanotechMod.nanoLogger.error("Failed to send a packet from a saber");
		}
	}

	public static void sendPacket(TileEntitySoundBox tile, int index, int indexList)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketListerJukebox(tile.xCoord, tile.yCoord, tile.zCoord, index, indexList));
		}
		catch(Exception exception)
		{
			NanotechMod.nanoLogger.error("Failed to send a packet from a listerjukebox");
		}
	}
	
	public static void sendPacket(TileEntitySoundBox tile, int index, String txt)
	{
		try
		{
			NanotechMod.packetHandler.sendToServer(new PacketListerJukeboxString(tile.xCoord, tile.yCoord, tile.zCoord, index, txt));
		}
		catch(Exception exception)
		{
			NanotechMod.nanoLogger.error("Failed to send a packet from a listerjukebox");
		}
	}
}