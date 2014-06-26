/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;

public class BlockJumper extends BlockContainer
{
	public static String[] type = new String[] {"basic", "advanced"};
	public IIcon[] iconbuffer;

	public BlockJumper()
	{
		super(Material.rock);
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		iconbuffer = new IIcon[5];
		iconbuffer[0] = iconregister.registerIcon(this.getTextureName() + "bottom");
		iconbuffer[1] = iconregister.registerIcon(this.getTextureName() + "top");
		iconbuffer[2] = iconregister.registerIcon(this.getTextureName() + "side");
		iconbuffer[3] = iconregister.registerIcon(this.getTextureName() + "top_advanced");
		iconbuffer[4] = iconregister.registerIcon(this.getTextureName() + "side_advanced");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
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

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(item, 1, metadatanumber));
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float var5 = 0.050F;
		return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - var5), (double)(z + 1));
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		TileEntityJumper tileJumper = (TileEntityJumper)world.getTileEntity(x, y, z);
		entity.motionY += tileJumper.getJumpHeightValue();
		if(world.getBlockMetadata(x, y, z) == 1)
		{
			entity.fallDistance = 0.0F;
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		if(!world.isRemote)
		{
			player.openGui(NanotechMod.modInstance, 0, world, x, y, z);
		}

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityJumper();
	}
}