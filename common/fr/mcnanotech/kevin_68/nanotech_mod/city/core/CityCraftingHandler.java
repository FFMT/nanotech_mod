package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;

public class CityCraftingHandler implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if(stack.itemID == NanotechCityBlock.BlockSpotLight.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockSpotLight);
		}
		if(stack.itemID == NanotechCityBlock.BlockTrail.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockTrail);
		}
		if(stack.itemID == NanotechCityBlock.BlockTrashcan.blockID)
		{
			player.triggerAchievement(NanotechCityAchievement.blockTrashCan);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{}
}