package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechDamageSource;

public class ItemNitrogenBucket extends ItemBucket
{
	public ItemNitrogenBucket(int id, int fluidId)
	{
		super(id, fluidId);
	}

	public boolean tryPlaceContainedLiquid(World world, int x, int y, int z)
	{
		Material material = world.getBlockMaterial(x, y, z);
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
					world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			}
			else
			{
				if(!world.isRemote && flag && !material.isLiquid())
				{
					world.destroyBlock(x, y, z, true);
				}
				world.setBlock(x, y, z, NanotechBlock.liquidNitrogen.blockID, 0, 3);
			}
			return true;
		}
	}
}