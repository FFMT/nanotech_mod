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
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityButton;

public class BlockSat extends Block
{
    public static String[] type = new String[] {"monitor", "pad", "padActive", "padError"};
    private IIcon monitorSide, screenFine, screenAlert, screenError;

    public BlockSat()
    {
        super(Material.iron);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconregister)
    {
        blockIcon = iconregister.registerIcon(this.getTextureName() + "empty");
        monitorSide = iconregister.registerIcon(this.getTextureName() + "monitorside");
        screenFine = iconregister.registerIcon(this.getTextureName() + "screenfine");
        screenAlert = iconregister.registerIcon(this.getTextureName() + "screenalert");
        screenError = iconregister.registerIcon(this.getTextureName() + "screenerror");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess blockaccess, int x, int y, int z, int side)
    {
        if(blockaccess.getBlockMetadata(x, y, z) == 1 || blockaccess.getBlockMetadata(x, y, z) == 2 || blockaccess.getBlockMetadata(x, y, z) == 3)
        {
            return blockIcon;

        }
        else
        {
            if(blockaccess.getBlock(x - 1, y, z).equals(this) && blockaccess.getBlockMetadata(x - 1, y, z) != 0)
            {
                if(side == 4)
                {
                    if(blockaccess.getBlockMetadata(x - 1, y, z) == 2)
                    {
                        return screenAlert;
                    }
                    else if(blockaccess.getBlockMetadata(x - 1, y, z) == 3)
                    {
                        return screenError;
                    }
                    else
                    {
                        return screenFine;
                    }
                }
                else
                {
                    return monitorSide;
                }
            }
            if(blockaccess.getBlock(x + 1, y, z).equals(this) && blockaccess.getBlockMetadata(x + 1, y, z) != 0)
            {
                if(side == 5)
                {
                    if(blockaccess.getBlockMetadata(x + 1, y, z) == 2)
                    {
                        return screenAlert;
                    }
                    else if(blockaccess.getBlockMetadata(x + 1, y, z) == 3)
                    {
                        return screenError;
                    }
                    else
                    {
                        return screenFine;
                    }
                }
                else
                {
                    return monitorSide;
                }
            }
            if(blockaccess.getBlock(x, y, z - 1).equals(this) && blockaccess.getBlockMetadata(x, y, z - 1) != 0)
            {
                if(side == 2)
                {
                    if(blockaccess.getBlockMetadata(x, y, z - 1) == 2)
                    {
                        return screenAlert;
                    }
                    else if(blockaccess.getBlockMetadata(x, y, z - 1) == 3)
                    {
                        return screenError;
                    }
                    else
                    {
                        return screenFine;
                    }
                }
                else
                {
                    return monitorSide;
                }
            }
            if(blockaccess.getBlock(x, y, z + 1).equals(this) && blockaccess.getBlockMetadata(x, y, z + 1) != 0)
            {
                if(side == 3)
                {
                    if(blockaccess.getBlockMetadata(x, y, z + 1) == 2)
                    {
                        return screenAlert;
                    }
                    else if(blockaccess.getBlockMetadata(x, y, z + 1) == 3)
                    {
                        return screenError;
                    }
                    else
                    {
                        return screenFine;
                    }
                }
                else
                {
                    return monitorSide;
                }
            }

            else
            {
                return monitorSide;
            }
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        if(metadata == 1 || metadata == 2 || metadata == 3)
        {
            return new TileEntityButton();
        }
        return null;
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        if(metadata == 1 || metadata == 2 || metadata == 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        if(world.getBlockMetadata(x, y, z) == 1 || world.getBlockMetadata(x, y, z) == 2 || world.getBlockMetadata(x, y, z) == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        if(world.getBlockMetadata(x, y, z) == 1 || world.getBlockMetadata(x, y, z) == 2 || world.getBlockMetadata(x, y, z) == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
            super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
    {
        if(!world.isRemote)
        {
            if(world.getBlockMetadata(x, y, z) == 1)
            {
                TileEntity te = world.getTileEntity(x, y, z);
                if(te instanceof TileEntityButton)
                {
                    TileEntityButton tile = (TileEntityButton)te;
                    tile.crashSatelite();
                    return true;
                }
            }
        }
        return false;
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
        return 0;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return false;
    }

    @Override
    public int damageDropped(int metadata)
    {
        return 5;
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int par3)
    {
        return NanotechItem.itemBase;
    }

    public int quantityDropped(Random rand)
    {
        return 1;
    }
}