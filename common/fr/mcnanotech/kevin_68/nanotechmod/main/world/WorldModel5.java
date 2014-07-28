/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class WorldModel5 extends WorldGenerator
{
    protected Block[] getValidSpawnBlocks()
    {
        return new Block[] {Blocks.stone, Blocks.dirt, NanotechBlock.nanoGrass, Blocks.snow};
    }

    public boolean LocationIsValidSpawn(World world, int x, int y, int z)
    {
        int distanceToAir = 0;
        Block check = world.getBlock(x, y, z);

        while(check != null)
        {
            distanceToAir++;
            check = world.getBlock(x, y + distanceToAir, z);
        }

        if(distanceToAir > 3)
        {
            return false;
        }
        y += distanceToAir - 1;

        Block block = world.getBlock(x, y, z);
        boolean isAirAbove = world.isAirBlock(x, y + 1, z);
        Block blockBelow = world.getBlock(x, y - 1, z);
        for(Block valideBlock : getValidSpawnBlocks())
        {
            if(!isAirAbove)
            {
                return false;
            }
            if(block == valideBlock)
            {
                return true;
            }
            else if(block == Blocks.snow && blockBelow == valideBlock)
            {
                return true;
            }
        }
        return false;
    }

    public WorldModel5()
    {}

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 6, y, z) || !LocationIsValidSpawn(world, x + 6, y, z + 6) || !LocationIsValidSpawn(world, x, y, z + 6))
        {
            return false;
        }

        world.setBlock(x, y - 4, z, Blocks.stone);
        world.setBlock(x, y - 4, z + 1, Blocks.stone);
        world.setBlock(x, y - 4, z + 2, Blocks.stone);
        world.setBlock(x, y - 4, z + 3, Blocks.stone);
        world.setBlock(x, y - 4, z + 4, Blocks.stone);
        world.setBlock(x, y - 4, z + 5, Blocks.stone);
        world.setBlock(x, y - 4, z + 6, Blocks.stone);
        world.setBlock(x, y - 3, z, Blocks.stone);
        world.setBlock(x, y - 3, z + 1, Blocks.stone);
        world.setBlock(x, y - 3, z + 2, Blocks.stone);
        world.setBlock(x, y - 3, z + 3, Blocks.stone);
        world.setBlock(x, y - 3, z + 4, Blocks.stone);
        world.setBlock(x, y - 3, z + 5, Blocks.stone);
        world.setBlock(x, y - 3, z + 6, Blocks.stone);
        world.setBlock(x, y - 2, z, Blocks.dirt);
        world.setBlock(x, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x, y - 2, z + 2, Blocks.dirt);
        world.setBlock(x, y - 2, z + 3, Blocks.dirt);
        world.setBlock(x, y - 2, z + 4, Blocks.dirt);
        world.setBlock(x, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x, y - 1, z, Blocks.dirt);
        world.setBlock(x, y - 1, z + 1, Blocks.dirt);
        world.setBlock(x, y - 1, z + 2, Blocks.dirt);
        world.setBlock(x, y - 1, z + 3, Blocks.dirt);
        world.setBlock(x, y - 1, z + 4, Blocks.dirt);
        world.setBlock(x, y - 1, z + 5, Blocks.dirt);
        world.setBlock(x, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 1, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 2, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 3, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 4, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 5, NanotechBlock.nanoGrass);
        world.setBlock(x, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x, y + 1, z);
        world.setBlockToAir(x, y + 1, z + 1);
        world.setBlockToAir(x, y + 1, z + 2);
        world.setBlockToAir(x, y + 1, z + 3);
        world.setBlockToAir(x, y + 1, z + 4);
        world.setBlockToAir(x, y + 1, z + 5);
        world.setBlockToAir(x, y + 1, z + 6);
        world.setBlockToAir(x, y + 2, z);
        world.setBlockToAir(x, y + 2, z + 1);
        world.setBlockToAir(x, y + 2, z + 2);
        world.setBlockToAir(x, y + 2, z + 3);
        world.setBlockToAir(x, y + 2, z + 4);
        world.setBlockToAir(x, y + 2, z + 5);
        world.setBlockToAir(x, y + 2, z + 6);
        world.setBlockToAir(x, y + 3, z);
        world.setBlockToAir(x, y + 3, z + 1);
        world.setBlockToAir(x, y + 3, z + 2);
        world.setBlockToAir(x, y + 3, z + 3);
        world.setBlockToAir(x, y + 3, z + 4);
        world.setBlockToAir(x, y + 3, z + 5);
        world.setBlockToAir(x, y + 3, z + 6);
        world.setBlockToAir(x, y + 4, z);
        world.setBlockToAir(x, y + 4, z + 1);
        world.setBlockToAir(x, y + 4, z + 2);
        world.setBlockToAir(x, y + 4, z + 3);
        world.setBlockToAir(x, y + 4, z + 4);
        world.setBlockToAir(x, y + 4, z + 5);
        world.setBlockToAir(x, y + 4, z + 6);
        world.setBlockToAir(x, y + 5, z);
        world.setBlockToAir(x, y + 5, z + 1);
        world.setBlockToAir(x, y + 5, z + 2);
        world.setBlockToAir(x, y + 5, z + 3);
        world.setBlockToAir(x, y + 5, z + 4);
        world.setBlockToAir(x, y + 5, z + 5);
        world.setBlockToAir(x, y + 5, z + 6);
        world.setBlockToAir(x, y + 6, z);
        world.setBlockToAir(x, y + 6, z + 1);
        world.setBlockToAir(x, y + 6, z + 2);
        world.setBlockToAir(x, y + 6, z + 3);
        world.setBlockToAir(x, y + 6, z + 4);
        world.setBlockToAir(x, y + 6, z + 5);
        world.setBlockToAir(x, y + 6, z + 6);
        world.setBlockToAir(x, y + 7, z);
        world.setBlockToAir(x, y + 7, z + 1);
        world.setBlockToAir(x, y + 7, z + 2);
        world.setBlockToAir(x, y + 7, z + 3);
        world.setBlockToAir(x, y + 7, z + 4);
        world.setBlockToAir(x, y + 7, z + 5);
        world.setBlockToAir(x, y + 7, z + 6);
        world.setBlockToAir(x, y + 8, z);
        world.setBlockToAir(x, y + 8, z + 1);
        world.setBlockToAir(x, y + 8, z + 2);
        world.setBlockToAir(x, y + 8, z + 3);
        world.setBlockToAir(x, y + 8, z + 4);
        world.setBlockToAir(x, y + 8, z + 5);
        world.setBlockToAir(x, y + 8, z + 6);
        world.setBlock(x + 1, y - 4, z, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 3, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 1, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 1, y - 3, z, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 2, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 3, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 4, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 1, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 1, y - 2, z, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 2, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 3, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 4, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 1, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 1, y - 1, z, Blocks.dirt);
        world.setBlock(x + 1, y - 1, z + 1, Blocks.dirt);
        world.setBlock(x + 1, y - 1, z + 2, NanotechBlock.nukeBuildingStairs, 4, 0);
        world.setBlock(x + 1, y - 1, z + 3, NanotechBlock.nukeBuildingStairs, 4, 0);
        world.setBlock(x + 1, y - 1, z + 4, NanotechBlock.nukeBuildingStairs, 4, 0);
        world.setBlock(x + 1, y - 1, z + 5, Blocks.dirt);
        world.setBlock(x + 1, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 1, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 1, y, z + 1, NanotechBlock.nukeBuilding, 8, 0);
        world.setBlock(x + 1, y, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y, z + 5, NanotechBlock.nukeBuilding, 7, 0);
        world.setBlock(x + 1, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 1, y + 1, z);
        world.setBlock(x + 1, y + 1, z + 1, NanotechBlock.nukeBuilding, 8, 0);
        world.setBlock(x + 1, y + 1, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 1, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 1, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 1, z + 5, NanotechBlock.nukeBuilding, 7, 0);
        world.setBlockToAir(x + 1, y + 1, z + 6);
        world.setBlockToAir(x + 1, y + 2, z);
        world.setBlock(x + 1, y + 2, z + 1, NanotechBlock.nukeBuilding, 8, 0);
        world.setBlock(x + 1, y + 2, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 2, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 2, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 2, z + 5, NanotechBlock.nukeBuilding, 7, 0);
        world.setBlockToAir(x + 1, y + 2, z + 6);
        world.setBlockToAir(x + 1, y + 3, z);
        world.setBlockToAir(x + 1, y + 3, z + 1);
        world.setBlock(x + 1, y + 3, z + 2, NanotechBlock.nukeBuildingStairs);
        world.setBlock(x + 1, y + 3, z + 3, NanotechBlock.nukeBuildingStairs);
        world.setBlock(x + 1, y + 3, z + 4, NanotechBlock.nukeBuildingStairs);
        world.setBlockToAir(x + 1, y + 3, z + 5);
        world.setBlockToAir(x + 1, y + 3, z + 6);
        world.setBlockToAir(x + 1, y + 4, z);
        world.setBlockToAir(x + 1, y + 4, z + 1);
        world.setBlockToAir(x + 1, y + 4, z + 2);
        world.setBlock(x + 1, y + 4, z + 3, NanotechBlock.nukeBuilding, 3, 0);
        world.setBlockToAir(x + 1, y + 4, z + 4);
        world.setBlockToAir(x + 1, y + 4, z + 5);
        world.setBlockToAir(x + 1, y + 4, z + 6);
        world.setBlockToAir(x + 1, y + 5, z);
        world.setBlockToAir(x + 1, y + 5, z + 1);
        world.setBlockToAir(x + 1, y + 5, z + 2);
        world.setBlockToAir(x + 1, y + 5, z + 3);
        world.setBlockToAir(x + 1, y + 5, z + 4);
        world.setBlockToAir(x + 1, y + 5, z + 5);
        world.setBlockToAir(x + 1, y + 5, z + 6);
        world.setBlockToAir(x + 1, y + 6, z);
        world.setBlockToAir(x + 1, y + 6, z + 1);
        world.setBlockToAir(x + 1, y + 6, z + 2);
        world.setBlockToAir(x + 1, y + 6, z + 3);
        world.setBlockToAir(x + 1, y + 6, z + 4);
        world.setBlockToAir(x + 1, y + 6, z + 5);
        world.setBlockToAir(x + 1, y + 6, z + 6);
        world.setBlockToAir(x + 1, y + 7, z);
        world.setBlockToAir(x + 1, y + 7, z + 1);
        world.setBlockToAir(x + 1, y + 7, z + 2);
        world.setBlockToAir(x + 1, y + 7, z + 3);
        world.setBlockToAir(x + 1, y + 7, z + 4);
        world.setBlockToAir(x + 1, y + 7, z + 5);
        world.setBlockToAir(x + 1, y + 7, z + 6);
        world.setBlockToAir(x + 1, y + 8, z);
        world.setBlock(x + 1, y + 8, z + 1, NanotechBlock.nukeBuilding, 8, 0);
        world.setBlock(x + 1, y + 8, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 8, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 8, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 1, y + 8, z + 5, NanotechBlock.nukeBuilding, 7, 0);
        world.setBlockToAir(x + 1, y + 8, z + 6);
        world.setBlock(x + 2, y - 4, z, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 3, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 2, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 2, y - 3, z, Blocks.stone);
        world.setBlock(x + 2, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 2, y - 3, z + 2, Blocks.stone);
        world.setBlock(x + 2, y - 3, z + 3, NanotechBlock.nukeBuildingStairs, 4, 0);
        world.setBlock(x + 2, y - 3, z + 4, Blocks.stone);
        world.setBlock(x + 2, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 2, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 2, y - 2, z, Blocks.dirt);
        world.setBlock(x + 2, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 2, y - 2, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 2, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 2, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 2, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 2, y - 1, z, Blocks.dirt);
        world.setBlock(x + 2, y - 1, z + 1, NanotechBlock.nukeBuildingStairs, 6, 0);
        world.setBlock(x + 2, y - 1, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 1, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 1, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y - 1, z + 5, NanotechBlock.nukeBuildingStairs, 7, 0);
        world.setBlock(x + 2, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 2, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 2, y, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y, z + 2, Blocks.tnt);
        world.setBlock(x + 2, y, z + 3, Blocks.tnt);
        world.setBlock(x + 2, y, z + 4, Blocks.tnt);
        world.setBlock(x + 2, y, z + 5, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 2, y + 1, z);
        world.setBlock(x + 2, y + 1, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 1, z + 2, Blocks.tnt);
        world.setBlock(x + 2, y + 1, z + 3, Blocks.tnt);
        world.setBlock(x + 2, y + 1, z + 4, Blocks.tnt);
        world.setBlock(x + 2, y + 1, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 2, y + 1, z + 6);
        world.setBlockToAir(x + 2, y + 2, z);
        world.setBlock(x + 2, y + 2, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 2, z + 2, Blocks.tnt);
        world.setBlock(x + 2, y + 2, z + 3, Blocks.tnt);
        world.setBlock(x + 2, y + 2, z + 4, Blocks.tnt);
        world.setBlock(x + 2, y + 2, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 2, y + 2, z + 6);
        world.setBlockToAir(x + 2, y + 3, z);
        world.setBlock(x + 2, y + 3, z + 1, NanotechBlock.nukeBuildingStairs, 2, 0);
        world.setBlock(x + 2, y + 3, z + 2, Blocks.tnt);
        world.setBlock(x + 2, y + 3, z + 3, Blocks.tnt);
        world.setBlock(x + 2, y + 3, z + 4, Blocks.tnt);
        world.setBlock(x + 2, y + 3, z + 5, NanotechBlock.nukeBuildingStairs, 3, 0);
        world.setBlockToAir(x + 2, y + 3, z + 6);
        world.setBlockToAir(x + 2, y + 4, z);
        world.setBlockToAir(x + 2, y + 4, z + 1);
        world.setBlock(x + 2, y + 4, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 4, z + 3, Blocks.tnt);
        world.setBlock(x + 2, y + 4, z + 4, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 2, y + 4, z + 5);
        world.setBlockToAir(x + 2, y + 4, z + 6);
        world.setBlockToAir(x + 2, y + 5, z);
        world.setBlockToAir(x + 2, y + 5, z + 1);
        world.setBlock(x + 2, y + 5, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 5, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 5, z + 4, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 2, y + 5, z + 5);
        world.setBlockToAir(x + 2, y + 5, z + 6);
        world.setBlockToAir(x + 2, y + 6, z);
        world.setBlockToAir(x + 2, y + 6, z + 1);
        world.setBlockToAir(x + 2, y + 6, z + 2);
        world.setBlock(x + 2, y + 6, z + 3, NanotechBlock.nukeBuildingStairs);
        world.setBlockToAir(x + 2, y + 6, z + 4);
        world.setBlockToAir(x + 2, y + 6, z + 5);
        world.setBlockToAir(x + 2, y + 6, z + 6);
        world.setBlockToAir(x + 2, y + 7, z);
        world.setBlockToAir(x + 2, y + 7, z + 1);
        world.setBlockToAir(x + 2, y + 7, z + 2);
        world.setBlockToAir(x + 2, y + 7, z + 3);
        world.setBlockToAir(x + 2, y + 7, z + 4);
        world.setBlockToAir(x + 2, y + 7, z + 5);
        world.setBlockToAir(x + 2, y + 7, z + 6);
        world.setBlockToAir(x + 2, y + 8, z);
        world.setBlock(x + 2, y + 8, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 2, y + 8, z + 2, NanotechBlock.nukeBuilding, 5, 0);
        world.setBlock(x + 2, y + 8, z + 3, NanotechBlock.nukeBuildingStairs, 1, 0);
        world.setBlock(x + 2, y + 8, z + 4, NanotechBlock.nukeBuilding, 6, 0);
        world.setBlock(x + 2, y + 8, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 2, y + 8, z + 6);
        world.setBlock(x + 3, y - 4, z, Blocks.stone);
        world.setBlock(x + 3, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 3, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 3, y - 4, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 3, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 3, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 3, y - 3, z, Blocks.stone);
        world.setBlock(x + 3, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 3, y - 3, z + 2, NanotechBlock.nukeBuildingStairs, 6, 0);
        world.setBlock(x + 3, y - 3, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 3, z + 4, NanotechBlock.nukeBuildingStairs, 7, 0);
        world.setBlock(x + 3, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 3, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 3, y - 2, z, Blocks.dirt);
        world.setBlock(x + 3, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 3, y - 2, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 2, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 3, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 3, y - 1, z, Blocks.dirt);
        world.setBlock(x + 3, y - 1, z + 1, NanotechBlock.nukeBuildingStairs, 6, 0);
        world.setBlock(x + 3, y - 1, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 1, z + 3, Blocks.diamond_ore);
        world.setBlock(x + 3, y - 1, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y - 1, z + 5, NanotechBlock.nukeBuildingStairs, 7, 0);
        world.setBlock(x + 3, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 3, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 3, y, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y, z + 2, Blocks.tnt);
        world.setBlock(x + 3, y, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y, z + 4, Blocks.tnt);
        world.setBlock(x + 3, y, z + 5, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 3, y + 1, z);
        world.setBlock(x + 3, y + 1, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y + 1, z + 2, Blocks.tnt);
        world.setBlock(x + 3, y + 1, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y + 1, z + 4, Blocks.tnt);
        world.setBlock(x + 3, y + 1, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 3, y + 1, z + 6);
        world.setBlockToAir(x + 3, y + 2, z);
        world.setBlock(x + 3, y + 2, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y + 2, z + 2, Blocks.tnt);
        world.setBlock(x + 3, y + 2, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y + 2, z + 4, Blocks.tnt);
        world.setBlock(x + 3, y + 2, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 3, y + 2, z + 6);
        world.setBlockToAir(x + 3, y + 3, z);
        world.setBlock(x + 3, y + 3, z + 1, NanotechBlock.nukeBuildingStairs, 2, 0);
        world.setBlock(x + 3, y + 3, z + 2, Blocks.tnt);
        world.setBlock(x + 3, y + 3, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y + 3, z + 4, Blocks.tnt);
        world.setBlock(x + 3, y + 3, z + 5, NanotechBlock.nukeBuildingStairs, 3, 0);
        world.setBlockToAir(x + 3, y + 3, z + 6);
        world.setBlockToAir(x + 3, y + 4, z);
        world.setBlock(x + 3, y + 4, z + 1, NanotechBlock.nukeBuilding, 4, 0);
        world.setBlock(x + 3, y + 4, z + 2, Blocks.tnt);
        world.setBlock(x + 3, y + 4, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y + 4, z + 4, Blocks.tnt);
        world.setBlock(x + 3, y + 4, z + 5, NanotechBlock.nukeBuilding, 2, 0);
        world.setBlockToAir(x + 3, y + 4, z + 6);
        world.setBlockToAir(x + 3, y + 5, z);
        world.setBlockToAir(x + 3, y + 5, z + 1);
        world.setBlock(x + 3, y + 5, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y + 5, z + 3, Blocks.tnt);
        world.setBlock(x + 3, y + 5, z + 4, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 3, y + 5, z + 5);
        world.setBlockToAir(x + 3, y + 5, z + 6);
        world.setBlockToAir(x + 3, y + 6, z);
        world.setBlockToAir(x + 3, y + 6, z + 1);
        world.setBlock(x + 3, y + 6, z + 2, NanotechBlock.nukeBuildingStairs, 2, 0);
        world.setBlock(x + 3, y + 6, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y + 6, z + 4, NanotechBlock.nukeBuildingStairs, 3, 0);
        world.setBlockToAir(x + 3, y + 6, z + 5);
        world.setBlockToAir(x + 3, y + 6, z + 6);
        world.setBlockToAir(x + 3, y + 7, z);
        world.setBlockToAir(x + 3, y + 7, z + 1);
        world.setBlockToAir(x + 3, y + 7, z + 2);
        world.setBlock(x + 3, y + 7, z + 3, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 3, y + 7, z + 4);
        world.setBlockToAir(x + 3, y + 7, z + 5);
        world.setBlockToAir(x + 3, y + 7, z + 6);
        world.setBlockToAir(x + 3, y + 8, z);
        world.setBlock(x + 3, y + 8, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 3, y + 8, z + 2, NanotechBlock.nukeBuildingStairs, 3, 0);
        world.setBlockToAir(x + 3, y + 8, z + 3);
        world.setBlock(x + 3, y + 8, z + 4, NanotechBlock.nukeBuildingStairs, 2, 0);
        world.setBlock(x + 3, y + 8, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 3, y + 8, z + 6);
        world.setBlock(x + 4, y - 4, z, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 3, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 4, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 4, y - 3, z, Blocks.stone);
        world.setBlock(x + 4, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 4, y - 3, z + 2, Blocks.stone);
        world.setBlock(x + 4, y - 3, z + 3, NanotechBlock.nukeBuildingStairs, 5, 0);
        world.setBlock(x + 4, y - 3, z + 4, Blocks.stone);
        world.setBlock(x + 4, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 4, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 4, y - 2, z, Blocks.dirt);
        world.setBlock(x + 4, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 4, y - 2, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 2, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 2, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 4, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 4, y - 1, z, Blocks.dirt);
        world.setBlock(x + 4, y - 1, z + 1, NanotechBlock.nukeBuildingStairs, 6, 0);
        world.setBlock(x + 4, y - 1, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 1, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 1, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y - 1, z + 5, NanotechBlock.nukeBuildingStairs, 7, 0);
        world.setBlock(x + 4, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 4, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 4, y, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y, z + 2, Blocks.tnt);
        world.setBlock(x + 4, y, z + 3, Blocks.tnt);
        world.setBlock(x + 4, y, z + 4, Blocks.tnt);
        world.setBlock(x + 4, y, z + 5, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 4, y + 1, z);
        world.setBlock(x + 4, y + 1, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 1, z + 2, Blocks.tnt);
        world.setBlock(x + 4, y + 1, z + 3, Blocks.tnt);
        world.setBlock(x + 4, y + 1, z + 4, Blocks.tnt);
        world.setBlock(x + 4, y + 1, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 4, y + 1, z + 6);
        world.setBlockToAir(x + 4, y + 2, z);
        world.setBlock(x + 4, y + 2, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 2, z + 2, Blocks.tnt);
        world.setBlock(x + 4, y + 2, z + 3, Blocks.tnt);
        world.setBlock(x + 4, y + 2, z + 4, Blocks.tnt);
        world.setBlock(x + 4, y + 2, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 4, y + 2, z + 6);
        world.setBlockToAir(x + 4, y + 3, z);
        world.setBlock(x + 4, y + 3, z + 1, NanotechBlock.nukeBuildingStairs, 2, 0);
        world.setBlock(x + 4, y + 3, z + 2, Blocks.tnt);
        world.setBlock(x + 4, y + 3, z + 3, Blocks.tnt);
        world.setBlock(x + 4, y + 3, z + 4, Blocks.tnt);
        world.setBlock(x + 4, y + 3, z + 5, NanotechBlock.nukeBuildingStairs, 3, 0);
        world.setBlockToAir(x + 4, y + 3, z + 6);
        world.setBlockToAir(x + 4, y + 4, z);
        world.setBlockToAir(x + 4, y + 4, z + 1);
        world.setBlock(x + 4, y + 4, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 4, z + 3, Blocks.tnt);
        world.setBlock(x + 4, y + 4, z + 4, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 4, y + 4, z + 5);
        world.setBlockToAir(x + 4, y + 4, z + 6);
        world.setBlockToAir(x + 4, y + 5, z);
        world.setBlockToAir(x + 4, y + 5, z + 1);
        world.setBlock(x + 4, y + 5, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 5, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 5, z + 4, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 4, y + 5, z + 5);
        world.setBlockToAir(x + 4, y + 5, z + 6);
        world.setBlockToAir(x + 4, y + 6, z);
        world.setBlockToAir(x + 4, y + 6, z + 1);
        world.setBlockToAir(x + 4, y + 6, z + 2);
        world.setBlock(x + 4, y + 6, z + 3, NanotechBlock.nukeBuildingStairs, 1, 0);
        world.setBlockToAir(x + 4, y + 6, z + 4);
        world.setBlockToAir(x + 4, y + 6, z + 5);
        world.setBlockToAir(x + 4, y + 6, z + 6);
        world.setBlockToAir(x + 4, y + 7, z);
        world.setBlockToAir(x + 4, y + 7, z + 1);
        world.setBlockToAir(x + 4, y + 7, z + 2);
        world.setBlockToAir(x + 4, y + 7, z + 3);
        world.setBlockToAir(x + 4, y + 7, z + 4);
        world.setBlockToAir(x + 4, y + 7, z + 5);
        world.setBlockToAir(x + 4, y + 7, z + 6);
        world.setBlockToAir(x + 4, y + 8, z);
        world.setBlock(x + 4, y + 8, z + 1, NanotechBlock.nukeBuilding);
        world.setBlock(x + 4, y + 8, z + 2, NanotechBlock.nukeBuilding, 7, 0);
        world.setBlock(x + 4, y + 8, z + 3, NanotechBlock.nukeBuildingStairs);
        world.setBlock(x + 4, y + 8, z + 4, NanotechBlock.nukeBuilding, 8, 0);
        world.setBlock(x + 4, y + 8, z + 5, NanotechBlock.nukeBuilding);
        world.setBlockToAir(x + 4, y + 8, z + 6);
        world.setBlock(x + 5, y - 4, z, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 3, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 5, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 5, y - 3, z, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 2, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 3, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 4, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 5, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 5, y - 2, z, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 2, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 3, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 4, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 5, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 5, y - 1, z, Blocks.dirt);
        world.setBlock(x + 5, y - 1, z + 1, Blocks.dirt);
        world.setBlock(x + 5, y - 1, z + 2, NanotechBlock.nukeBuildingStairs, 5, 0);
        world.setBlock(x + 5, y - 1, z + 3, NanotechBlock.nukeBuildingStairs, 5, 0);
        world.setBlock(x + 5, y - 1, z + 4, NanotechBlock.nukeBuildingStairs, 5, 0);
        world.setBlock(x + 5, y - 1, z + 5, Blocks.dirt);
        world.setBlock(x + 5, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 5, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 5, y, z + 1, NanotechBlock.nukeBuilding, 6, 0);
        world.setBlock(x + 5, y, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y, z + 5, NanotechBlock.nukeBuilding, 5, 0);
        world.setBlock(x + 5, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 5, y + 1, z);
        world.setBlock(x + 5, y + 1, z + 1, NanotechBlock.nukeBuilding, 6, 0);
        world.setBlock(x + 5, y + 1, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 1, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 1, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 1, z + 5, NanotechBlock.nukeBuilding, 5, 0);
        world.setBlockToAir(x + 5, y + 1, z + 6);
        world.setBlockToAir(x + 5, y + 2, z);
        world.setBlock(x + 5, y + 2, z + 1, NanotechBlock.nukeBuilding, 6, 0);
        world.setBlock(x + 5, y + 2, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 2, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 2, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 2, z + 5, NanotechBlock.nukeBuilding, 5, 0);
        world.setBlockToAir(x + 5, y + 2, z + 6);
        world.setBlockToAir(x + 5, y + 3, z);
        world.setBlockToAir(x + 5, y + 3, z + 1);
        world.setBlock(x + 5, y + 3, z + 2, NanotechBlock.nukeBuildingStairs, 1, 0);
        world.setBlock(x + 5, y + 3, z + 3, NanotechBlock.nukeBuildingStairs, 1, 0);
        world.setBlock(x + 5, y + 3, z + 4, NanotechBlock.nukeBuildingStairs, 1, 0);
        world.setBlockToAir(x + 5, y + 3, z + 5);
        world.setBlockToAir(x + 5, y + 3, z + 6);
        world.setBlockToAir(x + 5, y + 4, z);
        world.setBlockToAir(x + 5, y + 4, z + 1);
        world.setBlockToAir(x + 5, y + 4, z + 2);
        world.setBlock(x + 5, y + 4, z + 3, NanotechBlock.nukeBuilding, 1, 0);
        world.setBlockToAir(x + 5, y + 4, z + 4);
        world.setBlockToAir(x + 5, y + 4, z + 5);
        world.setBlockToAir(x + 5, y + 4, z + 6);
        world.setBlockToAir(x + 5, y + 5, z);
        world.setBlockToAir(x + 5, y + 5, z + 1);
        world.setBlockToAir(x + 5, y + 5, z + 2);
        world.setBlockToAir(x + 5, y + 5, z + 3);
        world.setBlockToAir(x + 5, y + 5, z + 4);
        world.setBlockToAir(x + 5, y + 5, z + 5);
        world.setBlockToAir(x + 5, y + 5, z + 6);
        world.setBlockToAir(x + 5, y + 6, z);
        world.setBlockToAir(x + 5, y + 6, z + 1);
        world.setBlockToAir(x + 5, y + 6, z + 2);
        world.setBlockToAir(x + 5, y + 6, z + 3);
        world.setBlockToAir(x + 5, y + 6, z + 4);
        world.setBlockToAir(x + 5, y + 6, z + 5);
        world.setBlockToAir(x + 5, y + 6, z + 6);
        world.setBlockToAir(x + 5, y + 7, z);
        world.setBlockToAir(x + 5, y + 7, z + 1);
        world.setBlockToAir(x + 5, y + 7, z + 2);
        world.setBlockToAir(x + 5, y + 7, z + 3);
        world.setBlockToAir(x + 5, y + 7, z + 4);
        world.setBlockToAir(x + 5, y + 7, z + 5);
        world.setBlockToAir(x + 5, y + 7, z + 6);
        world.setBlockToAir(x + 5, y + 8, z);
        world.setBlock(x + 5, y + 8, z + 1, NanotechBlock.nukeBuilding, 6, 0);
        world.setBlock(x + 5, y + 8, z + 2, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 8, z + 3, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 8, z + 4, NanotechBlock.nukeBuilding);
        world.setBlock(x + 5, y + 8, z + 5, NanotechBlock.nukeBuilding, 5, 0);
        world.setBlockToAir(x + 5, y + 8, z + 6);
        world.setBlock(x + 6, y - 4, z, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 1, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 2, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 3, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 4, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 5, Blocks.stone);
        world.setBlock(x + 6, y - 4, z + 6, Blocks.stone);
        world.setBlock(x + 6, y - 3, z, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 1, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 2, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 3, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 4, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 5, Blocks.stone);
        world.setBlock(x + 6, y - 3, z + 6, Blocks.stone);
        world.setBlock(x + 6, y - 2, z, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 1, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 2, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 3, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 4, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 5, Blocks.dirt);
        world.setBlock(x + 6, y - 2, z + 6, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 1, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 2, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 3, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 4, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 5, Blocks.dirt);
        world.setBlock(x + 6, y - 1, z + 6, Blocks.dirt);
        world.setBlock(x + 6, y, z, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 1, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 2, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 3, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 4, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 5, NanotechBlock.nanoGrass);
        world.setBlock(x + 6, y, z + 6, NanotechBlock.nanoGrass);
        world.setBlockToAir(x + 6, y + 1, z);
        world.setBlockToAir(x + 6, y + 1, z + 1);
        world.setBlockToAir(x + 6, y + 1, z + 2);
        world.setBlockToAir(x + 6, y + 1, z + 3);
        world.setBlockToAir(x + 6, y + 1, z + 4);
        world.setBlockToAir(x + 6, y + 1, z + 5);
        world.setBlockToAir(x + 6, y + 1, z + 6);
        world.setBlockToAir(x + 6, y + 2, z);
        world.setBlockToAir(x + 6, y + 2, z + 1);
        world.setBlockToAir(x + 6, y + 2, z + 2);
        world.setBlockToAir(x + 6, y + 2, z + 3);
        world.setBlockToAir(x + 6, y + 2, z + 4);
        world.setBlockToAir(x + 6, y + 2, z + 5);
        world.setBlockToAir(x + 6, y + 2, z + 6);
        world.setBlockToAir(x + 6, y + 3, z);
        world.setBlockToAir(x + 6, y + 3, z + 1);
        world.setBlockToAir(x + 6, y + 3, z + 2);
        world.setBlockToAir(x + 6, y + 3, z + 3);
        world.setBlockToAir(x + 6, y + 3, z + 4);
        world.setBlockToAir(x + 6, y + 3, z + 5);
        world.setBlockToAir(x + 6, y + 3, z + 6);
        world.setBlockToAir(x + 6, y + 4, z);
        world.setBlockToAir(x + 6, y + 4, z + 1);
        world.setBlockToAir(x + 6, y + 4, z + 2);
        world.setBlockToAir(x + 6, y + 4, z + 3);
        world.setBlockToAir(x + 6, y + 4, z + 4);
        world.setBlockToAir(x + 6, y + 4, z + 5);
        world.setBlockToAir(x + 6, y + 4, z + 6);
        world.setBlockToAir(x + 6, y + 5, z);
        world.setBlockToAir(x + 6, y + 5, z + 1);
        world.setBlockToAir(x + 6, y + 5, z + 2);
        world.setBlockToAir(x + 6, y + 5, z + 3);
        world.setBlockToAir(x + 6, y + 5, z + 4);
        world.setBlockToAir(x + 6, y + 5, z + 5);
        world.setBlockToAir(x + 6, y + 5, z + 6);
        world.setBlockToAir(x + 6, y + 6, z);
        world.setBlockToAir(x + 6, y + 6, z + 1);
        world.setBlockToAir(x + 6, y + 6, z + 2);
        world.setBlockToAir(x + 6, y + 6, z + 3);
        world.setBlockToAir(x + 6, y + 6, z + 4);
        world.setBlockToAir(x + 6, y + 6, z + 5);
        world.setBlockToAir(x + 6, y + 6, z + 6);
        world.setBlockToAir(x + 6, y + 7, z);
        world.setBlockToAir(x + 6, y + 7, z + 1);
        world.setBlockToAir(x + 6, y + 7, z + 2);
        world.setBlockToAir(x + 6, y + 7, z + 3);
        world.setBlockToAir(x + 6, y + 7, z + 4);
        world.setBlockToAir(x + 6, y + 7, z + 5);
        world.setBlockToAir(x + 6, y + 7, z + 6);
        world.setBlockToAir(x + 6, y + 8, z);
        world.setBlockToAir(x + 6, y + 8, z + 1);
        world.setBlockToAir(x + 6, y + 8, z + 2);
        world.setBlockToAir(x + 6, y + 8, z + 3);
        world.setBlockToAir(x + 6, y + 8, z + 4);
        world.setBlockToAir(x + 6, y + 8, z + 5);
        world.setBlockToAir(x + 6, y + 8, z + 6);
        world.setBlock(x + 3, y - 2, z + 3, NanotechBlock.nukeBuilding, 9, 0);
        return true;
    }
}