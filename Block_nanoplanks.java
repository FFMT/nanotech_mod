package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Block_nanoplanks extends Block
{
    public Block_nanoplanks(int par1, int par2)
    {
        super(par1, par2, Material.wood);
    }
 
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }
}
