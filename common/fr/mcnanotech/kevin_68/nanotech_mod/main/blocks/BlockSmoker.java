package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:smoker");
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		TileEntitySmoker tilesmoker = (TileEntitySmoker)world.getBlockTileEntity(x, y, z);
		float f = (float)x + random.nextFloat();
		float f1 = (float)y + random.nextFloat() * 0.5F + 0.5F;
		float f2 = (float)z + random.nextFloat();

		if(tilesmoker.getSmokeValue() == 1)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.1D, 0.0D);
		if(tilesmoker.getSmokeValue() == 2)
			world.spawnParticle("largesmoke", (double)f, (double)f2, (double)f2, 0.1D, 0.1D, 0.0D);
		if(tilesmoker.getSmokeValue() == 3)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, -0.1D, 0.1D, 0.0D);
		if(tilesmoker.getSmokeValue() == 4)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.1D, 0.1D);
		if(tilesmoker.getSmokeValue() == 5)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.1D, -0.1D);
		if(tilesmoker.getSmokeValue() == 6)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.1D, 0.1D, 0.1D);
		if(tilesmoker.getSmokeValue() == 7)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, -0.1D, 0.1D, -0.1D);
		if(tilesmoker.getSmokeValue() == 8)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, -0.1D, 0.1D, 0.1D);
		if(tilesmoker.getSmokeValue() == 9)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.1D, 0.1D, -0.1D);
		if(tilesmoker.getSmokeValue() == 10)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.15D, 0.0D);
		if(tilesmoker.getSmokeValue() == 11)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.17D, 0.0D);
		if(tilesmoker.getSmokeValue() == 12)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.2D, 0.0D);
		if(tilesmoker.getSmokeValue() == 13)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.25D, 0.0D);
		if(tilesmoker.getSmokeValue() == 14)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.3D, 0.0D);
		if(tilesmoker.getSmokeValue() == 15)
			world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.35D, 0.0D);

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