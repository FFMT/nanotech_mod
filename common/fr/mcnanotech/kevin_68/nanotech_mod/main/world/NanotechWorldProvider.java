package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechWorldProvider extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new NanotechWorldChunkManager(worldObj.getSeed(), terrainType);
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

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0.2, 0.2, 0.2);
	}

	@Override
	public boolean isSkyColored()
	{
		return true;
	}
}