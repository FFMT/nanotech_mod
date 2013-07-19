package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemEdibleflesh extends ItemFood
{

	public ItemEdibleflesh(int id, int healAmount, float saturation, boolean wolf)
	{
		super(id, healAmount, saturation, wolf);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("Nanotech_mod:" + getUnlocalizedName().substring(5));
	}

}
