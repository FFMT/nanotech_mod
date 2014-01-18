package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;

public class NanotechCityBlock
{
	// Blocks statement
	public static Block trashcan, spotLight, trail, fountain, lamp, sunShade, modernFence, textSpotLight;

	// Blocks Initialization
	public static void initBlock()
	{
		trashcan = new BlockTrashcan(NanotechModCity.trashcanID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("trashcan").setCreativeTab(NanotechModCity.cityTab);
		spotLight = new BlockSpotLight(NanotechModCity.spotLightID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("spotlight").setCreativeTab(NanotechModCity.cityTab);
		trail = new BlockTrail(NanotechModCity.trailID, Material.ground).setHardness(1.0F).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("trail").setStepSound(Block.soundGravelFootstep).setCreativeTab(NanotechModCity.cityTab);
		fountain = new BlockFountain(NanotechModCity.fountainID).setUnlocalizedName("fountain").setCreativeTab(NanotechModCity.cityTab);
		lamp = new BlockLamp(NanotechModCity.lampID, Material.iron).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("lamp").setCreativeTab(NanotechModCity.cityTab);
		sunShade = new BlockSunShade(NanotechModCity.sunShadeID, Material.wood).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("sunShade").setCreativeTab(NanotechModCity.cityTab);
		modernFence = new BlockModernFence(NanotechModCity.modernFenceID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("modernFence").setCreativeTab(NanotechModCity.cityTab);
		textSpotLight = new BlockTextSpotLight(NanotechModCity.textSpotLightID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("textSpotLight").setCreativeTab(NanotechModCity.cityTab);
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(trashcan, "BlockTrashcan");
		GameRegistry.registerBlock(spotLight, "BlockSpotLight");
		GameRegistry.registerBlock(trail, "BlockTrail");
		GameRegistry.registerBlock(fountain, "blockFountain");
		GameRegistry.registerBlock(lamp, ItemBlockLamp.class, "BlockLamp", "NanotechModCity");
		GameRegistry.registerBlock(sunShade, ItemBlockSunShade.class, "BlockSunShade", "NanotechModCity");
		GameRegistry.registerBlock(modernFence, ItemBlockModernFence.class, "blockModernFence", "NanotechModCity");
		GameRegistry.registerBlock(textSpotLight, "BlockTextSpotLight");
	}
}