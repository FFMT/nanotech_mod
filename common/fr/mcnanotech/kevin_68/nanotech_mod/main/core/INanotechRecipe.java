package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class INanotechRecipe implements IRecipe
{
	public ItemStack newStack;
	
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world)
	{
		ItemStack stack = null;
		ItemStack nStack = null;
		for(int i = 0; i < inventorycrafting.getSizeInventory(); i++)
		{
			ItemStack stack1 = inventorycrafting.getStackInSlot(i);
			if(stack1 != null)
			{
				if(stack1.itemID == NanotechItem.itemBase.itemID && stack1.getItemDamage() == 21 && stack == null)
				{
					stack = stack1;
				}
				else
				{
					if(nStack == null)
					{
						nStack = stack1;
					}
					else
					{
						return false;
					}
				}
			}
		}
		
		if(stack != null && nStack != null)
		{
			newStack = new ItemStack(NanotechBlock.present, 1, 0);
			NBTTagCompound nbtTag = new NBTTagCompound();
			nbtTag.setInteger("presentId", nStack.itemID);
			nbtTag.setInteger("presentMeta", stack.getItemDamage());
			newStack.setTagCompound(nbtTag);
			return true;
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
	{
		return newStack.copy();
	}

	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		return newStack;
	}
}