package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class NanotechServerTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer player = (EntityPlayer)tickData[0];
		if(player.inventory.armorItemInSlot(3) == null && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).itemID == NanotechItem.crazyGlasses.itemID)
					{
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses.itemID);
					}
				}
			}
		}
		else if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).itemID != NanotechItem.crazyGlasses.itemID && !player.capabilities.isCreativeMode)
		{
			for(int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if(player.inventory.getStackInSlot(i) != null)
				{
					if(player.inventory.getStackInSlot(i).itemID == NanotechItem.crazyGlasses.itemID)
					{
						player.inventory.setInventorySlotContents(i, player.inventory.armorItemInSlot(3).copy());
						player.inventory.setInventorySlotContents(39, new ItemStack(NanotechItem.crazyGlasses));
						player.inventory.consumeInventoryItem(NanotechItem.crazyGlasses.itemID);
					}
				}
			}
		}
		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).itemID == NanotechItem.nitrogenBucket.itemID)
				{
					Random rand = new Random();
					if(rand.nextInt(100) < 2 && this.doEffect(player))
					{
						player.attackEntityFrom(NanotechDamageSource.nitrogenDamage, 1);
					}
				}
			}
		}
	}

	private boolean doEffect(EntityPlayer player)
	{
		ItemStack helmet = player.getCurrentItemOrArmor(4);
		ItemStack chestPlate = player.getCurrentItemOrArmor(3);
		ItemStack leggings = player.getCurrentItemOrArmor(2);
		ItemStack boots = player.getCurrentItemOrArmor(1);
		if(helmet != null && chestPlate != null && leggings != null && boots != null)
		{
			if(helmet.getItem().equals(NanotechItem.mysteriousHelmet) && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && boots.getItem().equals(NanotechItem.mysteriousBoots))
			{
				return false;
			}
			if(Loader.isModLoaded("UltimateGraviSuite"))
			{
				if(helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet) && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate) && leggings.getItem().equals(UltimateGraviSuite.ultimateLeggings) && boots.getItem().equals(UltimateGraviSuite.ultimateBoots))
				{
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "Nanotech Mod - auto set crazy glasses";
	}
}