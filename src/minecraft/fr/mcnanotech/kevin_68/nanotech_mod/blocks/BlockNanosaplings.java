package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

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
import fr.mcnanotech.kevin_68.nanotech_mod.world.WorldGenNanoTree;

public class BlockNanosaplings extends BlockSapling
{
	public BlockNanosaplings(int id)
	{
		super(id);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("Nanotech_mod:sapling");
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
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k))
		{
			world.setBlock(i, j, k, blockID, l, 3);
		}
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == NanotechBlock.BlockGrass.blockID;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}

	public void fertilize(World world, int x, int y, int z)
	{}
}
