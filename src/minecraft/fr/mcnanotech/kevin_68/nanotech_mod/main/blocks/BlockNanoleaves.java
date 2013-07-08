package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNanoLeaves extends BlockLeaves implements IShearable
{
	private Icon fastIcon;
	public BlockNanoLeaves(int id)
	{
		super(id);
		this.setTickRandomly(true);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:nanoleaves");
		fastIcon = iconregister.registerIcon("Nanotech_mod:nanoleaves_opaque");
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return !this.graphicsLevel;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
	{
		graphicsLevel = !Block.leaves.isOpaqueCube();

		return super.shouldSideBeRendered(blockAccess, par2, par3, par4, par5);
	}

	public Icon getIcon(int side, int metadata)
	{
		return(isOpaqueCube() ? fastIcon : blockIcon);
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	public int idDropped(int par1, Random random, int par3)
	{
		return NanotechBlock.BlockNanosaplings.blockID;
	}

	public void getSubBlocks(int par1, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(par1, 1, 0));
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
	{
		if(!world.isRemote)
		{
			byte var8 = 20;

			if((par5 & 3) == 3)
			{
				var8 = 40;
			}

			if(world.rand.nextInt(var8) == 0)
			{
				int var9 = this.idDropped(par5, world.rand, par7);
				this.dropBlockAsItem_do(world, x, y, z, new ItemStack(var9, 1, this.damageDropped(par5)));
			}
		}
	}

	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z)
	{
		return -1;
	}
}
