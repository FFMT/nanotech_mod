package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class TileEntityLampLight extends TileEntity
{
    public String getLampTexture = NanotechMod.MODID + ":textures/blocks/lamp_on.png";

    @Override
    public void updateEntity()
    {
        getLampTexture = texture();
        if(this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
        {
            if(this.getBlockMetadata() == 2 && !worldObj.isDaytime())
            {
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
            }
            else if(this.getBlockMetadata() == 3 && worldObj.isDaytime())
            {
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }

    public String texture()
    {
        if(this.getBlockMetadata() == 3)
        {
            return NanotechMod.MODID + ":textures/blocks/lamp_on.png";
        }
        else
        {
            return NanotechMod.MODID + ":textures/blocks/lamp_off.png";
        }
    }
}