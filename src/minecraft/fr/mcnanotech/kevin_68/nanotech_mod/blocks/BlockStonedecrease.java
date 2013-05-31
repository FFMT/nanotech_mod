package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.Random;

import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockStonedecrease extends Block 
{
    public BlockStonedecrease(int id, int texture)
    {
        super(id, texture, Material.rock);
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
