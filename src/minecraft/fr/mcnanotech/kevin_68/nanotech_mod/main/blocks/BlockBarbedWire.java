package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBarbedWire extends Block
{
	public BlockBarbedWire(int id)
	{
		super(id, Material.iron);
	}
	
    public void registerIcons(IconRegister iconregister)
    {
        blockIcon = iconregister.registerIcon("Nanotech_mod:barbedwire");
    }

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			entity.setInWeb();
			entity.attackEntityFrom(DamageSource.cactus, 2);
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	public int getRenderType()
	{
		return 1;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
}
