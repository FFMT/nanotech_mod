package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockFalling;

public class ItemBlockLamp extends ItemBlock
{

	public ItemBlockLamp(int id)
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