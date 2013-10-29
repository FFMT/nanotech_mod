package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import net.minecraft.world.biome.BiomeGenBase;

public class NitrogenOcean extends BiomeGenBase
{
    public NitrogenOcean(int par1)
    {
        super(par1);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = (byte)NanotechBlock.nanoGrass.blockID;
    }
}
