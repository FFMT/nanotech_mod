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
import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerTextSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;
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
		
		if(packet.channel.equals("NTMC|text"))
		{
			handleTextSpotLightPacket(packet, playerSender);
		}
		
		if(packet.channel.equals("NTMC|text2"))
		{
			handleTextSpotLightPacket2(packet, playerSender);
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
			case 6:
				tileSpotLight.setAngle1Value(color);
				break;
			case 7:
				tileSpotLight.setAngle2Value(color);
				break;
			case 8:
				tileSpotLight.setRotateValue(color);
				break;
			case 9:
				tileSpotLight.setRotationSpeed(color);
				break;
			case 10:
				tileSpotLight.setSecondaryLazer(color);
				break;
			case 11:
				tileSpotLight.setReverseRotation(color);
				break;
			case 12:
				if(color == 0)
				{
					tileSpotLight.addNbtTagToItem();
					break;
				}
				else
				{
					tileSpotLight.setConfig();
					break;
				}
			default:
				Nanotech_mod.nanoLog.severe("A SpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to handle SpotLight packet");
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
			Nanotech_mod.nanoLog.severe("Failed to handle Fountain packet");
		}
	}
	
	private void handleTextSpotLightPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int value;
		int type;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			type = data.readInt();
			value = data.readInt();
			ContainerTextSpotLight containerSpotLight = (ContainerTextSpotLight)player.openContainer;
			TileEntityTextSpotLight tileSpotLight = containerSpotLight.getSpotLight();
			switch(type)
			{
			case 1:
				if(value == 1)
				{
					tileSpotLight.setRotate(true);
					break;
				}
				else
				{
					tileSpotLight.setRotate(false);
					break;
				}
			case 2:
				tileSpotLight.setAngle(value);
				break;
			case 3:
				tileSpotLight.setRotationSpeed(value);
				break;
			case 4:
				if(value == 1)
				{
					tileSpotLight.setReverseRotation(true);
					break;
				}
				else
				{
					tileSpotLight.setReverseRotation(false);
					break;
				}
			case 5:
				tileSpotLight.setRedValue(value);
				break;
			case 6:
				tileSpotLight.setGreenValue(value);
				break;
			case 7:
				tileSpotLight.setBlueValue(value);
				break;
			case 8:
				tileSpotLight.setScale(value);
				break;
			case 9:
				tileSpotLight.setHeight(value);
				break;
			case 10:
				if(value == 0)
				{
					tileSpotLight.addNbtTagToItem();
					break;
				}
				else
				{
					tileSpotLight.setConfig();
					break;
				}
			default:
				Nanotech_mod.nanoLog.severe("A TextSpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to handle TextSpotLight packet");
		}
	}
	
	private void handleTextSpotLightPacket2(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		String text;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			text = data.readUTF();
			ContainerTextSpotLight containerSpotLight = (ContainerTextSpotLight)player.openContainer;
			TileEntityTextSpotLight tileSpotLight = containerSpotLight.getSpotLight();
			tileSpotLight.setText(text);
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			Nanotech_mod.nanoLog.severe("Failed to handle TextSpotLight packet");
		}
	}
}