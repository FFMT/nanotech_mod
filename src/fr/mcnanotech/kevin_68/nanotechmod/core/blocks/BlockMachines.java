package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockMachines extends Block
{
	public static String[] subName = new String[] {"wirering", "centrifuge", "highttempfurnace", "cutting", "polishing", "engraving", "lensholder", "templateholder", "cleaning", "ionization", "circuitwirering", "testing", "oldmachine", "rottencleaning"};

	protected BlockMachines()
	{
		super(Material.iron);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
		default:
			return blockIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < subName.length; metadatanumber++)
		{
			list.add(new ItemStack(item, 1, metadatanumber));
		}
	}

//	@Override
//	public boolean renderAsNormalBlock()
//	{
//		return false;
//	}

//	@Override
//	public boolean isOpaqueCube()
//	{
//		return false;
//	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public int getRenderType()
//	{
//		return 0;
//	}

	@Override
	public boolean hasTileEntity(int metadata)
	{
		switch(metadata)
		{
		default:
			return false;
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		switch(metadata)
		{
		default:
			return null;
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		switch(metadata)
		{
		default:
			return super.getDrops(world, x, y, z, metadata, fortune);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xBlock, float yBlock, float zBlock)
	{
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

		switch(stack.getItemDamage())
		{

		}
		world.markBlockForUpdate(x, y, z);
	}

//	@Override
//	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
//	{
//		return true;
//	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int side)
	{}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return super.getPickBlock(target, world, x, y, z);
	}

	@Override
	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventValue)
	{
		super.onBlockEventReceived(world, x, y, z, eventId, eventValue);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return tileentity != null ? tileentity.receiveClientEvent(eventId, eventValue) : false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iiconRegister)
	{
		// Empty
	}
}