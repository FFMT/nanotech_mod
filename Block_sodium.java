package fr.mcnanotech.kevin_68.nanotech_mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Block_sodium extends Block
{

	public Block_sodium(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
	}
	
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
    }
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);

        if (par1World.getBlockId(par2, par3 - 1, par4) == Block.waterStill.blockID || par1World.getBlockId(par2, par3 + 1, par4) == Block.waterStill.blockID || par1World.getBlockId(par2 - 1, par3, par4) == Block.waterStill.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.waterStill.blockID || par1World.getBlockId(par2, par3, par4 - 1) == Block.waterStill.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.waterStill.blockID || par1World.getBlockId(par2, par3 - 1, par4) == Block.waterMoving.blockID || par1World.getBlockId(par2, par3 + 1, par4) == Block.waterMoving.blockID || par1World.getBlockId(par2 - 1, par3, par4) == Block.waterMoving.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.waterMoving.blockID || par1World.getBlockId(par2, par3, par4 - 1) == Block.waterMoving.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.waterMoving.blockID)
        {
            if (!par1World.isRemote)
            {
                par1World.setBlock(par2, par3, par4, 0);
                EntityTNTPrimed var9 = new EntityTNTPrimed(par1World);
                var9.setLocationAndAngles((double)par2, (double)par3, (double)par4, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(var9);
                par1World.notifyBlockChange(par2, par3, par4, 0);
            }
        }
    }
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.0625F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)((float)par2 + var5), (double)par3, (double)((float)par4 + var5), (double)((float)(par2 + 1) - var5), (double)((float)(par3 + 1) - var5), (double)((float)(par4 + 1) - var5));
    }
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
		if (par5Entity instanceof EntityLiving)
		{
			par5Entity.attackEntityFrom(DamageSource.cactus, 1);
		}
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		this.onBlockAdded(par1World, par2, par3, par4);
    }
}
