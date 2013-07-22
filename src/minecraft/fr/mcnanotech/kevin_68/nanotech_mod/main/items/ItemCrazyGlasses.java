package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import ic2.api.item.ElectricItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items.ItemCrazyGlassesModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

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
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 50, true));
	}
}