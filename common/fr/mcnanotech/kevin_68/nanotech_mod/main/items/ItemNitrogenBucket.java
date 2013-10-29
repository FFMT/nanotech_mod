package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;

public class ItemNitrogenBucket extends ItemBucket
{
	public ItemNitrogenBucket(int id, int fluidId)
	{
		super(id, fluidId);
	}
	
	public boolean tryPlaceContainedLiquid(World par1World, int par2, int par3, int par4)
    {
            Material material = par1World.getBlockMaterial(par2, par3, par4);
            boolean flag = !material.isSolid();

            if (!par1World.isAirBlock(par2, par3, par4) && !flag)
            {
                return false;
            }
            else
            {
                if (par1World.provider.isHellWorld)
                {
                    par1World.playSoundEffect((double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l)
                    {
                        par1World.spawnParticle("largesmoke", (double)par2 + Math.random(), (double)par3 + Math.random(), (double)par4 + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                else
                {
                    if (!par1World.isRemote && flag && !material.isLiquid())
                    {
                        par1World.destroyBlock(par2, par3, par4, true);
                    }

                    par1World.setBlock(par2, par3, par4, NanotechBlock.BlockLiquidNitrogen.blockID, 0, 3);
                }

                return true;
            }
        
    }
}