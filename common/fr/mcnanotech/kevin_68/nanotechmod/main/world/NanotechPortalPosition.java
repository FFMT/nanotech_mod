/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
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