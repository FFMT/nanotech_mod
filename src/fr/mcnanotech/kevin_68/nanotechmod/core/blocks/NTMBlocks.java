package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class NTMBlocks
{
    public static Block machines, spotlight, lamp, modernFence, sunShade;

    public static void initBlock()
    {
        machines = new BlockMachines().setHardness(1.0F).setResistance(15.0F).setBlockName("nanotech.machines")/* .setCreativeTab(NanotechMod.blockTab) */.setStepSound(Block.soundTypeMetal);
        GameRegistry.registerBlock(machines, ItemBlockMachines.class, "NanotechMachines");

        spotlight = new BlockSpotLight().setHardness(1.0F).setResistance(10.0F).setBlockName("nanotech.spotlight").setCreativeTab(NanotechMod.blockTab).setStepSound(Block.soundTypeMetal).setBlockTextureName(NanotechMod.MODID + ":spotlight");
        GameRegistry.registerBlock(spotlight, ItemBlock.class, "NanotechSpotLight");

        lamp = new BlockLamp().setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("lamp").setCreativeTab(NanotechMod.blockTab);
        GameRegistry.registerBlock(lamp, ItemBlockLamp.class, "NanotechLamp");

        modernFence = new BlockModernFence().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("modernFence").setCreativeTab(NanotechMod.blockTab);
        GameRegistry.registerBlock(modernFence, ItemBlockModernFence.class, "NanotechModernFence");

        sunShade = new BlockSunShade().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setBlockName("sunShade").setCreativeTab(NanotechMod.blockTab);
        GameRegistry.registerBlock(sunShade, ItemBlockSunShade.class, "NanotchModSunShade");
    }
}