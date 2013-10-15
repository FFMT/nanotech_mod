package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockTrashcan extends Block
{
	public Icon topIcon;
	public Icon bottomIcon;

	public BlockTrashcan(int id)
	{
		super(id, Material.iron);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotech_mod_city:trash_can_side");
		topIcon = iconregister.registerIcon("nanotech_mod_city:trash_can_top");
		bottomIcon = iconregister.registerIcon("nanotech_mod_city:trash_can_bottom");
	}

	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? topIcon : (side == 0 ? bottomIcon : blockIcon);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedBB, List list, Entity entity)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		float var8 = 0.125F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		this.setBlockBounds(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		this.setBlockBounds(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		this.setBlockBoundsForItemRender();
	}

	public void setBlockBoundsForItemRender()
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		int prob = world.rand.nextInt(100);
		if(entity instanceof EntityItem)
		{
			if(!world.isRemote)
			{
				entity.setDead();
				if(prob < 15)
				{
					world.spawnEntityInWorld(new EntityXPOrb(world, (double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D, 1));
				}
			}
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