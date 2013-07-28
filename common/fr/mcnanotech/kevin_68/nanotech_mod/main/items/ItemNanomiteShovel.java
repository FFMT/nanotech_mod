package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemNanomiteShovel extends ItemSpade
{
	public ItemNanomiteShovel(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("Nanotech_mod:nanomiteShovel");
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return true;
	}
}