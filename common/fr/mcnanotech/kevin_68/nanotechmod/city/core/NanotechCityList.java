/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class NanotechCityList
{
	public static final Block trashcan = GameRegistry.findBlock(NanotechModCity.MODID, "trashcan");
	public static final Block spotLight = GameRegistry.findBlock(NanotechModCity.MODID, "spotlight");
	public static final Block trail = GameRegistry.findBlock(NanotechModCity.MODID, "trail");
	public static final Block fountain = GameRegistry.findBlock(NanotechModCity.MODID, "fountain");
	public static final Block lamp = GameRegistry.findBlock(NanotechModCity.MODID, "lamp");
	public static final Block sunShade = GameRegistry.findBlock(NanotechModCity.MODID, "sunShade");
	public static final Block modernFence = GameRegistry.findBlock(NanotechModCity.MODID, "modernFence");
	public static final Block textSpotLight = GameRegistry.findBlock(NanotechModCity.MODID, "textSpotLight");

	public static final Item configCopier = GameRegistry.findItem(NanotechModCity.MODID, "configCopier");
	
}
