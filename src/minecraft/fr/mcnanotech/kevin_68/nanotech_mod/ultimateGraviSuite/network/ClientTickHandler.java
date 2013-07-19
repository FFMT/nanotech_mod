package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateClientProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient;

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

	public void tickStart(EnumSet var1, Object... var2)
	{
		if(var1.contains(TickType.CLIENT) && mc.theWorld != null)
		{
			if(!isFirstLoad)
			{
				isFirstLoad = true;

				for(int var3 = 0; var3 < mc.gameSettings.keyBindings.length; ++var3)
				{
					if(mc.gameSettings.keyBindings[var3].keyDescription == "Boost Key")
					{
						KeyboardClient.icBoostKeyID = var3;
					}

					if(mc.gameSettings.keyBindings[var3].keyDescription == "ALT Key")
					{
						KeyboardClient.icAltKeyID = var3;
					}

					if(mc.gameSettings.keyBindings[var3].keyDescription == "Mode Switch Key")
					{
						KeyboardClient.icModeKeyID = var3;
					}
				}
			}

			UltimateGraviSuite.keyboard.sendKeyUpdate(mc.thePlayer);
			ItemStack var4 = mc.thePlayer.inventory.armorInventory[2];

			if(var4 != null && var4.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
			{
				if(mc.thePlayer.capabilities.isCreativeMode && !isLastCreativeState)
				{
					isLastCreativeState = true;
				} else if(!mc.thePlayer.capabilities.isCreativeMode && isLastCreativeState && isFlyActiveByMod)
				{
					mc.thePlayer.capabilities.allowFlying = true;
					mc.thePlayer.capabilities.isFlying = true;
					isLastCreativeState = false;
				}

				UltimateGraviChestPlateClientProxy.onTickClient(mc.thePlayer, var4, KeyboardClient.moveStrafe, KeyboardClient.moveForward);

				if(mc.thePlayer.posY > 262.0D && !mc.thePlayer.capabilities.isCreativeMode)
				{
					mc.thePlayer.setPosition(mc.thePlayer.posX, 262.0D, mc.thePlayer.posZ);
				}
			} else if(isFlyActiveByMod)
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

	public void tickEnd(EnumSet var1, Object... var2)
	{
		if(var1.contains(TickType.RENDER) && UltimateGraviSuite.displayHud && mc.theWorld != null && mc.inGameHasFocus)
		{
			Minecraft var10000 = mc;

			if(!isDebugInfoEnabled())
			{
				ItemStack var6 = mc.thePlayer.inventory.armorItemInSlot(2);
				int var8 = 0;
				int var9 = 0;
				int var10 = 0;
				int var11 = 0;
				int var12 = 0;
				int var13 = 0;
				String var16 = "";
				String var15 = "";
				byte var14 = 3;
				int var4;
				int var5;

				if(var6 != null && var6.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
				{
					var4 = UltimateGraviChestPlate.getCharge(var6);
					var5 = var4 * 100 / UltimateGraviChestPlate.maxCharge;
					var16 = "Energy level: " + this.GetTextEnergyStatus(var5);
					var13 = mc.fontRenderer.getStringWidth("Energy level: " + Integer.toString(var5) + "%");

					if(isFlyActiveByMod && UltimateGraviChestPlate.readFlyStatus(var6))
					{
						var15 = "\u00a7aGravitation engine ON";
						var12 = mc.fontRenderer.getStringWidth("Gravitation engine ON");
					} else
					{
						var15 = "";
					}
				}
				if(var16 != "")
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
						if(var15 != "")
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
						if(var15 != "")
						{
							var8 = var26 - var12 - 2;
						}

						var10 = var26 - var13 - 2;
						var9 = var27 - 2 - mc.fontRenderer.FONT_HEIGHT;
						var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
					}

					if(var15 != "")
					{
						mc.ingameGUI.drawString(mc.fontRenderer, var15, var8, var9, 16777215);
						mc.ingameGUI.drawString(mc.fontRenderer, var16, var10, var11, 16777215);
					} else
					{
						mc.ingameGUI.drawString(mc.fontRenderer, var16, var10, var9, 16777215);
					}
				}
			}
		}
	}

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.WORLD, TickType.WORLDLOAD, TickType.CLIENT, TickType.RENDER);
	}

	public String GetTextEnergyStatus(int var1)
	{
		return var1 <= 10 && var1 > 5 ? "\u00a76" + Integer.toString(var1) + "%" : (var1 <= 5 ? "\u00a7c" + Integer.toString(var1) + "%" : Integer.toString(var1) + "%");
	}

	public String GetUSHGenerateStatus()
	{
		return UltimateQuantumHelmet.sunIsUp && UltimateQuantumHelmet.skyIsVisible ? "\u00a7eday (" + UltimateQuantumHelmet.genDay + " eu)" : (UltimateQuantumHelmet.skyIsVisible ? "\u00a73night (" + UltimateQuantumHelmet.genNight + " eu)" : "\u00a7cno sky");
	}

	public String getLabel()
	{
		return "UltimateGraviSuite";
	}
}
