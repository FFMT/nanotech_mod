/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.tileentity;

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

public class TileEntityTextSpotLight extends TileEntity implements IInventory
{
    private ItemStack[] inventory = new ItemStack[2];
    private String customName;

    @SideOnly(Side.CLIENT)
    private long worldTime;
    @SideOnly(Side.CLIENT)
    private float booleanFloat;
    public boolean isActive;

    public static final int REVREVERSEROTATION = -2, REVROTATE = -1, ROTATE = 0, ANGLE = 1, ROTATIONSPEED = 2, REVERSEROTATION = 3, RED = 4, GREEN = 5, BLUE = 6, SCALE = 7, HEIGHT = 8, CONFIGCOPIER = 9;

    public String signText = "";
    public int rotate;
    public int angle;
    public int rotationSpeed;
    public int reverseRotation;
    public int red;
    public int green;
    public int blue;
    public int scale;
    public int height;

    public void updateEntity()
    {
        if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
        {
            this.isActive = true;
        }
        else
        {
            this.isActive = false;
        }
    }

    @SideOnly(Side.CLIENT)
    public float isActiveFloat()
    {
        if(!this.isActive)
        {
            return 0.0F;
        }
        else
        {
            int i = (int)(this.worldObj.getTotalWorldTime() - this.worldTime);
            this.worldTime = this.worldObj.getTotalWorldTime();

            if(i > 1)
            {
                this.booleanFloat -= (float)i / 40.0F;

                if(this.booleanFloat < 0.0F)
                {
                    this.booleanFloat = 0.0F;
                }
            }

            this.booleanFloat += 0.025F;

            if(this.booleanFloat > 1.0F)
            {
                this.booleanFloat = 1.0F;
            }

            return this.booleanFloat;
        }
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared()
    {
        return 65536.0D;
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setString("Text", this.signText);
        nbtTagCompound.setInteger("Rotate", rotate);
        nbtTagCompound.setInteger("Angle", angle);
        nbtTagCompound.setInteger("RotationSpeed", rotationSpeed);
        nbtTagCompound.setInteger("ReverseRotation", reverseRotation);
        nbtTagCompound.setInteger("Red", red);
        nbtTagCompound.setInteger("Green", green);
        nbtTagCompound.setInteger("Blue", blue);
        nbtTagCompound.setInteger("Scale", scale);
        nbtTagCompound.setInteger("Height", height);

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

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        this.signText = nbtTagCompound.getString("Text");
        this.rotate = nbtTagCompound.getInteger("Rotate");
        this.angle = nbtTagCompound.getInteger("Angle");
        this.rotationSpeed = nbtTagCompound.getInteger("RotationSpeed");
        this.reverseRotation = nbtTagCompound.getInteger("ReverseRotation");
        this.red = nbtTagCompound.getInteger("Red");
        this.green = nbtTagCompound.getInteger("Green");
        this.blue = nbtTagCompound.getInteger("Blue");
        this.scale = nbtTagCompound.getInteger("Scale");
        this.height = nbtTagCompound.getInteger("Height");

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

    public void setText(String s)
    {
        this.signText = s;
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public String getText()
    {
        return this.signText;
    }

    public void set(int index, int value)
    {
        switch(index)
        {
            case ROTATE:
                this.rotate = value;
                break;
            case ANGLE:
                this.angle = value;
                break;
            case ROTATIONSPEED:
                this.rotationSpeed = value;
                break;
            case REVERSEROTATION:
                this.reverseRotation = value;
                break;
            case RED:
                this.red = value;
                break;
            case GREEN:
                this.green = value;
                break;
            case BLUE:
                this.blue = value;
                break;
            case SCALE:
                this.scale = value;
                break;
            case HEIGHT:
                this.height = value;
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
            default:
                NanotechModCity.nanoCityLogger.error("Wrong set index :" + index);
                break;
        }
        this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public int get(int index)
    {
        switch(index)
        {
            case REVREVERSEROTATION:
                return Math.abs(reverseRotation - 1);
            case REVROTATE:
                return Math.abs(rotate - 1);
            case ROTATE:
                return this.rotate;
            case ANGLE:
                return this.angle;
            case ROTATIONSPEED:
                return this.rotationSpeed;
            case REVERSEROTATION:
                return this.reverseRotation;
            case RED:
                return this.red;
            case GREEN:
                return this.green;
            case BLUE:
                return this.blue;
            case SCALE:
                return this.scale;
            case HEIGHT:
                return this.height;
            default:
                NanotechModCity.nanoCityLogger.error("Wrong set index :" + index);
                return -1;
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
        return "container.textspotLight";
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

    public void addNbtTagToItem()
    {
        ItemStack stack = getStackInSlot(1);
        ItemStack newStack = new ItemStack(NanotechCityItems.configCopier);
        if(stack != null && stack.getItem() == NanotechCityItems.configCopier)
        {
            newStack.setTagCompound(new NBTTagCompound());
            newStack.getTagCompound().setInteger("Type", 1);
            newStack.getTagCompound().setString("TextSpotLightText", getText());
            newStack.getTagCompound().setInteger("TextSpotLightRed", get(RED));
            newStack.getTagCompound().setInteger("TextSpotLightGreen", get(GREEN));
            newStack.getTagCompound().setInteger("TextSpotLightBlue", get(BLUE));
            newStack.getTagCompound().setInteger("TextSpotLightAngle", get(ANGLE));
            newStack.getTagCompound().setInteger("TextSpotLightAutoRotate", get(ROTATE));
            newStack.getTagCompound().setInteger("TextSpotLightRotationSpeed", get(ROTATIONSPEED));
            newStack.getTagCompound().setInteger("TextSpotLightReverseRotation", get(REVERSEROTATION));
            newStack.getTagCompound().setInteger("TextSpotLightScale", get(SCALE));
            newStack.getTagCompound().setInteger("TextSpotLightHeight", get(HEIGHT));
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
                if(stack.getTagCompound().hasKey("Type") && stack.getTagCompound().getInteger("Type") == 1)
                {
                    if(stack.getTagCompound().hasKey("TextSpotLightText"))
                    {
                        setText(stack.getTagCompound().getString("TextSpotLightText"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightRed"))
                    {
                        set(RED, stack.getTagCompound().getInteger("TextSpotLightRed"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightGreen"))
                    {
                        set(GREEN, stack.getTagCompound().getInteger("TextSpotLightGreen"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightBlue"))
                    {
                        set(BLUE, stack.getTagCompound().getInteger("TextSpotLightBlue"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightAngle"))
                    {
                        set(ANGLE, stack.getTagCompound().getInteger("TextSpotLightAngle"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightAutoRotate"))
                    {
                        set(ROTATE, stack.getTagCompound().getInteger("TextSpotLightAutoRotate"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightRotationSpeed"))
                    {
                        set(ROTATIONSPEED, stack.getTagCompound().getInteger("TextSpotLightRotationSpeed"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightReverseRotation"))
                    {
                        set(REVERSEROTATION, stack.getTagCompound().getInteger("TextSpotLightReverseRotation"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightScale"))
                    {
                        set(SCALE, stack.getTagCompound().getInteger("TextSpotLightScale"));
                    }
                    if(stack.getTagCompound().hasKey("TextSpotLightHeight"))
                    {
                        set(HEIGHT, stack.getTagCompound().getInteger("TextSpotLightHeight"));
                    }
                }
            }
        }
    }
}