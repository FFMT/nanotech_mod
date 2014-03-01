/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNanoFalling extends BlockFalling
{
	public static String[] type = new String[] {"stone", "stonebrick", "crackedstonebrick", "mossystonebrick", "chiseledstonebrick", "cobblestone", "mossycobblestone"};

	public BlockNanoFalling()
	{
		super(Material.rock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
		case 0:
			return Blocks.stone.getBlockTextureFromSide(side);
		case 1:
			return Blocks.stonebrick.getIcon(side, 0);
		case 2:
			return Blocks.stonebrick.getIcon(side, 1);
		case 3:
			return Blocks.stonebrick.getIcon(side, 2);
		case 4:
			return Blocks.stonebrick.getIcon(side, 3);
		case 5:
			return Blocks.cobblestone.getBlockTextureFromSide(side);
		case 6:
			return Blocks.mossy_cobblestone.getBlockTextureFromSide(side);
		default:
			return Blocks.stone.getBlockTextureFromSide(side);
		}
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(item, 1, metadatanumber));
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iiconRegister)
    {
    	// Empty
    }
}