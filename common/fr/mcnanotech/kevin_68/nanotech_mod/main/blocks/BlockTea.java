package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class BlockTea extends BlockCrops
{
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	protected static Random itemRand = new Random();

	protected BlockTea(int id)
	{
		super(id);
		this.setTickRandomly(true);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundGrassFootstep);
		this.disableStats();
	}

	protected boolean canThisPlantGrowOnThisBlockID(int blockid)
	{
		return blockid == Block.tilledField.blockID;
	}

	public void updateTick(World world, int x, int y, int z, Random par5Random)
	{
		super.updateTick(world, x, y, z, par5Random);

		if (world.getBlockLightValue(x, y + 1, z) >= 9)
		{
			int l = world.getBlockMetadata(x, y, z);

			if (l < 7)
			{
				float f = this.getGrowthRate(world, x, y, z);

				if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
				{
					++l;
					world.setBlockMetadataWithNotify(x, y, z, l, 2);
				}
			}
		}
	}

	public void fertilize(World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

		if (l > 7)
		{
			l = 7;
		}

		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	private float getGrowthRate(World world, int x, int y, int z)
	{
		float f = 1.0F;
		int l = world.getBlockId(x, y, z - 1);
		int i1 = world.getBlockId(x, y, z + 1);
		int j1 = world.getBlockId(x - 1, y, z);
		int k1 = world.getBlockId(x + 1, y, z);
		int l1 = world.getBlockId(x - 1, y, z - 1);
		int i2 = world.getBlockId(x + 1, y, z - 1);
		int j2 = world.getBlockId(x + 1, y, z + 1);
		int k2 = world.getBlockId(x - 1, y, z + 1);
		boolean flag = j1 == this.blockID || k1 == this.blockID;
		boolean flag1 = l == this.blockID || i1 == this.blockID;
		boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

		for (int l2 = x - 1; l2 <= x + 1; ++l2)
		{
			for (int i3 = z - 1; i3 <= z + 1; ++i3)
			{
				int j3 = world.getBlockId(l2, y - 1, i3);
				float f1 = 0.0F;

				if (blocksList[j3] != null && blocksList[j3].canSustainPlant(world, l2, y - 1, i3, ForgeDirection.UP, this))
				{
					f1 = 1.0F;

					if (blocksList[j3].isFertile(world, l2, y - 1, i3))
					{
						f1 = 3.0F;
					}
				}

				if (l2 != x || i3 != z)
				{
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		if (flag2 || flag && flag1)
		{
			f /= 2.0F;
		}

		return f;
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if (metadata < 0 || metadata > 7)
		{
			metadata = 7;
		}

		return this.iconArray[metadata];
	}


	public int getRenderType()
	{
		return 1;
	}

	protected int getSeedItem()
	{
		return NanotechItem.teaSeed.itemID;
	}

	protected int getCropItem()
	{
		return NanotechItem.tea.itemID;
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, 0);
	}

	@Override 
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

		if (metadata >= 7)
		{
			for (int n = 0; n < 3 + fortune; n++)
			{
				if (world.rand.nextInt(15) <= metadata)
				{
					ret.add(new ItemStack(this.getSeedItem(), 1, 0));
				}
			}
		}

		return ret;
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return metadata == 7 ? this.getCropItem() : this.getSeedItem();
	}

	public int quantityDropped(Random random)
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return this.getSeedItem();
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister)
	{
		this.iconArray = new Icon[8];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconregister.registerIcon("nanotech_mod:tea_" + (i + 1));
		}
	}
}
