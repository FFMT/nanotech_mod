package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityButton;

public class BlockSat extends Block
{
	public static String[] type = new String[] {"monitor", "pad", "padActive", "padError"};
	private Icon monitorSide;
	private Icon screenFine;
	private Icon screenAlert;
	private Icon screenError;

	public BlockSat(int id)
	{
		super(id, Material.iron);
		this.setHardness(3.0F);
		this.setResistance(2.0F);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotech_mod:empty");
		monitorSide = iconregister.registerIcon("nanotech_mod:monitorside");
		screenFine = iconregister.registerIcon("nanotech_mod:screenfine");
		screenAlert = iconregister.registerIcon("nanotech_mod:screenalert");
		screenError = iconregister.registerIcon("nanotech_mod:screenerror");
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		if(blockaccess.getBlockMetadata(x, y, z) == 1 || blockaccess.getBlockMetadata(x, y, z) == 2 || blockaccess.getBlockMetadata(x, y, z) == 3)
		{
			return blockIcon;

		}
		else
		{
			if(blockaccess.getBlockId(x - 1, y, z) == this.blockID && blockaccess.getBlockMetadata(x - 1, y, z) != 0)
			{
				if(side == 4)
				{
					if(blockaccess.getBlockMetadata(x - 1, y, z) == 2)
					{
						return screenAlert;
					}
					else if(blockaccess.getBlockMetadata(x - 1, y, z) == 3)
					{
						return screenError;
					}
					else
					{
						return screenFine;
					}
				}
				else
				{
					return monitorSide;
				}
			}
			if(blockaccess.getBlockId(x + 1, y, z) == this.blockID && blockaccess.getBlockMetadata(x + 1, y, z) != 0)
			{
				if(side == 5)
				{
					if(blockaccess.getBlockMetadata(x + 1, y, z) == 2)
					{
						return screenAlert;
					}
					else if(blockaccess.getBlockMetadata(x + 1, y, z) == 3)
					{
						return screenError;
					}
					else
					{
						return screenFine;
					}
				}
				else
				{
					return monitorSide;
				}
			}
			if(blockaccess.getBlockId(x, y, z - 1) == this.blockID && blockaccess.getBlockMetadata(x, y, z - 1) != 0)
			{
				if(side == 2)
				{
					if(blockaccess.getBlockMetadata(x, y, z - 1) == 2)
					{
						return screenAlert;
					}
					else if(blockaccess.getBlockMetadata(x, y, z - 1) == 3)
					{
						return screenError;
					}
					else
					{
						return screenFine;
					}
				}
				else
				{
					return monitorSide;
				}
			}
			if(blockaccess.getBlockId(x, y, z + 1) == this.blockID && blockaccess.getBlockMetadata(x, y, z + 1) != 0)
			{
				if(side == 3)
				{
					if(blockaccess.getBlockMetadata(x, y, z + 1) == 2)
					{
						return screenAlert;
					}
					else if(blockaccess.getBlockMetadata(x, y, z + 1) == 3)
					{
						return screenError;
					}
					else
					{
						return screenFine;
					}
				}
				else
				{
					return monitorSide;
				}
			}

			else
			{
				return monitorSide;
			}
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		if(metadata == 1 || metadata == 2 || metadata == 3)
		{
			return new TileEntityButton();
		}
		return null;
	}

	public boolean hasTileEntity(int metadata)
	{
		if(metadata == 1 || metadata == 2 || metadata == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) == 1 || world.getBlockMetadata(x, y, z) == 2 || world.getBlockMetadata(x, y, z) == 3)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
	{
		if(world.getBlockMetadata(x, y, z) == 1 || world.getBlockMetadata(x, y, z) == 2 || world.getBlockMetadata(x, y, z) == 3)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		if(!world.isRemote)
		{
			if(world.getBlockMetadata(x, y, z) == 1)
			{
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if(te instanceof TileEntityButton)
				{
					TileEntityButton tile = (TileEntityButton)te;
					tile.crashSatelite();
					return true;
				}
			}
		}
		return false;
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
		return 0;
	}

	protected boolean canSilkHarvest()
	{
		return false;
	}

	public int damageDropped(int metadata)
	{
		return 5;
	}

	public int idDropped(int metadata, Random rand, int par3)
	{
		return NanotechItem.itemBase.itemID;
	}

	public int quantityDropped(Random rand)
	{
		return 1;
	}
}