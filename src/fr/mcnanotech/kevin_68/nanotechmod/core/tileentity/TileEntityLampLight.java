package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class TileEntityLampLight extends TileEntity
{
    @Override
    public void updateEntity()
    {
        if(this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
        {
            if(this.getBlockMetadata() == 2 && !worldObj.isDaytime())
            {
                this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
                this.worldObj.updateLightByType(EnumSkyBlock.Block, this.xCoord, this.yCoord, this.zCoord);
            }
            else if(this.getBlockMetadata() == 3 && worldObj.isDaytime())
            {
                this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
                this.worldObj.updateLightByType(EnumSkyBlock.Block, this.xCoord, this.yCoord, this.zCoord);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }

    public String getTexture()
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