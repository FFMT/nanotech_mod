package fr.mcnanotech.kevin_68.nanotech_mod.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class World_model1 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.stone.blockID,
			Block.dirt.blockID,
			NanotechBlock.BlockGrass.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public World_model1() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 11, j, k) || !LocationIsValidSpawn(world, i + 11, j, k + 11) || !LocationIsValidSpawn(world, i, j, k + 11))
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
		world.setBlock(i + 1, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 1, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 2, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 3, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 3, j + 1, k + 6, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 3, j + 1, k + 7, Block.woodSingleSlab.blockID, 1);
		world.setBlock(i + 4, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 4, j + 0, k + 6, Block.planks.blockID, 1);
		world.setBlock(i + 4, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 4, j + 0, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 4, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 4, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 4, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 4, j + 1, k + 5, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 1, k + 7, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 4, j + 1, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 5, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 5, j + 0, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 0, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 0, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 5, j + 0, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 5, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 5, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 5, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 5, j + 1, k + 4, Block.woodSingleSlab.blockID, 1);
		world.setBlock(i + 5, j + 1, k + 9, Block.stoneBrick.blockID);
		world.setBlock(i + 6, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 6, j + 0, k + 4, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 0, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 0, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 0, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 0, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 6, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 6, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 6, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 6, j + 1, k + 3, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 1, k + 4, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 1, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 1, k + 6, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 6, j + 1, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 6, j + 2, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 6, j + 3, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 6, j + 4, k + 7, Block.woodSingleSlab.blockID, 9);
		world.setBlockAndMetadata(i + 6, j + 4, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 7, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 7, j + 0, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 0, k + 4, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 0, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 0, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 0, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 0, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 7, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 7, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 7, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 7, j + 1, k + 4, Block.woodSingleSlab.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 1, k + 5, Block.woodSingleSlab.blockID, 1);
		world.setBlock(i + 7, j + 1, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 7, j + 2, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 7, j + 3, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 4, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 4, k + 8, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 7, j + 4, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 7, j + 5, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 7, j + 8, k + 9, Block.stairsStoneBrickSmooth.blockID, 4);
		world.setBlock(i + 8, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 8, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 8, j + 0, k + 2, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 3, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 4, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 5, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 0, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 8, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 8, j + 0, k + 10, Block.dirt.blockID);
		world.setBlock(i + 8, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 8, j + 1, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 8, j + 1, k + 10, Block.stairsStoneBrickSmooth.blockID);
		world.setBlock(i + 8, j + 2, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 8, j + 3, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 8, j + 4, k + 5, Block.woodSingleSlab.blockID, 9);
		world.setBlockAndMetadata(i + 8, j + 4, k + 6, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 4, k + 7, Block.planks.blockID, 1);
		world.setBlockAndMetadata(i + 8, j + 4, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 8, j + 4, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 8, j + 5, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 8, j + 6, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 8, j + 7, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 8, j + 8, k + 7, Block.woodSingleSlab.blockID, 9);
		world.setBlockAndMetadata(i + 8, j + 8, k + 8, Block.planks.blockID, 1);
		world.setBlock(i + 8, j + 8, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 8, j + 9, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 9, j + 0, k + 2, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 3, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 4, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 0, k + 5, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 9, j + 0, k + 6, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 0, k + 7, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 8, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 10, Block.dirt.blockID);
		world.setBlock(i + 9, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 9, j + 1, k + 2, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 1, k + 3, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 1, k + 7, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 1, k + 8, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 1, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 1, k + 10, Block.stairsStoneBrickSmooth.blockID, 3);
		world.setBlockAndMetadata(i + 9, j + 2, k + 2, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 2, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 2, k + 7, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 2, k + 8, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 2, k + 9, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 9, j + 3, k + 3, Block.stoneBrick.blockID, 1);
		world.setBlockAndMetadata(i + 9, j + 3, k + 4, Block.stairsStoneBrickSmooth.blockID, 7);
		world.setBlockAndMetadata(i + 9, j + 3, k + 6, Block.stairsStoneBrickSmooth.blockID, 6);
		world.setBlockAndMetadata(i + 9, j + 3, k + 7, Block.stoneBrick.blockID, 1);
		world.setBlockAndMetadata(i + 9, j + 3, k + 8, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 3, k + 9, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 4, k + 4, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 4, k + 5, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 4, k + 6, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 4, k + 7, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 9, j + 4, k + 8, Block.stoneBrick.blockID, 2);
		world.setBlockAndMetadata(i + 9, j + 4, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 5, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 5, k + 5, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 5, k + 6, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 5, k + 7, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 5, k + 8, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 5, k + 9, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 6, k + 5, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 6, k + 8, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 6, k + 9, Block.stoneBrick.blockID, 1);
		world.setBlockAndMetadata(i + 9, j + 7, k + 5, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 7, k + 8, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 7, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 8, k + 4, Block.stairsStoneBrickSmooth.blockID, 6);
		world.setBlock(i + 9, j + 8, k + 5, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 8, k + 6, Block.stairsStoneBrickSmooth.blockID, 7);
		world.setBlockAndMetadata(i + 9, j + 8, k + 7, Block.stairsStoneBrickSmooth.blockID, 6);
		world.setBlockAndMetadata(i + 9, j + 8, k + 8, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 8, k + 9, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 9, k + 5, Block.stoneBrick.blockID, 1);
		world.setBlockAndMetadata(i + 9, j + 9, k + 6, Block.stoneBrick.blockID, 2);
		world.setBlock(i + 9, j + 9, k + 7, Block.stoneBrick.blockID);
		world.setBlockAndMetadata(i + 9, j + 9, k + 8, Block.stoneBrick.blockID, 1);
		world.setBlock(i + 9, j + 9, k + 9, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 10, k + 7, Block.stoneBrick.blockID);
		world.setBlock(i + 9, j + 10, k + 8, Block.stoneBrick.blockID);
		world.setBlock(i + 10, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 10, j + 0, k + 8, Block.dirt.blockID);
		world.setBlock(i + 10, j + 0, k + 9, Block.dirt.blockID);
		world.setBlock(i + 10, j + 0, k + 10, Block.dirt.blockID);
		world.setBlock(i + 10, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);
		world.setBlockAndMetadata(i + 10, j + 1, k + 8, Block.stairsStoneBrickSmooth.blockID, 2);
		world.setBlockAndMetadata(i + 10, j + 1, k + 9, Block.stairsStoneBrickSmooth.blockID, 1);
		world.setBlockAndMetadata(i + 10, j + 1, k + 10, Block.stairsStoneBrickSmooth.blockID, 3);
		world.setBlock(i + 11, j + 0, k + 0, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 1, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 2, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 3, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 4, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 5, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 6, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 7, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 8, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 9, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 10, NanotechBlock.BlockGrass.blockID);
		world.setBlock(i + 11, j + 0, k + 11, NanotechBlock.BlockGrass.blockID);

		return true;
	}
}