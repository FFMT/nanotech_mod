package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.core.IC2;
import net.minecraft.item.ItemArmor;

public class UltimateArmor extends ItemArmor
{
	public UltimateArmor(ArmorMaterial armorMaterial, int slot)
	{
		super(armorMaterial, 0, slot);
		this.setCreativeTab(IC2.tabIC2);
	}
}