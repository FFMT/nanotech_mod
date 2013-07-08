package fr.mcnanotech.kevin_68.nanotech_mod.world;

import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class NanotechWorldProvider extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Nanotech_mod.Nanotechbiome, 0.8F, 0.1F);
		this.dimensionId = Nanotech_mod.dimensionID;
	}

	public String getDimensionName()
	{
		return "Nanotech";
	}

	public boolean canRespawnHere()
	{
		return true;
	}

	public String getSaveFolder()
	{
		return "DIMNanotech";
	}

	@Override public IChunkProvider createChunkGenerator()
	{
		return new NanotechChunkProvider(worldObj, worldObj.getSeed(), true);
	}
}