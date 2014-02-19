/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNanoLeaves extends BlockLeaves implements IShearable
{
	protected IIcon fastIcon;
	public static final String[] types = new String[] {"nano"};

	public BlockNanoLeaves()
	{
		super();
		this.setLightOpacity(1);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon(this.getTextureName());
		fastIcon = iconregister.registerIcon(this.getTextureName() + "_opaque");
	}

	@Override
	public boolean isOpaqueCube()
	{
		return Blocks.leaves.isOpaqueCube();
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		return !this.isOpaqueCube() ? true : super.shouldSideBeRendered(blockaccess, x, y, z, side);
	}

	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return(isOpaqueCube() ? fastIcon : blockIcon);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBlockColor()
	{
		return -1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderColor(int par1)
	{
		return -1;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int par3)
	{
		return Item.getItemFromBlock(NanotechBlock.nanoSaplings);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float par6, int par7)
	{
		if(!world.isRemote)
		{
			if(world.rand.nextInt(20) == 0)
			{
				Item splingid = this.getItemDropped(metadata, world.rand, par7);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(splingid, 1, this.damageDropped(metadata)));
			}
		}
	}

	@Override
	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return -1;
	}

	@Override
	public String[] func_150125_e()
	{
		return types;
	}
}