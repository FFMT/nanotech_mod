package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemNanomiteAxe extends ItemAxe
{

	public ItemNanomiteAxe(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotechmod:nanomiteAxe");
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().equals(NanotechItem.itemBase) && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}