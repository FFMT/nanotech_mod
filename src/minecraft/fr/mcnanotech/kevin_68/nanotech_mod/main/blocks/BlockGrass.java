package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
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
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        blockIcon = par1IconRegister.registerIcon("Nanotech_mod:grass_side");
        iconTop = par1IconRegister.registerIcon("Nanotech_mod:grass_top");
        iconSnowSide = par1IconRegister.registerIcon("Nanotech_mod:grass_side_snow");
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int damage)
    {
        return side == 1 ? iconTop : (side == 0 ? Block.dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)
    {
        if (side == 1)
        {
            return iconTop;
        }
        else if (side == 0)
        {
            return Block.dirt.getBlockTextureFromSide(side);
        }
        else
        {
            Material material = par1IBlockAccess.getBlockMaterial(x, y + 1, z);
            return material != Material.snow && material != Material.craftedSnow ? blockIcon : iconSnowSide;
        }
    }

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
			{
				par1World.setBlock(par2, par3, par4, Block.dirt.blockID, 0, 3);
			}
			else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
			{
				for (int var6 = 0; var6 < 4; ++var6)
				{
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					int var10 = par1World.getBlockId(var7, var8 + 1, var9);

					if ((par1World.getBlockId(var7, var8, var9) == Block.dirt.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (par1World.getBlockId(var7, var8, var9) == Block.grass.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (par1World.getBlockId(var7, var8, var9) == Block.mycelium.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) || (par1World.getBlockId(var7, var8, var9) == Block.tilledField.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2))
					{
						par1World.setBlock(var7, var8, var9, NanotechBlock.BlockGrass.blockID, 0, 3);
					}
				}
			}
		}
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Block.dirt.idDropped(0, par2Random, par3);
	}
}
