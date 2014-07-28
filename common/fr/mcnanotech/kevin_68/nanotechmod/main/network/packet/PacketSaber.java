/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.network.packet;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.minecraftforgefrance.ffmtlibs.network.FFMTPacket;

public class PacketSaber extends FFMTPacket
{
    private int colorId, colorValue;

    public PacketSaber()
    {}

    public PacketSaber(int id, int value)
    {
        this.colorId = id;
        this.colorValue = value;
    }

    @Override
    public void writeData(ByteBuf buffer) throws IOException
    {
        buffer.writeInt(this.colorId);
        buffer.writeInt(this.colorValue);
    }

    @Override
    public void readData(ByteBuf buffer)
    {
        this.colorId = buffer.readInt();
        this.colorValue = buffer.readInt();
    }

    @Override
    public void handleClientSide(EntityPlayer player)
    {

    }

    @Override
    public void handleServerSide(EntityPlayer player)
    {
        ItemStack saberStack = player.getCurrentEquippedItem();
        if(saberStack.getItem() != NanotechItem.lightSaber)
        {
            NanotechMod.nanoLogger.error("A saber packet is erroned");
            return;
        }
        if(!saberStack.hasTagCompound())
        {
            saberStack.setTagCompound(new NBTTagCompound());
        }
        switch(colorId)
        {
            case 0:
                saberStack.getTagCompound().setInteger("red", colorValue);
                break;
            case 1:
                saberStack.getTagCompound().setInteger("green", colorValue);
                break;
            case 2:
                saberStack.getTagCompound().setInteger("blue", colorValue);
                break;
            default:
                NanotechMod.nanoLogger.error("A saber packet has a bad type, this is a bug");
        }
    }
}