package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntityModernFence extends TileEntity
{
	public boolean[] render = new boolean[] {false, false, false, false, false, false, false, false};

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

	public boolean canConnectFenceTo(World world, int x, int y, int z, boolean b)
	{
		int l = world.getBlockId(x, y, z);

		if(l != this.getBlockType().blockID && b)
		{
			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
		else if (l == this.getBlockType().blockID)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

}
