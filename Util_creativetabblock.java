package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Util_creativetabblock extends CreativeTabs	
{
	Util_creativetabblock(String par1)
	{
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Nanotech_mod.Block_booster.blockID;
	}
}