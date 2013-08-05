package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySuperBottleOfXp;

public class ItemSuperbottleofxp extends Item
{
	public ItemSuperbottleofxp(int id)
	{
		super(id);
		this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("expBottle");
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!player.isSneaking())
		{
			if(!player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}

			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if(!world.isRemote)
			{
				world.spawnEntityInWorld(new EntitySuperBottleOfXp(world, player));
			}
		}
		return stack;
	}
}
