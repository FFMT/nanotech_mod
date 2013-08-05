package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class ItemTrail extends Item
{
	public ItemTrail(int id)
	{
		super(id);
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("Nanotech_mod:itemTrail");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		int i1 = world.getBlockId(x, y, z);

		if(i1 == Block.snow.blockID && (world.getBlockMetadata(x, y, z) & 7) < 1)
		{
			par7 = 1;
		}
		else if(i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID)
		{
			if(par7 == 0)
			{
				--y;
			}

			if(par7 == 1)
			{
				++y;
			}

			if(par7 == 2)
			{
				--z;
			}

			if(par7 == 3)
			{
				++z;
			}

			if(par7 == 4)
			{
				--x;
			}

			if(par7 == 5)
			{
				++x;
			}
		}

		if(!player.canPlayerEdit(x, y, z, par7, stack))
		{
			return false;
		}
		else if(stack.stackSize == 0)
		{
			return false;
		}
		else
		{
			if(world.canPlaceEntityOnSide(NanotechBlock.BlockTrail.blockID, x, y, z, false, par7, (Entity)null, stack))
			{
				Block block = Block.blocksList[NanotechBlock.BlockTrail.blockID];
				int j1 = block.onBlockPlaced(world, x, y, z, par7, par8, par9, par10, 0);

				if(world.setBlock(x, y, z, NanotechBlock.BlockTrail.blockID, j1, 3))
				{
					if(world.getBlockId(x, y, z) == NanotechBlock.BlockTrail.blockID)
					{
						Block.blocksList[NanotechBlock.BlockTrail.blockID].onBlockPlacedBy(world, x, y, z, player, stack);
						Block.blocksList[NanotechBlock.BlockTrail.blockID].onPostBlockPlaced(world, x, y, z, j1);
					}

					world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
					--stack.stackSize;
				}
			}

			return true;
		}
	}
}
