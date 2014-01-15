package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class BlockSmoker extends BlockContainer
{
	public BlockSmoker(int id)
	{
		super(id, Material.rock);
		setTickRandomly(true);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if(tileentity == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(NanotechMod.modInstance, 1, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySmoker();
	}
}