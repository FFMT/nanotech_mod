package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class WorldGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.dimensionId == Nanotech_mod.dimensionID)
		{
			for(int i = 0; i < 4; i++)
			{
				(new WorldGenMinable(NanotechBlock.BlockNanoOre.blockID, 0, 10, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}
			
			(new WorldGenMinable(NanotechBlock.BlockNanoOre.blockID, 1, 7, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));

			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(NanotechBlock.BlockFakeOre.blockID, 0, 6, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(32), chunkZ * 16 + random.nextInt(16));
			}

			(new WorldGenMinable(NanotechBlock.BlockFakeOre.blockID, 1, 4, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(16), chunkZ * 16 + random.nextInt(16));
		}
	}
}