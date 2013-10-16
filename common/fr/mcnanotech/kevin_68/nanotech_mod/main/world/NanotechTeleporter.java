package fr.mcnanotech.kevin_68.nanotech_mod.main.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.PortalPosition;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class NanotechTeleporter extends Teleporter
{
	private final WorldServer worldServerInstance;
	private final Random random;
	private final LongHashMap destinationCoordinateCache = new LongHashMap();
	private final List destinationCoordinateKeys = new ArrayList();

	public NanotechTeleporter(WorldServer worldServer)
	{
		super(worldServer);
		this.worldServerInstance = worldServer;
		this.random = new Random(worldServer.getSeed());
	}

	public void placeInPortal(Entity entity, double x, double y, double z, float rotationYaw)
	{
		if(this.worldServerInstance.provider.dimensionId != 1)
		{
			if(!this.placeInExistingPortal(entity, x, y, z, rotationYaw))
			{
				this.makePortal(entity);
				this.placeInExistingPortal(entity, x, y, z, rotationYaw);
			}
		}
		else
		{
			int i = MathHelper.floor_double(entity.posX);
			int j = MathHelper.floor_double(entity.posY) - 1;
			int k = MathHelper.floor_double(entity.posZ);
			byte b0 = 1;
			byte b1 = 0;
			for(int l = -2; l <= 2; ++l)
			{
				for(int i1 = -2; i1 <= 2; ++i1)
				{
					for(int j1 = -1; j1 < 3; ++j1)
					{
						int k1 = i + i1 * b0 + l * b1;
						int l1 = j + j1;
						int i2 = k + i1 * b1 - l * b0;
						boolean flag = j1 < 0;

						this.worldServerInstance.setBlock(k1, l1, i2, flag ? NanotechBlock.BlockPortalFrame.blockID : 0);
					}
				}
			}
			entity.setLocationAndAngles((double)i, (double)j, (double)k, entity.rotationYaw, 0.0F);
			entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		}
	}

	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float rotationYaw)
	{
		short short1 = 128;
		double d3 = -1.0D;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = MathHelper.floor_double(entity.posX);
		int i1 = MathHelper.floor_double(entity.posZ);
		long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
		boolean flag = true;
		double d4;
		int k1;
		if(this.destinationCoordinateCache.containsItem(j1))
		{
			PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
			d3 = 0.0D;
			i = portalposition.posX;
			j = portalposition.posY;
			k = portalposition.posZ;
			portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
			flag = false;
		}
		else
		{
			for(k1 = l - short1; k1 <= l + short1; ++k1)
			{
				double d5 = (double)k1 + 0.5D - entity.posX;
				for(int l1 = i1 - short1; l1 <= i1 + short1; ++l1)
				{
					double d6 = (double)l1 + 0.5D - entity.posZ;
					for(int i2 = this.worldServerInstance.getActualHeight() - 1; i2 >= 0; --i2)
					{
						if(this.worldServerInstance.getBlockId(k1, i2, l1) == NanotechBlock.BlockPortal.blockID)
						{
							while(this.worldServerInstance.getBlockId(k1, i2 - 1, l1) == NanotechBlock.BlockPortal.blockID)
							{
								--i2;
							}
							d4 = (double)i2 + 0.5D - entity.posY;
							double d7 = d5 * d5 + d4 * d4 + d6 * d6;
							if(d3 < 0.0D || d7 < d3)
							{
								d3 = d7;
								i = k1;
								j = i2;
								k = l1;
							}
						}
					}
				}
			}
		}
		if(d3 >= 0.0D)
		{
			if(flag)
			{
				this.destinationCoordinateCache.add(j1, new NanotechPortalPosition(this, i, j, k, this.worldServerInstance.getTotalWorldTime()));
				this.destinationCoordinateKeys.add(Long.valueOf(j1));
			}
			double d8 = (double)i + 0.5D;
			double d9 = (double)j + 0.5D;
			d4 = (double)k + 0.5D;
			int j2 = -1;
			if(this.worldServerInstance.getBlockId(i - 1, j, k) == NanotechBlock.BlockPortal.blockID)
			{
				j2 = 2;
			}
			if(this.worldServerInstance.getBlockId(i + 1, j, k) == NanotechBlock.BlockPortal.blockID)
			{
				j2 = 0;
			}
			if(this.worldServerInstance.getBlockId(i, j, k - 1) == NanotechBlock.BlockPortal.blockID)
			{
				j2 = 3;
			}
			if(this.worldServerInstance.getBlockId(i, j, k + 1) == NanotechBlock.BlockPortal.blockID)
			{
				j2 = 1;
			}
			int k2 = entity.getTeleportDirection();
			if(j2 > -1)
			{
				int l2 = Direction.rotateLeft[j2];
				int i3 = Direction.offsetX[j2];
				int j3 = Direction.offsetZ[j2];
				int k3 = Direction.offsetX[l2];
				int l3 = Direction.offsetZ[l2];
				boolean flag1 = !this.worldServerInstance.isAirBlock(i + i3 + k3, j, k + j3 + l3) || !this.worldServerInstance.isAirBlock(i + i3 + k3, j + 1, k + j3 + l3);
				boolean flag2 = !this.worldServerInstance.isAirBlock(i + i3, j, k + j3) || !this.worldServerInstance.isAirBlock(i + i3, j + 1, k + j3);
				if(flag1 && flag2)
				{
					j2 = Direction.rotateOpposite[j2];
					l2 = Direction.rotateOpposite[l2];
					i3 = Direction.offsetX[j2];
					j3 = Direction.offsetZ[j2];
					k3 = Direction.offsetX[l2];
					l3 = Direction.offsetZ[l2];
					k1 = i - k3;
					d8 -= (double)k3;
					int i4 = k - l3;
					d4 -= (double)l3;
					flag1 = !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j, i4 + j3 + l3) || !this.worldServerInstance.isAirBlock(k1 + i3 + k3, j + 1, i4 + j3 + l3);
					flag2 = !this.worldServerInstance.isAirBlock(k1 + i3, j, i4 + j3) || !this.worldServerInstance.isAirBlock(k1 + i3, j + 1, i4 + j3);
				}
				float f1 = 0.5F;
				float f2 = 0.5F;
				if(!flag1 && flag2)
				{
					f1 = 1.0F;
				}
				else if(flag1 && !flag2)
				{
					f1 = 0.0F;
				}
				else if(flag1 && flag2)
				{
					f2 = 0.0F;
				}
				d8 += (double)((float)k3 * f1 + f2 * (float)i3);
				d4 += (double)((float)l3 * f1 + f2 * (float)j3);
				float f3 = 0.0F;
				float f4 = 0.0F;
				float f5 = 0.0F;
				float f6 = 0.0F;
				if(j2 == k2)
				{
					f3 = 1.0F;
					f4 = 1.0F;
				}
				else if(j2 == Direction.rotateOpposite[k2])
				{
					f3 = -1.0F;
					f4 = -1.0F;
				}
				else if(j2 == Direction.rotateRight[k2])
				{
					f5 = 1.0F;
					f6 = -1.0F;
				}
				else
				{
					f5 = -1.0F;
					f6 = 1.0F;
				}
				double d10 = entity.motionX;
				double d11 = entity.motionZ;
				entity.motionX = d10 * (double)f3 + d11 * (double)f6;
				entity.motionZ = d10 * (double)f5 + d11 * (double)f4;
				entity.rotationYaw = rotationYaw - (float)(k2 * 90) + (float)(j2 * 90);
			}
			else
			{
				entity.motionX = entity.motionY = entity.motionZ = 0.0D;
			}
			entity.setLocationAndAngles(d8, d9, d4, entity.rotationYaw, entity.rotationPitch);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean makePortal(Entity entity)
	{
		byte b0 = 16;
		double d0 = -1.0D;
		int i = MathHelper.floor_double(entity.posX);
		int j = MathHelper.floor_double(entity.posY);
		int k = MathHelper.floor_double(entity.posZ);
		int l = i;
		int i1 = j;
		int j1 = k;
		int k1 = 0;
		int l1 = this.random.nextInt(4);
		int i2;
		double d1;
		double d2;
		int j2;
		int k2;
		int l2;
		int i3;
		int j3;
		int k3;
		int l3;
		int i4;
		int j4;
		int k4;
		double d3;
		double d4;
		for(i2 = i - b0; i2 <= i + b0; ++i2)
		{
			d1 = (double)i2 + 0.5D - entity.posX;
			for(j2 = k - b0; j2 <= k + b0; ++j2)
			{
				d2 = (double)j2 + 0.5D - entity.posZ;
				label274: for(k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2)
				{
					if(this.worldServerInstance.isAirBlock(i2, k2, j2))
					{
						while(k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2))
						{
							--k2;
						}
						for(i3 = l1; i3 < l1 + 4; ++i3)
						{
							l2 = i3 % 2;
							k3 = 1 - l2;
							if(i3 % 4 >= 2)
							{
								l2 = -l2;
								k3 = -k3;
							}
							for(j3 = 0; j3 < 3; ++j3)
							{
								for(i4 = 0; i4 < 4; ++i4)
								{
									for(l3 = -1; l3 < 4; ++l3)
									{
										k4 = i2 + (i4 - 1) * l2 + j3 * k3;
										j4 = k2 + l3;
										int l4 = j2 + (i4 - 1) * k3 - j3 * l2;
										if(l3 < 0 && !this.worldServerInstance.getBlockMaterial(k4, j4, l4).isSolid() || l3 >= 0 && !this.worldServerInstance.isAirBlock(k4, j4, l4))
										{
											continue label274;
										}
									}
								}
							}
							d4 = (double)k2 + 0.5D - entity.posY;
							d3 = d1 * d1 + d4 * d4 + d2 * d2;
							if(d0 < 0.0D || d3 < d0)
							{
								d0 = d3;
								l = i2;
								i1 = k2;
								j1 = j2;
								k1 = i3 % 4;
							}
						}
					}
				}
			}
		}
		if(d0 < 0.0D)
		{
			for(i2 = i - b0; i2 <= i + b0; ++i2)
			{
				d1 = (double)i2 + 0.5D - entity.posX;
				for(j2 = k - b0; j2 <= k + b0; ++j2)
				{
					d2 = (double)j2 + 0.5D - entity.posZ;
					label222: for(k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2)
					{
						if(this.worldServerInstance.isAirBlock(i2, k2, j2))
						{
							while(k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2))
							{
								--k2;
							}
							for(i3 = l1; i3 < l1 + 2; ++i3)
							{
								l2 = i3 % 2;
								k3 = 1 - l2;
								for(j3 = 0; j3 < 4; ++j3)
								{
									for(i4 = -1; i4 < 4; ++i4)
									{
										l3 = i2 + (j3 - 1) * l2;
										k4 = k2 + i4;
										j4 = j2 + (j3 - 1) * k3;
										if(i4 < 0 && !this.worldServerInstance.getBlockMaterial(l3, k4, j4).isSolid() || i4 >= 0 && !this.worldServerInstance.isAirBlock(l3, k4, j4))
										{
											continue label222;
										}
									}
								}
								d4 = (double)k2 + 0.5D - entity.posY;
								d3 = d1 * d1 + d4 * d4 + d2 * d2;
								if(d0 < 0.0D || d3 < d0)
								{
									d0 = d3;
									l = i2;
									i1 = k2;
									j1 = j2;
									k1 = i3 % 2;
								}
							}
						}
					}
				}
			}
		}
		int i5 = l;
		int j5 = i1;
		j2 = j1;
		int k5 = k1 % 2;
		int l5 = 1 - k5;
		if(k1 % 4 >= 2)
		{
			k5 = -k5;
			l5 = -l5;
		}
		boolean flag;
		if(d0 < 0.0D)
		{
			if(i1 < 70)
			{
				i1 = 70;
			}
			if(i1 > this.worldServerInstance.getActualHeight() - 10)
			{
				i1 = this.worldServerInstance.getActualHeight() - 10;
			}
			j5 = i1;
			for(k2 = -1; k2 <= 1; ++k2)
			{
				for(i3 = 1; i3 < 3; ++i3)
				{
					for(l2 = -1; l2 < 3; ++l2)
					{
						k3 = i5 + (i3 - 1) * k5 + k2 * l5;
						j3 = j5 + l2;
						i4 = j2 + (i3 - 1) * l5 - k2 * k5;
						flag = l2 < 0;

						this.worldServerInstance.setBlock(k3, j3, i4, flag ? NanotechBlock.BlockPortalFrame.blockID : 0);
					}
				}
			}
		}
		for(k2 = 0; k2 < 4; ++k2)
		{
			for(i3 = 0; i3 < 4; ++i3)
			{
				for(l2 = -1; l2 < 4; ++l2)
				{
					k3 = i5 + (i3 - 1) * k5;
					j3 = j5 + l2;
					i4 = j2 + (i3 - 1) * l5;
					flag = i3 == 0 || i3 == 3 || l2 == -1 || l2 == 3;

					this.worldServerInstance.setBlock(k3, j3, i4, flag ? NanotechBlock.BlockPortalFrame.blockID : NanotechBlock.BlockPortal.blockID, 0, 2);
				}
			}
			for(i3 = 0; i3 < 4; ++i3)
			{
				for(l2 = -1; l2 < 4; ++l2)
				{
					k3 = i5 + (i3 - 1) * k5;
					j3 = j5 + l2;
					i4 = j2 + (i3 - 1) * l5;
					this.worldServerInstance.notifyBlocksOfNeighborChange(k3, j3, i4, this.worldServerInstance.getBlockId(k3, j3, i4));
				}
			}
		}
		return true;
	}

	public void removeStalePortalLocations(long time)
	{
		if(time % 100L == 0L)
		{
			Iterator iterator = this.destinationCoordinateKeys.iterator();
			long j = time - 600L;
			while(iterator.hasNext())
			{
				Long olong = (Long)iterator.next();
				PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());
				if(portalposition == null || portalposition.lastUpdateTime < j)
				{
					iterator.remove();
					this.destinationCoordinateCache.remove(olong.longValue());
				}
			}
		}
	}
}