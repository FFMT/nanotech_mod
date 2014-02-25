/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNotFalling extends Block
{
	public static String[] type = new String[] {"gravel", "sand"};
	private IIcon[] iconbuffer;

	public BlockNotFalling()
	{
		super(Material.sand);
		this.setHarvestLevel("shovel", 2);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		iconbuffer = new IIcon[type.length];
		iconbuffer[0] = Blocks.gravel.getBlockTextureFromSide(0);
		iconbuffer[1] = Blocks.sand.getBlockTextureFromSide(0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int damage)
	{
		if(damage == 1)
		{
			return iconbuffer[1];
		}
		else
		{
			return iconbuffer[0];
		}
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(item, 1, metadatanumber));
		}
	}
}
