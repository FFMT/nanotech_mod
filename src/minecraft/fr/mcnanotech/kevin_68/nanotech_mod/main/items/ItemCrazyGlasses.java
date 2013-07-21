package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items.ItemCrazyGlassesModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCrazyGlasses extends ItemArmor
{

	public ItemCrazyGlasses(int par1, EnumArmorMaterial material, int renderIndex, int armorType) 
	{
		super(par1, material, renderIndex, armorType);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("Nanotech_mod:crazyGlassesItem");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == NanotechItem.crazyGlasses.itemID)
		return "/mods/Nanotech_mod/textures/armor/crazyGlasses.png";
		
		return "/mods/Nanotech_mod/textures/block/empty.png";
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLiving entityliving, ItemStack stack, int armor)
	{
		return new ItemCrazyGlassesModel();
	}


}
