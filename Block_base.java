package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Block_base extends Block
{

	public Block_base(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}
	
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }

}
