package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;

public class ItemReinforcedFishingRod extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon theIcon;
	private boolean isFishing = false;

	public ItemReinforcedFishingRod(int par1)
	{
		super(par1);
		this.setMaxDamage(64);
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering()
	{
		return true;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(par3EntityPlayer.fishEntity != null)
		{
			int i = par3EntityPlayer.fishEntity.catchFish();
			par1ItemStack.damageItem(i, par3EntityPlayer);
			par3EntityPlayer.swingItem();
			isFishing = true;
		}
		else
		{
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if(!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(new EntityReinforcedFishingHook(par2World, par3EntityPlayer));
			}
			isFishing = false;
			par3EntityPlayer.swingItem();
		}

		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(this.getIconString() + "_uncast");
		this.theIcon = par1IconRegister.registerIcon(this.getIconString() + "_cast");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(ItemStack stack, int multiPassRender)
	{
		if(isFishing)
		{
			return itemIcon;
		}
		else
		{
			return theIcon;
		}
	}
}
