package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Calendar;
import java.util.Date;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityPresent;

public class BlockPresent extends Block
{
	public BlockPresent(int id)
	{
		super(id, Material.cloth);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityPresent();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		if(!world.isRemote)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int day = calendar.get(5);
			int month = calendar.get(2);
			
			if((day == 24 || day == 25 || day == 13) && month == Calendar.DECEMBER)
			{
				TileEntity tile = world.getBlockTileEntity(x, y, z);
				if(tile != null && tile instanceof TileEntityPresent)
				{
					TileEntityPresent te = (TileEntityPresent)tile;
					this.dropBlockAsItem_do(world, x, y, z, new ItemStack(1, 1, 0));
					world.setBlockToAir(x, y, z);
				}
			}
			else
			{
				player.addChatMessage("Hey, " + player.username + ", it's not the time to open!");
			}
		}
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		if(!world.isRemote)
		{
			TileEntity tile = world.getBlockTileEntity(x, y, z);
			if(tile != null && tile instanceof TileEntityPresent)
			{
				TileEntityPresent te = (TileEntityPresent)tile;
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("presentId") && stack.getTagCompound().hasKey("presentMeta"))
				{
					te.setPresent(stack.getTagCompound().getInteger("presentId"), stack.getTagCompound().getInteger("presentMeta"));
				}
			}
		}
	}
}