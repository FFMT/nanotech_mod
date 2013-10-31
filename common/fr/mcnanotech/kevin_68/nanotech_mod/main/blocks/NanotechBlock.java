package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechBlock
{
	// Blocks statement
	public static Block portal, portalFrame, nanoGrass, fakeOre, speed, jumper, multiplier, smoker, barbedwire, nanoWood, nanoLeaves, nanoSaplings, nanoPlanks, nanoOre, confusion, falling, notfalling, sodium, mossystone, theDeathHead, listerJukebox, liquidNitrogen, nanoStairs, nanoSlabSingle, nanoSlabDouble, nanoFence, nuke, nukeBuildingBlock, nukeBuildingStairs;

	// Blocks Initialization
	public static void initBlock()
	{
		portal = new BlockNanoPortal(Nanotech_mod.portalID).setBlockUnbreakable().setUnlocalizedName("portal").setTextureName("nanotech_mod:nanoportal");
		portalFrame = new BlockBase(Nanotech_mod.portalFrameID, Material.rock).setResistance(5F).setHardness(2F).setUnlocalizedName("portalframe").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:portalframe");
		nanoGrass = new BlockGrass(Nanotech_mod.grassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanograss").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		fakeOre = new BlockFakeOre(Nanotech_mod.fakeOreID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("fakediamond").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		speed = new BlockSpeed(Nanotech_mod.speedID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("speed").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		jumper = new BlockJumper(Nanotech_mod.jumperID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("jumper").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		multiplier = new BlockMultiplier(Nanotech_mod.multiplierID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("multiplier").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		smoker = new BlockSmoker(Nanotech_mod.smokerID).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("smoker").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:smoker");
		barbedwire = new BlockBarbedWire(Nanotech_mod.barbedWireID).setHardness(3.0F).setResistance(5F).setUnlocalizedName("barbedwire").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:barbedwire");
		nanoWood = new BlockNanoWood(Nanotech_mod.nanoWoodID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanowood").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoLeaves = new BlockNanoLeaves(Nanotech_mod.nanoLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanoleaves").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoSaplings = new BlockNanoSaplings(Nanotech_mod.nanoSaplingsID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nanosaplings").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoPlanks = new BlockNanoPlanks(Nanotech_mod.nanoPlanksID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("nanoplanks").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoOre = new BlockNanotechOre(Nanotech_mod.nanoOreID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ore");
		confusion = new BlockConfusion(Nanotech_mod.confusionID).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("confusion").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:confusion");
		falling = new BlockFalling(Nanotech_mod.fallingID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("falling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		notfalling = new BlockNotFalling(Nanotech_mod.notFallingID, Material.sand).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("notfalling").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		sodium = new BlockSodium(Nanotech_mod.sodiumID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("sodium").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:sodium");
		mossystone = new BlockBase(Nanotech_mod.mossyStoneID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mossystone").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:mossystone");
		theDeathHead = new BlockTheDeathHead(Nanotech_mod.theDeathHeadID).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("theDeathHead").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		listerJukebox = new BlockListerJukebox(Nanotech_mod.listerJukeboxID, Material.iron).setUnlocalizedName("listerJukebox").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B).setTextureName("nanotech_mod:listerjukebox");
		nanoFence = new BlockFence(Nanotech_mod.nanoFenceID, "nanotech_mod:nanoplank", Material.wood).setUnlocalizedName("nanoFence").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoStairs = new BlockNanoStairs(Nanotech_mod.nanoStairsID, nanoPlanks, 0).setUnlocalizedName("nanoStairs").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoSlabSingle = new BlockNanoSteps(Nanotech_mod.nanoSlabSingleID, false).setUnlocalizedName("nanoSlabSingle").setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		nanoSlabDouble = new BlockNanoSteps(Nanotech_mod.nanoSlabDoubleID, true).setUnlocalizedName("nanoSlabDouble");
		nuke = new BlockNuke(Nanotech_mod.nukeID).setUnlocalizedName("nuke").setTextureName("nanotech_mod:nukebuilding");
		nukeBuildingBlock = new BlockBuildingNuke(1026).setUnlocalizedName("nukeBuildingBlock").setTextureName("nanotech_mod:nukebuilding");
		nukeBuildingStairs = new BlockNanoStairs(1027, nukeBuildingBlock, 0).setUnlocalizedName("nukeBuildingStairs");
		
		if(Nanotech_mod.liquidNitrogen.getBlockID() == -1)
		{
			liquidNitrogen = new BlockLiquidNitrogen(Nanotech_mod.liquidNitrogenID, Nanotech_mod.liquidNitrogen, Material.water).setUnlocalizedName("liquidNitrogen");
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
		GameRegistry.registerBlock(nanoFence, "nanoFence");
		GameRegistry.registerBlock(nanoStairs, "nanoStairs");
		GameRegistry.registerBlock(nanoSlabSingle, ItemBlockNanoSteps.class, "BlockNanoSlabSingle", "Nanotech_mod");
		GameRegistry.registerBlock(nanoSlabDouble, ItemBlockNanoSteps.class, "BlockNanoSlabDouble", "Nanotech_mod");
		GameRegistry.registerBlock(nuke, "nuke");
		GameRegistry.registerBlock(nukeBuildingBlock, ItemBlockNukeBuildingBlock.class, "nukeBuildingBlock", "Nanotech_mod");
		GameRegistry.registerBlock(nukeBuildingStairs, "nukeBuildingStairs");
	}
}