package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityModernFence extends TileEntity
{
	public boolean[] textures = new boolean[] {false, false, false, false, false, false, false, false};

	public void updateEntity()
	{
		boolean flag = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord - 1);
		boolean flag1 = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord + 1);
		boolean flag2 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord);
		boolean flag3 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord);
		boolean flag4 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord + 1);
		boolean flag5 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord - 1);
		boolean flag6 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord + 1);
		boolean flag7 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord - 1);

		if(flag)
		{
			textures[0] = true;
		}
		else
		{
			textures[0] = false;
		}
		if(flag1)
		{
			textures[1] = true;
		}
		else
		{
			textures[1] = false;
		}
		if(flag2)
		{
			textures[2] = true;
		}
		else
		{
			textures[2] = false;
		}
		if(flag3)
		{
			textures[3] = true;
		}
		else
		{
			textures[3] = false;
		}
		if(flag4)
		{
			textures[4] = true;
		}
		else
		{
			textures[4] = false;
		}
		if(flag5)
		{
			textures[5] = true;
		}
		else
		{
			textures[5] = false;
		}
		if(flag6)
		{
			textures[6] = true;
		}
		else
		{
			textures[6] = false;
		}
		if(flag7)
		{
			textures[7] = true;
		}
		else
		{
			textures[7] = false;
		}

	}

	public boolean canConnectFenceTo(World world, int x, int y, int z)
	{
		int l = world.getBlockId(x, y, z);

		if(l != this.getBlockType().blockID)
		{
			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
		else
		{
			return true;
		}
	}

}
