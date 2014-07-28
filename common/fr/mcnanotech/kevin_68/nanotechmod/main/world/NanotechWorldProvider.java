/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;

public class NanotechWorldProvider extends WorldProvider
{
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new NanotechWorldChunkManager(worldObj.getSeed(), terrainType);
        this.dimensionId = NanotechConfiguration.dimensionID;
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
        return Vec3.createVectorHelper(0.2, 0.2, 0.2);
    }

    @Override
    public boolean isSkyColored()
    {
        return true;
    }
}