package fr.mcnanotech.kevin_68.nanotech_mod.world;

import java.util.Random;

import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class World_model7 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[]{Block.stone.blockID, Block.dirt.blockID, NanotechBlock.BlockGrass.blockID};
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

	public World_model7()
	{}

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 10, j, k) || !LocationIsValidSpawn(world, i + 10, j, k + 12) || !LocationIsValidSpawn(world, i, j, k + 12))
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
		world.setBlock(i + 0, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 0, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 9, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 10, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 1, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 9, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 10, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 11, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 7, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 10, Block.wood.blockID);
		world.setBlock(i + 1, j + 2, k + 11, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 3, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 9, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 10, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 1, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 1, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 1, j + 4, k + 8, Block.planks.blockID);
		world.setBlock(i + 1, j + 4, k + 9, Block.planks.blockID);
		world.setBlock(i + 1, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 1, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 1, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 1, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 1, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 1, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 2, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 9, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 10, Block.planks.blockID);
		world.setBlock(i + 2, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 1, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 1, k + 7, Block.planks.blockID);
		world.setBlock(i + 2, j + 1, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 2, k + 6, Block.planks.blockID);
		world.setBlock(i + 2, j + 3, k + 5, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 2, j + 3, k + 6, Block.planks.blockID);
		world.setBlock(i + 2, j + 3, k + 11, Block.planks.blockID);
		world.setBlock(i + 2, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 2, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 2, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 2, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 2, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 2, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 2, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 2, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 3, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 8, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 9, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 10, Block.planks.blockID);
		world.setBlock(i + 3, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 1, k + 7, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 3, j + 3, k + 11, Block.planks.blockID);
		world.setBlock(i + 3, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 3, j + 4, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 4, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 4, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 4, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 3, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 3, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 3, j + 5, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 5, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 5, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 5, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 3, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 3, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 3, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 3, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 4, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 8, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 9, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 10, Block.planks.blockID);
		world.setBlock(i + 4, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 4, j + 4, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 4, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 4, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 4, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 4, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 4, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 4, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 4, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 4, j + 5, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 5, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 5, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 5, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 5, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 4, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 4, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 4, j + 6, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 6, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 6, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 4, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 4, j + 7, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.dirt.blockID);
		world.setBlock(i + 5, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 8, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 9, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 10, Block.planks.blockID);
		world.setBlock(i + 5, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 1, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 1, k + 11, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 2, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 3, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 5, j + 4, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 4, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 4, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 4, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 4, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 5, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 5, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 5, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 5, j + 5, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 5, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 5, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 5, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 5, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 5, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 5, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 5, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 5, j + 6, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 6, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 6, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 5, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 5, j + 7, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 7, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 7, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 6, j + 0, k + 8, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 6, j + 0, k + 9, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 6, j + 0, k + 10, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 6, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 1, k + 11, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 3, k + 11, Block.planks.blockID);
		world.setBlock(i + 6, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 6, j + 4, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 4, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 4, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 4, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 4, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 6, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 6, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 6, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 6, j + 5, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 5, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 5, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 5, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 5, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 6, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 6, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 6, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 6, j + 6, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 6, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 6, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 6, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 6, j + 7, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 7, j + 0, k + 8, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 7, j + 0, k + 9, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 7, j + 0, k + 10, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 7, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 1, k + 9, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 7, j + 1, k + 10, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 7, j + 1, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 2, k + 11, Block.planks.blockID);
		world.setBlock(i + 7, j + 3, k + 11, Block.planks.blockID);
		world.setBlock(i + 7, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 7, j + 4, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 4, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 4, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 4, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 4, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 7, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 7, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 7, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 7, j + 5, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 5, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 5, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 7, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 7, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 7, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 7, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 7, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 8, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 8, j + 0, k + 7, Block.planks.blockID);
		world.setBlock(i + 8, j + 0, k + 8, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 8, j + 0, k + 9, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 8, j + 0, k + 10, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 8, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 8, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 1, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 8, j + 2, k + 11, Block.planks.blockID);
		world.setBlock(i + 8, j + 3, k + 11, Block.planks.blockID);
		world.setBlock(i + 8, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 8, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 8, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 8, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 8, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 8, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 8, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 8, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 8, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 8, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 8, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 9, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 0, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 0, k + 9, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 0, k + 10, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 0, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 1, k + 1, Block.fence.blockID);
		world.setBlock(i + 9, j + 1, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 1, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 1, k + 8, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 1, k + 9, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 1, k + 10, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 1, k + 11, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 2, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 2, k + 7, Block.wood.blockID);
		world.setBlock(i + 9, j + 2, k + 10, Block.wood.blockID);
		world.setBlock(i + 9, j + 2, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 3, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 3, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 3, k + 8, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 3, k + 9, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 9, j + 3, k + 10, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 3, k + 11, Block.cobblestone.blockID);
		world.setBlock(i + 9, j + 3, k + 12, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 9, j + 4, k + 6, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 9, j + 4, k + 7, Block.planks.blockID);
		world.setBlock(i + 9, j + 4, k + 8, Block.planks.blockID);
		world.setBlock(i + 9, j + 4, k + 9, Block.planks.blockID);
		world.setBlock(i + 9, j + 4, k + 10, Block.planks.blockID);
		world.setBlock(i + 9, j + 4, k + 11, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 9, j + 5, k + 7, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 9, j + 5, k + 8, Block.planks.blockID);
		world.setBlock(i + 9, j + 5, k + 9, Block.planks.blockID);
		world.setBlock(i + 9, j + 5, k + 10, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 9, j + 6, k + 8, Block.stairsWoodOak.blockID, 2, 3);
		world.setBlock(i + 9, j + 6, k + 9, Block.stairsWoodOak.blockID, 3, 3);
		world.setBlock(i + 10, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 12, NanotechBlock.BlockGrass.blockID);
		world.setBlockMetadataWithNotify(i + 3, j + 3, k + 10, Block.torchWood.blockID, 4);

		return true;
	}
}