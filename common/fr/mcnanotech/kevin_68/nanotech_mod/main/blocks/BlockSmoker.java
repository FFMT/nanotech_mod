package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class BlockSmoker extends BlockContainer
{
	public BlockSmoker(int id)
	{
		super(id, Material.rock);
		setTickRandomly(true);
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		TileEntitySmoker tilesmoker = (TileEntitySmoker)world.getBlockTileEntity(x, y, z);

		for(int i = 0; i < tilesmoker.getSmokeValue() * 2; i++)
		{
			float f = (float)x + random.nextFloat();
			float f1 = (float)y + random.nextFloat() * 0.5F + 0.5F;
			float f2 = (float)z + random.nextFloat();
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.002D * i, 0.0D);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if(tileentity == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(Nanotech_mod.modInstance, 1, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySmoker();
	}

}