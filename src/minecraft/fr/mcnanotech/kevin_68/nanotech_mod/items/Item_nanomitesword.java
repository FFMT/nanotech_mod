package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class Item_nanomitesword extends ItemSword
{
	public Item_nanomitesword(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}
}