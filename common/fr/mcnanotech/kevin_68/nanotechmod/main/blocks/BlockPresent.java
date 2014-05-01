/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPresent;

public class BlockPresent extends Block
{
	public BlockPresent()
	{
		super(Material.cloth);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityPresent();
	}

	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float f, float g, float t)
	{
		if(!world.isRemote)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null && tile instanceof TileEntityPresent)
			{
				TileEntityPresent te = (TileEntityPresent)tile;
				this.dropBlockAsItem(world, x, y, z, new ItemStack(te.getPresent().getItem(), 1, te.getPresent().getItemDamage()));
				this.removedByPlayer(world, player, x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		if(!world.isRemote)
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null && tile instanceof TileEntityPresent)
			{
				TileEntityPresent te = (TileEntityPresent)tile;
				if(stack.hasTagCompound())
				{
					try
					{
						te.setPresent(ItemStack.loadItemStackFromNBT(stack.getTagCompound()));
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						NanotechMod.nanoLogger.error("Failed to load NBTTags from ItemStack when block placed");
					}
				}
			}
		}
	}
}