package fr.mcnanotech.kevin_68.nanotechmod.main.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;

public class CreativetabItems extends CreativeTabs
{
	public CreativetabItems(String name)
	{
		super(name);
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		return new ItemStack(NanotechItem.itemBase.itemID, 1, 12);
	}
}