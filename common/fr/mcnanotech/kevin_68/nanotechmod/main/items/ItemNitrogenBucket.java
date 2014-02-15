package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class ItemNitrogenBucket extends ItemBucket
{
	public ItemNitrogenBucket(Block fluid)
	{
		super(fluid);
	}

	public boolean tryPlaceContainedLiquid(World world, int x, int y, int z)
	{
		Material material = world.getBlock(x, y, z).getMaterial();
		boolean flag = !material.isSolid();

		if(!world.isAirBlock(x, y, z) && !flag)
		{
			return false;
		}
		else
		{
			if(world.provider.isHellWorld)
			{
				world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

				for(int l = 0; l < 8; ++l)
				{
					world.spawnParticle("cloud", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			}
			else
			{
				if(!world.isRemote && flag && !material.isLiquid())
				{
					world.func_147480_a(x, y, z, true);
				}
				world.setBlock(x, y, z, NanotechBlock.liquidNitrogen, 0, 3);
			}
			return true;
		}
	}
}