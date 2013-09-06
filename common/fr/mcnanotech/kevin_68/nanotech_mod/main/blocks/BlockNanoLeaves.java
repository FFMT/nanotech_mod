package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.minecraftforgefrance.ffmtapi.blockhelper.BlockFFMTLeavesBase;

public class BlockNanoLeaves extends BlockFFMTLeavesBase implements IShearable
{
	public BlockNanoLeaves(int id)
	{
		super(id);
		this.setTickRandomly(true);
		this.setLightOpacity(1);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotech_mod:nanoleaves");
		fastIcon = iconregister.registerIcon("nanotech_mod:nanoleaves_opaque");
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

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return NanotechBlock.BlockNanosaplings.blockID;
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

	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return -1;
	}
}