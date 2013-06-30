package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNotFalling extends Block
{
	public static String[] type = new String[]{"gravel", "sand"};
	private Icon[] iconbuffer;

	public BlockNotFalling(int id, Material material)
	{
		super(id, material);
	}
	
    public void registerIcons(IconRegister iconregister)
    {
    	iconbuffer = new Icon[type.length];
    	iconbuffer[0] = iconregister.registerIcon("gravel");
    	iconbuffer[1] = iconregister.registerIcon("sand");
    }
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int damage)
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

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for (int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}
}
