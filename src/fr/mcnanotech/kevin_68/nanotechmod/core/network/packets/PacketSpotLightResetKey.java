package fr.mcnanotech.kevin_68.nanotechmod.core.network.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import cpw.mods.fml.common.network.ByteBufUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketSpotLightResetKey extends FFMTPacket
{
	public int x, y, z;
	public int index;
	
	public PacketSpotLightResetKey()
	{
		
	}
	
	public PacketSpotLightResetKey(int x, int y, int z, int index)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.index = index;
	}
	
	@Override
	public void writeData(ByteBuf buffer) throws IOException
	{
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
		buffer.writeInt(this.index);
	}

	@Override
	public void readData(ByteBuf buffer)
	{
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.index = buffer.readInt();
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
			te.setKey(this.index, null);
		}
	}
}