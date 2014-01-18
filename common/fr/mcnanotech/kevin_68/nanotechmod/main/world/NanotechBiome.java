package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class NanotechBiome extends BiomeGenBase
{
	private WorldGenNanoTree worldGenNanoTree = new WorldGenNanoTree(false);

	public NanotechBiome(int id)
	{
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.topBlock = (byte)NanotechBlock.nanoGrass.blockID;
		this.fillerBlock = (byte)Block.dirt.blockID;
		this.setBiomeName("Nanotech");
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.theBiomeDecorator.deadBushPerChunk = 0;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.reedsPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
	}

	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float color)
	{
		return 0;
	}

	public WorldGenerator getRandomWorldGenForTrees(Random rand)
	{
		return this.worldGenNanoTree;
	}
}