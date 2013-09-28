package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemNanoFood extends ItemFood
{

	public ItemNanoFood(int id, int healAmount, float saturation, boolean wolf)
	{
		super(id, healAmount, saturation, wolf);
	}

	public ItemNanoFood(int id, int healAmount, float saturation, boolean wolf, int pID, int pDuration, int pAmplifier, float pProb)
	{
		super(id, healAmount, saturation, wolf);
		this.setPotionEffect(pID, pDuration, pAmplifier, pProb);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:" + getUnlocalizedName().substring(5));
	}

}
