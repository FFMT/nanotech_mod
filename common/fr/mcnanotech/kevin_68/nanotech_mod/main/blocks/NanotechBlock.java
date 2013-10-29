package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechBlock
{
	// Blocks statement
	public static Block portal, portalFrame, nanoGrass, fakeOre, speed, jumper, multiplier, smoker, barbedwire, nanoWood, nanoLeaves, nanoSaplings, nanoPlanks, nanoOre, confusion, falling, notfalling, sodium, mossystone, theDeathHead, listerJukebox, liquidNitrogen, blockNanoStair,
			nanoSlabSingle, nanoSlabDouble;

	// Blocks Initialization
	public static void initBlock()
	{
		portal = new BlockNanoPortal(Nanotech_mod.BlockPortalID).setBlockUnbreakable().setUnlocalizedName("portal").setTextureName("nanotech_mod:nanoportal");
		portalFrame = new BlockBase(Nanotech_mod.BlockPortalFrameID, Material.rock).setResistance(5F).setHardness(2F).setUnlocalizedName("portalframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:portalframe");
		nanoGrass = new BlockGrass(Nanotech_mod.BlockGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanograss").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		fakeOre = new BlockFakeOre(Nanotech_mod.BlockFakeOreID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("fakediamond").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		speed = new BlockSpeed(Nanotech_mod.BlockSpeedID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("speed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		jumper = new BlockJumper(Nanotech_mod.BlockJumperID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("jumper").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		multiplier = new BlockMultiplier(Nanotech_mod.BlockMultiplierID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("multiplier").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		smoker = new BlockSmoker(Nanotech_mod.BlockSmokerID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoker").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:smoker");
		barbedwire = new BlockBarbedWire(Nanotech_mod.BlockBarbedWireID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("barbedwire").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:barbedwire");
		nanoWood = new BlockNanoWood(Nanotech_mod.BlockNanoWoodID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanowood").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoLeaves = new BlockNanoLeaves(Nanotech_mod.BlockNanoLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanoleaves").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoSaplings = new BlockNanoSaplings(Nanotech_mod.BlockNanoSaplingsID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanosaplings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoPlanks = new BlockNanoPlanks(Nanotech_mod.BlockNanoPlanksID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanoplanks").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoOre = new BlockNanotechOre(Nanotech_mod.BlockNanoOreID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ore");
		confusion = new BlockConfusion(Nanotech_mod.BlockConfusionID).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("confusion").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:confusion");
		falling = new BlockFalling(Nanotech_mod.BlockFallingID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("falling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		notfalling = new BlockNotFalling(Nanotech_mod.BlockNotFallingID, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("notfalling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		sodium = new BlockSodium(Nanotech_mod.BlockSodiumID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sodium").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:sodium");
		mossystone = new BlockBase(Nanotech_mod.BlockMossyStoneID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mossystone").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:mossystone");
		theDeathHead = new BlockTheDeathHead(Nanotech_mod.BlockTheDeathHeadID).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("theDeathHead").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		listerJukebox = new BlockListerJukebox(Nanotech_mod.BlockListerJukeboxID, Material.iron).setUnlocalizedName("listerJukebox").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:listerjukebox");

		if(Nanotech_mod.liquidNitrogen.getBlockID() == -1)
		{
			liquidNitrogen = new BlockLiquidNitrogen(Nanotech_mod.BlockLiquidNitrogenID, Nanotech_mod.liquidNitrogen, Material.water).setUnlocalizedName("liquidNitrogen");
			GameRegistry.registerBlock(liquidNitrogen, "blockLiquidNitrogen");
			Nanotech_mod.liquidNitrogen.setBlockID(liquidNitrogen);
		}
		else
		{
			liquidNitrogen = Block.blocksList[Nanotech_mod.liquidNitrogen.getBlockID()];
		}
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(portal, "BlockPortal");
		GameRegistry.registerBlock(portalFrame, "BlockPortalframe");
		GameRegistry.registerBlock(nanoGrass, "BlockGrass");
		GameRegistry.registerBlock(fakeOre, ItemBlockFakeOre.class, "BlockFakeOre", "Nanotech_mod");
		GameRegistry.registerBlock(speed, ItemBlockSpeed.class, "BlockSpeed", "Nanotech_mod");
		GameRegistry.registerBlock(jumper, ItemBlockJumper.class, "BlockJumper", "Nanotech_mod");
		GameRegistry.registerBlock(multiplier, "BlockMultiplier");
		GameRegistry.registerBlock(smoker, "BlockSmoker");
		GameRegistry.registerBlock(barbedwire, "BlockBarbedwire");
		GameRegistry.registerBlock(nanoWood, "BlockNanowood");
		GameRegistry.registerBlock(nanoLeaves, "BlockNanoleaves");
		GameRegistry.registerBlock(nanoSaplings, "BlockNanosaplings");
		GameRegistry.registerBlock(nanoPlanks, "BlockNanoplanks");
		GameRegistry.registerBlock(nanoOre, ItemBlockNanotechOre.class, "BlockNanoOre", "Nanotech_mod");
		GameRegistry.registerBlock(confusion, "BlockConfusion");
		GameRegistry.registerBlock(falling, ItemBlockFalling.class, "BlockFalling", "Nanotech_mod");
		GameRegistry.registerBlock(notfalling, ItemBlockNotFalling.class, "Blocknotfalling", "Nanotech_mod");
		GameRegistry.registerBlock(sodium, "BlockSodium");
		GameRegistry.registerBlock(mossystone, "BlockMossyStone");
		GameRegistry.registerBlock(theDeathHead, "BlockTheDeathHead");
		GameRegistry.registerBlock(listerJukebox, "ListerJukebox");
	}
}