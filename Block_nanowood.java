package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Block_nanowood extends BlockLog 
{
	public static final String[] woodType = new String[] {"nano"};
	public Block_nanowood(int par1) 
	{
		super(par1);

	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
 
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        int var3 = par2 & 12;
        int var4 = par2 & 3;
        return var3 == 0 && (par1 == 1 || par1 == 0) ? 15 : (var3 == 4 && (par1 == 5 || par1 == 4) ? 15 : (var3 == 8 && (par1 == 2 || par1 == 3) ? 15 : (var4 == 1 ? 116 : (var4 == 2 ? 117 : (var4 == 3 ? 153 : 14)))));
    }
 
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }
    
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
 
    }
    
    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
}
