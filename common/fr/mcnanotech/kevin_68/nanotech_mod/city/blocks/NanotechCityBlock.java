package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.Nanotech_mod_City;

public class NanotechCityBlock
{
	// Blocks statement
	public static Block BlockTrashcan, BlockSpotLight, BlockTrail, BlockFountain, BlockLamp, BlockSunShade, BlockModernFence;

	// Blocks Initialization
	public static void initBlock()
	{
		BlockTrashcan = new BlockTrashcan(Nanotech_mod_City.BlockTrashcanID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("trashcan").setCreativeTab(Nanotech_mod_City.cityTab);
		BlockSpotLight = new BlockSpotLight(Nanotech_mod_City.BlockSpotLightID).setHardness(1.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("spotlight").setCreativeTab(Nanotech_mod_City.cityTab);
		BlockTrail = new BlockTrail(Nanotech_mod_City.BlockTrailID, Material.ground).setHardness(1.0F).setResistance(1.0F).setUnlocalizedName("trail").setStepSound(Block.soundGravelFootstep).setCreativeTab(Nanotech_mod_City.cityTab);
		BlockFountain = new BlockFountain(Nanotech_mod_City.BlockFountainID).setUnlocalizedName("fountain").setCreativeTab(Nanotech_mod_City.cityTab);
		BlockLamp = new BlockLamp(Nanotech_mod_City.BlockLampID, Material.iron).setHardness(3.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("lamp").setCreativeTab(Nanotech_mod_City.cityTab);
		BlockSunShade = new BlockSunShade(Nanotech_mod_City.BlockSunShadeID, Material.wood).setHardness(2.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("sunShade").setCreativeTab(Nanotech_mod_City.cityTab);
		BlockModernFence = new BlockModernFence(Nanotech_mod_City.BlockModernFenceID).setHardness(1.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("modernFence").setCreativeTab(Nanotech_mod_City.cityTab);
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(BlockTrashcan, "BlockTrashcan");
		GameRegistry.registerBlock(BlockSpotLight, "BlockSpotLight");
		GameRegistry.registerBlock(BlockTrail, "BlockTrail");
		GameRegistry.registerBlock(BlockFountain, "blockFountain");
		GameRegistry.registerBlock(BlockLamp, ItemBlockLamp.class, "BlockLamp", "Nanotech_mod_City");
		GameRegistry.registerBlock(BlockSunShade, ItemBlockSunShade.class, "BlockSunShade", "Nanotech_mod_City");
		GameRegistry.registerBlock(BlockModernFence, ItemBlockModernFence.class, "blockModernFence", "Nanotech_mod_City");
	}
}