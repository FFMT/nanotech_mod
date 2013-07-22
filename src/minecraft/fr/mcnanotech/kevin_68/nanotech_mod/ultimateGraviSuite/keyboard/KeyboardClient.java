package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import gravisuite.GraviSuite;

@SideOnly(Side.CLIENT)
public class KeyboardClient extends Keyboard
{
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	public static KeyBinding flyKey = new KeyBinding("Ultimate Gravi Fly Key", 33);
	public static KeyBinding invKey = new KeyBinding("Invisibility Ultimate Gravi Key", 34);
	public static KeyBinding nightKey = new KeyBinding("Night vision Ultimate Solar Helmet Key", 35);
	private static int lastKeyState = 0;
	private static boolean lastKeyModeState = false;
	public static int icBoostKeyID;
	public static int icAltKeyID;
	public static int icModeKeyID;
	public static float moveStrafe;
	public static float moveForward;

	public KeyboardClient()
	{
		KeyBindingRegistry.registerKeyBinding(new KeyHandler(new KeyBinding[]
		{flyKey, invKey, nightKey}, new boolean[]
		{false, false, false})
		{
			@Override
			public String getLabel()
			{
				return "UltimateGraviSuiteKeyboard";
			}

			@Override
			public void keyDown(EnumSet var1, KeyBinding var2, boolean var3, boolean var4)
			{
				if(var3 && var2 == KeyboardClient.flyKey && KeyboardClient.mc.inGameHasFocus)
				{
					ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(2);

					if(var5 != null && var5.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
					{
						ClientProxy.sendMyPacket("keyFLY", 1);
						UltimateGraviChestPlateClientProxy.switchFlyModeClient(KeyboardClient.mc.thePlayer, var5);
					}
				}

				if(var3 && var2 == KeyboardClient.invKey && KeyboardClient.mc.inGameHasFocus)
				{
					ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(2);
					ItemStack var6 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(1);
					ItemStack var7 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(0);
					ItemStack var8 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(3);

					if(var5 != null && var5.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
					{
						ClientProxy.sendMyPacket("keyInv", 1);
						UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var5);

						if(var6 != null && var6.getItem() == UltimateGraviSuite.ultimateLeggings)
						{
							ClientProxy.sendMyPacket("keyInvLeg", 1);
							UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var6);
						}

						if(var7 != null && var7.getItem() == UltimateGraviSuite.ultimateBoots)
						{
							ClientProxy.sendMyPacket("keyInvBoo", 1);
							UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var7);
						}

						if(var8 != null && var8.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
						{
							ClientProxy.sendMyPacket("keyInvHel", 1);
							UltimateGraviChestPlateClientProxy.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, var8);
						}
					}
				}

				if(var3 && var2 == KeyboardClient.nightKey && KeyboardClient.mc.inGameHasFocus)
				{
					ItemStack var5 = KeyboardClient.mc.thePlayer.inventory.armorItemInSlot(3);

					if(var5 != null && var5.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
					{
						ClientProxy.sendMyPacket("keyNight", 1);
						UltimateGraviChestPlateClientProxy.switchNightVisionModeClient(KeyboardClient.mc.thePlayer, var5);
					}
				}
			}

			@Override
			public EnumSet ticks()
			{
				return EnumSet.of(TickType.CLIENT);
			}

			@Override
			public void keyUp(EnumSet var1, KeyBinding var2, boolean var3)
			{}
		});
	}

	public static boolean isBoostKeyDown(EntityPlayer player)
	{
		return mc.gameSettings.keyBindings[icBoostKeyID].pressed;
	}

	public static boolean isAltKeyDown(EntityPlayer player)
	{
		return mc.gameSettings.keyBindings[icAltKeyID].pressed;
	}

	public static boolean isModeKeyPress(EntityPlayer player)
	{
		if(mc.gameSettings.keyBindings[icModeKeyID].pressed)
		{
			if(!lastKeyModeState)
			{
				lastKeyModeState = true;
				sendModeKey(player);
			}

			return true;
		}
		else
		{
			lastKeyModeState = false;
			return false;
		}
	}

	public static boolean isJumpKeyDown(EntityPlayer player)
	{
		return mc.gameSettings.keyBindJump.pressed;
	}

	public static boolean isForwardKeyDown(EntityPlayer player)
	{
		return mc.gameSettings.keyBindForward.pressed;
	}

	public static boolean isSneakKeyDown(EntityPlayer player)
	{
		return mc.gameSettings.keyBindSneak.pressed;
	}

	public static void sendModeKey(EntityPlayer player)
	{
		ClientProxy.sendMyPacket("keyModePressed", 1);
	}

	public void sendKeyUpdate(EntityPlayer player)
	{
		int var2 = (isBoostKeyDown(player) ? 1 : 0) << 0 | (isAltKeyDown(player) ? 1 : 0) << 1 | (isModeKeyPress(player) ? 1 : 0) << 2 | (isForwardKeyDown(player) ? 1 : 0) << 3 | (isJumpKeyDown(player) ? 1 : 0) << 4 | (isSneakKeyDown(player) ? 1 : 0) << 5;

		if(var2 != lastKeyState)
		{
			ClientProxy.sendMyPacket("keyState", var2);
			lastKeyState = var2;
			super.processKeyUpdate(player, var2);
		}
	}

	public static void updatePlayerMove()
	{
		moveStrafe = 0.0F;
		moveForward = 0.0F;

		if(mc.gameSettings.keyBindForward.pressed)
		{
			++moveForward;
		}

		if(mc.gameSettings.keyBindBack.pressed)
		{
			--moveForward;
		}

		if(mc.gameSettings.keyBindLeft.pressed)
		{
			++moveStrafe;
		}

		if(mc.gameSettings.keyBindRight.pressed)
		{
			--moveStrafe;
		}

		if(mc.gameSettings.keyBindSneak.pressed)
		{
			moveStrafe = (float)((double)moveStrafe * 0.3D);
			moveForward = (float)((double)moveForward * 0.3D);
		}
	}
}
