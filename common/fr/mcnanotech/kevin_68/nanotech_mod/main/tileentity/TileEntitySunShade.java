package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class TileEntitySunShade extends TileEntity
{
	public String texture;

	public void updateEntity()
	{
		if (this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			texture = "Open";
			if (this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 1)
			{
				for (int j = -1; j < 2; ++j)
				{
					for (int k = -1; k < 2; ++k)
					{
						if(j == 0 && k == 0)
						{
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechBlock.BlockSunShade.blockID, 3, 1);
						}
						else
						{
							this.worldObj.setBlock(xCoord + j, yCoord + 2, zCoord + k, NanotechBlock.BlockSunShade.blockID, 2, 1);
						}
					}
				}
			}
		}
		else
		{
			texture = "Close";
			if (this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 3)
			{
				for (int j = -1; j < 2; ++j)
				{
					for (int k = -1; k < 2; ++k)
					{
						if(j == 0 && k == 0)
						{
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechBlock.BlockSunShade.blockID, 1, 1);
						}
						else
						{
							this.worldObj.setBlockToAir(xCoord + j, yCoord + 2, zCoord + k);
						}
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}
}
