package fr.mcnanotech.kevin_68.nanotechmod.main.network.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.network.AbstractPacket;

public class PacketSoundBoxSendCategToServer extends AbstractPacket
{
	private String name, id, owner;
	private int color;
	
	public PacketSoundBoxSendCategToServer()
	{
		
	}
	
	public PacketSoundBoxSendCategToServer(CategoryEntry entry)
	{
		this.name = entry.getName();
		this.id = entry.getId();
		this.owner = entry.getOwner();
		this.color = entry.getColor();
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		ByteBufUtils.writeUTF8String(buffer, name);
		ByteBufUtils.writeUTF8String(buffer, id);
		ByteBufUtils.writeUTF8String(buffer, owner);
		buffer.writeInt(color);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		name = ByteBufUtils.readUTF8String(buffer);
		id = ByteBufUtils.readUTF8String(buffer);
		owner = ByteBufUtils.readUTF8String(buffer);
		color = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		
	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		UtilSoundBox.importCategoryToServer(new CategoryEntry(this.name, this.owner, this.color, this.id));
	}
}