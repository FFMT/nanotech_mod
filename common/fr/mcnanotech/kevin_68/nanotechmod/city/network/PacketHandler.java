package fr.mcnanotech.kevin_68.nanotechmod.city.network;


public class PacketHandler //implements IPacketHandler
{
	/*@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		EntityPlayer playerSender = (EntityPlayer)player;
		if(packet.channel.equals("NTMC|light"))
		{
			handleSpotLightPacket(packet, playerSender);
		}
		
		if(packet.channel.equals("NTMC|lightKey"))
		{
			handleSpotLightKeyPacket(packet, playerSender);
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
		
		if(packet.channel.equals("NTMC|text3"))
		{
			handleTextSpotLightPacket3(packet, playerSender);
		}
	}

	private void handleSpotLightPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int type;
		int value;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			type = data.readInt();
			value = data.readInt();
			ContainerSpotLight containerSpotLight = (ContainerSpotLight)player.openContainer;
			TileEntitySpotLight tileSpotLight = containerSpotLight.getSpotLight();
			switch(type)
			{
			case 0:
				tileSpotLight.setRedValue(value);
				break;
			case 1:
				tileSpotLight.setGreenValue(value);
				break;
			case 2:
				tileSpotLight.setBlueValue(value);
				break;
			case 3:
				tileSpotLight.setDarkRedValue(value);
				break;
			case 4:
				tileSpotLight.setDarkGreenValue(value);
				break;
			case 5:
				tileSpotLight.setDarkBlueValue(value);
				break;
			case 6:
				tileSpotLight.setAngle1Value(value);
				break;
			case 7:
				tileSpotLight.setAngle2Value(value);
				break;
			case 8:
				tileSpotLight.setRotateValue(value);
				break;
			case 9:
				tileSpotLight.setRotationSpeed(value);
				break;
			case 10:
				tileSpotLight.setSecondaryLazer(value);
				break;
			case 11:
				tileSpotLight.setReverseRotation(value);
				break;
			case 12:
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
			case 13:
				tileSpotLight.setTimeLineMode(value);
				break;
			case 14:
				tileSpotLight.setCreateKeyTime(value);
				break;
			case 15:
				tileSpotLight.setSelectedButtonId(value);
				break;
			case 16:
				tileSpotLight.setTimeLine(value);
				break;
			case 17:
				tileSpotLight.setSmoothMode(value);
				break;
			default:
				NanotechMod.nanoLog.severe("A SpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle SpotLight packet");
		}
	}
	
	private void handleSpotLightKeyPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int type;
		int value;
		int time;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			type = data.readInt();
			value = data.readInt();
			time = data.readInt();
			ContainerSpotLight containerSpotLight = (ContainerSpotLight)player.openContainer;
			TileEntitySpotLight tileSpotLight = containerSpotLight.getSpotLight();
			switch(type)
			{
			case 0:
				tileSpotLight.setKey(time, value);
				break;
			case 1:
				tileSpotLight.setRedKey(time, value);
				break;
			case 2:
				tileSpotLight.setGreenKey(time, value);
				break;
			case 3:
				tileSpotLight.setBlueKey(time, value);
				break;
			case 4:
				tileSpotLight.setDarkRedKey(time, value);
				break;
			case 5:
				tileSpotLight.setDarkGreenKey(time, value);
				break;
			case 6:
				tileSpotLight.setDarkBlueKey(time, value);
				break;
			case 7:
				tileSpotLight.setAngle1Key(time, value);
				break;
			case 8:
				tileSpotLight.setAngle2Key(time, value);
				break;
			case 9:
				tileSpotLight.setAutoRotateKey(time, value);
				break;
			case 10:
				tileSpotLight.setRotationSpeedKey(time, value);
				break;
			case 11:
				tileSpotLight.setSecondaryLazerKey(time, value);
				break;
			case 12:
				tileSpotLight.setReverseRotationKey(time, value);
				break;
			default:
				NanotechMod.nanoLog.severe("A SpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle SpotLight packet");
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
			NanotechMod.nanoLog.severe("Failed to handle Fountain packet");
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
				NanotechMod.nanoLog.severe("A TextSpotLight packet has a bad type, this is a bug");
			}
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle TextSpotLight packet");
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
			NanotechMod.nanoLog.severe("Failed to handle TextSpotLight packet");
		}
	}
	
	private void handleTextSpotLightPacket3(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		Float value;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			value = data.readFloat();
			ContainerTextSpotLight containerSpotLight = (ContainerTextSpotLight)player.openContainer;
			TileEntityTextSpotLight tileSpotLight = containerSpotLight.getSpotLight();
			tileSpotLight.setScale(value);
			player.worldObj.markBlockForUpdate(tileSpotLight.xCoord, tileSpotLight.yCoord, tileSpotLight.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle TextSpotLight packet");
		}
	}*/
}