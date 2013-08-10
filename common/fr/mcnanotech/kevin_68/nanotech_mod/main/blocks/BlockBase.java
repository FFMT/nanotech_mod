package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBase extends Block
{
	public BlockBase(int id, Material material)
	{
		super(id, material);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:" + getUnlocalizedName().substring(5));
	}
}
