package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityFountain;

public class BlockFountain extends BlockContainer
{
	private Icon top;
	private Icon side;

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
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(Nanotech_mod.modInstance, 4, world, x, y, z);

		return true;
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
		this.side = iconregister.registerIcon("Nanotech_mod:FountainSide");
		this.top = iconregister.registerIcon("Nanotech_mod:FoutainTop");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(side == 1)
		{
			return this.top;
		}
		else
		{
			return this.side;
		}
	}

}
