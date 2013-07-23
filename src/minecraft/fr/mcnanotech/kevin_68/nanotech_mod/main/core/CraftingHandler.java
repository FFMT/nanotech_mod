package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class CraftingHandler implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack stack, IInventory craftMatrix)
	{
		if (stack.itemID == NanotechBlock.BlockBarbedwire.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockConfusion.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockFalling.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockJumper.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockMossystone.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.Blocknotfalling.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockPortalframe.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockSmoker.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockSpeed.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockSpotLight.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockTheDeathHead.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockTrail.blockID)
		{
			
		}
		if (stack.itemID == NanotechBlock.BlockTrashcan.blockID)
		{
			
		}

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{

	}
}