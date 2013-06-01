package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSpeed extends Block
{
	public static String[] type = new String[]{"booster", "retarder"};

	public BlockSpeed(int id, int par2)
    {
        super(id, par2, Material.rock);
		setRequiresSelfNotify();
    }
	
    public int damageDropped(int metadata)
    {
        return metadata;
    }
	
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
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
		if(damage == 0)
		{
			return blockIndexInTexture;
		}
		else if(damage == 1)
		{
			return blockIndexInTexture + 2;
		}
		else
		{
			return blockIndexInTexture;
		}
	}

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.025F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
    }
    
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		int damage = world.getBlockMetadata(x, y, z);
		if(damage == 1)
		{
			entity.motionX *= 0.01D;
	        entity.motionZ *= 0.01D;
	        entity.setInWeb();
		}
		
		else if(damage == 0)
		{
			entity.motionX *= 1.4D;
	        entity.motionZ *= 1.4D;
		}
    }
}
