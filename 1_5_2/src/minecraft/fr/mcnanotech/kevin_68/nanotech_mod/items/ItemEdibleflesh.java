package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.item.ItemFood;

public class ItemEdibleflesh extends ItemFood
{

	public ItemEdibleflesh(int id, int healAmount, float saturation, boolean wolf)
	{
		super(id, healAmount, saturation, wolf);
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}

}
