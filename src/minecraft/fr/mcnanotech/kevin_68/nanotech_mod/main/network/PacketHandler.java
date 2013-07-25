package fr.mcnanotech.kevin_68.nanotech_mod.main.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.Slot;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityBeacon;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		EntityPlayer playerSender = (EntityPlayer)player;

		if(packet.channel.equals("NTM|smoker"))
		{
			handleSmoker(packet, playerSender);
		}

	}

	private void handleSmoker(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

		int smokePower;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			smokePower = data.readInt();
			ContainerSmoker containersmoker = (ContainerSmoker)player.openContainer;
			TileEntitySmoker tileSmoker = containersmoker.getSmoker();
			tileSmoker.setSmokeInt(smokePower);
			player.worldObj.markBlockForUpdate(tileSmoker.xCoord, tileSmoker.yCoord, tileSmoker.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}

	}

}
