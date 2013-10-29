package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidNitrogen extends BlockFluidClassic
{
	private Icon stillIcon, flowingIcon;

	public BlockLiquidNitrogen(int id, Fluid fluid, Material material)
	{
		super(id, fluid, material);
		this.setTickRandomly(true);
	}

	public Icon getIcon(int side, int meta)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	public void registerIcons(IconRegister register)
	{
		stillIcon = register.registerIcon("nanotech_mod:liquid_nitrogen_still");
		flowingIcon = register.registerIcon("nanotech_mod:liquid_nitrogen_flow");
	}

	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlockMaterial(x, y, z).isLiquid())
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlockMaterial(x, y, z).isLiquid())
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}

	public void checkUpdate(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			boolean waterYMinus1 = (world.getBlockId(x, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x, y - 1, z) == Block.waterStill.blockID);
			boolean waterYMinus2 = (world.getBlockId(x, y - 2, z) == Block.waterMoving.blockID || world.getBlockId(x, y - 2, z) == Block.waterStill.blockID);
			boolean waterYMinus3 = (world.getBlockId(x, y - 3, z) == Block.waterMoving.blockID || world.getBlockId(x, y - 3, z) == Block.waterStill.blockID);
			boolean waterYPlus1 = (world.getBlockId(x, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z) == Block.waterStill.blockID);
			boolean waterYPlus2 = (world.getBlockId(x, y + 2, z) == Block.waterMoving.blockID || world.getBlockId(x, y + 2, z) == Block.waterStill.blockID);
			boolean waterYPlus3 = (world.getBlockId(x, y + 3, z) == Block.waterMoving.blockID || world.getBlockId(x, y + 3, z) == Block.waterStill.blockID);
			boolean waterXMinus1 = (world.getBlockId(x - 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z) == Block.waterStill.blockID);
			boolean waterXMinus2 = (world.getBlockId(x - 2, y, z) == Block.waterMoving.blockID || world.getBlockId(x - 2, y, z) == Block.waterStill.blockID);
			boolean waterXMinus3 = (world.getBlockId(x - 3, y, z) == Block.waterMoving.blockID || world.getBlockId(x - 3, y, z) == Block.waterStill.blockID);
			boolean waterXPlus1 = (world.getBlockId(x + 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z) == Block.waterStill.blockID);
			boolean waterXPlus2 = (world.getBlockId(x + 2, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 2, y, z) == Block.waterStill.blockID);
			boolean waterXPlus3 = (world.getBlockId(x + 3, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 3, y, z) == Block.waterStill.blockID);
			boolean waterZMinus1 = (world.getBlockId(x, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 1) == Block.waterStill.blockID);
			boolean waterZMinus2 = (world.getBlockId(x, y, z - 2) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 2) == Block.waterStill.blockID);
			boolean waterZMinus3 = (world.getBlockId(x, y, z - 3) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 3) == Block.waterStill.blockID);
			boolean waterZPlus1 = (world.getBlockId(x, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 1) == Block.waterStill.blockID);
			boolean waterZPlus2 = (world.getBlockId(x, y, z + 2) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 2) == Block.waterStill.blockID);
			boolean waterZPlus3 = (world.getBlockId(x, y, z + 3) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 3) == Block.waterStill.blockID);
			boolean waterYMinus1XMinus1 = (world.getBlockId(x - 1, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y - 1, z) == Block.waterStill.blockID);
			boolean waterYMinus1XMinus2 = (world.getBlockId(x - 2, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 2, y - 1, z) == Block.waterStill.blockID);
			boolean waterYMinus2XMinus1 = (world.getBlockId(x - 1, y - 2, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y - 2, z) == Block.waterStill.blockID);
			boolean waterYPlus1XPlus1 = (world.getBlockId(x + 1, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y + 1, z) == Block.waterStill.blockID);
			boolean waterYPlus1XPlus2 = (world.getBlockId(x + 2, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x + 2, y + 1, z) == Block.waterStill.blockID);
			boolean waterYPlus2XPlus1 = (world.getBlockId(x + 1, y + 2, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y + 2, z) == Block.waterStill.blockID);
			boolean waterYMinus1XPlus1 = (world.getBlockId(x + 1, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y - 1, z) == Block.waterStill.blockID);
			boolean waterYMinus1XPlus2 = (world.getBlockId(x + 2, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x + 2, y - 1, z) == Block.waterStill.blockID);
			boolean waterYMinus2XPlus1 = (world.getBlockId(x + 1, y - 2, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y - 2, z) == Block.waterStill.blockID);
			boolean waterYPlus1XMinus1 = (world.getBlockId(x - 1, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y + 1, z) == Block.waterStill.blockID);
			boolean waterYPlus1XMinus2 = (world.getBlockId(x - 2, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 2, y + 1, z) == Block.waterStill.blockID);
			boolean waterYPlus2XMinus1 = (world.getBlockId(x - 1, y + 2, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y + 2, z) == Block.waterStill.blockID);
			boolean waterYMinus1ZMinus1 = (world.getBlockId(x, y - 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y - 1, z - 1) == Block.waterStill.blockID);
			boolean waterYMinus1ZMinus2 = (world.getBlockId(x, y - 1, z - 2) == Block.waterMoving.blockID || world.getBlockId(x, y - 1, z - 2) == Block.waterStill.blockID);
			boolean waterYMinus2ZMinus1 = (world.getBlockId(x, y - 2, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y - 2, z - 1) == Block.waterStill.blockID);
			boolean waterYPlus1ZPlus1 = (world.getBlockId(x, y + 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z + 1) == Block.waterStill.blockID);
			boolean waterYPlus1ZPlus2 = (world.getBlockId(x, y + 1, z + 2) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z + 2) == Block.waterStill.blockID);
			boolean waterYPlus2ZPlus1 = (world.getBlockId(x, y + 2, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y + 2, z + 1) == Block.waterStill.blockID);
			boolean waterYMinus1ZPlus1 = (world.getBlockId(x, y - 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y - 1, z + 1) == Block.waterStill.blockID);
			boolean waterYMinus1ZPlus2 = (world.getBlockId(x, y - 1, z + 2) == Block.waterMoving.blockID || world.getBlockId(x, y - 1, z + 2) == Block.waterStill.blockID);
			boolean waterYMinus2ZPlus1 = (world.getBlockId(x, y - 2, z + 1) == Block.waterMoving.blockID || world.getBlockId(x, y - 2, z + 1) == Block.waterStill.blockID);
			boolean waterYPlus1ZMinus1 = (world.getBlockId(x, y + 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z - 1) == Block.waterStill.blockID);
			boolean waterYPlus1ZMinus2 = (world.getBlockId(x, y + 1, z - 2) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z - 2) == Block.waterStill.blockID);
			boolean waterYPlus2ZMinus1 = (world.getBlockId(x, y + 2, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y + 2, z - 1) == Block.waterStill.blockID);
			boolean waterXMinus1ZMinus1 = (world.getBlockId(x - 1, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z - 1) == Block.waterStill.blockID);
			boolean waterXMinus1ZMinus2 = (world.getBlockId(x - 1, y, z - 2) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z - 2) == Block.waterStill.blockID);
			boolean waterXMinus2ZMinus1 = (world.getBlockId(x - 2, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x - 2, y, z - 1) == Block.waterStill.blockID);
			boolean waterXPlus1ZPlus1 = (world.getBlockId(x + 1, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z + 1) == Block.waterStill.blockID);
			boolean waterXPlus1ZPlus2 = (world.getBlockId(x + 1, y, z + 2) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z + 2) == Block.waterStill.blockID);
			boolean waterXPlus2ZPlus1 = (world.getBlockId(x + 2, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x + 2, y, z + 1) == Block.waterStill.blockID);
			boolean waterXMinus1ZPlus1 = (world.getBlockId(x - 1, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z + 1) == Block.waterStill.blockID);
			boolean waterXMinus1ZPlus2 = (world.getBlockId(x - 1, y, z + 2) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z + 2) == Block.waterStill.blockID);
			boolean waterXMinus2ZPlus1 = (world.getBlockId(x - 2, y, z + 1) == Block.waterMoving.blockID || world.getBlockId(x - 2, y, z + 1) == Block.waterStill.blockID);
			boolean waterXPlus1ZMinus1 = (world.getBlockId(x + 1, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z - 1) == Block.waterStill.blockID);
			boolean waterXPlus1ZMinus2 = (world.getBlockId(x + 1, y, z - 2) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z - 2) == Block.waterStill.blockID);
			boolean waterXPlus2ZMinus1 = (world.getBlockId(x + 2, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x + 2, y, z - 1) == Block.waterStill.blockID);
			boolean waterXMinusZMinusYMinus = (world.getBlockId(x - 1, y - 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y - 1, z - 1) == Block.waterStill.blockID);
			boolean waterXMinusZPlusYMinus = (world.getBlockId(x - 1, y + 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y + 1, z - 1) == Block.waterStill.blockID);
			boolean waterXMinusZMinusYPlus = (world.getBlockId(x - 1, y - 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y - 1, z + 1) == Block.waterStill.blockID);
			boolean waterXMinusZPlusYPlus = (world.getBlockId(x - 1, y + 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x - 1, y + 1, z + 1) == Block.waterStill.blockID);
			boolean waterXPlusZMinusYMinus = (world.getBlockId(x + 1, y - 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y - 1, z - 1) == Block.waterStill.blockID);
			boolean waterXPlusZPlusYMinus = (world.getBlockId(x + 1, y + 1, z - 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y + 1, z - 1) == Block.waterStill.blockID);
			boolean waterXPlusZMinusYPlus = (world.getBlockId(x + 1, y - 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y - 1, z + 1) == Block.waterStill.blockID);
			boolean waterXPlusZPlusYPlus = (world.getBlockId(x + 1, y + 1, z + 1) == Block.waterMoving.blockID || world.getBlockId(x + 1, y + 1, z + 1) == Block.waterStill.blockID);

			boolean lavaYMinus1 = (world.getBlockId(x, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x, y - 1, z) == Block.lavaStill.blockID);
			boolean lavaYMinus2 = (world.getBlockId(x, y - 2, z) == Block.lavaMoving.blockID || world.getBlockId(x, y - 2, z) == Block.lavaStill.blockID);
			boolean lavaYMinus3 = (world.getBlockId(x, y - 3, z) == Block.lavaMoving.blockID || world.getBlockId(x, y - 3, z) == Block.lavaStill.blockID);
			boolean lavaYPlus1 = (world.getBlockId(x, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z) == Block.lavaStill.blockID);
			boolean lavaYPlus2 = (world.getBlockId(x, y + 2, z) == Block.lavaMoving.blockID || world.getBlockId(x, y + 2, z) == Block.lavaStill.blockID);
			boolean lavaYPlus3 = (world.getBlockId(x, y + 3, z) == Block.lavaMoving.blockID || world.getBlockId(x, y + 3, z) == Block.lavaStill.blockID);
			boolean lavaXMinus1 = (world.getBlockId(x - 1, y, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z) == Block.lavaStill.blockID);
			boolean lavaXMinus2 = (world.getBlockId(x - 2, y, z) == Block.lavaMoving.blockID || world.getBlockId(x - 2, y, z) == Block.lavaStill.blockID);
			boolean lavaXMinus3 = (world.getBlockId(x - 3, y, z) == Block.lavaMoving.blockID || world.getBlockId(x - 3, y, z) == Block.lavaStill.blockID);
			boolean lavaXPlus1 = (world.getBlockId(x + 1, y, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z) == Block.lavaStill.blockID);
			boolean lavaXPlus2 = (world.getBlockId(x + 2, y, z) == Block.lavaMoving.blockID || world.getBlockId(x + 2, y, z) == Block.lavaStill.blockID);
			boolean lavaXPlus3 = (world.getBlockId(x + 3, y, z) == Block.lavaMoving.blockID || world.getBlockId(x + 3, y, z) == Block.lavaStill.blockID);
			boolean lavaZMinus1 = (world.getBlockId(x, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y, z - 1) == Block.lavaStill.blockID);
			boolean lavaZMinus2 = (world.getBlockId(x, y, z - 2) == Block.lavaMoving.blockID || world.getBlockId(x, y, z - 2) == Block.lavaStill.blockID);
			boolean lavaZMinus3 = (world.getBlockId(x, y, z - 3) == Block.lavaMoving.blockID || world.getBlockId(x, y, z - 3) == Block.lavaStill.blockID);
			boolean lavaZPlus1 = (world.getBlockId(x, y, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x, y, z + 1) == Block.lavaStill.blockID);
			boolean lavaZPlus2 = (world.getBlockId(x, y, z + 2) == Block.lavaMoving.blockID || world.getBlockId(x, y, z + 2) == Block.lavaStill.blockID);
			boolean lavaZPlus3 = (world.getBlockId(x, y, z + 3) == Block.lavaMoving.blockID || world.getBlockId(x, y, z + 3) == Block.lavaStill.blockID);
			boolean lavaYMinus1XMinus1 = (world.getBlockId(x - 1, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y - 1, z) == Block.lavaStill.blockID);
			boolean lavaYMinus1XMinus2 = (world.getBlockId(x - 2, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x - 2, y - 1, z) == Block.lavaStill.blockID);
			boolean lavaYMinus2XMinus1 = (world.getBlockId(x - 1, y - 2, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y - 2, z) == Block.lavaStill.blockID);
			boolean lavaYPlus1XPlus1 = (world.getBlockId(x + 1, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y + 1, z) == Block.lavaStill.blockID);
			boolean lavaYPlus1XPlus2 = (world.getBlockId(x + 2, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x + 2, y + 1, z) == Block.lavaStill.blockID);
			boolean lavaYPlus2XPlus1 = (world.getBlockId(x + 1, y + 2, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y + 2, z) == Block.lavaStill.blockID);
			boolean lavaYMinus1XPlus1 = (world.getBlockId(x + 1, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y - 1, z) == Block.lavaStill.blockID);
			boolean lavaYMinus1XPlus2 = (world.getBlockId(x + 2, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x + 2, y - 1, z) == Block.lavaStill.blockID);
			boolean lavaYMinus2XPlus1 = (world.getBlockId(x + 1, y - 2, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y - 2, z) == Block.lavaStill.blockID);
			boolean lavaYPlus1XMinus1 = (world.getBlockId(x - 1, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y + 1, z) == Block.lavaStill.blockID);
			boolean lavaYPlus1XMinus2 = (world.getBlockId(x - 2, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x - 2, y + 1, z) == Block.lavaStill.blockID);
			boolean lavaYPlus2XMinus1 = (world.getBlockId(x - 1, y + 2, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y + 2, z) == Block.lavaStill.blockID);
			boolean lavaYMinus1ZMinus1 = (world.getBlockId(x, y - 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y - 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaYMinus1ZMinus2 = (world.getBlockId(x, y - 1, z - 2) == Block.lavaMoving.blockID || world.getBlockId(x, y - 1, z - 2) == Block.lavaStill.blockID);
			boolean lavaYMinus2ZMinus1 = (world.getBlockId(x, y - 2, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y - 2, z - 1) == Block.lavaStill.blockID);
			boolean lavaYPlus1ZPlus1 = (world.getBlockId(x, y + 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z + 1) == Block.lavaStill.blockID);
			boolean lavaYPlus1ZPlus2 = (world.getBlockId(x, y + 1, z + 2) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z + 2) == Block.lavaStill.blockID);
			boolean lavaYPlus2ZPlus1 = (world.getBlockId(x, y + 2, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x, y + 2, z + 1) == Block.lavaStill.blockID);
			boolean lavaYMinus1ZPlus1 = (world.getBlockId(x, y - 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x, y - 1, z + 1) == Block.lavaStill.blockID);
			boolean lavaYMinus1ZPlus2 = (world.getBlockId(x, y - 1, z + 2) == Block.lavaMoving.blockID || world.getBlockId(x, y - 1, z + 2) == Block.lavaStill.blockID);
			boolean lavaYMinus2ZPlus1 = (world.getBlockId(x, y - 2, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x, y - 2, z + 1) == Block.lavaStill.blockID);
			boolean lavaYPlus1ZMinus1 = (world.getBlockId(x, y + 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaYPlus1ZMinus2 = (world.getBlockId(x, y + 1, z - 2) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z - 2) == Block.lavaStill.blockID);
			boolean lavaYPlus2ZMinus1 = (world.getBlockId(x, y + 2, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y + 2, z - 1) == Block.lavaStill.blockID);
			boolean lavaXMinus1ZMinus1 = (world.getBlockId(x - 1, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z - 1) == Block.lavaStill.blockID);
			boolean lavaXMinus1ZMinus2 = (world.getBlockId(x - 1, y, z - 2) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z - 2) == Block.lavaStill.blockID);
			boolean lavaXMinus2ZMinus1 = (world.getBlockId(x - 2, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x - 2, y, z - 1) == Block.lavaStill.blockID);
			boolean lavaXPlus1ZPlus1 = (world.getBlockId(x + 1, y, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z + 1) == Block.lavaStill.blockID);
			boolean lavaXPlus1ZPlus2 = (world.getBlockId(x + 1, y, z + 2) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z + 2) == Block.lavaStill.blockID);
			boolean lavaXPlus2ZPlus1 = (world.getBlockId(x + 2, y, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x + 2, y, z + 1) == Block.lavaStill.blockID);
			boolean lavaXMinus1ZPlus1 = (world.getBlockId(x - 1, y, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z + 1) == Block.lavaStill.blockID);
			boolean lavaXMinus1ZPlus2 = (world.getBlockId(x - 1, y, z + 2) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z + 2) == Block.lavaStill.blockID);
			boolean lavaXMinus2ZPlus1 = (world.getBlockId(x - 2, y, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x - 2, y, z + 1) == Block.lavaStill.blockID);
			boolean lavaXPlus1ZMinus1 = (world.getBlockId(x + 1, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z - 1) == Block.lavaStill.blockID);
			boolean lavaXPlus1ZMinus2 = (world.getBlockId(x + 1, y, z - 2) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z - 2) == Block.lavaStill.blockID);
			boolean lavaXPlus2ZMinus1 = (world.getBlockId(x + 2, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x + 2, y, z - 1) == Block.lavaStill.blockID);
			boolean lavaXMinusZMinusYMinus = (world.getBlockId(x - 1, y - 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y - 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaXMinusZPlusYMinus = (world.getBlockId(x - 1, y + 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y + 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaXMinusZMinusYPlus = (world.getBlockId(x - 1, y - 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y - 1, z + 1) == Block.lavaStill.blockID);
			boolean lavaXMinusZPlusYPlus = (world.getBlockId(x - 1, y + 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y + 1, z + 1) == Block.lavaStill.blockID);
			boolean lavaXPlusZMinusYMinus = (world.getBlockId(x + 1, y - 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y - 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaXPlusZPlusYMinus = (world.getBlockId(x + 1, y + 1, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y + 1, z - 1) == Block.lavaStill.blockID);
			boolean lavaXPlusZMinusYPlus = (world.getBlockId(x + 1, y - 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y - 1, z + 1) == Block.lavaStill.blockID);
			boolean lavaXPlusZPlusYPlus = (world.getBlockId(x + 1, y + 1, z + 1) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y + 1, z + 1) == Block.lavaStill.blockID);

			if(waterYMinus1)
				world.setBlock(x, y - 1, z, Block.ice.blockID);
			if(waterYMinus2)
				world.setBlock(x, y - 2, z, Block.ice.blockID);
			if(waterYMinus3)
				world.setBlock(x, y - 3, z, Block.ice.blockID);
			if(waterYPlus1)
				world.setBlock(x, y + 1, z, Block.ice.blockID);
			if(waterYPlus2)
				world.setBlock(x, y + 2, z, Block.ice.blockID);
			if(waterYPlus3)
				world.setBlock(x, y + 3, z, Block.ice.blockID);

			if(waterXMinus1)
				world.setBlock(x - 1, y, z, Block.ice.blockID);
			if(waterXMinus2)
				world.setBlock(x - 2, y, z, Block.ice.blockID);
			if(waterXMinus3)
				world.setBlock(x - 3, y, z, Block.ice.blockID);
			if(waterXPlus1)
				world.setBlock(x + 1, y, z, Block.ice.blockID);
			if(waterXPlus2)
				world.setBlock(x + 2, y, z, Block.ice.blockID);
			if(waterXPlus3)
				world.setBlock(x + 3, y, z, Block.ice.blockID);

			if(waterZMinus1)
				world.setBlock(x, y, z - 1, Block.ice.blockID);
			if(waterZMinus2)
				world.setBlock(x, y, z - 2, Block.ice.blockID);
			if(waterZMinus3)
				world.setBlock(x, y, z - 3, Block.ice.blockID);
			if(waterZPlus1)
				world.setBlock(x, y, z + 1, Block.ice.blockID);
			if(waterZPlus2)
				world.setBlock(x, y, z + 2, Block.ice.blockID);
			if(waterZPlus3)
				world.setBlock(x, y, z + 3, Block.ice.blockID);

			if(waterYMinus1XMinus1)
				world.setBlock(x - 1, y - 1, z, Block.ice.blockID);
			if(waterYMinus1XMinus2)
				world.setBlock(x - 2, y - 1, z, Block.ice.blockID);
			if(waterYMinus2XMinus1)
				world.setBlock(x - 1, y - 2, z, Block.ice.blockID);

			if(waterYPlus1XPlus1)
				world.setBlock(x + 1, y + 1, z, Block.ice.blockID);
			if(waterYPlus1XPlus2)
				world.setBlock(x + 2, y + 1, z, Block.ice.blockID);
			if(waterYPlus2XPlus1)
				world.setBlock(x + 1, y + 2, z, Block.ice.blockID);

			if(waterYMinus1XPlus1)
				world.setBlock(x + 1, y - 1, z, Block.ice.blockID);
			if(waterYMinus1XPlus2)
				world.setBlock(x + 2, y - 1, z, Block.ice.blockID);
			if(waterYMinus2XPlus1)
				world.setBlock(x + 1, y - 2, z, Block.ice.blockID);

			if(waterYPlus1XMinus1)
				world.setBlock(x - 1, y + 1, z, Block.ice.blockID);
			if(waterYPlus1XMinus2)
				world.setBlock(x - 2, y + 1, z, Block.ice.blockID);
			if(waterYPlus2XMinus1)
				world.setBlock(x - 1, y + 2, z, Block.ice.blockID);

			if(waterYMinus1ZMinus1)
				world.setBlock(x, y - 1, z - 1, Block.ice.blockID);
			if(waterYMinus1ZMinus2)
				world.setBlock(x, y - 1, z - 2, Block.ice.blockID);
			if(waterYMinus2ZMinus1)
				world.setBlock(x, y - 2, z - 1, Block.ice.blockID);

			if(waterYPlus1ZPlus1)
				world.setBlock(x, y + 1, z + 1, Block.ice.blockID);
			if(waterYPlus1ZPlus2)
				world.setBlock(x, y + 1, z + 2, Block.ice.blockID);
			if(waterYPlus2ZPlus1)
				world.setBlock(x, y + 2, z + 1, Block.ice.blockID);

			if(waterYMinus1ZPlus1)
				world.setBlock(x, y - 1, z + 1, Block.ice.blockID);
			if(waterYMinus1ZPlus2)
				world.setBlock(x, y - 1, z + 2, Block.ice.blockID);
			if(waterYMinus2ZPlus1)
				world.setBlock(x, y - 2, z + 1, Block.ice.blockID);

			if(waterYPlus1ZMinus1)
				world.setBlock(x, y + 1, z - 1, Block.ice.blockID);
			if(waterYPlus1ZMinus2)
				world.setBlock(x, y + 1, z - 2, Block.ice.blockID);
			if(waterYPlus2ZMinus1)
				world.setBlock(x, y + 2, z - 1, Block.ice.blockID);

			if(waterXMinus1ZMinus1)
				world.setBlock(x - 1, y, z - 1, Block.ice.blockID);
			if(waterXMinus1ZMinus2)
				world.setBlock(x - 1, y, z - 2, Block.ice.blockID);
			if(waterXMinus2ZMinus1)
				world.setBlock(x - 2, y, z - 1, Block.ice.blockID);

			if(waterXPlus1ZPlus1)
				world.setBlock(x + 1, y, z + 1, Block.ice.blockID);
			if(waterXPlus1ZPlus2)
				world.setBlock(x + 1, y, z + 2, Block.ice.blockID);
			if(waterXPlus2ZPlus1)
				world.setBlock(x + 2, y, z + 1, Block.ice.blockID);

			if(waterXMinus1ZPlus1)
				world.setBlock(x - 1, y, z + 1, Block.ice.blockID);
			if(waterXMinus1ZPlus2)
				world.setBlock(x - 1, y, z + 2, Block.ice.blockID);
			if(waterXMinus2ZPlus1)
				world.setBlock(x - 2, y, z + 1, Block.ice.blockID);

			if(waterXPlus1ZMinus1)
				world.setBlock(x + 1, y, z - 1, Block.ice.blockID);
			if(waterXPlus1ZMinus2)
				world.setBlock(x + 1, y, z - 2, Block.ice.blockID);
			if(waterXPlus2ZMinus1)
				world.setBlock(x + 2, y, z - 1, Block.ice.blockID);

			if(waterXMinusZMinusYMinus)
				world.setBlock(x - 1, y - 1, z - 1, Block.ice.blockID);
			if(waterXMinusZPlusYMinus)
				world.setBlock(x - 1, y + 1, z - 1, Block.ice.blockID);
			if(waterXMinusZMinusYPlus)
				world.setBlock(x - 1, y - 1, z + 1, Block.ice.blockID);
			if(waterXMinusZPlusYPlus)
				world.setBlock(x - 1, y + 1, z + 1, Block.ice.blockID);
			if(waterXPlusZMinusYMinus)
				world.setBlock(x + 1, y - 1, z - 1, Block.ice.blockID);
			if(waterXPlusZPlusYMinus)
				world.setBlock(x + 1, y + 1, z - 1, Block.ice.blockID);
			if(waterXPlusZMinusYPlus)
				world.setBlock(x + 1, y - 1, z + 1, Block.ice.blockID);
			if(waterXPlusZPlusYPlus)
				world.setBlock(x + 1, y + 1, z + 1, Block.ice.blockID);

			if(lavaYMinus1)
				world.setBlock(x, y - 1, z, Block.obsidian.blockID);
			if(lavaYMinus2)
				world.setBlock(x, y - 2, z, Block.obsidian.blockID);
			if(lavaYMinus3)
				world.setBlock(x, y - 3, z, Block.obsidian.blockID);
			if(lavaYPlus1)
				world.setBlock(x, y + 1, z, Block.obsidian.blockID);
			if(lavaYPlus2)
				world.setBlock(x, y + 2, z, Block.obsidian.blockID);
			if(lavaYPlus3)
				world.setBlock(x, y + 3, z, Block.obsidian.blockID);

			if(lavaXMinus1)
				world.setBlock(x - 1, y, z, Block.obsidian.blockID);
			if(lavaXMinus2)
				world.setBlock(x - 2, y, z, Block.obsidian.blockID);
			if(lavaXMinus3)
				world.setBlock(x - 3, y, z, Block.obsidian.blockID);
			if(lavaXPlus1)
				world.setBlock(x + 1, y, z, Block.obsidian.blockID);
			if(lavaXPlus2)
				world.setBlock(x + 2, y, z, Block.obsidian.blockID);
			if(lavaXPlus3)
				world.setBlock(x + 3, y, z, Block.obsidian.blockID);

			if(lavaZMinus1)
				world.setBlock(x, y, z - 1, Block.obsidian.blockID);
			if(lavaZMinus2)
				world.setBlock(x, y, z - 2, Block.obsidian.blockID);
			if(lavaZMinus3)
				world.setBlock(x, y, z - 3, Block.obsidian.blockID);
			if(lavaZPlus1)
				world.setBlock(x, y, z + 1, Block.obsidian.blockID);
			if(lavaZPlus2)
				world.setBlock(x, y, z + 2, Block.obsidian.blockID);
			if(lavaZPlus3)
				world.setBlock(x, y, z + 3, Block.obsidian.blockID);

			if(lavaYMinus1XMinus1)
				world.setBlock(x - 1, y - 1, z, Block.obsidian.blockID);
			if(lavaYMinus1XMinus2)
				world.setBlock(x - 2, y - 1, z, Block.obsidian.blockID);
			if(lavaYMinus2XMinus1)
				world.setBlock(x - 1, y - 2, z, Block.obsidian.blockID);

			if(lavaYPlus1XPlus1)
				world.setBlock(x + 1, y + 1, z, Block.obsidian.blockID);
			if(lavaYPlus1XPlus2)
				world.setBlock(x + 2, y + 1, z, Block.obsidian.blockID);
			if(lavaYPlus2XPlus1)
				world.setBlock(x + 1, y + 2, z, Block.obsidian.blockID);

			if(lavaYMinus1XPlus1)
				world.setBlock(x + 1, y - 1, z, Block.obsidian.blockID);
			if(lavaYMinus1XPlus2)
				world.setBlock(x + 2, y - 1, z, Block.obsidian.blockID);
			if(lavaYMinus2XPlus1)
				world.setBlock(x + 1, y - 2, z, Block.obsidian.blockID);

			if(lavaYPlus1XMinus1)
				world.setBlock(x - 1, y + 1, z, Block.obsidian.blockID);
			if(lavaYPlus1XMinus2)
				world.setBlock(x - 2, y + 1, z, Block.obsidian.blockID);
			if(lavaYPlus2XMinus1)
				world.setBlock(x - 1, y + 2, z, Block.obsidian.blockID);

			if(lavaYMinus1ZMinus1)
				world.setBlock(x, y - 1, z - 1, Block.obsidian.blockID);
			if(lavaYMinus1ZMinus2)
				world.setBlock(x, y - 1, z - 2, Block.obsidian.blockID);
			if(lavaYMinus2ZMinus1)
				world.setBlock(x, y - 2, z - 1, Block.obsidian.blockID);

			if(lavaYPlus1ZPlus1)
				world.setBlock(x, y + 1, z + 1, Block.obsidian.blockID);
			if(lavaYPlus1ZPlus2)
				world.setBlock(x, y + 1, z + 2, Block.obsidian.blockID);
			if(lavaYPlus2ZPlus1)
				world.setBlock(x, y + 2, z + 1, Block.obsidian.blockID);

			if(lavaYMinus1ZPlus1)
				world.setBlock(x, y - 1, z + 1, Block.obsidian.blockID);
			if(lavaYMinus1ZPlus2)
				world.setBlock(x, y - 1, z + 2, Block.obsidian.blockID);
			if(lavaYMinus2ZPlus1)
				world.setBlock(x, y - 2, z + 1, Block.obsidian.blockID);

			if(lavaYPlus1ZMinus1)
				world.setBlock(x, y + 1, z - 1, Block.obsidian.blockID);
			if(lavaYPlus1ZMinus2)
				world.setBlock(x, y + 1, z - 2, Block.obsidian.blockID);
			if(lavaYPlus2ZMinus1)
				world.setBlock(x, y + 2, z - 1, Block.obsidian.blockID);

			if(lavaXMinus1ZMinus1)
				world.setBlock(x - 1, y, z - 1, Block.obsidian.blockID);
			if(lavaXMinus1ZMinus2)
				world.setBlock(x - 1, y, z - 2, Block.obsidian.blockID);
			if(lavaXMinus2ZMinus1)
				world.setBlock(x - 2, y, z - 1, Block.obsidian.blockID);

			if(lavaXPlus1ZPlus1)
				world.setBlock(x + 1, y, z + 1, Block.obsidian.blockID);
			if(lavaXPlus1ZPlus2)
				world.setBlock(x + 1, y, z + 2, Block.obsidian.blockID);
			if(lavaXPlus2ZPlus1)
				world.setBlock(x + 2, y, z + 1, Block.obsidian.blockID);

			if(lavaXMinus1ZPlus1)
				world.setBlock(x - 1, y, z + 1, Block.obsidian.blockID);
			if(lavaXMinus1ZPlus2)
				world.setBlock(x - 1, y, z + 2, Block.obsidian.blockID);
			if(lavaXMinus2ZPlus1)
				world.setBlock(x - 2, y, z + 1, Block.obsidian.blockID);

			if(lavaXPlus1ZMinus1)
				world.setBlock(x + 1, y, z - 1, Block.obsidian.blockID);
			if(lavaXPlus1ZMinus2)
				world.setBlock(x + 1, y, z - 2, Block.obsidian.blockID);
			if(lavaXPlus2ZMinus1)
				world.setBlock(x + 2, y, z - 1, Block.obsidian.blockID);

			if(lavaXMinusZMinusYMinus)
				world.setBlock(x - 1, y - 1, z - 1, Block.obsidian.blockID);
			if(lavaXMinusZPlusYMinus)
				world.setBlock(x - 1, y + 1, z - 1, Block.obsidian.blockID);
			if(lavaXMinusZMinusYPlus)
				world.setBlock(x - 1, y - 1, z + 1, Block.obsidian.blockID);
			if(lavaXMinusZPlusYPlus)
				world.setBlock(x - 1, y + 1, z + 1, Block.obsidian.blockID);
			if(lavaXPlusZMinusYMinus)
				world.setBlock(x + 1, y - 1, z - 1, Block.obsidian.blockID);
			if(lavaXPlusZPlusYMinus)
				world.setBlock(x + 1, y + 1, z - 1, Block.obsidian.blockID);
			if(lavaXPlusZMinusYPlus)
				world.setBlock(x + 1, y - 1, z + 1, Block.obsidian.blockID);
			if(lavaXPlusZPlusYPlus)
				world.setBlock(x + 1, y + 1, z + 1, Block.obsidian.blockID);

		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		this.checkUpdate(world, x, y, z);
		super.onNeighborBlockChange(world, x, y, z, blockid);
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
			if(world.provider.isHellWorld)
			{
				world.setBlockToAir(x, y, z);
			}
			else
			{
				this.checkUpdate(world, x, y, z);
				super.onBlockAdded(world, x, y, z);
			}
		
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		this.checkUpdate(world, x, y, z);
		super.updateTick(world, x, y, z, rand);
	}
}