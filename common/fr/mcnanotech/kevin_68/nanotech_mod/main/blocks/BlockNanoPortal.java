package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.UtilEntityTeleporter;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.NanotechTeleporter;

public class BlockNanoPortal extends Block
{
	public BlockNanoPortal(int id)
	{
		super(id, Material.portal);
		this.setTickRandomly(true);
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(0.75F);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int x, int y, int z)
	{
		float f;
		float f1;

		if(iblockaccess.getBlockId(x - 1, y, z) != this.blockID && iblockaccess.getBlockId(x + 1, y, z) != this.blockID)
		{
			f = 0.125F;
			f1 = 0.5F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
		else
		{
			f = 0.5F;
			f1 = 0.125F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}

	public void setBlockBoundsForItemRender()
	{
		float f1 = 0.125F;
		this.setBlockBounds(0, 0.0F, 0.5F - f1, 1F, 1.0F, 0.5F + f1);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		int y2 = y;
		while(world.getBlockId(x, y2, z) == this.blockID)
		{
			y2--;
		}
		if(world.getBlockId(x, y2, z) != NanotechBlock.BlockPortalFrame.blockID)
		{
			world.setBlockToAir(x, y, z);
		}
		int y3 = y2 + 1;
		boolean portalisgood = false;
		if(world.getBlockId(x, y3, z + 1) == this.blockID)
		{
			portalisgood = (world.getBlockId(x, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2, z + 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 1, z + 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 2, z + 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 3, z + 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 1, z - 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 2, z - 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 3, z - 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z - 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID);
		}
		else if(world.getBlockId(x, y3, z - 1) == this.blockID)
		{
			portalisgood = (world.getBlockId(x, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2, z - 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 1, z - 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 2, z - 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 3, z - 2) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 1, z + 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 2, z + 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 3, z + 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z + 1) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID);
		}
		else if(world.getBlockId(x + 1, y3, z) == this.blockID)
		{
			portalisgood = (world.getBlockId(x, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 2, y2 + 1, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 2, y2 + 2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 2, y2 + 3, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 1, y2 + 1, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 1, y2 + 2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 1, y2 + 3, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID);
		}
		else if(world.getBlockId(x - 1, y3, z) == this.blockID)
		{
			portalisgood = (world.getBlockId(x, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 1, y2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 2, y2 + 1, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 2, y2 + 2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x - 2, y2 + 3, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2 + 1, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2 + 2, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2 + 3, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x + 1, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID && world.getBlockId(x, y2 + 4, z) == NanotechBlock.BlockPortalFrame.blockID);
		}

		if(!portalisgood)
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

	public int quantityDropped(Random random)
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
					EntityPlayerMP player = (EntityPlayerMP)entity;
					if(player.timeUntilPortal > 0)
					{
						player.timeUntilPortal = 10;
					}
					else
					{
						player.timeUntilPortal = 10;
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Nanotech_mod.dimensionID, new NanotechTeleporter(player.mcServer.worldServerForDimension(Nanotech_mod.dimensionID)));
					}
				}
				else
				{
					UtilEntityTeleporter.teleportToDim(entity, Nanotech_mod.dimensionID);
				}
			}
			else
			{
				if(entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP player = (EntityPlayerMP)entity;
					if(player.timeUntilPortal > 0)
					{
						player.timeUntilPortal = 10;
					}
					else
					{
						player.timeUntilPortal = 10;
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new NanotechTeleporter(player.mcServer.worldServerForDimension(0)));
					}
				}
				else
				{
					UtilEntityTeleporter.teleportToDim(entity, 0);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return 0;
	}

	public void breakBlock(World world, int x, int y, int z, int metadata, int side)
	{
		super.breakBlock(world, x, y, z, metadata, side);
		if(world.getBlockId(x, y + 1, z) == this.blockID)
		{
			world.setBlockToAir(x, y + 1, z);
		}
		if(world.getBlockId(x, y - 1, z) == this.blockID)
		{
			world.setBlockToAir(x, y - 1, z);
		}
		if(world.getBlockId(x + 1, y, z) == this.blockID)
		{
			world.setBlockToAir(x + 1, y, z);
		}
		if(world.getBlockId(x - 1, y, z) == this.blockID)
		{
			world.setBlockToAir(x - 1, y, z);
		}
		if(world.getBlockId(x, y, z + 1) == this.blockID)
		{
			world.setBlockToAir(x, y, z + 1);
		}
		if(world.getBlockId(x, y, z - 1) == this.blockID)
		{
			world.setBlockToAir(x, y, z - 1);
		}
	}
}