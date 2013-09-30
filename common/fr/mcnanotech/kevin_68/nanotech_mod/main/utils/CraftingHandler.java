package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;

public class CraftingHandler implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if(stack.itemID == NanotechBlock.BlockBarbedwire.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockBarbedWire);
		}
		if(stack.itemID == NanotechBlock.BlockConfusion.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockConfusion);
		}
		if(stack.itemID == NanotechBlock.BlockFalling.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockFalling);
		}
		if(stack.itemID == NanotechBlock.BlockJumper.blockID && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockJumper);
		}

		if(stack.itemID == NanotechBlock.BlockJumper.blockID && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockJumperAdv);
		}

		if(stack.itemID == NanotechBlock.BlockMossystone.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockMossyStone);
		}
		if(stack.itemID == NanotechBlock.Blocknotfalling.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockNotFalling);
		}
		if(stack.itemID == NanotechBlock.BlockPortalFrame.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockPortalFrame);
		}
		if(stack.itemID == NanotechBlock.BlockSmoker.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockSmoker);
		}
		if(stack.itemID == NanotechBlock.BlockSpeed.blockID && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockSpeed);
		}

		if(stack.itemID == NanotechBlock.BlockSpeed.blockID && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockSlow);
		}

		if(stack.itemID == NanotechBlock.BlockTheDeathHead.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockTheDeath);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{}
}