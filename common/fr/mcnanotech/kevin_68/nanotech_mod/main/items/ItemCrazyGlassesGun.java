package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemCrazyGlassesGun extends ItemBow
{
	public ItemCrazyGlassesGun(int id)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(300000);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:crazyglassescannon");
	}

	public ItemStack onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(NanotechItem.itemBase, 1, 20)))
			{
				EntityItem glasses = new EntityItem(world);
				glasses.delayBeforeCanPickup = 5;
				glasses.setEntityItemStack(new ItemStack(NanotechItem.crazyGlasses, 1, 0));
				glasses.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
				glasses.posX -= (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
				glasses.posY -= 0.10000000149011612D;
				glasses.posZ -= (double)(MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
				glasses.setPosition(glasses.posX, glasses.posY, glasses.posZ);
				glasses.yOffset = 0.0F;
				glasses.motionX = (double)(-MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
				glasses.motionZ = (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
				glasses.motionY = (double)(-MathHelper.sin(glasses.rotationPitch / 180.0F * (float)Math.PI));
				world.spawnEntityInWorld(glasses);

				EntityItem iron = new EntityItem(world);
				iron.delayBeforeCanPickup = 5;
				iron.setEntityItemStack(new ItemStack(Item.ingotIron, 2, 0));
				iron.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
				iron.posX -= (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
				iron.posY -= 0.10000000149011612D;
				iron.posZ -= (double)(MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
				iron.setPosition(glasses.posX, glasses.posY, glasses.posZ);
				iron.yOffset = 0.0F;
				iron.motionX = (double)(-MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
				iron.motionZ = (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
				iron.motionY = (double)(-MathHelper.sin(glasses.rotationPitch / 180.0F * (float)Math.PI));
				world.spawnEntityInWorld(iron);

				if(!player.capabilities.isCreativeMode)
				{
					for(int j = 0; j < player.inventory.mainInventory.length; ++j)
					{
						if(player.inventory.mainInventory[j] != null && player.inventory.mainInventory[j].itemID == NanotechItem.itemBase.itemID && player.inventory.mainInventory[j].getItemDamage() == 20)
						{
							if(--player.inventory.mainInventory[j].stackSize <= 0)
							{
								player.inventory.mainInventory[j] = null;
							}
						}
					}
				}
			}
		}
		return stack;
	}

	public int getItemEnchantability()
	{
		return 1;
	}
}