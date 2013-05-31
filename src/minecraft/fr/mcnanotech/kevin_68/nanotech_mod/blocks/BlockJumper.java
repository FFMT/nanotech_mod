package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntity_block_jumper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockJumper extends BlockContainer
{
	
	public BlockJumper(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }
	
	public int getBlockTextureFromSide(int par1)
	{
		return par1 == 0 ? this.blockIndexInTexture - 1 : (par1 == 1 ? this.blockIndexInTexture - 1 : this.blockIndexInTexture);
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
        par5Entity.motionY += TileEntity_block_jumper.jumpheight;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
	        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

	        if(tile_entity == null || player.isSneaking())
	        {
	                return false;
	        }

	        player.openGui(Nanotech_mod.modInstance, 0, world, x, y, z);

	        return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
	        super.breakBlock(world, x, y, z, i, j);
	}
	@Override
	public TileEntity createNewTileEntity(World world)
	{
	        return new TileEntity_block_jumper();
	}

}