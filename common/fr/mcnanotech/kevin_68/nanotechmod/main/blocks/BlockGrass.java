package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrass extends Block
{
	private Icon iconTop;
	private Icon iconSnowSide;

	public BlockGrass(int id)
	{
		super(id, Material.grass);
		this.setTickRandomly(true);
	}

	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
	{
		return true;
	}

	public void registerIcons(IconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nanotechmod:grass_side");
		iconTop = iconregister.registerIcon("nanotechmod:grass_top");
		iconSnowSide = iconregister.registerIcon("nanotechmod:grass_side_snow");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? iconTop : (side == 0 ? Block.dirt.getBlockTextureFromSide(side) : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		if(side == 1)
		{
			return iconTop;
		}
		else if(side == 0)
		{
			return Block.dirt.getBlockTextureFromSide(side);
		}
		else
		{
			Material material = blockaccess.getBlockMaterial(x, y + 1, z);
			return material != Material.snow && material != Material.craftedSnow ? blockIcon : iconSnowSide;
		}
	}

	public void updateTick(World world, int x, int y, int z, Random par5Random)
	{
		if(!world.isRemote)
		{
			if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, Block.dirt.blockID, 0, 3);
			}
			else if(world.getBlockLightValue(x, y + 1, z) >= 9)
			{
				for(int var6 = 0; var6 < 4; ++var6)
				{
					int var7 = x + par5Random.nextInt(3) - 1;
					int var8 = y + par5Random.nextInt(5) - 3;
					int var9 = z + par5Random.nextInt(3) - 1;
					int var10 = world.getBlockId(var7, var8 + 1, var9);

					if((world.getBlockId(var7, var8, var9) == Block.dirt.blockID && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlockId(var7, var8, var9) == Block.grass.blockID && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlockId(var7, var8, var9) == Block.mycelium.blockID && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (world.getBlockId(var7, var8, var9) == Block.tilledField.blockID && world.getBlockLightValue(var7, var8 + 1, var9) >= 4 && world.getBlockLightOpacity(var7, var8 + 1, var9) <= 2))
					{
						world.setBlock(var7, var8, var9, NanotechBlock.nanoGrass.blockID, 0, 3);
					}
				}
			}
		}
	}

	public int idDropped(int metadata, Random random, int par3)
	{
		return Block.dirt.idDropped(0, random, par3);
	}
}