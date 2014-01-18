package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSatelite extends ItemBlock
{
	public ItemBlockSatelite(int id)
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
		if(stack.getItemDamage() < BlockSat.type.length)
		{
			return "tile." + BlockSat.type[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}