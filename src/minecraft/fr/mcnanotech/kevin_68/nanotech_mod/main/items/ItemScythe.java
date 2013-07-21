package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemScythe extends Item
{

	public ItemScythe(int par1) 
	{
		super(par1);
	}
	
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("Nanotech_mod:itemScythe");
	}

}
