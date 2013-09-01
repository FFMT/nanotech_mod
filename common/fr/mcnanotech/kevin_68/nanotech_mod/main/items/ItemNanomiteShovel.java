package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemNanomiteShovel extends ItemSpade
{
	public ItemNanomiteShovel(int id, EnumToolMaterial toolMaterial)
	{
		super(id, toolMaterial);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:nanomiteShovel");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
	{
		return true;
	}
}