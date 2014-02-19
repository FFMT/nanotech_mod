/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrail;

public class BlockTrail extends Block
{
	private IIcon top, left, bottom, right, topRight, topLeft, topBottom, topLeftBottom, topRightBottom, topLeftRight, leftRight, leftBottom, leftBottomRight, rightBottom, all, topRightDTR, topLeftDTL, leftBottomDBL, rightBottomDBR, topLeftBottomDTL, topLeftBottomDBL, topLeftBottomDTLBL, topRightBottomDTR, topRightBottomDBR, topRightBottomDTRBR, topLeftRightDTL, topLeftRightDTR,
			topLeftRightDTLTR, leftBottomRightDBL, leftBottomRightDBR, leftBottomRightDBLBR, allDTL, allDTR, allDBL, allDBR, allDTLTR, allDTLBL, allDTLBR, allDTRBL, allDTRBR, allDBLBR, allDTLTRBR, allDTRBRBL, allDBRBLTL, allDBLTLTR, allDTLTRBLBR, nothing, empty, handIcon;

	public BlockTrail()
	{
		super(Material.ground);
	}

	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityTrail();
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public int getRenderType()
	{
		return 0;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return Blocks.grass.colorMultiplier(blockaccess, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		if(side == 1)
		{
			// --------8--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.allDTLTRBLBR;
			}
			// --------7--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.allDBLTLTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.allDBRBLTL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.allDTRBRBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.allDTLTRBR;
			}
			// --------6--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.allDBLBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.allDTRBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.allDTRBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.allDTLBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.allDTLBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.allDTLTR;
			}

			// --------5--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.allDBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.allDBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.allDTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.allDTL;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.leftBottomRightDBLBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.topLeftRightDTLTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.topRightBottomDTRBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.topLeftBottomDTLBL;
			}
			// --------4--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.leftBottomRightDBR;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.leftBottomRightDBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.topLeftRightDTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.topLeftRightDTL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.topRightBottomDBR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.topRightBottomDTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.topLeftBottomDBL;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.topLeftBottomDTL;
			}

			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x - 1, y, z) == this)
			{
				return this.all;
			}
			// --------3--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x + 1, y, z - 1) == this)
			{
				return this.topRightDTR;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x - 1, y, z - 1) == this)
			{
				return this.topLeftDTL;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x - 1, y, z + 1) == this)
			{
				return this.leftBottomDBL;
			}
			if(blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this && blockAccess.getBlock(x + 1, y, z + 1) == this)
			{
				return this.rightBottomDBR;
			}

			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this)
			{
				return this.topLeftRight;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.leftBottomRight;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.topRightBottom;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.topLeftBottom;
			}
			// --------2--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x + 1, y, z) == this)
			{
				return this.leftRight;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.topBottom;
			}
			if(blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.rightBottom;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.leftBottom;
			}
			if(blockAccess.getBlock(x + 1, y, z) == this && blockAccess.getBlock(x, y, z - 1) == this)
			{
				return this.topRight;
			}
			if(blockAccess.getBlock(x - 1, y, z) == this && blockAccess.getBlock(x, y, z - 1) == this)
			{
				return this.topLeft;
			}
			// --------1--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlock(x - 1, y, z) == this)
			{
				return this.left;
			}
			if(blockAccess.getBlock(x + 1, y, z) == this)
			{
				return this.right;
			}
			if(blockAccess.getBlock(x, y, z - 1) == this)
			{
				return this.top;
			}
			if(blockAccess.getBlock(x, y, z + 1) == this)
			{
				return this.bottom;
			}
			return this.nothing;

		}
		return this.empty;
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.top = iconRegister.registerIcon("nanotechmodcity:trailTop");
		this.topRight = iconRegister.registerIcon("nanotechmodcity:trailTopRight");
		this.topLeft = iconRegister.registerIcon("nanotechmodcity:trailTopLeft");
		this.topBottom = iconRegister.registerIcon("nanotechmodcity:trailTopBottom");
		this.topLeftBottom = iconRegister.registerIcon("nanotechmodcity:trailTopLeftBottom");
		this.topRightBottom = iconRegister.registerIcon("nanotechmodcity:trailTopRightBottom");
		this.topLeftRight = iconRegister.registerIcon("nanotechmodcity:trailTopLeftRight");
		this.leftRight = iconRegister.registerIcon("nanotechmodcity:trailLeftRight");
		this.leftBottom = iconRegister.registerIcon("nanotechmodcity:trailLeftBottom");
		this.leftBottomRight = iconRegister.registerIcon("nanotechmodcity:trailLeftBottomRight");
		this.rightBottom = iconRegister.registerIcon("nanotechmodcity:trailRightBottom");
		this.left = iconRegister.registerIcon("nanotechmodcity:trailLeft");
		this.bottom = iconRegister.registerIcon("nanotechmodcity:trailBottom");
		this.right = iconRegister.registerIcon("nanotechmodcity:trailRight");
		this.all = iconRegister.registerIcon("nanotechmodcity:trailAll");
		this.topRightDTR = iconRegister.registerIcon("nanotechmodcity:trailTopRightDTR");
		this.topLeftDTL = iconRegister.registerIcon("nanotechmodcity:trailTopLeftDTL");
		this.rightBottomDBR = iconRegister.registerIcon("nanotechmodcity:trailRightBottomDBR");
		this.leftBottomDBL = iconRegister.registerIcon("nanotechmodcity:trailLeftBottomDBL");
		this.topLeftBottomDTL = iconRegister.registerIcon("nanotechmodcity:trailTopLeftBottomDTL");
		this.topLeftBottomDBL = iconRegister.registerIcon("nanotechmodcity:trailTopLeftBottomDBL");
		this.topLeftBottomDTLBL = iconRegister.registerIcon("nanotechmodcity:trailTopLeftBottomDTLBL");
		this.topRightBottomDTR = iconRegister.registerIcon("nanotechmodcity:trailTopRightBottomDTR");
		this.topRightBottomDBR = iconRegister.registerIcon("nanotechmodcity:trailTopRightBottomDBR");
		this.topRightBottomDTRBR = iconRegister.registerIcon("nanotechmodcity:trailTopRightBottomDTRBR");
		this.topLeftRightDTL = iconRegister.registerIcon("nanotechmodcity:trailTopLeftRightDTL");
		this.topLeftRightDTR = iconRegister.registerIcon("nanotechmodcity:trailTopLeftRightDTR");
		this.topLeftRightDTLTR = iconRegister.registerIcon("nanotechmodcity:trailTopLeftRightDTLTR");
		this.leftBottomRightDBL = iconRegister.registerIcon("nanotechmodcity:trailLeftBottomRightDBL");
		this.leftBottomRightDBR = iconRegister.registerIcon("nanotechmodcity:trailLeftBottomRightDBR");
		this.leftBottomRightDBLBR = iconRegister.registerIcon("nanotechmodcity:trailLeftBottomRightDBLBR");
		this.allDTL = iconRegister.registerIcon("nanotechmodcity:trailAllDTL");
		this.allDTR = iconRegister.registerIcon("nanotechmodcity:trailAllDTR");
		this.allDBL = iconRegister.registerIcon("nanotechmodcity:trailAllDBL");
		this.allDBR = iconRegister.registerIcon("nanotechmodcity:trailAllDBR");
		this.allDTLTR = iconRegister.registerIcon("nanotechmodcity:trailAllDTLTR");
		this.allDTLBL = iconRegister.registerIcon("nanotechmodcity:trailAllDTLBL");
		this.allDTLBR = iconRegister.registerIcon("nanotechmodcity:trailAllDTLBR");
		this.allDTRBL = iconRegister.registerIcon("nanotechmodcity:trailAllDTRBL");
		this.allDTRBR = iconRegister.registerIcon("nanotechmodcity:trailAllDTRBR");
		this.allDBLBR = iconRegister.registerIcon("nanotechmodcity:trailAllDBLBR");
		this.allDTLTRBR = iconRegister.registerIcon("nanotechmodcity:trailAllDTLTRBR");
		this.allDTRBRBL = iconRegister.registerIcon("nanotechmodcity:trailAllDTRBRBL");
		this.allDBRBLTL = iconRegister.registerIcon("nanotechmodcity:trailAllDBRBLTL");
		this.allDBLTLTR = iconRegister.registerIcon("nanotechmodcity:trailAllDBLTLTR");
		this.allDTLTRBLBR = iconRegister.registerIcon("nanotechmodcity:trailAllDTLTRBLBR");
		this.empty = iconRegister.registerIcon("nanotechmodcity:empty");
		this.nothing = iconRegister.registerIcon("nanotechmodcity:trailNothing");
		this.handIcon = iconRegister.registerIcon("nanotechmodcity:TrailInHand");
	}

	public IIcon getIcon(int side, int metadata)
	{
		return side == 1 ? handIcon : Blocks.grass.getIcon(side, 0);
	}
}