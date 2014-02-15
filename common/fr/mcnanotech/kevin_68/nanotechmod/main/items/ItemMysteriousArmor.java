package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMysteriousArmor extends ItemArmor
{
	public ItemMysteriousArmor(ArmorMaterial enumArmorMaterial, int slot, int layer)
	{
		super(enumArmorMaterial, slot, layer);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:" + getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.getItem().equals(NanotechItem.mysteriousLeggings))
		{
			return "nanotechmod:textures/armor/Mysteriousarmor2.png";
		}
		else
		{
			return "nanotechmod:textures/armor/Mysteriousarmor.png";
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
	{
		return true;
	}
}