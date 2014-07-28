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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrass extends Block
{
    private IIcon iconTop;
    private IIcon iconSnowSide;

    public BlockGrass()
    {
        super(Material.grass);
        this.setTickRandomly(true);
        this.setHarvestLevel("shovel", 2);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        return true;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconregister)
    {
        blockIcon = iconregister.registerIcon(this.getTextureName() + "_side");
        iconTop = iconregister.registerIcon(this.getTextureName() + "_top");
        iconSnowSide = iconregister.registerIcon(this.getTextureName() + "_side_snow");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? iconTop : (side == 0 ? Blocks.dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess blockaccess, int x, int y, int z, int side)
    {
        if(side == 1)
        {
            return iconTop;
        }
        else if(side == 0)
        {
            return Blocks.dirt.getBlockTextureFromSide(side);
        }
        else
        {
            Material material = blockaccess.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? blockIcon : iconSnowSide;
        }
    }

    public void updateTick(World world, int x, int y, int z, Random par5Random)
    {
        if(!world.isRemote)
        {
            if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            {
                world.setBlock(x, y, z, Blocks.dirt, 0, 3);
            }
            else if(world.getBlockLightValue(x, y + 1, z) >= 9)
            {
                for(int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = x + par5Random.nextInt(3) - 1;
                    int var8 = y + par5Random.nextInt(5) - 3;
                    int var9 = z + par5Random.nextInt(3) - 1;

                    if((world.getBlock(var7, var8, var9).equals(Blocks.dirt) && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlock(var7, var8, var9).equals(Blocks.grass) && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlock(var7, var8, var9).equals(Blocks.mycelium) && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlock(var7, var8, var9).equals(Blocks.farmland) && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2))
                    {
                        world.setBlock(var7, var8, var9, this, 0, 3);
                    }
                }
            }
        }
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int par3)
    {
        return Blocks.dirt.getItemDropped(0, random, par3);
    }
}