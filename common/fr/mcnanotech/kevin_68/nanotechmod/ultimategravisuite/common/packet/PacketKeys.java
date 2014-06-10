package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.packet;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketKeys extends FFMTPacket
{
	private int keyState;

	public PacketKeys()
	{}

	public PacketKeys(int currentKeyState)
	{
		this.keyState = currentKeyState;
	}
	
	@Override
	public void writeData(ByteBuf buffer) throws IOException
	{
		buffer.writeInt(this.keyState);
	}

	@Override
	public void readData(ByteBuf buffer)
	{
		this.keyState = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{

	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		UltimateGraviSuiteMod.keyboard.processKeyUpdate(player, this.keyState);
	}
}