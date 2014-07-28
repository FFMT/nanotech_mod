/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.packet.PacketSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.packet.PacketSpotLightKey;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.packet.PacketTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.network.packet.PacketTextSpotLightString;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;

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
            NanotechModCity.nanoCityLogger.error("[NTMC]Failed to send a packet from SpotLight");
        }
    }

    public static void sendPacket(TileEntitySpotLight tile, int value, int index, int time)
    {
        try
        {
            NanotechModCity.packetHandler.sendToServer(new PacketSpotLightKey(tile.xCoord, tile.yCoord, tile.zCoord, index, value, time));
        }
        catch(Exception exception)
        {
            NanotechModCity.nanoCityLogger.error("[NTMC]Failed to send a packet from SpotLight");
        }
    }

    public static void sendPacket(TileEntityTextSpotLight tile, int value, int index)
    {
        try
        {
            NanotechModCity.packetHandler.sendToServer(new PacketTextSpotLight(tile.xCoord, tile.yCoord, tile.zCoord, index, value));
        }
        catch(Exception exception)
        {
            NanotechModCity.nanoCityLogger.error("[NTMC]Failed to send a packet from SpotLight");
        }
    }

    public static void sendPacket(TileEntityTextSpotLight tile, String str)
    {
        try
        {
            NanotechModCity.packetHandler.sendToServer(new PacketTextSpotLightString(tile.xCoord, tile.yCoord, tile.zCoord, str));
        }
        catch(Exception exception)
        {
            NanotechModCity.nanoCityLogger.error("[NTMC]Failed to send a packet from SpotLight");
        }
    }
}
