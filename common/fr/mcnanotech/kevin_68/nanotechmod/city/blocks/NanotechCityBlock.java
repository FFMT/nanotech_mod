/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;

public class NanotechCityBlock
{
	public static Block trashcan, spotlight, fountain, lamp, sunShade, modernFence, textSpotlight;
	public static BlockTrail trail;
	
	public static void initBlock()
	{
		trashcan = new BlockTrashcan().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("trashcan").setCreativeTab(NanotechModCity.cityTab);
		spotlight = new BlockSpotLight().setBlockTextureName(NanotechModCity.MODID + ":spotlight").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("spotlight").setCreativeTab(NanotechModCity.cityTab);
		trail = (BlockTrail)new BlockTrail().setHardness(1.0F).setResistance(10.0F).setBlockName("trail").setStepSound(Block.soundTypeGravel).setCreativeTab(NanotechModCity.cityTab);
		fountain = new BlockFountain().setHardness(1.5F).setResistance(10.0F).setBlockName("fountain").setCreativeTab(NanotechModCity.cityTab);
		lamp = new BlockLamp().setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("lamp").setCreativeTab(NanotechModCity.cityTab);
		sunShade = new BlockSunShade().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setBlockName("sunShade").setCreativeTab(NanotechModCity.cityTab);
		modernFence = new BlockModernFence().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("modernFence").setCreativeTab(NanotechModCity.cityTab);
		textSpotlight = new BlockTextSpotLight().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("textSpotLight").setCreativeTab(NanotechModCity.cityTab);

		GameRegistry.registerBlock(trashcan, ItemBlock.class, "trashcan", NanotechModCity.MODID);
		GameRegistry.registerBlock(spotlight, ItemBlock.class, "spotlight", NanotechModCity.MODID);
		GameRegistry.registerBlock(trail, ItemBlock.class, "trail", NanotechModCity.MODID);
		GameRegistry.registerBlock(fountain, ItemBlock.class, "fountain", NanotechModCity.MODID);
		GameRegistry.registerBlock(lamp, ItemBlockLamp.class, "lamp", NanotechModCity.MODID);
		GameRegistry.registerBlock(sunShade, ItemBlockSunShade.class, "sunShade", NanotechModCity.MODID);
		GameRegistry.registerBlock(modernFence, ItemBlockModernFence.class, "modernFence", NanotechModCity.MODID);
		GameRegistry.registerBlock(textSpotlight, ItemBlock.class, "textSpotLight", NanotechModCity.MODID);
	}
}