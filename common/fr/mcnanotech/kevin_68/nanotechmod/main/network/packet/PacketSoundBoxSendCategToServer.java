package fr.mcnanotech.kevin_68.nanotechmod.main.network.packet;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.ByteBufUtils;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketSoundBoxSendCategToServer extends FFMTPacket
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
	public void writeData(ByteBuf buffer) throws IOException
	{
		ByteBufUtils.writeUTF8String(buffer, name);
		ByteBufUtils.writeUTF8String(buffer, id);
		ByteBufUtils.writeUTF8String(buffer, owner);
		buffer.writeInt(color);
	}

	@Override
	public void readData(ByteBuf buffer)
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