package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class NanotechBlock
{
	// Blocks statement
	public static Block BlockPortal, BlockPortalframe, BlockGrass, BlockFakeOre, BlockSpeed, BlockJumper, 
	BlockMultiplier, BlockSmoker, BlockTrashcan, BlockBarbedwire, BlockNanowood, BlockNanoleaves, BlockNanosaplings, 
	BlockNanoplanks, BlockNanoOre, BlockConfusion, BlockFalling, Blocknotfalling, BlockSodium, BlockSlope, BlockMossystone;
	
	// Blocks Initialization
	public static void initBlock()
	{
		BlockPortal = new BlockNanoportal(Nanotech_mod.BlockPortalID, 2).setBlockUnbreakable().setBlockName("portal");
		BlockPortalframe = new Blockbase(Nanotech_mod.BlockPortalframeID, 3, Material.rock).setResistance(5F).setHardness(2F).setBlockName("portalframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockGrass = new BlockGrass(Nanotech_mod.BlockGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setBlockName("nanograss").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFakeOre = new BlockFakeOre(Nanotech_mod.BlockFakeOreID).setHardness(3.0F).setResistance(5F).setBlockName("fakediamond").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSpeed = new BlockSpeed(Nanotech_mod.BlockSpeedID, 4).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("speed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockJumper = new BlockJumper(Nanotech_mod.BlockJumperID, 5).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("jumper").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMultiplier = new BlockMultiplier(Nanotech_mod.BlockMultiplierID, 7).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("multiplier").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSmoker = new BlockSmoker(Nanotech_mod.BlockSmokerID, 8).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("smoker").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockTrashcan = new BlockTrashcan(Nanotech_mod.BlockTrashcanID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("trashcan").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B); 
		BlockBarbedwire = new BlockBarbedWire(Nanotech_mod.BlockBarbedwireID, 16).setHardness(3.0F).setResistance(5F).setBlockName("barbedwire").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanowood = new BlockNanowood(Nanotech_mod.BlockNanowoodID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setBlockName("nanowood").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoleaves = new BlockNanoleaves(Nanotech_mod.BlockNanoleavesID, 13).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("nanoleaves").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanosaplings = new BlockNanosaplings(Nanotech_mod.BlockNanosaplingsID, 12).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("nanosaplings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoplanks = new BlockNanoplanks(Nanotech_mod.BlockNanoplanksID, 31).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setBlockName("nanoplanks").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoOre = new BlockNanotechOre(Nanotech_mod.BlockNanoOreID, 38).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("ore");
		BlockConfusion = new BlockConfusion(Nanotech_mod.BlockConfusionID, 40).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("confusion").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFalling = new BlockFalling(Nanotech_mod.BlockFallingID, 1, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("falling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		Blocknotfalling = new BlockNotFalling(Nanotech_mod.BlockNotfallingID, 18, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("notfalling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSodium = new BlockSodium(Nanotech_mod.BlockSodiumID, 20, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("sodium").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMossystone = new Blockbase(Nanotech_mod.BlockMossystoneID, 17, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("mossystone").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
	}
	
	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(BlockPortal, "BlockPortal");
		GameRegistry.registerBlock(BlockPortalframe, "BlockPortalframe");
		GameRegistry.registerBlock(BlockGrass, "BlockGrass");
		GameRegistry.registerBlock(BlockFakeOre, ItemBlockFakeOre.class ,"BlockFakeOre");
		GameRegistry.registerBlock(BlockSpeed, ItemBlockSpeed.class, "BlockSpeed");
		GameRegistry.registerBlock(BlockJumper, "BlockJumper");
		GameRegistry.registerBlock(BlockMultiplier, "BlockMultiplier");
		GameRegistry.registerBlock(BlockSmoker, "BlockSmoker");
		GameRegistry.registerBlock(BlockTrashcan, "BlockTrashcan");
		GameRegistry.registerBlock(BlockBarbedwire, "BlockBarbedwire");
		GameRegistry.registerBlock(BlockNanowood, "BlockNanowood");
		GameRegistry.registerBlock(BlockNanoleaves, "BlockNanoleaves");
		GameRegistry.registerBlock(BlockNanosaplings, "BlockNanosaplings");
		GameRegistry.registerBlock(BlockNanoplanks, "BlockNanoplanks");
		GameRegistry.registerBlock(BlockNanoOre, ItemBlockNanotechOre.class, "BlockNanoOre");
		GameRegistry.registerBlock(BlockConfusion, "BlockConfusion");
		GameRegistry.registerBlock(BlockFalling, ItemBlockFalling.class, "BlockFalling");
		GameRegistry.registerBlock(Blocknotfalling, ItemBlockNotFalling.class, "Blocknotfalling");
		GameRegistry.registerBlock(BlockSodium, "BlockSodium");
		GameRegistry.registerBlock(BlockMossystone, "BlockMossyStone");
	}

}
