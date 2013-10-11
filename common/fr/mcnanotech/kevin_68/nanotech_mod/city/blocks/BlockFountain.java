package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;

public class BlockFountain extends BlockContainer
{
	private Icon top;

	public BlockFountain(int id)
	{
		super(id, Material.iron);
	}

	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityFountain();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if(te == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(Nanotech_mod_City.modInstance, 4, world, x, y, z);
		return true;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("stone_slab_top");
		this.top = iconregister.registerIcon("nanotech_mod_city:fountainTop");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(side == 1)
		{
			return this.top;
		}

		return this.blockIcon;
	}
}