package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityReinforcedFishingHook;

public class ItemReinforcedFishingRod extends ItemFishingRod
{
	private IIcon theIcon;

	public ItemReinforcedFishingRod()
	{
		super();
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

	public void registerIcons(IIconRegister iiconRegister)
	{
		this.itemIcon = iiconRegister.registerIcon(this.getIconString() + "_uncast");
		this.theIcon = iiconRegister.registerIcon(this.getIconString() + "_cast");
	}

	@Override
	public IIcon getIcon(ItemStack stack, int multiPassRender)
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