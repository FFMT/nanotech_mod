/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

public class CraftingHandler
{
	// TODO fml event
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.barbedWire))
		{
			player.triggerAchievement(NanotechAchievement.blockBarbedWire);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.confusion))
		{
			player.triggerAchievement(NanotechAchievement.blockConfusion);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.notFalling))
		{
			player.triggerAchievement(NanotechAchievement.blockFalling);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.jump) && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockJumper);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.jump) && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockJumperAdv);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.mossyStone))
		{
			player.triggerAchievement(NanotechAchievement.blockMossyStone);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.notFalling))
		{
			player.triggerAchievement(NanotechAchievement.blockNotFalling);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.portalFrame))
		{
			player.triggerAchievement(NanotechAchievement.blockPortalFrame);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.smoker))
		{
			player.triggerAchievement(NanotechAchievement.blockSmoker);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.speed) && stack.getItemDamage() == 0)
		{
			player.triggerAchievement(NanotechAchievement.blockSpeed);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.speed) && stack.getItemDamage() == 1)
		{
			player.triggerAchievement(NanotechAchievement.blockSlow);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.theDeathHead))
		{
			player.triggerAchievement(NanotechAchievement.blockTheDeath);
		}
		if(stack.getItem() == Item.getItemFromBlock(NanotechBlock.listerJukeBox))
		{
			player.triggerAchievement(NanotechAchievement.blockListerJukebox);
		}

		if(stack.getItem() == NanotechItem.alters)
		{
			player.triggerAchievement(NanotechAchievement.itemAlters);
		}
		if(stack.getItem() == NanotechItem.itemBase)
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
		if(stack.getItem() == NanotechItem.diamondBow)
		{
			player.triggerAchievement(NanotechAchievement.itemDiamondBow);
		}
		if(stack.getItem() == NanotechItem.emeraldBow)
		{
			player.triggerAchievement(NanotechAchievement.itemEmeraldBow);
		}
		if(stack.getItem() == NanotechItem.nanomiteBow)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteBow);
		}
		if(stack.getItem() == NanotechItem.mysteriousBoots || stack.getItem() == NanotechItem.mysteriousChestPlate || stack.getItem() == NanotechItem.mysteriousHelmet || stack.getItem() == NanotechItem.mysteriousLeggings)
		{
			player.triggerAchievement(NanotechAchievement.itemMysteriousArmor);
		}
		if(stack.getItem() == NanotechItem.nanomiteBoots || stack.getItem() == NanotechItem.nanomiteChestPlate || stack.getItem() == NanotechItem.nanomiteHelmet || stack.getItem() == NanotechItem.nanomiteLeggings)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteArmor);
		}
		if(stack.getItem() == NanotechItem.nanomitePickaxe || stack.getItem() == NanotechItem.nanomiteAxe || stack.getItem() == NanotechItem.nanomiteShovel || stack.getItem() == NanotechItem.nanomiteHoe || stack.getItem() == NanotechItem.nanomiteSword)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteTool);
		}
		if(stack.getItem() == NanotechItem.reinforcedFishingRod)
		{
			player.triggerAchievement(NanotechAchievement.itemReinforcedFishinRod);
		}
		if(stack.getItem() == NanotechItem.crazyGlassesGun)
		{
			player.triggerAchievement(NanotechAchievement.itemCrazyGlassesLauncher);
		}

	}

	// TODO fml event
	public void onSmelting(EntityPlayer player, ItemStack stack)
	{
		if(stack.getItem() == NanotechItem.itemBase)
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