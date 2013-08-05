package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import net.minecraft.tileentity.TileEntity;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.BlockLampLight;

public class TileEntityLampLight extends TileEntity 
{

	public void updateEntity()
	{
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
}
