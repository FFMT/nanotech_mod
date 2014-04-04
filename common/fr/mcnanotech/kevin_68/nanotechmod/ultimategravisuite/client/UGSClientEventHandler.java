package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateArmor;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;

public class UGSClientEventHandler
{
	private Minecraft mc = FMLClientHandler.instance().getClient();

	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == TickEvent.Phase.END)
		{
			UltimateGraviSuiteMod.keyboard.sendKeyUpdate();

			ItemStack chestplate = event.player.getEquipmentInSlot(3);
			if(chestplate != null && chestplate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
			{
				if(!event.player.onGround && event.player.capabilities.isFlying && IC2.keyboard.isBoostKeyDown(event.player) && ElectricItem.manager.getCharge(chestplate) > UltimateGraviSuiteMod.ultimateMinCharge)
				{
					float moveStrafe = 0.0F;
					float moveForward = 0.0F;

					if(mc.gameSettings.keyBindForward.getIsKeyPressed())
					{
						++moveForward;
					}

					if(mc.gameSettings.keyBindBack.getIsKeyPressed())
					{
						--moveForward;
					}

					if(mc.gameSettings.keyBindLeft.getIsKeyPressed())
					{
						++moveStrafe;
					}

					if(mc.gameSettings.keyBindRight.getIsKeyPressed())
					{
						--moveStrafe;
					}

					if(mc.gameSettings.keyBindSneak.getIsKeyPressed())
					{
						moveStrafe *= 0.3F;
						moveForward *= 0.3F;
					}
					event.player.moveFlying(moveStrafe, moveForward, 0.15F);

					if(mc.gameSettings.keyBindJump.getIsKeyPressed())
					{
						event.player.motionY += 0.18F;
					}

					if(mc.gameSettings.keyBindSneak.getIsKeyPressed())
					{
						event.player.motionY -= 0.18F;
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void renderPower(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || (event.type != ElementType.EXPERIENCE && event.type != ElementType.HEALTHMOUNT))
		{
			return;
		}

		GL11.glEnable(GL11.GL_BLEND);
		int k = event.resolution.getScaledWidth();
		int l = event.resolution.getScaledHeight();
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
			charge = ElectricItem.manager.getCharge(chestPlate);
			percentage = (long)(((long)charge * 100.0D) / 1000000000);
			graviPercentage = getTextEnergyStatus(percentage);
			var13 = mc.fontRenderer.getStringWidth(graviPercentage);
		}
		if(graviPercentage != "")
		{

			if(UltimateGraviSuiteMod.hudPos == 1)
			{
				var8 = 5;
				var10 = 5;
				var9 = 5;
				var11 = 5 + var14 + mc.fontRenderer.FONT_HEIGHT;
			}

			if(UltimateGraviSuiteMod.hudPos == 2)
			{
				if(graviStatus != "")
				{
					var8 = k - var12 - 2;
				}

				var10 = k - var13 - 2;
				var9 = 2;
				var11 = 2 + var14 + mc.fontRenderer.FONT_HEIGHT;
			}

			if(UltimateGraviSuiteMod.hudPos == 3)
			{
				var8 = 2;
				var10 = 2;
				var9 = l - 2 - mc.fontRenderer.FONT_HEIGHT;
				var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
			}

			if(UltimateGraviSuiteMod.hudPos == 4)
			{
				if(graviStatus != "")
				{
					var8 = k - var12 - 2;
				}

				var10 = k - var13 - 2;
				var9 = l - 2 - mc.fontRenderer.FONT_HEIGHT;
				var11 = var9 - var14 - mc.fontRenderer.FONT_HEIGHT;
			}

			if(graviStatus != "")
			{
				this.mc.fontRenderer.drawString(graviStatus, var8, var9, 16777215);
				this.mc.fontRenderer.drawString(graviPercentage, var10, var11, 16777215);
			}
			else
			{
				this.mc.fontRenderer.drawString(graviPercentage, var10, var9, 16777215);
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
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

	public void drawCenteredString(FontRenderer font, String string, int x, int y, int color)
	{
		font.drawStringWithShadow(string, x - font.getStringWidth(string) / 2, y, color);
	}
}