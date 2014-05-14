/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.network.packet;

import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketTextSpotLightString extends AbstractPacket
{
	public int x, y, z;
	public String text;

	public PacketTextSpotLightString()
	{}

	public PacketTextSpotLightString(int x, int y, int z, String text)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.text = text;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, PacketBuffer buffer) throws IOException
	{
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeStringToBuffer(text);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, PacketBuffer buffer) throws IOException
	{
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		text = buffer.readStringFromBuffer(32767);
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
			te.setText(text);
		}
	}
}