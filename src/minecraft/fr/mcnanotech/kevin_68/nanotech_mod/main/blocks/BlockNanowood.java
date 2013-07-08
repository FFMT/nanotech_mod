package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockNanowood extends BlockLog
{
	private Icon topIcon;

	public BlockNanowood(int id)
	{
		super(id);
	}

	public int idDropped(int side, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
    public void registerIcons(IconRegister iconregister)
    {
        blockIcon = iconregister.registerIcon("Nanotech_mod:log");
        topIcon = iconregister.registerIcon("Nanotech_mod:log_top");
    }

	public Icon getIcon(int side, int par2)
	{
		int k = par2 & 12;
        return k == 0 && (side == 1 || side == 0) ? topIcon : (k == 4 && (side == 5 || side == 4) ? topIcon : (k == 8 && (side == 2 || side == 3) ? topIcon : blockIcon));
	}

	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(id, 1, 0));
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}
}
