package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockNukeBuildingBlock extends ItemBlock
{
	public ItemBlockNukeBuildingBlock(int id)
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
		if(stack.getItemDamage() < BlockBuildingNuke.type.length)
		{
			return "tile." + BlockBuildingNuke.type[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}