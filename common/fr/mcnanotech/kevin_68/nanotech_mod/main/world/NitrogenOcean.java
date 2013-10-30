package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import net.minecraft.world.biome.BiomeGenBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class NitrogenOcean extends BiomeGenBase
{
	public NitrogenOcean(int id)
	{
		super(id);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = (byte)NanotechBlock.nanoGrass.blockID;
	}
}
