package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;

public class ClientTickHandler implements ITickHandler
{
	private boolean keyDown;
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	public static boolean isFlyActiveByMod = false;
	public static boolean isInvisibilityActiveByMod = false;
	public static boolean isINightVisionActiveByMod = false;
	public static boolean isFirstLoad = false;
	public static boolean isLastUndressed = false;
	public static boolean isLastCreativeState = false;

	public void tickStart(EnumSet type, Object... tickData)
	{
		if(type.contains(TickType.CLIENT) && mc.theWorld != null)
		{
			if(!isFirstLoad)
			{
				isFirstLoad = true;

				for(int keyId = 0; keyId < mc.gameSettings.keyBindings.length; ++keyId)
				{
					if(mc.gameSettings.keyBindings[keyId].keyDescription.equals("IC2 Boost Key"))
					{
						KeyboardClient.icBoostKeyID = keyId;
					}

					if(mc.gameSettings.keyBindings[keyId].keyDescription.equals("IC2 ALT Key"))
					{
						KeyboardClient.icAltKeyID = keyId;
					}

					if(mc.gameSettings.keyBindings[keyId].keyDescription.equals("IC2 Mode Switch Key"))
					{
						KeyboardClient.icModeKeyID = keyId;
					}

					if(mc.gameSettings.keyBindings[keyId].keyDescription.equals("Gravi Fly Key"))
					{
						KeyboardClient.gravisuitFlyKeyID = keyId;
					}
				}
			}

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

				ClientPacketHelper.onTickClient(mc.thePlayer, chestPlate, KeyboardClient.moveStrafe, KeyboardClient.moveForward);

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

	public static boolean isDebugInfoEnabled()
	{
		return mc != null && mc.gameSettings.showDebugInfo;
	}

	public void tickEnd(EnumSet type, Object... tickData)
	{
		if(type.contains(TickType.RENDER) && UltimateGraviSuite.displayHud && mc.theWorld != null && mc.inGameHasFocus)
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

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
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

					if(UltimateGraviSuite.hudPos == 1)
					{
						var8 = 2;
						var10 = 2;
						var9 = 2;
						var11 = 2 + var14 + mc.fontRenderer.FONT_HEIGHT;
					}

					if(UltimateGraviSuite.hudPos == 2)
					{
						if(graviStatus != "")
						{
							var8 = var26 - var12 - 2;
						}

						var10 = var26 - var13 - 2;
						var9 = 2;
						var11 = 2 + var14 + mc.fontRenderer.FONT_HEIGHT;
					}

					if(UltimateGraviSuite.hudPos == 3)
					{
						var8 = 2;
						var10 = 2;
						var9 = var27 - 2 - mc.fontRenderer.FONT_HEIGHT;
						var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
					}

					if(UltimateGraviSuite.hudPos == 4)
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

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.WORLD, TickType.WORLDLOAD, TickType.CLIENT, TickType.RENDER);
	}

	public String getTextEnergyStatus(long percentage)
	{
		String color;
		if(percentage <= 10 && percentage > 5)
			color = FFMTColor.gold;
		else if(percentage <= 5)
			color = FFMTColor.red;
		else
			color = FFMTColor.green;
		return color + Long.toString(percentage) + "%";
	}

	public String getLabel()
	{
		return "UltimateGraviSuite";
	}
}