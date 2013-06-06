package fr.mcnanotech.kevin_68.nanotech_mod.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UtilCreativetabItems extends CreativeTabs	
{
	public UtilCreativetabItems(String par1)
	{
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Item.redstone.itemID;
	}
}