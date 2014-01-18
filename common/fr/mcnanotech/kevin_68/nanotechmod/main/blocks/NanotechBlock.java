package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;

public class NanotechBlock
{
	// Blocks statement
	public static Block portal, portalFrame, nanoGrass, fakeOre, speed, jumper, multiplier, smoker, barbedwire, nanoWood, nanoLeaves, nanoSaplings, nanoPlanks, nanoOre, confusion, falling, notfalling, sodium, mossystone, theDeathHead, listerJukebox, liquidNitrogen, nanoStairs, nanoSlabSingle, nanoSlabDouble, nanoFence, satelite, nukeBuildingBlock, nukeBuildingStairs, present, portableChest;

	// Blocks Initialization
	public static void initBlock()
	{
		portal = new BlockNanoPortal(NanotechMod.portalID).setBlockUnbreakable().setUnlocalizedName("portal").setTextureName("nanotechmod:nanoportal");
		portalFrame = new BlockBase(NanotechMod.portalFrameID, Material.rock).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("portalframe").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:portalframe");
		nanoGrass = new BlockGrass(NanotechMod.grassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanograss").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		fakeOre = new BlockFakeOre(NanotechMod.fakeOreID).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("fakediamond").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		speed = new BlockSpeed(NanotechMod.speedID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("speed").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		jumper = new BlockJumper(NanotechMod.jumperID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("jumper").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		multiplier = new BlockMultiplier(NanotechMod.multiplierID).setHardness(0.0F).setResistance(0.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("multiplier").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		smoker = new BlockSmoker(NanotechMod.smokerID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoker").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:smoker");
		barbedwire = new BlockBarbedWire(NanotechMod.barbedWireID).setHardness(3.0F).setResistance(15F).setUnlocalizedName("barbedwire").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:barbedwire");
		nanoWood = new BlockNanoWood(NanotechMod.nanoWoodID).setHardness(1.0F).setResistance(10.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanowood").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoLeaves = new BlockNanoLeaves(NanotechMod.nanoLeavesID).setHardness(0.2F).setResistance(10.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanoleaves").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoSaplings = new BlockNanoSaplings(NanotechMod.nanoSaplingsID).setHardness(0.0F).setResistance(10.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanosaplings").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoPlanks = new BlockNanoPlanks(NanotechMod.nanoPlanksID).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanoplanks").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoOre = new BlockNanotechOre(NanotechMod.nanoOreID).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ore");
		confusion = new BlockConfusion(NanotechMod.confusionID).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("confusion").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:confusion");
		falling = new BlockFalling(NanotechMod.fallingID, Material.rock).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("falling").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		notfalling = new BlockNotFalling(NanotechMod.notFallingID, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("notfalling").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		sodium = new BlockSodium(NanotechMod.sodiumID, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sodium").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:sodium");
		mossystone = new BlockBase(NanotechMod.mossyStoneID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mossystone").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:mossystone");
		theDeathHead = new BlockTheDeathHead(NanotechMod.theDeathHeadID).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("theDeathHead").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		listerJukebox = new BlockListerJukebox(NanotechMod.listerJukeboxID, Material.wood).setHardness(2.0F).setResistance(1.0F).setUnlocalizedName("listerJukebox").setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:listerjukebox");
		nanoFence = new BlockFence(NanotechMod.nanoFenceID, "nanotechmod:nanoplank", Material.wood).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("nanoFence").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoStairs = new BlockNanoStairs(NanotechMod.nanoStairsID, nanoPlanks, 0).setUnlocalizedName("nanoStairs").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoSlabSingle = new BlockNanoSteps(NanotechMod.nanoSlabSingleID, false).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("nanoSlabSingle").setCreativeTab(NanotechMod.CREATIVE_TAB_B);
		nanoSlabDouble = new BlockNanoSteps(NanotechMod.nanoSlabDoubleID, true).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("nanoSlabDouble");
		satelite = new BlockSat(NanotechMod.satID).setUnlocalizedName("satelite");
		nukeBuildingBlock = new BlockBuildingNuke(NanotechMod.nukeStairsID).setUnlocalizedName("nukeBuildingBlock").setTextureName("nanotechmod:nukebuilding");
		nukeBuildingStairs = new BlockNanoStairs(NanotechMod.nukeID, nukeBuildingBlock, 0).setUnlocalizedName("nukeBuildingStairs").setCreativeTab(null);
		present = new BlockPresent(NanotechMod.presentID).setUnlocalizedName("present").setHardness(1.0F).setResistance(2.5F).setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:present");
		portableChest = new BlockPortableChest(NanotechMod.portableChestID, Material.wood).setUnlocalizedName("portableChest").setHardness(1.0F).setResistance(15.0F).setCreativeTab(NanotechMod.CREATIVE_TAB_B).setTextureName("nanotechmod:portablechest");
		
		if(NanotechOther.liquidNitrogen.getBlockID() == -1)
		{
			liquidNitrogen = new BlockLiquidNitrogen(NanotechMod.liquidNitrogenID, NanotechOther.liquidNitrogen, Material.water).setUnlocalizedName("liquidNitrogen");
			GameRegistry.registerBlock(liquidNitrogen, "blockLiquidNitrogen");
			NanotechOther.liquidNitrogen.setBlockID(liquidNitrogen);
		}
		else
		{
			liquidNitrogen = Block.blocksList[NanotechOther.liquidNitrogen.getBlockID()];
		}
	}

	// Blocks registry
	public static void blockRegistry()
	{
		GameRegistry.registerBlock(portal, "BlockPortal");
		GameRegistry.registerBlock(portalFrame, "BlockPortalframe");
		GameRegistry.registerBlock(nanoGrass, "BlockGrass");
		GameRegistry.registerBlock(fakeOre, ItemBlockFakeOre.class, "BlockFakeOre", "NanotechMod");
		GameRegistry.registerBlock(speed, ItemBlockSpeed.class, "BlockSpeed", "NanotechMod");
		GameRegistry.registerBlock(jumper, ItemBlockJumper.class, "BlockJumper", "NanotechMod");
		GameRegistry.registerBlock(multiplier, "BlockMultiplier");
		GameRegistry.registerBlock(smoker, "BlockSmoker");
		GameRegistry.registerBlock(barbedwire, "BlockBarbedwire");
		GameRegistry.registerBlock(nanoWood, "BlockNanowood");
		GameRegistry.registerBlock(nanoLeaves, "BlockNanoleaves");
		GameRegistry.registerBlock(nanoSaplings, "BlockNanosaplings");
		GameRegistry.registerBlock(nanoPlanks, "BlockNanoplanks");
		GameRegistry.registerBlock(nanoOre, ItemBlockNanotechOre.class, "BlockNanoOre", "NanotechMod");
		GameRegistry.registerBlock(confusion, "BlockConfusion");
		GameRegistry.registerBlock(falling, ItemBlockFalling.class, "BlockFalling", "NanotechMod");
		GameRegistry.registerBlock(notfalling, ItemBlockNotFalling.class, "Blocknotfalling", "NanotechMod");
		GameRegistry.registerBlock(sodium, "BlockSodium");
		GameRegistry.registerBlock(mossystone, "BlockMossyStone");
		GameRegistry.registerBlock(theDeathHead, "BlockTheDeathHead");
		GameRegistry.registerBlock(listerJukebox, "ListerJukebox");
		GameRegistry.registerBlock(nanoFence, "nanoFence");
		GameRegistry.registerBlock(nanoStairs, "nanoStairs");
		GameRegistry.registerBlock(nanoSlabSingle, ItemBlockNanoSteps.class, "BlockNanoSlabSingle", "NanotechMod");
		GameRegistry.registerBlock(nanoSlabDouble, ItemBlockNanoSteps.class, "BlockNanoSlabDouble", "NanotechMod");
		GameRegistry.registerBlock(satelite, ItemBlockSatelite.class, "satelite", "NanotechMod");
		GameRegistry.registerBlock(nukeBuildingBlock, ItemBlockNukeBuildingBlock.class, "nukeBuildingBlock", "NanotechMod");
		GameRegistry.registerBlock(nukeBuildingStairs, "nukeBuildingStairs");
		GameRegistry.registerBlock(present, "present");
		GameRegistry.registerBlock(portableChest, "portableChest");
	}
}