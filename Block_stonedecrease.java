package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Block_stonedecrease extends Block 
{
    public Block_stonedecrease(int par1, int par2)
    {
        super(par1, par2, Material.rock);
        this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
    }
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }


    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
}
