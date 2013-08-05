package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityFakeGold;

public class BlockFakeOre extends Block
{
	public static String[] type = new String[]
	{"fakegold", "fakediamond"};

	public BlockFakeOre(int id)
	{
		super(id, Material.rock);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(metadata == 0)
		{
			return Block.oreGold.getIcon(0, 0);
		}
		else
		{
			return Block.oreDiamond.getIcon(0, 0);
		}
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		if(world.getBlockMetadata(x, y, z) == 0)
		{
			if(!world.isRemote)
			{
				world.setBlock(x, y, z, 0);
				EntityFakeGold fakegold = new EntityFakeGold(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F));
				world.spawnEntityInWorld(fakegold);
				world.playSoundAtEntity(fakegold, "random.fuse", 1.0F, 1.0F);
			}
		}

		else if(world.getBlockMetadata(x, y, z) == 1)
		{
			teleportNearby(world, x, y, z);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		onBlockClicked(world, x, y, z, player);
		teleportNearby(world, x, y, z);
		return true;
	}

	public boolean canDropFromExplosion(Explosion explosion)
	{
		return false;
	}

	public int tickRate()
	{
		return 5;
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, blockID, tickRate());
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		if(world.getBlockMetadata(x, y, z) == 1)
		{
			world.scheduleBlockUpdate(x, y, z, blockID, tickRate());
		}
	}

	public void updateTick(World world, int x, int y, int z, Random random)
	{
		fallIfPossible(world, x, y, z);
	}

	private void fallIfPossible(World world, int x, int y, int z)
	{
		if(BlockSand.canFallBelow(world, x, y - 1, z) && y >= 0 && world.getBlockMetadata(x, y, z) == 1)
		{
			byte var5 = 32;

			if(!BlockSand.fallInstantly && world.checkChunksExist(x - var5, y - var5, z - var5, x + var5, y + var5, z + var5))
			{
				EntityFallingSand fallingblock = new EntityFallingSand(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), blockID, 1);
				world.spawnEntityInWorld(fallingblock);
			}
			else
			{
				world.setBlockToAir(x, y, z);

				while(BlockSand.canFallBelow(world, x, y - 1, z) && y > 0)
				{
					--y;
				}

				if(y > 0)
				{
					world.setBlock(x, y, z, blockID, 1, 3);
				}
			}
		}
	}

	private void teleportNearby(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y, z) == blockID && world.getBlockMetadata(x, y, z) == 1)
		{
			for(int var5 = 0; var5 < 1000; ++var5)
			{
				int var6 = x + world.rand.nextInt(16) - world.rand.nextInt(16);
				int var7 = y + world.rand.nextInt(8) - world.rand.nextInt(8);
				int var8 = z + world.rand.nextInt(16) - world.rand.nextInt(16);

				if(world.getBlockId(var6, var7, var8) == 0)
				{
					if(!world.isRemote)
					{
						world.setBlock(var6, var7, var8, blockID, 1, 3);
						world.setBlockToAir(x, y, z);
					}
					else
					{
						for(int var10 = 0; var10 < 128; ++var10)
						{
							double var11 = world.rand.nextDouble();
							float var13 = (world.rand.nextFloat() - 0.5F) * 0.2F;
							float var14 = (world.rand.nextFloat() - 0.5F) * 0.2F;
							float var15 = (world.rand.nextFloat() - 0.5F) * 0.2F;
							double var16 = (double)var6 + (double)(x - var6) * var11 + (world.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
							double var18 = (double)var7 + (double)(y - var7) * var11 + world.rand.nextDouble() * 1.0D - 0.5D;
							double var20 = (double)var8 + (double)(z - var8) * var11 + (world.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
							world.spawnParticle("portal", var16, var18, var20, (double)var13, (double)var14, (double)var15);
						}
					}

					return;
				}
			}
		}
	}

}
