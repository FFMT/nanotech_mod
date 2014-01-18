package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items.ItemCrazyGlassesModel;

public class ItemCrazyGlasses extends ItemArmor
{

	public ItemCrazyGlasses(int par1, EnumArmorMaterial material, int renderIndex, int armorType)
	{
		super(par1, material, renderIndex, armorType);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:crazyGlassesItem");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == NanotechItem.crazyGlasses.itemID)
			return "nanotechmod:textures/armor/crazyGlasses.png";

		return "nanotechmod:textures/block/empty.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityliving, ItemStack stack, int armor)
	{
		return new ItemCrazyGlassesModel();
	}

	private int tick = 40;

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		if(!world.isRemote)
		{
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 50, true));
			if(tick > 56)
			{
				float randPitch = -5.0F + world.rand.nextFloat() * 10;
				world.playSoundAtEntity(player, "nanotechmod:CrazyGuy", 30.0F, randPitch);
				tick = 0 + (int)(randPitch * 13.0F);
			}
			else
			{
				tick++;
			}
		}
	}
}