package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityPortableChest;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityPresent;

public class BlockPortableChest extends BlockContainer
{

	protected BlockPortableChest(int par1, Material par2Material)
	{
		super(par1, par2Material);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityPortableChest();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		FMLNetworkHandler.openGui(player, NanotechMod.modInstance, 0, world, x, y, z);
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{

	}

	public void breakBlock(World world, int x, int y, int z, int side, int metadata)
	{
		super.breakBlock(world, x, y, z, side, metadata);
	}
}