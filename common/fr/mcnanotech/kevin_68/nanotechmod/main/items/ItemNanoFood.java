/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.ItemFood;

public class ItemNanoFood extends ItemFood
{

    public ItemNanoFood(int healAmount, float saturation, boolean wolf)
    {
        super(healAmount, saturation, wolf);
    }

    public ItemNanoFood(int healAmount, float saturation, boolean wolf, int pID, int pDuration, int pAmplifier, float pProb)
    {
        super(healAmount, saturation, wolf);
        this.setPotionEffect(pID, pDuration, pAmplifier, pProb);
    }
}