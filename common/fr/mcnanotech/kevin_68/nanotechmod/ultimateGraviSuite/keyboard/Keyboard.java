/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.keyboard;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

public class Keyboard
{
	private static Map boostKeyState = new HashMap();
	private static Map jumpKeyState = new HashMap();
	private static Map sneakKeyState = new HashMap();
	private static Map forwardKeyState = new HashMap();
	private static Map altKeyState = new HashMap();
	private static Map modeKeyState = new HashMap();

	public static boolean isBoostKeyDown(EntityPlayer player)
	{
		if(boostKeyState.containsKey(player))
		{
			return ((Boolean)boostKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public static boolean isAltKeyDown(EntityPlayer player)
	{
		if(altKeyState.containsKey(player))
		{
			return ((Boolean)altKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public static boolean isModeKeyDown(EntityPlayer player)
	{
		if(modeKeyState.containsKey(player))
		{
			return ((Boolean)modeKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public static boolean isForwardKeyDown(EntityPlayer player)
	{
		if(jumpKeyState.containsKey(player))
		{
			return ((Boolean)forwardKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public static boolean isJumpKeyDown(EntityPlayer player)
	{
		if(jumpKeyState.containsKey(player))
		{
			return ((Boolean)jumpKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public static boolean isSneakKeyDown(EntityPlayer player)
	{
		if(sneakKeyState.containsKey(player))
		{
			return ((Boolean)sneakKeyState.get(player)).booleanValue();
		}

		return false;
	}

	public void sendKeyUpdate(EntityPlayer player)
	{}

	public void processKeyUpdate(EntityPlayer player, int i)
	{
		boostKeyState.put(player, Boolean.valueOf((i & 0x1) != 0));
		altKeyState.put(player, Boolean.valueOf((i & 0x2) != 0));
		modeKeyState.put(player, Boolean.valueOf((i & 0x4) != 0));
		forwardKeyState.put(player, Boolean.valueOf((i & 0x8) != 0));
		jumpKeyState.put(player, Boolean.valueOf((i & 0x10) != 0));
		sneakKeyState.put(player, Boolean.valueOf((i & 0x20) != 0));

		if((!isForwardKeyDown(player)) || ((!isJumpKeyDown(player)) || ((!isBoostKeyDown(player)) || (isSneakKeyDown(player)))))
			;
	}
}