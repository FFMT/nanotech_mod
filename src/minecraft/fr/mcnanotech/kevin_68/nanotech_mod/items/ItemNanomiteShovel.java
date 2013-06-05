package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemNanomiteShovel extends ItemSpade
{
	public ItemNanomiteShovel(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}
	
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return true;
    }
}