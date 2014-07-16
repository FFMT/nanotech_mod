/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;

public class BlockSpotLight extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private IIcon top;

	public BlockSpotLight()
	{
		super(Material.iron);
		this.setLightLevel(1.0F);
	}

	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntitySpotLight();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		 TileEntity te = world.getTileEntity(x, y, z);
		 if(te instanceof TileEntitySpotLight)
		 {
			 TileEntitySpotLight tile = (TileEntitySpotLight)te;
			 tile.setDefaultValue();
		 }
		world.markBlockForUpdate(x, y, z);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return false;
		}
		else
		{
			player.openGui(NanotechMod.modInstance, 0, world, x, y, z);
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		super.registerBlockIcons(iconregister);
		this.top = iconregister.registerIcon(this.getTextureName() + "2");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if(side == 1 || side == 0)
		{
			return this.top;
		}
		else
		{
			return this.blockIcon;
		}
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
}