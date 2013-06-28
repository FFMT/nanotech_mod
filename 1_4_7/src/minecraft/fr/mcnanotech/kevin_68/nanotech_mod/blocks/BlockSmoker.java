package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntitySmoker;

public class BlockSmoker extends BlockContainer
{
	public BlockSmoker(int id, int texture)
	{
		super(id, texture, Material.rock);
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		TileEntitySmoker tilesmoker = new TileEntitySmoker();
		int var6;
		float var7;
		float var8;
		float var9;

		if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && !Block.fire.canBlockCatchFire(par1World, par2, par3 - 1, par4, UP))
		{
			if (Block.fire.canBlockCatchFire(par1World, par2 - 1, par3, par4, EAST))
			{
				for (var6 = 0; var6 < 2; ++var6)
				{
					var7 = (float) par2 + par5Random.nextFloat() * 0.1F;
					var8 = (float) par3 + par5Random.nextFloat();
					var9 = (float) par4 + par5Random.nextFloat();
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Block.fire.canBlockCatchFire(par1World, par2 + 1, par3, par4, WEST))
			{
				for (var6 = 0; var6 < 2; ++var6)
				{
					var7 = (float) (par2 + 1) - par5Random.nextFloat() * 0.1F;
					var8 = (float) par3 + par5Random.nextFloat();
					var9 = (float) par4 + par5Random.nextFloat();
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Block.fire.canBlockCatchFire(par1World, par2, par3, par4 - 1, SOUTH))
			{
				for (var6 = 0; var6 < 2; ++var6)
				{
					var7 = (float) par2 + par5Random.nextFloat();
					var8 = (float) par3 + par5Random.nextFloat();
					var9 = (float) par4 + par5Random.nextFloat() * 0.1F;
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Block.fire.canBlockCatchFire(par1World, par2, par3, par4 + 1, NORTH))
			{
				for (var6 = 0; var6 < 2; ++var6)
				{
					var7 = (float) par2 + par5Random.nextFloat();
					var8 = (float) par3 + par5Random.nextFloat();
					var9 = (float) (par4 + 1) - par5Random.nextFloat() * 0.1F;
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Block.fire.canBlockCatchFire(par1World, par2, par3 + 1, par4, DOWN))
			{
				for (var6 = 0; var6 < 2; ++var6)
				{
					var7 = (float) par2 + par5Random.nextFloat();
					var8 = (float) (par3 + 1) - par5Random.nextFloat() * 0.1F;
					var9 = (float) par4 + par5Random.nextFloat();
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.0D, 0.0D);
				}
			}
		}
		else
		{
			for (var6 = 0; var6 < 3; ++var6)
			{
				var7 = (float) par2 + par5Random.nextFloat();
				var8 = (float) par3 + par5Random.nextFloat() * 0.1F;
				var9 = (float) par4 + par5Random.nextFloat();
				if (tilesmoker.getSmokePower() >= 1)
				{
					par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, 0.0D);
					if (tilesmoker.getSmokePower() >= 2)
					{
						par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, 0.0D);
						if (tilesmoker.getSmokePower() >= 3)
						{
							par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, 0.0D);
							if (tilesmoker.getSmokePower() >= 4)
							{
								par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, 0.1D);
								if (tilesmoker.getSmokePower() >= 5)
								{
									par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, -0.1D);
									if (tilesmoker.getSmokePower() >= 6)
									{
										par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, 0.1D);
										if (tilesmoker.getSmokePower() >= 7)
										{
											par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, -0.1D);
											if (tilesmoker.getSmokePower() >= 8)
											{
												par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, 0.1D);
												if (tilesmoker.getSmokePower() >= 9)
												{
													par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, -0.1D);
													if (tilesmoker.getSmokePower() >= 10)
													{
														par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.15D, 0.0D);
														if (tilesmoker.getSmokePower() >= 11)
														{
															par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.17D, 0.0D);
															if (tilesmoker.getSmokePower() >= 12)
															{
																par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.2D, 0.0D);
																if (tilesmoker.getSmokePower() >= 13)
																{
																	par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.25D, 0.0D);
																	if (tilesmoker.getSmokePower() >= 14)
																	{
																		par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.3D, 0.0D);
																		if (tilesmoker.getSmokePower() >= 15)
																		{
																			par1World.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.35D, 0.0D);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);

		if (tileentity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(Nanotech_mod.modInstance, 1, world, x, y, z);

		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
		super.breakBlock(world, x, y, z, i, j);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySmoker();
	}

}