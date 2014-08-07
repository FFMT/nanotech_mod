package fr.mcnanotech.kevin_68.nanotechmod.core.utils;

import net.minecraft.nbt.NBTTagCompound;

public class SpotLightEntry
{
    private boolean active;

    private byte keyRed;
    private byte keyGreen;
    private byte keyBlue;
    private byte keySecRed;
    private byte keySecGreen;
    private byte keySecBlue;
    private int keyAngle1;
    private byte keyAngle2;
    private boolean keyAutRot;
    private boolean keyRevRot;
    private byte keyRotSpe;
    private boolean keySecLas;
    private byte displayAxe;
    private boolean sideLaser;
    private byte mainLaserSize;
    private byte secLaserSize;
    private int laserHeight;
    private boolean textEnabled;
    private byte txtRed;
    private byte txtGreen;
    private byte txtBlue;
    private int txtAngle1;
    private boolean txtAutoRotate;
    private boolean txtReverseRotation;
    private byte txtRotationSpeed;
    private byte txtScale;
    private byte txtHeight;

    public SpotLightEntry(boolean active, byte red, byte green, byte blue, byte secRed, byte secGreen, byte secBlue, int angle1, byte angle2, boolean autoRot, boolean revRot, byte rotSpe, boolean secLas, byte displayAxe, boolean sideLaser, byte mainLaserSize, byte secLaserSize, int laserHeight, boolean textEnabled, byte keyTxtRed, byte keyTxtGreen, byte keyTxtBlue, int txtAngle1, boolean txtAutoRotate, boolean txtReveseRotation, byte txtRotationSpeed, byte txtScale, byte txtHeight)
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
        this.sideLaser = sideLaser;
        this.mainLaserSize = mainLaserSize;
        this.secLaserSize = secLaserSize;
        this.laserHeight = laserHeight;
        this.textEnabled = textEnabled;
        this.txtRed = keyTxtRed;
        this.txtGreen = keyTxtGreen;
        this.txtBlue = keyTxtBlue;
        this.txtAngle1 = txtAngle1;
        this.txtAutoRotate = txtAutoRotate;
        this.txtReverseRotation = txtReveseRotation;
        this.txtRotationSpeed = txtRotationSpeed;
        this.txtScale = txtScale;
        this.txtHeight = txtHeight;
    }

    private SpotLightEntry()
    {}

    public boolean isActive()
    {
        return active;
    }

    public byte getKeyRed()
    {
        return keyRed;
    }

    public byte getKeyGreen()
    {
        return keyGreen;
    }

    public byte getKeyBlue()
    {
        return keyBlue;
    }

    public byte getKeySecRed()
    {
        return keySecRed;
    }

    public byte getKeySecGreen()
    {
        return keySecGreen;
    }

    public byte getKeySecBlue()
    {
        return keySecBlue;
    }

    public int getKeyAngle1()
    {
        return keyAngle1;
    }

    public byte getKeyAngle2()
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

    public byte getKeyRotSpe()
    {
        return keyRotSpe;
    }

    public boolean isKeySecLas()
    {
        return keySecLas;
    }

    public byte getKeyDisplayAxe()
    {
        return displayAxe;
    }

    public boolean isSideLaser()
    {
        return sideLaser;
    }

    public byte getKeyMainLaserSize()
    {
        return mainLaserSize;
    }

    public byte getKeySecLaserSize()
    {
        return secLaserSize;
    }

    public int getKeyLaserHeight()
    {
        return laserHeight;
    }

    public boolean isKeyTextEnabled()
    {
        return textEnabled;
    }

    public byte getKeyTxtRed()
    {
        return txtRed;
    }

    public byte getKeyTxtGreen()
    {
        return txtGreen;
    }

    public byte getKeyTxtBlue()
    {
        return txtBlue;
    }

    public int getTxtAngle1()
    {
        return txtAngle1;
    }

    public boolean isTxtAutoRotate()
    {
        return txtAutoRotate;
    }

    public boolean isTxtReverseRotation()
    {
        return txtReverseRotation;
    }

    public byte getTxtRotationSpeed()
    {
        return txtRotationSpeed;
    }

    public byte getTxtScale()
    {
        return txtScale;
    }

    public byte getTxtHeight()
    {
        return txtHeight;
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
        nbtTagCompound.setByte("red", this.keyRed);
        nbtTagCompound.setByte("green", this.keyGreen);
        nbtTagCompound.setByte("blue", this.keyBlue);
        nbtTagCompound.setByte("secRed", this.keySecRed);
        nbtTagCompound.setByte("secGreen", this.keySecGreen);
        nbtTagCompound.setByte("secBlue", this.keySecBlue);
        nbtTagCompound.setInteger("angle1", this.keyAngle1);
        nbtTagCompound.setByte("angle2", this.keyAngle2);
        nbtTagCompound.setBoolean("autoRot", this.keyAutRot);
        nbtTagCompound.setBoolean("revRot", this.keyRevRot);
        nbtTagCompound.setByte("rotSpe", this.keyRotSpe);
        nbtTagCompound.setBoolean("secLas", this.keySecLas);
        nbtTagCompound.setByte("displayAxe", this.displayAxe);
        nbtTagCompound.setBoolean("sideLaser", sideLaser);
        nbtTagCompound.setByte("mainLaserSize", this.mainLaserSize);
        nbtTagCompound.setByte("secLaserSize", this.secLaserSize);
        nbtTagCompound.setInteger("laserHeight", this.laserHeight);
        nbtTagCompound.setBoolean("textEnabled", this.textEnabled);
        nbtTagCompound.setByte("txtRed", this.txtRed);
        nbtTagCompound.setByte("txtGreen", this.txtGreen);
        nbtTagCompound.setByte("txtBlue", this.txtBlue);
        nbtTagCompound.setInteger("txtAngle1", this.txtAngle1);
        nbtTagCompound.setBoolean("txtAutoRot", this.txtAutoRotate);
        nbtTagCompound.setBoolean("txtRevRot", this.txtReverseRotation);
        nbtTagCompound.setByte("txtRotSpe", this.txtRotationSpeed);
        return nbtTagCompound;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        this.active = nbtTagCompound.getBoolean("Active");
        this.keyRed = nbtTagCompound.getByte("red");
        this.keyGreen = nbtTagCompound.getByte("green");
        this.keyBlue = nbtTagCompound.getByte("blue");
        this.keySecRed = nbtTagCompound.getByte("secRed");
        this.keySecGreen = nbtTagCompound.getByte("secGreen");
        this.keySecBlue = nbtTagCompound.getByte("secBlue");
        this.keyAngle1 = nbtTagCompound.getInteger("angle1");
        this.keyAngle2 = nbtTagCompound.getByte("angle2");
        this.keyAutRot = nbtTagCompound.getBoolean("autoRot");
        this.keyRevRot = nbtTagCompound.getBoolean("revRot");
        this.keyRotSpe = nbtTagCompound.getByte("rotSpe");
        this.keySecLas = nbtTagCompound.getBoolean("secLas");
        this.displayAxe = nbtTagCompound.getByte("displayAxe");
        this.sideLaser = nbtTagCompound.getBoolean("sideLaser");
        this.mainLaserSize = nbtTagCompound.getByte("mainLaserSize");
        this.secLaserSize = nbtTagCompound.getByte("secLaserSize");
        this.laserHeight = nbtTagCompound.getInteger("laserHeight");
        this.textEnabled = nbtTagCompound.getBoolean("textEnabled");
        this.txtRed = nbtTagCompound.getByte("txtRed");
        this.txtGreen = nbtTagCompound.getByte("txtGreen");
        this.txtBlue = nbtTagCompound.getByte("txtBlue");
        this.txtAngle1 = nbtTagCompound.getInteger("txtAngle1");
        this.txtAutoRotate = nbtTagCompound.getBoolean("txtAutoRot");
        this.txtReverseRotation = nbtTagCompound.getBoolean("txtRevRot");
        this.txtRotationSpeed = nbtTagCompound.getByte("txtRotSpe");
    }
}