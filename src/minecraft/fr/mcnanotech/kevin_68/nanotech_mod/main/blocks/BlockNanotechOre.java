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
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class BlockNanotechOre extends Block
{
	public static String[] type = new String[]{"silicon", "decrease"};
	public Icon[] iconbuffer;

	public BlockNanotechOre(int id)
	{
		super(id, Material.rock);
		setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
	}
	
	public void registerIcons(IconRegister iconregister)
	{
    	iconbuffer = new Icon[type.length];
    	for(int i = 0; i < type.length; i++)
    	{
    		iconbuffer[i] = iconregister.registerIcon("Nanotech_mod:"+ type[i] + "ore");
    	}
	}
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int damage)
    {
    	if(damage < type.length)
    	{
        	return iconbuffer[damage];
    	}
    	else 
    	{
    		return iconbuffer[0];
    	}
    }

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for (int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}
}
