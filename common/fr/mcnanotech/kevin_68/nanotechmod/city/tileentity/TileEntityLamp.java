/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;

public class TileEntityLamp extends TileEntity
{
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

	public void updateEntity()
	{
		if(this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
		{
			if(this.getBlockMetadata() == 2 && !worldObj.isDaytime())
			{
				if(worldObj.isAirBlock(xCoord + 1, yCoord, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord - 1, yCoord, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord, yCoord, zCoord + 1, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord, zCoord - 1, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord + 1, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord + 1, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord - 1, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord + 1, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord, yCoord + 1, zCoord + 1, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord + 1, zCoord - 1, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord + 1, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord + 2, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord - 1, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord + 2, zCoord, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord, yCoord + 2, zCoord + 1, NanotechCityBlock.lightAir);
				if(worldObj.isAirBlock(xCoord, yCoord + 2, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord + 2, zCoord - 1, NanotechCityBlock.lightAir);
			}
			else if(this.getBlockMetadata() == 3 && worldObj.isDaytime())
			{

				if(worldObj.isAirBlock(xCoord + 1, yCoord, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord - 1, yCoord, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord, yCoord, zCoord + 1, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord, zCoord - 1, Blocks.air);
				if(worldObj.isAirBlock(xCoord + 1, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord + 1, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord - 1, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord + 1, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
					worldObj.setBlock(xCoord, yCoord + 1, zCoord + 1, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord + 1, zCoord - 1, Blocks.air);
				if(worldObj.isAirBlock(xCoord + 1, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord + 1, yCoord + 2, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord - 1, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord - 1, yCoord + 2, zCoord, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord + 2, zCoord))
					worldObj.setBlock(xCoord, yCoord + 2, zCoord + 1, Blocks.air);
				if(worldObj.isAirBlock(xCoord, yCoord + 2, zCoord - 1))
					worldObj.setBlock(xCoord, yCoord + 2, zCoord - 1, Blocks.air);
			}
		}

	}
}