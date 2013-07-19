    package fr.mcnanotech.kevin_68.nanotech_mod.main.network;
     
    import java.io.ByteArrayInputStream;
    import java.io.DataInputStream;
    import java.io.IOException;
     
    import net.minecraft.client.Minecraft;
    import net.minecraft.client.entity.EntityOtherPlayerMP;
    import net.minecraft.client.multiplayer.NetClientHandler;
    import net.minecraft.client.multiplayer.WorldClient;
    import net.minecraft.entity.player.EntityPlayer;
    import net.minecraft.item.ItemStack;
    import net.minecraft.network.INetworkManager;
    import net.minecraft.network.packet.Packet;
    import net.minecraft.network.packet.Packet250CustomPayload;
    import cpw.mods.fml.client.FMLClientHandler;
    import cpw.mods.fml.common.network.IPacketHandler;
    import cpw.mods.fml.common.network.Player;
     
     
    public class ClientPacketHandler implements IPacketHandler
     
    {
    public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player)
    {
    DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
     
    if (payload.channel.equals("nanotech_mod"))
    {
    handlePacket(payload);
    }
     
    }
     
    private void handlePacket(Packet250CustomPayload packet)
    {
    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
     
    int randomInt1;
    int randomInt2;
     
     
    try {
    randomInt1= inputStream.readInt();
    randomInt2= inputStream.readInt();
    } catch (IOException e) {
    e.printStackTrace();
    return;
    }
     
    }
    }