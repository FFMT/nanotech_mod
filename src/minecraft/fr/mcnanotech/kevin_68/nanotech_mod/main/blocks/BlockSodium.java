package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockSodium extends Block
{
	public BlockSodium(int id, Material material)
	{
		super(id, material);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:sodium");
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.checkdoexplode(world, x, y, z);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float var5 = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)((float)(y + 1) - var5), (double)((float)(z + 1) - var5));
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLiving)
		{
			entity.attackEntityFrom(DamageSource.cactus, 1);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
	{
		super.onNeighborBlockChange(world, x, y, z, par5);
		this.checkdoexplode(world, x, y, z);
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		if(!world.isRemote)
		{
			world.setBlockToAir(x, y, z);
			float power = (float)world.rand.nextInt(10) - 4.5F;
			if(power < 2.5F)
			{
				power = 5F;
			}
			EntityTNTPrimed tnt = new EntityTNTPrimed(world);
			world.createExplosion(tnt, x, y, z, power, true);
			world.notifyBlockChange(x, y, z, 0);
		}
	}

	public void checkdoexplode(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y - 1, z) == Block.waterStill.blockID || world.getBlockId(x, y + 1, z) == Block.waterStill.blockID || world.getBlockId(x - 1, y, z) == Block.waterStill.blockID || world.getBlockId(x + 1, y, z) == Block.waterStill.blockID || world.getBlockId(x, y, z - 1) == Block.waterStill.blockID || world.getBlockId(x, y, z + 1) == Block.waterStill.blockID || world.getBlockId(x, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 1) == Block.waterMoving.blockID)
		{
			if(!world.isRemote)
			{
				world.setBlockToAir(x, y, z);
				float power = (float)world.rand.nextInt(15) - 5.5F;
				if(power < 2.5F)
				{
					power = 5F;
				}
				EntityTNTPrimed tnt = new EntityTNTPrimed(world);
				world.newExplosion(tnt, x, y, z, power, true, true);
				world.notifyBlockChange(x, y, z, 0);
			}
		}

		if(world.isAirBlock(x, y - 1, z) || world.isAirBlock(x, y + 1, z) || world.isAirBlock(x - 1, y, z) || world.isAirBlock(x + 1, y, z) || world.isAirBlock(x, y, z - 1) || world.isAirBlock(x, y, z + 1))
		{
			if(!world.isRemote)
			{
				int i = world.rand.nextInt(2);
				if(world.isAirBlock(x, y + 1, z) && i == 1)
				{
					world.setBlock(x, y + 1, z, Block.fire.blockID, 0, 3);
				}
			}
		}
	}
}
