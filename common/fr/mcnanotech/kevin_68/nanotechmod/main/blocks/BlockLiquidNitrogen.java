/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;

public class BlockLiquidNitrogen extends BlockFluidClassic
{
    private IIcon flowingIcon;

    public BlockLiquidNitrogen(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setTickRandomly(true);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return (side == 0 || side == 1) ? blockIcon : flowingIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        blockIcon = register.registerIcon(this.getTextureName() + "_still");
        flowingIcon = register.registerIcon(this.getTextureName() + "_flow");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if(world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if(world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityLivingBase && !world.isRemote)
        {
            EntityLivingBase living = (EntityLivingBase)entity;
            if(this.doEffect(living))
                living.addPotionEffect(new PotionEffect(NanotechOther.freeze.id, 500, 0));
        }

        if(entity instanceof EntityFishHook && !(entity instanceof EntityReinforcedFishingHook) && !world.isRemote)
        {
            EntityFishHook fishHook = (EntityFishHook)entity;
            fishHook.setDead();
        }
    }

    private boolean doEffect(EntityLivingBase living)
    {
        if(living instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)living;
            ItemStack helmet = player.getCurrentArmor(3);
            ItemStack chestPlate = player.getCurrentArmor(2);
            ItemStack leggings = player.getCurrentArmor(1);
            ItemStack boots = player.getCurrentArmor(0);
            if(helmet != null && chestPlate != null && leggings != null && boots != null)
            {
                if(helmet.getItem().equals(NanotechItem.mysteriousHelmet) && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && boots.getItem().equals(NanotechItem.mysteriousBoots))
                {
                    return false;
                }
                if(Loader.isModLoaded("UltimateGraviSuite"))
                {
                    Item ultiHelmet = GameRegistry.findItem("UltimateGraviSuite", "ultimateHelmet");
                    Item ultiChestPlate = GameRegistry.findItem("UltimateGraviSuite", "ultimateGraviChestPlate");
                    Item ultiLeggings = GameRegistry.findItem("UltimateGraviSuite", "ultimateLeggings");
                    Item ultiBoots = GameRegistry.findItem("UltimateGraviSuite", "ultimateBoots");
                    if(helmet.getItem() == ultiHelmet && chestPlate.getItem() == ultiChestPlate && leggings.getItem() == ultiLeggings && boots.getItem() == ultiBoots)
                    {
                        return false;
                    }
                }
            }
        }

        if(living instanceof MobThedeath)
        {
            return false;
        }
        return true;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if(world.isAirBlock(x, y + 1, z))
        {
            float f = (float)x + random.nextFloat();
            float f1 = (float)y + random.nextFloat() * 0.5F + 0.5F;
            float f2 = (float)z + random.nextFloat();
            world.spawnParticle("cloud", (double)f, (double)f1, (double)f2, 0.0D, 0.1D, 0.0D);
        }
    }

    public void checkUpdate(World world, int x, int y, int z)
    {
        if(!world.isRemote)
        {
            for(int x1 = -3; x1 < 4; x1++)
            {
                for(int y1 = -3; y1 < 4; y1++)
                {
                    for(int z1 = -3; z1 < 4; z1++)
                    {
                        boolean dofreeze = true;
                        // x - z
                        if((x1 == -3 && z1 == -3) || (x1 == -2 && z1 == -3) || (x1 == -3 && z1 == -2) || (x1 == 3 && z1 == 3) || (x1 == 3 && z1 == 2) || (x1 == 2 && z1 == 3) || (x1 == 3 && z1 == -3) || (x1 == 3 && z1 == -2) || (x1 == 2 && z1 == -3) || (x1 == -3 && z1 == 3) || (x1 == -3 && z1 == 2) || (x1 == -2 && z1 == 3)
                        // x - y
                        || (x1 == -3 && y1 == -3) || (x1 == -2 && y1 == -3) || (x1 == -3 && y1 == -2) || (x1 == 3 && y1 == 3) || (x1 == 3 && y1 == 2) || (x1 == 2 && y1 == 3) || (x1 == 3 && y1 == -3) || (x1 == 3 && y1 == -2) || (x1 == 2 && y1 == -3) || (x1 == -3 && y1 == 3) || (x1 == -3 && y1 == 2) || (x1 == -2 && y1 == 3)
                        // y - z
                        || (y1 == -3 && z1 == -3) || (y1 == -2 && z1 == -3) || (y1 == -3 && z1 == -2) || (y1 == 3 && z1 == 3) || (y1 == 3 && z1 == 2) || (y1 == 2 && z1 == 3) || (y1 == 3 && z1 == -3) || (y1 == 3 && z1 == -2) || (y1 == 2 && z1 == -3) || (y1 == -3 && z1 == 3) || (y1 == -3 && z1 == 2) || (y1 == -2 && z1 == 3))
                        {
                            dofreeze = false;
                        }
                        if(dofreeze)
                        {
                            if(world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.fire))
                            {
                                world.setBlockToAir(x + x1, y + y1, z + z1);
                            }
                            if(world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.lava))
                            {
                                world.setBlock(x + x1, y + y1, z + z1, Blocks.obsidian);
                            }
                            if(world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.flowing_lava))
                            {
                                if(world.getBlockMetadata(x + x1, y + y1, z + z1) == 0)
                                {
                                    world.setBlock(x + x1, y + y1, z + z1, Blocks.obsidian);
                                }
                                else
                                {
                                    world.setBlock(x + x1, y + y1, z + z1, Blocks.cobblestone);
                                }
                            }
                            if(world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.flowing_water) || world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.water))
                            {
                                world.setBlock(x + x1, y + y1, z + z1, Blocks.ice);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.checkUpdate(world, x, y, z);
        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        if(world.provider.isHellWorld)
        {
            world.setBlockToAir(x, y, z);
        }
        else
        {
            this.checkUpdate(world, x, y, z);
            super.onBlockAdded(world, x, y, z);
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        this.checkUpdate(world, x, y, z);
        super.updateTick(world, x, y, z, rand);
    }
}