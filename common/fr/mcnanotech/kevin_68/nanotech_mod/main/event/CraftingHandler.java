package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

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
		if(stack.itemID == NanotechBlock.BlockJumper.blockID)
		{
			if(stack == new ItemStack(NanotechBlock.BlockJumper, 1, 0))
			{
				player.triggerAchievement(NanotechAchievement.blockJumper);
			}
			if(stack == new ItemStack(NanotechBlock.BlockJumper, 1, 1))
			{
				player.triggerAchievement(NanotechAchievement.blockJumperAdv);
			}

		}
		if(stack.itemID == NanotechBlock.BlockMossystone.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockMossyStone);
		}
		if(stack.itemID == NanotechBlock.Blocknotfalling.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockNotFalling);
		}
		if(stack.itemID == NanotechBlock.BlockPortalframe.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockPortalFrame);
		}
		if(stack.itemID == NanotechBlock.BlockSmoker.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockSmoker);
		}
		if(stack.itemID == NanotechBlock.BlockSpeed.blockID)
		{
			if(stack == new ItemStack(NanotechBlock.BlockSpeed, 1, 0))
			{
				player.triggerAchievement(NanotechAchievement.blockSpeed);
			}
			if(stack == new ItemStack(NanotechBlock.BlockSpeed, 1, 1))
			{
				player.triggerAchievement(NanotechAchievement.blockSlow);
			}
		}
		if(stack.itemID == NanotechBlock.BlockSpotLight.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockSpotLight);
		}
		if(stack.itemID == NanotechBlock.BlockTheDeathHead.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockTheDeath);
		}
		if(stack.itemID == NanotechBlock.BlockTrail.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockTrail);
		}
		if(stack.itemID == NanotechBlock.BlockTrashcan.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockTrashCan);
		}

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{

	}
}