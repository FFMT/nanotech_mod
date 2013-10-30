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
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientPacketHelper;

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
	public static int gravisuitFlyKeyID;
	public static float moveStrafe;
	public static float moveForward;

	public KeyboardClient()
	{
		KeyBindingRegistry.registerKeyBinding(new KeyHandler(new KeyBinding[] {flyKey, invKey, nightKey}, new boolean[] {false, false, false})
		{
			@Override
			public String getLabel()
			{
				return "UltimateGraviSuiteKeyboard";
			}

			@Override
			public void keyDown(EnumSet types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
			{
				if(tickEnd && mc.inGameHasFocus)
				{
					ItemStack helmet = mc.thePlayer.inventory.armorItemInSlot(3);
					ItemStack chestPlate = mc.thePlayer.inventory.armorItemInSlot(2);
					ItemStack leggings = mc.thePlayer.inventory.armorItemInSlot(1);
					ItemStack boots = mc.thePlayer.inventory.armorItemInSlot(0);

					if(kb.equals(flyKey))
					{

						if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimategraviChestPlate))
						{
							ClientProxy.sendMyPacket("keyFLY", 1);
							ClientPacketHelper.switchFlyModeClient(KeyboardClient.mc.thePlayer, chestPlate);
						}
					}

					if(kb.equals(KeyboardClient.invKey))
					{
						if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimategraviChestPlate))
						{
							ClientProxy.sendMyPacket("keyInv", 1);
							ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, chestPlate);

							if(leggings != null && leggings.getItem().equals(UltimateGraviSuite.ultimateLeggings))
							{
								ClientProxy.sendMyPacket("keyInvLeg", 1);
								ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, leggings);
							}

							if(boots != null && boots.getItem().equals(UltimateGraviSuite.ultimateBoots))
							{
								ClientProxy.sendMyPacket("keyInvBoo", 1);
								ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, boots);
							}

							if(helmet != null && helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet))
							{
								ClientProxy.sendMyPacket("keyInvHel", 1);
								ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, helmet);
							}
						}
					}

					if(kb.equals(KeyboardClient.nightKey))
					{
						if(helmet != null && helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet))
						{
							ClientProxy.sendMyPacket("keyNight", 1);
							ClientPacketHelper.switchNightVisionModeClient(KeyboardClient.mc.thePlayer, helmet);
						}
					}
				}
			}

			@Override
			public EnumSet ticks()
			{
				return EnumSet.of(TickType.CLIENT);
			}

			@Override
			public void keyUp(EnumSet types, KeyBinding kb, boolean tickEnd)
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
		int keyId = (isBoostKeyDown(player) ? 1 : 0) << 0 | (isAltKeyDown(player) ? 1 : 0) << 1 | (isModeKeyPress(player) ? 1 : 0) << 2 | (isForwardKeyDown(player) ? 1 : 0) << 3 | (isJumpKeyDown(player) ? 1 : 0) << 4 | (isSneakKeyDown(player) ? 1 : 0) << 5;

		if(keyId != lastKeyState)
		{
			ClientProxy.sendMyPacket("keyState", keyId);
			lastKeyState = keyId;
			super.processKeyUpdate(player, keyId);
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