package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class TileEntitySmoker extends TileEntity
{
	public int Smokepower;
	
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("Smoke", Smokepower);
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        Smokepower = nbtTagCompound.getInteger("Smoke");
    }
	
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 4, nbttagcompound);
    }
    
    public void addSmokeInt()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try 
        {
        	outputStream.writeInt(Smokepower += 1);
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "nanotech_mod";
        packet.data = bos.toByteArray();
        packet.length = bos.size();
        
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        if (side == Side.SERVER) {
        // We are on the server side.
        EntityPlayerMP player = (EntityPlayerMP) playerEntity;
        } else if (side == Side.CLIENT) {
        // We are on the client side.
        EntityClientPlayerMP player = (EntityClientPlayerMP) playerEntity;
        player.sendQueue.addToSendQueue(packet);
        } else {
        // We are on the Bukkit server.
        }
    }
    
    public void dimSmokeInt()
    {
    	if(Smokepower > 0)
        Smokepower --;
    }
    
    public int getSmokeValue()
    {
        return this.Smokepower;
    }
}
