package fr.mcnanotech.kevin_68.nanotech_mod.city.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		EntityPlayer playerSender = (EntityPlayer)player;
		if(packet.channel.equals("NTMC|light"))
		{
			handleSpotLightPacket(packet, playerSender);
		}

		if(packet.channel.equals("NTMC|fount"))
		{
			handleFountainPacket(packet, playerSender);
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
			ContainerSpotLight containerSpotLight = (ContainerSpotLight)player.openContainer;
			TileEntitySpotLight tileSpotLight = containerSpotLight.getSpotLight();
			switch(type)
			{
			case 0:
				tileSpotLight.setRedValue(color);
				break;
			case 1:
				tileSpotLight.setGreenValue(color);
				break;
			case 2:
				tileSpotLight.setBlueValue(color);
				break;
			case 3:
				tileSpotLight.setDarkRedValue(color);
				break;
			case 4:
				tileSpotLight.setDarkGreenValue(color);
				break;
			case 5:
				tileSpotLight.setDarkBlueValue(color);
				break;
			default:
				Nanotech_mod.NanoLog.severe("A SpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.NanoLog.severe("Failed to handle SpotLight packet");
		}
	}

	private void handleFountainPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		float height;
		float width;
		boolean rotate;
		boolean animated;

		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			height = data.readFloat();
			width = data.readFloat();
			rotate = data.readBoolean();
			animated = data.readBoolean();

			ContainerFountain containerFountain = (ContainerFountain)player.openContainer;
			TileEntityFountain tilefountain = containerFountain.getFountain();
			tilefountain.setHeight(height);
			tilefountain.setWidth(width);
			tilefountain.setRotate(rotate);
			tilefountain.setAnimated(animated);
			player.worldObj.markBlockForUpdate(tilefountain.xCoord, tilefountain.yCoord, tilefountain.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.NanoLog.severe("Failed to handle Fountain packet");
		}
	}
}
