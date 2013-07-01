package fr.mcnanotech.kevin_68.nanotech_mod.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class WorldGeneration implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		//TODO case 19: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		int Xcoord2 = blockX + random.nextInt(1);
		int Ycoord2 = random.nextInt(100);
		int Zcoord2 = blockZ + random.nextInt(1);
		(new WorldGenMinable(NanotechBlock.BlockNanoOre.blockID, 0, 10)).generate(world, random, Xcoord2, Ycoord2, Zcoord2);

		int Xcoord3 = blockX + random.nextInt(16);
		int Ycoord3 = random.nextInt(100);
		int Zcoord3 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockNanoOre.blockID, 1, 7)).generate(world, random, Xcoord3, Ycoord3, Zcoord3);

		int Xcoord4 = blockX + random.nextInt(16);
		int Ycoord4 = random.nextInt(32);
		int Zcoord4 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockFakeOre.blockID, 0, 6)).generate(world, random, Xcoord4, Ycoord4, Zcoord4);

		int Xcoord5 = blockX + random.nextInt(16);
		int Ycoord5 = random.nextInt(16);
		int Zcoord5 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockFakeOre.blockID, 1, 4)).generate(world, random, Xcoord5, Ycoord5, Zcoord5);
	}
}