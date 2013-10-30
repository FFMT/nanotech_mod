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
		itemIcon = iconregister.registerIcon("nanotech_mod:nanomiteAxe");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().itemID == NanotechItem.itemBase.itemID && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}