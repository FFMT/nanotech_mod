/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemScythe extends ItemSword
{

	public ItemScythe(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
	{
		return false;
	}
}