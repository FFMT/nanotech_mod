/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrashCan;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class BlockTrashcan extends Block
{
	public BlockTrashcan()
	{
		super(Material.iron);
	}

	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotechmodcity:trash_can");
	}

	@SuppressWarnings("rawtypes")
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

	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityTrashCan();
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return FFMTClientRegistry.tesrRenderId;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
}