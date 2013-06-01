package fr.mcnanotech.kevin_68.nanotech_mod.utils;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class Util_creativetabblock extends CreativeTabs	
{
	public Util_creativetabblock(String par1)
	{
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return NanotechBlock.BlockSpeed.blockID;
	}
}