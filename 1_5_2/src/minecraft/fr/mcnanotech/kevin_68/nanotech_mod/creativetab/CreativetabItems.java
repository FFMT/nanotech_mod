package fr.mcnanotech.kevin_68.nanotech_mod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativetabItems extends CreativeTabs
{
	public CreativetabItems(String par1)
	{
		super(par1);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Item.redstone.itemID;
	}
}