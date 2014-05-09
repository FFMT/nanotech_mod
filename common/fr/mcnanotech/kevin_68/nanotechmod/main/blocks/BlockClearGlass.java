package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClearGlass extends Block
{
	private IIcon[] tex = new IIcon[47];

	public BlockClearGlass()
	{
		super(Material.glass);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		for(int i = 0; i < this.tex.length; i++)
		{
			tex[i] = iconregister.registerIcon("nanotechmod:clearglass/tex" + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return tex[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess ba, int x, int y, int z, int side)
	{
		if(((ba.getBlock(x, y - 1, z).isOpaqueCube() || ba.getBlock(x, y - 1, z) == this) && side == 0) || ((ba.getBlock(x, y + 1, z).isOpaqueCube() || ba.getBlock(x, y + 1, z) == this) && side == 1) || ((ba.getBlock(x, y, z - 1).isOpaqueCube() || ba.getBlock(x, y, z - 1) == this) && side == 2) || ((ba.getBlock(x, y, z + 1).isOpaqueCube() || ba.getBlock(x, y, z + 1) == this) && side == 3) || ((ba.getBlock(x - 1, y, z).isOpaqueCube() || ba.getBlock(x - 1, y, z) == this) && side == 4) || ((ba.getBlock(x + 1, y, z).isOpaqueCube() || ba.getBlock(x + 1, y, z) == this) && side == 5))
		{
			return tex[1];
		}

		if(side == 0 || side == 1)
		{
			if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[1];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[40];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[41];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[42];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[39];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[33];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[34];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[35];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[36];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[37];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[38];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[29];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[30];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[31];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[32];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[16];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x + 1, y, z + 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[22];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[20];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[21];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[19];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[17];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[18];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[28];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[27];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[26];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[25];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[24];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[23];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[11];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[10];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[9];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[8];
			}

			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x + 1, y, z + 1) == this)
			{
				return tex[43];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x + 1, y, z - 1) == this)
			{
				return tex[44];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x - 1, y, z + 1) == this)
			{
				return tex[45];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x - 1, y, z - 1) == this)
			{
				return tex[46];
			}

			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[12];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[13];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[14];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[15];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this)
			{
				return tex[7];
			}
			else if(ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[6];
			}
			else if(ba.getBlock(x + 1, y, z) == this)
			{
				return tex[5];
			}
			else if(ba.getBlock(x - 1, y, z) == this)
			{
				return tex[4];
			}
			else if(ba.getBlock(x, y, z + 1) == this)
			{
				return tex[3];
			}
			else if(ba.getBlock(x, y, z - 1) == this)
			{
				return tex[2];
			}
		}

		if(side == 2 || side == 3)
		{
			if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[1];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[41];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[40];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[39];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[42];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[38];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[37];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[35];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[36];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[34];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[33];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[32];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[31];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[30];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[29];
			}
			if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[16];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[19];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[17];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[18];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[22];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[20];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[21];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[28];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[26];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[27];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[25];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[23];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[24];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this)
			{
				return tex[10];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[11];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[9];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[8];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x + 1, y + 1, z) == this)
			{
				return tex[44];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x + 1, y - 1, z) == this)
			{
				return tex[43];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x - 1, y + 1, z) == this)
			{
				return tex[46];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x - 1, y - 1, z) == this)
			{
				return tex[45];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[13];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x, y + 1, z) == this)
			{
				return tex[12];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y - 1, z) == this)
			{
				return tex[15];
			}
			else if(ba.getBlock(x + 1, y, z) == this && ba.getBlock(x, y + 1, z) == this)
			{
				return tex[14];
			}
			else if(ba.getBlock(x - 1, y, z) == this && ba.getBlock(x + 1, y, z) == this)
			{
				return tex[7];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this)
			{
				return tex[6];
			}
			else if(ba.getBlock(x - 1, y, z) == this)
			{
				return tex[4];
			}
			else if(ba.getBlock(x + 1, y, z) == this)
			{
				return tex[5];
			}
			else if(ba.getBlock(x, y - 1, z) == this)
			{
				return tex[3];
			}
			else if(ba.getBlock(x, y + 1, z) == this)
			{
				return tex[2];
			}
		}

		if(side == 4 || side == 5)
		{
			if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[1];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[39];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[40];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[41];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[42];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[35];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[37];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[38];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[33];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[34];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[36];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[32];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[29];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[30];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[31];
			}
			if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[16];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y + 1, z + 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[25];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[24];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[23];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[28];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[27];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[26];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[22];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[21];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[20];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[19];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[18];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[17];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[8];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[9];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[11];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[10];
			}

			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y + 1, z + 1) == this)
			{
				return tex[44];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y + 1, z - 1) == this)
			{
				return tex[46];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this && ba.getBlock(x, y - 1, z + 1) == this)
			{
				return tex[43];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y - 1, z - 1) == this)
			{
				return tex[45];
			}

			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[13];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[15];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z - 1) == this)
			{
				return tex[12];
			}
			else if(ba.getBlock(x, y + 1, z) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[14];
			}
			else if(ba.getBlock(x, y - 1, z) == this && ba.getBlock(x, y + 1, z) == this)
			{
				return tex[6];
			}
			else if(ba.getBlock(x, y, z - 1) == this && ba.getBlock(x, y, z + 1) == this)
			{
				return tex[7];
			}
			else if(ba.getBlock(x, y + 1, z) == this)
			{
				return tex[2];
			}
			else if(ba.getBlock(x, y - 1, z) == this)
			{
				return tex[3];
			}
			else if(ba.getBlock(x, y, z + 1) == this)
			{
				return tex[5];
			}
			else if(ba.getBlock(x, y, z - 1) == this)
			{
				return tex[4];
			}
		}
		return tex[0];
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}
}