package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Blockbase extends Block
{	
	public Blockbase(int id, Material material)
	{
		super(id, material);
	}
	
    public void registerIcons(IconRegister iconregister)
    {
        blockIcon = iconregister.registerIcon("Nanotech_mod:"+getUnlocalizedName2());
    }
}
