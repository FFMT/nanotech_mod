package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import net.minecraft.block.Block;

public class NTMBlocks
{
	public static Block machines;
	
	public static void initBlock()
	{
		machines = new BlockMachines().setHardness(1.0F).setResistance(15.0F).setBlockName("nanotech.machines").setCreativeTab(NanotechMod.blockTab).setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(machines, ItemBlockMachines.class, "NanotechMachines");
	}
}
