package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;

public class CityCraftingHandler implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if(stack.itemID == NanotechCityBlock.spotLight.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockSpotLight);
		}
		if(stack.itemID == NanotechCityBlock.trail.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockTrail);
		}
		if(stack.itemID == NanotechCityBlock.trashcan.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockTrashCan);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{}
}