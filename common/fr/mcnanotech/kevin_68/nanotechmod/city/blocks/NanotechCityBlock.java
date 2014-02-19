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

	public static void initBlock()
	{
		GameRegistry.registerBlock(new BlockTrashcan().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("trashcan").setCreativeTab(NanotechModCity.cityTab), ItemBlock.class, "trashcan", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockSpotLight().setBlockTextureName(NanotechModCity.MODID + ":spotlight").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("spotlight").setCreativeTab(NanotechModCity.cityTab), ItemBlock.class, "spotlight", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockTrail().setHardness(1.0F).setResistance(10.0F).setBlockName("trail").setStepSound(Block.soundTypeGravel).setCreativeTab(NanotechModCity.cityTab), ItemBlock.class, "trail", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockFountain().setHardness(1.5F).setResistance(10.0F).setBlockName("fountain").setCreativeTab(NanotechModCity.cityTab), ItemBlock.class, "fountain", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockLamp().setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("lamp").setCreativeTab(NanotechModCity.cityTab), ItemBlockLamp.class, "lamp", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockSunShade().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setBlockName("sunShade").setCreativeTab(NanotechModCity.cityTab), ItemBlockSunShade.class, "sunShade", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockModernFence().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("modernFence").setCreativeTab(NanotechModCity.cityTab), ItemBlockModernFence.class, "modernFence", NanotechModCity.MODID);
		GameRegistry.registerBlock(new BlockTextSpotLight().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("textSpotLight").setCreativeTab(NanotechModCity.cityTab), ItemBlock.class, "textSpotLight", NanotechModCity.MODID);
	}
}