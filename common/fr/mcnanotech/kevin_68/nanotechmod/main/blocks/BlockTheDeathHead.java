/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobThedeath;

public class BlockTheDeathHead extends Block
{
	private IIcon top, side, side2, back, face, bottom;

	public BlockTheDeathHead()
	{
		super(Material.iron);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		Block red = Blocks.redstone_block;
		Block net = Blocks.quartz_block;
		Block obs = Blocks.obsidian;

		super.onBlockAdded(world, x, y, z);

		if(/* NanotechMod.theDeathSpawn TODO change */true)
		{
			if(world.getBlock(x, y - 1, z).equals(red) && world.getBlock(x, y - 2, z).equals(net) && world.getBlock(x, y - 3, z).equals(net) && world.getBlock(x, y - 4, z).equals(net))
			{
				boolean flag0 = world.getBlock(x - 1, y - 1, z).equals(obs) && world.getBlock(x - 1, y - 2, z).equals(obs) && world.getBlock(x - 1, y - 3, z).equals(obs) && world.getBlock(x - 1, y - 4, z).equals(obs) && world.getBlock(x - 1, y - 1, z + 1).equals(obs) && world.getBlock(x - 1, y - 1, z - 1).equals(obs) && world.getBlock(x - 1, y - 2, z + 1).equals(obs) && world.getBlock(x - 1, y - 2, z - 1).equals(obs) && world.getBlock(x - 1, y - 3, z + 1).equals(obs) && world.getBlock(x, y - 1, z + 1).equals(net) && world.getBlock(x, y - 1, z - 1).equals(net) && world.getBlock(x, y - 1, z + 2).equals(net) && world.getBlock(x, y - 1, z - 2).equals(net) && world.getBlock(x - 1, y - 1, z + 2).equals(obs) && world.getBlock(x - 1, y - 1, z - 2).equals(obs) && world.getBlock(x - 1, y - 2, z + 2).equals(obs) && world.getBlock(x - 1, y - 2, z - 2).equals(obs);
				boolean flag1 = world.getBlock(x + 1, y - 1, z).equals(obs) && world.getBlock(x + 1, y - 2, z).equals(obs) && world.getBlock(x + 1, y - 3, z).equals(obs) && world.getBlock(x + 1, y - 4, z).equals(obs) && world.getBlock(x + 1, y - 1, z - 1).equals(obs) && world.getBlock(x + 1, y - 1, z + 1).equals(obs) && world.getBlock(x + 1, y - 2, z - 1).equals(obs) && world.getBlock(x + 1, y - 2, z + 1).equals(obs) && world.getBlock(x + 1, y - 3, z - 1).equals(obs) && world.getBlock(x, y - 1, z - 1).equals(net) && world.getBlock(x, y - 1, z + 1).equals(net) && world.getBlock(x, y - 1, z - 2).equals(net) && world.getBlock(x, y - 1, z + 2).equals(net) && world.getBlock(x + 1, y - 1, z - 2).equals(obs) && world.getBlock(x + 1, y - 1, z + 2).equals(obs) && world.getBlock(x + 1, y - 2, z - 2).equals(obs) && world.getBlock(x + 1, y - 2, z + 2).equals(obs);
				boolean flag2 = world.getBlock(x, y - 1, z - 1).equals(obs) && world.getBlock(x, y - 2, z - 1).equals(obs) && world.getBlock(x, y - 3, z - 1).equals(obs) && world.getBlock(x, y - 4, z - 1).equals(obs) && world.getBlock(x + 1, y - 1, z - 1).equals(obs) && world.getBlock(x - 1, y - 1, z - 1).equals(obs) && world.getBlock(x + 1, y - 2, z - 1).equals(obs) && world.getBlock(x - 1, y - 2, z - 1).equals(obs) && world.getBlock(x + 1, y - 3, z - 1).equals(obs) && world.getBlock(x + 1, y - 1, z).equals(net) && world.getBlock(x - 1, y - 1, z).equals(net) && world.getBlock(x + 2, y - 1, z).equals(net) && world.getBlock(x - 2, y - 1, z).equals(net) && world.getBlock(x + 2, y - 1, z - 1).equals(obs) && world.getBlock(x - 2, y - 1, z - 1).equals(obs) && world.getBlock(x + 2, y - 2, z - 1).equals(obs) && world.getBlock(x - 2, y - 2, z - 1).equals(obs);
				boolean flag3 = world.getBlock(x, y - 1, z + 1).equals(obs) && world.getBlock(x, y - 2, z + 1).equals(obs) && world.getBlock(x, y - 3, z + 1).equals(obs) && world.getBlock(x, y - 4, z + 1).equals(obs) && world.getBlock(x - 1, y - 1, z + 1).equals(obs) && world.getBlock(x + 1, y - 1, z + 1).equals(obs) && world.getBlock(x - 1, y - 2, z + 1).equals(obs) && world.getBlock(x + 1, y - 2, z + 1).equals(obs) && world.getBlock(x - 1, y - 3, z + 1).equals(obs) && world.getBlock(x - 1, y - 1, z).equals(net) && world.getBlock(x + 1, y - 1, z).equals(net) && world.getBlock(x - 2, y - 1, z).equals(net) && world.getBlock(x + 2, y - 1, z).equals(net) && world.getBlock(x - 2, y - 1, z + 1).equals(obs) && world.getBlock(x + 2, y - 1, z + 1).equals(obs) && world.getBlock(x - 2, y - 2, z + 1).equals(obs) && world.getBlock(x + 2, y - 2, z + 1).equals(obs);

				if(flag0 || flag1 || flag2 || flag3)
				{
					world.setBlockToAir(x, y, z);
					world.setBlockToAir(x, y - 1, z);
					world.setBlockToAir(x, y - 2, z);
					world.setBlockToAir(x, y - 3, z);
					world.setBlockToAir(x, y - 4, z);

					if(flag0)
					{
						world.setBlockToAir(x - 1, y - 1, z);
						world.setBlockToAir(x - 1, y - 2, z);
						world.setBlockToAir(x - 1, y - 3, z);
						world.setBlockToAir(x - 1, y - 4, z);
						world.setBlockToAir(x - 1, y - 1, z + 1);
						world.setBlockToAir(x - 1, y - 2, z + 1);
						world.setBlockToAir(x - 1, y - 3, z + 1);
						world.setBlockToAir(x - 1, y - 1, z - 1);
						world.setBlockToAir(x - 1, y - 2, z - 1);
						world.setBlockToAir(x - 1, y - 3, z - 1);
						world.setBlockToAir(x, y - 1, z + 1);
						world.setBlockToAir(x, y - 1, z - 1);
						world.setBlockToAir(x, y - 1, z + 2);
						world.setBlockToAir(x, y - 1, z - 2);
						world.setBlockToAir(x - 1, y - 1, z + 2);
						world.setBlockToAir(x - 1, y - 1, z - 2);
						world.setBlockToAir(x - 1, y - 2, z + 2);
						world.setBlockToAir(x - 1, y - 2, z - 2);
					}
					else if(flag1)
					{
						world.setBlockToAir(x + 1, y - 1, z);
						world.setBlockToAir(x + 1, y - 2, z);
						world.setBlockToAir(x + 1, y - 3, z);
						world.setBlockToAir(x + 1, y - 4, z);
						world.setBlockToAir(x + 1, y - 1, z - 1);
						world.setBlockToAir(x + 1, y - 2, z - 1);
						world.setBlockToAir(x + 1, y - 3, z - 1);
						world.setBlockToAir(x + 1, y - 1, z + 1);
						world.setBlockToAir(x + 1, y - 2, z + 1);
						world.setBlockToAir(x + 1, y - 3, z + 1);
						world.setBlockToAir(x, y - 1, z - 1);
						world.setBlockToAir(x, y - 1, z + 1);
						world.setBlockToAir(x, y - 1, z - 2);
						world.setBlockToAir(x, y - 1, z + 2);
						world.setBlockToAir(x + 1, y - 1, z - 2);
						world.setBlockToAir(x + 1, y - 1, z + 2);
						world.setBlockToAir(x + 1, y - 2, z - 2);
						world.setBlockToAir(x + 1, y - 2, z + 2);
					}
					else if(flag2)
					{
						world.setBlockToAir(x, y - 1, z - 1);
						world.setBlockToAir(x, y - 2, z - 1);
						world.setBlockToAir(x, y - 3, z - 1);
						world.setBlockToAir(x, y - 4, z - 1);
						world.setBlockToAir(x + 1, y - 1, z - 1);
						world.setBlockToAir(x + 1, y - 2, z - 1);
						world.setBlockToAir(x + 1, y - 3, z - 1);
						world.setBlockToAir(x - 1, y - 1, z - 1);
						world.setBlockToAir(x - 1, y - 2, z - 1);
						world.setBlockToAir(x - 1, y - 3, z - 1);
						world.setBlockToAir(x + 1, y - 1, z);
						world.setBlockToAir(x - 1, y - 1, z);
						world.setBlockToAir(x + 2, y - 1, z);
						world.setBlockToAir(x - 2, y - 1, z);
						world.setBlockToAir(x - 2, y - 1, z - 1);
						world.setBlockToAir(x + 2, y - 1, z - 1);
						world.setBlockToAir(x - 2, y - 2, z - 1);
						world.setBlockToAir(x + 2, y - 2, z - 1);
					}
					else
					{
						world.setBlockToAir(x, y - 1, z + 1);
						world.setBlockToAir(x, y - 2, z + 1);
						world.setBlockToAir(x, y - 3, z + 1);
						world.setBlockToAir(x, y - 4, z + 1);
						world.setBlockToAir(x - 1, y - 1, z + 1);
						world.setBlockToAir(x - 1, y - 2, z + 1);
						world.setBlockToAir(x - 1, y - 3, z + 1);
						world.setBlockToAir(x + 1, y - 1, z + 1);
						world.setBlockToAir(x + 1, y - 2, z + 1);
						world.setBlockToAir(x + 1, y - 3, z + 1);
						world.setBlockToAir(x - 1, y - 1, z);
						world.setBlockToAir(x + 1, y - 1, z);
						world.setBlockToAir(x - 2, y - 1, z);
						world.setBlockToAir(x + 2, y - 1, z);
						world.setBlockToAir(x + 2, y - 1, z + 1);
						world.setBlockToAir(x - 2, y - 1, z + 1);
						world.setBlockToAir(x + 2, y - 2, z + 1);
						world.setBlockToAir(x - 2, y - 2, z + 1);
					}

					MobThedeath mobTheDeath = new MobThedeath(world);
					mobTheDeath.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					world.spawnEntityInWorld(mobTheDeath);
				}
			}
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.face = iconregister.registerIcon(this.getTextureName() + "Face");
		this.top = iconregister.registerIcon(this.getTextureName() + "Top");
		this.side = iconregister.registerIcon(this.getTextureName() + "Side");
		this.side2 = iconregister.registerIcon(this.getTextureName() + "Side2");
		this.back = iconregister.registerIcon(this.getTextureName() + "Back");
		this.bottom = iconregister.registerIcon(this.getTextureName() + "Bottom");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(side == 1)
		{
			return this.top;
		}
		else if(side == 0)
		{
			return this.bottom;
		}
		else if(side == 2 && metadata == 2)
		{
			return this.face;
		}
		else if(side == 3 && metadata == 2)
		{
			return this.back;
		}
		else if(side == 4 && metadata == 2)
		{
			return this.side2;
		}
		else if(side == 5 && metadata == 2)
		{
			return this.side;
		}
		else if(side == 5 && metadata == 3)
		{
			return this.face;
		}
		else if(side == 4 && metadata == 3)
		{
			return this.back;
		}
		else if(side == 2 && metadata == 3)
		{
			return this.side2;
		}
		else if(side == 3 && metadata == 3)
		{
			return this.side;
		}
		else if(side == 3 && metadata == 0)
		{
			return this.face;
		}
		else if(side == 2 && metadata == 0)
		{
			return this.back;
		}
		else if(side == 4 && metadata == 0)
		{
			return this.side2;
		}
		else if(side == 5 && metadata == 0)
		{
			return this.side;
		}
		else if(side == 4 && metadata == 1)
		{
			return this.face;
		}
		else if(side == 5 && metadata == 1)
		{
			return this.back;
		}
		else if(side == 3 && metadata == 1)
		{
			return this.side2;
		}
		else if(side == 2 && metadata == 1)
		{
			return this.side;
		}
		else
		{
			return this.side;
		}
	}
}