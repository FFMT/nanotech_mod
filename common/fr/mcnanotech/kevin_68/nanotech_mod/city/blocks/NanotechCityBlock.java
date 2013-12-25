package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;

public class NanotechCityBlock
{
	// Blocks statement
	public static Block trashcan, spotLight, trail, fountain, lamp, sunShade, modernFence, textSpotLight;

	// Blocks Initialization
	public static void initBlock()
	{
		trashcan = new BlockTrashcan(Nanotech_mod_City.trashcanID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("trashcan").setCreativeTab(Nanotech_mod_City.cityTab);
		spotLight = new BlockSpotLight(Nanotech_mod_City.spotLightID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("spotlight").setCreativeTab(Nanotech_mod_City.cityTab);
		trail = new BlockTrail(Nanotech_mod_City.trailID, Material.ground).setHardness(1.0F).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("trail").setStepSound(Block.soundGravelFootstep).setCreativeTab(Nanotech_mod_City.cityTab);
		fountain = new BlockFountain(Nanotech_mod_City.fountainID).setUnlocalizedName("fountain").setCreativeTab(Nanotech_mod_City.cityTab);
		lamp = new BlockLamp(Nanotech_mod_City.lampID, Material.iron).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("lamp").setCreativeTab(Nanotech_mod_City.cityTab);
		sunShade = new BlockSunShade(Nanotech_mod_City.sunShadeID, Material.wood).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("sunShade").setCreativeTab(Nanotech_mod_City.cityTab);
		modernFence = new BlockModernFence(Nanotech_mod_City.modernFenceID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("modernFence").setCreativeTab(Nanotech_mod_City.cityTab);
		textSpotLight = new BlockTextSpotLight(Nanotech_mod_City.textSpotLightID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("textSpotLight").setCreativeTab(Nanotech_mod_City.cityTab);
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(trashcan, "BlockTrashcan");
		GameRegistry.registerBlock(spotLight, "BlockSpotLight");
		GameRegistry.registerBlock(trail, "BlockTrail");
		GameRegistry.registerBlock(fountain, "blockFountain");
		GameRegistry.registerBlock(lamp, ItemBlockLamp.class, "BlockLamp", "Nanotech_mod_City");
		GameRegistry.registerBlock(sunShade, ItemBlockSunShade.class, "BlockSunShade", "Nanotech_mod_City");
		GameRegistry.registerBlock(modernFence, ItemBlockModernFence.class, "blockModernFence", "Nanotech_mod_City");
		GameRegistry.registerBlock(textSpotLight, "BlockTextSpotLight");
	}
}