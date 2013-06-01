package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockFakeOre extends ItemBlock
{

	public ItemBlockFakeOre(int id)
	{
		super(id);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata)
    {
        return metadata;
    }
	
	public String getItemNameIS(ItemStack stack) 
	{
		if(stack.getItemDamage() < BlockFakeOre.type.length)
		{
			return "tile." + BlockFakeOre.type[stack.getItemDamage()];
		}
		else
		{
			return getItemName();
		}
	}

}
