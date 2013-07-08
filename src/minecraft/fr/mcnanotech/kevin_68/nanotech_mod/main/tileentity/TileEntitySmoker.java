package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySmoker extends TileEntity
{
	public int Smokepower;

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
	    if (tagCompound.hasKey("Power"))
	    {
			Smokepower = tagCompound.getInteger("Power");
	    }
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("Power", Smokepower);
	}

	public void processActivate(EntityPlayer player, World world)
	{
		Smokepower ++;
		if(Smokepower > 16)
		{
			Smokepower = 0;
		}

		player.addChatMessage(String.valueOf(Smokepower));
		world.notifyBlockChange(xCoord, yCoord, zCoord, 2);
		
	}
}
