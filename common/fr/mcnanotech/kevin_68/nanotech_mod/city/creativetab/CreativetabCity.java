package fr.mcnanotech.kevin_68.nanotech_mod.city.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.items.NanotechCityItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class CreativetabCity extends CreativeTabs
{
	public CreativetabCity(String name)
	{
		super(name);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return NanotechCityItem.lamp.itemID;
	}
}