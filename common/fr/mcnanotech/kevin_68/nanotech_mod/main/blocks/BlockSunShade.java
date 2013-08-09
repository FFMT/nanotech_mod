package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySunShade;

public class BlockSunShade extends Block
{
	public static String[] type = new String[]{"sunshade", "empty", "emptyFlat", "emptyTop"};
	public Icon stick;

	public BlockSunShade(int id, Material material)
	{
		super(id, material);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) 
	{
		if (metadata == 0)
		{
			return new TileEntitySunShade();
		}
		else
		{
			return null;
		}
	}

	public boolean hasTileEntity(int metadata)
	{
		if (metadata == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderType()
	{
		return -1;
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) 
	{
		if (metadata == 0)
		{
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x, y + 1, z);
			if (world.getBlockMetadata(x, y + 2, z) == 1)
			{
				world.setBlockToAir(x, y + 2, z);
			}
			else if (world.getBlockMetadata(x, y + 2, z) == 3)
			{
				for (int j = -1; j < 2; ++j)
				{
					for (int k = -1; k < 2; ++k)
					{
						if (world.getBlockId(x + j, y + 2, z + k) == this.blockID)
						{
							world.setBlockToAir(x + j, y + 2, z + k);
						}
					}
				}
			}
		}
		else if (metadata == 1 && world.getBlockMetadata(x, y - 1, z) == 0 && world.getBlockId(x, y - 1, z) == this.blockID)
		{
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x, y - 1, z);
			if (world.getBlockMetadata(x, y + 1, z) == 1)
			{
				world.setBlockToAir(x, y + 1, z);
			}
			else if (world.getBlockMetadata(x, y + 1, z) == 3)
			{
				for (int j = -1; j < 2; ++j)
				{
					for (int k = -1; k < 2; ++k)
					{
						if (world.getBlockId(x + j, y + 1, z + k) == this.blockID)
						{
							world.setBlockToAir(x + j, y + 1, z + k);
						}
					}
				}
			}
		}
		else if (world.getBlockMetadata(x, y - 2, z) == 0 && world.getBlockId(x, y - 2, z) == this.blockID)
		{
			world.setBlockToAir(x, y - 1, z);
			world.setBlockToAir(x, y - 2, z);
			if (metadata == 1)
			{
				world.setBlockToAir(x, y, z);
			}
			else if (metadata == 3)
			{
				for (int j = -1; j < 2; ++j)
				{
					for (int k = -1; k < 2; ++k)
					{
						if (world.getBlockId(x + j, y, z + k) == this.blockID)
						{
							world.setBlockToAir(x + j, y, z + k);
						}
					}
				}
			}
		}
		else if (metadata == 2)
		{
			world.setBlock(x, y, z, this.blockID, 2, 1);
		}
		else
		{
			super.onBlockDestroyedByPlayer(world, x, y, z, metadata);
		}
	}    

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion) 
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, world.getBlockMetadata(x, y, z));
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return NanotechItem.lamp.itemID;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return NanotechItem.lamp.itemID;
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("cloth_0"); // for particles
		stick = iconregister.registerIcon("tree_side"); // for particles
	}	

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(metadata == 2)
		{
			return blockIcon;
		}
		else
		{
			return stick;
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		if (blockAccess.getBlockMetadata(x, y, z) == 0 || blockAccess.getBlockMetadata(x, y, z) == 1)
		{
			float f = 0.375F;
			float f1 = 0.625F;
			float f2 = 0.375F;
			float f3 = 0.625F;
			this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
		}
		else if (blockAccess.getBlockMetadata(x, y, z) == 2)
		{
			this.setBlockBounds(0.0F, 0.85F, 0.0F, 1.0F, 0.95F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
