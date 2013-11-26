package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import java.io.File;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityListerJukebox extends TileEntity
{
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	public void playMusic(String music, boolean mods)
	{
		if(!mods)
		{
			if(music != null && music.contains(".ogg"))
			{
				String str = music.replace(".ogg", "");
				this.worldObj.playRecord(str, xCoord, yCoord, zCoord);
			}
			else if(music != null && music.equals("nanodisk"))
			{
				this.worldObj.playRecord("nanotech_mod:" + music, xCoord, yCoord, zCoord);
			}
		}
		else
		{
			String newMusic = music.substring(music.lastIndexOf("assets"));
			String modId = newMusic.substring(7);
			String modId2 = "";
			for(int i = 0; i != modId.length(); i++)
			{
				if(modId.charAt(i) == File.separatorChar)
				{
					modId2 = modId.substring(0, i).replace(File.separator + "records", "").toLowerCase();
				}
			}
			String musicName = music.substring(music.lastIndexOf("records" + File.separator)).replace(".ogg", "").replace("records" + File.separator, "");
			
			this.worldObj.playRecord(modId2 + ":" + musicName, xCoord, yCoord, zCoord);
		}
	}

	public void stopMusic()
	{
		this.worldObj.playRecord((String)null, xCoord, yCoord, zCoord);
	}
}