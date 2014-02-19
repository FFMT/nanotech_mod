/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;

public class NanotechCityItems
{
	public static Item configCopier;

	public static void initItems()
	{
		configCopier = new ItemConfigCopy().setUnlocalizedName("configCopier").setCreativeTab(NanotechModCity.cityTab);
		GameRegistry.registerItem(configCopier, "configCopier", "NanotechModCity");
	}
}