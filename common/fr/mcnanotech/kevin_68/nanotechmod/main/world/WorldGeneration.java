/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class WorldGeneration implements IWorldGenerator
{
	private WorldModel1 worldgen1 = new WorldModel1();
	private WorldModel2 worldgen2 = new WorldModel2();
	private WorldModel3 worldgen3 = new WorldModel3();
	private WorldModel4 worldgen4 = new WorldModel4();
	private WorldModel5 worldgen5 = new WorldModel5();
	private WorldModel6 worldgen6 = new WorldModel6();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.dimensionId == NanotechMod.dimensionID)
		{
			for(int i = 0; i < 4; i++)
			{
				(new WorldGenMinable(NanotechBlock.nanoOre.blockID, 0, 10, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			(new WorldGenMinable(NanotechBlock.nanoOre.blockID, 1, 7, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));

			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(NanotechBlock.fakeOre.blockID, 0, 6, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(32), chunkZ * 16 + random.nextInt(16));
			}

			(new WorldGenMinable(NanotechBlock.fakeOre.blockID, 1, 4, Block.stone.blockID)).generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(16), chunkZ * 16 + random.nextInt(16));
			// world gen

			if(random.nextInt(32) < 2 * NanotechMod.structure1Prob)
			{
				worldgen1.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			if(random.nextInt(32) < 2 * NanotechMod.structure2Prob)
			{
				worldgen2.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			if(random.nextInt(32) < 2 * NanotechMod.structure3Prob)
			{
				worldgen3.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			if(random.nextInt(32) < 2 * NanotechMod.structure4Prob)
			{
				worldgen4.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			if(random.nextInt(32) < 2 * NanotechMod.structure5Prob)
			{
				worldgen5.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}

			if(random.nextInt(32) < 2 * NanotechMod.structure6Prob)
			{
				worldgen6.generate(world, random, chunkX * 16 + random.nextInt(16), random.nextInt(100), chunkZ * 16 + random.nextInt(16));
			}
		}
	}
}