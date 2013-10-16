package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

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
		if(stack.itemID == NanotechBlock.BlockListerJukebox.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockListerJukebox);
		}

		if(stack.itemID == NanotechItem.alters.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemAlters);
		}
		if(stack.itemID == NanotechItem.ItemBase.itemID)
		{
			switch(stack.getItemDamage())
			{
			case 5:
				player.triggerAchievement(NanotechAchievement.itemCircuit);
			case 6:
				player.triggerAchievement(NanotechAchievement.itemAdvancedcircuit);
			case 7:
				player.triggerAchievement(NanotechAchievement.itemProcessor);
			case 8:
				player.triggerAchievement(NanotechAchievement.itemMicroProcessor);
			case 9:
				player.triggerAchievement(NanotechAchievement.itemCamera);
			case 10:
				player.triggerAchievement(NanotechAchievement.itemDetector);
			case 11:
				player.triggerAchievement(NanotechAchievement.itemEngine);
			case 12:
				player.triggerAchievement(NanotechAchievement.itemNanomite);
			case 13:
				player.triggerAchievement(NanotechAchievement.itemNanomiteFrame);
			case 14:
				player.triggerAchievement(NanotechAchievement.itemSmallNanomite);
			case 15:
				player.triggerAchievement(NanotechAchievement.itemVoid);
			case 16:
				player.triggerAchievement(NanotechAchievement.itemPortalActivator);
			default:
				return;
			}
		}
		if(stack.itemID == NanotechItem.Diamondbow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemDiamondBow);
		}
		if(stack.itemID == NanotechItem.Emeraldbow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemEmeraldBow);
		}
		if(stack.itemID == NanotechItem.Nanomitebow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteBow);
		}
		if(stack.itemID == NanotechItem.Mysteriousboots.itemID || stack.itemID == NanotechItem.Mysteriouschestplate.itemID || stack.itemID == NanotechItem.Mysterioushelmet.itemID || stack.itemID == NanotechItem.Mysteriousleggings.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemMysteriousArmor);
		}
		if(stack.itemID == NanotechItem.Nanomiteboots.itemID || stack.itemID == NanotechItem.Nanomitechestplate.itemID || stack.itemID == NanotechItem.Nanomitehelmet.itemID || stack.itemID == NanotechItem.Nanomiteleggings.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteArmor);
		}
		if(stack.itemID == NanotechItem.Nanomitepickaxe.itemID || stack.itemID == NanotechItem.Nanomiteaxe.itemID || stack.itemID == NanotechItem.Nanomiteshovel.itemID || stack.itemID == NanotechItem.Nanomitehoe.itemID || stack.itemID == NanotechItem.Nanomitesword.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteTool);
		}

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack stack)
	{
		if(stack.itemID == NanotechItem.ItemBase.itemID)
		{
			switch(stack.getItemDamage())
			{
			case 0:
				player.triggerAchievement(NanotechAchievement.itemSiliconore);
			case 1:
				player.triggerAchievement(NanotechAchievement.itemStoneofdecrease);
			case 3:
				player.triggerAchievement(NanotechAchievement.itemSiliconplate);
			case 4:
				player.triggerAchievement(NanotechAchievement.itemMysteriousingot);
			default:
				return;
			}
		}
	}
}