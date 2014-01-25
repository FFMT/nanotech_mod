package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock
{
	public ItemBlockMachine(int id)
	{
		super(id);
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		if(stack.getItemDamage() >= 0 && stack.getItemDamage() < BlockNanotechMachine.subName.length)
		{
			return getUnlocalizedName() + "." + BlockNanotechMachine.subName[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}