package fr.mcnanotech.kevin_68.nanotech_mod.city.items;

import net.minecraft.item.Item;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;

public class NanotechCityItem 
{
	public static Item lamp, sunShade;

	public static void initItem()
	{
		lamp = new ItemLamp(Nanotech_mod_City.ItemLampID).setUnlocalizedName("lamp").setCreativeTab(Nanotech_mod_City.CREATIVE_TAB_C).func_111206_d("nanotech_mod_city:lamp");
		sunShade = new ItemSunShade(Nanotech_mod_City.ItemSunShadeID).setUnlocalizedName("sunShade").setCreativeTab(Nanotech_mod_City.CREATIVE_TAB_C).func_111206_d("nanotech_mod_city:sunShade");
	}
}