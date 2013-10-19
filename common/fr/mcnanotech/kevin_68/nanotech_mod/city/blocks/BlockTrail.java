package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrail;

public class BlockTrail extends Block
{
	private Icon top, left, bottom, right, topRight, topLeft, topBottom, topLeftBottom, topRightBottom, topLeftRight, leftRight, leftBottom, leftBottomRight, rightBottom, all, topRightDTR, topLeftDTL, leftBottomDBL, rightBottomDBR, topLeftBottomDTL, topLeftBottomDBL, topLeftBottomDTLBL, topRightBottomDTR, topRightBottomDBR, topRightBottomDTRBR, topLeftRightDTL, topLeftRightDTR, topLeftRightDTLTR,
			leftBottomRightDBL, leftBottomRightDBR, leftBottomRightDBLBR, allDTL, allDTR, allDBL, allDBR, allDTLTR, allDTLBL, allDTLBR, allDTRBL, allDTRBR, allDBLBR, allDTLTRBR, allDTRBRBL, allDBRBLTL, allDBLTLTR, allDTLTRBLBR, nothing, empty, handIcon;

	public BlockTrail(int id, Material material)
	{
		super(id, material);
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
		int l = 0;
		int i1 = 0;
		int j1 = 0;

		for(int k1 = -1; k1 <= 1; ++k1)
		{
			for(int l1 = -1; l1 <= 1; ++l1)
			{
				int i2 = blockaccess.getBiomeGenForCoords(x + l1, z + k1).getBiomeGrassColor();
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}
		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		if(side == 1)
		{
			// --------8--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.allDTLTRBLBR;
			}
			// --------7--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.allDBLTLTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.allDBRBLTL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.allDTRBRBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.allDTLTRBR;
			}
			// --------6--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.allDBLBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.allDTRBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.allDTRBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.allDTLBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.allDTLBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.allDTLTR;
			}

			// --------5--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.allDBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.allDBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.allDTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.allDTL;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.leftBottomRightDBLBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.topLeftRightDTLTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.topRightBottomDTRBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.topLeftBottomDTLBL;
			}
			// --------4--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.leftBottomRightDBR;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.leftBottomRightDBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.topLeftRightDTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.topLeftRightDTL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.topRightBottomDBR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.topRightBottomDTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.topLeftBottomDBL;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.topLeftBottomDTL;
			}

			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID)
			{
				return this.all;
			}
			// --------3--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z - 1) == this.blockID)
			{
				return this.topRightDTR;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x - 1, y, z - 1) == this.blockID)
			{
				return this.topLeftDTL;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z + 1) == this.blockID)
			{
				return this.leftBottomDBL;
			}
			if(blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z + 1) == this.blockID)
			{
				return this.rightBottomDBR;
			}

			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID)
			{
				return this.topLeftRight;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.leftBottomRight;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.topRightBottom;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.topLeftBottom;
			}
			// --------2--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x + 1, y, z) == this.blockID)
			{
				return this.leftRight;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.topBottom;
			}
			if(blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.rightBottom;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.leftBottom;
			}
			if(blockAccess.getBlockId(x + 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z - 1) == this.blockID)
			{
				return this.topRight;
			}
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID && blockAccess.getBlockId(x, y, z - 1) == this.blockID)
			{
				return this.topLeft;
			}
			// --------1--------------------------------------------------------------------------------------------------------------------
			if(blockAccess.getBlockId(x - 1, y, z) == this.blockID)
			{
				return this.left;
			}
			if(blockAccess.getBlockId(x + 1, y, z) == this.blockID)
			{
				return this.right;
			}
			if(blockAccess.getBlockId(x, y, z - 1) == this.blockID)
			{
				return this.top;
			}
			if(blockAccess.getBlockId(x, y, z + 1) == this.blockID)
			{
				return this.bottom;
			}
			return this.nothing;

		}
		return this.empty;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		this.top = iconRegister.registerIcon("nanotech_mod_city:trailTop");
		this.topRight = iconRegister.registerIcon("nanotech_mod_city:trailTopRight");
		this.topLeft = iconRegister.registerIcon("nanotech_mod_city:trailTopLeft");
		this.topBottom = iconRegister.registerIcon("nanotech_mod_city:trailTopBottom");
		this.topLeftBottom = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftBottom");
		this.topRightBottom = iconRegister.registerIcon("nanotech_mod_city:trailTopRightBottom");
		this.topLeftRight = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftRight");
		this.leftRight = iconRegister.registerIcon("nanotech_mod_city:trailLeftRight");
		this.leftBottom = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottom");
		this.leftBottomRight = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottomRight");
		this.rightBottom = iconRegister.registerIcon("nanotech_mod_city:trailRightBottom");
		this.left = iconRegister.registerIcon("nanotech_mod_city:trailLeft");
		this.bottom = iconRegister.registerIcon("nanotech_mod_city:trailBottom");
		this.right = iconRegister.registerIcon("nanotech_mod_city:trailRight");
		this.all = iconRegister.registerIcon("nanotech_mod_city:trailAll");
		this.topRightDTR = iconRegister.registerIcon("nanotech_mod_city:trailTopRightDTR");
		this.topLeftDTL = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftDTL");
		this.rightBottomDBR = iconRegister.registerIcon("nanotech_mod_city:trailRightBottomDBR");
		this.leftBottomDBL = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottomDBL");
		this.topLeftBottomDTL = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftBottomDTL");
		this.topLeftBottomDBL = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftBottomDBL");
		this.topLeftBottomDTLBL = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftBottomDTLBL");
		this.topRightBottomDTR = iconRegister.registerIcon("nanotech_mod_city:trailTopRightBottomDTR");
		this.topRightBottomDBR = iconRegister.registerIcon("nanotech_mod_city:trailTopRightBottomDBR");
		this.topRightBottomDTRBR = iconRegister.registerIcon("nanotech_mod_city:trailTopRightBottomDTRBR");
		this.topLeftRightDTL = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftRightDTL");
		this.topLeftRightDTR = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftRightDTR");
		this.topLeftRightDTLTR = iconRegister.registerIcon("nanotech_mod_city:trailTopLeftRightDTLTR");
		this.leftBottomRightDBL = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottomRightDBL");
		this.leftBottomRightDBR = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottomRightDBR");
		this.leftBottomRightDBLBR = iconRegister.registerIcon("nanotech_mod_city:trailLeftBottomRightDBLBR");
		this.allDTL = iconRegister.registerIcon("nanotech_mod_city:trailAllDTL");
		this.allDTR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTR");
		this.allDBL = iconRegister.registerIcon("nanotech_mod_city:trailAllDBL");
		this.allDBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDBR");
		this.allDTLTR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTLTR");
		this.allDTLBL = iconRegister.registerIcon("nanotech_mod_city:trailAllDTLBL");
		this.allDTLBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTLBR");
		this.allDTRBL = iconRegister.registerIcon("nanotech_mod_city:trailAllDTRBL");
		this.allDTRBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTRBR");
		this.allDBLBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDBLBR");
		this.allDTLTRBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTLTRBR");
		this.allDTRBRBL = iconRegister.registerIcon("nanotech_mod_city:trailAllDTRBRBL");
		this.allDBRBLTL = iconRegister.registerIcon("nanotech_mod_city:trailAllDBRBLTL");
		this.allDBLTLTR = iconRegister.registerIcon("nanotech_mod_city:trailAllDBLTLTR");
		this.allDTLTRBLBR = iconRegister.registerIcon("nanotech_mod_city:trailAllDTLTRBLBR");
		this.empty = iconRegister.registerIcon("nanotech_mod_city:empty");
		this.nothing = iconRegister.registerIcon("nanotech_mod_city:trailNothing");
		this.handIcon = iconRegister.registerIcon("nanotech_mod_city:TrailInHand");
	}

	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? handIcon : Block.grass.getIcon(side, 0);
	}
}