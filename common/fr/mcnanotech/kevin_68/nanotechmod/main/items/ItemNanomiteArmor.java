package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemNanomiteArmor extends ItemArmor
{
	public ItemNanomiteArmor(ArmorMaterial armormaterial, int slot, int layer)
	{
		super(armormaterial, slot, layer);
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:" + getUnlocalizedName().substring(5));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.getItem().equals(NanotechItem.nanomiteLeggings))
		{
			return "nanotechmod:textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "nanotechmod:textures/armor/Nanomitearmor.png";
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().equals(NanotechItem.itemBase) && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}