package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class USGCommonEventHandler
{
	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == TickEvent.Phase.END)
		{
			ItemStack chestPlate = event.player.getCurrentArmor(2);
			if(UGSUtils.isInvisible(event.player))
			{
				event.player.setInvisible(true);
				if(!event.player.capabilities.isCreativeMode)
				{
					ElectricItem.manager.discharge(chestPlate, UltimateGraviSuiteMod.ultimateUseByTick, 4, true, false);
				}
			}
			else
			{
				if(event.player.isInvisible() && !event.player.isPotionActive(Potion.invisibility))
				{
					event.player.setInvisible(false);
				}
			}

			if(UltimateGraviSuiteMod.keyboard.isFlyKeyDown(event.player))
			{
				System.out.println(event.player.getCommandSenderName() + " pressed fly key");
			}
		}
	}

	public void onPlayerFall(LivingFallEvent event)
	{
		ItemStack armor = event.entityLiving.getEquipmentInSlot(1);
		if((armor != null) && (armor.getItem() == UltimateGraviSuiteMod.ultimateBoots))
		{
			int fallDamage = Math.max((int)event.distance - 10, 0);
			int energyCost = 10000 * fallDamage;
			if(energyCost <= ElectricItem.manager.getCharge(armor))
			{
				ElectricItem.manager.discharge(armor, energyCost, Integer.MAX_VALUE, true, false);
				event.setCanceled(true);
			}
		}
	}
}