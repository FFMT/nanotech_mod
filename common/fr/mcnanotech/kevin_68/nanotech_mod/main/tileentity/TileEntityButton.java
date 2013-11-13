package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySatelite;

public class TileEntityButton extends TileEntity
{
	public void updateEntity()
	{

	}

	public void crashSatelite()
	{
		if(monitorNextToPad(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
		{
			this.worldObj.spawnEntityInWorld(new EntitySatelite(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord));
			if(this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == NanotechBlock.satelite.blockID && this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, NanotechBlock.satelite.blockID, 2, 2);
			}
		}
	}

	public boolean monitorNextToPad(World world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) != 0)
		{
			boolean flag = world.getBlockId(x - 1, y, z) == NanotechBlock.satelite.blockID && world.getBlockMetadata(x - 1, y, z) == 0;
			boolean flag1 = world.getBlockId(x + 1, y, z) == NanotechBlock.satelite.blockID && world.getBlockMetadata(x + 1, y, z) == 0;
			boolean flag2 = world.getBlockId(x, y, z - 1) == NanotechBlock.satelite.blockID && world.getBlockMetadata(x, y, z - 1) == 0;
			boolean flag3 = world.getBlockId(x, y, z + 1) == NanotechBlock.satelite.blockID && world.getBlockMetadata(x, y, z + 1) == 0;
			return flag ? true : (flag1 ? true : (flag2 ? true : (flag3 ? true : false)));
		}
		return false;
	}
}
