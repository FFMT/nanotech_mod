package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.Loader;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechOther;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class BlockLiquidNitrogen extends BlockFluidClassic
{
	private Icon stillIcon, flowingIcon;

	public BlockLiquidNitrogen(int id, Fluid fluid, Material material)
	{
		super(id, fluid, material);
		this.setTickRandomly(true);
	}

	public Icon getIcon(int side, int meta)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	public void registerIcons(IconRegister register)
	{
		stillIcon = register.registerIcon("nanotech_mod:nitrogen_still");
		flowingIcon = register.registerIcon("nanotech_mod:nitrogen_flow");
	}

	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlockMaterial(x, y, z).isLiquid())
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlockMaterial(x, y, z).isLiquid())
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLivingBase && !world.isRemote)
		{
			EntityLivingBase living = (EntityLivingBase)entity;
			if(this.doEffect(living))
				living.addPotionEffect(new PotionEffect(NanotechOther.freeze.id, 500, 0));
		}

		if(entity instanceof EntityFishHook && !(entity instanceof EntityReinforcedFishingHook) && !world.isRemote)
		{
			EntityFishHook fishHook = (EntityFishHook)entity;
			fishHook.setDead();
		}
	}

	private boolean doEffect(EntityLivingBase living)
	{
		ItemStack helmet = living.getCurrentItemOrArmor(4);
		ItemStack chestPlate = living.getCurrentItemOrArmor(3);
		ItemStack leggings = living.getCurrentItemOrArmor(2);
		ItemStack boots = living.getCurrentItemOrArmor(1);
		if(helmet != null && chestPlate != null && leggings != null && boots != null)
		{
			if(helmet.getItem().equals(NanotechItem.mysteriousHelmet) && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && boots.getItem().equals(NanotechItem.mysteriousBoots))
			{
				return false;
			}
			if(Loader.isModLoaded("UltimateGraviSuite"))
			{
				if(helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet) && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate) && leggings.getItem().equals(UltimateGraviSuite.ultimateLeggings) && boots.getItem().equals(UltimateGraviSuite.ultimateBoots))
				{
					return false;
				}
			}
		}
		if(living instanceof MobThedeath)
		{
			return false;
		}
		return true;
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if(world.isAirBlock(x, y + 1, z))
		{
			float f = (float)x + random.nextFloat();
			float f1 = (float)y + random.nextFloat() * 0.5F + 0.5F;
			float f2 = (float)z + random.nextFloat();
			world.spawnParticle("cloud", (double)f, (double)f1, (double)f2, 0.0D, 0.1D, 0.0D);
		}
	}

	public void checkUpdate(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			for(int x1 = -3; x1 < 4; x1++)
			{
				for(int y1 = -3; y1 < 4; y1++)
				{
					for(int z1 = -3; z1 < 4; z1++)
					{
						boolean dofreeze = true;
						// x - z
						if((x1 == -3 && z1 == -3) || (x1 == -2 && z1 == -3) || (x1 == -3 && z1 == -2) || (x1 == 3 && z1 == 3) || (x1 == 3 && z1 == 2) || (x1 == 2 && z1 == 3) || (x1 == 3 && z1 == -3) || (x1 == 3 && z1 == -2) || (x1 == 2 && z1 == -3) || (x1 == -3 && z1 == 3) || (x1 == -3 && z1 == 2) || (x1 == -2 && z1 == 3)
						// x - y
						|| (x1 == -3 && y1 == -3) || (x1 == -2 && y1 == -3) || (x1 == -3 && y1 == -2) || (x1 == 3 && y1 == 3) || (x1 == 3 && y1 == 2) || (x1 == 2 && y1 == 3) || (x1 == 3 && y1 == -3) || (x1 == 3 && y1 == -2) || (x1 == 2 && y1 == -3) || (x1 == -3 && y1 == 3) || (x1 == -3 && y1 == 2) || (x1 == -2 && y1 == 3)
						// y - z
						|| (y1 == -3 && z1 == -3) || (y1 == -2 && z1 == -3) || (y1 == -3 && z1 == -2) || (y1 == 3 && z1 == 3) || (y1 == 3 && z1 == 2) || (y1 == 2 && z1 == 3) || (y1 == 3 && z1 == -3) || (y1 == 3 && z1 == -2) || (y1 == 2 && z1 == -3) || (y1 == -3 && z1 == 3) || (y1 == -3 && z1 == 2) || (y1 == -2 && z1 == 3))
						{
							dofreeze = false;
						}
						if(dofreeze)
						{
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.fire.blockID)
								world.setBlockToAir(x + x1, y + y1, z + z1);
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.lavaStill.blockID)
								world.setBlock(x + x1, y + y1, z + z1, Block.obsidian.blockID);
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.lavaMoving.blockID)
							{
								if(world.getBlockMetadata(x + x1, y + y1, z + z1) == 0)
									world.setBlock(x + x1, y + y1, z + z1, Block.obsidian.blockID);
								else
									world.setBlock(x + x1, y + y1, z + z1, Block.cobblestone.blockID);
							}
							if(world.getBlockId(x + x1, y + y1, z + z1) == Block.waterMoving.blockID || world.getBlockId(x + x1, y + y1, z + z1) == Block.waterStill.blockID)
								world.setBlock(x + x1, y + y1, z + z1, Block.ice.blockID);
						}
					}
				}
			}
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		this.checkUpdate(world, x, y, z);
		super.onNeighborBlockChange(world, x, y, z, blockid);
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		if(world.provider.isHellWorld)
		{
			world.setBlockToAir(x, y, z);
		}
		else
		{
			this.checkUpdate(world, x, y, z);
			super.onBlockAdded(world, x, y, z);
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		this.checkUpdate(world, x, y, z);
		super.updateTick(world, x, y, z, rand);
	}
}