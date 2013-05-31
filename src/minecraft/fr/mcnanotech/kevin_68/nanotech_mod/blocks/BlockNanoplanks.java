package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNanoplanks extends Block
{
    public BlockNanoplanks(int id, int texture)
    {
        super(id, texture, Material.wood);
    }
 
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }
}
