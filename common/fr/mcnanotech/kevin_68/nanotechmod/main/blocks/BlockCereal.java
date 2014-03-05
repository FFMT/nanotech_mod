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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

@SuppressWarnings({"unchecked", "rawtypes"})
public class BlockCereal extends Block
{
	public static String[] type = new String[] {"packet1", "packet2", "bowl_empty", "bowl_quarter", "bowl_half", "bowl_3quarter", "bowl_full", "bowl_quarterempty", "bowl_halfempty", "bowl_3quarterempty"};
	private IIcon[] iconBuffer;

	protected BlockCereal()
	{
		super(Material.wood);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedBB, List list, Entity entity)
	{
		float f = 0.0625F;

		if(world.getBlockMetadata(x, y, z) == 0)
		{
			this.setBlockBounds(6 * f, 0.0F, 2 * f, 10 * f, 1.0F - (2 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(world.getBlockMetadata(x, y, z) == 1)
		{
			this.setBlockBounds(2 * f, 0.0F, 6 * f, 1.0F - (2 * f), 1.0F - (2 * f), 10 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else
		{
			this.setBlockBounds(6 * f, 0, 6 * f, 10 * f, f, 10 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(6 * f, f, 5 * f, 10 * f, 2 * f, 6 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, f, 6 * f, 6 * f, 2 * f, 10 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(6 * f, f, 10 * f, 10 * f, 2 * f, 11 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(10 * f, f, 6 * f, 11 * f, 2 * f, 10 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, 2 * f, 4 * f, 11 * f, 3 * f, 5 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(11 * f, 2 * f, 5 * f, 12 * f, 3 * f, 11 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(4 * f, 2 * f, 5 * f, 5 * f, 3 * f, 11 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, 2 * f, 11 * f, 11 * f, 3 * f, 12 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, 2 * f, 5 * f, 6 * f, 3 * f, 6 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, 2 * f, 10 * f, 6 * f, 3 * f, 11 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(10 * f, 2 * f, 10 * f, 11 * f, 3 * f, 11 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(10 * f, 2 * f, 5 * f, 11 * f, 3 * f, 6 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(4 * f, 3 * f, 4 * f, 5 * f, 4 * f, 12 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(4 * f, 3 * f, 4 * f, 12 * f, 4 * f, 5 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(5 * f, 3 * f, 11 * f, 12 * f, 4 * f, 12 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(11 * f, 3 * f, 5 * f, 12 * f, 4 * f, 12 * f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		float f = 0.0625F;

		if(world.getBlockMetadata(x, y, z) == 0)
		{
			this.setBlockBounds(6 * f, 0.0F, 2 * f, 10 * f, 1.0F - (2 * f), 1.0F - (2 * f));
		}
		else if(world.getBlockMetadata(x, y, z) == 1)
		{
			this.setBlockBounds(2 * f, 0.0F, 6 * f, 1.0F - (2 * f), 1.0F - (2 * f), 10 * f);
		}
		else
		{
			this.setBlockBounds(4 * f, 0.0F, 4 * f, 12 * f, 0.25F, 12 * f);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		iconBuffer = new IIcon[9];
		iconBuffer[0] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal1");
		iconBuffer[1] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal2");
		iconBuffer[2] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal3");
		iconBuffer[3] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal4");
		iconBuffer[4] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal5");
		iconBuffer[5] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal6");
		iconBuffer[6] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal7");
		iconBuffer[7] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal8");
		iconBuffer[8] = iconRegister.registerIcon(NanotechMod.MODID + ":cereal9");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(metadata > 1)
		{
			if(side != 1)
			{
				return Blocks.planks.getIcon(1, 0);
			}
			else
			{
				if(metadata == 2)
				{
					return Blocks.planks.getIcon(1, 0);
				}
				else if(metadata == 3)
				{
					return iconBuffer[0];
				}
				else if(metadata == 4)
				{
					return iconBuffer[1];
				}
				else if(metadata == 5)
				{
					return iconBuffer[2];
				}
				else if(metadata == 6 || metadata == 7)
				{
					return iconBuffer[3];
				}
				else if(metadata == 8)
				{
					return iconBuffer[4];
				}
				else if(metadata == 9)
				{
					return iconBuffer[5];
				}
				else
				{
					return iconBuffer[1];
				}
			}
		}
		else
		{
			if(metadata == 0)
			{
				if(side == 4 || side == 5)
				{
					return iconBuffer[6];
				}
				else if(side == 2 || side == 3)
				{
					return iconBuffer[7];
				}
				else
				{
					return iconBuffer[8];
				}
			}
			else if(metadata == 1)
			{
				if(side == 2 || side == 3)
				{
					return iconBuffer[6];
				}
				else if(side == 4 || side == 5)
				{
					return iconBuffer[7];
				}
				else
				{
					return iconBuffer[8];
				}
			}
			else
			{
				return iconBuffer[5];
			}
		}
	}

	@Override
	public int damageDropped(int metadata)
	{
		if(metadata == 1)
		{
			return 0;
		}
		else
		{
			return metadata;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 6));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(!world.isRemote)
		{
			if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem().equals(Items.wheat))
			{
				if(world.getBlockMetadata(x, y, z) < 5 && world.getBlockMetadata(x, y, z) > 1)
				{
					world.setBlock(x, y, z, this, world.getBlockMetadata(x, y, z) + 1, 2);
					if(!player.capabilities.isCreativeMode && --player.inventory.getCurrentItem().stackSize <= 0)
					{
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}
			}
			else if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem().equals(Items.milk_bucket))
			{
				if(world.getBlockMetadata(x, y, z) == 5)
				{
					player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
					world.setBlock(x, y, z, this, 6, 2);
				}
			}
			else
			{
				if(world.getBlockMetadata(x, y, z) > 5 && world.getBlockMetadata(x, y, z) < 10 && player.canEat(false))
				{
					world.setBlock(x, y, z, this, world.getBlockMetadata(x, y, z) + 1, 2);
					player.getFoodStats().addStats(1, 0.1F);
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public int getRenderType()
	{
		return ClientProxy.renderCerealID;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		if(stack.getItemDamage() == 0)
		{
			int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			if(direction == 0 || direction == 2)
			{
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			}
		}
	}
}