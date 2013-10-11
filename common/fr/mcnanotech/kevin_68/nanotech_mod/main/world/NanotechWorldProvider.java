package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechWorldProvider extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Nanotech_mod.nanotechBiome, 0.8F, 0.1F);
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

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new NanotechChunkProvider(worldObj, worldObj.getSeed(), true);
	}
}