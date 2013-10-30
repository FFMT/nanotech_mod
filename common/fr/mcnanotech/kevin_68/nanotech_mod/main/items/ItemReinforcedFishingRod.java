package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;

public class ItemReinforcedFishingRod extends ItemFishingRod
{
	private Icon theIcon;

	public ItemReinforcedFishingRod(int id)
	{
		super(id);
		this.setMaxDamage(128);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(player.fishEntity != null)
		{
			int i = player.fishEntity.catchFish();
			stack.damageItem(i, player);
			player.swingItem();
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound tag = stack.getTagCompound();
			tag.setBoolean("using", false);
		}
		else
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if(!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityReinforcedFishingHook(world, player));
			}
			if(!stack.hasTagCompound())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound tag = stack.getTagCompound();
			tag.setBoolean("using", true);
			player.swingItem();
		}
		return stack;
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(this.getIconString() + "_uncast");
		this.theIcon = par1IconRegister.registerIcon(this.getIconString() + "_cast");
	}

	@Override
	public Icon getIcon(ItemStack stack, int multiPassRender)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tag = stack.getTagCompound();

		if(tag.hasKey("using"))
		{
			boolean using = tag.getBoolean("using");
			if(!using)
			{
				return itemIcon;
			}
		}
		return theIcon;
	}
}