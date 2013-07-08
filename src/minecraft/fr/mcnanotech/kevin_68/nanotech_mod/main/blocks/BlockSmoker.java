package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class BlockSmoker extends BlockContainer
{
	public BlockSmoker(int id)
	{
		super(id, Material.rock);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:smoker");
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		TileEntitySmoker tilesmoker = (TileEntitySmoker) world.getBlockTileEntity(x, y, z);
		int var6;
		float var7;
		float var8;
		float var9;

		for(var6 = 0; var6 < 3; ++var6)
		{
			var7 = (float) x + random.nextFloat();
			var8 = (float) y + random.nextFloat() * 0.1F;
			var9 = (float) z + random.nextFloat();
			if (tilesmoker.Smokepower >= 1)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, 0.0D);
			if (tilesmoker.Smokepower >= 2)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, 0.0D);
			if (tilesmoker.Smokepower >= 3)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, 0.0D);
			if (tilesmoker.Smokepower >= 4)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, 0.1D);
			if (tilesmoker.Smokepower >= 5)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.1D, -0.1D);
			if (tilesmoker.Smokepower >= 6)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, 0.1D);
			if (tilesmoker.Smokepower >= 7)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, -0.1D);
			if (tilesmoker.Smokepower >= 8)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, -0.1D, 0.1D, 0.1D);
			if (tilesmoker.Smokepower >= 9)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.1D, 0.1D, -0.1D);
			if (tilesmoker.Smokepower >= 10)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.15D, 0.0D);
			if (tilesmoker.Smokepower >= 11)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.17D, 0.0D);
			if (tilesmoker.Smokepower >= 12)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.2D, 0.0D);
			if (tilesmoker.Smokepower >= 13)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.25D, 0.0D);
			if (tilesmoker.Smokepower >= 14)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.3D, 0.0D);
			if (tilesmoker.Smokepower >= 15)
			{
			world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, 0.0D, 0.35D, 0.0D);
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
			}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		if(!world.isRemote)
		{
			TileEntitySmoker tileentitysmoker = (TileEntitySmoker) world.getBlockTileEntity(x, y, z);
		}

		TileEntity tileentity = world.getBlockTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(Nanotech_mod.modInstance, 1, world, x, y, z);

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
		return new TileEntitySmoker();
	}
	
	public void addSmokeInt()
	{
		if (this.readSmokeInt(new ItemStack(this, 1)) != 16)
		{
			this.saveSmokeInt(new ItemStack(this, 1), this.readSmokeInt(new ItemStack(this, 1))+1);
		}
	}
	
	public void dimSmokeInt()
	{
		if (this.readSmokeInt(new ItemStack(this, 1)) != 0)
		{
			this.saveSmokeInt(new ItemStack(this, 1), this.readSmokeInt(new ItemStack(this, 1))-1);
		}
	}
	
    public static int readSmokeInt(ItemStack var0)
    {
        NBTTagCompound var1 = UltimateGraviSuite.getOrCreateNbtData(var0);
        return var1.getInteger("smokeInt");
    }

    public static int saveSmokeInt(ItemStack var0, int var1)
    {
        NBTTagCompound var2 = UltimateGraviSuite.getOrCreateNbtData(var0);
        var2.setInteger("smokeInt", var1);
        return 0;
    }

}