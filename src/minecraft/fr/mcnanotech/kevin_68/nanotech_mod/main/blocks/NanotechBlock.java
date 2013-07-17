package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechBlock
{
	// Blocks statement
	public static Block BlockPortal, BlockPortalframe, BlockGrass,
			BlockFakeOre, BlockSpeed, BlockJumper, BlockMultiplier,
			BlockSmoker, BlockTrashcan, BlockBarbedwire, BlockNanowood,
			BlockNanoleaves, BlockNanosaplings, BlockNanoplanks, BlockNanoOre,
			BlockConfusion, BlockFalling, Blocknotfalling, BlockSodium,
			BlockSlope, BlockMossystone, BlockSpotLight;

	// Blocks Initialization
	public static void initBlock()
	{
		BlockPortal = new BlockNanoPortal(Nanotech_mod.BlockPortalID).setBlockUnbreakable().setUnlocalizedName("portal");
		BlockPortalframe = new BlockPortalFrame(Nanotech_mod.BlockPortalFrameID, Material.rock).setResistance(5F).setHardness(2F).setUnlocalizedName("portalframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockGrass = new BlockGrass(Nanotech_mod.BlockGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanograss").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFakeOre = new BlockFakeOre(Nanotech_mod.BlockFakeOreID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("fakediamond").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSpeed = new BlockSpeed(Nanotech_mod.BlockSpeedID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("speed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockJumper = new BlockJumper(Nanotech_mod.BlockJumperID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("jumper").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMultiplier = new BlockMultiplier(Nanotech_mod.BlockMultiplierID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("multiplier").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSmoker = new BlockSmoker(Nanotech_mod.BlockSmokerID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoker").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockTrashcan = new BlockTrashcan(Nanotech_mod.BlockTrashcanID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("trashcan").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockBarbedwire = new BlockBarbedWire(Nanotech_mod.BlockBarbedWireID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("barbedwire").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanowood = new BlockNanoWood(Nanotech_mod.BlockNanoWoodID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanowood").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoleaves = new BlockNanoLeaves(Nanotech_mod.BlockNanoLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanoleaves").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanosaplings = new BlockNanoSaplings(Nanotech_mod.BlockNanoSaplingsID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanosaplings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoplanks = new BlockNanoPlanks(Nanotech_mod.BlockNanoPlanksID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanoplanks").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockNanoOre = new BlockNanotechOre(Nanotech_mod.BlockNanoOreID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ore");
		BlockConfusion = new BlockConfusion(Nanotech_mod.BlockConfusionID).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("confusion").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockFalling = new BlockFalling(Nanotech_mod.BlockFallingID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("falling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		Blocknotfalling = new BlockNotFalling(Nanotech_mod.BlockNotFallingID, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("notfalling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSodium = new BlockSodium(Nanotech_mod.BlockSodiumID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sodium").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockMossystone = new BlockBase(Nanotech_mod.BlockMossyStoneID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mossystone").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		BlockSpotLight = new BlockSpotLight(Nanotech_mod.BlockSpotLightID).setHardness(1.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("spotlight").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(BlockPortal, "BlockPortal");
		GameRegistry.registerBlock(BlockPortalframe, "BlockPortalframe");
		GameRegistry.registerBlock(BlockGrass, "BlockGrass");
		GameRegistry.registerBlock(BlockFakeOre, ItemBlockFakeOre.class, "BlockFakeOre", "Nanotech_mod");
		GameRegistry.registerBlock(BlockSpeed, ItemBlockSpeed.class, "BlockSpeed", "Nanotech_mod");
		GameRegistry.registerBlock(BlockJumper, ItemBlockJumper.class, "BlockJumper", "Nanotech_mod");
		GameRegistry.registerBlock(BlockMultiplier, "BlockMultiplier");
		GameRegistry.registerBlock(BlockSmoker, "BlockSmoker");
		GameRegistry.registerBlock(BlockTrashcan, "BlockTrashcan");
		GameRegistry.registerBlock(BlockBarbedwire, "BlockBarbedwire");
		GameRegistry.registerBlock(BlockNanowood, "BlockNanowood");
		GameRegistry.registerBlock(BlockNanoleaves, "BlockNanoleaves");
		GameRegistry.registerBlock(BlockNanosaplings, "BlockNanosaplings");
		GameRegistry.registerBlock(BlockNanoplanks, "BlockNanoplanks");
		GameRegistry.registerBlock(BlockNanoOre, ItemBlockNanotechOre.class, "BlockNanoOre", "Nanotech_mod");
		GameRegistry.registerBlock(BlockConfusion, "BlockConfusion");
		GameRegistry.registerBlock(BlockFalling, ItemBlockFalling.class, "BlockFalling", "Nanotech_mod");
		GameRegistry.registerBlock(Blocknotfalling, ItemBlockNotFalling.class, "Blocknotfalling", "Nanotech_mod");
		GameRegistry.registerBlock(BlockSodium, "BlockSodium");
		GameRegistry.registerBlock(BlockMossystone, "BlockMossyStone");
		GameRegistry.registerBlock(BlockSpotLight, "BlockSpotLight");
	}

}
