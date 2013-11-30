package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity;

import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityListerJukebox extends TileEntity
{
	private boolean playRecords = false;
	private Map playListMap;
	private List playListList;
	
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
			this.worldObj.playRecord(music, xCoord, yCoord, zCoord);
		}
	}

	public void stopMusic()
	{
		playRecords = false;
		this.worldObj.playRecord((String)null, xCoord, yCoord, zCoord);
	}
	
	public void playAllPlaylist(Map map, List list)
	{
		playRecords = true;
		playListMap = map;
		playListList = list;
	}
	
	public int number = 0;
	public void updateEntity()
	{
		if(playRecords)
		{
			String music = playListMap.get(playListList.get(number)).toString();
			boolean isPlaying = Minecraft.getMinecraft().sndManager.sndSystem.playing(music);
			if(!isPlaying)
			{
				this.worldObj.playRecord(music, xCoord, yCoord, zCoord);
				if(number == playListList.size())
				{
					number = 0;
				}
				else
				{
					number++;
				}
			}
		}
	}
}