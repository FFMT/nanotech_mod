/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.init.Blocks;
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
		this.topBlock = NanotechBlock.nanoGrass;
		this.fillerBlock = Blocks.dirt;
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