package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrail;

public class BlockTrail extends BlockContainer
{
	private Icon top, left, bottom, right, topRight, topLeft, topBottom,
			topLeftBottom, topRightBottom, topLeftRight, leftRight, leftBottom,
			leftBottomRight, rightBottom, all, topRightDTR, topLeftDTL,
			leftBottomDBL, rightBottomDBR, topLeftBottomDTL, topLeftBottomDBL,
			topLeftBottomDTLBL, topRightBottomDTR, topRightBottomDBR,
			topRightBottomDTRBR, topLeftRightDTL, topLeftRightDTR,
			topLeftRightDTLTR, leftBottomRightDBL, leftBottomRightDBR,
			leftBottomRightDBLBR, allDTL, allDTR, allDBL, allDBR, allDTLTR,
			allDTLBL, allDTLBR, allDTRBL, allDTRBR, allDBLBR, allDTLTRBR,
			allDTRBRBL, allDBRBLTL, allDBLTLTR, allDTLTRBLBR, nothing, empty,
			handIcon;

	public BlockTrail(int id, Material material)
	{
		super(id, material);
	}

	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityTrail();
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
		this.top = iconRegister.registerIcon("Nanotech_mod_City:trailTop");
		this.topRight = iconRegister.registerIcon("Nanotech_mod_City:trailTopRight");
		this.topLeft = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeft");
		this.topBottom = iconRegister.registerIcon("Nanotech_mod_City:trailTopBottom");
		this.topLeftBottom = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftBottom");
		this.topRightBottom = iconRegister.registerIcon("Nanotech_mod_City:trailTopRightBottom");
		this.topLeftRight = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftRight");
		this.leftRight = iconRegister.registerIcon("Nanotech_mod_City:trailLeftRight");
		this.leftBottom = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottom");
		this.leftBottomRight = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottomRight");
		this.rightBottom = iconRegister.registerIcon("Nanotech_mod_City:trailRightbottom");
		this.left = iconRegister.registerIcon("Nanotech_mod_City:trailLeft");
		this.bottom = iconRegister.registerIcon("Nanotech_mod_City:trailBottom");
		this.right = iconRegister.registerIcon("Nanotech_mod_City:trailRight");
		this.all = iconRegister.registerIcon("Nanotech_mod_City:trailAll");
		this.topRightDTR = iconRegister.registerIcon("Nanotech_mod_City:trailTopRightDTR");
		this.topLeftDTL = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftDTL");
		this.rightBottomDBR = iconRegister.registerIcon("Nanotech_mod_City:trailRightBottomDBR");
		this.leftBottomDBL = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottomDBL");
		this.topLeftBottomDTL = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftBottomDTL");
		this.topLeftBottomDBL = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftBottomDBL");
		this.topLeftBottomDTLBL = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftBottomDTLBL");
		this.topRightBottomDTR = iconRegister.registerIcon("Nanotech_mod_City:trailTopRightBottomDTR");
		this.topRightBottomDBR = iconRegister.registerIcon("Nanotech_mod_City:trailTopRightBottomDBR");
		this.topRightBottomDTRBR = iconRegister.registerIcon("Nanotech_mod_City:trailTopRightBottomDTRBR");
		this.topLeftRightDTL = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftRightDTL");
		this.topLeftRightDTR = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftRightDTR");
		this.topLeftRightDTLTR = iconRegister.registerIcon("Nanotech_mod_City:trailTopLeftRightDTLTR");
		this.leftBottomRightDBL = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottomRightDBL");
		this.leftBottomRightDBR = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottomRightDBR");
		this.leftBottomRightDBLBR = iconRegister.registerIcon("Nanotech_mod_City:trailLeftBottomRightDBLBR");
		this.allDTL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTL");
		this.allDTR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTR");
		this.allDBL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDBL");
		this.allDBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDBR");
		this.allDTLTR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTLTR");
		this.allDTLBL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTLBL");
		this.allDTLBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTLBR");
		this.allDTRBL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTRBL");
		this.allDTRBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTRBR");
		this.allDBLBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDBLBR");
		this.allDTLTRBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTLTRBR");
		this.allDTRBRBL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTRBRBL");
		this.allDBRBLTL = iconRegister.registerIcon("Nanotech_mod_City:trailAllDBRBLTL");
		this.allDBLTLTR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDBLTLTR");
		this.allDTLTRBLBR = iconRegister.registerIcon("Nanotech_mod_City:trailAllDTLTRBLBR");
		this.empty = iconRegister.registerIcon("Nanotech_mod_City:empty");
		this.nothing = iconRegister.registerIcon("Nanotech_mod_City:trailNothing");
		this.handIcon = iconRegister.registerIcon("Nanotech_mod_City:TrailInHand");
	}

	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? handIcon : Block.grass.getIcon(side, 0);
	}
}