package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockLeaves;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class Block_nanoleaves extends BlockLeaves implements IShearable 
{

	protected Block_nanoleaves(int par1, int par2) 
	{
		super(par1, par2);
		this.setTickRandomly(true);
	}
	
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return -1;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int par1)
    {
        return -1;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return !this.graphicsLevel;
    }
	
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }
	
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(20) == 0 ? 1 : 0;
    }
 
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Nanotech_mod.Block_nanosaplings.blockID;
    }
    
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (!par1World.isRemote)
        {
            byte var8 = 20;

            if ((par5 & 3) == 3)
            {
                var8 = 40;
            }

            if (par1World.rand.nextInt(var8) == 0)
            {
                int var9 = this.idDropped(par5, par1World.rand, par7);
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(var9, 1, this.damageDropped(par5)));
            }
        }
    }
    @Override
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }
    
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return -1;
    }
}
