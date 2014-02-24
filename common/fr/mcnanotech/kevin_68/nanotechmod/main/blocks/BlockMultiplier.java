/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;

public class BlockMultiplier extends BlockContainer
{
	public IIcon topbottomIcon;

	public BlockMultiplier()
	{
		super(Material.rock);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		topbottomIcon = iconregister.registerIcon(this.getTextureName() + "side");
		blockIcon = iconregister.registerIcon(this.getTextureName());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 ? blockIcon : (side == 1 ? blockIcon : topbottomIcon);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}

		if(!world.isRemote)
		{
			player.openGui(NanotechMod.modInstance, 0, world, x, y, z);
		}

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityMultiplier();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityMultiplier && stack.hasDisplayName())
		{
			TileEntityMultiplier multiplier = (TileEntityMultiplier)te;
			multiplier.setCustomName(stack.getDisplayName());
		}
	}
}