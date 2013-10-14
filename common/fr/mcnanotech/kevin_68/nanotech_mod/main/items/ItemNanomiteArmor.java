package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemNanomiteArmor extends ItemArmor
{
	public ItemNanomiteArmor(int id, EnumArmorMaterial armormaterial, int slot, int layer)
	{
		super(id, armormaterial, slot, layer);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == NanotechItem.Nanomiteleggings.itemID)
		{
			return "nanotech_mod:textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "nanotech_mod:textures/armor/Nanomitearmor.png";
		}
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().itemID == NanotechItem.ItemBase.itemID && repairItem.getItemDamage() == 14)
		return true;
		return false;
	}
}