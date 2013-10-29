package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechBiomeGenLayer extends GenLayer
{

	protected BiomeGenBase[] allowedBiomes = {Nanotech_mod.nanotechBiome, Nanotech_mod.nitrogenOcean};

	public NanotechBiomeGenLayer(long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
	}

	public NanotechBiomeGenLayer(long seed)
	{
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width * depth);

		for(int dz = 0; dz < depth; dz++)
		{
			for(int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}