package fr.mcnanotech.kevin_68.nanotechmod.core.network.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketSpotLightByte extends FFMTPacket
{
    public int x, y, z;
    public byte index, value;

    public PacketSpotLightByte()
    {

    }

    public PacketSpotLightByte(int x, int y, int z, byte index, byte value)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
        this.value = value;
    }

    @Override
    public int getDiscriminator()
    {
        return 2;
    }

    @Override
    public void writeData(ByteBuf buffer) throws IOException
    {
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
        buffer.writeByte(index);
        buffer.writeByte(value);
    }

    @Override
    public void readData(ByteBuf buffer)
    {
        x = buffer.readInt();
        y = buffer.readInt();
        z = buffer.readInt();
        index = buffer.readByte();
        value = buffer.readByte();
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
            te.setByte(index, value);
        }
    }
}