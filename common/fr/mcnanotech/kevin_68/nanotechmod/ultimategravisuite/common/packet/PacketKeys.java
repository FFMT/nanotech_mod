package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.packet;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketKeys extends AbstractPacket
{
	private int keyState;

	public PacketKeys()
	{}

	public PacketKeys(int currentKeyState)
	{
		this.keyState = currentKeyState;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, PacketBuffer buffer)
	{
		buffer.writeInt(this.keyState);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, PacketBuffer buffer)
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