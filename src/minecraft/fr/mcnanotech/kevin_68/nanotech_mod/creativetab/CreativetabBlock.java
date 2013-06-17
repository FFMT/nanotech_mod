package fr.mcnanotech.kevin_68.nanotech_mod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class CreativetabBlock extends CreativeTabs
{
	public CreativetabBlock(String par1)
	{
		super(par1);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return NanotechBlock.BlockSpeed.blockID;
	}
}