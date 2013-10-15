package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import java.io.IOException;

import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityListerJukebox extends TileEntity
{
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	public void playMusic(String music)
	{
		if (music != null && music.contains(".ogg"))
		{
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			String str = music.replace(".ogg", "");
			System.out.println(str);
			this.worldObj.playRecord("nanotech_mod:" + str, xCoord, yCoord, zCoord);
		}
	}
	
	public void stopMusic()
	{
		this.worldObj.playRecord((String)null, xCoord, yCoord, zCoord);
	}
}