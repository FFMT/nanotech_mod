/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;

public class BlockSodium extends Block
{
    public BlockSodium()
    {
        super(Material.rock);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.checkdoexplode(world, x, y, z);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float var5 = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)((float)(y + 1) - var5), (double)((float)(z + 1) - var5));
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityLivingBase)
        {
            entity.attackEntityFrom(NanotechDamageSource.sodiumDamage, 1.0F);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        this.checkdoexplode(world, x, y, z);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
    {
        if(!world.isRemote)
        {
            world.setBlockToAir(x, y, z);
            float power = (float)world.rand.nextInt(10) - 4.5F;
            if(power < 2.5F)
            {
                power = 5F;
            }
            EntityTNTPrimed tnt = new EntityTNTPrimed(world);
            world.createExplosion(tnt, x, y, z, power, true);
            world.notifyBlockChange(x, y, z, Blocks.air);
        }
    }

    public void checkdoexplode(World world, int x, int y, int z)
    {
        if(world.getBlock(x, y - 1, z).equals(Blocks.water) || world.getBlock(x, y + 1, z).equals(Blocks.water) || world.getBlock(x - 1, y, z).equals(Blocks.water) || world.getBlock(x + 1, y, z).equals(Blocks.water) || world.getBlock(x, y, z - 1).equals(Blocks.water) || world.getBlock(x, y, z + 1).equals(Blocks.water) || world.getBlock(x, y - 1, z).equals(Blocks.flowing_water) || world.getBlock(x, y + 1, z).equals(Blocks.flowing_water) || world.getBlock(x - 1, y, z).equals(Blocks.flowing_water) || world.getBlock(x + 1, y, z).equals(Blocks.flowing_water) || world.getBlock(x, y, z - 1).equals(Blocks.flowing_water) || world.getBlock(x, y, z + 1).equals(Blocks.flowing_water))
        {
            if(!world.isRemote)
            {
                world.setBlockToAir(x, y, z);
                float power = (float)world.rand.nextInt(15) - 5.5F;
                if(power < 2.5F)
                {
                    power = 5F;
                }
                EntityTNTPrimed tnt = new EntityTNTPrimed(world);
                world.newExplosion(tnt, x, y, z, power, true, true);
                world.notifyBlockChange(x, y, z, Blocks.air);
            }
        }

        if(world.isAirBlock(x, y - 1, z) || world.isAirBlock(x, y + 1, z) || world.isAirBlock(x - 1, y, z) || world.isAirBlock(x + 1, y, z) || world.isAirBlock(x, y, z - 1) || world.isAirBlock(x, y, z + 1))
        {
            if(!world.isRemote)
            {
                int i = world.rand.nextInt(2);
                if(world.isAirBlock(x, y + 1, z) && i == 1)
                {
                    world.setBlock(x, y + 1, z, Blocks.fire, 0, 3);
                }
            }
        }
    }
}