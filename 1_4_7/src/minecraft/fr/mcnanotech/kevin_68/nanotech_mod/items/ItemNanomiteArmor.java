package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemNanomiteArmor extends ItemArmor implements IArmorTextureProvider
{
	public ItemNanomiteArmor(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(id, par2EnumArmorMaterial, par3, par4);
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}

	public String getArmorTextureFile(ItemStack stack)
	{
		if (stack.itemID == NanotechItem.Nanomiteleggings.itemID)
		{
			return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor2.png";
		}
		else
		{
			return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor.png";
		}
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return true;
	}
}