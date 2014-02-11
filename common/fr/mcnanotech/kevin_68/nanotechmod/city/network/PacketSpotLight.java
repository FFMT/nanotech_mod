package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketSpotLight extends AbstractPacket
{
	int x, y, z, red, green, blue, darkRed, darkGreen, darkBlue;

	public PacketSpotLight()
	{}

	public PacketSpotLight(int x, int y, int z, int red, int blue, int green, int darkRed, int darkGreen, int darkBlue)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.red = red;
		this.blue = blue;
		this.green = green;
		this.darkRed = darkRed;
		this.darkGreen = darkGreen;
		this.darkBlue = darkBlue;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(red);
		buffer.writeInt(blue);
		buffer.writeInt(green);
		buffer.writeInt(darkRed);
		buffer.writeInt(darkGreen);
		buffer.writeInt(darkBlue);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		red = buffer.readInt();
		green = buffer.readInt();
		blue = buffer.readInt();
		darkRed = buffer.readInt();
		darkGreen = buffer.readInt();
		darkBlue = buffer.readInt();
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

			te.setRedValue(red);
			te.setGreenValue(green);
			te.setBlueValue(blue);
			te.setDarkRedValue(darkRed);
			te.setDarkGreenValue(darkGreen);
			te.setDarkBlueValue(darkBlue);

			world.markBlockForUpdate(x, y, z);
		}
	}
}