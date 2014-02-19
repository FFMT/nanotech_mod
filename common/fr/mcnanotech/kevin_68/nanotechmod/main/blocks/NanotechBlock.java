/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;

public class NanotechBlock
{
	/**
	 * Only use for NPE on loading
	 */
	public static Block nukeBuilding, machine, nanoStepSingle, nanoStepDouble;

	public static void initBlock()
	{
		GameRegistry.registerBlock(new BlockNanoPortal().setBlockUnbreakable().setBlockName("portal").setBlockTextureName(NanotechMod.MODID + ":nanoportal"), ItemBlock.class, "BlockPortal", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockBase(Material.rock).setHardness(2.0F).setResistance(10.0F).setBlockName("portalframe").setBlockTextureName(NanotechMod.MODID + ":portalframe").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockPortalframe", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockGrass().setHardness(0.6F).setResistance(1.0F).setBlockName("nanograss").setBlockTextureName(NanotechMod.MODID + ":grass").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeGrass), ItemBlock.class, "BlockGrass", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockFakeOre().setHardness(3.0F).setResistance(10.0F).setBlockName("fakeore").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlockFakeOre.class, "BlockFakeOre", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockSpeed().setHardness(1.5F).setResistance(10.0F).setBlockName("speed").setBlockTextureName(NanotechMod.MODID + ":").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlockSpeed.class, "BlockSpeed", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockJumper().setHardness(1.5F).setResistance(10.0F).setBlockName("jumper").setBlockTextureName(NanotechMod.MODID + ":jump").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlockJumper.class, "BlockJumper", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockMultiplier().setHardness(0.0F).setResistance(0.0F).setBlockName("multiplier").setBlockTextureName(NanotechMod.MODID + ":multiplier").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeMetal), ItemBlock.class, "BlockMultiplier", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockSmoker().setHardness(1.5F).setResistance(10.0F).setBlockName("smoker").setBlockTextureName(NanotechMod.MODID + ":smoker").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockSmoker", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockBarbedWire().setHardness(3.0F).setResistance(15.0F).setBlockName("barbedwire").setBlockTextureName(NanotechMod.MODID + ":barbedwire").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeMetal), ItemBlock.class, "BlockBarbedwire", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoWood().setHardness(1.0F).setResistance(10.0F).setBlockName("nanowood").setBlockTextureName(NanotechMod.MODID + ":log").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlock.class, "BlockNanowood", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoLeaves().setHardness(0.2F).setResistance(10.0F).setBlockName("nanoleaves").setBlockTextureName(NanotechMod.MODID + ":nanoleaves").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeGrass), ItemBlock.class, "BlockNanoleaves", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoSaplings().setHardness(0.0F).setResistance(0.0F).setBlockName("nanosaplings").setBlockTextureName(NanotechMod.MODID + ":sapling").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeGrass), ItemBlock.class, "BlockNanosaplings", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockBase(Material.wood).setHardness(2.0F).setResistance(10.0F).setBlockName("nanoplanks").setBlockTextureName(NanotechMod.MODID + ":nanoplank").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlock.class, "BlockNanoplanks", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanotechOre().setHardness(2.0F).setResistance(10.0F).setBlockName("ore").setBlockTextureName(NanotechMod.MODID + ":").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlockNanotechOre.class, "BlockNanoOre", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockConfusion().setHardness(5.0F).setResistance(15.0F).setBlockName("confusion").setBlockTextureName(NanotechMod.MODID + ":confusion").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockConfusion", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoFalling().setHardness(1.5F).setResistance(10.0F).setBlockName("falling").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlockFalling.class, "BlockFalling", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNotFalling().setHardness(0.5F).setResistance(5.0F).setBlockName("notfalling").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeGravel), ItemBlockNotFalling.class, "Blocknotfalling", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockSodium().setHardness(2.0F).setResistance(10.0F).setBlockName("sodium").setBlockTextureName(NanotechMod.MODID + ":sodium").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockSodium", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockBase(Material.rock).setHardness(1.0F).setResistance(10.0F).setBlockName("mossystone").setBlockTextureName(NanotechMod.MODID + ":mossycobble").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockMossyStone", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockTheDeathHead().setHardness(5.0F).setResistance(25.0F).setBlockName("theDeathHead").setBlockTextureName(NanotechMod.MODID + ":theDeathHead").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeStone), ItemBlock.class, "BlockTheDeathHead", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockListerJukebox().setHardness(2.0F).setResistance(10.0F).setBlockName("listerJukebox").setBlockTextureName(NanotechMod.MODID + ":listerjukebox").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlock.class, "ListerJukebox", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockFence(NanotechMod.MODID + ":nanoplank", Material.wood).setHardness(2.0F).setResistance(5.0F).setBlockName("nanoFence").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlock.class, "nanoFence", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoStairs(NanotechModList.nanoPlank, 0).setBlockName("nanoStairs").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlock.class, "nanoStairs", NanotechMod.MODID);
		GameRegistry.registerBlock(nanoStepSingle = new BlockNanoSteps(false).setHardness(2.0F).setResistance(5.0F).setBlockName("nanoSlabSingle").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeWood), ItemBlockNanoSteps.class, "BlockNanoSlabSingle", NanotechMod.MODID);
		GameRegistry.registerBlock(nanoStepDouble = new BlockNanoSteps(true).setHardness(2.0F).setResistance(5.0F).setBlockName("nanoSlabDouble").setStepSound(Block.soundTypeWood), ItemBlockNanoSteps.class, "BlockNanoSlabDouble", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockSat().setHardness(3.0F).setResistance(2.0F).setBlockName("satelite").setBlockTextureName(NanotechMod.MODID + ":").setStepSound(Block.soundTypeMetal), ItemBlockSatelite.class, "satelite", NanotechMod.MODID);
		GameRegistry.registerBlock(nukeBuilding = new BlockBuildingNuke().setHardness(2.0F).setResistance(15.0F).setBlockName("nukeBuildingBlock").setBlockTextureName(NanotechMod.MODID + ":nukebuilding").setStepSound(Block.soundTypeMetal), ItemBlockNukeBuildingBlock.class, "nukeBuildingBlock", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockNanoStairs(nukeBuilding, 0).setBlockName("nukeBuildingStairs").setStepSound(Block.soundTypeMetal), ItemBlock.class, "nukeBuildingStairs", NanotechMod.MODID);
		GameRegistry.registerBlock(new BlockPresent().setHardness(1.0F).setResistance(5.0F).setBlockName("present").setBlockTextureName(NanotechMod.MODID + ":present").setCreativeTab(NanotechMod.CreaB).setStepSound(Block.soundTypeCloth), ItemBlock.class, "present", NanotechMod.MODID);
		GameRegistry.registerBlock(machine = new BlockNanotechMachine(Material.wood).setHardness(1.0F).setResistance(15.0F).setBlockName("machine").setBlockTextureName(NanotechMod.MODID + ":"), ItemBlockMachine.class, "machine", NanotechMod.MODID);
		/*
		 * if(NanotechOther.liquidNitrogen.getBlock() == null) { GameRegistry.registerBlock(liquidNitro = new BlockLiquidNitrogen(NanotechOther.liquidNitrogen,
		 * Material.water).setBlockName("liquidNitrogen").setBlockTextureName(NanotechMod.MODID + ":nitrogen"), ItemBlock.class, "blockLiquidNitrogen", NanotechMod.MODID);
		 * NanotechOther.liquidNitrogen.setBlock(liquidNitro); } else { liquidNitro = NanotechOther.liquidNitrogen.getBlock(); }
		 */

		NanotechMod.nanoLogger.info("Blocks initialized");
	}
}