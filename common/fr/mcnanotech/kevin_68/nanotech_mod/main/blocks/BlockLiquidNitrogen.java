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
			for(int x1 = -3; x1 < 4; x1++)
			{
				for(int y1 = -3; y1 < 4; y1++)
				{
					for(int z1 = -3; z1 < 4; z1++)
					{
						boolean dofreeze = true;
						if((x1 == -3 && z1 == -3) || (x1 == 3 && z1 == 3) || (x1 == -2 && z1 == -3) || (x1 == -2 && z1 == -3) || (x1 == 2 && z1 == 3) || (x1 == 3 && z1 == 2) || (x1 == -3 && y1 == -3) || (x1 == 3 && y1 == -3) || (x1 == -3 && y1 == 3) || (x1 == 3 && y1 == 3) || (z1 == -3 && y1 == -3) || (z1 == 3 && y1 == -3) || (z1 == -3 && y1 == 3) || (z1 == 3 && y1 == 3))
						{
							dofreeze = false;
						}
						if(dofreeze)
						{
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.fire.blockID)
								world.setBlockToAir(x + x1, y + y1, z + z1);
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.lavaStill.blockID)
								world.setBlock(x + x1, y + y1, z + z1, Block.obsidian.blockID);
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.lavaMoving.blockID)
							{
								if(world.getBlockMetadata(x + x1, y + y1, z + z1) == 0)
									world.setBlock(x + x1, y + y1, z + z1, Block.obsidian.blockID);
								else
									world.setBlock(x + x1, y + y1, z + z1, Block.cobblestone.blockID);
							}
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.waterMoving.blockID || world.getBlockId(x, y + y1, z) == Block.waterStill.blockID)
								world.setBlock(x + x1, y + y1, z + z1, Block.ice.blockID);
						}
					}
				}
			}
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