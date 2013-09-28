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
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientTickHandler;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
	public static Minecraft mc = FMLClientHandler.instance().getClient();

	public void initCore()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(this);
		registerKeys();
	}

	public static void registerKeys()
	{}

	public static boolean sendMyPacket(String var0, int var1)
	{
		ByteArrayOutputStream var2 = new ByteArrayOutputStream();
		DataOutputStream var3 = new DataOutputStream(var2);

		try
		{
			var3.writeUTF(var0);
			var3.writeInt(var1);
		}
		catch(IOException var5)
		{
			var5.printStackTrace();
		}

		Packet250CustomPayload var4 = new Packet250CustomPayload();
		var4.channel = "gravisuite";
		var4.data = var2.toByteArray();
		var4.length = var4.data.length;
		mc.thePlayer.sendQueue.addToSendQueue(var4);
		return true;
	}

	public EntityPlayer getPlayerInstance()
	{
		return Minecraft.getMinecraft().thePlayer;
	}

	public void registerSoundHandler()
	{}

	public int addArmor(String var1)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(var1);
	}

	public static void sendPlayerMessage(EntityPlayer var0, String var1)
	{
		if(!mc.theWorld.isRemote)
		{
			var0.addChatMessage(var1);
		}
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load var1)
	{
		UltimateGraviChestPlateClientProxy.firstLoad = true;
	}
}
