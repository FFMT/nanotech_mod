package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;

public class BlockTextSpotLight extends BlockContainer
{
	protected BlockTextSpotLight()
	{
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
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
	public void registerIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("nanotechmodcity:SpotLightSides");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
		ItemStack itemstack = player.inventory.getCurrentItem();

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}
		else
		{
			player.openGui(NanotechModCity.modInstance, 3, world, x, y, z);
			return true;
		}
	}

}
