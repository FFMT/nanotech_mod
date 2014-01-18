package fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.core;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class ServerProxy
{
	public void initCore()
	{}

	public static void sendPlayerMessage(EntityPlayer player, String message)
	{
		player.addChatMessage(message);
	}

	public static boolean sendPacket(EntityPlayer player, String name, int id)
	{
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(byteArray);

		try
		{
			data.writeUTF(name);
			data.writeInt(id);
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}

		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "gravisuite";
		pkt.data = byteArray.toByteArray();
		pkt.length = pkt.data.length;
		PacketDispatcher.sendPacketToPlayer(pkt, (Player)player);
		return true;
	}

	public static boolean isSimulating()
	{
		return !FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	public void playSoundSp(String var1, float var2, float var3)
	{}

	public void registerSoundHandler()
	{}

	public void registerRenderers()
	{}

	public EntityPlayer getPlayerInstance()
	{
		return null;
	}
}