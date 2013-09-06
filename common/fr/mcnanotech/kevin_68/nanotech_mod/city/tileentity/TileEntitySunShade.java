package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;

public class TileEntitySunShade extends TileEntity
{
	public String texture;

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			texture = "Open";
			if(this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 1)
			{
				for(int j = -1; j < 2; ++j)
				{
					for(int k = -1; k < 2; ++k)
					{
						if(j == 0 && k == 0)
						{
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.BlockSunShade.blockID, 3, 1);
						}
						else
						{
							this.worldObj.setBlock(xCoord + j, yCoord + 2, zCoord + k, NanotechCityBlock.BlockSunShade.blockID, 2, 1);
						}
					}
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
		}
		else
		{
			texture = "Close";
			if(this.worldObj.getBlockMetadata(xCoord, yCoord + 2, zCoord) == 3)
			{
				for(int j = -1; j < 2; ++j)
				{
					for(int k = -1; k < 2; ++k)
					{
						if(j == 0 && k == 0)
						{
							this.worldObj.setBlock(xCoord, yCoord + 2, zCoord, NanotechCityBlock.BlockSunShade.blockID, 1, 1);
						}
						else
						{
							this.worldObj.setBlockToAir(xCoord + j, yCoord + 2, zCoord + k);
						}
					}
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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