/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock
{
    public ItemBlockMachine(Block block)
    {
        super(block);
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        if(stack.getItemDamage() >= 0 && stack.getItemDamage() < BlockNanotechMachine.subName.length)
        {
            return getUnlocalizedName() + "." + BlockNanotechMachine.subName[stack.getItemDamage()];
        }
        else
        {
            return getUnlocalizedName();
        }
    }
}