package fr.mcnanotech.kevin_68.nanotech_mod.world;

import java.util.Random;

import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class World_model3 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[] { Block.stone.blockID, Block.dirt.blockID, NanotechBlock.BlockGrass.blockID };
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0)
		{
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3)
		{
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for (int x : GetValidSpawnBlocks())
		{
			if (blockIDAbove != 0)
			{
				return false;
			}
			if (blockID == x)
			{
				return true;
			}
			else if (blockID == Block.snow.blockID && blockIDBelow == x)
			{
				return true;
			}
		}
		return false;
	}

	public World_model3()
	{}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 11, j, k) || !LocationIsValidSpawn(world, i + 11, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
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
		world.setBlock(i + 0, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 3, k + 0, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 1, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 2, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 5, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 6, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 7, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 8, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Block.planks.blockID);
		world.setBlock(i + 1, j + 2, k + 3, Block.planks.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 2, k + 6, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 7, Block.planks.blockID);
		world.setBlock(i + 1, j + 2, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 1, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 2, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 3, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 4, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 5, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 6, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 7, Block.planks.blockID);
		world.setBlock(i + 1, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 1, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 5, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 6, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 7, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 8, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 2, j + 1, k + 1, Block.tripWireSource.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 2, Block.tripWire.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 3, Block.tripWire.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 4, Block.tripWire.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 5, Block.tripWire.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 6, Block.tripWire.blockID, 4);
		world.setBlockAndMetadata(i + 2, j + 1, k + 7, Block.tripWireSource.blockID, 6);
		world.setBlock(i + 2, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 2, k + 0, Block.wood.blockID);
		world.setBlock(i + 2, j + 2, k + 8, Block.wood.blockID);
		world.setBlock(i + 2, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 6, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 2, j + 4, k + 8, Block.planks.blockID);
		world.setBlock(i + 2, j + 5, k + 0, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 2, j + 5, k + 1, Block.stairCompactPlanks.blockID);
		world.setBlockAndMetadata(i + 2, j + 5, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 2, j + 5, k + 4, Block.planks.blockID, 1);
		world.setBlock(i + 2, j + 5, k + 5, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 2, j + 5, k + 6, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 2, j + 5, k + 7, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 2, j + 5, k + 8, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 1, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 2, k + 8, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 0, Block.planks.blockID);
		world.setBlock(i + 3, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 3, j + 4, k + 8, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 0, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 1, Block.planks.blockID);
		world.setBlockAndMetadata(i + 3, j + 5, k + 2, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 3, j + 5, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 3, j + 5, k + 4, Block.planks.blockID, 1);
		world.setBlock(i + 3, j + 5, k + 5, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 6, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 7, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 3, j + 6, k + 0, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 6, k + 1, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 6, k + 5, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 6, k + 6, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 6, k + 7, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 3, j + 6, k + 8, Block.stairCompactPlanks.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 4, j + 1, k + 3, Block.wood.blockID, 1);
		world.setBlock(i + 4, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlockAndMetadata(i + 4, j + 2, k + 3, Block.wood.blockID, 1);
		world.setBlock(i + 4, j + 2, k + 8, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 4, j + 3, k + 3, Block.wood.blockID, 1);
		world.setBlock(i + 4, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 4, k + 0, Block.planks.blockID);
		world.setBlockAndMetadata(i + 4, j + 4, k + 3, Block.wood.blockID, 1);
		world.setBlock(i + 4, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 4, j + 4, k + 8, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 0, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 1, Block.planks.blockID);
		world.setBlockAndMetadata(i + 4, j + 5, k + 2, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 5, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 5, k + 4, Block.planks.blockID, 1);
		world.setBlock(i + 4, j + 5, k + 5, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 6, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 7, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 8, Block.planks.blockID);
		world.setBlockAndMetadata(i + 4, j + 6, k + 0, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 6, k + 1, Block.stairCompactPlanks.blockID, 1);
		world.setBlock(i + 4, j + 6, k + 5, Block.planks.blockID);
		world.setBlock(i + 4, j + 6, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 4, j + 6, k + 7, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 6, k + 8, Block.stairCompactPlanks.blockID, 1);
		world.setBlock(i + 5, j + 0, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 5, j + 1, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 1, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 1, k + 7, Block.pistonBase.blockID, 5);
		world.setBlock(i + 5, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 2, k + 0, Block.wood.blockID);
		world.setBlockAndMetadata(i + 5, j + 2, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 2, k + 7, Block.planks.blockID, 1);
		world.setBlock(i + 5, j + 2, k + 8, Block.wood.blockID);
		world.setBlock(i + 5, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 4, k + 0, Block.planks.blockID);
		world.setBlock(i + 5, j + 4, k + 1, Block.planks.blockID);
		world.setBlock(i + 5, j + 4, k + 2, Block.planks.blockID);
		world.setBlock(i + 5, j + 4, k + 8, Block.planks.blockID);
		world.setBlockAndMetadata(i + 5, j + 5, k + 0, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 5, k + 1, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 5, k + 2, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 5, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 5, k + 4, Block.planks.blockID, 1);
		world.setBlock(i + 5, j + 5, k + 6, Block.planks.blockID);
		world.setBlock(i + 5, j + 5, k + 7, Block.planks.blockID);
		world.setBlockAndMetadata(i + 5, j + 5, k + 8, Block.stairCompactPlanks.blockID, 1);
		world.setBlock(i + 5, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 5, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 6, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 6, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 6, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 6, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 1, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 1, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 6, j + 1, k + 7, Block.planks.blockID, 1);
		world.setBlock(i + 6, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 2, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 2, k + 1, Block.planks.blockID);
		world.setBlock(i + 6, j + 2, k + 2, Block.planks.blockID);
		world.setBlockAndMetadata(i + 6, j + 2, k + 6, Block.planks.blockID, 1);
		world.setBlock(i + 6, j + 2, k + 8, Block.planks.blockID);
		world.setBlock(i + 6, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 3, k + 1, Block.planks.blockID);
		world.setBlock(i + 6, j + 3, k + 2, Block.planks.blockID);
		world.setBlock(i + 6, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 6, j + 4, k + 0, Block.stairCompactPlanks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 4, k + 1, Block.stairCompactPlanks.blockID, 1);
		world.setBlock(i + 6, j + 4, k + 2, Block.planks.blockID);
		world.setBlock(i + 6, j + 4, k + 3, Block.planks.blockID);
		world.setBlockAndMetadata(i + 6, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 6, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 6, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 6, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 6, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 6, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 6, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 6, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 7, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 7, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 7, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 7, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 7, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 7, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlockAndMetadata(i + 7, j + 1, k + 6, Block.planks.blockID, 1);
		world.setBlock(i + 7, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 7, j + 2, k + 2, Block.wood.blockID);
		world.setBlockAndMetadata(i + 7, j + 2, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 2, k + 7, Block.planks.blockID, 1);
		world.setBlock(i + 7, j + 2, k + 8, Block.wood.blockID);
		world.setBlockAndMetadata(i + 7, j + 3, k + 0, Block.stairCompactPlanks.blockID, 1);
		world.setBlock(i + 7, j + 3, k + 1, Block.planks.blockID);
		world.setBlock(i + 7, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 7, j + 4, k + 2, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 7, j + 4, k + 3, Block.planks.blockID);
		world.setBlockAndMetadata(i + 7, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 7, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 7, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 7, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 7, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 7, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 7, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 7, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 8, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 8, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 8, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 8, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 8, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 8, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 8, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 8, j + 1, k + 7, Block.tnt.blockID);
		world.setBlock(i + 8, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 8, j + 2, k + 2, Block.fenceIron.blockID);
		world.setBlockAndMetadata(i + 8, j + 2, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 2, k + 7, Block.planks.blockID, 1);
		world.setBlock(i + 8, j + 2, k + 8, Block.fenceIron.blockID);
		world.setBlockAndMetadata(i + 8, j + 3, k + 1, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 8, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 8, j + 3, k + 6, Block.bed.blockID);
		world.setBlockAndMetadata(i + 8, j + 3, k + 7, Block.bed.blockID, 8);
		world.setBlock(i + 8, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 8, j + 4, k + 2, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 8, j + 4, k + 3, Block.planks.blockID);
		world.setBlockAndMetadata(i + 8, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 8, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 8, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 8, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 8, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 8, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 8, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 8, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 9, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 9, j + 0, k + 4, NanotechBlock.BlockSodium.blockID);
		world.setBlock(i + 9, j + 0, k + 6, NanotechBlock.BlockSodium.blockID);
		world.setBlock(i + 9, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 9, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 1, k + 6, Block.tnt.blockID);
		world.setBlock(i + 9, j + 1, k + 7, Block.tnt.blockID);
		world.setBlock(i + 9, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 2, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 9, j + 2, k + 6, Block.tnt.blockID);
		world.setBlock(i + 9, j + 2, k + 8, Block.fenceIron.blockID);
		world.setBlockAndMetadata(i + 9, j + 3, k + 1, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 9, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 9, j + 4, k + 2, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 9, j + 4, k + 3, Block.planks.blockID);
		world.setBlock(i + 9, j + 4, k + 7, Block.planks.blockID);
		world.setBlockAndMetadata(i + 9, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 9, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 9, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 9, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 9, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 9, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 9, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 9, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 10, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 10, j + 0, k + 3, Block.planks.blockID);
		world.setBlock(i + 10, j + 0, k + 4, Block.planks.blockID);
		world.setBlock(i + 10, j + 0, k + 5, NanotechBlock.BlockSodium.blockID);
		world.setBlock(i + 10, j + 0, k + 6, Block.planks.blockID);
		world.setBlock(i + 10, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 10, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 10, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 10, j + 1, k + 3, Block.tnt.blockID);
		world.setBlock(i + 10, j + 1, k + 4, Block.tnt.blockID);
		world.setBlock(i + 10, j + 1, k + 5, Block.tnt.blockID);
		world.setBlock(i + 10, j + 1, k + 6, Block.tnt.blockID);
		world.setBlock(i + 10, j + 1, k + 7, Block.tnt.blockID);
		world.setBlock(i + 10, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 10, j + 2, k + 2, Block.wood.blockID);
		world.setBlock(i + 10, j + 2, k + 5, Block.tnt.blockID);
		world.setBlock(i + 10, j + 2, k + 6, Block.tnt.blockID);
		world.setBlock(i + 10, j + 2, k + 7, Block.tnt.blockID);
		world.setBlock(i + 10, j + 2, k + 8, Block.wood.blockID);
		world.setBlockAndMetadata(i + 10, j + 3, k + 1, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 10, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 10, j + 3, k + 6, Block.tnt.blockID);
		world.setBlock(i + 10, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 10, j + 4, k + 2, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 10, j + 4, k + 3, Block.planks.blockID);
		world.setBlock(i + 10, j + 4, k + 7, Block.planks.blockID);
		world.setBlockAndMetadata(i + 10, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 10, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 10, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 10, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 10, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 10, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 10, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 10, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlock(i + 11, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 0, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 0, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 1, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 1, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 1, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 1, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 1, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 2, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 2, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 2, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 2, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 2, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 2, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 2, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 11, j + 3, k + 1, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 11, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 3, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 3, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 3, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 11, j + 3, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 3, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 11, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlockAndMetadata(i + 11, j + 4, k + 2, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 11, j + 4, k + 3, Block.planks.blockID);
		world.setBlock(i + 11, j + 4, k + 4, Block.wood.blockID);
		world.setBlock(i + 11, j + 4, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 11, j + 4, k + 6, Block.wood.blockID);
		world.setBlock(i + 11, j + 4, k + 7, Block.planks.blockID);
		world.setBlockAndMetadata(i + 11, j + 4, k + 8, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 11, j + 5, k + 3, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 11, j + 5, k + 4, Block.planks.blockID);
		world.setBlock(i + 11, j + 5, k + 5, Block.planks.blockID);
		world.setBlock(i + 11, j + 5, k + 6, Block.planks.blockID);
		world.setBlockAndMetadata(i + 11, j + 5, k + 7, Block.stairCompactPlanks.blockID, 3);
		world.setBlockAndMetadata(i + 11, j + 6, k + 4, Block.stairCompactPlanks.blockID, 2);
		world.setBlock(i + 11, j + 6, k + 5, Block.planks.blockID);
		world.setBlockAndMetadata(i + 11, j + 6, k + 6, Block.stairCompactPlanks.blockID, 3);
		world.setBlockWithNotify(i + 1, j + 1, k + 2, Block.doorSteel.blockID);
		world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 2, Block.doorSteel.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 2, Block.torchWood.blockID, 1);
		world.setBlockWithNotify(i + 3, j + 1, k + 7, Block.redstoneWire.blockID);
		world.setBlockWithNotify(i + 4, j + 1, k + 7, Block.redstoneWire.blockID);
		world.setBlockWithNotify(i + 6, j + 2, k + 7, Block.waterStill.blockID);
		world.setBlockAndMetadataWithNotify(i + 7, j + 3, k + 7, Block.torchWood.blockID, 5);

		return true;
	}
}