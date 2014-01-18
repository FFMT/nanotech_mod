package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockJumper extends ItemBlock
{
	public ItemBlockJumper(int id)
	{
		super(id);
		setHasSubtypes(true);
	}

	public int getMetadata(int metadata)
	{
		return metadata;
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		if(stack.getItemDamage() == 1)
		{
			return getUnlocalizedName() + "advanced";
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}