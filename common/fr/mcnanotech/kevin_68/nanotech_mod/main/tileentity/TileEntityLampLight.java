package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockLampLight;

public class TileEntityLampLight extends TileEntity 
{
	public String getLampTexture = "Nanotech_mod:textures/blocks/BlockLampLightOn.png";
	
	public void updateEntity()
	{
		getLampTexture = texture();
        if (this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
        {
            this.blockType = this.getBlockType();

            if (this.blockType != null && this.blockType instanceof BlockLamp)
            {
                ((BlockLamp)this.blockType).updateLight(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
            
            if (this.blockType != null && this.blockType instanceof BlockLampLight)
            {
                ((BlockLampLight)this.blockType).updateLight(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
	}
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}
	
	public String texture()
	{
		if (this.getBlockMetadata() == 0)
		{
			return "Nanotech_mod:textures/blocks/BlockLampLightOn.png";
		}
		else
		{
			return "Nanotech_mod:textures/blocks/BlockLampLightOff.png";
		}
	}
	
}
