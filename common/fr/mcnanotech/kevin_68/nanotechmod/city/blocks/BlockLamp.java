/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLampLight;

public class BlockLamp extends Block
{
    public BlockLamp()
    {
        super(Material.iron);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if(world.getBlockMetadata(x, y, z) == 3)
        {
            return 15;
        }
        return 0;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        if(metadata == 0)
        {
            return new TileEntityLamp();
        }
        else if(metadata == 2 || metadata == 3)
        {
            return new TileEntityLampLight();
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        if(metadata == 0 || metadata == 2 || metadata == 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block bloc, int metadata)
    {
        for(int i = -3; i < 4; ++i)
        {
            if(world.getBlock(x, y + i, z).equals(this))
            {
                world.setBlockToAir(x, y + i, z);
            }
        }
        super.breakBlock(world, x, y, z, bloc, metadata);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return NanotechCityBlock.spotlight.getIcon(2, 0);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconregister)
    {}

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
    {
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    @Override
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
        super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
    }
}