/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketListerJukebox extends AbstractPacket
{
	private int x, y, z, index, listIndex;

	public PacketListerJukebox()
	{}

	public PacketListerJukebox(int x, int y, int z, int index, int listIndex)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = index;
		this.listIndex = listIndex;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(index);
		buffer.writeInt(listIndex);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		index = buffer.readInt();
		listIndex = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		TileEntity tile = player.worldObj.getTileEntity(x, y, z);

		if(tile instanceof TileEntitySoundBox)
		{
			TileEntitySoundBox te = (TileEntitySoundBox)tile;
			te.set(index, listIndex);
		}
	}
}