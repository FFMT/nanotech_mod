package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


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
