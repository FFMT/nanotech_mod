package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class NTMBlocks
{
	public static Block machines, spotlight;
	
	public static void initBlock()
	{
		machines = new BlockMachines().setHardness(1.0F).setResistance(15.0F).setBlockName("nanotech.machines").setCreativeTab(NanotechMod.blockTab).setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(machines, ItemBlockMachines.class, "NanotechMachines");

		spotlight = new BlockSpotLight().setHardness(1.0F).setResistance(10.0F).setBlockName("nanotech.spotlight").setCreativeTab(NanotechMod.blockTab).setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(spotlight, ItemBlock.class, "NanotechSpotLight");
	}
}
