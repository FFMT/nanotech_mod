package fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityModernFence extends TileEntity
{
	public void updateEntity()
	{
        boolean flag = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord - 1);
        boolean flag1 = this.canConnectFenceTo(this.worldObj, this.xCoord, this.yCoord, this.zCoord + 1);
        boolean flag2 = this.canConnectFenceTo(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord);
        boolean flag3 = this.canConnectFenceTo(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord);
        
        
	}
	
    public boolean canConnectFenceTo(World world, int x, int y, int z)
    {
        int l = world.getBlockId(x, y, z);

        if (l != this.getBlockType().blockID)
        {
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }
    
}
