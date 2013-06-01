package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockFalling extends BlockSand
{
	public static String[] type = new String[]{"stone", "stonebrick", "crackedstonebrick", "mossystonebrick", "chiseledstonebrick", "cobblestone", "mossycobblestone" };
	
	public BlockFalling(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
		setRequiresSelfNotify();
	}
	
    public int damageDropped(int metadata)
    {
        return metadata;
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
    		return 1;
    	case 1:
    		return 54;
    	case 2:
    		return 100;
    	case 3:
    		return 101;
    	case 4:
    		return 213;
    	case 5:
    		return 16;
    	case 6:
    		return 36;
    	default :
    		return 1;
    	}
	}
}
