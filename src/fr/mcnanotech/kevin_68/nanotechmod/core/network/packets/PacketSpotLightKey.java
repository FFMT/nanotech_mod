package fr.mcnanotech.kevin_68.nanotechmod.core.network.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.ByteBufUtils;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.SpotLightEntry;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketSpotLightKey extends FFMTPacket
{
    public int x, y, z;
    public int index;
    public NBTTagCompound tag = new NBTTagCompound();

    public PacketSpotLightKey()
    {

    }

    public PacketSpotLightKey(int x, int y, int z, int index, SpotLightEntry entry)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
        entry.writeToNBT(this.tag);
    }

    @Override
    public int getDiscriminator()
    {
        return 3;
    }

    @Override
    public void writeData(ByteBuf buffer) throws IOException
    {
        buffer.writeInt(this.x);
        buffer.writeInt(this.y);
        buffer.writeInt(this.z);
        buffer.writeInt(this.index);
        ByteBufUtils.writeTag(buffer, this.tag);
    }

    @Override
    public void readData(ByteBuf buffer)
    {
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.index = buffer.readInt();
        this.tag = ByteBufUtils.readTag(buffer);
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
            SpotLightEntry entry = SpotLightEntry.loadSpotLightEntryFromNBT(this.tag);
            te.setKey(this.index, entry);
        }
    }
}