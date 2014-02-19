/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpeed extends Block
{
	public static String[] type = new String[] {"booster", "retarder"};
	public IIcon[] iconbuffer;

	public BlockSpeed()
	{
		super(Material.rock);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		iconbuffer = new IIcon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon(this.getTextureName() + type[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(metadata < type.length)
		{
			return iconbuffer[metadata];
		}
		else
		{
			return iconbuffer[0];
		}
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
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
		float var5 = 0.025F;
		return AxisAlignedBB.getAABBPool().getAABB((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - var5), (double)(z + 1));
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if(metadata == 1)
		{
			entity.motionX *= 0.01D;
			entity.motionZ *= 0.01D;
			entity.setInWeb();
		}

		else if(metadata == 0)
		{
			entity.motionX *= 1.4D;
			entity.motionZ *= 1.4D;
		}
	}
}
