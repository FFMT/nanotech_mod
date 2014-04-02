package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;

public class UGSUtils
{
	public static Map<EntityPlayer, Boolean> flyActive = new HashMap();
	public static Map<EntityPlayer, Boolean> invisibilityActive = new HashMap();
	
	public static boolean isFlyActive(EntityPlayer player)
	{
		return flyActive.containsKey(player) ? flyActive.get(player) : false;
	}

	public static boolean isInvisibilityActive(EntityPlayer player)
	{
		return invisibilityActive.containsKey(player) ? invisibilityActive.get(player) : false;
	}

	public static void switchVisibility(EntityPlayer player, ItemStack chestPlate)
	{ 
		if(ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
		{
			NBTTagCompound tag = getTag(chestPlate);
			boolean invisible = !tag.getBoolean("invisible");
			tag.setBoolean("invisible", invisible);
			player.addChatComponentMessage(new ChatComponentTranslation(invisible ? "ultimate.inv.on" : "ultimate.inv.off"));
			invisibilityActive.put(player, invisible);
		}
		else
		{
			player.addChatComponentMessage(new ChatComponentTranslation("ultimate.inv.noenergy"));
		}
	}
	
	public static void switchFly(EntityPlayer player, ItemStack chestPlate)
	{ 
		if(ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
		{
			NBTTagCompound tag = getTag(chestPlate);
			boolean fly = !tag.getBoolean("fly");
			tag.setBoolean("fly", fly);
			player.addChatComponentMessage(new ChatComponentTranslation(fly ? "ultimate.fly.on" : "ultimate.fly.off"));
			flyActive.put(player, fly);
		}
		else
		{
			player.addChatComponentMessage(new ChatComponentTranslation("ultimate.fly.noenergy"));
		}
	}

	public static NBTTagCompound getTag(ItemStack stack)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		return stack.getTagCompound();
	}
}