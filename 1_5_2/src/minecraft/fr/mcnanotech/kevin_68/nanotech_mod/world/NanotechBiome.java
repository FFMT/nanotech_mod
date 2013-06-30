package fr.mcnanotech.kevin_68.nanotech_mod.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class NanotechBiome extends BiomeGenBase
{
	public NanotechBiome(int id)
	{
		super(id);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.topBlock = (byte) NanotechBlock.BlockGrass.blockID;
		this.fillerBlock = (byte) Block.dirt.blockID;
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
	public int getSkyColorByTemp(float par1)
	{
		return 0;
	}
}
