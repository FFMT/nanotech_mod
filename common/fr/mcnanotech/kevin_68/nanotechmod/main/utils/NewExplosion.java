/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

@SuppressWarnings({"unchecked", "rawtypes"})
public class NewExplosion extends Explosion
{
	private final Random ExplosionRNG = new Random();
	private final World worldObj;
	private final int mapHeight;
	private final double explosionX;
	private final double explosionY;
	private final double explosionZ;
	private final Entity exploder;
	private final float power;
	private final float explosionDropRate;
	private final boolean nuclear;
	private final int radiationRange;
	private final EntityLivingBase igniter;
	private final List<Map.Entry<Integer, Entity>> entitiesInRange = new ArrayList();
	private final Map<ChunkPosition, Boolean> destroyedBlockPositions = new HashMap();
	private ChunkCache chunkCache;
	private static final double dropPowerLimit = 8.0D;
	private static final double damageAtDropPowerLimit = 32.0D;
	private static final double accelerationAtDropPowerLimit = 0.7D;
	private static final double motionLimit = 60.0D;
	private static final int secondaryRayCount = 5;

	public NewExplosion(World world, Entity entity, double x, double y, double z, float power, float drop)
	{
		this(world, entity, x, y, z, power, drop, false);
	}

	private NewExplosion(World world, Entity entity, double x, double y, double z, float power, float drop, boolean nuclear)
	{
		this(world, entity, x, y, z, power, drop, nuclear, null, 0);
	}

	private NewExplosion(World world, Entity entity, double x, double y, double z, float power, float drop, boolean nuclear, EntityLivingBase igniter, int radiationRange)
	{
		super(world, entity, x, y, z, power);

		this.worldObj = world;
		this.mapHeight = world.getHeight();
		this.exploder = entity;
		this.power = power;
		this.explosionDropRate = drop;
		this.explosionX = x;
		this.explosionY = y;
		this.explosionZ = z;
		this.nuclear = nuclear;
		this.igniter = igniter;
		this.radiationRange = radiationRange;
	}

	public void doExplosion()
	{
		if(this.power <= 0.0F)
			return;

		double maxDistance = this.power / 0.4D;
		int maxDistanceInt = (int)Math.ceil(maxDistance);

		this.chunkCache = new ChunkCache(this.worldObj, (int)this.explosionX - maxDistanceInt, (int)this.explosionY - maxDistanceInt, (int)this.explosionZ - maxDistanceInt, (int)this.explosionX + maxDistanceInt, (int)this.explosionY + maxDistanceInt, (int)this.explosionZ + maxDistanceInt, 0);

		List entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.getAABBPool().getAABB(this.explosionX - maxDistance, this.explosionY - maxDistance, this.explosionZ - maxDistance, this.explosionX + maxDistance, this.explosionY + maxDistance, this.explosionZ + maxDistance));

		boolean entitiesAreInRange = !this.entitiesInRange.isEmpty();

		int steps = (int)Math.ceil(3.141592653589793D / Math.atan(1.0D / maxDistance));

		for(int phi_n = 0; phi_n < 2 * steps; phi_n++)
		{
			for(int theta_n = 0; theta_n < steps; theta_n++)
			{
				double phi = 6.283185307179586D / steps * phi_n;
				double theta = 3.141592653589793D / steps * theta_n;

				shootRay(this.explosionX, this.explosionY, this.explosionZ, phi, theta, this.power, (entitiesAreInRange) && (phi_n % 8 == 0) && (theta_n % 8 == 0));
			}
		}

		for(Map.Entry entry : this.entitiesInRange)
		{
			Entity entity = (Entity)entry.getValue();

			double motionSq = entity.motionX * entity.motionX + entity.motionY * entity.motionY + entity.motionZ * entity.motionZ;

			if(motionSq > 3600.0D)
			{
				double reduction = Math.sqrt(3600.0D / motionSq);

				entity.motionX *= reduction;
				entity.motionY *= reduction;
				entity.motionZ *= reduction;
			}
		}

		Map blocksToDrop = new HashMap();

		for(Map.Entry entry : this.destroyedBlockPositions.entrySet())
		{
			int x = ((ChunkPosition)entry.getKey()).chunkPosX;
			int y = ((ChunkPosition)entry.getKey()).chunkPosY;
			int z = ((ChunkPosition)entry.getKey()).chunkPosZ;

			Block block = this.chunkCache.getBlock(x, y, z);

			if(block != null)
			{
				if(((Boolean)entry.getValue()).booleanValue())
				{
					double effectX = x + this.worldObj.rand.nextFloat();
					double effectY = y + this.worldObj.rand.nextFloat();
					double effectZ = z + this.worldObj.rand.nextFloat();
					double d3 = effectX - this.explosionX;
					double d4 = effectY - this.explosionY;
					double d5 = effectZ - this.explosionZ;
					double effectDistance = MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
					d3 /= effectDistance;
					d4 /= effectDistance;
					d5 /= effectDistance;
					double d7 = 0.5D / (effectDistance / this.power + 0.1D);
					d7 *= (this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
					d3 *= d7;
					d4 *= d7;
					d5 *= d7;
					this.worldObj.spawnParticle("explode", (effectX + this.explosionX) / 2.0D, (effectY + this.explosionY) / 2.0D, (effectZ + this.explosionZ) / 2.0D, d3, d4, d5);
					this.worldObj.spawnParticle("smoke", effectX, effectY, effectZ, d3, d4, d5);

					int meta = this.worldObj.getBlockMetadata(x, y, z);

					for(ItemStack itemStack : block.getDrops(this.worldObj, x, y, z, meta, 0))
					{
						if(this.worldObj.rand.nextFloat() <= this.explosionDropRate)
						{
							XZposition xZposition = new XZposition(x / 2, z / 2);

							if(!blocksToDrop.containsKey(xZposition))
								blocksToDrop.put(xZposition, new HashMap());
							Map map = (Map)blocksToDrop.get(xZposition);

							ItemWithMeta itemWithMeta = new ItemWithMeta(itemStack.getItem(), itemStack.getItemDamage());

							if(!map.containsKey(itemWithMeta))
								map.put(itemWithMeta, new DropData(itemStack.stackSize, y));
							else
							{
								map.put(itemWithMeta, ((DropData)map.get(itemWithMeta)).add(itemStack.stackSize, y));
							}
						}
					}
				}

				this.worldObj.setBlock(x, y, z, Blocks.air, 0, 7);
				block.onBlockDestroyedByExplosion(this.worldObj, x, y, z, this);
			}
		}

		XZposition xZposition;
	}

	public static int roundToNegInf(double x)
	{
		int ret = (int)x;

		if(ret > x)
			ret--;

		return ret;
	}

	private void shootRay(double x, double y, double z, double phi, double theta, double power, boolean killEntities)
	{
		double deltaX = Math.sin(theta) * Math.cos(phi);
		double deltaY = Math.cos(theta);
		double deltaZ = Math.sin(theta) * Math.sin(phi);

		for(int step = 0;; step++)
		{
			int blockY = roundToNegInf(y);

			if((blockY < 0) || (blockY >= this.mapHeight))
				break;
			int blockX = roundToNegInf(x);
			int blockZ = roundToNegInf(z);

			Block block = this.chunkCache.getBlock(blockX, blockY, blockZ);
			double absorption = 0.5D;

			if(block != null)
			{
				absorption += (block.getExplosionResistance(this.exploder, this.worldObj, blockX, blockY, blockZ, this.explosionX, this.explosionY, this.explosionZ) + 4.0D) * 0.3D;
			}

			if(absorption > power)
				break;
			if(block != null)
			{
				ChunkPosition position = new ChunkPosition(blockX, blockY, blockZ);

				if(power > 8.0D)
					this.destroyedBlockPositions.put(position, Boolean.valueOf(false));
				else if(!this.destroyedBlockPositions.containsKey(position))
				{
					this.destroyedBlockPositions.put(position, Boolean.valueOf(true));
				}

			}

			if((killEntities) && ((step + 4) % 8 == 0) && (power >= 0.25D))
			{
				int index = 0;
				if(step != 4)
				{
					int distanceMin = step * step - 25;

					int indexStart = 0;
					int indexEnd = this.entitiesInRange.size() - 1;
					do
					{
						int index1 = (indexStart + indexEnd) / 2;

						int distance = ((Integer)((Map.Entry)this.entitiesInRange.get(index1)).getKey()).intValue();

						if(distance < distanceMin)
							indexStart = index1 + 1;
						else if(distance > distanceMin)
							indexEnd = index1 - 1;
						else
						{
							indexEnd = index1;
						}
					}
					while(indexStart < indexEnd);
				}
				else
				{
					index = 0;
				}

				int distanceMax = step * step + 25;

				for(int i = index; (i < this.entitiesInRange.size()) && (((Integer)((Map.Entry)this.entitiesInRange.get(index)).getKey()).intValue() < distanceMax); i++)
				{
					Entity entity = (Entity)((Map.Entry)this.entitiesInRange.get(index)).getValue();

					if((entity.posX - x) * (entity.posX - x) + (entity.posY - y) * (entity.posY - y) + (entity.posZ - z) * (entity.posZ - z) <= 25.0D)
					{
						entity.attackEntityFrom(getDamageSource(), (int)(32.0D * power / 8.0D));

						double dx = entity.posX - this.explosionX;
						double dy = entity.posY - this.explosionY;
						double dz = entity.posZ - this.explosionZ;

						double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

						entity.motionX += dx / distance * 0.7D * power / 8.0D;
						entity.motionY += dy / distance * 0.7D * power / 8.0D;
						entity.motionZ += dz / distance * 0.7D * power / 8.0D;

						if(!entity.isEntityAlive())
						{
							this.entitiesInRange.remove(i);
							i--;
						}
					}
				}
			}

			if(absorption > 10.0D)
			{
				for(int i = 0; i < 5; i++)
				{
					shootRay(x, y, z, this.ExplosionRNG.nextDouble() * 2.0D * 3.141592653589793D, this.ExplosionRNG.nextDouble() * 3.141592653589793D, absorption * 0.4D, false);
				}
			}

			power -= absorption;

			x += deltaX;
			y += deltaY;
			z += deltaZ;
		}
	}

	public EntityLivingBase getExplosivePlacedBy()
	{
		return this.igniter;
	}

	private DamageSource getDamageSource()
	{
		return DamageSource.setExplosionSource(this);
	}

	private static class DropData
	{
		int n;
		int maxY;

		DropData(int n, int y)
		{
			this.n = n;
			this.maxY = y;
		}

		public DropData add(int n, int y)
		{
			this.n += n;
			if(y > this.maxY)
				this.maxY = y;

			return this;
		}
	}

	private static class ItemWithMeta
	{
		Item itemId;
		int metaData;

		ItemWithMeta(Item item, int metaData)
		{
			this.itemId = item;
			this.metaData = metaData;
		}

		public boolean equals(Object obj)
		{
			if((obj instanceof ItemWithMeta))
			{
				ItemWithMeta itemWithMeta = (ItemWithMeta)obj;

				return (itemWithMeta.itemId == this.itemId) && (itemWithMeta.metaData == this.metaData);
			}

			return false;
		}

		public int hashCode()
		{
			return Item.getIdFromItem(this.itemId) * 31 ^ this.metaData;
		}
	}

	private static class XZposition
	{
		int x;
		int z;

		XZposition(int x, int z)
		{
			this.x = x;
			this.z = z;
		}

		public boolean equals(Object obj)
		{
			if((obj instanceof XZposition))
			{
				XZposition xZposition = (XZposition)obj;

				return (xZposition.x == this.x) && (xZposition.z == this.z);
			}

			return false;
		}

		public int hashCode()
		{
			return this.x * 31 ^ this.z;
		}
	}
}