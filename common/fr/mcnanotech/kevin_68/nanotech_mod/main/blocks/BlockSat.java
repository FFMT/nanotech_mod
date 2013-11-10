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
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityButton;

public class BlockSat extends Block
{
	public static String[] type = new String[] {"monitor", "pad"};
	private Icon monitorSide;

	public BlockSat(int id)
	{
		super(id, Material.iron);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotech_mod:empty");
		monitorSide = iconregister.registerIcon("nanotech_mod:monitorside");
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		if(blockaccess.getBlockMetadata(x, y, z) == 1)
		{
			return blockIcon;
		}
		else
		{
			return monitorSide;
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		if(metadata == 1)
		{
			return new TileEntityButton();
		}
		return null;
	}

	public boolean hasTileEntity(int metadata)
	{
		if(metadata == 1)
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
		if(world.getBlockMetadata(x, y, z) == 1)
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
		if(world.getBlockMetadata(x, y, z) == 1)
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

	public int quantityDropped(Random rand)
	{
		return 0;
	}
}