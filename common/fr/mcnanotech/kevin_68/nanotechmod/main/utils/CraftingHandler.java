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
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;
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

		if(stack.getItem() == NanotechModList.alters)
		{
			player.triggerAchievement(NanotechAchievement.itemAlters);
		}
		if(stack.getItem() == NanotechModList.itemBase)
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
		if(stack.getItem() == NanotechModList.diamondBow)
		{
			player.triggerAchievement(NanotechAchievement.itemDiamondBow);
		}
		if(stack.getItem() == NanotechModList.emeraldBow)
		{
			player.triggerAchievement(NanotechAchievement.itemEmeraldBow);
		}
		if(stack.getItem() == NanotechModList.nanomiteBow)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteBow);
		}
		if(stack.getItem() == NanotechModList.mysteriousBoots || stack.getItem() == NanotechModList.mysteriousChestPlate || stack.getItem() == NanotechModList.mysteriousHelmet || stack.getItem() == NanotechModList.mysteriousLeggings)
		{
			player.triggerAchievement(NanotechAchievement.itemMysteriousArmor);
		}
		if(stack.getItem() == NanotechModList.nanomiteBoots || stack.getItem() == NanotechModList.nanomiteChestPlate || stack.getItem() == NanotechModList.nanomiteHelmet || stack.getItem() == NanotechModList.nanomiteLeggings)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteArmor);
		}
		if(stack.getItem() == NanotechModList.nanomitePickaxe || stack.getItem() == NanotechModList.nanomiteAxe || stack.getItem() == NanotechModList.nanomiteShovel || stack.getItem() == NanotechModList.nanomiteHoe || stack.getItem() == NanotechModList.nanomiteSword)
		{
			player.triggerAchievement(NanotechAchievement.itemNanomiteTool);
		}
		if(stack.getItem() == NanotechModList.reinforcedFishingRod)
		{
			player.triggerAchievement(NanotechAchievement.itemReinforcedFishinRod);
		}
		if(stack.getItem() == NanotechModList.crazyGlassesGun)
		{
			player.triggerAchievement(NanotechAchievement.itemCrazyGlassesLauncher);
		}

	}

	// TODO fml event
	public void onSmelting(EntityPlayer player, ItemStack stack)
	{
		if(stack.getItem() == NanotechModList.itemBase)
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