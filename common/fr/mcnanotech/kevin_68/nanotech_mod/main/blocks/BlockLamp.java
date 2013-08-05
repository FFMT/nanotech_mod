package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityLampLight;

public class BlockLamp extends Block
{
	public static String[] type = new String[]{"lamp1", "empty", "lampLightOff"};

	public BlockLamp(int id, Material material)
	{
		super(id, material);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) 
	{
		if (metadata == 0)
		{
			return new TileEntityLamp();
		}
		else if (metadata == 2)
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
		if (metadata == 0 || metadata == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
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
	 */
	public void updateLight(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y, z) == this.blockID && world.getBlockMetadata(x, y, z) == 2 && !world.isDaytime())
		{
			world.setBlockToAir(x, y, z);
			world.setBlock(x, y, z, NanotechBlock.BlockLampLight.blockID);
		}
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) 
	{
		for (int i = - 3; i < 4; ++i)

			if (world.getBlockId(x, y + i, z) == this.blockID || world.getBlockId(x, y + i, z) == NanotechBlock.BlockLampLight.blockID)
			{
				world.setBlockToAir(x, y + i, z);
			}
	}    

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion) 
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, 0);
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

}
