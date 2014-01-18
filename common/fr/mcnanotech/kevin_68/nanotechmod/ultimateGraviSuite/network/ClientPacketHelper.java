package fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.network;

import ic2.api.item.ElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.client.FMLClientHandler;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.keyboard.KeyboardClient;

public class ClientPacketHelper
{
	public static boolean firstLoad = false;
	private Minecraft mc = FMLClientHandler.instance().getClient();
	private static int ticker = 0;

	public static boolean switchFlyModeClient(EntityPlayer player, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			if(!player.capabilities.isCreativeMode)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
			}

			ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.off"));
			ClientTickHandler.isFlyActiveByMod = false;
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
		}
		else
		{
			int charge = UltimateGraviChestPlate.getCharge(stack);

			if(charge < UltimateGraviChestPlate.minCharge && !player.capabilities.isCreativeMode)
			{
				ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.noenergy"));
			}
			else
			{
				ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.on"));
				player.capabilities.allowFlying = true;
				player.capabilities.isFlying = true;
				ClientTickHandler.isFlyActiveByMod = true;
				UltimateGraviChestPlate.saveFlyStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean switchInvisibleModeClient(EntityPlayer player, ItemStack stack)
	{
		if(stack.getItem() == UltimateGraviSuite.ultimateGraviChestPlate)
		{
			if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
			{
				ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.on"));
				ClientTickHandler.isInvisibilityActiveByMod = false;
				UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);

			}
			else
			{
				int charge = UltimateGraviChestPlate.getCharge(stack);

				if(charge < UltimateGraviChestPlate.minCharge && !player.capabilities.isCreativeMode)
				{
					ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.noenergy"));
				}
				else
				{
					ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.on"));
					ClientTickHandler.isInvisibilityActiveByMod = true;
					UltimateGraviChestPlate.saveInvisibilityStatus(stack, true);
				}
			}
		}

		if(stack.getItem() == UltimateGraviSuite.ultimateLeggings)
		{
			if(UltimateLeggings.readInvisibilityStatus(stack))
			{
				UltimateLeggings.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateLeggings.saveInvisibilityStatus(stack, true);

			}
		}

		if(stack.getItem() == UltimateGraviSuite.ultimateBoots)
		{
			if(UltimateBoots.readInvisibilityStatus(stack))
			{
				UltimateBoots.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateBoots.saveInvisibilityStatus(stack, true);

			}
		}

		if(stack.getItem() == UltimateGraviSuite.ultimateHelmet)
		{
			if(UltimateQuantumHelmet.readInvisibilityStatus(stack))
			{
				UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateQuantumHelmet.saveInvisibilityStatus(stack, true);

			}
		}
		return true;
	}

	public static boolean switchNightVisionModeClient(EntityPlayer player, ItemStack stack)
	{
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.off"));
			ClientTickHandler.isINightVisionActiveByMod = false;
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);

		}
		else
		{
			int charge = UltimateQuantumHelmet.getCharge(stack);

			if(charge < UltimateQuantumHelmet.minCharge && !player.capabilities.isCreativeMode)
			{
				ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.noenergy"));
			}
			else
			{
				ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.on"));
				ClientTickHandler.isINightVisionActiveByMod = true;
				UltimateQuantumHelmet.saveNightVisionStatus(stack, true);
			}
		}
		return true;
	}

	public static boolean boostMode(EntityPlayer player, ItemStack stack, float f1, float f2)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack) && !player.onGround && player.capabilities.isFlying && !player.isInWater())
		{
			int charge = UltimateGraviChestPlate.getCharge(stack);

			if(charge > UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier || player.capabilities.isCreativeMode)
			{
				player.moveFlying(f1, f2, UltimateGraviChestPlate.boostSpeed);

				if(!player.capabilities.isCreativeMode)
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
				}
			}
		}

		return true;
	}

	public static boolean firstLoadClient(EntityPlayer player, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			switchFlyModeClient(player, stack);
		}
		if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			UltimateLeggings.saveInvisibilityStatus(stack, false);
			UltimateBoots.saveInvisibilityStatus(stack, false);
			UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);
			switchInvisibleModeClient(player, stack);
		}
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
			switchNightVisionModeClient(player, stack);
		}

		return true;
	}

	public static boolean onTickClient(EntityPlayer player, ItemStack stack, float f1, float f2)
	{
		if(firstLoad)
		{
			ClientProxy.sendMyPacket("worldLoad", 1);
			firstLoad = false;
			return true;
		}
		else
		{
			if(ClientTickHandler.isLastUndressed)
			{
				UltimateGraviChestPlate.saveFlyStatus(stack, false);
				ClientTickHandler.isLastUndressed = false;
			}

			if(UltimateGraviChestPlate.readFlyStatus(stack) || UltimateGraviChestPlate.readInvisibilityStatus(stack))
			{
				int charge = UltimateGraviChestPlate.getCharge(stack);

				if(!player.capabilities.isCreativeMode)
				{
					if(charge < UltimateGraviChestPlate.dischargeOnTick)
					{
						ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.outofenergy"));
						switchFlyModeClient(player, stack);
						switchInvisibleModeClient(player, stack);
					}
					else
					{
						ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick, 3, true, false);
					}
				}

				player.fallDistance = 0.0F;

				if(!player.onGround && player.capabilities.isFlying && KeyboardClient.isBoostKeyDown(player))
				{
					KeyboardClient.updatePlayerMove();

					if(charge <= UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier && !player.capabilities.isCreativeMode)
					{
						ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.boost.noenergy"));
					}
					else
					{
						boostMode(player, stack, f1, f2);

						if(KeyboardClient.isJumpKeyDown(player))
						{
							player.motionY += (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
						}

						if(KeyboardClient.isSneakKeyDown(player))
						{
							player.motionY -= (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
						}

						if(!player.capabilities.isCreativeMode)
						{
							ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
						}
					}
				}
			}

			if(UltimateQuantumHelmet.readNightVisionStatus(stack))
			{
				int charge = UltimateQuantumHelmet.getCharge(stack);

				if(!player.capabilities.isCreativeMode)
				{
					if(charge < UltimateQuantumHelmet.dischargeOnTick)
					{
						ClientProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.outofenergy"));
						switchNightVisionModeClient(player, stack);
					}
					else
					{
						ElectricItem.manager.discharge(stack, UltimateQuantumHelmet.dischargeOnTick, 3, true, false);
					}
				}
			}

			player.extinguish();
			return true;
		}
	}
}