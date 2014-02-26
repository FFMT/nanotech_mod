/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;

public class PlayerEvent
{
	@SubscribeEvent
	public void onItemPickup(ItemPickupEvent event)
	{
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NanotechItem.scythe)))
		{
			event.player.triggerAchievement(NanotechAchievement.getScythe);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NanotechItem.crazyGlasses)))
		{
			event.player.triggerAchievement(NanotechAchievement.itemCrazyGlasses);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NanotechItem.itemBase, 1, 2)))
		{
			event.player.triggerAchievement(NanotechAchievement.getMysteriousMat);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NanotechBlock.ore, 1, 1)))
		{
			event.player.triggerAchievement(NanotechAchievement.blockSiliconOre);
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		event.player.triggerAchievement(NanotechAchievement.installMod);
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerChangedDimensionEvent event)
	{
		if(event.player.dimension == NanotechConfiguration.dimensionID)
		{
			event.player.triggerAchievement(NanotechAchievement.nanotechDim);
		}
	}
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.barbedWire))
		{
			event.player.triggerAchievement(NanotechAchievement.blockBarbedWire);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.confusion))
		{
			event.player.triggerAchievement(NanotechAchievement.blockConfusion);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.notFalling))
		{
			event.player.triggerAchievement(NanotechAchievement.blockFalling);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.jump) && event.crafting.getItemDamage() == 0)
		{
			event.player.triggerAchievement(NanotechAchievement.blockJumper);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.jump) && event.crafting.getItemDamage() == 1)
		{
			event.player.triggerAchievement(NanotechAchievement.blockJumperAdv);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.mossyStone))
		{
			event.player.triggerAchievement(NanotechAchievement.blockMossyStone);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.notFalling))
		{
			event.player.triggerAchievement(NanotechAchievement.blockNotFalling);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.portalFrame))
		{
			event.player.triggerAchievement(NanotechAchievement.blockPortalFrame);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.smoker))
		{
			event.player.triggerAchievement(NanotechAchievement.blockSmoker);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.speed) && event.crafting.getItemDamage() == 0)
		{
			event.player.triggerAchievement(NanotechAchievement.blockSpeed);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.speed) && event.crafting.getItemDamage() == 1)
		{
			event.player.triggerAchievement(NanotechAchievement.blockSlow);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.theDeathHead))
		{
			event.player.triggerAchievement(NanotechAchievement.blockTheDeath);
		}
		if(event.crafting.getItem() == Item.getItemFromBlock(NanotechBlock.listerJukeBox))
		{
			event.player.triggerAchievement(NanotechAchievement.blockListerJukebox);
		}

		if(event.crafting.getItem() == NanotechItem.alters)
		{
			event.player.triggerAchievement(NanotechAchievement.itemAlters);
		}
		if(event.crafting.getItem() == NanotechItem.itemBase)
		{
			switch(event.crafting.getItemDamage())
			{
			case 5:
				event.player.triggerAchievement(NanotechAchievement.itemCircuit);
			case 6:
				event.player.triggerAchievement(NanotechAchievement.itemAdvancedcircuit);
			case 7:
				event.player.triggerAchievement(NanotechAchievement.itemProcessor);
			case 8:
				event.player.triggerAchievement(NanotechAchievement.itemMicroProcessor);
			case 9:
				event.player.triggerAchievement(NanotechAchievement.itemCamera);
			case 10:
				event.player.triggerAchievement(NanotechAchievement.itemDetector);
			case 11:
				event.player.triggerAchievement(NanotechAchievement.itemEngine);
			case 12:
				event.player.triggerAchievement(NanotechAchievement.itemNanomite);
			case 13:
				event.player.triggerAchievement(NanotechAchievement.itemNanomiteFrame);
			case 14:
				event.player.triggerAchievement(NanotechAchievement.itemSmallNanomite);
			case 15:
				event.player.triggerAchievement(NanotechAchievement.itemVoid);
			case 16:
				event.player.triggerAchievement(NanotechAchievement.itemPortalActivator);
			default:
				return;
			}
		}
		if(event.crafting.getItem() == NanotechItem.diamondBow)
		{
			event.player.triggerAchievement(NanotechAchievement.itemDiamondBow);
		}
		if(event.crafting.getItem() == NanotechItem.emeraldBow)
		{
			event.player.triggerAchievement(NanotechAchievement.itemEmeraldBow);
		}
		if(event.crafting.getItem() == NanotechItem.nanomiteBow)
		{
			event.player.triggerAchievement(NanotechAchievement.itemNanomiteBow);
		}
		if(event.crafting.getItem() == NanotechItem.mysteriousBoots || event.crafting.getItem() == NanotechItem.mysteriousChestPlate || event.crafting.getItem() == NanotechItem.mysteriousHelmet || event.crafting.getItem() == NanotechItem.mysteriousLeggings)
		{
			event.player.triggerAchievement(NanotechAchievement.itemMysteriousArmor);
		}
		if(event.crafting.getItem() == NanotechItem.nanomiteBoots || event.crafting.getItem() == NanotechItem.nanomiteChestPlate || event.crafting.getItem() == NanotechItem.nanomiteHelmet || event.crafting.getItem() == NanotechItem.nanomiteLeggings)
		{
			event.player.triggerAchievement(NanotechAchievement.itemNanomiteArmor);
		}
		if(event.crafting.getItem() == NanotechItem.nanomitePickaxe || event.crafting.getItem() == NanotechItem.nanomiteAxe || event.crafting.getItem() == NanotechItem.nanomiteShovel || event.crafting.getItem() == NanotechItem.nanomiteHoe || event.crafting.getItem() == NanotechItem.nanomiteSword)
		{
			event.player.triggerAchievement(NanotechAchievement.itemNanomiteTool);
		}
		if(event.crafting.getItem() == NanotechItem.reinforcedFishingRod)
		{
			event.player.triggerAchievement(NanotechAchievement.itemReinforcedFishinRod);
		}
		if(event.crafting.getItem() == NanotechItem.crazyGlassesGun)
		{
			event.player.triggerAchievement(NanotechAchievement.itemCrazyGlassesLauncher);
		}
	}
	
	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event)
	{
		if(event.smelting.getItem() == NanotechItem.itemBase)
		{
			switch(event.smelting.getItemDamage())
			{
			case 0:
				event.player.triggerAchievement(NanotechAchievement.itemSiliconore);
			case 1:
				event.player.triggerAchievement(NanotechAchievement.itemStoneofdecrease);
			case 3:
				event.player.triggerAchievement(NanotechAchievement.itemSiliconplate);
			case 4:
				event.player.triggerAchievement(NanotechAchievement.itemMysteriousingot);
			default:
				return;
			}
		}
	}
}