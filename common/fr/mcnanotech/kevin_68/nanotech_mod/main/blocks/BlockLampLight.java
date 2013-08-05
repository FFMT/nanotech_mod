package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityLampLight;

public class BlockLampLight extends BlockContainer
{	
	public BlockLampLight(int id, Material material)
	{
		super(id, material);
		this.setLightValue(1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityLampLight();
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderType()
	{
		return -1;
	}
	
	public void updateLight(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y, z) == this.blockID && world.isDaytime())
		{
			world.setBlockToAir(x, y, z);
			world.setBlock(x, y, z, NanotechBlock.BlockLamp.blockID, 2, 1);
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion) 
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, 0);
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) 
	{
		for (int i = - 3; i < 4; ++i)

			if (world.getBlockId(x, y + i, z) == this.blockID || world.getBlockId(x, y + i, z) == NanotechBlock.BlockLamp.blockID)
			{
				world.setBlockToAir(x, y + i, z);
			}
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return NanotechItem.lamp.itemID;
	}
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return NanotechItem.lamp.itemID;
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
}

