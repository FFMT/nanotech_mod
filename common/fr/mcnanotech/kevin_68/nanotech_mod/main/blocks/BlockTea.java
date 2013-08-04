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

	protected BlockTea(int par1)
	{
		super(par1);
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundGrassFootstep);
		this.disableStats();
	}

	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return par1 == Block.tilledField.blockID;
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);

			if (l < 7)
			{
				float f = this.getGrowthRate(par1World, par2, par3, par4);

				if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
				{
					++l;
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
				}
			}
		}
	}

	public void fertilize(World par1World, int x, int y, int z)
	{
		int l = par1World.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

		if (l > 7)
		{
			l = 7;
		}

		par1World.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	private float getGrowthRate(World par1World, int par2, int par3, int par4)
	{
		float f = 1.0F;
		int l = par1World.getBlockId(par2, par3, par4 - 1);
		int i1 = par1World.getBlockId(par2, par3, par4 + 1);
		int j1 = par1World.getBlockId(par2 - 1, par3, par4);
		int k1 = par1World.getBlockId(par2 + 1, par3, par4);
		int l1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
		int i2 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
		int j2 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
		int k2 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
		boolean flag = j1 == this.blockID || k1 == this.blockID;
		boolean flag1 = l == this.blockID || i1 == this.blockID;
		boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

		for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2)
		{
			for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3)
			{
				int j3 = par1World.getBlockId(l2, par3 - 1, i3);
				float f1 = 0.0F;

				if (blocksList[j3] != null && blocksList[j3].canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this))
				{
					f1 = 1.0F;

					if (blocksList[j3].isFertile(par1World, l2, par3 - 1, i3))
					{
						f1 = 3.0F;
					}
				}

				if (l2 != par2 || i3 != par4)
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
	public Icon getIcon(int par1, int par2)
	{
		if (par2 < 0 || par2 > 7)
		{
			par2 = 7;
		}

		return this.iconArray[par2];
	}


	public int getRenderType()
	{
		return 6;
	}

	protected int getSeedItem()
	{
		return NanotechItem.teaSeed.itemID;
	}

	protected int getCropItem()
	{
		return NanotechItem.tea.itemID;
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
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

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return par1 == 7 ? this.getCropItem() : this.getSeedItem();
	}

	public int quantityDropped(Random par1Random)
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return this.getSeedItem();
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconArray = new Icon[8];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon("Nanotech_mod:tea_" + i);
		}
	}
}
