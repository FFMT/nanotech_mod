package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockPortalFrame extends Block
{
	public BlockPortalFrame(int id, Material material)
	{
		super(id, material);
		this.setTickRandomly(true);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:" + getUnlocalizedName2());
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.checkDoCreatePortal(world, x, y, z);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		super.onNeighborBlockChange(world, x, y, z, blockid);
		this.checkDoCreatePortal(world, x, y, z);
	}

	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkDoCreatePortal(world, x, y, z);
	}

	public int tickRate(World world)
	{
		return 120;
	}

	public void checkDoCreatePortal(World world, int x, int y, int z)
	{
		if(world.getBlockId(x - 1, y, z) == this.blockID && world.getBlockId(x - 1, y, z + 3) == this.blockID && world.getBlockId(x, y, z + 3) == this.blockID && world.getBlockId(x + 1, y, z + 1) == this.blockID && world.getBlockId(x + 1, y, z + 2) == this.blockID && world.getBlockId(x - 2, y, z + 1) == this.blockID && world.getBlockId(x - 2, y, z + 2) == this.blockID)
		{
			for(int i = 1; i < 3; i++)
			{
				if(world.isAirBlock(x, y, z + i))
				{
					world.setBlock(x, y, z + i, NanotechBlock.BlockPortal.blockID);
				}
				if(world.isAirBlock(x - 1, y, z + i))
				{
					world.setBlock(x - 1, y, z + i, NanotechBlock.BlockPortal.blockID);
				}
			}
		}
	}

}
