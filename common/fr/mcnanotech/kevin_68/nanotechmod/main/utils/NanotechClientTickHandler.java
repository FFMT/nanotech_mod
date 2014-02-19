/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.util.EnumSet;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;

public class NanotechClientTickHandler
{
	// TODO fml event
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

	// TODO fml event
	public String getLabel()
	{
		return "Nanotech Mod - drawn the player when has alters";
	}
}