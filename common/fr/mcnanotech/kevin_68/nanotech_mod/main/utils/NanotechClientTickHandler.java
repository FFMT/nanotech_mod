package fr.mcnanotech.kevin_68.nanotech_mod.main.utils;

import java.util.EnumSet;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class NanotechClientTickHandler implements ITickHandler
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
		
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "Nanotech Mod - drawn the player when has alters";
	}
}