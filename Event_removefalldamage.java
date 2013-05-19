package fr.mcnanotech.kevin_68.nanotech_mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class Event_removefalldamage 
{

	@ForgeSubscribe
	public void livingFall(LivingFallEvent event)
	{
		if (!(event.entityLiving instanceof EntityPlayer)) return;
		EntityPlayer eventPlayer = (EntityPlayer)event.entityLiving;
		event.distance = 0F;
	}
}
