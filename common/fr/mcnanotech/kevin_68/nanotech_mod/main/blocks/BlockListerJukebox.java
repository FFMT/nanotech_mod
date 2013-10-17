package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;

public class BlockListerJukebox extends BlockContainer
{
	public BlockListerJukebox(int par1, Material par2Material)
	{
		super(par1, par2Material);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityListerJukebox();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}

		if(!world.isRemote)
		player.openGui(Nanotech_mod.modInstance, 3, world, x, y, z);

		return true;
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		world.playRecord((String)null, x, y, z);
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion)
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
}