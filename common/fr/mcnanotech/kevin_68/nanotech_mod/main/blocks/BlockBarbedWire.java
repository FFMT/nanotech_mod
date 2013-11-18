package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechDamageSource;

public class BlockBarbedWire extends Block
{
	public BlockBarbedWire(int id)
	{
		super(id, Material.iron);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLivingBase)
		{
			entity.setInWeb();
			entity.attackEntityFrom(NanotechDamageSource.barbedWireDamage, 2);
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
}