package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class BlockLamp extends Block
{
	public BlockLamp(int id, Material material)
	{
		super(id, material);
	}
	
    @SideOnly(Side.CLIENT)
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
    	if(world.getBlockMetadata(x, y, z) == 3)
    	{
    		return 15;
    	}
    	return 0;
    }

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		if(metadata == 0)
		{
			return new TileEntityLamp();
		}
		else if(metadata == 2 || metadata == 3)
		{
			return new TileEntityLampLight();
		}
		else
		{
			return null;
		}
	}

	public boolean hasTileEntity(int metadata)
	{
		if(metadata == 0 || metadata == 2 || metadata == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
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

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		for(int i = -3; i < 4; ++i)
		{
			if(world.getBlockId(x, y + i, z) == this.blockID)
			{
				world.setBlockToAir(x, y + i, z);
			}
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion)
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, world.getBlockMetadata(x, y, z));
	}

	public Icon getIcon(int side, int metadata)
	{
		return NanotechBlock.BlockJumper.getIcon(0, 0);
	}

	public void registerIcons(IconRegister iconregister)
	{}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;
		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}
}