package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class WorldModel6 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[]
		{Block.stone.blockID, Block.dirt.blockID, NanotechBlock.BlockGrass.blockID};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while(checkID != 0)
		{
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if(distanceToAir > 3)
		{
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for(int x : GetValidSpawnBlocks())
		{
			if(blockIDAbove != 0)
			{
				return false;
			}
			if(blockID == x)
			{
				return true;
			} else if(blockID == Block.snow.blockID && blockIDBelow == x)
			{
				return true;
			}
		}
		return false;
	}

	public WorldModel6()
	{}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		// check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 6) || !LocationIsValidSpawn(world, i, j, k + 6))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 1, k + 1, Block.wood.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.planks.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.planks.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.planks.blockID);
		world.setBlock(i + 1, j + 1, k + 5, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 2, Block.planks.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Block.planks.blockID);
		world.setBlock(i + 1, j + 2, k + 5, Block.wood.blockID);
		world.setBlock(i + 2, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 1, k + 1, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 1, k + 5, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 1, k + 5, Block.wood.blockID);
		world.setBlock(i + 4, j + 2, k + 5, Block.wood.blockID);
		world.setBlock(i + 5, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);

		return true;
	}
}