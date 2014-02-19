/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketSmoker extends AbstractPacket
{
	private int x, y, z, smoke;

	public PacketSmoker()
	{}

	public PacketSmoker(int x, int y, int z, int smoke)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.smoke = smoke;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(smoke);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		smoke = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		TileEntity tile = player.worldObj.getTileEntity(x, y, z);

		if(tile instanceof TileEntitySmoker)
		{
			TileEntitySmoker te = (TileEntitySmoker)tile;
			te.setSmokeInt(smoke);
		}
	}
}