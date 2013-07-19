package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

;

public interface IItemTickListener
{
	boolean onTick(EntityPlayer var1, ItemStack var2);
}
