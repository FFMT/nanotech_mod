package fr.mcnanotech.kevin_68.nanotech_mod.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class World_generation implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case 19: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		int Xcoord1 = blockX + random.nextInt(512);
		int Ycoord1 = random.nextInt(100);
		int Zcoord1 = blockZ + random.nextInt(512);
		(new World_model1()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	
		int Xcoord2 = blockX + random.nextInt(1);
		int Ycoord2 = random.nextInt(100);
		int Zcoord2 = blockZ + random.nextInt(1);
		(new WorldGenMinable(NanotechBlock.BlockSiliconore.blockID, 10)).generate(world, random, Xcoord2, Ycoord2, Zcoord2);

		int Xcoord3 = blockX + random.nextInt(16);
		int Ycoord3 = random.nextInt(100);
		int Zcoord3 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockStonedecrease.blockID, 7)).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
		
		int Xcoord4 = blockX + random.nextInt(16);
		int Ycoord4 = random.nextInt(32);
		int Zcoord4 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockFakeGold.blockID, 6)).generate(world, random, Xcoord4, Ycoord4, Zcoord4);

		int Xcoord5 = blockX + random.nextInt(16);
		int Ycoord5 = random.nextInt(16);
		int Zcoord5 = blockZ + random.nextInt(16);
		(new WorldGenMinable(NanotechBlock.BlockFakeDiamond.blockID, 4)).generate(world, random, Xcoord5, Ycoord5, Zcoord5);
		
		int Xcoord6 = blockX + random.nextInt(256);
		int Ycoord6 = random.nextInt(100);
		int Zcoord6 = blockZ + random.nextInt(256);
		(new World_gennanotree(true)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		
		int Xcoord7 = blockX + random.nextInt(1024);
		int Ycoord7 = random.nextInt(100);
		int Zcoord7 = blockZ + random.nextInt(1024);
		(new World_model2()).generate(world, random, Xcoord7, Ycoord7, Zcoord7);
		
		int Xcoord8 = blockX + random.nextInt(512);
		int Ycoord8 = random.nextInt(100);
		int Zcoord8 = blockZ + random.nextInt(512);
		(new World_model3()).generate(world, random, Xcoord8, Ycoord8, Zcoord8);
		/**
		int Xcoord9 = blockX + random.nextInt(512);
		int Ycoord9 = random.nextInt(100);
		int Zcoord9 = blockZ + random.nextInt(512);
		(new World_model4()).generate(world, random, Xcoord9, Ycoord9, Zcoord9);
		
		int Xcoord10 = blockX + random.nextInt(512);
		int Ycoord10 = random.nextInt(100);
		int Zcoord10 = blockZ + random.nextInt(512);
		(new World_model5()).generate(world, random, Xcoord10, Ycoord10, Zcoord10);
		
		int Xcoord11 = blockX + random.nextInt(512);
		int Ycoord11 = random.nextInt(100);
		int Zcoord11 = blockZ + random.nextInt(512);
		(new World_model6()).generate(world, random, Xcoord11, Ycoord11, Zcoord11);
		**/
		int Xcoord12 = blockX + random.nextInt(512);
		int Ycoord12 = random.nextInt(100);
		int Zcoord12 = blockZ + random.nextInt(512);
		(new World_model7()).generate(world, random, Xcoord12, Ycoord12, Zcoord12);
		
	}
}