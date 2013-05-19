package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Block_confusion extends Block
{
    public Block_confusion(int par1, int par2)
    {
        super(par1, par2, Material.iron);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.125F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2 - var5, (double)par3 - var5, (double)par4 - var5, (double)(par2 + 1) - var5, (double)((float)(par3 + 1) - var5), (double)(par4 + 1)- var5);
    }
    
	public String getTextureFile()
	{
        return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if (par5Entity instanceof EntityPlayer)
    	{
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(9, 20, 10));
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(15, 200, 10));
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(2, 200, 10));
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(4, 200, 10));
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(17, 200, 10));
    		((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(20, 20, 10));
    	}
    }
}
