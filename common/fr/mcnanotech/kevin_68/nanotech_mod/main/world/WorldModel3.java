package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class WorldModel3 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[] {Block.stone.blockID, Block.dirt.blockID, NanotechBlock.nanoGrass.blockID};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		int checkID = world.getBlockId(x, y, z);

		while(checkID != 0)
		{
			distanceToAir++;
			checkID = world.getBlockId(x, y + distanceToAir, z);
		}

		if(distanceToAir > 3)
		{
			return false;
		}
		y += distanceToAir - 1;

		int blockID = world.getBlockId(x, y, z);
		int blockIDAbove = world.getBlockId(x, y + 1, z);
		int blockIDBelow = world.getBlockId(x, y - 1, z);
		for(int valideId : GetValidSpawnBlocks())
		{
			if(blockIDAbove != 0)
			{
				return false;
			}
			if(blockID == valideId)
			{
				return true;
			}
			else if(blockID == Block.snow.blockID && blockIDBelow == valideId)
			{
				return true;
			}
		}
		return false;
	}

	public WorldModel3()
	{}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		// checz that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 11, y, z) || !LocationIsValidSpawn(world, x + 11, y, z + 8) || !LocationIsValidSpawn(world, x, y, z + 8))
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Block.cobblestone.blockID);
		world.setBlock(x + 0, y + 0, z + 1, Block.cobblestone.blockID);
		world.setBlock(x + 0, y + 0, z + 2, Block.cobblestone.blockID);
		world.setBlock(x + 0, y + 0, z + 3, Block.cobblestone.blockID);
		world.setBlock(x + 0, y + 0, z + 4, Block.cobblestone.blockID);
		world.setBlock(x + 0, y + 1, z + 0, Block.cobblestone.blockID);
		world.setBlockToAir(x + 0, y + 1, z + 1);
		world.setBlockToAir(x + 0, y + 1, z + 2);
		world.setBlockToAir(x + 0, y + 1, z + 3);
		world.setBlock(x + 0, y + 1, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 0, y + 1, z + 5);
		world.setBlockToAir(x + 0, y + 2, z + 0);
		world.setBlockToAir(x + 0, y + 2, z + 1);
		world.setBlockToAir(x + 0, y + 2, z + 2);
		world.setBlockToAir(x + 0, y + 2, z + 3);
		world.setBlock(x + 0, y + 2, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 0, y + 2, z + 5);
		world.setBlockToAir(x + 0, y + 3, z + 0);
		world.setBlockToAir(x + 0, y + 3, z + 1);
		world.setBlockToAir(x + 0, y + 3, z + 2);
		world.setBlockToAir(x + 0, y + 3, z + 3);
		world.setBlock(x + 0, y + 3, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 0, y + 3, z + 5);
		world.setBlockToAir(x + 0, y + 4, z + 0);
		world.setBlockToAir(x + 0, y + 4, z + 1);
		world.setBlockToAir(x + 0, y + 4, z + 2);
		world.setBlockToAir(x + 0, y + 4, z + 3);
		world.setBlockToAir(x + 0, y + 4, z + 4);
		world.setBlockToAir(x + 0, y + 4, z + 5);
		world.setBlock(x + 1, y + 0, z + 0, Block.cobblestone.blockID);
		world.setBlock(x + 1, y + 0, z + 1, Block.cobblestone.blockID);
		world.setBlock(x + 1, y + 0, z + 2, Block.cobblestone.blockID);
		world.setBlock(x + 1, y + 0, z + 3, Block.cobblestone.blockID);
		world.setBlock(x + 1, y + 0, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 1, y + 0, z + 5);
		world.setBlockToAir(x + 1, y + 1, z + 0);
		world.setBlockToAir(x + 1, y + 1, z + 1);
		world.setBlockToAir(x + 1, y + 1, z + 2);
		world.setBlockToAir(x + 1, y + 1, z + 3);
		world.setBlockToAir(x + 1, y + 1, z + 4);
		world.setBlockToAir(x + 1, y + 1, z + 5);
		world.setBlockToAir(x + 1, y + 2, z + 0);
		world.setBlockToAir(x + 1, y + 2, z + 1);
		world.setBlockToAir(x + 1, y + 2, z + 2);
		world.setBlockToAir(x + 1, y + 2, z + 3);
		world.setBlockToAir(x + 1, y + 2, z + 4);
		world.setBlockToAir(x + 1, y + 2, z + 5);
		world.setBlockToAir(x + 1, y + 3, z + 0);
		world.setBlockToAir(x + 1, y + 3, z + 1);
		world.setBlockToAir(x + 1, y + 3, z + 2);
		world.setBlockToAir(x + 1, y + 3, z + 3);
		world.setBlockToAir(x + 1, y + 3, z + 4);
		world.setBlockToAir(x + 1, y + 3, z + 5);
		world.setBlockToAir(x + 1, y + 4, z + 0);
		world.setBlockToAir(x + 1, y + 4, z + 1);
		world.setBlockToAir(x + 1, y + 4, z + 2);
		world.setBlockToAir(x + 1, y + 4, z + 3);
		world.setBlockToAir(x + 1, y + 4, z + 4);
		world.setBlockToAir(x + 1, y + 4, z + 5);
		world.setBlock(x + 2, y + 0, z + 0, Block.cobblestone.blockID);
		world.setBlock(x + 2, y + 0, z + 1, Block.cobblestone.blockID);
		world.setBlock(x + 2, y + 0, z + 2, Block.cobblestone.blockID);
		world.setBlock(x + 2, y + 0, z + 3, Block.cobblestone.blockID);
		world.setBlock(x + 2, y + 0, z + 4, Block.cobblestone.blockID);
		world.setBlock(x + 2, y + 0, z + 5, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlockToAir(x + 2, y + 1, z + 0);
		world.setBlockToAir(x + 2, y + 1, z + 1);
		world.setBlockToAir(x + 2, y + 1, z + 2);
		world.setBlockToAir(x + 2, y + 1, z + 3);
		world.setBlockToAir(x + 2, y + 1, z + 4);
		world.setBlockToAir(x + 2, y + 1, z + 5);
		world.setBlockToAir(x + 2, y + 2, z + 0);
		world.setBlockToAir(x + 2, y + 2, z + 1);
		world.setBlockToAir(x + 2, y + 2, z + 2);
		world.setBlockToAir(x + 2, y + 2, z + 3);
		world.setBlockToAir(x + 2, y + 2, z + 4);
		world.setBlockToAir(x + 2, y + 2, z + 5);
		world.setBlockToAir(x + 2, y + 3, z + 0);
		world.setBlockToAir(x + 2, y + 3, z + 1);
		world.setBlockToAir(x + 2, y + 3, z + 2);
		world.setBlockToAir(x + 2, y + 3, z + 3);
		world.setBlockToAir(x + 2, y + 3, z + 4);
		world.setBlockToAir(x + 2, y + 3, z + 5);
		world.setBlockToAir(x + 2, y + 4, z + 0);
		world.setBlockToAir(x + 2, y + 4, z + 1);
		world.setBlockToAir(x + 2, y + 4, z + 2);
		world.setBlockToAir(x + 2, y + 4, z + 3);
		world.setBlockToAir(x + 2, y + 4, z + 4);
		world.setBlockToAir(x + 2, y + 4, z + 5);
		world.setBlock(x + 3, y + 0, z + 0, Block.cobblestone.blockID);
		world.setBlock(x + 3, y + 0, z + 1, Block.cobblestone.blockID);
		world.setBlock(x + 3, y + 0, z + 2, Block.cobblestone.blockID);
		world.setBlock(x + 3, y + 0, z + 3, Block.cobblestone.blockID);
		world.setBlock(x + 3, y + 0, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 3, y + 0, z + 5);
		world.setBlockToAir(x + 3, y + 1, z + 0);
		world.setBlockToAir(x + 3, y + 1, z + 1);
		world.setBlockToAir(x + 3, y + 1, z + 2);
		world.setBlockToAir(x + 3, y + 1, z + 3);
		world.setBlockToAir(x + 3, y + 1, z + 4);
		world.setBlockToAir(x + 3, y + 1, z + 5);
		world.setBlockToAir(x + 3, y + 2, z + 0);
		world.setBlockToAir(x + 3, y + 2, z + 1);
		world.setBlockToAir(x + 3, y + 2, z + 2);
		world.setBlockToAir(x + 3, y + 2, z + 3);
		world.setBlockToAir(x + 3, y + 2, z + 4);
		world.setBlockToAir(x + 3, y + 2, z + 5);
		world.setBlockToAir(x + 3, y + 3, z + 0);
		world.setBlockToAir(x + 3, y + 3, z + 1);
		world.setBlockToAir(x + 3, y + 3, z + 2);
		world.setBlockToAir(x + 3, y + 3, z + 3);
		world.setBlockToAir(x + 3, y + 3, z + 4);
		world.setBlockToAir(x + 3, y + 3, z + 5);
		world.setBlockToAir(x + 3, y + 4, z + 0);
		world.setBlockToAir(x + 3, y + 4, z + 1);
		world.setBlockToAir(x + 3, y + 4, z + 2);
		world.setBlockToAir(x + 3, y + 4, z + 3);
		world.setBlockToAir(x + 3, y + 4, z + 4);
		world.setBlockToAir(x + 3, y + 4, z + 5);
		world.setBlock(x + 4, y + 0, z + 0, Block.cobblestone.blockID);
		world.setBlock(x + 4, y + 0, z + 1, Block.cobblestone.blockID);
		world.setBlock(x + 4, y + 0, z + 2, Block.cobblestone.blockID);
		world.setBlock(x + 4, y + 0, z + 3, Block.cobblestone.blockID);
		world.setBlock(x + 4, y + 0, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 0, z + 5);
		world.setBlock(x + 4, y + 1, z + 0, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 1, z + 1);
		world.setBlockToAir(x + 4, y + 1, z + 2);
		world.setBlockToAir(x + 4, y + 1, z + 3);
		world.setBlock(x + 4, y + 1, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 1, z + 5);
		world.setBlock(x + 4, y + 2, z + 0, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 2, z + 1);
		world.setBlockToAir(x + 4, y + 2, z + 2);
		world.setBlockToAir(x + 4, y + 2, z + 3);
		world.setBlock(x + 4, y + 2, z + 4, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 2, z + 5);
		world.setBlock(x + 4, y + 3, z + 0, Block.cobblestone.blockID);
		world.setBlockToAir(x + 4, y + 3, z + 1);
		world.setBlockToAir(x + 4, y + 3, z + 2);
		world.setBlockToAir(x + 4, y + 3, z + 3);
		world.setBlockToAir(x + 4, y + 3, z + 4);
		world.setBlockToAir(x + 4, y + 3, z + 5);
		world.setBlockToAir(x + 4, y + 4, z + 1);
		world.setBlockToAir(x + 4, y + 4, z + 2);
		world.setBlockToAir(x + 4, y + 4, z + 3);
		world.setBlockToAir(x + 4, y + 4, z + 4);
		world.setBlockToAir(x + 4, y + 4, z + 5);

		return true;
	}
}