package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityTrail;

public class BlockTrail extends BlockContainer
{
	Icon top;
	Icon left;
	Icon bottom;
	Icon right;
	Icon topRight;
	Icon topLeft;
	Icon topBottom;
	Icon topLeftBottom;
	Icon topRightBottom;
	Icon topLeftRight;
	Icon leftRight;
	Icon leftBottom;
	Icon leftBottomRight;
	Icon rightBottom;
	Icon all;
	Icon topRightDTR;
	Icon topLeftDTL;
	Icon leftBottomDBL;
	Icon rightBottomDBR;
	Icon topLeftBottomDTL;
	Icon topLeftBottomDBL;
	Icon topLeftBottomDTLBL;
	Icon topRightBottomDTR;
	Icon topRightBottomDBR;
	Icon topRightBottomDTRBR;
	Icon topLeftRightDTL;
	Icon topLeftRightDTR;
	Icon topLeftRightDTLTR;
	Icon leftBottomRightDBL;
	Icon leftBottomRightDBR;
	Icon leftBottomRightDBLBR;
	Icon allDTL;
	Icon allDTR;
	Icon allDBL;
	Icon allDBR;
	Icon allDTLTR;
	Icon allDTLBL;
	Icon allDTLBR;
	Icon allDTRBL;
	Icon allDTRBR;
	Icon allDBLBR;
	Icon allDTLTRBR;
	Icon allDTRBRBL;
	Icon allDBRBLTL;
	Icon allDBLTLTR;
	Icon allDTLTRBLBR;
	Icon nothing;
	Icon empty;

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
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return this.getBlockColor();
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
		this.top = iconRegister.registerIcon("Nanotech_mod:trailTop");
		this.topRight = iconRegister.registerIcon("Nanotech_mod:trailTopRight");
		this.topLeft = iconRegister.registerIcon("Nanotech_mod:trailTopLeft");
		this.topBottom = iconRegister.registerIcon("Nanotech_mod:trailTopBottom");
		this.topLeftBottom = iconRegister.registerIcon("Nanotech_mod:trailTopLeftBottom");
		this.topRightBottom = iconRegister.registerIcon("Nanotech_mod:trailTopRightBottom");
		this.topLeftRight = iconRegister.registerIcon("Nanotech_mod:trailTopLeftRight");
		this.leftRight = iconRegister.registerIcon("Nanotech_mod:trailLeftRight");
		this.leftBottom = iconRegister.registerIcon("Nanotech_mod:trailLeftBottom");
		this.leftBottomRight = iconRegister.registerIcon("Nanotech_mod:trailLeftBottomRight");
		this.rightBottom = iconRegister.registerIcon("Nanotech_mod:trailRightbottom");
		this.left = iconRegister.registerIcon("Nanotech_mod:trailLeft");
		this.bottom = iconRegister.registerIcon("Nanotech_mod:trailBottom");
		this.right = iconRegister.registerIcon("Nanotech_mod:trailRight");
		this.all = iconRegister.registerIcon("Nanotech_mod:trailAll");
		this.topRightDTR = iconRegister.registerIcon("Nanotech_mod:trailTopRightDTR");
		this.topLeftDTL = iconRegister.registerIcon("Nanotech_mod:trailTopLeftDTL");
		this.rightBottomDBR = iconRegister.registerIcon("Nanotech_mod:trailRightBottomDBR");
		this.leftBottomDBL = iconRegister.registerIcon("Nanotech_mod:trailLeftBottomDBL");
		this.topLeftBottomDTL = iconRegister.registerIcon("Nanotech_mod:trailTopLeftBottomDTL");
		this.topLeftBottomDBL = iconRegister.registerIcon("Nanotech_mod:trailTopLeftBottomDBL");
		this.topLeftBottomDTLBL = iconRegister.registerIcon("Nanotech_mod:trailTopLeftBottomDTLBL");
		this.topRightBottomDTR = iconRegister.registerIcon("Nanotech_mod:trailTopRightBottomDTR");
		this.topRightBottomDBR = iconRegister.registerIcon("Nanotech_mod:trailTopRightBottomDBR");
		this.topRightBottomDTRBR = iconRegister.registerIcon("Nanotech_mod:trailTopRightBottomDTRBR");
		this.topLeftRightDTL = iconRegister.registerIcon("Nanotech_mod:trailTopLeftRightDTL");
		this.topLeftRightDTR = iconRegister.registerIcon("Nanotech_mod:trailTopLeftRightDTR");
		this.topLeftRightDTLTR = iconRegister.registerIcon("Nanotech_mod:trailTopLeftRightDTLTR");
		this.leftBottomRightDBL = iconRegister.registerIcon("Nanotech_mod:trailLeftBottomRightDBL");
		this.leftBottomRightDBR = iconRegister.registerIcon("Nanotech_mod:trailLeftBottomRightDBR");
		this.leftBottomRightDBLBR = iconRegister.registerIcon("Nanotech_mod:trailLeftBottomRightDBLBR");
		this.allDTL = iconRegister.registerIcon("Nanotech_mod:trailAllDTL");
		this.allDTR = iconRegister.registerIcon("Nanotech_mod:trailAllDTR");
		this.allDBL = iconRegister.registerIcon("Nanotech_mod:trailAllDBL");
		this.allDBR = iconRegister.registerIcon("Nanotech_mod:trailAllDBR");
		this.allDTLTR = iconRegister.registerIcon("Nanotech_mod:trailAllDTLTR");
		this.allDTLBL = iconRegister.registerIcon("Nanotech_mod:trailAllDTLBL");
		this.allDTLBR = iconRegister.registerIcon("Nanotech_mod:trailAllDTLBR");
		this.allDTRBL = iconRegister.registerIcon("Nanotech_mod:trailAllDTRBL");
		this.allDTRBR = iconRegister.registerIcon("Nanotech_mod:trailAllDTRBR");
		this.allDBLBR = iconRegister.registerIcon("Nanotech_mod:trailAllDBLBR");
		this.allDTLTRBR = iconRegister.registerIcon("Nanotech_mod:trailAllDTLTRBR");
		this.allDTRBRBL = iconRegister.registerIcon("Nanotech_mod:trailAllDTRBRBL");
		this.allDBRBLTL = iconRegister.registerIcon("Nanotech_mod:trailAllDBRBLTL");
		this.allDBLTLTR = iconRegister.registerIcon("Nanotech_mod:trailAllDBLTLTR");
		this.allDTLTRBLBR = iconRegister.registerIcon("Nanotech_mod:trailAllDTLTRBLBR");
		this.empty = iconRegister.registerIcon("Nanotech_mod:empty");
		this.nothing = iconRegister.registerIcon("Nanotech_mod:trailNothing");
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return NanotechItem.Trail.itemID;
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return NanotechItem.Trail.itemID;
	}
}