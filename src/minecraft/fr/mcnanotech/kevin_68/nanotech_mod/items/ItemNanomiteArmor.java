package fr.mcnanotech.kevin_68.nanotech_mod.items;

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
        itemIcon = iconregister.registerIcon("Nanotech_mod:"+getUnlocalizedName().substring(5));
    }

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if (stack.itemID == NanotechItem.Nanomiteleggings.itemID)
		{
			return "/mods/Nanotech_mod/textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "/mods/Nanotech_mod/textures/armor/Nanomitearmor.png";
		}
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return true;
	}
}