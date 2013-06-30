package fr.mcnanotech.kevin_68.nanotech_mod.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class NanotechWorldProvider extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Nanotech_mod.Nanotechbiome, 0.8F, 0.1F);
		this.dimensionId = Nanotech_mod.dimensionID;
		this.hasNoSky = false;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new NanotechChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
	}

	public String getSaveFolder()
	{
		return "DIMNanotech";
	}

	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2)
	{
		return false;
	}

	public String getDimensionName()
	{
		return "Nanotech";
	}

	public boolean renderClouds()
	{
		return false;
	}

	public boolean renderVoidFog()
	{
		return false;
	}

	public boolean renderEndSky()
	{
		return false;
	}

	public boolean canRespawnHere()
	{
		return false;
	}

	public boolean isSurfaceWorld()
	{
		return true;
	}
}