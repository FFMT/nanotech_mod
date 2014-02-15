package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemNanomiteHoe extends ItemHoe
{
	public ItemNanomiteHoe(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
	}

	public void registerIcons(IIconRegister iiconregister)
	{
		itemIcon = iiconregister.registerIcon("nanotechmod:nanomiteHoe");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == NanotechItem.itemBase && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}