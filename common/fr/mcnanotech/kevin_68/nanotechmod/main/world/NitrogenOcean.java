/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import net.minecraft.world.biome.BiomeGenBase;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;

public class NitrogenOcean extends BiomeGenBase
{
	public NitrogenOcean(int id)
	{
		super(id);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = NanotechModList.nanoGrass;
	}
}
