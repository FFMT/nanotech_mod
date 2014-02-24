/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketTextSpotLight extends AbstractPacket
{
	public int x, y, z, index, value;

	public PacketTextSpotLight()
	{}

	public PacketTextSpotLight(int x, int y, int z, int index, int value)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = index;
		this.value = value;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(index);
		buffer.writeInt(value);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		index = buffer.readInt();
		value = buffer.readInt();
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

		if(tile instanceof TileEntityTextSpotLight)
		{
			TileEntityTextSpotLight te = (TileEntityTextSpotLight)tile;
			te.set(index, value);
		}
	}

}
