package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class NanotechGenLayer extends GenLayer
{
	public NanotechGenLayer(long seed)
	{
		super(seed);
	}

	public static GenLayer[] makeTheWorld(long seed)
	{

		GenLayer biomes = new NanotechBiomeGenLayer(1L);

		biomes = new GenLayerZoom(100000L, biomes);
		biomes = new GenLayerZoom(100001L, biomes);

		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		return new GenLayer[] {biomes, genlayervoronoizoom};
	}
}