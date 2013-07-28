package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockFalling extends ItemBlock
{

	public ItemBlockFalling(int id)
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
		if(stack.getItemDamage() < BlockFalling.type.length)
		{
			return getUnlocalizedName() + BlockFalling.type[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}

}
