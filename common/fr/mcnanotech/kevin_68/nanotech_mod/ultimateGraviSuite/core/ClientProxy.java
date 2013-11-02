package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientPacketHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientTickHandler;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
	public static Minecraft mc = FMLClientHandler.instance().getClient();

	public void initCore()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static boolean sendMyPacket(String name, int id)
	{
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(byteArray);

		try
		{
			dataOut.writeUTF(name);
			dataOut.writeInt(id);
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}

		Packet250CustomPayload customPacket = new Packet250CustomPayload();
		customPacket.channel = "gravisuite";
		customPacket.data = byteArray.toByteArray();
		customPacket.length = customPacket.data.length;
		mc.thePlayer.sendQueue.addToSendQueue(customPacket);
		return true;
	}

	public EntityPlayer getPlayerInstance()
	{
		return Minecraft.getMinecraft().thePlayer;
	}

	public void registerSoundHandler()
	{}

	public static void sendPlayerMessage(EntityPlayer player, String message)
	{
		if(!mc.theWorld.isRemote)
		{
			player.addChatMessage(message);
		}
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load event)
	{
		ClientPacketHelper.firstLoad = true;
	}
}