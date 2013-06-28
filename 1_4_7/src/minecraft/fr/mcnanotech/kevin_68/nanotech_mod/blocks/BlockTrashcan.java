package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockTrashcan extends Block
{
	public BlockTrashcan(int id)
	{
		super(id, Material.iron);
		this.blockIndexInTexture = 9;
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? 9 : (par1 == 0 ? 11 : 10);
	}

	public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollidingBlockToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		float var8 = 0.125F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
		super.addCollidingBlockToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
		super.addCollidingBlockToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollidingBlockToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
		super.addCollidingBlockToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBoundsForItemRender();
	}

	public void setBlockBoundsForItemRender()
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityItem)
		{
			entity.setDead();
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
