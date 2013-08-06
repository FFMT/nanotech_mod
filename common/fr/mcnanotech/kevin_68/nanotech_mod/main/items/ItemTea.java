package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemTea extends Item
{

	public ItemTea(int id) 
	{
		super(id);
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("Nanotech_mod:tea");
	}

}
