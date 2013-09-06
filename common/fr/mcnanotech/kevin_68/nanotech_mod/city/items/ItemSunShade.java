package fr.mcnanotech.kevin_68.nanotech_mod.city.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;

public class ItemSunShade extends Item
{
	public ItemSunShade(int id)
	{
		super(id);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		if(player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack) && player.canPlayerEdit(x, y + 2, z, side, stack))
		{
			int i1 = world.getBlockId(x, y, z);
			boolean isReplaceable = (i1 == Block.vine.blockID || i1 == Block.tallGrass.blockID || i1 == Block.deadBush.blockID || (Block.blocksList[i1] != null & Block.blocksList[i1].isBlockReplaceable(world, x, y, z)));

			if(isReplaceable && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z))
			{
				world.setBlock(x, y, z, NanotechCityBlock.BlockSunShade.blockID, 0, 3);
				world.setBlock(x, y + 1, z, NanotechCityBlock.BlockSunShade.blockID, 1, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.BlockSunShade.blockID, 1, 3);
				--stack.stackSize;
				return true;
			}

			else if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 3, z) && side == 1 && player.canPlayerEdit(x, y + 3, z, side, stack))
			{
				world.setBlock(x, y + 1, z, NanotechCityBlock.BlockSunShade.blockID, 0, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.BlockSunShade.blockID, 1, 3);
				world.setBlock(x, y + 3, z, NanotechCityBlock.BlockSunShade.blockID, 1, 3);
				--stack.stackSize;
				return true;
			}
		}
		return false;
	}
}