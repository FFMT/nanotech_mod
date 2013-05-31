package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNotFalling extends Block
{
	public static String[] type = new String[] {"gravel", "sand"};

	public BlockNotFalling(int id, int texture, Material material)
	{
		super(id, texture, material);
		setRequiresSelfNotify();
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
    {
    	for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber ++)
    	{
            list.add(new ItemStack(blockid, 1, metadatanumber));
    	}
    }
    
	public int getBlockTextureFromSideAndMetadata(int side, int damage) 
	{
    	switch(damage)
    	{
    	case 0:
    		return 19;
    	case 1:
    		return 18;
    	default:
    		return 19;
    	}
	}

}
