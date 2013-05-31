package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
	
	public String getItemNameIS(ItemStack stack) 
	{
		if(stack.getItemDamage() < BlockFalling.type.length)
		{
			return getItemName() + BlockFalling.type[stack.getItemDamage()];
		}
		else
		{
			return getItemName();
		}
	}

}
