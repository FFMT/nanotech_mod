package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFalling extends BlockSand
{
	public static String[] type = new String[] {"stone", "stonebrick", "crackedstonebrick", "mossystonebrick", "chiseledstonebrick", "cobblestone", "mossycobblestone"};
	private Icon[] iconbuffer;

	public BlockFalling(int id, Material material)
	{
		super(id, material);
	}

	public void registerIcons(IconRegister iconRegister)
	{}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
		case 0:
			return Block.stone.getBlockTextureFromSide(side);
		case 1:
			return Block.stoneBrick.getIcon(side, 0);
		case 2:
			return Block.stoneBrick.getIcon(side, 1);
		case 3:
			return Block.stoneBrick.getIcon(side, 2);
		case 4:
			return Block.stoneBrick.getIcon(side, 3);
		case 5:
			return Block.cobblestone.getBlockTextureFromSide(side);
		case 6:
			return Block.cobblestoneMossy.getBlockTextureFromSide(side);
		default:
			return Block.stone.getBlockTextureFromSide(side);
		}
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}
}