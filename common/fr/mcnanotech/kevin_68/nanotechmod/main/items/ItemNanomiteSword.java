package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemNanomiteSword extends ItemSword
{
	public ItemNanomiteSword(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
	}

	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:nanomiteSword");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == NanotechItem.itemBase && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}