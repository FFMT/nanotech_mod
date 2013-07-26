package fr.mcnanotech.kevin_68.nanotech_mod.main.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		EntityPlayer playerSender = (EntityPlayer)player;

		if(packet.channel.equals("NTM|smoker"))
		{
			handleSmokerPacket(packet, playerSender);
		}
		
		if(packet.channel.equals("NTM|jumper"))
		{
			handleJumperPacket(packet, playerSender);
		}
		
		if(packet.channel.equals("NTM|light"))
		{
			handleSpotLightPacket(packet, playerSender);
		}
	}

	private void handleSmokerPacket(Packet250CustomPayload packet, EntityPlayer player)
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
			Nanotech_mod.NanoLog.severe("Failed to handle smoker packet");
		}
	}
	
	private void handleJumperPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int jumpHeith;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			jumpHeith = data.readInt();
			ContainerJumper containerJumper = (ContainerJumper)player.openContainer;
			TileEntityJumper tileJumper = containerJumper.getJumper();
			tileJumper.setJumpHeight(jumpHeith);
			player.worldObj.markBlockForUpdate(tileJumper.xCoord, tileJumper.yCoord, tileJumper.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.NanoLog.severe("Failed to handle jumper packet");
		}
	}

	private void handleSpotLightPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int type;
		int color;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			type = data.readInt();
			color = data.readInt();
			ContainerBlockSpotLight containerSpotLight = (ContainerBlockSpotLight)player.openContainer;
			TileEntityBlockSpotLight tileSpotLight = containerSpotLight.getSpotLight();
			switch(type)
			{
				case 0: tileSpotLight.setRedValue(color);
					break;
				case 1: tileSpotLight.setGreenValue(color);
					break;
				case 2: tileSpotLight.setBlueValue(color);
					break;
				case 3: tileSpotLight.setDarkRedValue(color);
					break;
				case 4: tileSpotLight.setDarkGreenValue(color);
					break;
				case 5: tileSpotLight.setDarkBlueValue(color);
					break;
				default: Nanotech_mod.NanoLog.severe("A SpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.NanoLog.severe("Failed to handle SpotLight packet");
		}
	}
}
