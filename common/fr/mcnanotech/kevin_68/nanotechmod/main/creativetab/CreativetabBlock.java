package fr.mcnanotech.kevin_68.nanotechmod.main.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class CreativetabBlock extends CreativeTabs
{
	public CreativetabBlock(String name)
	{
		super(name);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return NanotechBlock.speed.blockID;
	}
}