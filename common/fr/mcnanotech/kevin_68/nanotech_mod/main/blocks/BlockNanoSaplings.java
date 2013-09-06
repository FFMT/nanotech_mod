package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.world.WorldGenNanoTree;

public class BlockNanoSaplings extends BlockSapling
{
	public BlockNanoSaplings(int id)
	{
		super(id);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotech_mod:sapling");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return blockIcon;
	}

	public void growTree(World world, int i, int j, int k, Random random)
	{
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new WorldGenNanoTree(false);
		if(!((WorldGenerator)(obj)).generate(world, random, i, j, k))
		{
			world.setBlock(i, j, k, blockID, l, 3);
		}
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int blockid)
	{
		return blockid == Block.grass.blockID || blockid == Block.dirt.blockID || blockid == Block.tilledField.blockID || blockid == NanotechBlock.BlockGrass.blockID;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(blockid, 1, 0));
	}

	public void fertilize(World world, int x, int y, int z)
	{}
}
