package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Block_multiplier extends BlockContainer
{ 		
	public Block_multiplier(int i, int j) 
	{ 
		super(i, j, Material.rock);
	} 

	public String getTextureFile()
	{
        return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

	public int getBlockTextureFromSide(int par1)
	{
		return par1 == 0 ? this.blockIndexInTexture: (par1 == 1 ? this.blockIndexInTexture: this.blockIndexInTexture + 16);
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
		return new TileEntity_block_multiplier();
	}
}