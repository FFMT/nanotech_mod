package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class WorldModel2 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[] {Block.stone.blockID, Block.dirt.blockID, NanotechBlock.BlockGrass.blockID};
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
			}
			else if(blockID == Block.snow.blockID && blockIDBelow == x)
			{
				return true;
			}
		}
		return false;
	}

	public WorldModel2()
	{}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		// check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 4, j, k) || !LocationIsValidSpawn(world, i + 4, j, k + 9) || !LocationIsValidSpawn(world, i, j, k + 9))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 0, k + 5, Block.dirt.blockID);
		world.setBlock(i + 0, j + 0, k + 6, Block.dirt.blockID);
		world.setBlock(i + 0, j + 0, k + 7, Block.dirt.blockID);
		world.setBlock(i + 0, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 1, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 1, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 2, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 3, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 3, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 4, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 4, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 5, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 5, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 5, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 6, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 6, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 7, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 7, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 8, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 8, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 8, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 9, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 9, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 9, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 9, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 9, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 10, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 10, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 10, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 10, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 11, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 1, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Block.stairsCobblestone.blockID, 1, 3);
		world.setBlock(i + 1, j + 2, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 5, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 5, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 5, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 5, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 6, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 6, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 7, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 7, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 8, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 8, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 9, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 9, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 9, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 9, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 9, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 10, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 10, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 1, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 1, k + 2, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 2, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 5, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 5, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 5, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 5, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 8, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 8, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 9, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 9, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 10, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 11, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 2, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 3, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 4, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 5, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 5, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 5, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 6, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 7, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 8, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 9, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 10, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.dirt.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.dirt.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.dirt.blockID);
		world.setBlock(i + 4, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 1, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 1, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 3, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 3, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 3, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 3, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 4, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 5, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 5, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 5, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 6, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 6, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 7, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 8, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 8, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 9, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 9, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 9, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 10, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Block.torchWood.blockID, 1, 3);
		world.setBlock(i + 2, j + 4, k + 1, Block.torchWood.blockID, 3, 3);
		world.setBlock(i + 2, j + 4, k + 3, Block.torchWood.blockID, 4, 3);
		world.setBlock(i + 3, j + 1, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 2, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 3, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 4, k + 2, Block.torchWood.blockID, 2, 3);
		world.setBlock(i + 3, j + 4, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 5, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 6, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 7, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 8, k + 5, Block.ladder.blockID, 4, 3);
		world.setBlock(i + 3, j + 9, k + 5, Block.ladder.blockID, 4, 3);

		return true;
	}
}