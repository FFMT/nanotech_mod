package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityLampLight extends TileEntity
{
	public String getLampTexture = "nanotechmodcity:textures/blocks/BlockLampLightOn.png";

	public void updateEntity()
	{
		getLampTexture = texture();
		if(this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
		{
			if(this.getBlockMetadata() == 2 && !worldObj.isDaytime())
			{
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
			}
			else if(this.getBlockMetadata() == 3 && worldObj.isDaytime())
			{
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

	public String texture()
	{
		if(this.getBlockMetadata() == 3)
		{
			return "nanotechmodcity:textures/blocks/BlockLampLightOn.png";
		}
		else
		{
			return "nanotechmodcity:textures/blocks/BlockLampLightOff.png";
		}
	}
}