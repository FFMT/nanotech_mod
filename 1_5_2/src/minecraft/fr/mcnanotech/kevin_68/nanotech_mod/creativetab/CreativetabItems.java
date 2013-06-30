package fr.mcnanotech.kevin_68.nanotech_mod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.items.NanotechItem;

public class CreativetabItems extends CreativeTabs
{
	public CreativetabItems(String name)
	{
		super(name);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return NanotechItem.Nanomitebow.itemID;
	}
}