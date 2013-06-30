package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockConfusion extends Block
{
	public BlockConfusion(int id)
	{
		super(id, Material.iron);
	}
	
    public void registerIcons(IconRegister iconregister)
    {
    	blockIcon = iconregister.registerIcon("Nanotech_mod:confusion");
    }

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float var5 = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB((double) x - var5, (double) y - var5, (double) z - var5, (double) (x + 1) - var5, (double) ((float) (y + 1) - var5), (double) (z + 1) - var5);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityPlayer)
		{
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(9, 20, 10));
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(15, 200, 10));
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(2, 200, 10));
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(4, 200, 10));
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(17, 200, 10));
			((EntityPlayer)entity).addPotionEffect(new PotionEffect(20, 20, 10));
		}
	}
}
