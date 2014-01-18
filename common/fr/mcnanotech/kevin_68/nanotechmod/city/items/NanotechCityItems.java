package fr.mcnanotech.kevin_68.nanotechmod.city.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import net.minecraft.item.Item;

public class NanotechCityItems
{
	public static Item configCopy;
	
	public static void initItems()
	{
		configCopy = new ItemConfigCopy(NanotechModCity.configCopyID).setUnlocalizedName("configCopier").setCreativeTab(NanotechModCity.cityTab);
	}

	public static void registerItem()
	{
		GameRegistry.registerItem(configCopy, "configCopier", "NanotechModCity");
	}
}