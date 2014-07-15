package fr.mcnanotech.kevin_68.nanotechmod.core.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class SpotLightEntry
{
	private boolean active;
	
	private int keyRed;
	private int keyGreen;
	private int keyBlue;
	private int keySecRed;
	private int keySecGreen;
	private int keySecBlue;
	private int keyAngle1;
	private int keyAngle2;
	private boolean keyAutRot;
	private boolean keyRevRot;
	private int keyRotSpe;
	private boolean keySecLas;
	private int displayAxe;
	
	public SpotLightEntry(boolean active, int red, int green, int blue, int secRed, int secGreen, int secBlue, int angle1, int angle2, boolean autoRot, boolean revRot, int rotSpe, boolean secLas, int displayAxe)
	{
		this.active = active;
		this.keyRed = red;
		this.keyGreen = green;
		this.keyBlue = blue;
		this.keySecRed = secRed;
		this.keySecGreen = secGreen;
		this.keySecBlue = secBlue;
		this.keyAngle1 = angle1;
		this.keyAngle2 = angle2;
		this.keyAutRot = autoRot;
		this.keyRevRot = revRot;
		this.keyRotSpe = rotSpe;
		this.keySecLas = secLas;
		this.displayAxe = displayAxe;
	}
	
	private SpotLightEntry()
	{
	}

	public boolean isActive()
	{
		return active;
	}
	
	public int getKeyRed()
	{
		return keyRed;
	}

	public int getKeyGreen()
	{
		return keyGreen;
	}

	public int getKeyBlue()
	{
		return keyBlue;
	}

	public int getKeySecRed()
	{
		return keySecRed;
	}

	public int getKeySecGreen()
	{
		return keySecGreen;
	}

	public int getKeySecBlue()
	{
		return keySecBlue;
	}

	public int getKeyAngle1()
	{
		return keyAngle1;
	}

	public int getKeyAngle2()
	{
		return keyAngle2;
	}

	public boolean isKeyAutRot()
	{
		return keyAutRot;
	}

	public boolean isKeyRevRot()
	{
		return keyRevRot;
	}

	public int getKeyRotSpe()
	{
		return keyRotSpe;
	}

	public boolean isKeySecLas()
	{
		return keySecLas;
	}
	
	public int getKeyDisplayAxe()
	{
		return displayAxe;
	}
	
    public static SpotLightEntry loadSpotLightEntryFromNBT(NBTTagCompound nbtTagCompound)
    {
    	SpotLightEntry entry = new SpotLightEntry();
    	entry.readFromNBT(nbtTagCompound);
        return entry;
    }
	
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound)
    {
    	nbtTagCompound.setBoolean("Active", this.active);
		nbtTagCompound.setInteger("red", this.keyRed);
		nbtTagCompound.setInteger("green", this.keyGreen);
		nbtTagCompound.setInteger("blue", this.keyBlue);
		nbtTagCompound.setInteger("secRed", this.keySecRed);
		nbtTagCompound.setInteger("secGreen", this.keySecGreen);
		nbtTagCompound.setInteger("secBlue", this.keySecBlue);
		nbtTagCompound.setInteger("angle1", this.keyAngle1);
		nbtTagCompound.setInteger("angle2", this.keyAngle2);
		nbtTagCompound.setBoolean("autoRot", this.keyAutRot);
		nbtTagCompound.setBoolean("revRot", this.keyRevRot);
		nbtTagCompound.setInteger("rotSpe", this.keyRotSpe);
		nbtTagCompound.setBoolean("secLas", this.keySecLas);
		nbtTagCompound.setInteger("displayAxe", this.displayAxe);

        return nbtTagCompound;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
    	this.active = nbtTagCompound.getBoolean("Active");
		this.keyRed = nbtTagCompound.getInteger("red");
		this.keyGreen = nbtTagCompound.getInteger("green");
		this.keyBlue = nbtTagCompound.getInteger("blue");
		this.keySecRed = nbtTagCompound.getInteger("secRed");
		this.keySecGreen = nbtTagCompound.getInteger("secGreen");
		this.keySecBlue = nbtTagCompound.getInteger("secBlue");
		this.keyAngle1 = nbtTagCompound.getInteger("angle1");
		this.keyAngle2 = nbtTagCompound.getInteger("angle2");
		this.keyAutRot = nbtTagCompound.getBoolean("autoRot");
		this.keyRevRot = nbtTagCompound.getBoolean("revRot");
		this.keyRotSpe = nbtTagCompound.getInteger("rotSpe");
		this.keySecLas = nbtTagCompound.getBoolean("secLas");
		this.displayAxe = nbtTagCompound.getInteger("displayAxe");
    }
}