package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Calendar;
import java.util.Date;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float f, float g, float t)
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
					this.dropBlockAsItem_do(world, x, y, z, te.getPresent());
					this.removeBlockByPlayer(world, player, x, y, z);
					world.setBlockToAir(x, y, z);
				}
			}
			else
			{
				player.addChatMessage(I18n.getString("block.present.hey") + player.username + I18n.getString("block.present.nottime"));
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
				if(stack.hasTagCompound())
				{
					try
					{
						te.setPresent(ItemStack.loadItemStackFromNBT(stack.getTagCompound()));
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						System.out.println("error");
					}
				}
			}
		}
	}
}