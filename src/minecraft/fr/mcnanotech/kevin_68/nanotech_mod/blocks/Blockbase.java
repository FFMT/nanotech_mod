package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blockbase extends Block
{

	public Blockbase(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}
	
	public String getTextureFile()
    {
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }

}
