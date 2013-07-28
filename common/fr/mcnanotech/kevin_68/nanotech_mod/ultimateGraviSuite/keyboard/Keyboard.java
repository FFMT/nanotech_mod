package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard;

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

	public static boolean isBoostKeyDown(EntityPlayer var0)
	{
		return boostKeyState.containsKey(var0) ? ((Boolean)boostKeyState.get(var0)).booleanValue() : false;
	}

	public static boolean isAltKeyDown(EntityPlayer var0)
	{
		return altKeyState.containsKey(var0) ? ((Boolean)altKeyState.get(var0)).booleanValue() : false;
	}

	public static boolean isModeKeyDown(EntityPlayer var0)
	{
		return modeKeyState.containsKey(var0) ? ((Boolean)modeKeyState.get(var0)).booleanValue() : false;
	}

	public static boolean isForwardKeyDown(EntityPlayer var0)
	{
		return jumpKeyState.containsKey(var0) ? ((Boolean)forwardKeyState.get(var0)).booleanValue() : false;
	}

	public static boolean isJumpKeyDown(EntityPlayer var0)
	{
		return jumpKeyState.containsKey(var0) ? ((Boolean)jumpKeyState.get(var0)).booleanValue() : false;
	}

	public static boolean isSneakKeyDown(EntityPlayer var0)
	{
		return sneakKeyState.containsKey(var0) ? ((Boolean)sneakKeyState.get(var0)).booleanValue() : false;
	}

	public void sendKeyUpdate(EntityPlayer var1)
	{}

	public void processKeyUpdate(EntityPlayer var1, int var2)
	{
		boostKeyState.put(var1, Boolean.valueOf((var2 & 1) != 0));
		altKeyState.put(var1, Boolean.valueOf((var2 & 2) != 0));
		modeKeyState.put(var1, Boolean.valueOf((var2 & 4) != 0));
		forwardKeyState.put(var1, Boolean.valueOf((var2 & 8) != 0));
		jumpKeyState.put(var1, Boolean.valueOf((var2 & 16) != 0));
		sneakKeyState.put(var1, Boolean.valueOf((var2 & 32) != 0));

		if(isForwardKeyDown(var1))
		{
			;
		}

		if(isJumpKeyDown(var1))
		{
			;
		}

		if(isBoostKeyDown(var1))
		{
			;
		}

		if(isSneakKeyDown(var1))
		{
			;
		}
	}
}
