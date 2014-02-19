/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemNanomiteArmor extends ItemArmor
{
	public ItemNanomiteArmor(ArmorMaterial armormaterial, int slot, int layer)
	{
		super(armormaterial, slot, layer);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem().equals(NanotechItem.nanomiteLeggings))
		{
			return "nanotechmod:textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "nanotechmod:textures/armor/Nanomitearmor.png";
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().equals(NanotechItem.itemBase) && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}