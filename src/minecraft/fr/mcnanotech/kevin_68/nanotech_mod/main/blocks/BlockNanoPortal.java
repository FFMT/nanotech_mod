package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class BlockNanoPortal extends Block
{
	public BlockNanoPortal(int id)
	{
		super(id, Material.portal);
		this.setTickRandomly(true);
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(0.75F);
		this.setBlockBounds(0.0F, 0.40F, 0.0F, 1.0F, 0.60F, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
	{
		super.onNeighborBlockChange(world, x, y, z, par5);
		if(world.getBlockId(x - 1, y, z) != NanotechBlock.BlockPortalframe.blockID && world.getBlockId(x + 1, y, z) != NanotechBlock.BlockPortalframe.blockID && world.getBlockId(x, y - 1, z) != NanotechBlock.BlockPortalframe.blockID && world.getBlockId(x, y + 1, z) != NanotechBlock.BlockPortalframe.blockID)
		{
			world.setBlockToAir(x, y, z);
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if((entity.ridingEntity == null) && (entity.riddenByEntity == null))
		{
			if(entity.dimension != Nanotech_mod.dimensionID)
			{
				if(entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
					thePlayer.timeUntilPortal = 10;
				}
				entity.travelToDimension(Nanotech_mod.dimensionID);
			}
			else
			{
				if(entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
					thePlayer.timeUntilPortal = 10;
				}
				entity.travelToDimension(0);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("Nanotech_mod:nanoportal");
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return 0;
	}
}