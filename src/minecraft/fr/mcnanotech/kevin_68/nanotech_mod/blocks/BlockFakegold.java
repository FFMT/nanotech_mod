package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import fr.mcnanotech.kevin_68.nanotech_mod.entity.others.Entity_fakegold;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockFakegold extends Block
{

	public BlockFakegold(int par1, int par2) 
	{
		super(par1, par2, Material.rock);
	}
    
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        if (!par1World.isRemote)
        {
        	par1World.setBlock(par2, par3, par4, 0);
        	Entity_fakegold var6 = new Entity_fakegold(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
            par1World.spawnEntityInWorld(var6);
            par1World.playSoundAtEntity(var6, "random.fuse", 1.0F, 1.0F);
        }
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        this.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }
    
    public boolean canDropFromExplosion(Explosion par1Explosion)
    {
        return false;
    }

}
