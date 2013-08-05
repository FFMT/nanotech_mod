package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemNanomiteSword extends ItemSword
{
	public ItemNanomiteSword(int id, EnumToolMaterial toolMaterial)
	{
		super(id, toolMaterial);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("Nanotech_mod:nanomiteSword");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
	{
		return true;
	}
}