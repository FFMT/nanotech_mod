package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

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
				this.worldObj.playRecord("nanotechmod:" + music, xCoord, yCoord, zCoord);
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
		number = 0;
		this.worldObj.playRecord((String)null, xCoord, yCoord, zCoord);
	}

	public void playAllPlaylist(Map map, List list)
	{
		stopMusic();
		playRecords = true;
		playListMap = map;
		playListList = list;
		timer = 100;
	}

	public int number = 0;
	public int timer = 0;

	public void updateEntity()
	{
		if(timer < 100)
		{
			timer++;
		}
		else
		{
			timer = 0;
			if(playRecords && !playListMap.isEmpty())
			{
				System.out.println(number);
				String music = playListMap.get(playListList.get(number)).toString();
				System.out.println(music);
				boolean isPlaying = Minecraft.getMinecraft().sndManager.sndSystem.playing("streaming");
				System.out.println(isPlaying);
				if(!isPlaying)
				{
					playMusic(music, music.contains(":") ? true : false);
					if(number == playListList.size() - 1)
					{
						number = 0;
					}
					else
					{
						number++;
					}
				}
				else
				{
					return;
				}
			}
		}
	}
}