package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NanotechBlock
{
	/*
	 * Block statement
	 */
	public static Block BlockPortal, BlockPortalframe, BlockGrass, BlockFakeOre;
	public static Block BlockSpeed;
	public static Block BlockJumper;
	public static Block BlockMultiplier;
	public static Block BlockSmoker;
	public static Block BlockTrashcan;
	public static Block BlockBarbedwire;
	public static Block BlockNanowood;
	public static Block BlockNanoleaves;
	public static Block BlockNanosaplings;
	public static Block BlockNanoplanks;
	public static Block BlockNanoOre;
	public static Block BlockConfusion;
	public static Block BlockFalling;
	public static Block Blocknotfalling;
	public static Block BlockSodium;
	public static Block BlockSlope;
	public static Block BlockMossystone;
	
	/*
	 * Initialization of Blocks
	 */
	public static void initBlock()
	{
		BlockPortal = new BlockNanoportal(Nanotech_mod.Block_portalID, 2).setBlockUnbreakable().setBlockName("portal");
		BlockPortalframe = new Blockbase(Nanotech_mod.Block_portalframeID, 3, Material.rock).setResistance(5F).setHardness(2F).setBlockName("portalframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockGrass = new BlockGrass(Nanotech_mod.Block_grassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setBlockName("nanograss").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFakeOre = new BlockFakeOre(Nanotech_mod.Block_fakeOreID).setHardness(3.0F).setResistance(5F).setBlockName("fakediamond").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSpeed = new BlockSpeed(Nanotech_mod.Block_speedID, 4).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("speed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockJumper = new BlockJumper(Nanotech_mod.Block_jumperID, 5).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("jumper").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMultiplier = new BlockMultiplier(Nanotech_mod.Block_multiplierID, 7).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("multiplier").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSmoker = new BlockSmoker(Nanotech_mod.Block_smokerID, 8).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("smoker").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockTrashcan = new BlockTrashcan(Nanotech_mod.Block_trashcanID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("trashcan").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B); 
		BlockBarbedwire = new BlockBarbedWire(Nanotech_mod.Block_barbedwireID, 16).setHardness(3.0F).setResistance(5F).setBlockName("barbedwire").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanowood = new BlockNanowood(Nanotech_mod.Block_nanowoodID).setHardness(1.0F).setResistance(5F).setBlockName("nanowood").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoleaves = new BlockNanoleaves(Nanotech_mod.Block_nanoleavesID, 13).setHardness(0.5F).setResistance(5F).setBlockName("nanoleaves").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanosaplings = new BlockNanosaplings(Nanotech_mod.Block_nanosaplingsID, 12).setHardness(0.0F).setResistance(5F).setBlockName("nanosaplings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoplanks = new BlockNanoplanks(Nanotech_mod.Block_nanoplanksID, 31).setHardness(1.0F).setResistance(5F).setBlockName("nanoplanks").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoOre = new BlockNanotechOre(Nanotech_mod.Block_nanoOreID, 38).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("ore");
		BlockConfusion = new BlockConfusion(Nanotech_mod.Block_confusionID, 40).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("confusion").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFalling = new BlockFalling(Nanotech_mod.Block_fallingID, 1, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("falling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		Blocknotfalling = new BlockNotFalling(Nanotech_mod.Block_notfallingID, 18, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("notfalling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSodium = new BlockSodium(Nanotech_mod.Block_sodiumID, 20, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("sodium").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMossystone = new Blockbase(Nanotech_mod.Block_mossystoneID, 17, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("mossystone").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
	}
	
	/*
	 * Block registry
	 */
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
		GameRegistry.registerBlock(BlockSodium, "Block_sodium");
		GameRegistry.registerBlock(BlockMossystone, "Block_mossystone");
	}

}
