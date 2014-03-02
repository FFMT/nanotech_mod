package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.util.IKeyboard;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

public class UGSKeyboard
{
	private final Map<EntityPlayer, Boolean> flyKeyState = new HashMap();
	private final Map<EntityPlayer, Boolean> invKeyState = new HashMap();
	private final Map<EntityPlayer, Boolean> nightKeyState = new HashMap();
	private final Map<EntityPlayer, Boolean> forwardKeyState = new HashMap();

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

	public boolean isNightKeyDown(EntityPlayer player)
	{
		if(this.nightKeyState.containsKey(player))
		{
			return ((Boolean)this.nightKeyState.get(player)).booleanValue();
		}
		return false;
	}

	public boolean isForwardKeyDown(EntityPlayer player)
	{
		if(this.forwardKeyState.containsKey(player))
		{
			return ((Boolean)this.forwardKeyState.get(player)).booleanValue();
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
		this.nightKeyState.put(player, Boolean.valueOf((keyState & 0x4) != 0));
		this.forwardKeyState.put(player, Boolean.valueOf((keyState & 0x8) != 0));
	}

	public void removePlayerReferences(EntityPlayer player)
	{
		this.flyKeyState.remove(player);
		this.invKeyState.remove(player);
		this.nightKeyState.remove(player);
		this.forwardKeyState.remove(player);
	}
}