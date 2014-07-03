package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachines extends ItemBlock
{
	public ItemBlockMachines(Block block)
	{
		super(block);
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < BlockMachines.subName.length)
		{
			return getUnlocalizedName() + "." + BlockMachines.subName[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}
