package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLamp extends TileEntity 
{
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}
}
