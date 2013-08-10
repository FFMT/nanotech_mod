package fr.mcnanotech.FFMT.FFMTAPI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.IPlayerTracker;

public class FFMTPlayerTracker implements IPlayerTracker
{
	public final String outatedmod;
	public final String lastversion;
	public final String downloadurl;
	public boolean hassay = false;

	public FFMTPlayerTracker(String modid, String last, String download)
	{
		outatedmod = modid;
		lastversion = last;
		downloadurl = download;
	}

	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		if(!hassay)
		{
			player.addChatMessage(String.format(StatCollector.translateToLocal("update.available"), outatedmod, lastversion));
			player.addChatMessage(StatCollector.translateToLocal("update.download") + " " + FFMTColor.blue + downloadurl);
			hassay = true;
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{
	}

}
