package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import net.minecraft.util.ChunkCoordinates;

public class NanotechPortalPosition extends ChunkCoordinates
{
	public long time;
	final NanotechTeleporter teleporter;

	public NanotechPortalPosition(NanotechTeleporter nanotechTeleporter, int x, int y, int z, long creationTime)
	{
		super(x, y, z);
		this.teleporter = nanotechTeleporter;
		this.time = creationTime;
	}
}