package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;

public class BlockTextSpotLight extends BlockContainer
{
	protected BlockTextSpotLight(int id)
	{
		super(id, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityTextSpotLight();
	}

	public boolean isOpaqueCube()
	{
		return false;
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
		this.blockIcon = iconregister.registerIcon("nanotech_mod_city:SpotLightSides");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		ItemStack itemstack = player.inventory.getCurrentItem();

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}
		else
		{
			player.openGui(Nanotech_mod_City.modInstance, 3, world, x, y, z);
			return true;
		}
	}

}
