package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import ic2.core.util.KeyboardClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.network.ClientPacketHelper;

public class UGSClientEventHandler
{
	private boolean keyDown;
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	public static boolean isFlyActiveByMod = false;
	public static boolean isInvisibilityActiveByMod = false;
	public static boolean isINightVisionActiveByMod = false;
	public static boolean isFirstLoad = false;
	public static boolean isLastUndressed = false;
	public static boolean isLastCreativeState = false;
	public static float moveStrafe;
	public static float moveForward;

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event)
	{
		ClientPacketHelper.firstLoad = true;
	}

	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == Phase.START)
		{
			if(mc.theWorld != null)
			{
				UltimateGraviSuite.keyboard.sendKeyUpdate(mc.thePlayer);
				ItemStack chestPlate = mc.thePlayer.inventory.armorInventory[2];

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					if(mc.thePlayer.capabilities.isCreativeMode && !isLastCreativeState)
					{
						isLastCreativeState = true;
					}
					else if(!mc.thePlayer.capabilities.isCreativeMode && isLastCreativeState && isFlyActiveByMod)
					{
						mc.thePlayer.capabilities.allowFlying = true;
						mc.thePlayer.capabilities.isFlying = true;
						isLastCreativeState = false;
					}

					ClientPacketHelper.onTickClient(mc.thePlayer, chestPlate, moveStrafe, moveForward);

					if(mc.thePlayer.posY > 262.0D && !mc.thePlayer.capabilities.isCreativeMode)
					{
						mc.thePlayer.setPosition(mc.thePlayer.posX, 262.0D, mc.thePlayer.posZ);
					}
				}
				else if(isFlyActiveByMod)
				{
					mc.thePlayer.capabilities.allowFlying = false;
					mc.thePlayer.capabilities.isFlying = false;
					isFlyActiveByMod = false;
					isLastUndressed = true;
				}
			}
		}

		if(event.phase == Phase.END)
		{
			if(UltimateGraviSuiteMod.displayHud && mc.theWorld != null && mc.inGameHasFocus)
			{
				if(!isDebugInfoEnabled())
				{
					ItemStack chestPlate = mc.thePlayer.inventory.armorItemInSlot(2);
					int var8 = 0;
					int var9 = 0;
					int var10 = 0;
					int var11 = 0;
					int var12 = 0;
					int var13 = 0;
					String graviPercentage = "";
					String graviStatus = "";
					byte var14 = 3;
					int charge;
					long percentage;

					if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuiteMod.ultimateGraviChestPlate))
					{
						charge = UltimateGraviChestPlate.getCharge(chestPlate);
						percentage = (long)(((long)charge * 100.0D) / UltimateGraviChestPlate.maxCharge);
						graviPercentage = StatCollector.translateToLocalFormatted("gravi.energy.level", getTextEnergyStatus(percentage));
						var13 = mc.fontRenderer.getStringWidth(graviPercentage);

						if(isFlyActiveByMod && UltimateGraviChestPlate.readFlyStatus(chestPlate))
						{
							graviStatus = StatCollector.translateToLocal("gravi.fly.on");
							var12 = mc.fontRenderer.getStringWidth(graviStatus);
						}
						else
						{
							graviStatus = "";
						}
					}
					if(graviPercentage != "")
					{
						ScaledResolution var25 = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
						int var26 = var25.getScaledWidth();
						int var27 = var25.getScaledHeight();

						if(UltimateGraviSuiteMod.hudPos == 1)
						{
							var8 = 2;
							var10 = 2;
							var9 = 2;
							var11 = 2 + var14 + mc.fontRenderer.FONT_HEIGHT;
						}

						if(UltimateGraviSuiteMod.hudPos == 2)
						{
							if(graviStatus != "")
							{
								var8 = var26 - var12 - 2;
							}

							var10 = var26 - var13 - 2;
							var9 = 2;
							var11 = 2 + var14 + mc.fontRenderer.FONT_HEIGHT;
						}

						if(UltimateGraviSuiteMod.hudPos == 3)
						{
							var8 = 2;
							var10 = 2;
							var9 = var27 - 2 - mc.fontRenderer.FONT_HEIGHT;
							var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
						}

						if(UltimateGraviSuiteMod.hudPos == 4)
						{
							if(graviStatus != "")
							{
								var8 = var26 - var12 - 2;
							}

							var10 = var26 - var13 - 2;
							var9 = var27 - 2 - mc.fontRenderer.FONT_HEIGHT;
							var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
						}

						if(graviStatus != "")
						{
							mc.ingameGUI.drawString(mc.fontRenderer, graviStatus, var8, var9, 16777215);
							mc.ingameGUI.drawString(mc.fontRenderer, graviPercentage, var10, var11, 16777215);
						}
						else
						{
							mc.ingameGUI.drawString(mc.fontRenderer, graviPercentage, var10, var9, 16777215);
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onEvent(KeyInputEvent event)
	{
		if(mc.inGameHasFocus)
		{
			ItemStack helmet = mc.thePlayer.inventory.armorItemInSlot(3);
			ItemStack chestPlate = mc.thePlayer.inventory.armorItemInSlot(2);
			ItemStack leggings = mc.thePlayer.inventory.armorItemInSlot(1);
			ItemStack boots = mc.thePlayer.inventory.armorItemInSlot(0);

			if(ClientProxy.flyKey.isPressed())
			{

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuiteMod.ultimateGraviChestPlate))
				{
					ClientProxy.sendMyPacket("keyFLY", 1);
					ClientPacketHelper.switchFlyModeClient(KeyboardClient.mc.thePlayer, chestPlate);
				}
			}

			if(ClientProxy.invKey.isPressed())
			{
				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuiteMod.ultimateGraviChestPlate))
				{
					ClientProxy.sendMyPacket("keyInv", 1);
					ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, chestPlate);

					if(leggings != null && leggings.getItem().equals(UltimateGraviSuiteMod.ultimateLeggings))
					{
						ClientProxy.sendMyPacket("keyInvLeg", 1);
						ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, leggings);
					}

					if(boots != null && boots.getItem().equals(UltimateGraviSuiteMod.ultimateBoots))
					{
						ClientProxy.sendMyPacket("keyInvBoo", 1);
						ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, boots);
					}

					if(helmet != null && helmet.getItem().equals(UltimateGraviSuiteMod.ultimateHelmet))
					{
						ClientProxy.sendMyPacket("keyInvHel", 1);
						ClientPacketHelper.switchInvisibleModeClient(KeyboardClient.mc.thePlayer, helmet);
					}
				}
			}

			if(ClientProxy.nightKey.isPressed())
			{
				if(helmet != null && helmet.getItem().equals(UltimateGraviSuiteMod.ultimateHelmet))
				{
					ClientProxy.sendMyPacket("keyNight", 1);
					ClientPacketHelper.switchNightVisionModeClient(KeyboardClient.mc.thePlayer, helmet);
				}
			}
		}
	}

	public static boolean isDebugInfoEnabled()
	{
		return mc != null && mc.gameSettings.showDebugInfo;
	}

	public String getTextEnergyStatus(long percentage)
	{
		String color;
		if(percentage <= 10 && percentage > 5)
			color = String.valueOf(EnumChatFormatting.GOLD);
		else if(percentage <= 5)
			color = String.valueOf(EnumChatFormatting.RED);
		else
			color = String.valueOf(EnumChatFormatting.GREEN);
		return color + Long.toString(percentage) + "%";
	}
	
	public static void updatePlayerMove()
	{
		moveStrafe = 0.0F;
		moveForward = 0.0F;

		if(mc.gameSettings.keyBindForward.isPressed())
		{
			++moveForward;
		}

		if(mc.gameSettings.keyBindBack.isPressed())
		{
			--moveForward;
		}

		if(mc.gameSettings.keyBindLeft.isPressed())
		{
			++moveStrafe;
		}

		if(mc.gameSettings.keyBindRight.isPressed())
		{
			--moveStrafe;
		}

		if(mc.gameSettings.keyBindSneak.isPressed())
		{
			moveStrafe = (float)((double)moveStrafe * 0.3D);
			moveForward = (float)((double)moveForward * 0.3D);
		}
	}
}