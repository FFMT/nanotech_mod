package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
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
					System.out.println("moveStrafe : " + moveStrafe);
					System.out.println("moveForward : " + moveForward);
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
}