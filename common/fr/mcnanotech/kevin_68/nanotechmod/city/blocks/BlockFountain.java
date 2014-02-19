/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;

public class BlockFountain extends BlockContainer
{
	private IIcon top;

	public BlockFountain()
	{
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityFountain();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity te = world.getTileEntity(x, y, z);

		if(te == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(NanotechModCity.modInstance, 4, world, x, y, z);
		return true;
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

	@Override
	public int getRenderType()
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("stone_slab_top");
		this.top = iconregister.registerIcon("nanotechmodcity:fountaintop");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if(side == 1)
		{
			return this.top;
		}

		return this.blockIcon;
	}
}