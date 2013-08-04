package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.ElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.KeyboardClient;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ClientTickHandler;

public class UltimateGraviChestPlateClientProxy
{
	public static boolean firstLoad = false;
	private Minecraft mc = FMLClientHandler.instance().getClient();
	private static int ticker = 0;

	public static boolean switchFlyModeClient(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			if(!var0.capabilities.isCreativeMode)
			{
				var0.capabilities.allowFlying = false;
				var0.capabilities.isFlying = false;
			}

			ClientProxy.sendPlayerMessage(var0, "\u00a7cGravitation engine OFF");
			ClientTickHandler.isFlyActiveByMod = false;
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
		}
		else
		{
			int var2 = UltimateGraviChestPlate.getCharge(stack);

			if(var2 < UltimateGraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
			{
				ClientProxy.sendPlayerMessage(var0, "Not enough energy to run Gravitation engine !");
			}
			else
			{
				ClientProxy.sendPlayerMessage(var0, "\u00a7aGravitation engine ON");
				var0.capabilities.allowFlying = true;
				var0.capabilities.isFlying = true;
				ClientTickHandler.isFlyActiveByMod = true;
				UltimateGraviChestPlate.saveFlyStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean switchInvisibleModeClient(EntityPlayer player, ItemStack stack)
	{
		if(stack.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
		{
			if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
			{
				ClientProxy.sendPlayerMessage(player, "\u00a7cInvisibility OFF");
				ClientTickHandler.isInvisibilityActiveByMod = false;
				UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);

			}
			else
			{
				int var2 = UltimateGraviChestPlate.getCharge(stack);

				if(var2 < UltimateGraviChestPlate.minCharge && !player.capabilities.isCreativeMode)
				{
					ClientProxy.sendPlayerMessage(player, "Not enough energy to be invisible !");
				}
				else
				{
					ClientProxy.sendPlayerMessage(player, "\u00a7aInvisibility ON");
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

		if(stack.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
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

	public static boolean switchNightVisionModeClient(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			ClientProxy.sendPlayerMessage(var0, "\u00a7cNight vision OFF");
			ClientTickHandler.isINightVisionActiveByMod = false;
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);

		}
		else
		{
			int var2 = UltimateQuantumHelmet.getCharge(stack);

			if(var2 < UltimateQuantumHelmet.minCharge && !var0.capabilities.isCreativeMode)
			{
				ClientProxy.sendPlayerMessage(var0, "Not enough energy to be invisible !");
			}
			else
			{
				ClientProxy.sendPlayerMessage(var0, "\u00a7aNight vision ON");
				ClientTickHandler.isINightVisionActiveByMod = true;
				UltimateQuantumHelmet.saveNightVisionStatus(stack, true);
			}
		}
		return true;
	}

	public static boolean boostMode(EntityPlayer var0, ItemStack stack, float var2, float var3)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack) && !var0.onGround && var0.capabilities.isFlying && !var0.isInWater())
		{
			int var4 = UltimateGraviChestPlate.getCharge(stack);

			if(var4 > UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier || var0.capabilities.isCreativeMode)
			{
				var0.moveFlying(var2, var3, UltimateGraviChestPlate.boostSpeed);

				if(!var0.capabilities.isCreativeMode)
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
				}
			}
		}

		return true;
	}

	public static boolean firstLoadClient(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			switchFlyModeClient(var0, stack);
		}
		if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			UltimateLeggings.saveInvisibilityStatus(stack, false);
			UltimateBoots.saveInvisibilityStatus(stack, false);
			UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);
			switchInvisibleModeClient(var0, stack);
		}
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
			switchNightVisionModeClient(var0, stack);
		}

		return true;
	}

	public static boolean onTickClient(EntityPlayer var0, ItemStack stack, float var2, float var3)
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
				int var4 = UltimateGraviChestPlate.getCharge(stack);

				if(!var0.capabilities.isCreativeMode)
				{
					if(var4 < UltimateGraviChestPlate.dischargeOnTick)
					{
						ClientProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
						switchFlyModeClient(var0, stack);
						switchInvisibleModeClient(var0, stack);
					}
					else
					{
						ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick, 3, true, false);
					}
				}

				var0.fallDistance = 0.0F;

				if(!var0.onGround && var0.capabilities.isFlying && KeyboardClient.isBoostKeyDown(var0))
				{
					KeyboardClient.updatePlayerMove();

					if(var4 <= UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier && !var0.capabilities.isCreativeMode)
					{
						ClientProxy.sendPlayerMessage(var0, "Not enough energy to boost !");
					}
					else
					{
						boostMode(var0, stack, var2, var3);

						if(KeyboardClient.isJumpKeyDown(var0))
						{
							var0.motionY += (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
						}

						if(KeyboardClient.isSneakKeyDown(var0))
						{
							var0.motionY -= (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
						}

						if(!var0.capabilities.isCreativeMode)
						{
							ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
						}
					}
				}

			}

			if(UltimateQuantumHelmet.readNightVisionStatus(stack))
			{
				int var4 = UltimateQuantumHelmet.getCharge(stack);

				if(!var0.capabilities.isCreativeMode)
				{
					if(var4 < UltimateQuantumHelmet.dischargeOnTick)
					{
						ClientProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
						switchNightVisionModeClient(var0, stack);
					}
					else
					{
						ElectricItem.manager.discharge(stack, UltimateQuantumHelmet.dischargeOnTick, 3, true, false);
					}
				}
			}

			var0.extinguish();
			return true;
		}
	}
}
