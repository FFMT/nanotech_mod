package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class BlockNanoportal extends BlockPortal 
{
	public BlockNanoportal(int id, int texture)
	{
		super(id, texture);
		this.setTickRandomly(true);
	}

	public String getTextureFile() 
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		super.updateTick(world, x, y, z, rand);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
	{
		if (entity.ridingEntity == null && entity.riddenByEntity == null)
		{
			if (entity.dimension != Nanotech_mod.dimension)
			{
				entity.travelToDimension(Nanotech_mod.dimension);
			} 
			else 
			{
				entity.travelToDimension(0);
			}
		}
	}

    public boolean tryToCreatePortal(World world, int x, int y, int z)
    {
        byte var5 = 0;
        byte var6 = 0;

        if (world.getBlockId(x - 1, y, z) == NanotechBlock.BlockPortalframe.blockID || world.getBlockId(x + 1, y, z) == NanotechBlock.BlockPortalframe.blockID)
        {
            var5 = 1;
        }

        if (world.getBlockId(x, y, z - 1) == NanotechBlock.BlockPortalframe.blockID || world.getBlockId(x, y, z + 1) == NanotechBlock.BlockPortalframe.blockID)
        {
            var6 = 1;
        }

        if (var5 == var6)
        {
            return false;
        }
        else
        {
            if (world.getBlockId(x - var5, y, z - var6) == 0)
            {
                x -= var5;
                z -= var6;
            }

            int var7;
            int var8;

            for (var7 = -1; var7 <= 2; ++var7)
            {
                for (var8 = -1; var8 <= 3; ++var8)
                {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3)
                    {
                        int var10 = world.getBlockId(x + var5 * var7, y + var8, z + var6 * var7);

                        if (var9)
                        {
                            if (var10 != NanotechBlock.BlockPortalframe.blockID)
                            {
                                return false;
                            }
                        }
                        else if (var10 != 0 && var10 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            world.editingBlocks = true;

            for (var7 = 0; var7 < 2; ++var7)
            {
                for (var8 = 0; var8 < 3; ++var8)
                {
                    world.setBlockWithNotify(x + var5 * var7, y + var8, z + var6 * var7, NanotechBlock.BlockPortal.blockID);
                }
            }

            world.editingBlocks = false;
            return true;
        }
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        byte var6 = 0;
        byte var7 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            var6 = 1;
            var7 = 0;
        }

        int var8;

        for (var8 = par3; par1World.getBlockId(par2, var8 - 1, par4) == this.blockID; --var8)
        {
            ;
        }

        if (par1World.getBlockId(par2, var8 - 1, par4) != NanotechBlock.BlockPortalframe.blockID)
        {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
        else
        {
            int var9;

            for (var9 = 1; var9 < 4 && par1World.getBlockId(par2, var8 + var9, par4) == this.blockID; ++var9)
            {
                ;
            }

            if (var9 == 3 && par1World.getBlockId(par2, var8 + var9, par4) == NanotechBlock.BlockPortalframe.blockID)
            {
                boolean var10 = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean var11 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (var10 && var11)
                {
                    par1World.setBlockWithNotify(par2, par3, par4, 0);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + var6, par3, par4 + var7) != NanotechBlock.BlockPortalframe.blockID || par1World.getBlockId(par2 - var6, par3, par4 - var7) != this.blockID) && (par1World.getBlockId(par2 - var6, par3, par4 - var7) != NanotechBlock.BlockPortalframe.blockID || par1World.getBlockId(par2 + var6, par3, par4 + var7) != this.blockID))
                    {
                        par1World.setBlockWithNotify(par2, par3, par4, 0);
                    }
                }
            }
            else
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }
        }
    }
}