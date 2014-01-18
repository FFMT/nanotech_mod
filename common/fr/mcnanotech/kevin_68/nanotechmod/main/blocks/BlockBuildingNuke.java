package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.NewExplosion;

public class BlockBuildingNuke extends Block
{
	public static String[] type = new String[] {"full", "half1", "half2", "half3", "half4", "quarter1", "quarter2", "quarter3", "quarter4", "nuke"};

	public BlockBuildingNuke(int id)
	{
		super(id, Material.iron);
		this.setHardness(Block.blockIron.blockHardness);
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) == 0 || world.getBlockMetadata(x, y, z) == 9)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if(world.getBlockMetadata(x, y, z) == 1)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
		}

		if(world.getBlockMetadata(x, y, z) == 2)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
		}

		if(world.getBlockMetadata(x, y, z) == 3)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if(world.getBlockMetadata(x, y, z) == 4)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
		}

		if(world.getBlockMetadata(x, y, z) == 5)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.5F);
		}

		if(world.getBlockMetadata(x, y, z) == 6)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 1.0F, 1.0F);
		}

		if(world.getBlockMetadata(x, y, z) == 7)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
		}

		if(world.getBlockMetadata(x, y, z) == 8)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
	{
		if(world.getBlockMetadata(x, y, z) == 0 || world.getBlockMetadata(x, y, z) == 9)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 1)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 2)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 3)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 4)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 5)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 6)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 7)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

		if(world.getBlockMetadata(x, y, z) == 8)
		{
			this.setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}

	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		if(!world.isRemote)
		{
			if(world.getBlockMetadata(x, y, z) == 9)
			{
				NewExplosion explosion = new NewExplosion(world, null, x, y, z, 50.0F, 0.0F);
				explosion.doExplosion();
				world.newExplosion(null, x, y, z, 15, true, true);
			}
		}
	}

	public int idDropped(int metadata, Random rand, int par3)
	{
		return Item.ingotIron.itemID;
	}

	public int quantityDropped(Random rand)
	{
		return 1;
	}

	protected boolean canSilkHarvest()
	{
		return false;
	}
}
