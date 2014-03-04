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
	private static final Map<EntityPlayer, Boolean> lock = new HashMap();

	public static boolean isInvisible(Entity entity)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			ItemStack chestPlate = player.getCurrentArmor(2);
			if(chestPlate != null && chestPlate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
			{
				NBTTagCompound tag = chestPlate.getTagCompound();
				if(tag != null)
				{
					return tag.getBoolean("invisible");
				}
			}
		}
		return false;
	}

	public static void switchVisibility(EntityPlayer player)
	{
		ItemStack chestPlate = player.getCurrentArmor(2);
		if(chestPlate != null && chestPlate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
		{
			if(ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
			{
				NBTTagCompound tag = getTag(chestPlate);
				tag.setBoolean("invisible", !tag.getBoolean("invisible"));
				player.addChatComponentMessage(new ChatComponentTranslation(tag.getBoolean("invisible") ? "ultimate.inv.on" : "ultimate.inv.off"));
			}
			else
			{
				player.addChatComponentMessage(new ChatComponentTranslation("ultimate.inv.noenergy"));
			}
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