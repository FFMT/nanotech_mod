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
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketListerJukeboxString extends AbstractPacket
{
	private int x, y, z;
	private String txt;

	public PacketListerJukeboxString()
	{}

	public PacketListerJukeboxString(int x, int y, int z, String txt)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.txt = txt;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		char[] chrs = txt.toCharArray();
		buffer.writeShort(chrs.length - 1);
		for(char i : chrs)
		{
			buffer.writeChar(i);
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();

		short lenght = buffer.readShort();
		String str = "";
		for(short i = 0; i <= lenght; i++)
		{
			str += buffer.readChar();
		}
		txt = str;
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		TileEntity tile = player.worldObj.getTileEntity(x, y, z);

		if(tile instanceof TileEntityListerJukebox)
		{
			TileEntityListerJukebox te = (TileEntityListerJukebox)tile;
			te.set(txt);
		}
	}
}