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

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;

public class BlockNanoSteps extends BlockSlab
{
	public static final String[] StepTypes = new String[] {"nano"};

	public BlockNanoSteps(boolean isdouble)
	{
		super(isdouble, Material.wood);
		if(!this.field_150004_a)
		{
			this.setLightOpacity(0);
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(BlockNanoSteps block)
	{
		return block.equals(NanotechBlock.nanoStepSingle);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this) ? new ItemStack(this) : new ItemStack(NanotechBlock.nanoStepDouble);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return Item.getItemFromBlock(NanotechBlock.nanoStepSingle);
	}

	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(NanotechBlock.nanoStepSingle, 2, metadata & 7);
	}

	@Override
	public String func_150002_b(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}

		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		if(!item.equals(Item.getItemFromBlock(NanotechBlock.nanoStepDouble)))
		{
			for(int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return NanotechBlock.nanoPlank.getBlockTextureFromSide(side);
	}
}
