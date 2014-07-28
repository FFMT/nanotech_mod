/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFastZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperCreeper;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityFakeGold;

public class BlockFakeOre extends Block
{
    public static String[] type = new String[] {"fakegold", "fakediamond"};

    public BlockFakeOre()
    {
        super(Material.rock);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {}

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 0)
        {
            return Blocks.gold_ore.getIcon(0, 0);
        }
        else
        {
            return Blocks.diamond_ore.getIcon(0, 0);
        }
    }

    @Override
    public int damageDropped(int metadata)
    {
        return metadata;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
        {
            list.add(new ItemStack(item, 1, metadatanumber));
        }
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        if(world.getBlockMetadata(x, y, z) == 0)
        {
            if(!world.isRemote)
            {
                world.setBlockToAir(x, y, z);
                EntityFakeGold fakegold = new EntityFakeGold(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F));
                world.spawnEntityInWorld(fakegold);
                world.playSoundAtEntity(fakegold, "random.fuse", 1.0F, 1.0F);
            }
        }

        else if(world.getBlockMetadata(x, y, z) == 1)
        {
            teleportNearby(world, x, y, z);
            if(!world.isRemote)
            {
                MobFastZombie zombie = new MobFastZombie(world);
                zombie.setPosition(x, y, z);
                world.spawnEntityInWorld(zombie);
                zombie.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
                MobSuperCreeper creeper = new MobSuperCreeper(world);
                creeper.setPosition(x, y, z);
                world.spawnEntityInWorld(creeper);
                MobSuperSkeleton skeleton = new MobSuperSkeleton(world);
                skeleton.setPosition(x, y, z);
                world.spawnEntityInWorld(skeleton);
                skeleton.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
                creeper.mountEntity(zombie);
                skeleton.mountEntity(creeper);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        onBlockClicked(world, x, y, z, player);
        teleportNearby(world, x, y, z);
        return true;
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion)
    {
        return false;
    }

    @Override
    public int tickRate(World world)
    {
        return 5;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if(world.getBlockMetadata(x, y, z) == 1)
        {
            world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        fallIfPossible(world, x, y, z);
    }

    private void fallIfPossible(World world, int x, int y, int z)
    {
        // canFallBelow
        if(BlockFalling.func_149831_e(world, x, y - 1, z) && y >= 0 && world.getBlockMetadata(x, y, z) == 1)
        {
            byte var5 = 32;

            if(!BlockFalling.fallInstantly && world.checkChunksExist(x - var5, y - var5, z - var5, x + var5, y + var5, z + var5))
            {
                EntityFallingBlock fallingblock = new EntityFallingBlock(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this, 1);
                world.spawnEntityInWorld(fallingblock);
            }
            else
            {
                world.setBlockToAir(x, y, z);

                while(BlockSand.func_149831_e(world, x, y - 1, z) && y > 0)
                {
                    --y;
                }

                if(y > 0)
                {
                    world.setBlock(x, y, z, this, 1, 3);
                }
            }
        }
    }

    private void teleportNearby(World world, int x, int y, int z)
    {
        if(world.getBlock(x, y, z) == this && world.getBlockMetadata(x, y, z) == 1)
        {
            for(int var5 = 0; var5 < 1000; ++var5)
            {
                int var6 = x + world.rand.nextInt(16) - world.rand.nextInt(16);
                int var7 = y + world.rand.nextInt(8) - world.rand.nextInt(8);
                int var8 = z + world.rand.nextInt(16) - world.rand.nextInt(16);

                if(world.isAirBlock(var6, var7, var8))
                {
                    if(!world.isRemote)
                    {
                        world.setBlock(var6, var7, var8, this, 1, 3);
                        world.setBlockToAir(x, y, z);
                    }
                    else
                    {
                        for(int var10 = 0; var10 < 128; ++var10)
                        {
                            double var11 = world.rand.nextDouble();
                            float var13 = (world.rand.nextFloat() - 0.5F) * 0.2F;
                            float var14 = (world.rand.nextFloat() - 0.5F) * 0.2F;
                            float var15 = (world.rand.nextFloat() - 0.5F) * 0.2F;
                            double var16 = (double)var6 + (double)(x - var6) * var11 + (world.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
                            double var18 = (double)var7 + (double)(y - var7) * var11 + world.rand.nextDouble() * 1.0D - 0.5D;
                            double var20 = (double)var8 + (double)(z - var8) * var11 + (world.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
                            world.spawnParticle("portal", var16, var18, var20, (double)var13, (double)var14, (double)var15);
                        }
                    }
                    return;
                }
            }
        }
    }
}