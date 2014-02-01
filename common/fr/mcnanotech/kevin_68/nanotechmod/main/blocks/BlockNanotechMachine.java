package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class BlockNanotechMachine extends Block
{
	public static String[] subName = new String[] {"portableChest"};

	protected BlockNanotechMachine(int id, Material material)
	{
		super(id, material);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(metadata == 0)
		{
			return Block.chest.getBlockTextureFromSide(0);
		}
		return blockIcon;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return FFMTClientRegistry.tesrRenderId;
	}

	public boolean hasTileEntity(int metadata)
	{
		switch(metadata)
		{
		case 0:
			return true;
		default:
			return false;
		}
	}

	public TileEntity createTileEntity(World world, int metadata)
	{
		switch(metadata)
		{
		case 0:
			return new TileEntityPortableChest();
		default:
			return null;
		}
	}

	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		if(metadata == 0)
		{
			ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
			ItemStack chestStack = new ItemStack(this, 1, 0);
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityPortableChest)
			{
				TileEntityPortableChest teChest = (TileEntityPortableChest)te;
				NBTTagCompound nbttag = new NBTTagCompound();

				NBTTagList nbttaglist = new NBTTagList();
				for(int i = 0; i < teChest.inventory.length; i++)
				{
					if(teChest.inventory[i] != null)
					{
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						nbttagcompound1.setByte("Slot", (byte)i);
						teChest.inventory[i].writeToNBT(nbttagcompound1);
						nbttaglist.appendTag(nbttagcompound1);
					}
				}

				nbttag.setTag("Items", nbttaglist);
				chestStack.setTagCompound(nbttag);

				if(teChest.isInvNameLocalized())
				{
					chestStack.setItemName(teChest.getCustomGuiName());
				}
			}
			ret.add(chestStack);
			return ret;
		}
		else
		{
			return super.getBlockDropped(world, x, y, z, metadata, fortune);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		FMLNetworkHandler.openGui(player, NanotechMod.modInstance, 1, world, x, y, z);
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

		if(stack.getItemDamage() == 0)
		{
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityPortableChest)
			{
				TileEntityPortableChest teChest = (TileEntityPortableChest)te;
				teChest.setDirection((byte)direction);

				if(stack.hasTagCompound())
				{
					if(stack.hasDisplayName())
					{
						teChest.setCustomGuiName(stack.getDisplayName());
					}

					NBTTagList nbttaglist = stack.getTagCompound().getTagList("Items");
					for(int i = 0; i < nbttaglist.tagCount(); i++)
					{
						NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
						int j = nbttagcompound1.getByte("Slot");

						if(j >= 0 && j < teChest.inventory.length)
						{
							teChest.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
						}
					}
				}
			}
		}
		world.markBlockForUpdate(x, y, z);
	}

	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z)
	{
		if(!world.isRemote && !player.capabilities.isCreativeMode && world.getBlockMetadata(x, y, z) == 0)
		{
			player.addStat(StatList.mineBlockStatArray[this.blockID], 1);
			player.addExhaustion(0.025F);
			int i1 = EnchantmentHelper.getFortuneModifier(player);
			if(!player.getEntityName().contains("[") || !(player instanceof FakePlayer))
			{
				ArrayList<ItemStack> items = getBlockDropped(world, x, y, z, world.getBlockMetadata(x, y, z), i1);
				for(ItemStack is : items)
				{
					this.dropBlockAsItem_do(world, x, y, z, is);
				}
			}
		}
		world.setBlockToAir(x, y, z);
		return true;
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int side)
	{}

	public void breakBlock(World world, int x, int y, int z, int side, int metadata)
	{
		super.breakBlock(world, x, y, z, side, metadata);
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) == 0)
		{
			ItemStack chestStack = new ItemStack(this, 1, 0);
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityPortableChest)
			{
				TileEntityPortableChest teChest = (TileEntityPortableChest)te;
				NBTTagCompound nbttag = new NBTTagCompound();

				NBTTagList nbttaglist = new NBTTagList();
				for(int i = 0; i < teChest.inventory.length; i++)
				{
					if(teChest.inventory[i] != null)
					{
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						nbttagcompound1.setByte("Slot", (byte)i);
						teChest.inventory[i].writeToNBT(nbttagcompound1);
						nbttaglist.appendTag(nbttagcompound1);
					}
				}

				nbttag.setTag("Items", nbttaglist);
				chestStack.setTagCompound(nbttag);

				if(teChest.isInvNameLocalized())
				{
					chestStack.setItemName(teChest.getCustomGuiName());
				}
			}
			return chestStack;
		}
		else
		{
			return super.getPickBlock(target, world, x, y, z);
		}
	}

	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventValue)
	{
		super.onBlockEventReceived(world, x, y, z, eventId, eventValue);
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		return tileentity != null ? tileentity.receiveClientEvent(eventId, eventValue) : false;
	}
}