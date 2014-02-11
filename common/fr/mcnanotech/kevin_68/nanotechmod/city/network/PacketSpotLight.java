package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketSpotLight extends AbstractPacket
{
	int x, y, z, index, red, green, blue, darkRed, darkGreen, darkBlue;

	public PacketSpotLight()
	{}

	public PacketSpotLight(int x, int y, int z, int index, int value)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = index;

		switch(index)
		{
		case 0:
			this.red = value;
			break;
		case 1:
			this.green = value;
			break;
		case 2:
			this.blue = value;
			break;
		case 3:
			this.darkRed = value;
			break;
		case 4:
			this.darkGreen = value;
			break;
		case 5:
			this.darkBlue = value;
			break;
		default:
			System.out.println("[NTMC][1]Wrong index : " + index);
			break;
		}
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(index);
		switch(index)
		{
		case 0:
			buffer.writeInt(red);
			break;
		case 1:
			buffer.writeInt(blue);
			break;
		case 2:
			buffer.writeInt(green);
			break;
		case 3:
			buffer.writeInt(darkRed);
			break;
		case 4:
			buffer.writeInt(darkGreen);
			break;
		case 5:
			buffer.writeInt(darkBlue);
			break;
		default:
			System.out.println("[NTMC][2]Wrong index : " + index);
			break;
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		index = buffer.readInt();
		switch(index)
		{
		case 0:
			red = buffer.readInt();
			break;
		case 1:
			green = buffer.readInt();
			break;
		case 2:
			blue = buffer.readInt();
			break;
		case 3:
			darkRed = buffer.readInt();
			break;
		case 4:
			darkGreen = buffer.readInt();
			break;
		case 5:
			darkBlue = buffer.readInt();
			break;
		default:
			System.out.println("[NTMC][3]Wrong index : " + index);
			break;
		}
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		World world = player.worldObj;
		TileEntity tile = world.getTileEntity(x, y, z);

		if(tile instanceof TileEntitySpotLight)
		{
			TileEntitySpotLight te = (TileEntitySpotLight)tile;
			switch(index)
			{
			case 0:
				te.setRedValue(red);
				break;
			case 1:
				te.setGreenValue(green);
				break;
			case 2:
				te.setBlueValue(blue);
				break;
			case 3:
				te.setDarkRedValue(darkRed);
				break;
			case 4:
				te.setDarkGreenValue(darkGreen);
				break;
			case 5:
				te.setDarkBlueValue(darkBlue);
				break;
			default:
				System.out.println("[NTMC][4]Wrong index : " + index);
				break;
			}
			world.markBlockForUpdate(x, y, z);
		}

	}

}
