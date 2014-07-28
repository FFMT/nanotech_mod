/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemNanomiteHoe extends ItemHoe
{
    public ItemNanomiteHoe(ToolMaterial toolMaterial)
    {
        super(toolMaterial);
    }

    @Override
    public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
    {
        if(stack.getItem().equals(this) && repairItem.getItem() == NanotechItem.itemBase && repairItem.getItemDamage() == 14)
            return true;
        return false;
    }
}