/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMysteriousArmor extends ItemArmor
{
    public ItemMysteriousArmor(ArmorMaterial enumArmorMaterial, int slot, int layer)
    {
        super(enumArmorMaterial, slot, layer);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.epic;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem().equals(NanotechItem.mysteriousLeggings))
        {
            return "nanotechmod:textures/armor/Mysteriousarmor2.png";
        }
        else
        {
            return "nanotechmod:textures/armor/Mysteriousarmor.png";
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
    {
        return true;
    }
}