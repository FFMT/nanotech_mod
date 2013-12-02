package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNanoSteps extends BlockHalfSlab
{
	public static final String[] StepTypes = new String[] {"nano"};

	public BlockNanoSteps(int id, boolean isdouble)
	{
		super(id, isdouble, Material.wood);
		if(!this.isDoubleSlab)
		{
			this.setLightOpacity(0);
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == NanotechBlock.nanoSlabSingle.blockID;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this.blockID) ? this.blockID : NanotechBlock.nanoSlabDouble.blockID;
	}

	public int idDropped(int metadata, Random rand, int fortune)
	{
		return NanotechBlock.nanoSlabSingle.blockID;
	}

	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(NanotechBlock.nanoSlabSingle.blockID, 2, metadata & 7);
	}

	public String getFullSlabName(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}

		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		if(id != NanotechBlock.nanoSlabDouble.blockID)
		{
			for(int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(id, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return NanotechBlock.nanoPlanks.getBlockTextureFromSide(side);
	}
}
