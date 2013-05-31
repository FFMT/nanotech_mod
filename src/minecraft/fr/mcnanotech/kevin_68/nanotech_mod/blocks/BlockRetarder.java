package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockRetarder extends Block
{

	public BlockRetarder(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }
	
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.125F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
    }
    
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.01D;
        par5Entity.motionZ *= 0.01D;
        par5Entity.setInWeb();
    }
}
