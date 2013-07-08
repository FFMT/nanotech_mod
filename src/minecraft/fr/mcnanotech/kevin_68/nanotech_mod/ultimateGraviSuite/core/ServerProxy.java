package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

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
    public void initCore() {}

    public static void sendPlayerMessage(EntityPlayer var0, String var1)
    {
        var0.addChatMessage(var1);
    }

    public static boolean sendPacket(EntityPlayer var0, String var1, int var2)
    {
        ByteArrayOutputStream var3 = new ByteArrayOutputStream();
        DataOutputStream var4 = new DataOutputStream(var3);

        try
        {
            var4.writeUTF(var1);
            var4.writeInt(var2);
        }
        catch (IOException var6)
        {
            var6.printStackTrace();
        }

        Packet250CustomPayload var5 = new Packet250CustomPayload();
        var5.channel = "gravisuite";
        var5.data = var3.toByteArray();
        var5.length = var5.data.length;
        PacketDispatcher.sendPacketToPlayer(var5, (Player)var0);
        return true;
    }

    public static boolean isSimulating()
    {
        return !FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public void playSoundSp(String var1, float var2, float var3) {}

    public void registerSoundHandler() {}

    public void registerRenderers() {}

    public EntityPlayer getPlayerInstance()
    {
        return null;
    }

    public int addArmor(String var1)
    {
        return 0;
    }
}
