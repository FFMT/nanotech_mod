package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemNanomiteAxe extends ItemAxe
{

	public ItemNanomiteAxe(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}

    public void registerIcons(IconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("Nanotech_mod:nanomiteAxe");
    }

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return true;
	}
}