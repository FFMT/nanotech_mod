package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockNotFalling extends ItemBlock
{

	public ItemBlockNotFalling(int par1)
	{
		super(par1);
		setHasSubtypes(true);
	}

	public int getMetadata(int metadata)
	{
		return metadata;
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		if(stack.getItemDamage() < BlockNotFalling.type.length)
		{
			return getUnlocalizedName() + BlockNotFalling.type[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}
