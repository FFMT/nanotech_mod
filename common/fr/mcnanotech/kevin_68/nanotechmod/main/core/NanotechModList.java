/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class NanotechModList
{
	public static final Block portal = GameRegistry.findBlock(NanotechMod.MODID, "BlockPortal");
	public static final Block portalFrame = GameRegistry.findBlock(NanotechMod.MODID, "BlockPortalframe");
	public static final Block nanoGrass = GameRegistry.findBlock(NanotechMod.MODID, "BlockGrass");
	public static final Block fakeOre = GameRegistry.findBlock(NanotechMod.MODID, "BlockFakeOre");
	public static final Block speed = GameRegistry.findBlock(NanotechMod.MODID, "BlockSpeed");
	public static final Block jump = GameRegistry.findBlock(NanotechMod.MODID, "BlockJumper");
	public static final Block multiplier = GameRegistry.findBlock(NanotechMod.MODID, "BlockMultiplier");
	public static final Block smoker = GameRegistry.findBlock(NanotechMod.MODID, "BlockSmoker");
	public static final Block barbedWire = GameRegistry.findBlock(NanotechMod.MODID, "BlockBarbedwire");
	public static final Block nanoWood = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanowood");
	public static final Block nanoLeaves = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanoleaves");
	public static final Block nanoSaplings = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanosaplings");
	public static final Block nanoPlank = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanoplanks");
	public static final Block ore = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanoOre");
	public static final Block confusion = GameRegistry.findBlock(NanotechMod.MODID, "BlockConfusion");
	public static final Block falling = GameRegistry.findBlock(NanotechMod.MODID, "BlockFalling");
	public static final Block notFalling = GameRegistry.findBlock(NanotechMod.MODID, "Blocknotfalling");
	public static final Block sodium = GameRegistry.findBlock(NanotechMod.MODID, "BlockSodium");
	public static final Block mossyStone = GameRegistry.findBlock(NanotechMod.MODID, "BlockMossyStone");
	public static final Block theDeathHead = GameRegistry.findBlock(NanotechMod.MODID, "BlockTheDeathHead");
	public static final Block listerJukeBox = GameRegistry.findBlock(NanotechMod.MODID, "ListerJukebox");
	public static final Block nanoFence = GameRegistry.findBlock(NanotechMod.MODID, "nanoFence");
	public static final Block nanoStairs = GameRegistry.findBlock(NanotechMod.MODID, "nanoStairs");
	public static final Block nanoSlabSingle = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanoSlabSingle");
	public static final Block nanoSlabDouble = GameRegistry.findBlock(NanotechMod.MODID, "BlockNanoSlabDouble");
	public static final Block satelite = GameRegistry.findBlock(NanotechMod.MODID, "satelite");
	public static final Block nukeBuilding = GameRegistry.findBlock(NanotechMod.MODID, "nukeBuildingBlock");
	public static final Block nukeBuildingStairs = GameRegistry.findBlock(NanotechMod.MODID, "nukeBuildingStairs");
	public static final Block present = GameRegistry.findBlock(NanotechMod.MODID, "present");
	public static final Block machine = GameRegistry.findBlock(NanotechMod.MODID, "machine");
	public static final Block liquidNitrogen = GameRegistry.findBlock(NanotechMod.MODID, "blockLiquidNitrogen");

	public static final Item itemBase = GameRegistry.findItem(NanotechMod.MODID, "nanotechbase");
	public static final Item superBottleOfXp = GameRegistry.findItem(NanotechMod.MODID, "superbottleofxp");
	public static final Item diamondBow = GameRegistry.findItem(NanotechMod.MODID, "diamondbow");
	public static final Item emeraldBow = GameRegistry.findItem(NanotechMod.MODID, "emeraldbow");
	public static final Item nanomiteBow = GameRegistry.findItem(NanotechMod.MODID, "nanomitebow");
	public static final Item nanomiteHelmet = GameRegistry.findItem(NanotechMod.MODID, "nanomiteHelmet");
	public static final Item nanomiteChestPlate = GameRegistry.findItem(NanotechMod.MODID, "nanomiteChestPlate");
	public static final Item nanomiteLeggings = GameRegistry.findItem(NanotechMod.MODID, "nanomiteLegs");
	public static final Item nanomiteBoots = GameRegistry.findItem(NanotechMod.MODID, "nanomiteBoots");
	public static final Item nanomiteSword = GameRegistry.findItem(NanotechMod.MODID, "nanomiteSword");
	public static final Item nanomiteShovel = GameRegistry.findItem(NanotechMod.MODID, "nanomiteShovel");
	public static final Item nanomitePickaxe = GameRegistry.findItem(NanotechMod.MODID, "nanomitePickaxe");
	public static final Item nanomiteAxe = GameRegistry.findItem(NanotechMod.MODID, "nanomiteAxe");
	public static final Item nanomiteHoe = GameRegistry.findItem(NanotechMod.MODID, "nanomiteHoe");
	public static final Item mysteriousHelmet = GameRegistry.findItem(NanotechMod.MODID, "mysteriousHelmet");
	public static final Item mysteriousChestPlate = GameRegistry.findItem(NanotechMod.MODID, "mysteriousChestPlate");
	public static final Item mysteriousLeggings = GameRegistry.findItem(NanotechMod.MODID, "mysteriousLeggings");
	public static final Item mysteriousBoots = GameRegistry.findItem(NanotechMod.MODID, "mysteriousBoots");
	public static final Item nanoDisc = GameRegistry.findItem(NanotechMod.MODID, "nanoDisc");
	public static final Item edibleFlesh = GameRegistry.findItem(NanotechMod.MODID, "edibleFlesh");
	public static final Item rottenChunk = GameRegistry.findItem(NanotechMod.MODID, "rottenChunk");
	public static final Item scythe = GameRegistry.findItem(NanotechMod.MODID, "scythe");
	public static final Item crazyGlasses = GameRegistry.findItem(NanotechMod.MODID, "crazyGlasses");
	public static final Item debug = GameRegistry.findItem(NanotechMod.MODID, "debug");
	public static final Item alters = GameRegistry.findItem(NanotechMod.MODID, "alters");
	public static final Item nitrogenBucket = GameRegistry.findItem(NanotechMod.MODID, "nitrogenBucket");
	public static final Item reinforcedFishingRod = GameRegistry.findItem(NanotechMod.MODID, "reinforcedFishingRod");
	public static final Item crazyGlassesGun = GameRegistry.findItem(NanotechMod.MODID, "crazyGlassesGun");
	public static final Item lightSaber = GameRegistry.findItem(NanotechMod.MODID, "lightSaber");

	public static final Fluid fluidNitrogen = FluidRegistry.getFluid("liquidnitrogen");

}