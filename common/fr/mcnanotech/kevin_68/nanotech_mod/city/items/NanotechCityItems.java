package fr.mcnanotech.kevin_68.nanotech_mod.city.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;
import net.minecraft.item.Item;

public class NanotechCityItems
{
	public static Item configCopy;
	
	public static void initItems()
	{
		configCopy = new ItemConfigCopy(Nanotech_mod_City.configCopyID).setUnlocalizedName("configCopy").setCreativeTab(Nanotech_mod_City.cityTab);
	}

	public static void registerItem()
	{
		GameRegistry.registerItem(configCopy, "configCopy", "Nanotech_mod_City");
	}
}