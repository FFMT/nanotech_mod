package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockLightAir extends Block
{

	protected BlockLightAir()
	{
		super(Material.air);
	}

	public int getRenderType()
	{
		return -1;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_)
	{
		return false;
	}

	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
	{}
}