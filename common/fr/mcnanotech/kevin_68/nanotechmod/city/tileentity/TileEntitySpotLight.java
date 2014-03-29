/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.items.NanotechCityItems;

public class TileEntitySpotLight extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[2];
	private String customName;

	@SideOnly(Side.CLIENT)
	private long worldTimeClient;
	@SideOnly(Side.CLIENT)
	private float activeBooleanFloat;
	public boolean isActive;

	/**
	 * Index
	 */
	public static final int REVSMOOTHMODE = -5, REVTIMELINEMODE = -4, REVREVERSEROTATION = -3, REVSECONDARYLAZER = -2, REVAUTOROTATE = -1, RED = 0, GREEN = 1, BLUE = 2, DARKRED = 3, DARKGREEN = 4, DARKBLUE = 5, ANGLE1 = 6, ANGLE2 = 7, AUTOROTATE = 8, ROTATIONSPEED = 9, SECONDARYLAZER = 10, REVERSEROTATION = 11, CONFIGCOPIER = 12, TIMELINEMODE = 13, CREATEKEYTIME = 14, SELECTEDBUTTON = 15,
			TIMELINE = 16, SMOOTHMODE = 17;

	public static final int KEYLIST = 0, REDKEY = 1, GREENKEY = 2, BLUEKEY = 3, DARKREDKEY = 4, DARKGREENKEY = 5, DARKBLUEKEY = 6, ANGLE1KEY = 7, ANGLE2KEY = 8, AUTOROTATEKEY = 9, ROTATIONSPEEDKEY = 10, SECONDARYLAZERKEY = 11, REVERSEROTATIONKEY = 12;

	public int red;
	public int green;
	public int blue;
	public int darkRed;
	public int darkGreen;
	public int darkBlue;
	public int angle1;
	public int angle2;
	public int autoRotate;
	public int rotationSpeed;
	public int secondaryLazer;
	public int reverseRotation;

	public int timeLineMode;
	public int timeLine, lastTimeUse;
	public int createKeyTime;
	public int selectedbuttonid;
	public int smoothMode;

	private int[] keyList = new int[121];
	private int[] redkey = new int[121];
	private int[] greenkey = new int[121];
	private int[] bluekey = new int[121];
	private int[] darkRedkey = new int[121];
	private int[] darkGreenkey = new int[121];
	private int[] darkBluekey = new int[121];
	private int[] angle1key = new int[121];
	private int[] angle2key = new int[121];
	private int[] autoRotatekey = new int[121];
	private int[] rotateSpeedkey = new int[121];
	private int[] secondaryLazerkey = new int[121];
	private int[] reverseRotationkey = new int[121];

	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{

			if(get(TIMELINEMODE) == 1)
			{
				if(get(TIMELINE) > 1200)
				{
					set(TIMELINE, 0);
				}
				else
				{
					set(TIMELINE, get(TIMELINE) + 1);
				}

				if(!this.worldObj.isRemote)
				{
					if(get(SMOOTHMODE) == 1)
					{
						ArrayList<Integer> keys = new ArrayList();
						ArrayList<Integer> timeBetwinKey = new ArrayList();
						ArrayList<Integer> timeToChange = new ArrayList();
						int[] redKeyValue = new int[242];

						for(int i = 0; i != 121; i++)
						{
							if(get(KEYLIST, i) == 1)
							{
								keys.add(keys.size(), i * 10);
							}
						}

						if(!keys.isEmpty() && keys.size() > 1)
						{
							for(int i = 0; i != keys.size(); i++)
							{
								if(i == 0)
								{
									timeBetwinKey.add(i, keys.get(i) + (1210 - keys.get(keys.size() - 1)));
									timeToChange.add(i, keys.get(i));
								}
								else
								{
									timeBetwinKey.add(i, keys.get(i) - keys.get(i - 1));
									timeToChange.add(i, timeToChange.get(i - 1) + timeBetwinKey.get(i));
								}
							}
						}

						if(!keys.isEmpty() && keys.size() > 1)
						{
							for(int i = 0; i != timeBetwinKey.size(); i++)
							{
								if(i == 0)
								{
									if((get(TIMELINE) > timeToChange.get(timeToChange.size() - 1) && get(TIMELINE) <= 1210) || (get(TIMELINE) >= 0 && get(TIMELINE) <= timeToChange.get(i)))
									{
										int prevKeyRed = this.get(REDKEY, timeToChange.get(timeToChange.size() - 1) / 10);
										int nextKeyRed = this.get(REDKEY, timeToChange.get(i) / 10);
										int percentAfter0 = timeToChange.get(i) / timeBetwinKey.get(0);
										int redKeyAt0 = (nextKeyRed - prevKeyRed) * percentAfter0;

										// Unworking TODO fix
										if(get(TIMELINE) <= timeToChange.get(i))
										{
											if(prevKeyRed < nextKeyRed)
											{
												float numberRed = (nextKeyRed - redKeyAt0) / (timeToChange.get(i) / 10);
												set(RED, (int)(redKeyAt0 + (numberRed * (timeToChange.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
											}
											else
											{
												float numberRed = (redKeyAt0 - nextKeyRed) / (timeToChange.get(i) / 10);
												set(RED, (int)(redKeyAt0 - (numberRed * (timeToChange.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
											}
										}
										else
										{
											if(prevKeyRed < nextKeyRed)
											{
												float numberRed = (redKeyAt0 - prevKeyRed) / (timeBetwinKey.get(i) / 10);
												set(RED, (int)(prevKeyRed + (numberRed * ((timeBetwinKey.get(i) - timeToChange.get(i)) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
											}
											else
											{
												float numberRed = (prevKeyRed - redKeyAt0) / (timeBetwinKey.get(i) / 10);
												set(RED, (int)(prevKeyRed - (numberRed * ((timeBetwinKey.get(i) - timeToChange.get(i)) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
											}
										}
										// End
										this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
									}
								}
								else
								{
									if(get(TIMELINE) > timeToChange.get(i - 1) && get(TIMELINE) <= timeToChange.get(i))
									{
										int prevKeyRed = this.get(REDKEY, timeToChange.get(i - 1) / 10);
										int nextKeyRed = this.get(REDKEY, timeToChange.get(i) / 10);
										int prevKeyGreen = this.get(GREENKEY, timeToChange.get(i - 1) / 10);
										int nextKeyGreen = this.get(GREENKEY, timeToChange.get(i) / 10);
										int prevKeyBlue = this.get(BLUEKEY, timeToChange.get(i - 1) / 10);
										int nextKeyBlue = this.get(BLUEKEY, timeToChange.get(i) / 10);

										int prevKeyDarkRed = this.get(DARKREDKEY, timeToChange.get(i - 1) / 10);
										int nextKeyDarkRed = this.get(DARKREDKEY, timeToChange.get(i) / 10);
										int prevKeyDarkGreen = this.get(DARKGREENKEY, timeToChange.get(i - 1) / 10);
										int nextKeyDarkGreen = this.get(DARKGREENKEY, timeToChange.get(i) / 10);
										int prevKeyDarkBlue = this.get(DARKBLUEKEY, timeToChange.get(i - 1) / 10);
										int nextKeyDarkBlue = this.get(DARKBLUEKEY, timeToChange.get(i) / 10);

										if(prevKeyRed < nextKeyRed)
										{
											float numberRed = (nextKeyRed - prevKeyRed) / (timeBetwinKey.get(i) / 10);
											set(RED, (int)(prevKeyRed + (numberRed * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberRed = (prevKeyRed - nextKeyRed) / (timeBetwinKey.get(i) / 10);
											set(RED, (int)(prevKeyRed - (numberRed * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}

										if(prevKeyGreen < nextKeyGreen)
										{
											float numberGreen = (nextKeyGreen - prevKeyGreen) / (timeBetwinKey.get(i) / 10);
											set(GREEN, (int)(prevKeyGreen + (numberGreen * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberGreen = (prevKeyGreen - nextKeyGreen) / (timeBetwinKey.get(i) / 10);
											set(GREEN, (int)(prevKeyGreen - (numberGreen * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}

										if(prevKeyBlue < nextKeyBlue)
										{
											float numberBlue = (nextKeyBlue - prevKeyBlue) / (timeBetwinKey.get(i) / 10);
											set(BLUE, (int)(nextKeyBlue + (numberBlue * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberBlue = (prevKeyBlue - nextKeyBlue) / (timeBetwinKey.get(i) / 10);
											set(BLUE, (int)(prevKeyBlue - (numberBlue * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}

										if(prevKeyDarkRed < nextKeyDarkRed)
										{
											float numberDarkRed = (nextKeyDarkRed - prevKeyDarkRed) / (timeBetwinKey.get(i) / 10);
											set(DARKRED, (int)(prevKeyDarkRed + (numberDarkRed * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberDarkRed = (prevKeyDarkRed - nextKeyDarkRed) / (timeBetwinKey.get(i) / 10);
											set(DARKRED, (int)(prevKeyDarkRed - (numberDarkRed * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}

										if(prevKeyDarkGreen < nextKeyDarkGreen)
										{
											float numberDarkGreen = (nextKeyDarkGreen - prevKeyDarkGreen) / (timeBetwinKey.get(i) / 10);
											set(DARKGREEN, (int)(prevKeyDarkGreen + (numberDarkGreen * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberDarkGreen = (prevKeyDarkGreen - nextKeyDarkGreen) / (timeBetwinKey.get(i) / 10);
											set(DARKGREEN, (int)(prevKeyDarkGreen - (numberDarkGreen * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}

										if(prevKeyDarkBlue < nextKeyDarkBlue)
										{
											float numberDarkBlue = (nextKeyDarkBlue - prevKeyDarkBlue) / (timeBetwinKey.get(i) / 10);
											set(DARKBLUE, (int)(nextKeyDarkBlue + (numberDarkBlue * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										else
										{
											float numberDarkBlue = (prevKeyDarkBlue - nextKeyDarkBlue) / (timeBetwinKey.get(i) / 10);
											set(DARKBLUE, (int)(prevKeyDarkBlue - (numberDarkBlue * (timeBetwinKey.get(i) - (timeToChange.get(i) - get(TIMELINE))) / 10)));
										}
										this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
									}
								}
							}
						}
					}
					else
					{
						int time = get(TIMELINE) / 10;
						if(get(KEYLIST, time) == 1 && lastTimeUse != time)
						{
							lastTimeUse = time;

							set(RED, get(REDKEY, time));
							set(GREEN, get(GREENKEY, time));
							set(BLUE, get(BLUEKEY, time));
							set(DARKRED, get(DARKREDKEY, time));
							set(DARKGREEN, get(DARKGREENKEY, time));
							set(DARKBLUE, get(DARKBLUEKEY, time));
							set(ANGLE1, get(ANGLE1KEY, time));
							set(ANGLE2, get(ANGLE2KEY, time));
							set(AUTOROTATE, get(AUTOROTATEKEY, time));
							set(ROTATIONSPEED, get(ROTATIONSPEEDKEY, time));
							set(SECONDARYLAZER, get(SECONDARYLAZERKEY, time));
							set(REVERSEROTATION, get(REVERSEROTATIONKEY, time));
							this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
						}
					}
				}
			}
			this.isActive = true;
		}
		else
		{
			this.isActive = false;
		}
	}

	@SideOnly(Side.CLIENT)
	public float isActive()
	{
		if(!this.isActive)
		{
			return 0.0F;
		}
		else
		{
			int i = (int)(this.worldObj.getTotalWorldTime() - this.worldTimeClient);
			this.worldTimeClient = this.worldObj.getTotalWorldTime();

			if(i > 1)
			{
				this.activeBooleanFloat -= (float)i / 40.0F;

				if(this.activeBooleanFloat < 0.0F)
				{
					this.activeBooleanFloat = 0.0F;
				}
			}

			this.activeBooleanFloat += 0.025F;

			if(this.activeBooleanFloat > 1.0F)
			{
				this.activeBooleanFloat = 1.0F;
			}

			return this.activeBooleanFloat;
		}
	}

	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()
	{
		return 65536.0D;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("SpotLightRed", red);
		nbtTagCompound.setInteger("SpotLightGreen", green);
		nbtTagCompound.setInteger("SpotLightBlue", blue);
		nbtTagCompound.setInteger("SpotLightDarkRed", darkRed);
		nbtTagCompound.setInteger("SpotLightDarkGreen", darkGreen);
		nbtTagCompound.setInteger("SpotLightDarkBlue", darkBlue);
		nbtTagCompound.setInteger("SpotLightAngle1", angle1);
		nbtTagCompound.setInteger("SpotLightAngle2", angle2);
		nbtTagCompound.setInteger("SpotLightAutoRotate", autoRotate);
		nbtTagCompound.setInteger("SpotLightRotationSpeed", rotationSpeed);
		nbtTagCompound.setInteger("SpotLightSecondaryLaser", secondaryLazer);
		nbtTagCompound.setInteger("SpotLightReverseRotation", reverseRotation);

		nbtTagCompound.setInteger("SpotlightSelectedButtonId", selectedbuttonid);
		nbtTagCompound.setInteger("SpotLightTimeLineMode", timeLineMode);
		nbtTagCompound.setInteger("SpotLightTimeLine", timeLine);
		nbtTagCompound.setInteger("SpotLightCreateKeyTime", createKeyTime);
		nbtTagCompound.setIntArray("SpotLightHasKey", keyList);
		nbtTagCompound.setIntArray("SpotLightTimeRed", redkey);
		nbtTagCompound.setIntArray("SpotLightTimeGreen", greenkey);
		nbtTagCompound.setIntArray("SpotLightTimeBlue", bluekey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkRed", darkRedkey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkGreen", darkGreenkey);
		nbtTagCompound.setIntArray("SpotLightTimeDarkBlue", darkBluekey);
		nbtTagCompound.setIntArray("SpotLightTimeAngle1", angle1key);
		nbtTagCompound.setIntArray("SpotLightTimeAngle2", angle2key);
		nbtTagCompound.setIntArray("SpotLightTimeAutoRotate", autoRotatekey);
		nbtTagCompound.setIntArray("SpotLightTimeRotateSpeed", rotateSpeedkey);
		nbtTagCompound.setIntArray("SpotLightTimeSecondaryLazer", secondaryLazerkey);
		nbtTagCompound.setIntArray("SpotLightTimeReverseRotation", reverseRotationkey);
		nbtTagCompound.setInteger("SpotLightSmoothMode", smoothMode);

		NBTTagList itemList = new NBTTagList();
		for(int j = 0; j < inventory.length; j++)
		{
			ItemStack stack = inventory[j];
			if(stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte)j);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		nbtTagCompound.setTag("Inventory", itemList);
		if(this.customName != null)
		{
			nbtTagCompound.setString("Name", this.customName);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		red = nbtTagCompound.getInteger("SpotLightRed");
		green = nbtTagCompound.getInteger("SpotLightGreen");
		blue = nbtTagCompound.getInteger("SpotLightBlue");
		darkRed = nbtTagCompound.getInteger("SpotLightDarkRed");
		darkGreen = nbtTagCompound.getInteger("SpotLightDarkGreen");
		darkBlue = nbtTagCompound.getInteger("SpotLightDarkBlue");
		angle1 = nbtTagCompound.getInteger("SpotLightAngle1");
		angle2 = nbtTagCompound.getInteger("SpotLightAngle2");
		autoRotate = nbtTagCompound.getInteger("SpotLightAutoRotate");
		rotationSpeed = nbtTagCompound.getInteger("SpotLightRotationSpeed");
		secondaryLazer = nbtTagCompound.getInteger("SpotLightSecondaryLaser");
		reverseRotation = nbtTagCompound.getInteger("SpotLightReverseRotation");

		selectedbuttonid = nbtTagCompound.getInteger("SpotlightSelectedButtonId");
		timeLineMode = nbtTagCompound.getInteger("SpotLightTimeLineMode");
		timeLine = nbtTagCompound.getInteger("SpotLightTimeLine");
		createKeyTime = nbtTagCompound.getInteger("SpotLightCreateKeyTime");
		keyList = nbtTagCompound.getIntArray("SpotLightHasKey");
		redkey = nbtTagCompound.getIntArray("SpotLightTimeRed");
		greenkey = nbtTagCompound.getIntArray("SpotLightTimeGreen");
		bluekey = nbtTagCompound.getIntArray("SpotLightTimeBlue");
		darkRedkey = nbtTagCompound.getIntArray("SpotLightTimeDarkRed");
		darkGreenkey = nbtTagCompound.getIntArray("SpotLightTimeDarkGreen");
		darkBluekey = nbtTagCompound.getIntArray("SpotLightTimeDarkBlue");
		angle1key = nbtTagCompound.getIntArray("SpotLightTimeAngle1");
		angle2key = nbtTagCompound.getIntArray("SpotLightTimeAngle2");
		autoRotatekey = nbtTagCompound.getIntArray("SpotLightTimeAutoRotate");
		rotateSpeedkey = nbtTagCompound.getIntArray("SpotLightTimeRotateSpeed");
		secondaryLazerkey = nbtTagCompound.getIntArray("SpotLightTimeSecondaryLazer");
		reverseRotationkey = nbtTagCompound.getIntArray("SpotLightTimeReverseRotation");
		smoothMode = nbtTagCompound.getInteger("SpotLightSmoothMode");

		NBTTagList tagList = nbtTagCompound.getTagList("Inventory", 10);
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound)tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");

			if(slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}

		if(nbtTagCompound.hasKey("Name"))
		{
			this.customName = nbtTagCompound.getString("Name");
		}
	}

	/**
	 * Set a value
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, int value)
	{
		switch(index)
		{
		case RED:
			this.red = value;
			break;
		case GREEN:
			this.green = value;
			break;
		case BLUE:
			this.blue = value;
			break;
		case DARKRED:
			this.darkRed = value;
			break;
		case DARKGREEN:
			this.darkGreen = value;
			break;
		case DARKBLUE:
			this.darkBlue = value;
			break;
		case ANGLE1:
			this.angle1 = value;
			break;
		case ANGLE2:
			this.angle2 = value;
			break;
		case AUTOROTATE:
			this.autoRotate = value;
			break;
		case ROTATIONSPEED:
			this.rotationSpeed = value;
			break;
		case SECONDARYLAZER:
			this.secondaryLazer = value;
			break;
		case REVERSEROTATION:
			this.reverseRotation = value;
			break;
		case CONFIGCOPIER:
		{
			if(value == 0)
			{
				this.addNbtTagToItem();
				break;
			}
			else
			{
				this.setConfig();
				break;
			}
		}
		case TIMELINEMODE:
			this.timeLineMode = value;
			break;
		case CREATEKEYTIME:
			this.createKeyTime = value;
			break;
		case SELECTEDBUTTON:
			this.selectedbuttonid = value;
			break;
		case TIMELINE:
			this.timeLine = value;
			break;
		case SMOOTHMODE:
			this.smoothMode = value;
			break;
		default:
			NanotechModCity.nanoCityLogger.error("Wrong set index :" + index);
			break;
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	/**
	 * Set a value at time
	 * 
	 * @param index
	 * @param value
	 * @param time
	 */
	public void set(int index, int value, int time)
	{
		switch(index)
		{
		case KEYLIST:
			this.keyList[time] = value;
			break;
		case REDKEY:
			this.redkey[time] = value;
			break;
		case GREENKEY:
			this.greenkey[time] = value;
			break;
		case BLUEKEY:
			this.bluekey[time] = value;
			break;
		case DARKREDKEY:
			this.darkRedkey[time] = value;
			break;
		case DARKGREENKEY:
			this.darkGreenkey[time] = value;
			break;
		case DARKBLUEKEY:
			this.darkBluekey[time] = value;
			break;
		case ANGLE1KEY:
			this.angle1key[time] = value;
			break;
		case ANGLE2KEY:
			this.angle2key[time] = value;
			break;
		case AUTOROTATEKEY:
			this.autoRotatekey[time] = value;
			break;
		case ROTATIONSPEEDKEY:
			this.rotateSpeedkey[time] = value;
			break;
		case SECONDARYLAZERKEY:
			this.secondaryLazerkey[time] = value;
			break;
		case REVERSEROTATIONKEY:
			this.reverseRotationkey[time] = value;
			break;
		default:
			NanotechModCity.nanoCityLogger.error("Wrong set index :" + index);
			break;
		}
	}

	/**
	 * Get a value
	 * 
	 * @param index
	 * @param value
	 * @return the value
	 */
	public int get(int index)
	{
		switch(index)
		{
		case REVSMOOTHMODE:
			return Math.abs(get(SMOOTHMODE) - 1);
		case REVTIMELINEMODE:
			return Math.abs(get(TIMELINEMODE) - 1);
		case REVREVERSEROTATION:
			return Math.abs(get(REVERSEROTATION) - 1);
		case REVSECONDARYLAZER:
			return Math.abs(get(SECONDARYLAZER) - 1);
		case REVAUTOROTATE:
			return Math.abs(get(AUTOROTATE) - 1);
		case RED:
			return this.red;
		case GREEN:
			return this.green;
		case BLUE:
			return this.blue;
		case DARKRED:
			return this.darkRed;
		case DARKGREEN:
			return this.darkGreen;
		case DARKBLUE:
			return this.darkBlue;
		case ANGLE1:
			return this.angle1;
		case ANGLE2:
			return this.angle2;
		case AUTOROTATE:
			return this.autoRotate;
		case ROTATIONSPEED:
			return this.rotationSpeed;
		case SECONDARYLAZER:
			return this.secondaryLazer;
		case REVERSEROTATION:
			return this.reverseRotation;
		case TIMELINEMODE:
			return this.timeLineMode;
		case CREATEKEYTIME:
			return this.createKeyTime;
		case SELECTEDBUTTON:
			return this.selectedbuttonid;
		case TIMELINE:
			return this.timeLine;
		case SMOOTHMODE:
			return this.smoothMode;
		default:
		{
			NanotechModCity.nanoCityLogger.error("Wrong get index :" + index);
			return -1;
		}
		}
	}

	public int get(int index, int time)
	{
		switch(index)
		{
		case KEYLIST:
			return this.keyList[time];
		case REDKEY:
			return this.redkey[time];
		case GREENKEY:
			return this.greenkey[time];
		case BLUEKEY:
			return this.bluekey[time];
		case DARKREDKEY:
			return this.darkRedkey[time];
		case DARKGREENKEY:
			return this.darkGreenkey[time];
		case DARKBLUEKEY:
			return this.darkBluekey[time];
		case ANGLE1KEY:
			return this.angle1key[time];
		case ANGLE2KEY:
			return this.angle2key[time];
		case AUTOROTATEKEY:
			return this.autoRotatekey[time];
		case ROTATIONSPEEDKEY:
			return this.rotateSpeedkey[time];
		case SECONDARYLAZERKEY:
			return this.secondaryLazerkey[time];
		case REVERSEROTATIONKEY:
			return this.reverseRotationkey[time];
		default:
		{
			NanotechModCity.nanoCityLogger.error("Wrong get index :" + index);
			return -1;
		}
		}
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex)
	{
		return inventory[slotIndex];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if(stack != null)
		{
			if(stack.stackSize <= amount)
			{
				setInventorySlotContents(slotIndex, null);
			}
			else
			{
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}

		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = getStackInSlot(slotIndex);
		if(stack != null)
		{
			setInventorySlotContents(slotIndex, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;

		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName()
	{
		return "container.spotLight";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public void openInventory()
	{}

	@Override
	public void closeInventory()
	{}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbt);
	}

	public void addNbtTagToItem()
	{
		ItemStack stack = getStackInSlot(1);
		ItemStack newStack = new ItemStack(NanotechCityItems.configCopier);
		if(stack != null && stack.getItem() == NanotechCityItems.configCopier)
		{
			newStack.setTagCompound(new NBTTagCompound());
			newStack.getTagCompound().setInteger("Type", 0);
			newStack.getTagCompound().setInteger("SpotLightRed", get(RED));
			newStack.getTagCompound().setInteger("SpotLightGreen", get(GREEN));
			newStack.getTagCompound().setInteger("SpotLightBlue", get(BLUE));
			newStack.getTagCompound().setInteger("SpotLightDarkRed", get(DARKRED));
			newStack.getTagCompound().setInteger("SpotLightDarkGreen", get(DARKGREEN));
			newStack.getTagCompound().setInteger("SpotLightDarkBlue", get(DARKBLUE));
			newStack.getTagCompound().setInteger("SpotLightAngle1", get(ANGLE1));
			newStack.getTagCompound().setInteger("SpotLightAngle2", get(ANGLE2));
			newStack.getTagCompound().setInteger("SpotLightAutoRotate", get(AUTOROTATE));
			newStack.getTagCompound().setInteger("SpotLightRotationSpeed", get(ROTATIONSPEED));
			newStack.getTagCompound().setInteger("SpotLightSecondaryLazer", get(SECONDARYLAZER));
			newStack.getTagCompound().setInteger("SpotLightReverseRotation", get(REVERSEROTATION));

			newStack.getTagCompound().setInteger("SpotLightTimeLineMode", timeLineMode);
			newStack.getTagCompound().setIntArray("SpotLightHasKey", keyList);
			newStack.getTagCompound().setIntArray("SpotLightTimeRed", redkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeGreen", greenkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeBlue", bluekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkRed", darkRedkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkGreen", darkGreenkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeDarkBlue", darkBluekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeAngle1", angle1key);
			newStack.getTagCompound().setIntArray("SpotLightTimeAngle2", angle2key);
			newStack.getTagCompound().setIntArray("SpotLightTimeAutoRotate", autoRotatekey);
			newStack.getTagCompound().setIntArray("SpotLightTimeRotateSpeed", rotateSpeedkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeSecondaryLazer", secondaryLazerkey);
			newStack.getTagCompound().setIntArray("SpotLightTimeReverseRotation", reverseRotationkey);
			newStack.getTagCompound().setInteger("SpotLightSmoothMode", smoothMode);
			setInventorySlotContents(1, newStack);
		}
	}

	public void setConfig()
	{
		ItemStack stack = getStackInSlot(1);
		if(stack != null && stack.getItem() == NanotechCityItems.configCopier)
		{
			if(stack.hasTagCompound())
			{
				if(stack.getTagCompound().hasKey("Type") && stack.getTagCompound().getInteger("Type") == 0)
				{
					if(stack.getTagCompound().hasKey("SpotLightRed"))
					{
						set(RED, stack.getTagCompound().getInteger("SpotLightRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightGreen"))
					{
						set(GREEN, stack.getTagCompound().getInteger("SpotLightGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightBlue"))
					{
						set(BLUE, stack.getTagCompound().getInteger("SpotLightBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkRed"))
					{
						set(DARKRED, stack.getTagCompound().getInteger("SpotLightDarkRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkGreen"))
					{
						set(DARKGREEN, stack.getTagCompound().getInteger("SpotLightDarkGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightDarkBlue"))
					{
						set(DARKBLUE, stack.getTagCompound().getInteger("SpotLightDarkBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAngle1"))
					{
						set(ANGLE1, stack.getTagCompound().getInteger("SpotLightAngle1"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAngle2"))
					{
						set(ANGLE2, stack.getTagCompound().getInteger("SpotLightAngle2"));
					}
					if(stack.getTagCompound().hasKey("SpotLightAutoRotate"))
					{
						set(AUTOROTATE, stack.getTagCompound().getInteger("SpotLightAutoRotate"));
					}
					if(stack.getTagCompound().hasKey("SpotLightRotationSpeed"))
					{
						set(ROTATIONSPEED, stack.getTagCompound().getInteger("SpotLightRotationSpeed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightSecondaryLazer"))
					{
						set(SECONDARYLAZER, stack.getTagCompound().getInteger("SpotLightSecondaryLazer"));
					}
					if(stack.getTagCompound().hasKey("SpotLightReverseRotation"))
					{
						set(REVERSEROTATION, (stack.getTagCompound().getInteger("SpotLightReverseRotation")));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeLineMode"))
					{
						set(TIMELINEMODE, (stack.getTagCompound().getInteger("SpotLightTimeLineMode")));
					}
					if(stack.getTagCompound().hasKey("SpotLightHasKey"))
					{
						keyList = (stack.getTagCompound().getIntArray("SpotLightHasKey"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeRed"))
					{
						redkey = (stack.getTagCompound().getIntArray("SpotLightTimeRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeGreen"))
					{
						greenkey = (stack.getTagCompound().getIntArray("SpotLightTimeGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeBlue"))
					{
						bluekey = (stack.getTagCompound().getIntArray("SpotLightTimeBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkRed"))
					{
						darkRedkey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkRed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkGreen"))
					{
						darkGreenkey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkGreen"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeDarkBlue"))
					{
						darkBluekey = (stack.getTagCompound().getIntArray("SpotLightTimeDarkBlue"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAngle1"))
					{
						angle1key = (stack.getTagCompound().getIntArray("SpotLightTimeAngle1"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAngle2"))
					{
						angle2key = (stack.getTagCompound().getIntArray("SpotLightTimeAngle2"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeAutoRotate"))
					{
						autoRotatekey = (stack.getTagCompound().getIntArray("SpotLightTimeAutoRotate"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeRotateSpeed"))
					{
						rotateSpeedkey = (stack.getTagCompound().getIntArray("SpotLightTimeRotateSpeed"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeSecondaryLazer"))
					{
						secondaryLazerkey = (stack.getTagCompound().getIntArray("SpotLightTimeSecondaryLazer"));
					}
					if(stack.getTagCompound().hasKey("SpotLightTimeReverseRotation"))
					{
						reverseRotationkey = (stack.getTagCompound().getIntArray("SpotLightTimeReverseRotation"));
					}
					if(stack.getTagCompound().hasKey("SpotLightSmoothMode"))
					{
						set(SMOOTHMODE, stack.getTagCompound().getInteger("SpotLightSmoothmode"));
					}
				}
			}
		}
	}
}