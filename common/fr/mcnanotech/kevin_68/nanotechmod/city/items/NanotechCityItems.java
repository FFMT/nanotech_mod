package fr.mcnanotech.kevin_68.nanotechmod.city.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import net.minecraft.item.Item;

public class NanotechCityItems
{
	public static void initItems()
	{
		GameRegistry.registerItem(new ItemConfigCopy().setUnlocalizedName("configCopier").setCreativeTab(NanotechModCity.cityTab), "configCopier", "NanotechModCity");
	}
}