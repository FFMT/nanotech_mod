/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntitySatelite;

public class TileEntityButton extends TileEntity
{
	public void crashSatelite()
	{
		if(monitorNextToPad(this.worldObj, this.xCoord, this.yCoord, this.zCoord))
		{
			this.worldObj.spawnEntityInWorld(new EntitySatelite(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord));
			if(this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord).equals(NanotechModList.satelite) && this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, NanotechModList.satelite, 2, 2);
			}
		}
	}

	public boolean monitorNextToPad(World world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) != 0)
		{
			boolean flag = world.getBlock(x - 1, y, z).equals(NanotechModList.satelite) && world.getBlockMetadata(x - 1, y, z) == 0;
			boolean flag1 = world.getBlock(x + 1, y, z).equals(NanotechModList.satelite) && world.getBlockMetadata(x + 1, y, z) == 0;
			boolean flag2 = world.getBlock(x, y, z - 1).equals(NanotechModList.satelite) && world.getBlockMetadata(x, y, z - 1) == 0;
			boolean flag3 = world.getBlock(x, y, z + 1).equals(NanotechModList.satelite) && world.getBlockMetadata(x, y, z + 1) == 0;
			return flag ? true : (flag1 ? true : (flag2 ? true : (flag3 ? true : false)));
		}
		return false;
	}
}
