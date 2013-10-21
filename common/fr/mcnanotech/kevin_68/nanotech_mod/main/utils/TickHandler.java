package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.util.EnumSet;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class TickHandler implements ITickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer player = (EntityPlayer)tickData[0];
		for(int i = 0; i < player.inventory.getSizeInventory(); i++)
		{
			if(player.inventory.getStackInSlot(i) != null)
			{
				if(player.inventory.getStackInSlot(i).itemID == NanotechItem.alters.itemID)
				{
					if(player.isInsideOfMaterial(Material.water) || player.isInsideOfMaterial(Material.lava))
					{
						if(!player.capabilities.isCreativeMode)
						{
							Minecraft mc = Minecraft.getMinecraft();
							if(mc.gameSettings.isKeyDown(mc.gameSettings.keyBindJump))
							{
								mc.gameSettings.keyBindJump.pressed = false;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer player = (EntityPlayer)tickData[0];
		if(player.inventory.armorItemInSlot(3) == null)
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
		else if(player.inventory.armorItemInSlot(3).itemID != NanotechItem.crazyGlasses.itemID)
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
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "Nanotech Mod Tick Handler";
	}
}