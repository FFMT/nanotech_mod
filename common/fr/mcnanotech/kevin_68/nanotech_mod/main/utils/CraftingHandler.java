package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechAchievement;

public class CraftingHandler implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if(stack.itemID == NanotechBlock.barbedwire.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockBarbedWire);
		}
		if(stack.itemID == NanotechBlock.confusion.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockConfusion);
		}
		if(stack.itemID == NanotechBlock.notfalling.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockFalling);
		}
		if(stack.itemID == NanotechBlock.jumper.blockID && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockJumper);
		}
		if(stack.itemID == NanotechBlock.jumper.blockID && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockJumperAdv);
		}
		if(stack.itemID == NanotechBlock.mossystone.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockMossyStone);
		}
		if(stack.itemID == NanotechBlock.notfalling.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockNotFalling);
		}
		if(stack.itemID == NanotechBlock.portalFrame.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockPortalFrame);
		}
		if(stack.itemID == NanotechBlock.smoker.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockSmoker);
		}
		if(stack.itemID == NanotechBlock.speed.blockID && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockSpeed);
		}
		if(stack.itemID == NanotechBlock.speed.blockID && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockSlow);
		}
		if(stack.itemID == NanotechBlock.theDeathHead.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockTheDeath);
		}
		if(stack.itemID == NanotechBlock.listerJukebox.blockID)
		{
			player.triggerAchievement(NanotechAchievement.blockListerJukebox);
		}

		if(stack.itemID == NanotechItem.alters.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemAlters);
		}
		if(stack.itemID == NanotechItem.itemBase.itemID)
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
		if(stack.itemID == NanotechItem.diamondBow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemDiamondBow);
		}
		if(stack.itemID == NanotechItem.emeraldBow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemEmeraldBow);
		}
		if(stack.itemID == NanotechItem.nanomiteBow.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteBow);
		}
		if(stack.itemID == NanotechItem.mysteriousBoots.itemID || stack.itemID == NanotechItem.mysteriousChestPlate.itemID || stack.itemID == NanotechItem.mysteriousHelmet.itemID || stack.itemID == NanotechItem.mysteriousLeggings.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemMysteriousArmor);
		}
		if(stack.itemID == NanotechItem.nanomiteBoots.itemID || stack.itemID == NanotechItem.nanomiteChestPlate.itemID || stack.itemID == NanotechItem.nanomiteHelmet.itemID || stack.itemID == NanotechItem.nanomiteLeggings.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteArmor);
		}
		if(stack.itemID == NanotechItem.nanomitePickaxe.itemID || stack.itemID == NanotechItem.nanomiteAxe.itemID || stack.itemID == NanotechItem.nanomiteShovel.itemID || stack.itemID == NanotechItem.nanomiteHoe.itemID || stack.itemID == NanotechItem.nanomiteSword.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteTool);
		}
		if(stack.itemID == NanotechItem.reinforcedFishingRod.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemReinforcedFishinRod);
		}
		if(stack.itemID == NanotechItem.crazyGlassesGun.itemID)
		{
			player.triggerAchievement(NanotechAchievement.itemCrazyGlassesLauncher);
		}

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack stack)
	{
		if(stack.itemID == NanotechItem.itemBase.itemID)
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