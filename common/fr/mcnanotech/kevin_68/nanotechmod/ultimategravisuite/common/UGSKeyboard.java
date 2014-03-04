package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.util.IKeyboard;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

public class UGSKeyboard
{
	private final Map<EntityPlayer, Boolean> flyKeyState = new HashMap();
	private final Map<EntityPlayer, Boolean> invKeyState = new HashMap();

	public boolean isFlyKeyDown(EntityPlayer player)
	{
		if(this.flyKeyState.containsKey(player))
		{
			return ((Boolean)this.flyKeyState.get(player)).booleanValue();
		}
		return false;
	}

	public boolean isInvKeyDown(EntityPlayer player)
	{
		if(this.invKeyState.containsKey(player))
		{
			return ((Boolean)this.invKeyState.get(player)).booleanValue();
		}
		return false;
	}

	public boolean isSneakKeyDown(EntityPlayer player)
	{
		return player.isSneaking();
	}

	public void sendKeyUpdate()
	{}

	public void processKeyUpdate(EntityPlayer player, int keyState)
	{
		this.flyKeyState.put(player, Boolean.valueOf((keyState & 0x1) != 0));
		this.invKeyState.put(player, Boolean.valueOf((keyState & 0x2) != 0));
	}

	public void removePlayerReferences(EntityPlayer player)
	{
		this.flyKeyState.remove(player);
		this.invKeyState.remove(player);
	}
}