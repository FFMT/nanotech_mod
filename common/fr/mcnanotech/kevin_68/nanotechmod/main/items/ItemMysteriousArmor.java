package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMysteriousArmor extends ItemArmor
{
	public ItemMysteriousArmor(int id, EnumArmorMaterial enumArmorMaterial, int slot, int layer)
	{
		super(id, enumArmorMaterial, slot, layer);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:" + getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == NanotechItem.mysteriousLeggings.itemID)
		{
			return "nanotechmod:textures/armor/Mysteriousarmor2.png";
		}
		else
		{
			return "nanotechmod:textures/armor/Mysteriousarmor.png";
		}
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
	{
		return true;
	}
}