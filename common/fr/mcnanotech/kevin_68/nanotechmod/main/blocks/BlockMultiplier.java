package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;

public class BlockMultiplier extends BlockContainer
{
	public Icon topbottomIcon;

	public BlockMultiplier(int id)
	{
		super(id, Material.rock);
	}

	public void registerIcons(IconRegister iconregister)
	{
		topbottomIcon = iconregister.registerIcon("nanotech_mod:multiplierside");
		blockIcon = iconregister.registerIcon("nanotech_mod:multiplier");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side == 0 ? blockIcon : (side == 1 ? blockIcon : topbottomIcon);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(NanotechMod.modInstance, 0, world, x, y, z);

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityMultiplier();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityMultiplier && stack.hasDisplayName())
		{
			TileEntityMultiplier multiplier = (TileEntityMultiplier)te;
			multiplier.setCustomName(stack.getDisplayName());
		}
	}
}