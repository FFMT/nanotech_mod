package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobThedeath;

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

		if(NanotechMod.theDeathSpawn)
		{
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
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister)
	{
		this.face = iconregister.registerIcon("nanotechmod:theDeathHeadFace");
		this.top = iconregister.registerIcon("nanotechmod:theDeathHeadTop");
		this.side = iconregister.registerIcon("nanotechmod:theDeathHeadSide");
		this.side2 = iconregister.registerIcon("nanotechmod:theDeathHeadSide2");
		this.back = iconregister.registerIcon("nanotechmod:theDeathHeadBack");
		this.bottom = iconregister.registerIcon("nanotechmod:theDeathHeadBottom");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
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