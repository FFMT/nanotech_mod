package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockFalling;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSunShade extends ItemBlock
{

	public ItemBlockSunShade(int id)
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