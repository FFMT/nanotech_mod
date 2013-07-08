package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;

public class UltimateCircuit extends Item
{

	public UltimateCircuit(int par1) 
	{
		super(par1);
		this.setCreativeTab(UltimateGraviSuite.ic2Tab);
	}
    
    public void registerIcons(IconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateCircuit");
    }

}
