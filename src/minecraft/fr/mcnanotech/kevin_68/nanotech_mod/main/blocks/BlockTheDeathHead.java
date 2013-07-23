package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobThedeath;

public class BlockTheDeathHead extends Block
{
	private Icon top;
	private Icon side;
	private Icon side2;
	private Icon back;
	private Icon face;
	private Icon bottom;
	private EntityPlayer player;

	public BlockTheDeathHead(int id)
	{
		super(id, Material.iron);
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		int redID = Block.blockRedstone.blockID;
		int netherID = Block.blockNetherQuartz.blockID;
		int obsiID = Block.obsidian.blockID;

		super.onBlockAdded(world, x, y, z);

		if(world.getBlockId(x, y - 1, z) == redID && world.getBlockId(x, y - 2, z) == netherID && world.getBlockId(x, y - 3, z) == netherID && world.getBlockId(x, y - 4, z) == netherID)
		{
			boolean flag0 = world.getBlockId(x - 1, y - 1, z) == obsiID && world.getBlockId(x - 1, y - 2, z) == obsiID && world.getBlockId(x - 1, y - 3, z) == obsiID && world.getBlockId(x - 1, y - 4, z) == obsiID && world.getBlockId(x - 1, y - 1, z + 1) == obsiID && world.getBlockId(x - 1, y - 1, z - 1) == obsiID && world.getBlockId(x - 1, y - 2, z + 1) == obsiID && world.getBlockId(x - 1, y - 2, z - 1) == obsiID && world.getBlockId(x - 1, y - 3, z + 1) == obsiID && world.getBlockId(x, y - 1, z + 1) == netherID && world.getBlockId(x, y - 1, z - 1) == netherID && world.getBlockId(x, y - 1, z + 2) == netherID && world.getBlockId(x, y - 1, z - 2) == netherID && world.getBlockId(x - 1, y - 1, z + 2) == obsiID && world.getBlockId(x - 1, y - 1, z - 2) == obsiID && world.getBlockId(x - 1, y - 2, z + 2) == obsiID && world.getBlockId(x - 1, y - 2, z - 2) == obsiID;
			boolean flag1 = world.getBlockId(x + 1, y - 1, z) == obsiID && world.getBlockId(x + 1, y - 2, z) == obsiID && world.getBlockId(x + 1, y - 3, z) == obsiID && world.getBlockId(x + 1, y - 4, z) == obsiID && world.getBlockId(x + 1, y - 1, z - 1) == obsiID && world.getBlockId(x + 1, y - 1, z + 1) == obsiID && world.getBlockId(x + 1, y - 2, z - 1) == obsiID && world.getBlockId(x + 1, y - 2, z + 1) == obsiID && world.getBlockId(x + 1, y - 3, z - 1) == obsiID && world.getBlockId(x, y - 1, z - 1) == netherID && world.getBlockId(x, y - 1, z + 1) == netherID && world.getBlockId(x, y - 1, z - 2) == netherID && world.getBlockId(x, y - 1, z + 2) == netherID && world.getBlockId(x + 1, y - 1, z - 2) == obsiID && world.getBlockId(x + 1, y - 1, z + 2) == obsiID && world.getBlockId(x + 1, y - 2, z - 2) == obsiID && world.getBlockId(x + 1, y - 2, z + 2) == obsiID;
			boolean flag2 = world.getBlockId(x, y - 1, z - 1) == obsiID && world.getBlockId(x, y - 2, z - 1) == obsiID && world.getBlockId(x, y - 3, z - 1) == obsiID && world.getBlockId(x, y - 4, z - 1) == obsiID && world.getBlockId(x + 1, y - 1, z - 1) == obsiID && world.getBlockId(x - 1, y - 1, z - 1) == obsiID && world.getBlockId(x + 1, y - 2, z - 1) == obsiID && world.getBlockId(x - 1, y - 2, z - 1) == obsiID && world.getBlockId(x + 1, y - 3, z - 1) == obsiID && world.getBlockId(x + 1, y - 1, z) == netherID && world.getBlockId(x - 1, y - 1, z) == netherID && world.getBlockId(x + 2, y - 1, z) == netherID && world.getBlockId(x - 2, y - 1, z) == netherID && world.getBlockId(x + 2, y - 1, z - 1) == obsiID && world.getBlockId(x - 2, y - 1, z - 1) == obsiID && world.getBlockId(x + 2, y - 2, z - 1) == obsiID && world.getBlockId(x - 2, y - 2, z - 1) == obsiID;
			boolean flag3 = world.getBlockId(x, y - 1, z + 1) == obsiID && world.getBlockId(x, y - 2, z + 1) == obsiID && world.getBlockId(x, y - 3, z + 1) == obsiID && world.getBlockId(x, y - 4, z + 1) == obsiID && world.getBlockId(x - 1, y - 1, z + 1) == obsiID && world.getBlockId(x + 1, y - 1, z + 1) == obsiID && world.getBlockId(x - 1, y - 2, z + 1) == obsiID && world.getBlockId(x + 1, y - 2, z + 1) == obsiID && world.getBlockId(x - 1, y - 3, z + 1) == obsiID && world.getBlockId(x - 1, y - 1, z) == netherID && world.getBlockId(x + 1, y - 1, z) == netherID && world.getBlockId(x - 2, y - 1, z) == netherID && world.getBlockId(x + 2, y - 1, z) == netherID && world.getBlockId(x - 2, y - 1, z + 1) == obsiID && world.getBlockId(x + 2, y - 1, z + 1) == obsiID && world.getBlockId(x - 2, y - 2, z + 1) == obsiID && world.getBlockId(x + 2, y - 2, z + 1) == obsiID;

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

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.face = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadFace");
		this.top = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadTop");
		this.side = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadSide");
		this.side2 = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadSide2");
		this.back = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadBack");
		this.bottom = par1IconRegister.registerIcon("Nanotech_mod:theDeathHeadBottom");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		if(par1 == 1)
		{
			return this.top;
		}
		else if(par1 == 0)
		{
			return this.bottom;
		}
		else if(par1 == 2 && par2 == 2)
		{
			return this.face;
		}
		else if(par1 == 3 && par2 == 2)
		{
			return this.back;
		}
		else if(par1 == 4 && par2 == 2)
		{
			return this.side2;
		}
		else if(par1 == 5 && par2 == 2)
		{
			return this.side;
		}
		else if(par1 == 5 && par2 == 3)
		{
			return this.face;
		}
		else if(par1 == 4 && par2 == 3)
		{
			return this.back;
		}
		else if(par1 == 2 && par2 == 3)
		{
			return this.side2;
		}
		else if(par1 == 3 && par2 == 3)
		{
			return this.side;
		}
		else if(par1 == 3 && par2 == 0)
		{
			return this.face;
		}
		else if(par1 == 2 && par2 == 0)
		{
			return this.back;
		}
		else if(par1 == 4 && par2 == 0)
		{
			return this.side2;
		}
		else if(par1 == 5 && par2 == 0)
		{
			return this.side;
		}
		else if(par1 == 4 && par2 == 1)
		{
			return this.face;
		}
		else if(par1 == 5 && par2 == 1)
		{
			return this.back;
		}
		else if(par1 == 3 && par2 == 1)
		{
			return this.side2;
		}
		else if(par1 == 2 && par2 == 1)
		{
			return this.side;
		}
		else
		{
			return this.side;
		}

	}
}
