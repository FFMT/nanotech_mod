package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemNanomiteShovel extends ItemSpade
{
	public ItemNanomiteShovel(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
	}

	public void registerIcons(IIconRegister iiconregister)
	{
		itemIcon = iiconregister.registerIcon("nanotechmod:nanomiteShovel");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == NanotechItem.itemBase && repairItem.getItemDamage() == 14)
			return true;
		return false;
	}
}