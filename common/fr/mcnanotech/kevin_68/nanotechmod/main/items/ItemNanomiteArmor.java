package fr.mcnanotech.kevin_68.nanotechmod.main.items;

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
		itemIcon = iconregister.registerIcon("nanotechmod:" + getUnlocalizedName().substring(5));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == NanotechItem.nanomiteLeggings.itemID)
		{
			return "nanotechmod:textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "nanotechmod:textures/armor/Nanomitearmor.png";
		}
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().itemID == NanotechItem.itemBase.itemID && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}