package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
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
        blockIcon = iconregister.registerIcon("Nanotech_mod:trash_can_side");
        topIcon = iconregister.registerIcon("Nanotech_mod:trash_can_top");
        bottomIcon = iconregister.registerIcon("Nanotech_mod:trash_can_bottom");
    }

	public Icon getIcon(int side, int damage)
	{
		return side == 1 ? topIcon : (side == 0 ?  bottomIcon : blockIcon);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		float var8 = 0.125F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
		super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
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
