package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityModernFence extends TileEntity
{
    public boolean[] render = new boolean[] {false, false, false, false, false, false, false, false};
    private byte color;

    @Override
    public void updateEntity()
    {
        boolean flag = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord - 1, true);
        boolean flag1 = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord + 1, true);
        boolean flag2 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord, true);
        boolean flag3 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord, true);
        boolean flag4 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord + 1, false);
        boolean flag5 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord - 1, false);
        boolean flag6 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord + 1, false);
        boolean flag7 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord - 1, false);
        if(flag)
        {
            render[0] = true;
        }
        else
        {
            render[0] = false;
        }
        if(flag1)
        {
            render[1] = true;
        }
        else
        {
            render[1] = false;
        }
        if(flag2)
        {
            render[2] = true;
        }
        else
        {
            render[2] = false;
        }
        if(flag3)
        {
            render[3] = true;
        }
        else
        {
            render[3] = false;
        }
        if(flag4 && !(flag1 && flag3) && !flag1 && !flag3)
        {
            render[4] = true;
        }
        else
        {
            render[4] = false;
        }
        if(flag5 && !(flag && flag3) && !flag && !flag3)
        {
            render[5] = true;
        }
        else
        {
            render[5] = false;
        }
        if(flag6 && !(flag1 && flag2) && !flag1 && !flag2)
        {
            render[6] = true;
        }
        else
        {
            render[6] = false;
        }
        if(flag7 && !(flag && flag2) && !flag && !flag2)
        {
            render[7] = true;
        }
        else
        {
            render[7] = false;
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setByte("Color", color);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        color = nbtTagCompound.getByte("Color");
    }

    public void setColor(byte col)
    {
        this.color = col;
    }

    public byte getColor()
    {
        return color;
    }

    public boolean canConnectFenceTo(World world, int x, int y, int z, boolean b)
    {
        Block block = world.getBlock(x, y, z);
        if(block != this.getBlockType() && b)
        {
            return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false;
        }
        else if(block == this.getBlockType())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord - 2, yCoord - 2, zCoord - 2, xCoord + 2, yCoord + 2, zCoord + 2);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbt);
    }

}