package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;

public class BlockJumper extends BlockContainer
{
	public static String[] type = new String[] {"basic", "advanced"};
	public Icon[] iconbuffer;

	public BlockJumper(int id)
	{
		super(id, Material.rock);
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	public void registerIcons(IconRegister iconregister)
	{
		iconbuffer = new Icon[5];
		iconbuffer[0] = iconregister.registerIcon("nanotech_mod:jumpbottom");
		iconbuffer[1] = iconregister.registerIcon("nanotech_mod:jumptop");
		iconbuffer[2] = iconregister.registerIcon("nanotech_mod:jumpside");
		iconbuffer[3] = iconregister.registerIcon("nanotech_mod:jumptop_advanced");
		iconbuffer[4] = iconregister.registerIcon("nanotech_mod:jumpside_advanced");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(metadata == 0)
		{
			return (side == 0) ? iconbuffer[0] : (side == 1) ? iconbuffer[1] : iconbuffer[2];
		}
		else
		{
			return (side == 0) ? iconbuffer[0] : (side == 1) ? iconbuffer[3] : iconbuffer[4];
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float var5 = 0.050F;
		return AxisAlignedBB.getAABBPool().getAABB((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - var5), (double)(z + 1));
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		TileEntityJumper tileJumper = (TileEntityJumper)world.getBlockTileEntity(x, y, z);
		entity.motionY += tileJumper.getJumpHeightValue();
		if(world.getBlockMetadata(x, y, z) == 1)
		{
			entity.fallDistance = 0.0F;
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(NanotechMod.modInstance, 0, world, x, y, z);

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityJumper();
	}
}